package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.domain.Contract;
import com.team.seahouse.service.IContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @Title: 合同相关接口
 * @Description: 创建合同、签约合同等
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/12
 */
@Slf4j
@RestController
@RequestMapping("/contract")
@Api(value = "签约相关的接口", description = "创建签约信息、签约合同等")
public class ContractController extends BaseController {

    @Autowired
    private IContractService contractService;

    /**
     * 创建合同接口
     * @param contract 合同对象
     * @return
     */
    @PostMapping("/create")
    @ApiOperation(value = "创建合同", notes = "创建合同")
    public Response create(@RequestBody Contract contract) {
        try {
            Contract saveContract = contractService.create(contract);
            return new Response(CommonReturnCode.OK, saveContract);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

}
