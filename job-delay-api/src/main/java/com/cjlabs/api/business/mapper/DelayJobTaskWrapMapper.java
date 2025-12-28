package com.cjlabs.api.business.mapper;

import com.cjlabs.api.business.mysql.DelayJobTask;
import com.cjlabs.api.business.reqquery.DelayJobTaskReqQuery;
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
 * delay_job_task 延迟任务配置表
 *
 * 2025-12-28 10:32:02
 */
@Slf4j
@Service
public class DelayJobTaskWrapMapper extends FmkService<DelayJobTaskMapper, DelayJobTask> {
    
    protected DelayJobTaskWrapMapper(DelayJobTaskMapper mapper) {
        super(mapper);
    }
    
    @Override
    protected Class<DelayJobTask> getEntityClass() {
        return DelayJobTask.class;
    }

 	/**
     * 分页查询
     */
    public FmkPageResponse<DelayJobTask> pageQuery(FmkRequest<DelayJobTaskReqQuery> input) {
        // 参数校验
        FmkCheckUtil.checkInput(Objects.isNull(input));
        FmkCheckUtil.checkInput(Objects.isNull(input.getRequest()));

        // 构建分页对象
        Page<DelayJobTask> page = new Page<>(input.getCurrent(), input.getSize());
        DelayJobTaskReqQuery request = input.getRequest();

        // 构建查询条件
        LambdaQueryWrapper<DelayJobTask> lambdaQuery = buildLambdaQuery();


        List<FmkOrderItem> orderItemList = input.getOrderItemList();

        // 执行分页查询
        IPage<DelayJobTask> dbPage = super.pageByCondition(page, lambdaQuery, orderItemList);

        return FmkPageResponse.of(dbPage);
    }
}