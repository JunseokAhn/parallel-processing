import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Utils {
    public static List<String> urls = List.of("http://example.com", "http://example.org", "http://example.net");

    /**
     * url에서 전체 문자열을 읽은 뒤 스트림을 종료
     */
    public static String downloadContent(String url) {
        try (Scanner scanner = new Scanner(new URL(url).openStream())) {
            return scanner.useDelimiter("\\A").next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 단어 빈도 분석
     */
    public static Map<String, Integer> analyzeWordFrequency(String content) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = content.split("\\W+");
        for (String word : words) {
            wordFrequency.merge(word.toLowerCase(), 1, Integer::sum);
        }
        return wordFrequency;
    }
}
