package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.BeanMapper;
import com.filemanager.utils.transporters.dto.DoctorDto;
import com.filemanager.utils.transporters.model.DoctorModel;

public class DoctorTransformer extends BeanMapper<DoctorModel, DoctorDto> {

	private static volatile DoctorTransformer instance;

	private DoctorTransformer() {
	}

	public static DoctorTransformer getInstance() {
		if (instance == null) {
			synchronized (DoctorTransformer.class) {
				if (instance == null) {
					instance = new DoctorTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public DoctorModel dtoToModel(DoctorDto dto) {

		DoctorModel model = new DoctorModel();
		model.setId(dto.getId());
		model.setNume(dto.getNume());
		model.setPrenume(dto.getPrenume());
		return model;
	}

	@Override
	public DoctorDto modelToDto(DoctorModel model) {

		DoctorDto dto = new DoctorDto();
		dto.setId(model.getId());
		dto.setNume(model.getNume());
		dto.setPrenume(model.getPrenume());
		return dto;
	}

}
