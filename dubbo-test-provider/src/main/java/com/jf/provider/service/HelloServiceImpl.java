package com.jf.provider.service;

import com.jf.dubbo.entity.TimeRecord;
import com.jf.dubbo.service.HelloService;
import com.jf.provider.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {
    private String word = "帅锅 %s, time_stamp: %s, time_stamp_tz: %s";

    @Autowired
    private TimeMapper timeMapper;

    @Override
    public String hello(String name) {
        Date now = new Date();
        int res = timeMapper.insertTime(now);
        if (res < 1) {
            return "error";
        }
        TimeRecord record = timeMapper.selectLast();

        return String.format(word, name, record.getTimeStamp(), record.getTimeStampTz());
    }

    @Override
    public String selectLast() {
        TimeRecord record = timeMapper.selectLast();
        return String.format(word, "test", record.getTimeStamp(), record.getTimeStampTz());
    }

    @Override
    public List<String> selectRows() {
        List<TimeRecord> records = timeMapper.selectRows();
        List<String> reses = new ArrayList<>();
        for (TimeRecord record : records) {
            reses.add(String.format(word, "test", record.getTimeStamp(), record.getTimeStampTz()));
        }
        return reses;
    }

}
