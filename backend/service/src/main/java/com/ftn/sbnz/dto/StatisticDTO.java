package com.ftn.sbnz.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatisticDTO {
    private Long id;
    private String email;
    private String comment;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
}
