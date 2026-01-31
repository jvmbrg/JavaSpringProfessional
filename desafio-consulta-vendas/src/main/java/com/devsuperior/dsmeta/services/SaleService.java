package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}


	public Page<SaleReportDTO> report(String minDateStr, String maxDateStr, String name, Pageable pageable){
		LocalDate maxDate;
		LocalDate minDate;

		if(maxDateStr == null || maxDateStr.isBlank()){
			maxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		}else{
			maxDate = LocalDate.parse(maxDateStr);
		}

		if(minDateStr == null || minDateStr.isBlank()){
			minDate = maxDate.minusYears(1L);
		}else{
			minDate = LocalDate.parse(minDateStr);
		}

		if(name == null){
			name = "";
		}

		return repository.searchReport(minDate, maxDate, name, pageable);
	}

	public List<SaleSummaryDTO> summary(String minDateStr, String maxDateStr){
		LocalDate maxDate;
		LocalDate minDate;

		if(maxDateStr == null || maxDateStr.isBlank()){
			maxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		}else{
			maxDate = LocalDate.parse(maxDateStr);
		}

		if (minDateStr == null || minDateStr.isBlank()){
			minDate = maxDate.minusYears(1L);
		}else{
			minDate = LocalDate.parse(minDateStr);
		}

		return repository.summary(minDate,maxDate);

	}
}
