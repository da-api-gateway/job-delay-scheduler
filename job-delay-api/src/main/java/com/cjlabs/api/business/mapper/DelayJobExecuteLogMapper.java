package com.cjlabs.api.business.mapper;

import com.cjlabs.api.business.mysql.DelayJobExecuteLog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * delay_job_execute_log 延迟任务执行日志表
 * <p>
 * 2025-12-28 10:32:02
 */
@Mapper
public interface DelayJobExecuteLogMapper extends BaseMapper<DelayJobExecuteLog> {

}