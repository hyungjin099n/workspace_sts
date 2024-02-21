package com.example.FetchStudent.controller;

import com.example.FetchStudent.service.StuServiceImpl;
import com.example.FetchStudent.vo.ClassVO;
import com.example.FetchStudent.vo.DetailVO;
import com.example.FetchStudent.vo.ScoreVO;
import com.example.FetchStudent.vo.StuVO;
import jakarta.annotation.Resource;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StuController {
    @Resource(name = "stuService")
    private StuServiceImpl stuService;

    @GetMapping("/")
    public String main(Model model, StuVO stuVO){
        //학급 목록 데이터 조회
        List<ClassVO> classList = stuService.selectClassList();
        model.addAttribute("classList", classList);

        //학생 목록 데이터 조회
        List<StuVO> stuList = stuService.selectStuList(stuVO);
        model.addAttribute("stuList", stuList);

        return "stu_manage";
    }

    @ResponseBody
    @PostMapping("/fetchSelect")
    public List<StuVO> fetchSelect(StuVO stuVO){
        //학생 목록 데이터 조회
        List<StuVO> stuList = stuService.selectStuList(stuVO);
        return stuList;
    }

    @ResponseBody
    @PostMapping("/detail")
    public DetailVO detail(@RequestParam(name = "stuNum") int stuNum){
        //클릭한 학생의 상세 정보 조회
        StuVO stuInfo = stuService.selectStuDetail(stuNum);

        //클릭한 학생의 점수 정보 조회
        ScoreVO scoreInfo = stuService.selectScoreInfo(stuNum);

        DetailVO result = new DetailVO();
        result.setStuVO(stuInfo);
        result.setScoreVO(scoreInfo);

        //조회한 데이터를 가지고 자바스크립트로 이동
        return result;
    }

    @ResponseBody
    @PostMapping("/insertScore")
    public void insertScore(ScoreVO scoreVO){
        stuService.insertScore(scoreVO);
    }

}
