package com.example.jpaspringtestphamthithanhngan.Entity;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chungnhan")
@IdClass(ChungNhanPK.class)
public class ChungNhan {
    @Id
    @ManyToOne
    @JoinColumn(name = "manv", columnDefinition = "varchar(10)")
    public NhanVien MaNV;

    @Id
    @ManyToOne
    @JoinColumn(name = "mamb", columnDefinition = "int")
    public MayBay MaMB;
}
