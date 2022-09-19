package ru.kolesnik.computershop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolesnik.computershop.exception.ProductAlreadyExistsException;
import ru.kolesnik.computershop.exception.ProductNotFound;
import ru.kolesnik.computershop.exception.UnknownPcFormFactorException;
import ru.kolesnik.computershop.payload.PcDto;
import ru.kolesnik.computershop.repository.PcFormFactorRepository;
import ru.kolesnik.computershop.repository.PcRepository;
import ru.kolesnik.computershop.repository.entity.Pc;
import ru.kolesnik.computershop.repository.entity.PcFormFactor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PcService {

    private final PcRepository pcRepository;
    private final PcFormFactorRepository pcFormFactorRepository;

    public Pc createPc(PcDto pcDto) {
        Optional<Pc> samePcOptional = pcRepository.findBySeriesNumberAndManufacturerName(pcDto.getSeriesNumber(),
                pcDto.getManufacturerName());
        PcFormFactor formFactor = pcFormFactorRepository.findByName(pcDto.getFormFactorName())
                .orElseThrow(UnknownPcFormFactorException::new);
        if (samePcOptional.isPresent()) {
            throw new ProductAlreadyExistsException();
        } else {
            Pc pc = new Pc(pcDto.getSeriesNumber(), pcDto.getManufacturerName(),
                    pcDto.getPrice(), pcDto.getNumberInStock(), formFactor);
            return pcRepository.save(pc);
        }
    }

    public Pc updatePcById(PcDto pcDto, Long id) {
        Pc pc = pcRepository.findById(id).orElseThrow(ProductNotFound::new);
        Optional<Pc> samePcOptional = pcRepository.findBySeriesNumberAndManufacturerName(pcDto.getSeriesNumber(),
                pcDto.getManufacturerName());
        PcFormFactor formFactor = pcFormFactorRepository.findByName(pcDto.getFormFactorName())
                .orElseThrow(UnknownPcFormFactorException::new);
        if (samePcOptional.isPresent() && !samePcOptional.get().getId().equals(id)) {
            throw new ProductAlreadyExistsException();
        } else {
            pc.setSeriesNumber(pcDto.getSeriesNumber());
            pc.setManufacturerName(pcDto.getManufacturerName());
            pc.setPrice(pcDto.getPrice());
            pc.setNumberInStock(pcDto.getNumberInStock());
            pc.setFormFactor(formFactor);
            return pcRepository.save(pc);
        }
    }

    public Pc deletePcById(Long id) {
        Pc pc = pcRepository.findById(id).orElseThrow(ProductNotFound::new);
        pcRepository.delete(pc);
        return pc;
    }

    public List<Pc> getAllPcs() {
        return pcRepository.findAll();
    }

    public Pc getPcById(Long id) {
        return pcRepository.findById(id).orElseThrow(ProductNotFound::new);
    }

}
