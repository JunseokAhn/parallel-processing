import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadExample implements MyExample {

    @Override
    public ConcurrentHashMap<String, Map<String, Integer>> run() {

        ConcurrentHashMap<String, Map<String, Integer>> results = new ConcurrentHashMap<>();

        Thread[] threads = new Thread[Utils.urls.size()];
        for (int i = 0; i < Utils.urls.size(); i++) {
            String url = Utils.urls.get(i);
            threads[i] = new Thread(() -> {
                try {
                    String content = Utils.downloadContent(url);
                    Map<String, Integer> wordFrequency = analyzeWordFrequency(content);
                    results.put(Thread.currentThread().getName() + ": " + url, wordFrequency);
                } catch (IOException e) {
                    e.printStackTrace();
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

    @Override
    public Map<String, Integer> analyzeWordFrequency(String content) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = content.split("\\W+");
        synchronized (this) { // synchronized블럭을 지우고 ConcurrentHashMap을 사용해도 됨.
            for (String word : words) {
                wordFrequency.merge(word.toLowerCase(), 1, Integer::sum);
            }
        }
        return wordFrequency;
    }
}
