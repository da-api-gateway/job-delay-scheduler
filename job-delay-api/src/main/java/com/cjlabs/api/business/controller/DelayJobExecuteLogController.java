package com.cjlabs.api.business.controller;

import com.cjlabs.api.business.reqquery.DelayJobExecuteLogReqQuery;
import com.cjlabs.api.business.requpdate.DelayJobExecuteLogReqSave;
import com.cjlabs.api.business.requpdate.DelayJobExecuteLogReqUpdate;
import com.cjlabs.api.business.resp.DelayJobExecuteLogResp;
import com.cjlabs.db.domain.FmkPageResponse;
import com.cjlabs.db.domain.FmkRequest;
import com.cjlabs.web.threadlocal.FmkResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * delay_job_execute_log 延迟任务执行日志表
 * <p>
 * 2025-12-28 10:32:02
 */
@Slf4j
@RestController
@RequestMapping("/api/delayJobExecuteLog")
public class DelayJobExecuteLogController {

    @Autowired
    private DelayJobExecuteLogApiService delayJobExecuteLogApiService;

    /**
     * 分页查询
     */
    @PostMapping("/page")
    public FmkResult<FmkPageResponse<DelayJobExecuteLogResp>> page(@RequestBody FmkRequest<DelayJobExecuteLogReqQuery> input) {
        FmkPageResponse<DelayJobExecuteLogResp> page = delayJobExecuteLogApiService.pageQuery(input);
        return FmkResult.success(page);
    }

    /**
     * 查询所有（不分页）
     */
    @PostMapping("/list")
    public FmkResult<List<DelayJobExecuteLogResp>> list() {
        List<DelayJobExecuteLogResp> list = delayJobExecuteLogApiService.listAll();
        return FmkResult.success(list);
    }

    /**
     * 根据 ID 查询
     */
    @PostMapping("/get/byId")
    public FmkResult<DelayJobExecuteLogResp> getById(@RequestBody FmkRequest<Void> input) {
        DelayJobExecuteLogResp resp = delayJobExecuteLogApiService.getById(input);
        return FmkResult.success(resp);
    }

    /**
     * 新增
     */
    @PostMapping("/save")
    public FmkResult<DelayJobExecuteLogResp> save(@RequestBody FmkRequest<DelayJobExecuteLogReqSave> input) {
        DelayJobExecuteLogResp result = delayJobExecuteLogApiService.save(input);
        return FmkResult.success(result);
    }

    /**
     * 更新
     */
    @PostMapping("/update/byId")
    public FmkResult<Boolean> update(@RequestBody FmkRequest<DelayJobExecuteLogReqUpdate> input) {
        boolean result = delayJobExecuteLogApiService.update(input);
        return FmkResult.success(result);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/byId")
    public FmkResult<Boolean> delete(@RequestBody FmkRequest<Void> input) {
        boolean result = delayJobExecuteLogApiService.deleteById(input);
        return FmkResult.success(result);
    }

}