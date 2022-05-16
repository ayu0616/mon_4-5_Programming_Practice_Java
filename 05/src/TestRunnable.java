public class TestRunnable {
    public static void doTask(Runnable task) {
        task.run();
    }

    public static void main(String[] args) {
        Runnable task1 = () -> System.out.println("Hello Runnable");

        doTask(task1);
        doTask(() -> System.out.println("Hello Lambda Runnable"));
    }
}
