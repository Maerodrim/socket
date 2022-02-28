package com.ssau.socket.dto;

import com.ssau.socket.model.ByteArrayOfImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhotoDTO{
    private ByteArrayOfImage photo;
    private File photoFile;
}
