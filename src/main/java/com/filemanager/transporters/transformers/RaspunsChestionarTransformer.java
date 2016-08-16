package com.filemanager.transporters.transformers;

import com.filemanager.transporters.dto.RaspunsChestionarDto;
import com.filemanager.transporters.model.RaspunsChestionarModel;
import com.filemanager.utils.BeanMapper;

public class RaspunsChestionarTransformer extends BeanMapper<RaspunsChestionarModel, RaspunsChestionarDto> {

	private static volatile RaspunsChestionarTransformer instance;

	private RaspunsChestionarTransformer() {
	}

	public static RaspunsChestionarTransformer getInstance() {
		if (instance == null) {
			synchronized (RaspunsChestionarTransformer.class) {
				if (instance == null) {
					instance = new RaspunsChestionarTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public RaspunsChestionarModel dtoToModel(RaspunsChestionarDto dto) {

		RaspunsChestionarModel model = new RaspunsChestionarModel();
		model.setIdPacient(dto.getIdPacient());
		model.setIdChestionar(dto.getIdChestionar());
		model.setIdIntrebare(dto.getIdIntrebare());
		model.setRaspuns(dto.getRaspuns());
		return model;
	}

	@Override
	public RaspunsChestionarDto modelToDto(RaspunsChestionarModel model) {

		RaspunsChestionarDto dto = new RaspunsChestionarDto();
		dto.setIdPacient(model.getIdPacient());
		dto.setIdChestionar(model.getIdChestionar());
		dto.setIdIntrebare(model.getIdIntrebare());
		dto.setRaspuns(model.getRaspuns());
		return dto;
	}

}
