package com.ssau.socket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssau.socket.model.ByteArrayOfImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoDTO implements Serializable {
    private ByteArrayOfImage photo;
    private File photoFile;
}
