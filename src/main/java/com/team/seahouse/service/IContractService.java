package com.team.seahouse.service;

import com.team.seahouse.domain.Contract;

/**
 * @Title: 签约相关业务接口
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/13
 */
public interface IContractService {

    /**
     * 创建合同接口
     * @param contract
     * @return
     */
    Contract create(Contract contract);
}
