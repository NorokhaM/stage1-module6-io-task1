package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {
    public Profile getDataFromFile(File file)  {
        BufferedReader reader = null;
        int index=0;
        String[] data = new String[4];
        try{
            reader = new BufferedReader(new java.io.FileReader(file));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                data[index++] = readLine;
            }
            String name = data[0].split(":")[1].trim();
            Integer age= Integer.parseInt(data[1].split(":")[1].trim());
            String email = data[2].split(":")[1].trim();
            Long phone = Long.parseLong(data[3].split(":")[1].trim());
            return new Profile(name, age, email, phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
