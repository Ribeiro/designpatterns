package br.com.gigio.designpatterns.application;

import java.sql.SQLException;
import java.util.List;

import org.springframework.integration.Message;

import br.com.gigio.designpatterns.domain.InputMap;
import br.com.gigio.designpatterns.domain.InputMaps;
import br.com.gigio.designpatterns.domain.NonSQLTypeQuery;
import br.com.gigio.designpatterns.domain.OutputGroup;
import br.com.gigio.designpatterns.domain.OutputMaps;
import br.com.gigio.designpatterns.domain.Query;
import br.com.gigio.designpatterns.domain.QueryFromMessage;
import br.com.gigio.designpatterns.domain.QuerySet;
import br.com.gigio.designpatterns.domain.SQLTypeQuery;
import br.com.gigio.designpatterns.infrastructure.QueryExecutorDAO;

public class QueryExecutorImpl implements QueryExecutor {
	
	private QueryParser queryParser;

	public QueryParser getQueryParser() {
		return queryParser;
	}

	public void setQueryParser(QueryParser queryParser) {
		this.queryParser = queryParser;
	}
	
	public QueryExecutorDAO getQueryExecutorDAO() {
		return queryExecutorDAO;
	}

	public void setQueryExecutorDAO(QueryExecutorDAO queryExecutorDAO) {
		this.queryExecutorDAO = queryExecutorDAO;
	}

	private QueryExecutorDAO queryExecutorDAO;

	public InputMaps execute(Query query, InputMap inputMap) throws Exception {
		InputMaps inputMaps = new InputMaps();
		String parsedQuery = getQueryParser().parse(query.getSqlQuery(), inputMap.getMap());
		
		QueryFromMessage queryFromMessage = new QueryFromMessage();
		SQLTypeQuery sqlTypeQuery = new SQLTypeQuery();
		NonSQLTypeQuery nonSQLTypeQuery = new NonSQLTypeQuery();
		
		queryFromMessage.setSuccessor(sqlTypeQuery);
		sqlTypeQuery.setSuccessor(nonSQLTypeQuery);
		
		queryFromMessage.execute(inputMaps, query, parsedQuery, queryExecutorDAO);
		return inputMaps;
		
	}

	public List<OutputGroup> atomicProccessing(Message<?> incomingMessage,
			QuerySet querySet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public OutputMaps processMaps(InputMaps inputMaps, Query query)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}