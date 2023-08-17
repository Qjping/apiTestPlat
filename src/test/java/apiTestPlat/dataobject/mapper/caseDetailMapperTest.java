package apiTestPlat.dataobject.mapper;

import apiTestPlat.dataobject.vo1.CaseDetailVO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class caseDetailMapperTest {

    @Autowired
    CaseDetailMapper caseDetailMapper;
    @org.testng.annotations.Test
    public void testSave() {
    }

    @org.testng.annotations.Test
    public void testSelectById() {
        System.out.println(1);
            caseDetailMapper.selectById(1);

        CaseDetailVO caseDetailVO = new CaseDetailVO();
        caseDetailVO.setUrl("www.baidu.com");
        caseDetailVO.setData("test");
        caseDetailVO.setMethod("GET");
        caseDetailVO.setCreatedBy("sys");
        List<CaseDetailVO>list= new ArrayList<>();
        list.add(caseDetailVO);

        caseDetailMapper.save(list);

    }

}