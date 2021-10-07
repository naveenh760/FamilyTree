package com.geektrust.family.tree.commands;

import java.util.List;

import com.geektrust.family.tree.main.Family;

public class AddChild extends AddChildIni {

	public AddChild(List<String> arguments, Family family) {
		super(arguments, family);
	}

	@Override
	public String execute() {
		String result = super.execute();
		if (result.isEmpty()) {
			result = "CHILD_ADDITION_SUCCEEDED";
		}
		return result;
	}

}
