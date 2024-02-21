package com.green.shop.study.fetch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.shop.admin.service.AdminService;
import com.green.shop.admin.service.AdminServiceImpl;
import com.green.shop.item.service.ItemService;
import com.green.shop.item.service.ItemServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fetch")
public class FetchController {

    @GetMapping("/main")
    public String main(){
        return "test/fetch/main";
    }

    //넘어오는 데이터를 받을 때 사용하는 어노테이션
    //@RequestParam
    // - url에 데이터가 함께 넘어올 떄 사용
    // - ex ) localhost:8081/aaa?a=b
    // - form 태그를 사용
    //@RequestBody
    // - url이 아닌 body 영역에 데이터가 담겨서 올 때
    @ResponseBody
    @PostMapping("/fetch1")
    public void fetch1(@RequestBody MemberVO memberVO){
        System.out.println("fetch1 메서드 실행~");
        System.out.println(memberVO);
    }

    @ResponseBody
    @PostMapping("/fetch2")
    public void fetch2(@RequestBody HashMap<String, String> data){
        System.out.println("fetch2 메서드 실행~");
        System.out.println(data);
        System.out.println(data.get("id"));
        System.out.println(data.get("name"));
        System.out.println(data.get("age"));
    }

    //자바스크립에서 배열이 넘어오면 ArrayList 로 받을 수 있음.
    @ResponseBody
    @PostMapping("/fetch3")
    public void fetch3(@RequestBody ArrayList<MemberVO> list){
        System.out.println("fetch3 메서드 실행~");
        System.out.println(list);
    }

    @ResponseBody
    @PostMapping("/fetch4")
    public void fetch4(@RequestBody HashMap<String, Object> map){
        System.out.println("fetch4 메서드 실행~");
        System.out.println(map);
        //1. cartCode
        int cartCode = (int)map.get("cartCode");
        System.out.println(cartCode);
        //2. memberId
        HashMap<String, String> memberInfo = (HashMap<String, String>)map.get("memberInfo");
        String memberId = memberInfo.get("memberId");
        System.out.println(memberId);

        //두번쨰 이미지의 imgCode
        Map<String, Object> itemInfo = (Map<String, Object>)map.get("itemInfo");
        List<Object> imgList = (List<Object>)itemInfo.get("imgList");
        System.out.println(imgList);
        Map<String, Object> img = (Map<String, Object>)imgList.get(1);
        int imgCode = (int)img.get("imgCode");
        System.out.println(imgCode);

        //////////////////////////////////////////////////////////
        System.out.println();

        //map 데이터를 vo객체에 매핑하기
        ObjectMapper mapper = new ObjectMapper();
        MapDataVO data = mapper.convertValue(map, MapDataVO.class);
        System.out.println(data);


    }

}
