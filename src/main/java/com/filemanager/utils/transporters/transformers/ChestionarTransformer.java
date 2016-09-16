package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.BeanMapper;
import com.filemanager.utils.transporters.dto.ChestionarDto;
import com.filemanager.utils.transporters.model.ChestionarModel;

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
	public ChestionarModel dtoToEntity(ChestionarDto dto) {

		ChestionarModel model = new ChestionarModel();
		model.setId(dto.getId());
		model.setIdIntrebare(dto.getIdIntrebare());
		model.setIntrebare(dto.getIntrebare());
		return model;
	}

	@Override
	public ChestionarDto entityToDto(ChestionarModel model) {

		ChestionarDto dto = new ChestionarDto();
		dto.setId(model.getId());
		dto.setIdIntrebare(model.getIdIntrebare());
		dto.setIntrebare(model.getIntrebare());
		return dto;
	}

}
