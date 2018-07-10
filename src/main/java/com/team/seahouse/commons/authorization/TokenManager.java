package com.team.seahouse.commons.authorization;

/**        
 * Title: REST 鉴权   
 * Description: 登录用户的身份鉴权
 * @author rico       
 * @created 2017年7月4日 下午4:41:43    
 */      
public interface TokenManager {

    /**
     * 利用UUID创建Token(用户登录时，创建Token)
     * @param username
     * @return
     */
	String createToken(String username);

    /**
     * Token验证(用户登录验证)
     * @param token
     * @return
     */
    boolean checkToken(String token);

    /**
     * Token删除(用户登出时，删除Token)
     * @param token
     */
    void deleteToken(String token);
}
