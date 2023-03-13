package com.imraninfrared.Schkoula.Services.Assignments;

import com.imraninfrared.Schkoula.Models.Assignment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentService {
    Assignment createAssignment(Assignment assignment);
    List<Assignment> getAllAssignments();
    Assignment getAssignment(Long id);
    Assignment toggleStatus(Long id);
    Assignment updateAssignment(Long id, Assignment assignment);
    void deleteAssignment(Long id);
}
