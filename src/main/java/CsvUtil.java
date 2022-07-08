import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;

public class CsvUtil {

    private CsvUtil() {}

    public static List<String[]> readAll(String filename) throws IOException, CsvException {
        List<String[]> data;

        try(CSVReader csvReader = new CSVReader(new FileReader(Paths.get(filename).toFile()))) {
            data = csvReader.readAll();
        }

        return data;
    }

    public static <T> List<T> readAllAsType(Class<T> type, String filepath) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(filepath))
                .withType(type)
                .build()
                .parse();
    }
}
