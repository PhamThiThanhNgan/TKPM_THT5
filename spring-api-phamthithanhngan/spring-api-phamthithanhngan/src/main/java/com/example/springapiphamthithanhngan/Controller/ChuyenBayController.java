package com.example.springapiphamthithanhngan.Controller;

import com.example.springapiphamthithanhngan.Entity.ChuyenBay;
import com.example.springapiphamthithanhngan.Service.ChuyenBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ChuyenBayController {
    @Autowired
    ChuyenBayRepository chuyenBayRepository;
    //Câu 1
    @RequestMapping(value = "/timchuyenbayboigaden/{gaden}", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiGaDen(@PathVariable("gaden") String gaDen){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByGaDen(gaDen);
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }
    //Câu 4
    @RequestMapping(value = "/timchuyenbayboidodai", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiDoDai(){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByDoDai();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }
    //Câu 5
    @RequestMapping(value = "/timchuyenbayboigadenvagadi", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiGaDenVaGaDi(){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByGaDiVaGaDen();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }
    //Câu 6
    @RequestMapping(value = "/sochuyenbayxuatphattusaigon/{gaDi}", method = RequestMethod.GET)
    public String soChuyenBayXuatPhatTuSaiGon(@PathVariable("gaDi") String gaDi){
        int soChuyenBay = chuyenBayRepository.findChuyenBayByGaDi(gaDi);
        if(soChuyenBay == 0){
            ResponseEntity.notFound().build();
        }
        return  "Có " + soChuyenBay + " chuyến bay xuất phát từ Sài Gòn";
    }
    // Câu 14
    @RequestMapping(value = "/chuyenbaythuchienboiairbusa320/{loaiMB}", method = RequestMethod.GET)
    public List<ChuyenBay> chuyenBayThucHienBoiAirbusA320(@PathVariable("loaiMB") String loaiMB){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByMayBayAirbusA320(loaiMB);
        if(chuyenBays == null || chuyenBays.size() == 0){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
    //Câu 17
    @RequestMapping(value = "/timchuyenbayditugaadengabvelaigaa", method = RequestMethod.GET)
    public List<ChuyenBay> timCBDiTuGaADenBVeLaiA(){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findCBDiTuGaADenBVeLaiA();
        if(chuyenBays== null){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
    //Câu 18
    @RequestMapping(value = "/demchuyenbayditugaadenbvelaia", method = RequestMethod.GET)
    public List<Map<String, Object>> countCBDiTuGaADenBVeLaiGaA(){
        List<Map<String, Object>> chuyenBays = chuyenBayRepository.countCBDiTuGaADenBVeLaiA();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
}
