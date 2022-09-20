package ru.kolesnik.computershop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolesnik.computershop.exception.ProductAlreadyExistsException;
import ru.kolesnik.computershop.exception.ProductNotFoundException;
import ru.kolesnik.computershop.payload.HddDto;
import ru.kolesnik.computershop.repository.HddRepository;
import ru.kolesnik.computershop.repository.entity.Hdd;
import ru.kolesnik.computershop.repository.entity.Product;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HddService {

    private final HddRepository hddRepository;

    public Hdd createHdd(HddDto hddDto) {
        Optional<Product> sameProductOptional = hddRepository
                .findBySeriesNumberAndManufacturerName(hddDto.getSeriesNumber(), hddDto.getManufacturerName());
        if (sameProductOptional.isPresent()) {
            throw new ProductAlreadyExistsException();
        } else {
            Hdd hdd = new Hdd(hddDto.getSeriesNumber(), hddDto.getManufacturerName(),
                    hddDto.getPrice(), hddDto.getNumberInStock(), hddDto.getCapacityGb());
            return hddRepository.save(hdd);
        }
    }

    public Hdd updateHddById(HddDto hddDto, Long id) {
        Hdd hdd = hddRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        Optional<Product> sameProductOptional = hddRepository
                .findBySeriesNumberAndManufacturerName(hddDto.getSeriesNumber(), hddDto.getManufacturerName());
        if (sameProductOptional.isPresent() && !sameProductOptional.get().getId().equals(id)) {
            throw new ProductAlreadyExistsException();
        } else {
            hdd.setSeriesNumber(hddDto.getSeriesNumber());
            hdd.setManufacturerName(hddDto.getManufacturerName());
            hdd.setPrice(hddDto.getPrice());
            hdd.setNumberInStock(hddDto.getNumberInStock());
            hdd.setCapacityGb(hddDto.getCapacityGb());
            return hddRepository.save(hdd);
        }
    }

    public Hdd deleteHddById(Long id) {
        Hdd hdd = hddRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        hddRepository.delete(hdd);
        return hdd;
    }

    public List<Hdd> getAllHdds() {
        return hddRepository.findAll();
    }

    public Hdd getHddById(Long id) {
        return hddRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

}
