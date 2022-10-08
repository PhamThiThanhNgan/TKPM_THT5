package com.example.springapiphamthithanhngan.Service;

import com.example.springapiphamthithanhngan.Entity.ChuyenBay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChuyenBayRepository extends CrudRepository<ChuyenBay, String> {
    @Query("select cb from ChuyenBay cb where cb.gaDen = ?1")
    List<ChuyenBay> findChuyenBayByGaDen(String gaDen);
}