package _9_template_method;

public class TemplateMethodExample {


    public abstract class AbstractTest {

        abstract protected void prepare();

        abstract protected boolean run();

        protected void releaseResources(){};

        public void runTest() {

            prepare();

            long start = System.currentTimeMillis();

            boolean isSuccessful = run();

            System.out.println("end test" + getClass().getSimpleName() + "\n" +
                    "time: " + (System.currentTimeMillis() - start) + " msec\n" +
                    "success: " + isSuccessful + "\n");

            releaseResources();
        }
    }


    public class ConcreteTest extends AbstractTest {

        @Override
        protected void prepare() {
            // какие-то специальные действия по подготовке теста к запуску
        }

        @Override
        protected boolean run() {
            // логика самого теста
        }

        @Override
        protected void releaseResources() {
            // логика освобождения ресурсов если надо
        }
    }

}
