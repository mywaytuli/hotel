package cn.ahut.sys.foodtype.action;

import java.util.Map;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ahut.sys.foodtype.entity.FoodType;
import cn.ahut.sys.foodtype.service.IFoodTypeService;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 菜系的控制层
 * @author Dell
 */

@Controller
@Scope("prototype")
public class FoodTypeAction extends ActionSupport{
	@Resource
	private IFoodTypeService foodTypeService;
	private FoodType foodType;
	private String keyword;
	
	private PageResult pageResult;
	private int pageNo;
	private int pageSize;
	//默认页大小
	public static int DEFAULT_PAGE_SIZE = 5;
	
	
	/**
	 * 菜系列表展示
	 */
	public String list() throws Exception {
		try{
//			List<FoodType> foodTypeList = foodTypeService.getAll();
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
//			request.put("foodTypeList", foodTypeList);
			QueryHelper queryHelper = new QueryHelper(FoodType.class, "f");
			pageResult = foodTypeService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("pageResult", pageResult);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * 添加菜系
	 */
	public String add() throws Exception{
		if(foodType!=null){
			foodTypeService.save(foodType);
		}
		return "add";
	}
	
	/**
	 * 进入更新页面
	 */
	public String updateView() throws Exception{
		if(foodType!=null&&foodType.getId()!=null){
			FoodType ft = foodTypeService.findById(foodType.getId());
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("foodType", ft);
		}
		return "updateView";
	}
	
	/**
	 * 更新菜系
	 */
	public String update() throws Exception{
		if(foodType!=null&&foodType.getId()!=null){
			foodTypeService.update(foodType);
		}
		return "update";
	}
	
	
	/**
	 * 菜系删除
	 */
	public String delete() throws Exception{
		if(foodType!=null&&foodType.getId()!=null){
			foodTypeService.delete(foodType.getId());
		}
		return "delete";
	}

	/**
	 * 根据关键字搜索
	 */
	public String search() throws Exception{
		if(keyword!=null){
			QueryHelper queryHelper = new QueryHelper(FoodType.class, "f");
			queryHelper.addCondition("f.typeName like ?", "%"+keyword+"%");
//			List<FoodType> foodTypeList = foodTypeService.getAll(queryHelper);
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
//			request.put("foodTypeList", foodTypeList);
			pageResult = foodTypeService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("pageResult", pageResult);
		}
		return "search";
	}
	
	
	
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	public FoodType getFoodType() {
		return foodType;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getKeyword() {
		return keyword;
	}
	public PageResult getPageResult() {
		return pageResult;
	}
	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		if (pageSize<1) pageSize=DEFAULT_PAGE_SIZE;
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
