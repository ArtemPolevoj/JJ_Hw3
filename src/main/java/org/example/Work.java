package org.example;

abstract class Work {
    //region fields
    protected String fileName;
    protected Student student;
    //endregion

    //region constructor
    public Work(String fileName, Student student) {
        this.fileName = fileName;
        this.student = student;
    }
    //endregion

    //region methods
    protected abstract void serialisation();

    protected abstract void deserilisation();
    //endregion

}
