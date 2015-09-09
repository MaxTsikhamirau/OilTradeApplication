package org.TikhomirovServiseHyber;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovServiseHyber.impl.UserServiseImpl;
import org.TikhomirovServiseHyber.interf.UserServise;
import org.TikhomirovVO.UserVO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserServise userServise=new UserServiseImpl();
        UserVO userVO=new UserVO();
        
        userVO.setUser_id(54);
        UserVO userVO1=new UserVO(new Integer(5),"mikel", "homyak", "choowe", "Liverpool", "UK", "002356");
        
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
        
        try {
			System.out.println(userServise.getAuthorizedUser("dan", "dan"));
		} catch (ServiseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
