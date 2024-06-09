import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class ParallelStreamExample implements MyExample {
    @Override
    public HashMap<String, Map<String, Integer>> run() {

        HashMap<String, Map<String, Integer>> results = new HashMap<>();
        Semaphore semaphore = new Semaphore(1);
        Utils.urls.parallelStream().forEach(url -> {
            String content = Utils.downloadContent(url);
            Map<String, Integer> wordFrequency = Utils.analyzeWordFrequency(content);

            boolean acquired = false;
            try {
                while (acquired == false) {
                    semaphore.acquire();
                    acquired = true;
                    results.put(Thread.currentThread().getName() + ": " + url, wordFrequency);
                }
            } catch (InterruptedException e1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
                Thread.currentThread().interrupt();
            } finally {
                if (acquired == true) {
                    semaphore.release();
                }
            }
        });
        return results;
    }
}
