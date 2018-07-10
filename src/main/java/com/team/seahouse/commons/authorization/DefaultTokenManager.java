package com.team.seahouse.commons.authorization;

import com.team.seahouse.commons.utils.CodecUtil;
import com.team.seahouse.commons.utils.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

  
/**
 * @title TokenManager的默认实现
 * @describe  管理 Token
 * @author vanguard
 * @version 1.0
 * @date 18/7/10
 */
public class DefaultTokenManager implements TokenManager {

	/**
	 * 将token存储到JVM内存(ConcurrentHashMap)中   (@author: rico)
	 */
	private static Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();


	public String createToken(String username) {
		String token = CodecUtil.createUUID();
		tokenMap.put(token, username);
		return token;
	}

	public boolean checkToken(String token) {
		return !StringUtils.isBlank(token) && tokenMap.containsKey(token);
	}

	public void deleteToken(String token) {
		tokenMap.remove(token);
	}
}
