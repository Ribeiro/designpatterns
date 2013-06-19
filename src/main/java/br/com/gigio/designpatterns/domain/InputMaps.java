package br.com.gigio.designpatterns.domain;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InputMaps extends AbstractCollection<InputMap> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6317591273550631576L;
	/** The maps. */
	private final List<InputMap> maps;

	/**
	 * Instantiates a new input maps.
	 *
	 * @param maps the maps
	 */
	public InputMaps(List<Map<String, Object>> maps) {
		this.maps = createInputs(maps);
	}

	/**
	 * Gets the maps.
	 *
	 * @return the maps
	 */
	public List<InputMap> getMaps() {
		return maps;
	}

	/**
	 * Instantiates a new input maps.
	 */
	public InputMaps() {
		this.maps = new ArrayList<InputMap>();
	}

	/**
	 * Instantiates a new input maps.
	 *
	 * @param input the input
	 */
	public InputMaps(InputMap input) {
		this.maps = new ArrayList<InputMap>();
		this.add(input);
	}

	/**
	 * Instantiates a new input maps.
	 *
	 * @param input the input
	 */
	public InputMaps(InputMaps input) {
		this.maps = new ArrayList<InputMap>();
		this.add(input);
	}

	/**
	 * Creates the inputs.
	 *
	 * @param maps the maps
	 * @return the list
	 */
	private List<InputMap> createInputs(List<Map<String, Object>> maps) {

		List<InputMap> list = new ArrayList<InputMap>();

		for (Map<String, Object> map : maps) {
			list.add(new InputMap(map));
		}

		return list;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<InputMap> iterator() {
		return maps.iterator();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return maps.size();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#add(java.lang.Object)
	 */
	@Override
	public final boolean add(InputMap input) {
		return this.maps.add(input);
	}

	/**
	 * Adds the.
	 *
	 * @param maps the maps
	 */
	public final void add(InputMaps maps) {
		this.maps.addAll(maps.maps);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maps == null) ? 0 : maps.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		InputMaps other = (InputMaps) obj;
		if (maps == null) {
			if (other.maps != null) {
				return false;
			}
		} else if (!maps.equals(other.maps)) {
			return false;
		}
		return true;
	}

	/**
	 * Blank.
	 *
	 * @return the input maps
	 */
	public static InputMaps blank() {
		InputMaps blank = new InputMaps();
		blank.add(new InputMap());
		return blank;
	}

}