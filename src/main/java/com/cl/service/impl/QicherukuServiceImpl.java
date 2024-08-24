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


import com.cl.dao.QicherukuDao;
import com.cl.entity.QicherukuEntity;
import com.cl.service.QicherukuService;
import com.cl.entity.view.QicherukuView;

@Service("qicherukuService")
public class QicherukuServiceImpl extends ServiceImpl<QicherukuDao, QicherukuEntity> implements QicherukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QicherukuEntity> page = this.selectPage(
                new Query<QicherukuEntity>(params).getPage(),
                new EntityWrapper<QicherukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QicherukuEntity> wrapper) {
		  Page<QicherukuView> page =new Query<QicherukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QicherukuView> selectListView(Wrapper<QicherukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QicherukuView selectView(Wrapper<QicherukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
