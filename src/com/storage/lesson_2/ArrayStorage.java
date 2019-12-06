package com.storage.lesson_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int MAX_SIZE = 10000;
    Resume[] storage = new Resume[MAX_SIZE];
    int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        if (size == MAX_SIZE) {
            System.out.println("The storage is already full. ");
        } else {
            if (getResume(r.uuid) != null) {
                System.out.println("ERROR: this resume is already in the storage.");
            } else {
                storage[size] = r;
                size++;
            }
        }
    }

    void update(String uuid) throws IOException {
        if (getResume(uuid) == null) {
            System.out.println("ERROR: there is no such resume in the storage");
        } else {
            System.out.print("New uuid: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            getResume(uuid).uuid = reader.readLine();
        }
    }

    Resume get(String uuid) {
        Resume r = getResume(uuid);
        if (r == null) {
            System.out.println("ERROR: there is no such resume in the storage");
        }
        return r;
    }

    Resume getResume(String uuid) {
        int i = 0;
        while (i < size) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            } else {
                i++;
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (getResume(uuid) != null) {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    System.arraycopy(storage, i +1, storage, i, size - i -1);
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        } else {
            System.out.println("Error: there is no such resume in the storage");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
