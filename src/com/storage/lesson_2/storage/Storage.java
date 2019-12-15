package com.storage.lesson_2.storage;

import com.storage.lesson_2.model.Resume;

import java.io.IOException;

public interface Storage {

    void clear();

    void save(Resume r);

    void update(String uuid) throws IOException;

    Resume get(String uuid);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll();

    int size();
}
