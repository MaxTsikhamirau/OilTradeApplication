package org.TikhomirovServiseHyber.interf;

import java.util.List;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovVO.SortVO;


public interface SortService {
	public void add(SortVO sortVO) throws ServiseException;

	public List<SortVO> getAll() throws ServiseException;

	public void delete(SortVO sortVO) throws ServiseException;

	public SortVO getById(SortVO sortVO) throws ServiseException;

}
