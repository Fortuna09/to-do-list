package br.edu.unifalmg.service;

import br.edu.unifalmg.domain.Chore;
import br.edu.unifalmg.exception.DuplicatedChoreException;
import br.edu.unifalmg.exception.InvalidDeadlineException;
import br.edu.unifalmg.exception.InvalidDescriptionException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChoreService {

    public ChoreService() {
        List<Chore> chores = new ArrayList<>();
    }
    private List<Chore> chores;

    public Chore addChore(String description, LocalDate deadline) {
        if (description == null || description.isEmpty()) {
            throw new InvalidDescriptionException("The description cannot be null or empty");
        }
        if (deadline == null || deadline.isBefore(LocalDate.now())) {
            throw new InvalidDeadlineException("The deadline cannot be or before the current date");
        }

        for (Chore chore : chores) {
            if (chore.getDescription().equals(description) && chore.getDeadline().isEqual(deadline)){
                throw new DuplicatedChoreException("The given chore already exists.");
            }
        }

//        Chore chore = new Chore();
//        chore.setDescription(description);
//        chore.setDeadline(deadline);
//        chore.setIsCompleted(Boolean.FALSE);

        Chore chore = Chore.builder()
                .description(description)
                .deadline(deadline)
                .isCompleted(Boolean.FALSE)
                .build();
//        Chore chore = new Chore(description,deadline,Boolean.FALSE);

        chores.add(chore);
        return chore;
    }

}
