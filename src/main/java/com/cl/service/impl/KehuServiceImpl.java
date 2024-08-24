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


import com.cl.dao.KehuDao;
import com.cl.entity.KehuEntity;
import com.cl.service.KehuService;
import com.cl.entity.view.KehuView;

@Service("kehuService")
public class KehuServiceImpl extends ServiceImpl<KehuDao, KehuEntity> implements KehuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KehuEntity> page = this.selectPage(
                new Query<KehuEntity>(params).getPage(),
                new EntityWrapper<KehuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KehuEntity> wrapper) {
		  Page<KehuView> page =new Query<KehuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KehuView> selectListView(Wrapper<KehuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KehuView selectView(Wrapper<KehuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<KehuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<KehuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<KehuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
