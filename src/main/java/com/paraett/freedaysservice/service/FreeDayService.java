package com.paraett.freedaysservice.service;

import com.paraett.freedaysservice.exception.NotFoundException;
import com.paraett.freedaysservice.model.entities.FreeDay;
import com.paraett.freedaysservice.repository.FreeDayRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreeDayService {

    private FreeDayRepository freeDayRepository;

    public FreeDayService(FreeDayRepository freeDayRepository) {
        this.freeDayRepository = freeDayRepository;
    }

    public List<FreeDay> getAllFreeDays(Long companyId) {
        if (companyId != null) {
            return  freeDayRepository.findAllByCompanyId(companyId);
        }
        return freeDayRepository.findAll();
    }

    public FreeDay getFreeDay(Long id) {
        Optional<FreeDay> optionalFreeDay = freeDayRepository.findById(id);
        if (optionalFreeDay.isPresent()) {
            return optionalFreeDay.get();
        }
        throw new NotFoundException("id: " + id);
    }

    public void deleteFreeDay(Long id) {
        Optional<FreeDay> optionalFreeDay = freeDayRepository.findById(id);
        if (optionalFreeDay.isPresent()) {
            freeDayRepository.deleteById(id);
        }
        throw new NotFoundException("id: " + id);
    }

    public FreeDay createFreeDay(FreeDay freeDay) {
        return freeDayRepository.save(freeDay);
    }

    public FreeDay updateFreeDay(Long id, FreeDay freeDay) {
        Optional<FreeDay> optionalFreeDay = freeDayRepository.findById(id);
        if (optionalFreeDay.isPresent()) {
            freeDay.setId(id);
            freeDayRepository.save(freeDay);
        }
        throw new NotFoundException("id: " + id);
    }

    public void deleteFreeDays(Long companyId) {
        if (companyId != null) {
            freeDayRepository.deleteAllByCompanyId(companyId);
        }
    }

    public List<FreeDay> createFreeDays(List<FreeDay> freeDays) {
        return freeDayRepository.saveAll(freeDays);
    }
}
