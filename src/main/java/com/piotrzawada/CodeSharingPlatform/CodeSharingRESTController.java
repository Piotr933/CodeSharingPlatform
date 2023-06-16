package com.piotrzawada.CodeSharingPlatform;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class CodeSharingRESTController {

    private final CodeService codeService;

    public CodeSharingRESTController(@Autowired CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/api/code/{id}")
    public ResponseEntity<?> currentJSON(@PathVariable String id) throws JsonProcessingException {
        Code currentCode = codeService.getCode(id);

        if (currentCode == null) {
            return new ResponseEntity<>("(Not Found)", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(currentCode, HttpStatus.OK);
    }

    @GetMapping("/api/code/latest")
    @ResponseBody
    public List<Code> latestCodesJSON() throws JsonProcessingException {
        return codeService.getLatest();
    }

    @PostMapping("/api/code/new")
    public HashMap<String, String> newCodeJSON(@RequestBody Code newCode) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String formatted = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss").format(localDateTime);
        UUID uuid = UUID.randomUUID();
        newCode.setId(String.valueOf(uuid));
        newCode.setDate(formatted);
        newCode.setLocalDateTime(localDateTime);

        codeService.addCode(newCode);

        HashMap<String, String> r = new HashMap<>();
        r.put("id", String.valueOf(newCode.getId()));
        return r;
    }
}