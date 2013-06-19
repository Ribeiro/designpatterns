package br.com.gigio.designpatterns.application;

import java.util.Map;

public interface QueryParser {

	String parse(String sqlQuery, Map<String, Object> map);

}
