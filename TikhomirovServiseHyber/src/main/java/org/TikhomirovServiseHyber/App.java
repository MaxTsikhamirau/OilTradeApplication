package org.TikhomirovServiseHyber;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovServiseHyber.impl.OfferServiseImpl;
import org.TikhomirovServiseHyber.impl.OrderServiseImpl;
import org.TikhomirovServiseHyber.impl.UserServiseImpl;
import org.TikhomirovServiseHyber.interf.OfferServise;
import org.TikhomirovServiseHyber.interf.OrderServise;
import org.TikhomirovServiseHyber.interf.UserServise;
import org.TikhomirovVO.OfferVO;
import org.TikhomirovVO.OrderVO;
import org.TikhomirovVO.SortVO;
import org.TikhomirovVO.UserVO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ServiseException
    {
        UserServise userServise=new UserServiseImpl();
        OrderServise orderServise=new OrderServiseImpl();
        OfferServise offerServise=new OfferServiseImpl();
        UserVO userVO=new UserVO();
        
        //userVO.setUser_id(54);
       
        
//        try {
//			userServise.add(userVO1);
//		} catch (ServiseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//        try {
//        	System.out.println("Get all users");
//			System.out.println(userServise.getAll());
//		} catch (ServiseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        try {
//			userServise.delete(userVO);
//			System.out.println(userVO);
//		} catch (ServiseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//       try {
//		System.out.println( userServise.getById(userVO));
//	} catch (ServiseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
        
//        try {
//        	
//			System.out.println(userServise.getAuthorizedUser("dan", "dan").getOffersVO());
//		} catch (ServiseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        UserVO userVO1=new UserVO();
        userVO1.setUser_name("Hleb");
        userVO1.setTelephone("0023");
        SortVO sortVO=new SortVO();
        sortVO.setSort_name("WTI");
        OrderVO orderVO=new OrderVO();
        orderVO.setPrice(1230);
        orderVO.setQuantity(897);
        
        orderVO.setUserVO(userVO1);
        orderVO.setSortVO(sortVO);
      //  userServise.add(userVO1);
        System.out.println(orderVO);
      //  orderServise.add(orderVO);
        
        OfferVO offerVO=new OfferVO();
        offerVO.setPrice(12);
        offerVO.setQuantity(11);
        
        offerVO.setUserVO(userVO1);
        offerVO.setSortVO(sortVO);
        offerServise.add(offerVO);
     //  System.out.println( orderServise.getAll());
        
//        OrderVO delOrder=new OrderVO();
//        delOrder.setOrder_id(5);
//        System.out.println(delOrder);
   // orderServise.delete(delOrder);
      //  System.out.println(orderServise.getById(delOrder));
         
//        UserVO byUser=new UserVO();
//        byUser.setUser_id(3);
       //System.out.println( orderServise.getOrdersByUser(byUser));
       
//       System.out.println("getAuthorizedUser: "+userServise.getAuthorizedUser("dan", "fsdfd"));
//       System.out.println("offerslist:" +offerServise.getAll());
//       System.out.println("orderslist:" +orderServise.getAll());
    }
}
