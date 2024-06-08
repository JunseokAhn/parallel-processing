import java.util.HashMap;
import java.util.Map;

public class ThreadExample implements MyExample {

    @Override
    public HashMap<String, Map<String, Integer>> run() {

        HashMap<String, Map<String, Integer>> results = new HashMap<>();

        Thread[] threads = new Thread[Utils.urls.size()];
        for (int i = 0; i < Utils.urls.size(); i++) {
            String url = Utils.urls.get(i);
            threads[i] = new Thread(() -> {
                String content = Utils.downloadContent(url);
                Map<String, Integer> wordFrequency = Utils.analyzeWordFrequency(content);
                synchronized (this) { // synchronized블럭을 지우고 ConcurrentHashMap을 사용해도 됨.
                    results.put(Thread.currentThread().getName() + ": " + url, wordFrequency);
                }
            });
            threads[i].start();
        }

        // 모든 스레드가 종료될 때까지 대기
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return results;
    }

}
