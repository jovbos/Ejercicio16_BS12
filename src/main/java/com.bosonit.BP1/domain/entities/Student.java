package com.bosonit.BP1.domain.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Parameter;
import com.bosonit.BP1.application.stringgenerator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdGen")
    @GenericGenerator(
            name = "studentIdGen",
            strategy = "com.bosonit.BP1.application.stringgenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    @Column(name = "Id_student")
    private String id_student;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Id_person")
    private Person person;

    @Column(name = "Hours_per_week")
    private Integer hours_per_week;

    @Column(name = "Comments")
    private String comments;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Id_professor")
    private Professor professor;

    @Column(name = "Branch")
    private String branch;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Subject> subjectList = new ArrayList<>();

    public void addSubject (Subject subject) {
        subjectList.add(subject);
    }

}
