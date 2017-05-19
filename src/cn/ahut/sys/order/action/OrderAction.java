package cn.ahut.sys.order.action;

import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.sys.order.entity.Order;
import cn.ahut.sys.order.entity.OrderDetail;
import cn.ahut.sys.order.service.IOrderDetailService;
import cn.ahut.sys.order.service.IOrderService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class OrderAction extends ActionSupport{
	
	@Resource
	private IOrderService orderService;
	@Resource
	private IOrderDetailService orderDetailService;
	
	private Order order;
	private PageResult pageResult;
	private int pageNo;
	private int pageSize;
	//默认页大小
	public static int DEFAULT_PAGE_SIZE = 5;
	
	/**
	 * 订单列表展示
	 */
	public String list() throws Exception {
		try{
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			QueryHelper queryHelper = new QueryHelper(Order.class, "o");
			pageResult = orderService.getPageResult(queryHelper, getPageNo(), getPageSize());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Iterator<Order> it = pageResult.getItems().iterator();
			while (it.hasNext()) {
				Order order = it.next();
				if(order.getOrderDate()!=null){
					dateFormat.format(order.getOrderDate());
				}
			}
			request.put("pageResult", pageResult);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	
	/**
	 * 订单详细
	 * @return
	 */
	public String detail() throws Exception{
		QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
		queryHelper1.addCondition("o.order = ?", order);
		List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper1);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("orderDetailList", orderDetailList);
		return "detail";
	}
	
	/**
	 * 结账
	 * @return
	 */
	public String pay() throws Exception{
		Order o = orderService.findById(order.getId());
		o.setOrderStatus(1);
		orderService.update(o);
		return "pay";
	}
	
	/**
	 * 订单删除
	 * @return
	 */
	public String delete() throws Exception{
		QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
		queryHelper1.addCondition("o.order = ?", order);
		List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper1);
		if(orderDetailList.size()>0){
			for(OrderDetail orderDetail:orderDetailList){
				orderDetailService.delete(orderDetail.getId());
			}
		}
		orderService.delete(order.getId());
		return "delete";
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
