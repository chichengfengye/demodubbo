package com.jf.demodubbo.entity;

import java.util.Date;

public class TimeRecord {
    private Long id;
    private Date timeStamp;
    private Date timeStampTz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getTimeStampTz() {
        return timeStampTz;
    }

    public void setTimeStampTz(Date timeStampTz) {
        this.timeStampTz = timeStampTz;
    }
}
