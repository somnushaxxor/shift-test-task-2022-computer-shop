package ru.kolesnik.computershop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kolesnik.computershop.payload.HddDto;
import ru.kolesnik.computershop.repository.entity.Hdd;
import ru.kolesnik.computershop.service.HddService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("hdd")
public class HddController {

    private final HddService hddService;

    @PostMapping
    public Hdd createHdd(@Valid @RequestBody HddDto hddDto) {
        return hddService.createHdd(hddDto);
    }

    @PutMapping("{id}")
    public Hdd updateHddById(@Valid @RequestBody HddDto hddDto, @PathVariable Long id) {
        return hddService.updateHddById(hddDto, id);
    }

    @DeleteMapping("{id}")
    public Hdd deleteHddById(@PathVariable Long id) {
        return hddService.deleteHddById(id);
    }

    @GetMapping
    public List<Hdd> getAllHdds() {
        return hddService.getAllHdds();
    }

    @GetMapping("{id}")
    public Hdd getHddById(@PathVariable Long id) {
        return hddService.getHddById(id);
    }

}
