package com.ssau.socket.controller;

import com.ssau.socket.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerController {
    private PhotoService photoService;

    @Autowired
    public ServerController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public void sendPhoto() throws Exception {
        photoService.sendResponse(photoService.getPhoto(),"http://localhost:8081/intermediate/start");
    }
}
