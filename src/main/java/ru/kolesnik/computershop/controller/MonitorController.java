package ru.kolesnik.computershop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kolesnik.computershop.payload.MonitorDto;
import ru.kolesnik.computershop.repository.entity.Monitor;
import ru.kolesnik.computershop.service.MonitorService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("monitor")
public class MonitorController {

    private final MonitorService monitorService;

    @PostMapping
    public Monitor createMonitor(@Valid @RequestBody MonitorDto monitorDto) {
        return monitorService.createMonitor(monitorDto);
    }

    @PutMapping("{id}")
    public Monitor updateMonitorById(@Valid @RequestBody MonitorDto monitorDto, @PathVariable Long id) {
        return monitorService.updateMonitorById(monitorDto, id);
    }

    @DeleteMapping("{id}")
    public Monitor deleteMonitorById(@PathVariable Long id) {
        return monitorService.deleteMonitorById(id);
    }

    @GetMapping
    public List<Monitor> getAllMonitors() {
        return monitorService.getAllMonitors();
    }

    @GetMapping("{id}")
    public Monitor getMonitorById(@PathVariable Long id) {
        return monitorService.getMonitorById(id);
    }

}
