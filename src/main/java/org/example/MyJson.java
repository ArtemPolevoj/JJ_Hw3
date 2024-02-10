package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class MyJson extends Work {
    //region fields
    private final File file = new File(fileName + ".json");
    private final ObjectMapper objectMapper = new ObjectMapper();
    //endregion

    //region constructor
    public MyJson(String fileName, Student student) {
        super(fileName, student);
    }
    //endregion

    //region methods
    @Override
    public void serialisation() {
        try {
            objectMapper.writeValue(file, student);
            System.out.println("MyJson произвел сериализацию.");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка сериализации в классе MyJson.");
        }
    }

    @Override
    public void deserilisation() {
        try {
            Student st = objectMapper.readValue(file, Student.class);
            System.out.println("MyJson произвел десериализацию.");
            st.info();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка десериализации в классе MyJson.");
        }
    }
    //endregion
}
