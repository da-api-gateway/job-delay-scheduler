package com.cjlabs.api.business.service;

import com.cjlabs.api.business.convert.DelayJobExecuteLogReqConvert;
import com.cjlabs.api.business.mapper.DelayJobExecuteLogWrapMapper;
import com.cjlabs.api.business.mysql.DelayJobExecuteLog;
import com.cjlabs.api.business.reqquery.DelayJobExecuteLogReqQuery;
import com.cjlabs.api.business.requpdate.DelayJobExecuteLogReqSave;
import com.cjlabs.api.business.requpdate.DelayJobExecuteLogReqUpdate;
import com.cjlabs.db.domain.FmkPageResponse;
import com.cjlabs.db.domain.FmkRequest;
import com.cjlabs.web.check.FmkCheckUtil;
import com.cjlabs.domain.exception.Error200ExceptionEnum;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * delay_job_execute_log 延迟任务执行日志表
 *
 * 2025-12-28 10:32:02
 */
@Slf4j
@Service
public class DelayJobExecuteLogService {
    
    @Autowired
    private DelayJobExecuteLogWrapMapper delayJobExecuteLogWrapMapper;
	
    public DelayJobExecuteLog getById(FmkRequest<Void> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(StringUtils.isBlank(input.getBusinessKey()));

        String id = input.getBusinessKey();
        return delayJobExecuteLogWrapMapper.getById(id);
    }

    public DelayJobExecuteLog save(DelayJobExecuteLogReqSave request) {
        FmkCheckUtil.checkInput(Objects.isNull(request));
        
        DelayJobExecuteLog db = DelayJobExecuteLogReqConvert.toDb(request);

        int saved = delayJobExecuteLogWrapMapper.save(db);
        FmkCheckUtil.throw200Error(saved == 0, Error200ExceptionEnum.DATA_NOT_FOUND);
        return db;
    }


    public boolean update(DelayJobExecuteLogReqUpdate request) {
        FmkCheckUtil.checkInput(Objects.isNull(request));
        
        DelayJobExecuteLog db = DelayJobExecuteLogReqConvert.toDb(request);
        
        int updated = delayJobExecuteLogWrapMapper.updateById(db);
        if (updated > 0) {
            log.info("DelayJobExecuteLogService|update|update={}|id={}", updated, request.getId());
            return true;
        }
        return false;
    }

    public boolean deleteById(String businessKey) {
        // 参数校验
        FmkCheckUtil.checkInput(StringUtils.isBlank(businessKey));
        
        int deleted = delayJobExecuteLogWrapMapper.deleteById(businessKey);
        if (deleted > 0) {
            log.info("DelayJobExecuteLogService|deleteById|deleteById={}|id={}", deleted, businessKey);
            return true;
        }
        return false;
    }

    /**
     * 查询所有（不分页）
     */
    public List<DelayJobExecuteLog> listAll() {
        List<DelayJobExecuteLog> entityList = delayJobExecuteLogWrapMapper.listAllLimitService();
        return entityList;
    }
    
      /**
     * 分页查询
     */
    public FmkPageResponse<DelayJobExecuteLog> pageQuery(FmkRequest<DelayJobExecuteLogReqQuery> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(Objects.isNull(input.getRequest()));

        // 执行分页查询
        FmkPageResponse<DelayJobExecuteLog> entityPage = delayJobExecuteLogWrapMapper.pageQuery(input);

        return entityPage;
    }
}