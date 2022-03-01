package com.ssau.socket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    @JsonProperty("byteOfImage")
    private byte[] byteOfImage;

    //private File photoFile;
    @JsonSerialize(using= com.ssau.socket.utils.ByteArraySerializer.class)
    public byte[] getByteOfImage() {
        return byteOfImage;
    }
}
