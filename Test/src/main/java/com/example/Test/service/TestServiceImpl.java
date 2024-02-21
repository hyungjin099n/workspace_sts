package com.example.Test.service;

import com.example.Test.vo.EmpVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<EmpVO> selectEmpList() {
        return sqlSession.selectList("empMapper.selectEmpList");
    }
}
