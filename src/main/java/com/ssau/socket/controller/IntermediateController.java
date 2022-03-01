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

@RestController
@RequestMapping("/intermediate")
@RequiredArgsConstructor
public class IntermediateController {
    private PhotoService photoService;
    private Bluer bluer = new BluerImpl();

    @Autowired
    public IntermediateController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public void sendPhoto(@RequestBody PhotoDTO body) throws Exception {
        ByteArrayOfImage byteArrayOfImage = new ByteArrayOfImage(bluer.saltPepper(body.getByteOfImage()));
        photoService.sendResponse(new PhotoDTO(byteArrayOfImage.getByteOfImage()), "http://localhost:8081/client/start");
    }
}
