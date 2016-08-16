package com.filemanager.transporters.transformers;

import com.filemanager.transporters.dto.ConsultatieDto;
import com.filemanager.transporters.model.ConsultatieModel;
import com.filemanager.utils.BeanMapper;

public class ConsultatieTransformer extends BeanMapper<ConsultatieModel, ConsultatieDto> {

	private static volatile ConsultatieTransformer instance;

	private ConsultatieTransformer() {
	}

	public static ConsultatieTransformer getInstance() {
		if (instance == null) {
			synchronized (ConsultatieTransformer.class) {
				if (instance == null) {
					instance = new ConsultatieTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public ConsultatieModel dtoToModel(ConsultatieDto dto) {

		ConsultatieModel model = new ConsultatieModel();
		model.setId(dto.getId());
		model.setIdDoctor(dto.getIdDoctor());
		model.setIdPacient(dto.getIdPacient());
		model.setDiagnostic(dto.getDiagnostic());
		model.setObservatii(dto.getObservatii());
		model.setPret(dto.getPret());
		return model;
	}

	@Override
	public ConsultatieDto modelToDto(ConsultatieModel model) {

		ConsultatieDto dto = new ConsultatieDto();
		dto.setId(model.getId());
		dto.setIdDoctor(model.getIdDoctor());
		dto.setIdPacient(model.getIdPacient());
		dto.setDiagnostic(model.getDiagnostic());
		dto.setObservatii(model.getObservatii());
		dto.setPret(model.getPret());
		return dto;
	}

}
