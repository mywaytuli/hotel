package cn.ahut.sys.food.action;

import java.io.File;




import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ahut.sys.food.entity.Food;
import cn.ahut.sys.food.service.IFoodService;
import cn.ahut.sys.foodtype.entity.FoodType;
import cn.ahut.sys.foodtype.service.IFoodTypeService;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class FoodAction extends ActionSupport{

	@Resource
	private IFoodService foodService;
	@Resource
	private IFoodTypeService foodTypeService;
	
	private Food food;
	// ��Ӧ����<input type="file" name="img">
	private File img; 
	// �ļ���
	private String imgFileName;
	// �ļ�������(MIME)
	private String imgContentType;
	private String typeId;
	private String keyword;
	
	private PageResult pageResult;
	private int pageNo;
	private int pageSize;
	//Ĭ��ҳ��С
	public static int DEFAULT_PAGE_SIZE = 5;
	
	
	/**
	 * ��ϵ�б�չʾ
	 */
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		try{
			List<FoodType> foodTypeList = foodTypeService.getAll();
			ServletActionContext.getServletContext().setAttribute("foodTypeList", foodTypeList);
			//List<Food> foodList = foodService.getAll();
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			//request.put("foodList", foodList);
			QueryHelper queryHelper = new QueryHelper(Food.class, "f");
			pageResult = foodService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("pageResult", pageResult);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * ��Ӳ�ϵ
	 */
	public String add() throws Exception{
		try{
			if(food!=null&&imgFileName!=null){
				/******�õ��ϴ����ļ������д���******/
				// ���ļ��ϴ���uploadĿ¼
				
				// ��ȡ�ϴ���Ŀ¼·��
				String path = ServletActionContext.getServletContext().getRealPath("/upload/food");
				String fileName = UUID.randomUUID().toString().replaceAll("-", "") + imgFileName.substring(imgFileName.lastIndexOf("."));
				// ����Ŀ���ļ�����
				File destFile = new File(path,fileName);
				// ���ϴ����ļ���������Ŀ���ļ���
				FileUtils.copyFile(img, destFile);
				//���ò�Ʒͷ��·��
				food.setImg("food/" + fileName);
				food.setFoodType(foodTypeService.findById(typeId));
				foodService.save(food);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "add";
	}
	
	/**
	 * �������ҳ��
	 */
	public String updateView() throws Exception{
		if(food!=null&&food.getId()!=null){
			Food f = foodService.findById(food.getId());
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("food", f);
		}
		return "updateView";
	}
	
	/**
	 * ���²�ϵ
	 */
	public String update() throws Exception{
		try{
			if(food!=null&&food.getId()!=null){
				if(img!=null){
					// ��ȡ�ϴ���Ŀ¼·��
					String path = ServletActionContext.getServletContext().getRealPath("/upload/food");
					String fileName = UUID.randomUUID().toString().replaceAll("-", "") + imgFileName.substring(imgFileName.lastIndexOf("."));
					// ����Ŀ���ļ�����
					File destFile = new File(path,fileName);
					// ���ϴ����ļ���������Ŀ���ļ���
					FileUtils.copyFile(img, destFile);
					//���ò�Ʒͷ��·��
					food.setImg("food/" + fileName);
				}
				food.setFoodType(foodTypeService.findById(typeId));
				foodService.update(food);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "update";
	}
	
	
	/**
	 * ��ϵɾ��
	 */
	public String delete() throws Exception{
		if(food!=null&&food.getId()!=null){
			foodService.delete(food.getId());
		}
		return "delete";
	}
	
	/**
	 * ���ݹؼ�������
	 */
	public String search() throws Exception{
		if(keyword!=null){
			QueryHelper queryHelper = new QueryHelper(Food.class, "f");
			//���ݲ�Ʒ����ģ����ѯ
			queryHelper.addCondition("f.foodName like ?", "%"+keyword+"%");
			//���߸��ݲ�ϵ��ѯ��Ʒ
			queryHelper.addCondition("OR f.foodType.typeName = ? ", keyword);
//			List<Food> foodList = foodService.getAll(queryHelper);
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			pageResult = foodService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("pageResult", pageResult);
//			request.put("foodList", foodList);
		}
		return "search";
	}
	
	//������Ʒ�б�
		public void exportExcel(){
			try {
				//1�����Ҳ�Ʒ�б�
				//2������
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/x-execl");
				response.setHeader("Content-Disposition", "attachment;filename=" + new String("��Ʒ�б�.xls".getBytes(), "ISO-8859-1"));
				ServletOutputStream outputStream = response.getOutputStream();
				foodService.exportExcel(foodService.getAll(), outputStream);
				if(outputStream != null){
					outputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	public void setFood(Food food) {
		this.food = food;
	}
	public Food getFood() {
		return food;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public File getImg() {
		return img;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	public String getImgContentType() {
		return imgContentType;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeId() {
		return typeId;
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
