package com.imraninfrared.Schkoula.Services.Exams;

import com.imraninfrared.Schkoula.Models.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {
    Exam createExam(Exam exam);
    List<Exam> getAllExams();
    Exam getExam(Long id);
    Exam updateExam(Long id, Exam exam);
    void deleteExam(Long id);
}
