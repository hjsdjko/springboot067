package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.QicherukuEntity;
import com.cl.entity.view.QicherukuView;

import com.cl.service.QicherukuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 汽车入库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 16:40:21
 */
@RestController
@RequestMapping("/qicheruku")
public class QicherukuController {
    @Autowired
    private QicherukuService qicherukuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QicherukuEntity qicheruku,
		HttpServletRequest request){
        EntityWrapper<QicherukuEntity> ew = new EntityWrapper<QicherukuEntity>();

		PageUtils page = qicherukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicheruku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QicherukuEntity qicheruku, 
		HttpServletRequest request){
        EntityWrapper<QicherukuEntity> ew = new EntityWrapper<QicherukuEntity>();

		PageUtils page = qicherukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicheruku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QicherukuEntity qicheruku){
       	EntityWrapper<QicherukuEntity> ew = new EntityWrapper<QicherukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qicheruku, "qicheruku")); 
        return R.ok().put("data", qicherukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QicherukuEntity qicheruku){
        EntityWrapper< QicherukuEntity> ew = new EntityWrapper< QicherukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qicheruku, "qicheruku")); 
		QicherukuView qicherukuView =  qicherukuService.selectView(ew);
		return R.ok("查询汽车入库成功").put("data", qicherukuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QicherukuEntity qicheruku = qicherukuService.selectById(id);
		qicheruku = qicherukuService.selectView(new EntityWrapper<QicherukuEntity>().eq("id", id));
        return R.ok().put("data", qicheruku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QicherukuEntity qicheruku = qicherukuService.selectById(id);
		qicheruku = qicherukuService.selectView(new EntityWrapper<QicherukuEntity>().eq("id", id));
        return R.ok().put("data", qicheruku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QicherukuEntity qicheruku, HttpServletRequest request){
    	qicheruku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qicheruku);
        qicherukuService.insert(qicheruku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QicherukuEntity qicheruku, HttpServletRequest request){
    	qicheruku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qicheruku);
        qicherukuService.insert(qicheruku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QicherukuEntity qicheruku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qicheruku);
        qicherukuService.updateById(qicheruku);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qicherukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
