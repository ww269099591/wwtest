
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Crawlers {

    public static void main(String[] args) throws IOException, InterruptedException {
        int start = 0;
        int total = 23000;
        int threads = 20; // 线程数

        // 创建文件写入器
        BufferedWriter writer = new BufferedWriter(new FileWriter("crawled_results2.txt"));
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger errorCount = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < total; i++) {
            int index = start + i;
            executor.submit(() -> {
                try {
                    Document doc = Jsoup.connect("https://www.happydot.top/" + index + ".html")
                            .timeout(5000)
                            .get();

                    // 尝试提取页面标题作为示例
                    String title = ""+doc.childNodes().get(2).childNodes().get(3).childNodes().get(5).childNodes().get(3).childNodes().get(1).childNodes().get(3).childNodes().get(1).childNodes().get(1).childNodes().get(0);
                    String result = "Page " + index + ": " + title;
                    // 写入文件（需要同步）
                    synchronized (writer) {
                        writer.write(result);
                        writer.newLine();
                    }

                    successCount.incrementAndGet();
                    System.out.println("Success: " + index);
                } catch (Exception e) {
                    errorCount.incrementAndGet();
                    System.err.println("Error crawling page " + index + ": " + e.getMessage());
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.MINUTES);

        // 关闭文件写入器
        writer.write("Crawling completed. Success: " + successCount.get() + ", Errors: " + errorCount.get());
        writer.newLine();
        writer.close();

        System.out.println("Crawling completed. Success: " + successCount.get() + ", Errors: " + errorCount.get());
    }
}