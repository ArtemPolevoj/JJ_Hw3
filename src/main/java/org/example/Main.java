package org.example;

public class Main {
    public static void main(String[] args) {
        /*
        Ответ на вопрос, почему значение "GPA" не было сохранено/восстановлено,
        заключается в использовании ключевого слова "transient". Поле "GPA"
        не будет участвовать в процессе сериализации и десериализации, поэтому
        его значение не будет сохранено в файле и не будет восстановлено
        при десериализации.
        Но "transient" возможно не будет работать на сторонних библиотеках.
        Нужно изучать используемую библиотеку.
         */
        String fileName = "task2";
        Student student = new Student("Tom", 21, 4.6);

        Work file = new MyFile(fileName, student);
        file.serialisation();
        file.deserilisation();
        System.out.println();

        Work json = new MyJson(fileName, student);
        json.serialisation();
        json.deserilisation();
        System.out.println();

        Work xml = new MyXml(fileName, student);
        xml.serialisation();
        xml.deserilisation();
        System.out.println();

    }
}