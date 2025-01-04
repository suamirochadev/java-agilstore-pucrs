package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Product;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    private static final Gson gson = new Gson();

    public static void saveToFile(List<Product> products, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(products, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error saving data", e);
        }
    }

    public static List<Product> loadFromFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type type = new TypeToken<List<Product>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return List.of(); // Return empty list if no file found
        }
    }
}