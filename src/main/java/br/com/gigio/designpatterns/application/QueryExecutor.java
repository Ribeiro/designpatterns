package br.com.gigio.designpatterns.application;

import java.sql.SQLException;
import java.util.List;

import org.springframework.integration.Message;

import br.com.gigio.designpatterns.domain.InputMap;
import br.com.gigio.designpatterns.domain.InputMaps;
import br.com.gigio.designpatterns.domain.OutputGroup;
import br.com.gigio.designpatterns.domain.OutputMaps;
import br.com.gigio.designpatterns.domain.Query;
import br.com.gigio.designpatterns.domain.QuerySet;

public interface QueryExecutor {	
	
	
	/**
	 * Execute query sql from Query using parameters from the InputMap
	 * @param query
	 * @param inputMap
	 * @return InputMaps result
	 */
	InputMaps execute(Query query, InputMap inputMap) throws Exception;	
	
	/**
	 * Process the payload from a incomingMessage using configurations of a QuerySet
	 * @param incomingMessage
	 * @param querySet
	 * @return List<OutputGroup> result
	 * @throws ResultSetEmptyException 
	 */
	List<OutputGroup> atomicProccessing(Message<?> incomingMessage, QuerySet querySet) throws SQLException;

	/**
	 * Returns a OutputMaps proccessing a InputMaps using a Query
	 * @param inputMaps
	 * @param query
	 * @return OutputMaps result
	 */
	OutputMaps processMaps(InputMaps inputMaps, Query query) throws SQLException;

}
