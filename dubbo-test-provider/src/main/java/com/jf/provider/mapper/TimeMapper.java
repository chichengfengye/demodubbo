package com.jf.provider.mapper;

import com.jf.dubbo.entity.TimeRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface TimeMapper {
    int insertTime(Date nowtime);

    TimeRecord selectLast();

    List<TimeRecord> selectRows();

}
