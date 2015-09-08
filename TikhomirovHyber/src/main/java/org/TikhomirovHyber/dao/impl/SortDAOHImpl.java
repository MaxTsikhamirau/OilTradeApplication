package org.TikhomirovHyber.dao.impl;

import org.TikhomirovHyber.dao.interf.AbstractDAOH;
import org.TikhomirovHyber.dao.interf.SortDAOH;
import org.TikhomirovHyber.pojos.Sort;

public class SortDAOHImpl extends AbstractDAOH<Sort>implements SortDAOH<Sort> {
	private static SortDAOHImpl instance;

	private SortDAOHImpl() {
	}

	public static synchronized SortDAOHImpl getInstance() {
		if (instance == null) {
			instance = new SortDAOHImpl();
		}
		return instance;
	}

	@Override
	public String getQuery() {
		return "FROM Sort";
	}

	@Override
	public Class<Sort> getObjectClass() {
		return Sort.class;
	}

	@Override
	public Integer getId(Sort sort) {
		return sort.getSort_id();
	}

}
