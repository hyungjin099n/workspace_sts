package com.example.FetchStudent.service;

import com.example.FetchStudent.vo.ClassVO;
import com.example.FetchStudent.vo.ScoreVO;
import com.example.FetchStudent.vo.StuVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stuService")
public class StuServiceImpl implements StuService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<ClassVO> selectClassList() {
        return sqlSession.selectList("stuMapper.selectClassList");
    }

    @Override
    public List<StuVO> selectStuList(StuVO stuVO) {
        return sqlSession.selectList("stuMapper.selectStuList", stuVO);
    }

    @Override
    public StuVO selectStuDetail(int stuNum) {
        return sqlSession.selectOne("stuMapper.selectStuDetail", stuNum);
    }

    @Override
    public ScoreVO selectScoreInfo(int stuNum) {
        return sqlSession.selectOne("stuMapper.selectScoreInfo", stuNum);
    }

    @Override
    public void insertScore(ScoreVO scoreVO) {
        sqlSession.insert("stuMapper.insertScore", scoreVO);
    }
}
