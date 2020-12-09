package com.ali.emailextractor.controller;

import com.ali.emailextractor.model.Extractor;
import com.ali.emailextractor.service.ExtractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/email")
public class ExtractController {

    @Autowired
    private ExtractorService extractorService;

    @GetMapping("/extract")
    public ResponseEntity<String> getOrderById(@RequestParam("body") String mailBody) {
        String extractor = extractorService.emailExtractor(mailBody);
        return ResponseEntity.ok().body(extractor);
    }

}
