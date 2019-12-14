package com.storage.lesson_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int MAX_SIZE = 10000;
    private Resume[] storage = new Resume[MAX_SIZE];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    void save(Resume r) {
        if (size == MAX_SIZE) {
            System.out.println("The storage is already full. ");
        } else {
            if (getIndex(r.getUuid()) != -1) {
                System.out.println("ERROR: this resume is already in the storage.");
            } else {
                storage[size] = r;
                size++;
            }
        }
    }

    void update(String uuid) throws IOException {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: there is no such resume in the storage");
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("New uuid: ");
                String s = reader.readLine();
                if (getIndex(s) == -1) {
                    storage[index].setUuid(s);
                    break;
                } else {
                    System.out.println("ERROR: there is already resume in the storage with such uuid");
                }
            }
        }
    }

    Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("ERROR: there is no such resume in the storage");
            return null;
        }
        return storage[i];
    }

    void delete(String uuid) {
        if (getIndex(uuid) != -1) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    System.arraycopy(storage, i + 1, storage, i, size - i - 1);
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
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}
