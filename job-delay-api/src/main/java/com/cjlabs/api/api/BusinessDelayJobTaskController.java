package com.cjlabs.api.api;

import com.cjlabs.api.business.controller.DelayJobTaskApiService;
import com.cjlabs.api.business.requpdate.DelayJobTaskReqSave;
import com.cjlabs.api.business.resp.DelayJobTaskResp;
import com.cjlabs.db.domain.FmkRequest;
import com.cjlabs.web.threadlocal.FmkResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * delay_job_task 延迟任务配置表
 * <p>
 * 2025-12-28 10:32:02
 */
@Slf4j
@RestController
@RequestMapping("/api/business/delayJobTask")
public class BusinessDelayJobTaskController {

    @Autowired
    private DelayJobTaskApiService delayJobTaskApiService;

    /**
     * 根据 ID 查询
     */
    @PostMapping("/get/byId")
    public FmkResult<DelayJobTaskResp> getById(@RequestBody FmkRequest<Void> input) {
        DelayJobTaskResp resp = delayJobTaskApiService.getById(input);
        return FmkResult.success(resp);
    }

    /**
     * 新增
     */
    @PostMapping("/save")
    public FmkResult<DelayJobTaskResp> save(@RequestBody FmkRequest<DelayJobTaskReqSave> input) {
        DelayJobTaskResp result = delayJobTaskApiService.save(input);
        return FmkResult.success(result);
    }

}