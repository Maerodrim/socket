package com.ssau.socket.service;

import com.ssau.socket.dto.PhotoDTO;
import com.ssau.socket.model.ByteArrayOfImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoService {
    final RestTemplate restTemplate = new RestTemplate();
    final String stringPosts = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts?_limit=10", String.class);

    public PhotoDTO getPhoto() throws IOException {
        System.out.println("Client has started");
        File input = new File("image.jpg");
        BufferedImage inputImg = ImageIO.read(input);
        ByteArrayOfImage baoi = new ByteArrayOfImage(inputImg);
            /*byte[] outBaoiByte = bluer.blurring(baoi.getByteOfImage());
            ByteArrayOfImage outBaoi  = new ByteArrayOfImage(outBaoiByte);
            BufferedImage outputImg = outBaoi.getBufferedImage();

            ImageIO.write(outputImg, "jpg", output);
            ImageIO.write(inputImg, "jpg", output2);
            ImageIO.write(outputImg, "jpg", output3);*/
        return new PhotoDTO(baoi, input);
    }

    public void sendResponse(PhotoDTO photo, String url) throws IOException {
        PhotoDTO postToInsert = photo;
        final PhotoDTO insertedPost = restTemplate.postForObject(url, postToInsert, PhotoDTO.class);
    }
}
