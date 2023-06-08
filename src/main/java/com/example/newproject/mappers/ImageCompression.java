package com.example.newproject.mappers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCompression {
    public static void compressImage(String inputPath, String outputPath, float compressionQuality) {
        try {
            // Read the input image
            BufferedImage image = ImageIO.read(new File(inputPath));

            // Create the output file
            File outputFile = new File(outputPath);

            // Compress the image
            ImageIO.write(image, "jpg", outputFile);

            // Set compression quality
            ImageIO.write(image, "jpg", outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputPath1 = "../static/images/main-slider/slide3.jpg";
        String outputPath1 = "../static/images/main-slider/compressed_slide3.jpg";
        String inputPath2 = "../static/images/main-slider/slide1.jpg";
        String outputPath2 = "../static/images/main-slider/compressed_slide1.jpg";
        String inputPath3 = "../static/images/main-slider/slide2.jpg";
        String outputPath3 = "../static/images/main-slider/compressed_slide2.jpg";

        float compressionQuality = 0.5f; // 0.0 - 1.0

        // Compress each image
        compressImage(inputPath1, outputPath1, compressionQuality);
        compressImage(inputPath2, outputPath2, compressionQuality);
        compressImage(inputPath3, outputPath3, compressionQuality);
    }
}