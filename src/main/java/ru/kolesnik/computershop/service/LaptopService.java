package ru.kolesnik.computershop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolesnik.computershop.exception.ProductAlreadyExistsException;
import ru.kolesnik.computershop.exception.ProductNotFoundException;
import ru.kolesnik.computershop.exception.UnknownLaptopSizeException;
import ru.kolesnik.computershop.payload.LaptopDto;
import ru.kolesnik.computershop.repository.LaptopRepository;
import ru.kolesnik.computershop.repository.LaptopSizeRepository;
import ru.kolesnik.computershop.repository.entity.Laptop;
import ru.kolesnik.computershop.repository.entity.LaptopSize;
import ru.kolesnik.computershop.repository.entity.Product;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;
    private final LaptopSizeRepository laptopSizeRepository;

    public Laptop createLaptop(LaptopDto laptopDto) {
        Optional<Product> sameProductOptional = laptopRepository.
                findBySeriesNumberAndManufacturerName(laptopDto.getSeriesNumber(), laptopDto.getManufacturerName());
        LaptopSize size = laptopSizeRepository.findBySizeValue(laptopDto.getSizeValue())
                .orElseThrow(UnknownLaptopSizeException::new);
        if (sameProductOptional.isPresent()) {
            throw new ProductAlreadyExistsException();
        } else {
            Laptop laptop = new Laptop(laptopDto.getSeriesNumber(), laptopDto.getManufacturerName(),
                    laptopDto.getPrice(), laptopDto.getNumberInStock(), size);
            return laptopRepository.save(laptop);
        }
    }

    public Laptop updateLaptopById(LaptopDto laptopDto, Long id) {
        Laptop laptop = laptopRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        Optional<Product> sameProductOptional = laptopRepository.
                findBySeriesNumberAndManufacturerName(laptopDto.getSeriesNumber(), laptopDto.getManufacturerName());
        LaptopSize size = laptopSizeRepository.findBySizeValue(laptopDto.getSizeValue())
                .orElseThrow(UnknownLaptopSizeException::new);
        if (sameProductOptional.isPresent() && !sameProductOptional.get().getId().equals(id)) {
            throw new ProductAlreadyExistsException();
        } else {
            laptop.setSeriesNumber(laptopDto.getSeriesNumber());
            laptop.setManufacturerName(laptopDto.getManufacturerName());
            laptop.setPrice(laptopDto.getPrice());
            laptop.setNumberInStock(laptopDto.getNumberInStock());
            laptop.setSize(size);
            return laptopRepository.save(laptop);
        }
    }

    public Laptop deleteLaptopById(Long id) {
        Laptop laptop = laptopRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        laptopRepository.delete(laptop);
        return laptop;
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(Long id) {
        return laptopRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

}
