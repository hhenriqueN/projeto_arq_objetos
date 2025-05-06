package org.example.split;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/splits")
public class SplitController {

    @Autowired
    private SplitService splitService;

    @PostMapping
    public void cadastrarSplit(@RequestBody SplitRequest splitRequest) {
        splitService.salvarSplit(splitRequest);
    }

    @GetMapping
    public List<Split> listarSplits() {
        return splitService.listarSplits();
    }
}
