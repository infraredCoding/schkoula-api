package com.imraninfrared.Schkoula.Services.Exams;

import com.imraninfrared.Schkoula.Models.Exam;
import com.imraninfrared.Schkoula.Repositories.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ExamServiceImpl implements ExamService {
    
    private final ExamRepository examRepository;
    
    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam getExam(Long id) {
        Optional<Exam> exam = examRepository.findById(id);
        return exam.orElse(null);
    }

    @Override
    public Exam updateExam(Long id, Exam exam) {
        Optional<Exam> examToChange = examRepository.findById(id);

        if (examToChange.isPresent()) {
            Exam _exam = examToChange.get();
            _exam.setTitle(exam.getTitle());
            _exam.setExamDateTime(exam.getExamDateTime());

            return examRepository.save(_exam);
        }

        return null;
    }

    @Override
    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
