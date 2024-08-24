package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QicherukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QicherukuView;


/**
 * 汽车入库
 *
 * @author 
 * @email 
 * @date 2024-04-08 16:40:21
 */
public interface QicherukuService extends IService<QicherukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QicherukuView> selectListView(Wrapper<QicherukuEntity> wrapper);
   	
   	QicherukuView selectView(@Param("ew") Wrapper<QicherukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QicherukuEntity> wrapper);
   	

}

