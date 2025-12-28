package com.cjlabs.api.business.mapper;

import com.cjlabs.api.business.mysql.DelayJobExecuteLog;
import com.cjlabs.api.business.reqquery.DelayJobExecuteLogReqQuery;
import com.cjlabs.db.mp.FmkService;
import com.cjlabs.db.domain.FmkOrderItem;
import com.cjlabs.db.domain.FmkPageResponse;
import com.cjlabs.db.domain.FmkRequest;
import com.cjlabs.web.check.FmkCheckUtil;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import lombok.extern.slf4j.Slf4j;
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
public class DelayJobExecuteLogWrapMapper extends FmkService<DelayJobExecuteLogMapper, DelayJobExecuteLog> {
    
    protected DelayJobExecuteLogWrapMapper(DelayJobExecuteLogMapper mapper) {
        super(mapper);
    }
    
    @Override
    protected Class<DelayJobExecuteLog> getEntityClass() {
        return DelayJobExecuteLog.class;
    }

 	/**
     * 分页查询
     */
    public FmkPageResponse<DelayJobExecuteLog> pageQuery(FmkRequest<DelayJobExecuteLogReqQuery> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(Objects.isNull(input.getRequest()));

        // 构建分页对象
        Page<DelayJobExecuteLog> page = new Page<>(input.getCurrent(), input.getSize());
        DelayJobExecuteLogReqQuery request = input.getRequest();

        // 构建查询条件
        LambdaQueryWrapper<DelayJobExecuteLog> lambdaQuery = buildLambdaQuery();


        List<FmkOrderItem> orderItemList = input.getOrderItemList();

        // 执行分页查询
        IPage<DelayJobExecuteLog> dbPage = super.pageByCondition(page, lambdaQuery, orderItemList);

        return FmkPageResponse.of(dbPage);
    }
}