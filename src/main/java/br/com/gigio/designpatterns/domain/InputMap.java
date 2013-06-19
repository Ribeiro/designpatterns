package br.com.gigio.designpatterns.domain;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputMap extends AbstractMap<String, Object> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2423545921329285461L;
	/** The map. */
	private final Map<String, Object> map;

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * Instantiates a new input map.
	 *
	 * @param map the map
	 */
	public InputMap(Map<String, Object> map) {
		this.map = map;
	}

	/**
	 * Instantiates a new input map.
	 */
	public InputMap() {
		this.map = new HashMap<String, Object>();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractMap#get(java.lang.Object)
	 */
	@Override
	public Object get(Object key) {
		return map.get(key);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object put(String key, Object value) {
		return map.put(key, value);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractMap#entrySet()
	 */
	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return map.entrySet();
	}
	
	/**
	 * Aggregate input map.
	 *
	 * @param inputMapToAggregate the input map to aggregate
	 * @return the input map
	 */
	public InputMap aggregateInputMap(InputMap inputMapToAggregate){
		
		this.getMap().putAll(inputMapToAggregate.getMap());
		
		return new InputMap(this.getMap());
	}

}