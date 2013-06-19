package br.com.gigio.designpatterns.domain;

public class Query {
	
	private String type;

	private String sqlQuery;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}
	
	public boolean isSQLTypeQuery() {
		return this.getType().equals("Query");
	}

}
