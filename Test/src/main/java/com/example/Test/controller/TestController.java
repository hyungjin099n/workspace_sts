package com.example.Test.controller;

import com.example.Test.service.TestService;
import com.example.Test.vo.EmpVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.naming.Name;
import java.util.List;

@Controller
public class TestController {
    @Resource(name = "testService")
    private TestService testService;

    @GetMapping("/")
    public String main(){
        List<EmpVO> empList = testService.selectEmpList();

        for(EmpVO vo : empList){
            System.out.println(vo);
        }


        System.out.println("!!!" + empList.size());



        return "main";
    }

}
