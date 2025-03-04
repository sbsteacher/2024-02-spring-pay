package com.green.greengram;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasicTest {

    String uploadPath = "D:/2024-02/download/greengram_jpa";

    @Test
    void fileTest() {
        String path = "dddd/ffff/abc.jpg";
        File f = new File(uploadPath, path);
        System.out.printf("origin-file: %s\n", f.getAbsolutePath());

        Path transPath = Paths.get(String.format("%s/%s", uploadPath, path)).toAbsolutePath();
        System.out.printf("transPath: %s\n", transPath.toString());

        File file = transPath.toFile();
        System.out.printf("path-file: %s\n", file.getAbsolutePath());
    }
}
