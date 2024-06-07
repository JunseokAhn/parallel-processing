import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<String> urls = List.of("http://example.com", "http://example.org", "http://example.net");

    /**
     * url에서 전체 문자열을 읽은 뒤 스트림을 종료
     */
    public static String downloadContent(String url) throws IOException {
        try (Scanner scanner = new Scanner(new URL(url).openStream())) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
