package com.bosonit.BP1.application.useCases.subject;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.subject.GetSubjectPort;
import com.bosonit.BP1.domain.entities.Subject;
import com.bosonit.BP1.domain.repositories.SubjectRepository;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetSubjectUseCase implements GetSubjectPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SubjectRepository repository;

    public ResponseEntity<SubjectOutputDTO> getSubjectId(String id) throws Exception {
        if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
        else {

            Subject subject = repository.findById(id).orElseThrow(() -> new Exception("Subject not registered."));
            SubjectOutputDTO subjectOut = modelMapper.map(subject, SubjectOutputDTO.class);

            return ResponseEntity.ok().body(subjectOut);
        }
    }

    public List<SubjectOutputDTO> getSubjectAll() {

        List<SubjectOutputDTO> listDTO = new ArrayList<>();
        List<Subject> SubjectList = repository.findAll();
        SubjectList.forEach(p -> {
            SubjectOutputDTO SubjectOutputDTO = modelMapper.map(p, SubjectOutputDTO.class);
            listDTO.add(SubjectOutputDTO);
        });

        return listDTO;
    }
}
