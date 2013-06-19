package br.com.gigio.designpatterns.domain;

import br.com.gigio.designpatterns.infrastructure.QueryExecutorDAO;

public class QueryFromMessage extends QueryChain{

	@Override
	public void execute(InputMaps inputMaps, Query query, String parsedQuery,
			QueryExecutorDAO queryExecutorDAO) throws Exception {
		
			if (query.getType() == null) {
				inputMaps = queryExecutorDAO.executePayload(query,parsedQuery);
			} else {
				if (successor != null) {
					successor.execute(inputMaps, query, parsedQuery, queryExecutorDAO);
				}
			
			}
		
	}

}
