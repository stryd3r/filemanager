package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.BeanMapper;
import com.filemanager.utils.transporters.dto.DetaliiPacientDto;
import com.filemanager.utils.transporters.model.DetaliiPacientModel;

public class DetaliiPacientTransformer extends BeanMapper<DetaliiPacientModel, DetaliiPacientDto> {

	private static volatile DetaliiPacientTransformer instance;

	private DetaliiPacientTransformer() {
	}

	public static DetaliiPacientTransformer getInstance() {
		if (instance == null) {
			synchronized (DetaliiPacientTransformer.class) {
				if (instance == null) {
					instance = new DetaliiPacientTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public DetaliiPacientModel dtoToEntity(DetaliiPacientDto dto) {

		DetaliiPacientModel model = new DetaliiPacientModel();
		model.setIdPacient(dto.getIdPacient());
		model.setAdresa(dto.getAdresa());

		return model;
	}

	@Override
	public DetaliiPacientDto entityToDto(DetaliiPacientModel model) {

		DetaliiPacientDto dto = new DetaliiPacientDto();
		dto.setIdPacient(model.getIdPacient());
		dto.setAdresa(model.getAdresa());

		return dto;
	}

}
