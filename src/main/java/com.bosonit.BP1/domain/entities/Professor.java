package com.bosonit.BP1.domain.entities;

import com.bosonit.BP1.application.stringgenerator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Professors")
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professorIdGen")
    @GenericGenerator(
            name = "professorIdGen",
            strategy = "com.bosonit.BP1.application.stringgenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "AUS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    @Column(name = "Id_professor")
    private String id_professor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_person")
    private Person person;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Student> studentList = new ArrayList<>();

    @Column(name = "Comments")
    private String comments;

    @Column(name = "Branch")
    private String branch;
}
