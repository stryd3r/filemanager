package com.filemanager.transporters.transformers;

import com.filemanager.transporters.dto.CredentialDto;
import com.filemanager.transporters.model.CredentialModel;
import com.filemanager.utils.BeanMapper;

public class CredentialTransformer extends BeanMapper<CredentialModel, CredentialDto> {

	private static volatile CredentialTransformer instance;

	private CredentialTransformer() {
	}

	public static CredentialTransformer getInstance() {
		if (instance == null) {
			synchronized (CredentialTransformer.class) {
				if (instance == null) {
					instance = new CredentialTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public CredentialModel dtoToModel(CredentialDto dto) {

		CredentialModel model = new CredentialModel();
		model.setUser(dto.getUser());
		model.setPassword(dto.getPassword());

		return model;
	}

	@Override
	public CredentialDto modelToDto(CredentialModel model) {

		CredentialDto dto = new CredentialDto();
		dto.setUser(model.getUser());
		dto.setPassword(model.getPassword());

		return dto;
	}

}
