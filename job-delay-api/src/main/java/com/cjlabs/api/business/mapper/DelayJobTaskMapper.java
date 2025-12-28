package com.cjlabs.api.business.mapper;

import com.cjlabs.api.business.mysql.DelayJobTask;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * delay_job_task 延迟任务配置表
 * <p>
 * 2025-12-28 10:32:02
 */
@Mapper
public interface DelayJobTaskMapper extends BaseMapper<DelayJobTask> {

}