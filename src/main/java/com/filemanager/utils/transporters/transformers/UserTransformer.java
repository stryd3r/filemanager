package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.UserDto;
import com.filemanager.utils.transporters.model.UserModel;

public class UserTransformer {

	private UserTransformer() {
	}

	public static UserDto modelToDto(UserModel model) {

		UserDto dto = new UserDto();

		dto.setId(model.getId()); 
		dto.setName(model.getName());
		dto.setSurname(model.getSurname());

		return dto;

	}

	public static UserModel dtoToModel(UserDto dto) {

		UserModel model = new UserModel();

		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setSurname(dto.getSurname());

		return model;

	}

}
