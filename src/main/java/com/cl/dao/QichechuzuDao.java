package com.cl.dao;

import com.cl.entity.QichechuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QichechuzuView;


/**
 * 汽车出租
 * 
 * @author 
 * @email 
 * @date 2024-04-08 16:40:20
 */
public interface QichechuzuDao extends BaseMapper<QichechuzuEntity> {
	
	List<QichechuzuView> selectListView(@Param("ew") Wrapper<QichechuzuEntity> wrapper);

	List<QichechuzuView> selectListView(Pagination page,@Param("ew") Wrapper<QichechuzuEntity> wrapper);
	
	QichechuzuView selectView(@Param("ew") Wrapper<QichechuzuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QichechuzuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QichechuzuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QichechuzuEntity> wrapper);



}
