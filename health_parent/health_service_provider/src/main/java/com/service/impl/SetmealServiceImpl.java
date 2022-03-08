package com.service.impl;

/**
 * 体检套餐服务
 **/

import com.alibaba.dubbo.config.annotation.Service;
import com.constant.RedisConstant;
import com.dao.CheckGroupDao;
import com.dao.SetmealDao;
import com.entity.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pojo.CheckItem;
import com.pojo.Setmeal;
import com.service.SetmealService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import redis.clients.jedis.JedisPool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {
	@Autowired
	private SetmealDao setmealDao;
	@Autowired
	private JedisPool jedisPool;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	//从属性文件读取输出目录的路径
	@Value("${out_put_path}")
    private String outputPath;

	//新增套餐
	public void add(Setmeal setmeal, Integer[] checkgroupIds) {
		setmealDao.add(setmeal);
		if(checkgroupIds != null && checkgroupIds.length > 0){
			//绑定套餐和检查组的多对多关系
			setSetmealAndCheckGroup(setmeal.getId(),checkgroupIds);
		}
		//将图片名称保存到Redis
		savePic2Redis(setmeal.getImg());

		//当条件套餐后需要重新生成静态页面（套餐列表页面、套餐详情页面）
         generateMobileStaticHtml();

	}

	//生成当前方法所需的静态页面
	public void generateMobileStaticHtml() {
		//在生成静态页面之前需要查询所有数据
		List<Setmeal> list = setmealDao.findAll();
		//需要生成套餐列表静态页面
         generateMobileSetmealListHtml(list);
		//需要生成套餐详情页面
		generateMobileSetmealDetailHtml(list);
	}
	//生成套餐列表静态页面
	public void generateMobileSetmealListHtml(List<Setmeal> setmealList) {
       Map map = new HashMap();
       //为模板提供数据，用于生成静态页面
       map.put("setmealList", setmealList);
       generateHtml("mobile_setmeal.ftl","m_setmeal.html",map);
	}

	//生成套餐详情静态页面（多个）
	public void generateMobileSetmealDetailHtml(List<Setmeal> setmealList) {
		for (Setmeal setmeal : setmealList) {
			Map map = new HashMap();
			map.put("setmeal", this.findById(setmeal.getId()));
			this.generateHtml("mobile_setmeal_detail.ftl",
					"setmeal_detail_"+setmeal.getId()+".html",
					map);

		}
	}

	//用于生成静态页面
	public void generateHtml(String templateName,String htmlPageName,Map map){
         //获得配置对象
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		Writer out = null;
		try {
			Template template = configuration.getTemplate(templateName);
			//构造输出流
            out = new FileWriter(new File(outputPath+"/"+htmlPageName));
            //输出文件
			template.process(map, out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
		PageHelper.startPage(currentPage,pageSize);
		Page<Setmeal> page = setmealDao.findByCondition(queryString);
		return new PageResult(page.getTotal(),page.getResult());
	}

	public List<Setmeal> findAll() {
		return setmealDao.findAll();
	}

	//根据套餐ID查询套餐详情（套餐基本信息，套餐对应的检查组信息，检查组对应的检查项信息）
	public Setmeal findById(int id) {
		return setmealDao.findById(id);
	}

	public List<Map<String, Object>> findSetmealCount() {
		return setmealDao.findSetmealCount();
	}

	//将图片名称保存到Redis
	private void savePic2Redis(String pic){
		jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES,pic);
	}
	//绑定套餐和检查组的多对多关系
	private void setSetmealAndCheckGroup(Integer id, Integer[] checkgroupIds) {
		for (Integer checkgroupId : checkgroupIds) {
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("setmeal_id",id);
			map.put("checkgroup_id",checkgroupId);
			setmealDao.setSetmealAndCheckGroup(map);
		}
	}
}