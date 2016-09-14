package gifterland3.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by kdiv on 9/14/16.
 */
public interface MealStorageService {

     Stream<Path> loadAll();

    /**
     * Методы касающиеся харнилища
     */
    void init();
    void deleteAll();

    /**
     * Методы касающиеся загрузки и отображения файлов
     * @param filename
     * @return
     */
    Path load(String filename);
    Resource loadAsResource(String filename);

    /**
     * Метод касающийся сохранения файлов в хранилище
     *
     * @param file
     */
    void store(MultipartFile file);
}
