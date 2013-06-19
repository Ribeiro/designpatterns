package br.com.gigio.designpatterns.domain;

import br.com.gigio.designpatterns.infrastructure.QueryExecutorDAO;

public class SQLTypeQuery extends QueryChain{

	@Override
	public void execute(InputMaps inputMaps, Query query, String parsedQuery,
			QueryExecutorDAO queryExecutorDAO) throws Exception {
		
		if (query.isSQLTypeQuery()) {
			inputMaps = queryExecutorDAO.executeQuery(query,parsedQuery);
			
		} else {
			if (successor != null) {
				successor.execute(inputMaps, query, parsedQuery, queryExecutorDAO);
			}

		}
		
	}

}
