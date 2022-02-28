package com.ssau.socket.controller;

import com.ssau.socket.dto.PhotoDTO;
import com.ssau.socket.model.ByteArrayOfImage;
import com.ssau.socket.service.Bluer;
import com.ssau.socket.service.PhotoService;
import com.ssau.socket.service.impl.BluerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private PhotoService photoService;
    private Bluer bluer = new BluerImpl();

    @Autowired
    public ClientController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public void validatePhoto(@RequestBody PhotoDTO body) throws Exception {
        File output = new File("image1.jpg");
        File output2 = new File("image2.jpg");
        byte[] outBaoiByte = bluer.blurring(body.getPhoto().getByteOfImage());
        ByteArrayOfImage outBaoi = new ByteArrayOfImage(outBaoiByte);
        BufferedImage outputImg = outBaoi.getBufferedImage();

        ImageIO.write(outputImg, "jpg", output);
        ByteArrayOfImage result = new ByteArrayOfImage(bluer.blurring(outBaoiByte));
        BufferedImage outputImg2 = result.getBufferedImage();
        ImageIO.write(outputImg2, "jpg", output2);
    }
}
