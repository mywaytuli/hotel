package cn.ahut.login.action;

import java.text.SimpleDateFormat;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.ahut.core.util.Md5Util;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.login.entity.User;
import cn.ahut.login.service.IUserService;
import cn.ahut.sys.order.entity.Order;
import cn.ahut.sys.order.entity.OrderDetail;
import cn.ahut.sys.order.service.IOrderDetailService;
import cn.ahut.sys.order.service.IOrderService;


@Controller
@Scope("prototype")
public class LoginAction {

	@Resource
	private IUserService userService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IOrderDetailService orderDetailService;
	
	private Order order;
	private Double money;
	private User user;
	private Map<String, Object> return_map;
	private String login=null;
	
	//登录
		public String login(){
			if(user != null){
				if(StringUtils.isNotBlank(user.getAccount()) && StringUtils.isNotBlank(user.getPwd()) ){
					//根据用户的帐号和密码查询用户列表
					
					List<User> list = userService.findUsersByAccountAndPwd(user.getAccount(), Md5Util.md5(user.getPwd()));
					if(list != null && list.size() > 0){//说明登录成功
						//登录成功
						User user = list.get(0);
						//将用户信息保存到session中
						ServletActionContext.getRequest().getSession().setAttribute("info", user);
						Log log = LogFactory.getLog(LoginAction.class);
						log.info("用户名称为：" + user.getUserName() + " 的用户登录了系统。");
						if ("管理员".equals(user.getRole())){
							login="login1";
						}else login="login2";
					}else {
						Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
						request.put("valida", "密码和账号不匹配");
						login="login3";
					}
				}
			}
			return login;
		}
		
		/**
		 * 注册
		 * @return
		 */
		public String register() throws Exception{
			user.setPwd(Md5Util.md5(user.getPwd()));
			userService.save(user);
			return "register";
		}
		
		/**
		 * 验证用户账号唯一性
		 * @return
		 */
		public String reg_account() throws Exception{
			try{
			QueryHelper queryHelper = new QueryHelper(User.class, "u");
			queryHelper.addCondition("u.account = ?", user.getAccount());
			List<User> userList = userService.getAll(queryHelper);
			return_map = new HashMap<String, Object>();
			if(userList.size()>0){
				return_map.put("msg", true);
				}else{
					return_map.put("msg", false);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return "success";
		}

		/**
		 * 退出
		 * @return
		 */
		public String exit(){
			ServletActionContext.getRequest().getSession().removeAttribute("info");
			return "exit";
		}
		
		/**
		 * 进入修改基本信息页面
		 * @return
		 */
		public String doModifyInfo_1() throws Exception{
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("info");
			User u = userService.findById(user.getId());
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("doModifyInfo_1",u);
			return "doModifyInfo_1";
		}
		
		/**
		 * 修改基本信息
		 * @return
		 */
		public String modifyInfo_1() throws Exception{
			User u = (User) ServletActionContext.getRequest().getSession().getAttribute("info");
			User us = userService.findById(u.getId());
			us.setUserName(user.getUserName());
			us.setMobile(user.getMobile());
			us.setAddress(user.getAddress());
			userService.update(us);
			return "modifyInfo_1";
		}
		
		/**
		 * 验证密码是否正确
		 * @return
		 */
		public String doModifyInfo_2() throws Exception{
			User u = (User) ServletActionContext.getRequest().getSession().getAttribute("info");
			User us = userService.findById(u.getId());
			return_map = new HashMap<String, Object>();
			if(us.getPwd().equals(Md5Util.md5(user.getPwd()))){
				return_map.put("msg", false);
				}else{
					return_map.put("msg", true);
			}
			
			return "success";
		}
		
		/**
		 * 修改密码
		 * @return
		 */
		public String modifyInfo_2() throws Exception{
			User u = (User) ServletActionContext.getRequest().getSession().getAttribute("info");
			User us = userService.findById(u.getId());
			us.setPwd(Md5Util.md5(user.getPwd()));
			userService.update(us);
			return "modifyInfo_2";
		}
		
		/**
		 * 进入显示订单信息页面
		 * @return
		 */
		public String doModifyInfo_3() throws Exception{
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("info");
			User u = userService.findById(user.getId());
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			QueryHelper queryHelper = new QueryHelper(Order.class, "o");
			queryHelper.addCondition("o.user = ?", u);
			List<Order> orderList = orderService.getAll(queryHelper);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Iterator<Order> it = orderList.iterator();
			while (it.hasNext()) {
				Order order = it.next();
				if(order.getOrderDate()!=null){
					dateFormat.format(order.getOrderDate());
				}
			}
			request.put("orderList", orderList);
			return "doModifyInfo_3";
		}
		
		/**
		 * 结账
		 * @return
		 */
		public String modifyInfo_3pay() throws Exception{
			Order o = orderService.findById(order.getId());
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("order", o);
			request.put("money", money);
			return "modifyInfo_3pay";
		}
		
		/**
		 * 订单明细
		 * @return
		 */
		public String modifyInfo_3detail() throws Exception{
			QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
			queryHelper1.addCondition("o.order = ?", orderService.findById(order.getId()));
			List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper1);
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("orderDetailList", orderDetailList);
			return "modifyInfo_3detail";
		}
		
		/**
		 * 订单退订
		 * @return
		 */
		public String modifyInfo_3delete() throws Exception{
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
			return "modifyInfo_3delete";
		}
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Map<String, Object> getReturn_map() {
			return return_map;
		}
		public void setReturn_map(Map<String, Object> return_map) {
			this.return_map = return_map;
		}
		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}

		public Double getMoney() {
			return money;
		}

		public void setMoney(Double money) {
			this.money = money;
		}
		
}
