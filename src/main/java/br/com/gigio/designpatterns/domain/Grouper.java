package br.com.gigio.designpatterns.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class Grouper {
	
	/** The grouping headers. */
	private String groupingHeaders;

	/**
	 * Instantiates a new grouper.
	 *
	 * @param groupingHeaders the grouping headers
	 */
	public Grouper(String groupingHeaders) {
		this.groupingHeaders = groupingHeaders;

	}

	/**
	 * Group by.
	 *
	 * @param listMap the list map
	 * @return the list
	 */
	public List<OutputGroup> groupBy(List<InputMap> listMap) {

		List<OutputGroup> outputGroups = new LinkedList<OutputGroup>();		
		
		Multimap<Map<String, Object>, InputMap> grouped = Multimaps.index(listMap,
				new Function<InputMap, Map<String, Object>>() {
					
					public Map<String, Object> apply(InputMap item) {						
						return Grouper.this.groupString(item);
					}
		});
 
		Iterator<Map<String, Object>> keyIterator = grouped.asMap().keySet().iterator();
		OutputGroup newOutputGroup = null;
		
		while (keyIterator.hasNext()) {
			Map<String, Object> key = keyIterator.next();
			Collection<InputMap> dataRows = grouped.get(key);			
			newOutputGroup = new OutputGroup((List<InputMap>)dataRows , key);
			outputGroups.add(newOutputGroup);			
		}

		return outputGroups;

	}

	/**
	 * Group string.
	 *
	 * @param item the item
	 * @return the string
	 */
	private Map<String, Object> groupString(InputMap item) {		
		
		String[] headers = groupingHeaders.split(",");

		Map<String, Object> out = new HashMap<String, Object>();
		
		for(int i = 0; i < headers.length ; i++) {
			
			out.put(headers[i].trim(), item.get(headers[i].trim()));

		}
		
		return out;
	}

	/**
	 * Sets the grouping headers.
	 *
	 * @param groupingHeaders the new grouping headers
	 */
	public void setGroupingHeaders(String groupingHeaders) {
		this.groupingHeaders = groupingHeaders;
	}


}

