package com.imraninfrared.Schkoula.Services.Assignments;

import com.imraninfrared.Schkoula.Models.Assignment;
import com.imraninfrared.Schkoula.Repositories.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class AssignmentServiceImpl implements AssignmentService{
    private final AssignmentRepository assignmentRepository;

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment getAssignment(Long id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        return assignment.orElse(null);
    }

    @Override
    public Assignment toggleStatus(Long id) {
        Assignment assignment = assignmentRepository.findById(id).get();
        assignment.setCompleted(!assignment.isCompleted());
        assignmentRepository.save(assignment);
        return assignment;
    }

    @Override
    public Assignment updateAssignment(Long id, Assignment assignment) {
        Optional<Assignment> assignmentToChange = assignmentRepository.findById(id);

        if (assignmentToChange.isPresent()){
            Assignment _assignment = assignmentToChange.get();
            _assignment.setTitle(assignment.getTitle());
            _assignment.setDeadline(assignment.getDeadline());
            _assignment.setPriority(assignment.getPriority());

            return assignmentRepository.save(_assignment);
        }
        return null;
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
