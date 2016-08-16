package com.filemanager.transporters.transformers;

import com.filemanager.transporters.dto.ChestionarDto;
import com.filemanager.transporters.model.ChestionarModel;
import com.filemanager.utils.BeanMapper;

public class ChestionarTransformer extends BeanMapper<ChestionarModel, ChestionarDto> {

	private static volatile ChestionarTransformer instance;

	private ChestionarTransformer() {
	}

	public static ChestionarTransformer getInstance() {
		if (instance == null) {
			synchronized (ChestionarTransformer.class) {
				if (instance == null) {
					instance = new ChestionarTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public ChestionarModel dtoToModel(ChestionarDto dto) {

		ChestionarModel model = new ChestionarModel();
		model.setId(dto.getId());
		model.setIdIntrebare(dto.getIdIntrebare());
		model.setIntrebare(dto.getIntrebare());
		return model;
	}

	@Override
	public ChestionarDto modelToDto(ChestionarModel model) {

		ChestionarDto dto = new ChestionarDto();
		dto.setId(model.getId());
		dto.setIdIntrebare(model.getIdIntrebare());
		dto.setIntrebare(model.getIntrebare());
		return dto;
	}

}
