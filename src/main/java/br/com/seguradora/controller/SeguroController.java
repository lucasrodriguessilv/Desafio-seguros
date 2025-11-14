package br.com.seguradora.controller;

import br.com.seguradora.model.entities.SeguroAutomovel;
import br.com.seguradora.service.SeguroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seguros")
public class SeguroController {

    private final SeguroService service;

    public SeguroController(SeguroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SeguroAutomovel> criar(@RequestBody SeguroAutomovel seguro) {
        SeguroAutomovel salvo = service.salvar(seguro);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguroAutomovel> getById(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
