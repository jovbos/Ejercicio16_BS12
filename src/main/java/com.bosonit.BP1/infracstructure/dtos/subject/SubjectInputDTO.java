package com.bosonit.BP1.infracstructure.dtos.subject;

import lombok.Data;
import java.util.Date;

@Data
public class SubjectInputDTO {

    private String id_subject;

    private String name;

    private String comments;

    private Date initial_date;

    private Date finish_date;

}
