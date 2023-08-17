package apiTestPlat;

import apiTestPlat.dataobject.mapper.CaseDetailMapper;
import apiTestPlat.dataobject.vo1.CaseDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class apiTestPlatTest extends AbstractTestNGSpringContextTests {
    @Autowired
    CaseDetailMapper caseDetailMapper;
    @org.testng.annotations.Test
    public void testSave() {
    }

    @org.testng.annotations.Test
    public void testSelectById() {
        System.out.println(1);
        CaseDetailVO caseDetailV=caseDetailMapper.selectById(1);
        System.out.println(caseDetailV.getId());
        System.out.println(caseDetailV.getUrl());

        CaseDetailVO caseDetailVO = new CaseDetailVO();
        caseDetailVO.setUrl("www.baidu.com");
        caseDetailVO.setData("test");
        caseDetailVO.setMethod("GET");
        caseDetailVO.setCreatedBy("sys");
        List<CaseDetailVO> list= new ArrayList<>();
        list.add(caseDetailVO);
        caseDetailMapper.save(list);
    }
}
