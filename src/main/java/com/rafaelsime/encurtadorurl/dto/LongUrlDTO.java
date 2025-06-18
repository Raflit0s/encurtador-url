package com.rafaelsime.encurtadorurl.dto;

import com.rafaelsime.encurtadorurl.entities.LongUrl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class LongUrlDTO {

    private String id;
    private String longUrl;

    public LongUrlDTO(LongUrl entity) {
        id = entity.getId();
        longUrl = entity.getLongUrl();
    }

    @Override
    public String toString() {
        return "LongUrlDTO2{" +
                "id='" + id + '\'' +
                ", longUrl='" + longUrl + '\'' +
                '}';
    }
}
