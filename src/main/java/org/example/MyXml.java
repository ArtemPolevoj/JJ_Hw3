package org.example;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class MyXml extends Work {

    //region fields
    private final XmlMapper xmlMapper = new XmlMapper();
    private final File file = new File(fileName + ".xml");
    //endregion

    //region constructor
    public MyXml(String fileName, Student student) {
        super(fileName, student);
    }
    //endregion

    //region methods
    @Override
    protected void serialisation() {
        try {
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(file, student);
            System.out.println("MyXml произвел сериализацию.");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка сериализации в классе MyXml.");
        }
    }

    @Override
    protected void deserilisation() {
        try {
            Student st = xmlMapper.readValue(file, Student.class);
            System.out.println("MyXml произвел десериализацию.");
            st.info();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка десериализации в классе MyXml.");
        }
    }
    //endregion

}
