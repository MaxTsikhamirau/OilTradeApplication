package org.TikhomirovHyber.dao.impl;

import org.TikhomirovHyber.dao.interf.AbstractDAOH;
import org.TikhomirovHyber.pojos.Role;

public class RoleDAOHImpl extends AbstractDAOH<Role> {

	@Override
	public String getQuery() {
		return "FROM Role";
	}

	@Override
	public Class<Role> getObjectClass() {
		return Role.class;
	}

	@Override
	public Integer getId(Role object) {
		return null;
	}

}
