package ru.kolesnik.computershop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kolesnik.computershop.payload.PcDto;
import ru.kolesnik.computershop.repository.entity.Pc;
import ru.kolesnik.computershop.service.PcService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("pc")
public class PcController {

    private final PcService pcService;

    @PostMapping
    public Pc createPc(@Valid @RequestBody PcDto pcDto) {
        return pcService.createPc(pcDto);
    }

    @PutMapping("{id}")
    public Pc updatePcById(@Valid @RequestBody PcDto pcDto, @PathVariable Long id) {
        return pcService.updatePcById(pcDto, id);
    }

    @DeleteMapping("{id}")
    public Pc deletePcById(@PathVariable Long id) {
        return pcService.deletePcById(id);
    }

    @GetMapping
    public List<Pc> getAllPcs() {
        return pcService.getAllPcs();
    }

    @GetMapping("{id}")
    public Pc getPcById(@PathVariable Long id) {
        return pcService.getPcById(id);
    }

}
