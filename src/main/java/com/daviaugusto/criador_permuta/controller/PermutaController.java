package com.daviaugusto.criador_permuta.controller;

import com.daviaugusto.criador_permuta.Infrastructure.entities.Dados;
import com.daviaugusto.criador_permuta.service.CriadorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pdf")
@CrossOrigin("*")
public class PermutaController {


    @Autowired
    CriadorService criadorService;

    @PostMapping("/gerar")
    public ResponseEntity<byte[]> gerarPdf(@RequestBody Dados dados){
        byte[] pdf = criadorService.criarPermuta(dados);

                return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename = arquivo.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }


}
