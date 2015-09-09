package org.TikhomirovServiseHyber.interf;

import java.util.List;
import java.util.Set;


import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovVO.OfferVO;
import org.TikhomirovVO.UserVO;



public interface OfferServise {
	
	public void add(OfferVO offerVO) throws ServiseException;

	public List<OfferVO> getAll() throws ServiseException;

	public void delete(OfferVO offerVO) throws ServiseException;

	public OfferVO getById(OfferVO offerVO) throws ServiseException;
	
	public Set<OfferVO> getOffersByUser(UserVO userVO)throws ServiseException;

}
