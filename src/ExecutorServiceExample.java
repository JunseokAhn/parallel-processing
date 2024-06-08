import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class ExecutorServiceExample implements MyExample {
    @Override
    public HashMap<String, Map<String, Integer>> run() {

        HashMap<String, Map<String, Integer>> results = new HashMap<>();
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            Lock lock = new ReentrantLock();
            List<Future<?>> futures = Utils.urls.stream().map(url -> executorService.submit(() -> {
                String content = Utils.downloadContent(url);
                Map<String, Integer> wordFrequency = Utils.analyzeWordFrequency(content);
                lock.lock(); // lock사용할필요없이 ConcurrentHashMap을 사용해도 됨.
                try {
                    results.put(Thread.currentThread().getName() + ": " + url, wordFrequency);
                } finally {
                    lock.unlock();
                }
                return null;
            })).collect(Collectors.toList());

            for (Future<?> future : futures) {
                future.get(); // 명시적 블로킹 -> 모든 스레드가 종료될 때까지 대기
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return results;
    }
}
