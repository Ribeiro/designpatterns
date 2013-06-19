package br.com.gigio.designpatterns.domain;

import java.sql.SQLException;

import br.com.gigio.designpatterns.infrastructure.QueryExecutorDAO;

public abstract class QueryChain {
	
	protected QueryChain successor;
	
	public void setSuccessor(QueryChain successor) {
		this.successor = successor;
	}
	
	abstract public void execute(InputMaps inputmaps, Query query, String parsedQuery, QueryExecutorDAO  queryExecutorDAO) throws SQLException, Exception;

}
