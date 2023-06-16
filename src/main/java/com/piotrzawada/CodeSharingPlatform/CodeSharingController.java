package com.piotrzawada.CodeSharingPlatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class CodeSharingController {

    private final CodeService codeService;

    public CodeSharingController(@Autowired CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{id}")
    public String code(Model model, @PathVariable String id) {
        Code code = codeService.getCode(id);


        if (code == null) {
            return "";
        }

        if (code.restrictedByTime && code.restrictedByViews) {
            model.addAttribute("code",code);
            return "rcode";
        }

        if (code.restrictedByTime) {
            model.addAttribute("code", code);
            return "timer";
        }

        if (code.restrictedByViews) {
            model.addAttribute("code", code);
            return "viewsr";
        }

        model.addAttribute("code", code);
        return "code";
    }
    @GetMapping("/code/latest")
    public String latestCodes(Model model) {
        List<Code> codeList = codeService.getLatest();
        model.addAttribute("codes", codeList);
        return "codes";
    }

    @GetMapping("code/new")
    public String newCode(Model model) {
        return "newCode";
    }
}