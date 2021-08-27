package util.helpers;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvParser {

    public static <T> List<T> parseCsvToList(Class<T> clazz, String filePath) {
        CsvToBeanBuilder<T> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<>(new FileReader(new File(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (csvToBean != null) {
            return csvToBean.withType(clazz).build().parse();
        }
        return null;
    }
}
