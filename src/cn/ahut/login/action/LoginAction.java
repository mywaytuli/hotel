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
	
	//��¼
		public String login(){
			if(user != null){
				if(StringUtils.isNotBlank(user.getAccount()) && StringUtils.isNotBlank(user.getPwd()) ){
					//�����û����ʺź������ѯ�û��б�
					
					List<User> list = userService.findUsersByAccountAndPwd(user.getAccount(), Md5Util.md5(user.getPwd()));
					if(list != null && list.size() > 0){//˵����¼�ɹ�
						//��¼�ɹ�
						User user = list.get(0);
						//���û���Ϣ���浽session��
						ServletActionContext.getRequest().getSession().setAttribute("info", user);
						Log log = LogFactory.getLog(LoginAction.class);
						log.info("�û�����Ϊ��" + user.getUserName() + " ���û���¼��ϵͳ��");
						if ("����Ա".equals(user.getRole())){
							login="login1";
						}else login="login2";
					}else {
						Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
						request.put("valida", "������˺Ų�ƥ��");
						login="login3";
					}
				}
			}
			return login;
		}
		
		/**
		 * ע��
		 * @return
		 */
		public String register() throws Exception{
			user.setPwd(Md5Util.md5(user.getPwd()));
			userService.save(user);
			return "register";
		}
		
		/**
		 * ��֤�û��˺�Ψһ��
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
		 * �˳�
		 * @return
		 */
		public String exit(){
			ServletActionContext.getRequest().getSession().removeAttribute("info");
			return "exit";
		}
		
		/**
		 * �����޸Ļ�����Ϣҳ��
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
		 * �޸Ļ�����Ϣ
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
		 * ��֤�����Ƿ���ȷ
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
		 * �޸�����
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
		 * ������ʾ������Ϣҳ��
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
		 * ����
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
		 * ������ϸ
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
		 * �����˶�
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
