package com.filemanager.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class BeanMapper<M, D> {

	public abstract M dtoToModel(D dto);

	public abstract D modelToDto(M model);

	public List<M> dtoToModelAsList(List<D> dtos) {

		List<M> models = new ArrayList<M>();

		if (isNull(dtos)) {
			return models;
		}

		for (D dto : dtos) {
			models.add(dtoToModel(dto));
		}

		return models;
	}

	public List<D> modelToDtoAsList(List<M> models) {

		List<D> dtos = new ArrayList<D>();

		if (isNull(models)) {
			return dtos;
		}

		for (M model : models) {
			dtos.add(modelToDto(model));
		}

		return dtos;
	}

	protected boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}

		return false;
	}
}