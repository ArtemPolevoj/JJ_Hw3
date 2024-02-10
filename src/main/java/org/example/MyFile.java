package org.example;

import java.io.*;

public class MyFile extends Work {
    private  final File file = new File(fileName + ".txt");
    public MyFile(String fileName, Student student) {
        super(fileName, student);
    }

    @Override
    public void serialisation() {
        try (FileOutputStream outfile = new FileOutputStream(file);
             ObjectOutputStream outObj = new ObjectOutputStream(outfile)) {
            outObj.writeObject(student);
            System.out.println("MyFile произвел сериализацию.");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка сериализации в классе MyFile.");
        }
    }

    @Override
    public void deserilisation() {
        try (FileInputStream infile = new FileInputStream(file);
             ObjectInputStream inObj = new ObjectInputStream(infile)) {
            Student st = (Student) inObj.readObject();
            System.out.println("MyFile произвел десериализацию.");
            st.info();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка десериализации в классе MyFile.");
        }
    }
}
