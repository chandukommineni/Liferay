package com.custom.student.object.rest.builder.client.aggregation;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * @author kommineni.chandu
 * @generated
 */
@Generated("")
public class Aggregation {

	public Map<String, String> getAggregationTerms() {
		return _aggregationTerms;
	}

	public void setAggregationTerms(Map<String, String> aggregationTerms) {
		_aggregationTerms = aggregationTerms;
	}

	private Map<String, String> _aggregationTerms = new HashMap<>();

}