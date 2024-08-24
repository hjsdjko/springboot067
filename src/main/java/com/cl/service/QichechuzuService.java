package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QichechuzuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QichechuzuView;


/**
 * 汽车出租
 *
 * @author 
 * @email 
 * @date 2024-04-08 16:40:20
 */
public interface QichechuzuService extends IService<QichechuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QichechuzuView> selectListView(Wrapper<QichechuzuEntity> wrapper);
   	
   	QichechuzuView selectView(@Param("ew") Wrapper<QichechuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QichechuzuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<QichechuzuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<QichechuzuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<QichechuzuEntity> wrapper);



}

