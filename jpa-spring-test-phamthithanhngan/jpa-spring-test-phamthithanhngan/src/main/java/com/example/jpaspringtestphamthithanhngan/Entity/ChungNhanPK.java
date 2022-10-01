package com.example.jpaspringtestphamthithanhngan.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ChungNhanPK implements Serializable {
    public String maNV;
    public int maMB;
}
