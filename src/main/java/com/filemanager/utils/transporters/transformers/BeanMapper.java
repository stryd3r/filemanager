package com.filemanager.utils.transporters.transformers;

import java.util.ArrayList;
import java.util.List;

public abstract class BeanMapper<M, D> {

	public abstract M dtoToEntity(D dto);

	public abstract D entityToDto(M model);

	public List<M> dtoToEntityAsList(List<D> dtos) {

		List<M> models = new ArrayList<M>();

		if (isNull(dtos)) {
			return models;
		}

		for (D dto : dtos) {
			models.add(dtoToEntity(dto));
		}

		return models;
	}

	public List<D> entityToDtoAsList(List<M> models) {

		List<D> dtos = new ArrayList<D>();

		if (isNull(models)) {
			return dtos;
		}

		for (M model : models) {
			dtos.add(entityToDto(model));
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