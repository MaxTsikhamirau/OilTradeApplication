package org.TikhomirovServiseHyber.impl;

import java.util.List;
import java.util.Set;

import org.TikhomirovHyber.dao.impl.OfferDAOHImpl;
import org.TikhomirovHyber.dao.impl.OrderDAOHImpl;
import org.TikhomirovHyber.dao.interf.OfferDAOH;
import org.TikhomirovHyber.pojos.Offer;
import org.TikhomirovHyber.pojos.Order;
import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovServiseHyber.interf.OfferServise;
import org.TikhomirovServiseHyber.utils.POJOtoVOTransformation;
import org.TikhomirovServiseHyber.utils.VOtoPOJOTransformation;
import org.TikhomirovVO.OfferVO;
import org.TikhomirovVO.OrderVO;
import org.TikhomirovVO.UserVO;
import org.apache.log4j.Logger;

import exceptions.DAOException;

public class OfferServiseImpl implements OfferServise {
	private static final Logger logger = Logger.getLogger(OfferServiseImpl.class.getName());
	OfferDAOH offerdao = OfferDAOHImpl.getInstance();

	@Override
	public void add(OfferVO offerVO) throws ServiseException {
		logger.info("Start adding offerVO: " + offerVO + " to DataBase: ");
		logger.debug("Start transformation offerVO: " + offerVO + " to offer");
		Offer offer = VOtoPOJOTransformation.offerTransform(offerVO);
		logger.debug("Successful transformation from offerVO to offer. Transformed offer: " + offer);
		logger.info("Trying to add order: " + offer + " to DataBase");
		try {
			offerdao.add(offer);
			logger.info("New offer: " + offer + " was successfully created");
		} catch (DAOException e) {
			logger.error("Add offer: " + offer + " to DataBase: failed");
			throw new ServiseException("Add offer: " + offer + " to DataBase: failed", e);
		}
	}

	

	@Override
	public List<OfferVO> getAll() throws ServiseException {
		logger.info("Start getting List of offers");
		List<OfferVO> offersVO = null;
		try {
			List<Offer> offers = offerdao.getAll();
			logger.debug("Start transformation List<Offer> to List<OfferVO>");
			offersVO = POJOtoVOTransformation.offersExtract(offers);
			logger.debug("Successfull transformation List<Offer> to List<OfferVO>");
		} catch (DAOException e) {
			logger.error("Getting List of offers: failed");
			throw new ServiseException("Getting List of offers: failed", e);
		}
		logger.info("Successfull getting List of offers");
		return offersVO;
	}

	@Override
	public void delete(OfferVO offerVO) throws ServiseException {
		// TODO Auto-generated method stub

	}

	@Override
	public OfferVO getById(OfferVO offerVO) throws ServiseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<OfferVO> getOffersByUser(UserVO userVO) throws ServiseException {
		// TODO Auto-generated method stub
		return null;
	}

}
