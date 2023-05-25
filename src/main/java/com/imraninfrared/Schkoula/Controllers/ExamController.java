package com.imraninfrared.Schkoula.Controllers;

import com.imraninfrared.Schkoula.Models.Exam;
import com.imraninfrared.Schkoula.Services.Exams.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exams/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExamController {

    private final ExamService examService;

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {
        return new ResponseEntity<>(examService.getAllExams(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(examService.getExam(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        return new ResponseEntity<>(examService.createExam(exam), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        Exam examToChange = examService.updateExam(id, exam);
        if (examToChange != null) {
            return new ResponseEntity<>(examToChange, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public void deleteExam(@PathVariable("id") Long id) {
        examService.deleteExam(id);
    }
}
