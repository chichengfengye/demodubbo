package com.jf.demodubbo.mapper;

import com.jf.demodubbo.entity.TimeRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface TimeMapper {
    int insertTime(Date nowtime);

    TimeRecord selectLast();

    List<TimeRecord> selectRows();

}
