package com.paraett.freedaysservice.model.entities;

import com.paraett.freedaysservice.model.enums.FreeDayType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "free_day_tbl")
public class FreeDay {
    @Id
    @Column(name = "free_day_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "company_id")
    private Long companyId;

    @Column
    private Date date;

    @Column
    private FreeDayType type;

    public FreeDay() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public FreeDayType getType() {
        return type;
    }

    public void setType(FreeDayType type) {
        this.type = type;
    }
}
