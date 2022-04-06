package com.geektrust.family.tree.commands;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.geektrust.family.tree.main.Family;

public abstract class Command {
    
	public List<String> arguments;
	public Family family;
	
	protected Command(List<String> arguments, Family family) {
		this.arguments = arguments;
		this.family = family;
	}
	
	public static class Factory{
		public static Command create(String[] tokens, Family family) {
			String commandName = tokens[0];
			List<String> arguments = new LinkedList<>(Arrays.asList(tokens));
			arguments.remove(0);
			Command command;
			switch (commandName) {
			case "ADD_CHILD":
				command = new AddChild(arguments, family);
				break;
			case "ADD_CHILD_INI":
				command = new AddChildIni(arguments, family);
				break;
			case "ADD_SPOUSE":
				command = new AddSpouse(arguments, family);
				break;
			case "GET_RELATIONSHIP":
				command = new GetRelationship(arguments, family);
				break;

				case "ADD_SPOUSE1":
					command = new AddSpouse1(arguments,family);
					break;
			default:
				System.out.println("Invalid command");
				command = null;
				break;

			}
			return command;

		}
	}
	public abstract String execute();
}
