/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        int i = 0;
        while (i < size()) {
            if (storage[i].uuid.equals(uuid)) {
                break;
            } else {
                i++;
            }
        }
        return storage[i];
    }

    void delete(String uuid) {
        int i = 0;
        while (i < size()) {
            if (storage[i].uuid.equals(uuid)) {
                break;
            } else {
                i++;
            }
        }
        for (int j = i; j < size() - 1; j++) {
            storage[j] = storage[j + 1];
        }
        storage[size() - 1] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] getArray = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            getArray[i] = storage[i];
        }
        return getArray;
    }

    int size() {
        int i = 0;
        while (i < 10000) {
            if (storage[i] == null) {
                break;
            } else {
                i++;
            }
        }
        return i;
    }
}
