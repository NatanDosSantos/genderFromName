package com.example.demo.resource;

import com.example.demo.service.MaleOrFemaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;

@Resource
@RestController
@RequestMapping("/benino-ou-benina")
@AllArgsConstructor
public class MaleOrFemaleResource {

    private final MaleOrFemaleService maleOrFemaleService;



    @GetMapping("/{nome}")
    public DeferredResult<ResponseEntity<String>> getGender(@PathVariable String nome) throws Exception {
        DeferredResult<ResponseEntity<String>> df = new DeferredResult<ResponseEntity<String>>();
        df.setResult(ResponseEntity.ok("O Nome "+nome+" é "+maleOrFemaleService.getGender(nome)));
        return df;
    }
    @GetMapping
    public DeferredResult<ResponseEntity<String>> getGender() throws Exception {
        DeferredResult<ResponseEntity<String>> df = new DeferredResult<ResponseEntity<String>>();
        df.setResult(ResponseEntity.ok("ESTOU FUNCIONANDO"));
        return df;
    }

}
