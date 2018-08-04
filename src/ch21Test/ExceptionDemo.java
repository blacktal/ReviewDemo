package ch21Test;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            excTest();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("结束了吗");
    }

    public static void excTest() throws RuntimeException {
        System.out.println("开始执行...");
        throw new RuntimeException("发生了运行时异常！");
        // System.out.println("执行结束。");
    }
}
