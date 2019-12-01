package com.fh.dao;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Electric;
import com.fh.bean.vo.ElectricVo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
@CacheNamespace(size = 1024)
public interface ElectricDao extends BaseMapper<Electric> {
    List<ElectricVo> queryElectric();
}
