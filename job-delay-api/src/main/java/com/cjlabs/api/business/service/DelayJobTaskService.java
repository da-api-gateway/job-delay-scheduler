package com.cjlabs.api.business.service;

import com.cjlabs.api.business.convert.DelayJobTaskReqConvert;
import com.cjlabs.api.business.mapper.DelayJobTaskWrapMapper;
import com.cjlabs.api.business.mysql.DelayJobTask;
import com.cjlabs.api.business.reqquery.DelayJobTaskReqQuery;
import com.cjlabs.api.business.requpdate.DelayJobTaskReqSave;
import com.cjlabs.api.business.requpdate.DelayJobTaskReqUpdate;
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
 * delay_job_task 延迟任务配置表
 * <p>
 * 2025-12-28 10:32:02
 */
@Slf4j
@Service
public class DelayJobTaskService {

    @Autowired
    private DelayJobTaskWrapMapper delayJobTaskWrapMapper;

    public DelayJobTask getById(FmkRequest<Void> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(StringUtils.isBlank(input.getBusinessKey()));

        String id = input.getBusinessKey();
        return delayJobTaskWrapMapper.getById(id);
    }

    public DelayJobTask save(DelayJobTaskReqSave request) {
        FmkCheckUtil.checkInput(Objects.isNull(request));

        DelayJobTask db = DelayJobTaskReqConvert.toDb(request);

        int saved = delayJobTaskWrapMapper.save(db);
        FmkCheckUtil.throw200Error(saved == 0, Error200ExceptionEnum.DATA_NOT_FOUND);
        return db;
    }


    public boolean update(DelayJobTaskReqUpdate request) {
        FmkCheckUtil.checkInput(Objects.isNull(request));

        DelayJobTask db = DelayJobTaskReqConvert.toDb(request);

        int updated = delayJobTaskWrapMapper.updateById(db);
        if (updated > 0) {
            log.info("DelayJobTaskService|update|update={}|id={}", updated, request.getId());
            return true;
        }
        return false;
    }

    public boolean deleteById(String businessKey) {
        // 参数校验
        FmkCheckUtil.checkInput(StringUtils.isBlank(businessKey));

        int deleted = delayJobTaskWrapMapper.deleteById(businessKey);
        if (deleted > 0) {
            log.info("DelayJobTaskService|deleteById|deleteById={}|id={}", deleted, businessKey);
            return true;
        }
        return false;
    }

    /**
     * 查询所有（不分页）
     */
    public List<DelayJobTask> listAll() {
        List<DelayJobTask> entityList = delayJobTaskWrapMapper.listAllLimitService();
        return entityList;
    }

    /**
     * 分页查询
     */
    public FmkPageResponse<DelayJobTask> pageQuery(FmkRequest<DelayJobTaskReqQuery> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(Objects.isNull(input.getRequest()));

        // 执行分页查询
        FmkPageResponse<DelayJobTask> entityPage = delayJobTaskWrapMapper.pageQuery(input);

        return entityPage;
    }
}