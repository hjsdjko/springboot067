package com.cl.dao;

import com.cl.entity.QicherukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QicherukuView;


/**
 * 汽车入库
 * 
 * @author 
 * @email 
 * @date 2024-04-08 16:40:21
 */
public interface QicherukuDao extends BaseMapper<QicherukuEntity> {
	
	List<QicherukuView> selectListView(@Param("ew") Wrapper<QicherukuEntity> wrapper);

	List<QicherukuView> selectListView(Pagination page,@Param("ew") Wrapper<QicherukuEntity> wrapper);
	
	QicherukuView selectView(@Param("ew") Wrapper<QicherukuEntity> wrapper);
	

}
