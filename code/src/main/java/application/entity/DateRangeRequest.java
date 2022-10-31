package application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

//JSON Object to be used in queries relying on a date range

public class DateRangeRequest {

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    public DateRangeRequest() {}

    public DateRangeRequest(Date startDate, Date endDate) {

        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Date getStartDate() {

        return this.startDate;

    }

    public void setStartDate(Date newDate) {

        this.startDate = newDate;

    }

    public Date getEndDate() {

        return this.endDate;

    }

    public void setEndDate(Date newDate) {

        this.endDate = newDate;

    }

}
