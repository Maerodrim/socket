package com.ssau.socket.controller;

import com.ssau.socket.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private PhotoService photoService;

    @Autowired
    public ClientController(PhotoService photoService) {
        this.photoService = photoService;
    }
}
