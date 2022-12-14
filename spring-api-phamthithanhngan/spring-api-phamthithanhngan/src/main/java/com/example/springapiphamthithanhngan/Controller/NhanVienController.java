package com.example.springapiphamthithanhngan.Controller;

import com.example.springapiphamthithanhngan.Entity.NhanVien;
import com.example.springapiphamthithanhngan.Service.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NhanVienController {
    @Autowired
    NhanVienRepository nhanVienRepository;
    //Câu 3
    @RequestMapping(value = "/timnhanvientheoluong", method = RequestMethod.GET)
    public List<NhanVien> timNhanVienTheoLuong(){
        List<NhanVien> nhanViens = nhanVienRepository.findNhanVienByLuong();
        if(nhanViens == null){
            ResponseEntity.notFound().build();
        }
        return nhanViens;
    }
    //Câu 8
    @RequestMapping(value = "/tongsoluongnhanvien", method = RequestMethod.GET)
    public String tongSoLuongNhanVien(){
        int soLuong = nhanVienRepository.tinhTongLuong();
        if(soLuong == 0){
            ResponseEntity.notFound().build();
        }
        return  "Tổng số lương phải trả cho các nhân viên là " + soLuong;
    }
    //Câu 9
    @RequestMapping(value = "/manhanvienlaimaybayboeing", method = RequestMethod.GET)
    public List<String> maNhanVienLaiMayBayBoeing(){
        List<String> maNhanViens = nhanVienRepository.getMaByLoaiMayBay();
        if(maNhanViens == null){
            ResponseEntity.notFound().build();
        }
        return  maNhanViens;
    }
    //Câu 10
    @RequestMapping(value = "/nhanvienlaimaybay747/{maMB}", method = RequestMethod.GET)
    public List<NhanVien> nhanVienLaiMayBay747(@PathVariable("maMB") int maMB){
        List<NhanVien> nhanViens = nhanVienRepository.findNhanVienByMaMB(maMB);
        if(nhanViens == null){
            ResponseEntity.notFound().build();
        }
        return  nhanViens;
    }
    //Câu 12
    @RequestMapping(value = "/maphicongvualaiboeingvaairbus", method = RequestMethod.GET)
    public List<String> maPhiCongVuaLaiBoeingVuaLaiAirbus(){
        List<String> maPhiCongs = nhanVienRepository.getMaByLoaiMB();
        if(maPhiCongs == null){
            ResponseEntity.notFound().build();
        }
        return  maPhiCongs;
    }
    //Câu 15
    @RequestMapping(value = "/phiconglaimaybayboeing", method = RequestMethod.GET)
    public List<String> phiCongLaiMayBayBoeing(){
        List<String> tenPhiCongs = nhanVienRepository.findTenNhanVienLaiBoeing();
        if(tenPhiCongs == null){
            ResponseEntity.notFound().build();
        }
        return  tenPhiCongs;
    }
}
