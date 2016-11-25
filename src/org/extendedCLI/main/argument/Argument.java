package org.extendedCLI.main.argument;

import org.apache.commons.cli.Option;

@SuppressWarnings("javadoc")
public interface Argument {

	static Argument create(String name, Requires requiresValue) {
		return create(name, requiresValue, new String[0]);
	}
	
	static Argument create(String name, Requires requiresValue, String[] validValues) {
		return create(name, requiresValue, validValues, null);
	}
	
	static Argument create(String name, Requires requiresValue, String description) {
		return create(name, requiresValue, description, new String[0]);
	}

	static Argument create(String name, Requires requiresValue, String[] validValues, String defaultValue) {
		return create(name, requiresValue, "No description provided", validValues, defaultValue);
	}
	
	static Argument create(String name, Requires requiresValue, String description, String[] validValues) {
		return create(name, requiresValue, description, validValues, null);
	}
	
	static Argument create(String name, Requires requiresValue, String description, String[] validValues, String defaultValue) {
		return new DefaultArgument(name, requiresValue, description, validValues, defaultValue);
	}
	
	String getName();
	
	Requires requiresValue();
	
	String getDescription();

	boolean isValid(String value);
	void setValidValues(String[] values);

	void setDefaultValue(String value);
	String getDefaultValue();

	String getFormattedName();

	Option toOption();

	void setLongName(String longName);

	String getLongName();

	String[] getValidValues();
	
}
