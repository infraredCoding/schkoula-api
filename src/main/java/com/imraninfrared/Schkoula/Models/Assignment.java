package com.imraninfrared.Schkoula.Models;

import com.imraninfrared.Schkoula.Enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Priority priority;
    private Date deadline;
    private boolean isCompleted = false;
}
