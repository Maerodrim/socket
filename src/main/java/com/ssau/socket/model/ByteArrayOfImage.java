package com.ssau.socket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ssau.socket.utils.ByteArraySerializer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class ByteArrayOfImage implements Serializable {
    @JsonProperty("byteOfImage")
    private byte[] byteOfImage;

    public ByteArrayOfImage(byte[] byteOfImage) {
        this.byteOfImage = byteOfImage;
    }

    public ByteArrayOfImage(BufferedImage image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            byteOfImage = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() {
        try {
            return ImageIO.read(new ByteArrayInputStream(byteOfImage));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @JsonSerialize(using= com.ssau.socket.utils.ByteArraySerializer.class)
    public byte[] getByteOfImage() {
        return byteOfImage;
    }

    @Override
    public String toString() {
        return "ByteArrayOfImage{" +
                "byteOfImage=" + Arrays.toString(byteOfImage) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ByteArrayOfImage that = (ByteArrayOfImage) o;
        return Arrays.equals(byteOfImage, that.byteOfImage);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(byteOfImage);
    }
}
