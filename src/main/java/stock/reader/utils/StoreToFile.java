package stock.reader.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stock.reader.model.GroupStock;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StoreToFile {

    private static final Logger LOG = LoggerFactory.getLogger(StoreToFile.class);

    public void write(List<String> str) {
        try {
            if (str.size() > 0){
                Files.write(getFileFromResource("result.txt").toPath(), str, UTF_8, APPEND, CREATE);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    public File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }

    public static String writeToFile(GroupStock groupStock){
        if (groupStock == null){
            return "";
        }
        return groupStock.getTime().format(DateTimeFormatter.ofPattern("hh:mm:ss")) +
                "|" +
                groupStock.getCode() +
                "|" +
                "high;" +
                groupStock.getHigh() +
                "|" +
                "low;" +
                groupStock.getLow();
    }

}
