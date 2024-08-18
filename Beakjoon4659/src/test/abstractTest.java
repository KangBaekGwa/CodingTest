package test;

public abstract class abstractTest {
    int a;

    public abstractTest(int a) {
        this.a = a;
    }

    void print(){
        System.out.println("print 메서드 실행");
    }

    abstract void printf();
}
