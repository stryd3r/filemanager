package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.PacientsDetailsDto;
import com.filemanager.utils.transporters.entities.PacientsDetails;

public class PacientDetailTransformer extends BeanMapper<PacientsDetails, PacientsDetailsDto> {

	private static volatile PacientDetailTransformer instance;

	private PacientDetailTransformer() {
	}

	public static PacientDetailTransformer getInstance() {
		if (instance == null) {
			synchronized (PacientDetailTransformer.class) {
				if (instance == null) {
					instance = new PacientDetailTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public PacientsDetails dtoToEntity(PacientsDetailsDto dto) {
		PacientsDetails entity = new PacientsDetails();
		if (dto != null) {
			entity.setAddress(dto.getAddress());
			entity.setPacient(PacientTransformer.getInstance().dtoToEntity(dto.getPacient()));
			entity.setPacientDetailsId(dto.getPacientDetailsId());
		}
		return entity;
	}

	@Override
	public PacientsDetailsDto entityToDto(PacientsDetails entity) {
		PacientsDetailsDto dto = new PacientsDetailsDto();
		if (entity != null) {
			dto.setAddress(entity.getAddress());
			dto.setPacient(PacientTransformer.getInstance().entityToDto(entity.getPacient()));
			dto.setPacientDetailsId(entity.getPacientDetailsId());
		}
		return dto;
	}

}