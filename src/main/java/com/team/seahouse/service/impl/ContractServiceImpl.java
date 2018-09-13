package com.team.seahouse.service.impl;

import com.team.seahouse.commons.enums.ContractStatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.domain.Contract;
import com.team.seahouse.mapper.ContractMapper;
import com.team.seahouse.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Title: 合同相关业务实现类
 * @Description: 创建合同、签约合同等
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/13
 */
@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public Contract create(Contract contract) {
        try {
            contract.setCreateTime(new Date());
            contract.setState(ContractStatusEnum.NO_SIGN.getStatus());
            contractMapper.insert(contract);
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return contract;
    }
}
