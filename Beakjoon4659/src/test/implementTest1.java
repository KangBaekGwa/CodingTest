package test;

public class implementTest1 extends abstractTest{

    public implementTest1(int a) {
        super(a);
    }

    @Override
    void printf() {
        System.out.println("implement 후, 실행");
    }
}
