import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeTest {
    class TestObserver implements Observer{
        boolean called = false;

        @Override
        public void update() {
            called = true;
        }
    }

    private TestObserver testObserver = new TestObserver();
    private Time testTime;

    @BeforeEach
    void createTime(){
        testTime = Time.createTime(testObserver);
    }

    @Test
    void testSingleton(){
        Time testTime2 = Time.createTime(testObserver);
        assertEquals(testTime,testTime2);
    }

    @Test
    void testCalledUpdate(){
        testTime.observer = testObserver;
        testTime.notifyObserver();
        assertTrue(testObserver.called);
    }
}
