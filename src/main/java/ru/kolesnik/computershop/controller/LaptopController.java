package ru.kolesnik.computershop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kolesnik.computershop.payload.LaptopDto;
import ru.kolesnik.computershop.repository.entity.Laptop;
import ru.kolesnik.computershop.service.LaptopService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("laptop")
public class LaptopController {

    private final LaptopService laptopService;

    @PostMapping
    public Laptop createLaptop(@Valid @RequestBody LaptopDto laptopDto) {
        return laptopService.createLaptop(laptopDto);
    }

    @PutMapping("{id}")
    public Laptop updateLaptopById(@Valid @RequestBody LaptopDto laptopDto, @PathVariable Long id) {
        return laptopService.updateLaptopById(laptopDto, id);
    }

    @DeleteMapping("{id}")
    public Laptop deleteLaptopById(@PathVariable Long id) {
        return laptopService.deleteLaptopById(id);
    }

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("{id}")
    public Laptop getLaptopById(@PathVariable Long id) {
        return laptopService.getLaptopById(id);
    }

}
