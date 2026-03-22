package com.federicog.taskmanager.util;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SchemaValidator {

    private SchemaValidator() {}

    public static boolean validate(String filePath) {

        try (
             InputStream schemaStream = SchemaValidator.class.getResourceAsStream("/data/tasks-schema.json");
             InputStream dataStream = Files.newInputStream(Paths.get(filePath))
        ) {
            Schema schema = SchemaLoader.load(new org.json.JSONObject(new JSONTokener(schemaStream)));

            // Leemos el archivo JSON a validar como JSONArray
            JSONArray data = new JSONArray(new JSONTokener(dataStream));

            // Validamos
            schema.validate(data);
            return true;

        } catch (org.everit.json.schema.ValidationException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println("File not found: " + filePath);
            return false;
        }
    }
}