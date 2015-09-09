package org.TikhomirovServiseHyber.interf;

import java.util.List;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovVO.RoleVO;
import org.TikhomirovVO.SortVO;


public interface RoleService {
	public void add(RoleVO roleVO) throws ServiseException;

	public List<RoleVO> getAll() throws ServiseException;

	public void delete(RoleVO roleVO) throws ServiseException;

	public RoleVO getById(RoleVO roleVO) throws ServiseException;

}
