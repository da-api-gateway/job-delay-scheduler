package com.cjlabs.api.business.controller;

import com.cjlabs.api.business.convert.DelayJobExecuteLogConvert;
import com.cjlabs.api.business.mysql.DelayJobExecuteLog;
import com.cjlabs.api.business.reqquery.DelayJobExecuteLogReqQuery;
import com.cjlabs.api.business.requpdate.DelayJobExecuteLogReqSave;
import com.cjlabs.api.business.requpdate.DelayJobExecuteLogReqUpdate;
import com.cjlabs.api.business.resp.DelayJobExecuteLogResp;
import com.cjlabs.api.business.service.DelayJobExecuteLogService;
import com.cjlabs.db.domain.FmkPageResponse;
import com.cjlabs.db.domain.FmkRequest;
import com.cjlabs.web.check.FmkCheckUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * delay_job_execute_log 延迟任务执行日志表
 * <p>
 * 2025-12-28 10:32:02
 */
@Slf4j
@Service
public class DelayJobExecuteLogApiService {

    @Autowired
    private DelayJobExecuteLogService delayJobExecuteLogService;

    public DelayJobExecuteLogResp getById(FmkRequest<Void> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(StringUtils.isBlank(input.getBusinessKey()));

        DelayJobExecuteLog delayJobExecuteLog = delayJobExecuteLogService.getById(input);
        return DelayJobExecuteLogConvert.toResp(delayJobExecuteLog);
    }

    public DelayJobExecuteLogResp save(FmkRequest<DelayJobExecuteLogReqSave> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(Objects.isNull(input.getRequest()));

        DelayJobExecuteLogReqSave request = input.getRequest();
        if (Objects.isNull(request)) {
            log.info("DelayJobExecuteLogApiService|save|request is null");
            return null;
        }

        DelayJobExecuteLog delayJobExecuteLog = delayJobExecuteLogService.save(request);
        return DelayJobExecuteLogConvert.toResp(delayJobExecuteLog);
    }


    public boolean update(FmkRequest<DelayJobExecuteLogReqUpdate> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(Objects.isNull(input.getRequest()));

        DelayJobExecuteLogReqUpdate request = input.getRequest();
        if (Objects.isNull(request)) {
            log.info("DelayJobExecuteLogApiService|update|request is null");
            return false;
        }
        return delayJobExecuteLogService.update(request);
    }

    public boolean deleteById(FmkRequest<Void> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(Objects.isNull(input.getBusinessKey()));

        String businessKey = input.getBusinessKey();
        if (businessKey == null) {
            log.info("DelayJobExecuteLogApiService|deleteById|request is null");
            return false;
        }
        return delayJobExecuteLogService.deleteById(businessKey);
    }

    /**
     * 查询所有（不分页）
     */
    public List<DelayJobExecuteLogResp> listAll() {
        List<DelayJobExecuteLog> entityList = delayJobExecuteLogService.listAll();
        List<DelayJobExecuteLogResp> respList = DelayJobExecuteLogConvert.toResp(entityList);
        return respList;
    }

    /**
     * 分页查询
     */
    public FmkPageResponse<DelayJobExecuteLogResp> pageQuery(FmkRequest<DelayJobExecuteLogReqQuery> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(Objects.isNull(input.getRequest()));

        // 执行分页查询
        FmkPageResponse<DelayJobExecuteLog> entityPage = delayJobExecuteLogService.pageQuery(input);

        if (Objects.isNull(entityPage) || CollectionUtils.isEmpty(entityPage.getRecords())) {
            return FmkPageResponse.empty();
        }

        FmkPageResponse<DelayJobExecuteLogResp> pageResponse = FmkPageResponse.of(entityPage, DelayJobExecuteLogConvert::toResp);

        return pageResponse;
    }
}