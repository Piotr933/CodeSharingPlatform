package com.piotrzawada.CodeSharingPlatform;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class CodeService {

    private final CodeRepo codeRepo;
    @Transactional
    public void addCode(Code code) {
        code.setRestrictedByTime(code.getTime() != 0);
        code.setRestrictedByViews(code.getViews() !=0);
        codeRepo.save(code);
    }

    @Transactional
    public void deleteCode (String id) {
        codeRepo.deleteById(id);
    }

    public Code getCode(String id) {
        Code code =  codeRepo.findById(id).orElse(null);

        if (code != null) {
            if (code.isRestrictedByViews()) {
                code.setViews(code.views - 1);

                if (code.views == 0) {
                    codeRepo.delete(code);

                } else {
                    codeRepo.save(code);
                }
            }

            if (code.isRestrictedByTime()) {
                long compareTimes = ChronoUnit.SECONDS.between(LocalDateTime.now(),  //compare current time with allowed time
                        code.localDateTime.plusSeconds(code.time));

                if (compareTimes > 0) {
                    code.setTime(compareTimes);
                    } else {

                    codeRepo.delete(code);
                    return null;
                    }
                }
            }

        return code;
    }

    public List<Code> getLatest() {
        return codeRepo.findCode();
    }
}
