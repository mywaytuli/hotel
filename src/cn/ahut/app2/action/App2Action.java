package cn.ahut.app2.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ahut.core.util.QueryHelper;
import cn.ahut.sys.foodtype.entity.FoodType;
import cn.ahut.sys.foodtype.service.IFoodTypeService;
import cn.ahut.sys.order.entity.Order;
import cn.ahut.sys.order.entity.OrderDetail;
import cn.ahut.sys.order.service.IOrderDetailService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * ǰ̨actionʵ��
 * @author Dell
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class App2Action extends ActionSupport{
	
	@Resource
	private IFoodTypeService foodTypeService;
	@Resource
	private IOrderDetailService orderDetailService;
	
	private String odId;
	private String foodCount;
		
	/**
	 * �޸Ĳ�Ʒ����
	 */
	public String alter() throws Exception{
		OrderDetail orderDetail = orderDetailService.findById(odId);
		orderDetail.setFoodCount(Integer.parseInt(foodCount));
		orderDetailService.update(orderDetail);
		
		Order order = (Order) ServletActionContext.getRequest().getSession().getAttribute("order");
		List<FoodType> foodTypeList = foodTypeService.getAll();
		QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
		queryHelper1.addCondition("o.order = ?", order);
		List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper1);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("foodTypeList", foodTypeList);
		request.put("orderDetailList", orderDetailList);
		return "alter";
	}
	
	/**
	 * ɾ���ͳ��еĲ�Ʒ
	 */
	public String remove() throws Exception{
		orderDetailService.delete(odId);
		
		Order order = (Order) ServletActionContext.getRequest().getSession().getAttribute("order");
		List<FoodType> foodTypeList = foodTypeService.getAll();
		QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
		queryHelper1.addCondition("o.order = ?", order);
		List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper1);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("foodTypeList", foodTypeList);
		request.put("orderDetailList", orderDetailList);
		return "remove";
	}

	
	
	public String getOdId() {
		return odId;
	}

	public void setOdId(String odId) {
		this.odId = odId;
	}

	public String getFoodCount() {
		return foodCount;
	}

	public void setFoodCount(String foodCount) {
		this.foodCount = foodCount;
	}
	
	
}



