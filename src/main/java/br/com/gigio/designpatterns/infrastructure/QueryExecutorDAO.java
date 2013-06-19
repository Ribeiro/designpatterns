package br.com.gigio.designpatterns.infrastructure;

import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.gigio.designpatterns.domain.InputMaps;
import br.com.gigio.designpatterns.domain.Query;


public interface QueryExecutorDAO {

	/**
	 * Execute.
	 *
	 * @param sql the sql
	 * @return the input maps
	 */
	InputMaps execute(String sql);
	
	/**
	 * Execute query.
	 *
	 * @param sql the sql
	 * @return the input maps
	 * @throws ResultSetEmptyException the query executor dao exception
	 */
	InputMaps executeQuery(Query query, String sql) throws Exception;
	
	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	void setDataSource(DataSource dataSource);
	
	/**
	 * Execute payload.
	 *
	 * @param sql the sql
	 * @return the input maps
	 */
	InputMaps executePayload(Query query, String sql) throws SQLException;


}
