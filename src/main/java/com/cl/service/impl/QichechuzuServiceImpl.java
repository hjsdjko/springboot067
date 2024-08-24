package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.QichechuzuDao;
import com.cl.entity.QichechuzuEntity;
import com.cl.service.QichechuzuService;
import com.cl.entity.view.QichechuzuView;

@Service("qichechuzuService")
public class QichechuzuServiceImpl extends ServiceImpl<QichechuzuDao, QichechuzuEntity> implements QichechuzuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QichechuzuEntity> page = this.selectPage(
                new Query<QichechuzuEntity>(params).getPage(),
                new EntityWrapper<QichechuzuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QichechuzuEntity> wrapper) {
		  Page<QichechuzuView> page =new Query<QichechuzuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QichechuzuView> selectListView(Wrapper<QichechuzuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QichechuzuView selectView(Wrapper<QichechuzuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<QichechuzuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<QichechuzuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<QichechuzuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
