package com.sheldonhh.callable;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

// 3rd way to create Thread
public class TestCallable implements Callable<Boolean> {
     private String url;
     private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloadeer = new WebDownloader();
        webDownloadeer.downloader(url,name);
        System.out.println("FileName to download: "+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://pbs.twimg.com/media/FHcV5uuagAAKrz6?format=jpg&name=medium", "Japan.png");
        TestCallable t2 = new TestCallable("https://pbs.twimg.com/media/FHdksshXMAsVQBs?format=jpg&name=medium", "Cholate.png");
        TestCallable t3 = new TestCallable("https://pbs.twimg.com/media/FHfw6CGXwAA7aZR?format=jpg&name=small", "Banana.png");

        //1. Executor Service
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 2. submit execution
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        // 3. result
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        // 4. shutdown
        ser.shutdown();

    }

}
/*
1. ExecutorService ser = Executors.newFixedThreadPool(1);

2. Future<Boolean> r1= ser.submit(1);

3. boolean r1 = result1.get()l

4. ser.shutdownNow()
 */
class WebDownloader{
    public void downloader(String url, String name){

        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        }

    }
}
