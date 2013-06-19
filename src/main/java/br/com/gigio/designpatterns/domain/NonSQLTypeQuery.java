package br.com.gigio.designpatterns.domain;

import java.sql.SQLException;

import br.com.gigio.designpatterns.infrastructure.QueryExecutorDAO;

public class NonSQLTypeQuery extends QueryChain{

	@Override
	public void execute(InputMaps inputMaps, Query query, String parsedQuery,
			QueryExecutorDAO queryExecutorDAO) throws SQLException, Exception {
		
		if (!query.isSQLTypeQuery()) {
			inputMaps = queryExecutorDAO.execute(parsedQuery);
			
		} else {
			throw new RuntimeException("No implementaion has been satisfied on this chain!");

		}
		
	}

}
