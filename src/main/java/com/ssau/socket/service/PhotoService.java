package com.ssau.socket.service;

import com.ssau.socket.dto.PhotoDTO;
import com.ssau.socket.model.ByteArrayOfImage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoService {
    final RestTemplate restTemplate = new RestTemplate();

    public PhotoDTO getPhoto() throws IOException {
        System.out.println("Client has started");
        File input = new File("image.jpg");
        BufferedImage inputImg = ImageIO.read(input);
        ByteArrayOfImage baoi = new ByteArrayOfImage(inputImg);
        return new PhotoDTO(baoi, input);
    }

    public void sendResponse(PhotoDTO photo, String url){
        PhotoDTO postToInsert = photo;
        //restTemplate.postForEntity(url, postToInsert, PhotoDTO.class);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("imagefile", photo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, request, String.class);
        System.out.println(stringResponseEntity.toString());
    }
}
