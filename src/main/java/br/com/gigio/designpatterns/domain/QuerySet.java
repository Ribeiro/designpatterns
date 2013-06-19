package br.com.gigio.designpatterns.domain;

import java.io.Serializable;

public class QuerySet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9085668207690343466L;
	
	private boolean splitResults;
	
	private String groupingHeaders;

	public boolean isSplitResults() {
		return splitResults;
	}

	public void setSplitResults(boolean splitResults) {
		this.splitResults = splitResults;
	}
	
	public boolean hasToSplitResults() {
		return splitResults;
	}

	public String getGroupingHeaders() {
		return groupingHeaders;
	}

	public void setGroupingHeaders(String groupingHeaders) {
		this.groupingHeaders = groupingHeaders;
	}

}
