import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface MyExample {


    ConcurrentHashMap<String, Map<String, Integer>> run();

    /**
     * 블로킹기법을 사용한 단어빈도분석
     */
    Map<String, Integer> analyzeWordFrequency(String content);
}
