package com.filemanager.utils.transporters.dto;

import java.util.ArrayList;
import java.util.List;

public class RemoveConsultationsInput {

	private List<Integer> ids = new ArrayList<>();

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

}
