package se.lexicon.services;

import se.lexicon.models.Student;

import java.util.List;

public interface StudentMangement {
    Student create();
    Student save(Student student);
    Student find(int id);
    Student remove(int id);
    List<Student> findAll();
    Student edit(Student student);
}
