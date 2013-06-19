package br.com.gigio.designpatterns.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class OutputMaps extends InputMaps implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1885191044053812102L;

	/**
	 * Instantiates a new output maps.
	 */
	public OutputMaps() {
		super();
	}

	/**
	 * Instantiates a new output maps.
	 *
	 * @param input the input
	 */
	public OutputMaps(InputMaps input) {
		super(input);
	}

	/**
	 * Split.
	 *
	 * @param querySet the query set
	 * @return the list
	 */
	public List<OutputGroup> split(QuerySet querySet) {

		if (querySet.hasToSplitResults()) {

			return this.group(querySet.getGroupingHeaders());

		} else {

			return OutputGroup.singleGroup(this.getMaps());
		}

	}

	/**
	 * Group.
	 *
	 * @param groupingHeaders the grouping headers
	 * @return the list
	 */
	private List<OutputGroup> group(String groupingHeaders) {

		List<OutputGroup> outputGroups = new LinkedList<OutputGroup>();
		OutputGroup newOutputGroup = null;

		if (groupingHeaders != null && !groupingHeaders.trim().isEmpty()) {

			Grouper grouper = new Grouper(groupingHeaders);
			outputGroups = grouper.groupBy(this.getMaps());

		} else {

			for (InputMap inputMap : this.getMaps()) {
				newOutputGroup = new OutputGroup(
						(new InputMaps(inputMap)).getMaps());
				outputGroups.add(newOutputGroup);
			}

		}

		return outputGroups;

	}
	

}
