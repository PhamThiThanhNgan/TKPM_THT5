package com.example.springapiphamthithanhngan.Controller;

import com.example.springapiphamthithanhngan.Service.MayBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MayBayController {
    @Autowired
    MayBayRepository mayBayRepository;
    //Câu 2
    @RequestMapping(value = "/maybaycotambaylonhon10000", method = RequestMethod.GET)
    public List<String> mayBayCoTamBayLonHon10000(){
        List<String> mayBays = mayBayRepository.findLoaiMayBayByTamBay();
        if(mayBays == null){
            ResponseEntity.notFound().build();
        }
        return mayBays;
    }
    //Câu 7
    @RequestMapping(value = "/soloaimaybayboeing", method = RequestMethod.GET)
    public String soLoaiMayBayBoeing(){
        int soLoaiMayBay = mayBayRepository.findLoaiMayBay();
        if(soLoaiMayBay == 0){
            ResponseEntity.notFound().build();
        }
        return  "Có " + soLoaiMayBay + " loại máy bay Boeing";
    }
    //Câu 11
    @RequestMapping(value = "/timmamaybaytheoho/{hoNV}", method = RequestMethod.GET)
    public List<Integer> nhanVienLaiMayBay747(@PathVariable("hoNV") String hoNV){
        List<Integer> maMayBays = mayBayRepository.getMaMBByTenNV(hoNV);
        if(maMayBays == null){
            ResponseEntity.notFound().build();
        }
        return  maMayBays;
    }
    // Câu 13
    @RequestMapping(value = "/loaimaybaydichuyenvn280/{maCB}", method = RequestMethod.GET)
    public List<String> maPhiCongVuaLaiBoeingVuaLaiAirbus(@PathVariable("maCB") String maCB){
        List<String> loaiMBs = mayBayRepository.loaiMayBayChuyenVN280(maCB);
        if(loaiMBs == null){
            ResponseEntity.notFound().build();
        }
        return  loaiMBs;
    }
    //Câu 16
    @RequestMapping(value = "/demsophiconglaimaybay", method = RequestMethod.GET)
    public List<Map<String, Object>> demSoPhiCongLaiMayBay(){
        List<Map<String, Object>> mayBays = mayBayRepository.demSoPhiCongLaiMayBay();
        if(mayBays== null){
            ResponseEntity.notFound().build();
        }
        return  mayBays;
    }
}
