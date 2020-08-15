package support;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class DataClass {

    private static final String csvFile = "src" +
            File.separator + "main" +
            File.separator + "resources" +
            File.separator + "login.csv";

    @DataProvider(name = "getLogin")
    public static Object[][] loginTestData(){
        return new Object[][] {{"standard_user","secret_sauce"}};
    }

    @DataProvider(name = "login-users-csv")
    public Iterator<Object[]> loginCSV(){
        return parseCsvData(csvFile);
    }

    private Iterator<Object[]> parseCsvData(String fileName) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
            String[] line;
            ArrayList<Object[]> data = new ArrayList<Object[]>();
            while ((line = csvReader.readNext()) != null) {
                data.add(line);
            }
            reader.close();
            csvReader.close();
            return data.iterator();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
