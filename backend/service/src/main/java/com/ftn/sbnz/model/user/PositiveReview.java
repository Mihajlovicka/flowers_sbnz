package com.ftn.sbnz.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PositiveReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date = new Date();
    private String comment;

    public PositiveReview(String comment) {
        this.comment = comment;
    }
}
