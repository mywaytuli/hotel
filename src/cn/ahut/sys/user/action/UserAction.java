package cn.ahut.sys.user.action;

import java.text.SimpleDateFormat;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.login.entity.User;
import cn.ahut.login.service.IUserService;
import cn.ahut.sys.order.entity.Order;
import cn.ahut.sys.order.entity.OrderDetail;
import cn.ahut.sys.order.service.IOrderDetailService;
import cn.ahut.sys.order.service.IOrderService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{
	
	@Resource
	private IUserService userService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IOrderDetailService orderDetailService;
	private User user;
	private String userId;
	private Order order;
	private String keyword;
	private PageResult pageResult;
	private int pageNo;
	private int pageSize;
	//Ĭ��ҳ��С
	public static int DEFAULT_PAGE_SIZE = 5;
	
	/**
	 * ��Ա�б�չʾ
	 */
	public String list() throws Exception {
		try{
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			QueryHelper queryHelper = new QueryHelper(User.class, "u");
			pageResult = userService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("pageResult", pageResult);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	

	/**
	 * ��Աɾ��
	 */
	public String delete() throws Exception{
		if(user!=null&&user.getId()!=null){
			userService.delete(user.getId());
		}
		return "delete";
	}
	
	/**
	 * ���ݹؼ�������
	 */
	public String search() throws Exception{
		if(keyword!=null){
			QueryHelper queryHelper = new QueryHelper(User.class, "u");
			//���ݲ�Ʒ����ģ����ѯ
			queryHelper.addCondition("u.userName like ?", "%"+keyword+"%");
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			pageResult = userService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("pageResult", pageResult);
		}
		return "search";
	}
	
	/**
	 * �����û��б�
	 */
		public void exportExcel(){
			try {
				//1�����Ҳ�Ʒ�б�
				//2������
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/x-execl");
				response.setHeader("Content-Disposition", "attachment;filename=" + new String("�û��б�.xls".getBytes(), "ISO-8859-1"));
				ServletOutputStream outputStream = response.getOutputStream();
				userService.exportExcel(userService.getAll(), outputStream);
				if(outputStream != null){
					outputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		/**
		 * �鿴�û���ʷ����
		 * @return
		 */
		public String order() throws Exception {
			try{
				if(userId!=null){
					ServletActionContext.getRequest().getSession().setAttribute("userId", userId);
				}else{
					 userId = (String) ServletActionContext.getRequest().getSession().getAttribute("userId");
				}
				User user = userService.findById(userId);
				Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
				QueryHelper queryHelper = new QueryHelper(Order.class, "o");
				queryHelper.addCondition("o.user = ?", user);
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
			return "order";
		}
		

		/**
		 * ������ϸ
		 * @return
		 */
		public String orderDetail() throws Exception{
			QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
			queryHelper1.addCondition("o.order = ?", order);
			List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper1);
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("orderDetailList", orderDetailList);
			return "orderDetail";
		}
		
		/**
		 * ����
		 * @return
		 */
		public String orderPay() throws Exception{
			Order o = orderService.findById(order.getId());
			o.setOrderStatus(1);
			orderService.update(o);
			return "orderPay";
		}
		
		/**
		 * ����ɾ��
		 * @return
		 */
		public String orderDelete() throws Exception{
			Order o = orderService.findById(order.getId());
			QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
			queryHelper1.addCondition("o.order = ?", o);
			List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper1);
			if(orderDetailList.size()>0){
				for(OrderDetail orderDetail:orderDetailList){
					orderDetailService.delete(orderDetail.getId());
				}
			}
			orderService.delete(order.getId());
			return "orderDelete";
		}
		
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public static int getDEFAULT_PAGE_SIZE() {
		return DEFAULT_PAGE_SIZE;
	}
	public static void setDEFAULT_PAGE_SIZE(int dEFAULT_PAGE_SIZE) {
		DEFAULT_PAGE_SIZE = dEFAULT_PAGE_SIZE;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
