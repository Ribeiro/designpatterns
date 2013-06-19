package br.com.gigio.designpatterns.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class OutputGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3166693360334398456L;

	/** The maps. */
	private List<InputMap> maps;

	/** The grouping headers. */
	private Map<String, Object> groupingHeaders;

	/**
	 * Instantiates a new output group.
	 * 
	 * @param maps
	 *            the maps
	 */
	public OutputGroup(List<InputMap> maps) {

		this.maps = maps;
	}

	/**
	 * Instantiates a new output group.
	 * 
	 * @param maps
	 *            the maps
	 * @param groupingHeaders
	 *            the grouping headers
	 */
	public OutputGroup(List<InputMap> maps, Map<String, Object> groupingHeaders) {

		this.maps = maps;
		this.groupingHeaders = groupingHeaders;
	}

	/**
	 * Single group.
	 * 
	 * @param maps
	 *            the maps
	 * @return the list
	 */
	public static List<OutputGroup> singleGroup(List<InputMap> maps) {
		return Collections.singletonList(new OutputGroup(maps));
	}

	/**
	 * Checks for grouping headers.
	 * 
	 * @return true, if successful
	 */
	public boolean hasGroupingHeaders() {
		return this.getGroupingHeaders() != null
				&& !this.getGroupingHeaders().isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getMaps().hashCode();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OutputGroup other = (OutputGroup) obj;
		
		if (!getMaps().equals(other.getMaps())) {
			return false;
		}
		
		return true;
	}

	/**
	 * Gets the maps.
	 * 
	 * @return the maps
	 */
	public List<Map<String, Object>> getMaps() {

		List<Map<String, Object>> outputMaps = new ArrayList<Map<String, Object>>();

		for (InputMap map : maps) {
			outputMaps.add(map.getMap());
		}

		return outputMaps;
	}
	
	public boolean haveListofEmptyMap(){
		
		if(maps.size() == 1 && maps.get(0).isEmpty()){
				return true;
		}		
		return false;
	}

	/**
	 * Sets the maps.
	 * 
	 * @param maps
	 *            the new maps
	 */
	public void setMaps(List<InputMap> maps) {
		this.maps = maps;
	}

	/**
	 * Gets the grouping headers.
	 * 
	 * @return the grouping headers
	 */
	public Map<String, Object> getGroupingHeaders() {
		return groupingHeaders;
	}

	/**
	 * Sets the grouping headers.
	 * 
	 * @param groupingHeaders
	 *            the grouping headers
	 */
	public void setGroupingHeaders(Map<String, Object> groupingHeaders) {
		this.groupingHeaders = groupingHeaders;
	}
}

