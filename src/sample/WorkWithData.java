package sample;

import sample.Data.Data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Работа с данными
 *
 * Дополнительные методы:
 * 1) загрузка данных из файла в данные
 * 2) загрузка данных из файла в строку
 * 3) загрузка строки данных в файл
 */
public class WorkWithData {

    // загрузка данных из файла в данные
    public Data dataWithLoad(String way, Data data) {
        try (FileReader reader = new FileReader(way)) {
            String resRead = "";
            int symbol;
            while ((symbol = reader.read()) != -1)
                resRead += (char) symbol;
            data.loadData(resRead);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    // загрузка данных из файла в строку
    public String dataFromFile(String way) {
        String resRead = "";
        try (FileReader reader = new FileReader(way)) {
            int symbol;
            while ((symbol = reader.read()) != -1)
                resRead += (char) symbol;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resRead;
    }

    // загрузка строки данных в файл
    public int writeDataFile(String file, String data, boolean isAppendExport) {
        try(FileWriter writer = new FileWriter(file, isAppendExport)) {
            writer.write(data);
            writer.flush();
            return Constants.NORNAL_WRITE;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Constants.ERROR_WRITE;
        }
    }
}
