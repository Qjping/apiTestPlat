package apiTestPlat.dataobject.mapper;

import apiTestPlat.dataobject.vo1.CaseDetailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface CaseDetailMapper {

     public  int save(List<CaseDetailVO> caseDetailVO);

     public CaseDetailVO selectById(Integer id);
}
