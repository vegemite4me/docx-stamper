package org.wickedsource.docxstamper.context.functions;

public class FormatBoolFunctionImpl implements FormatBoolFunction {

	@Override
	public String formatBool(Boolean value) {
		return value ? "Yes" : "No";
	}

}
