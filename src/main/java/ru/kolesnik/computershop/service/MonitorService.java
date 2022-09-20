package ru.kolesnik.computershop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolesnik.computershop.exception.ProductAlreadyExistsException;
import ru.kolesnik.computershop.exception.ProductNotFoundException;
import ru.kolesnik.computershop.payload.MonitorDto;
import ru.kolesnik.computershop.repository.MonitorRepository;
import ru.kolesnik.computershop.repository.entity.Monitor;
import ru.kolesnik.computershop.repository.entity.Product;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public Monitor createMonitor(MonitorDto monitorDto) {
        Optional<Product> sameProductOptional = monitorRepository.
                findBySeriesNumberAndManufacturerName(monitorDto.getSeriesNumber(), monitorDto.getManufacturerName());
        if (sameProductOptional.isPresent()) {
            throw new ProductAlreadyExistsException();
        } else {
            Monitor monitor = new Monitor(monitorDto.getSeriesNumber(), monitorDto.getManufacturerName(),
                    monitorDto.getPrice(), monitorDto.getNumberInStock(), monitorDto.getDiagonal());
            return monitorRepository.save(monitor);
        }
    }

    public Monitor updateMonitorById(MonitorDto monitorDto, Long id) {
        Monitor monitor = monitorRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        Optional<Product> sameProductOptional = monitorRepository.
                findBySeriesNumberAndManufacturerName(monitorDto.getSeriesNumber(), monitorDto.getManufacturerName());
        if (sameProductOptional.isPresent() && !sameProductOptional.get().getId().equals(id)) {
            throw new ProductAlreadyExistsException();
        } else {
            monitor.setSeriesNumber(monitorDto.getSeriesNumber());
            monitor.setManufacturerName(monitorDto.getManufacturerName());
            monitor.setPrice(monitorDto.getPrice());
            monitor.setNumberInStock(monitorDto.getNumberInStock());
            monitor.setDiagonal(monitorDto.getDiagonal());
            return monitorRepository.save(monitor);
        }
    }

    public Monitor deleteMonitorById(Long id) {
        Monitor monitor = monitorRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        monitorRepository.delete(monitor);
        return monitor;
    }

    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    public Monitor getMonitorById(Long id) {
        return monitorRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

}
