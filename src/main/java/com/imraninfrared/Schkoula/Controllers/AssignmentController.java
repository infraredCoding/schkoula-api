package com.imraninfrared.Schkoula.Controllers;

import com.imraninfrared.Schkoula.Models.Assignment;
import com.imraninfrared.Schkoula.Services.Assignments.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/assignments/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        List<Assignment> assignments = assignmentService.getAllAssignments();
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(assignmentService.getAssignment(id), HttpStatus.OK);
    }

    @PostMapping("toggle/{id}")
    public ResponseEntity<Assignment> toggleStatus(@PathVariable("id") Long id) {
        return new ResponseEntity<>(assignmentService.toggleStatus(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        return new ResponseEntity<>(assignmentService.createAssignment(assignment), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        Assignment changedAssignment = assignmentService.updateAssignment(id, assignment);
        if (changedAssignment != null) {
            return new ResponseEntity<>(changedAssignment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public void deleteAssignment(@PathVariable("id") Long id) {
        assignmentService.deleteAssignment(id);
    }
}
