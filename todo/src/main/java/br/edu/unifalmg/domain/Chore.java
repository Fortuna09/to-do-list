package br.edu.unifalmg.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Chore {

    private boolean isCompleted;

    private String description;

    private LocalDate deadline;


}
