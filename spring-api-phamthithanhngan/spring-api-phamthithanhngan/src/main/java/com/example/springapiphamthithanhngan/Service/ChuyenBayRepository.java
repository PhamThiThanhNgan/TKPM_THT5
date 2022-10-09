package com.example.springapiphamthithanhngan.Service;

import com.example.springapiphamthithanhngan.Entity.ChuyenBay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChuyenBayRepository extends CrudRepository<ChuyenBay, String> {
    @Query("select cb from ChuyenBay cb where cb.gaDen = ?1")
    List<ChuyenBay> findChuyenBayByGaDen(String gaDen);
    @Query("select cb from ChuyenBay cb where cb.doDai between 8000 and 10000")
    List<ChuyenBay> findChuyenBayByDoDai();
    @Query("select cb from ChuyenBay cb where cb.gaDi = 'SGN' and cb.gaDen = 'BMV'")
    List<ChuyenBay> findChuyenBayByGaDiVaGaDen();
    @Query("select count(cb) from ChuyenBay cb where cb.gaDi = ?1")
    int findChuyenBayByGaDi(String gaDi);
    @Query("select cb from ChuyenBay cb " +
            "where cb.doDai <= (select mb.tamBay from MayBay mb where mb.loai = ?1)")
    List<ChuyenBay> findChuyenBayByMayBayAirbusA320(String loaiMB);
}
