package cn.ahut.app.action;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.PaymentUtil;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.login.entity.User;
import cn.ahut.sys.dinnertable.entity.DinnerTable;
import cn.ahut.sys.dinnertable.entity.TableDetail;
import cn.ahut.sys.dinnertable.service.IDinnerTableService;
import cn.ahut.sys.dinnertable.service.ITableDetailService;
import cn.ahut.sys.food.entity.Food;
import cn.ahut.sys.food.service.IFoodService;
import cn.ahut.sys.foodtype.entity.FoodType;
import cn.ahut.sys.foodtype.service.IFoodTypeService;
import cn.ahut.sys.order.entity.Order;
import cn.ahut.sys.order.entity.OrderDetail;
import cn.ahut.sys.order.service.IOrderDetailService;
import cn.ahut.sys.order.service.IOrderService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 前台action实现
 * @author Dell
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AppAction extends ActionSupport{
	
	@Resource
	private IDinnerTableService dinnerTableService;
	@Resource
	private IFoodTypeService foodTypeService;
	@Resource
	private IFoodService foodService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IOrderDetailService orderDetailService;
	@Resource
	private ITableDetailService tableDetailService;
	
	private String eatTime1;
	private String eatTime2;
	private DinnerTable dinnerTable;
	private Food food;
	private String keyword;
	private PageResult pageResult;
	private int pageNo;
	private int pageSize;
	public static int DEFAULT_PAGE_SIZE = 6;
	private OrderDetail orderDetail;
	private Order order;
	private String foodId;
	private Double money;
	private String pd_FrpId;
	private String r3_Amt;
	private String r6_Order;
	
	/**
	 * 餐桌显示，
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String showTable() throws Exception{
		try{
			ServletActionContext.getRequest().getSession().setAttribute("eatDate", eatTime1+eatTime2);
			List<DinnerTable> dinnerTableList = dinnerTableService.getAll();
			QueryHelper queryHelper = new QueryHelper(TableDetail.class, "t");
			queryHelper.addCondition("t.eatDate = ?", eatTime1+eatTime2);
			List<TableDetail> tableDetailList = tableDetailService.getAll(queryHelper);
			for(TableDetail tableDetail:tableDetailList){
				if(dinnerTableList.contains(tableDetail.getDinnerTable())){
					dinnerTableList.remove(tableDetail.getDinnerTable());
				}
			}
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("dinnerTableList", dinnerTableList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "showTable";
	}
	
	/**
	 * 前台菜单显示菜系和菜品
	 * @param return_map
	 */
	@SuppressWarnings("unchecked")
	public String list() throws Exception{
		try{
			if(dinnerTable!=null){
				DinnerTable table = dinnerTableService.findById(dinnerTable.getId());
				String date = (String) ServletActionContext.getRequest().getSession().getAttribute("eatDate");
				TableDetail tableDetail = new TableDetail();
				tableDetail.setDinnerTable(table);
				tableDetail.setEatDate(date);
				tableDetailService.save(tableDetail);
				Object obj = ServletActionContext.getRequest().getSession().getAttribute("info");
				Order order = new Order();
				order.setDinnerTable(table);
				order.setEatDate(date);
				if(obj!=null){
					User user = (User) obj;
					order.setUser(user);
				}
				orderService.save(order);
				ServletActionContext.getRequest().getSession().setAttribute("order", order);
			}
			List<FoodType> foodTypeList = foodTypeService.getAll();
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			QueryHelper queryHelper = new QueryHelper(Food.class, "f");
			pageResult = foodService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("foodTypeList", foodTypeList);
			request.put("pageResult_food", pageResult);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	/**
	 * 前台菜品详细介绍
	 * @param return_map
	 */
	@SuppressWarnings("unchecked")
	public String foodDetail() throws Exception{
			if(food!=null&&food.getId()!=null){
			Food foodDetail = foodService.findById(food.getId());
			List<FoodType> foodTypeList = foodTypeService.getAll();
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("foodTypeList", foodTypeList);   
			request.put("foodDetail", foodDetail);
		}
		return "foodDetail";
	}
	
	/**
	 * 根据菜系查看菜品
	 * @param return_map
	 */
	@SuppressWarnings("unchecked")
	public String searchByType() throws Exception{
		if(keyword!=null){
			List<FoodType> foodTypeList = foodTypeService.getAll();
			QueryHelper queryHelper = new QueryHelper(Food.class,"f");
			queryHelper.addCondition("f.foodType.id = ? ",keyword);
			pageResult = foodService.getPageResult(queryHelper, getPageNo(), getPageSize());
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");                                       
			request.put("foodTypeList", foodTypeList);
			request.put("pageResult_food", pageResult);
		}
		return"searchByType";
	}
	
	/**
	 * 根据关键字搜索
	 */
	@SuppressWarnings("unchecked")
	public String search() throws Exception{
		if(keyword!=null){
			List<FoodType> foodTypeList = foodTypeService.getAll();
			QueryHelper queryHelper = new QueryHelper(Food.class, "f");
			//根据菜品名称模糊查询
			queryHelper.addCondition("f.foodName like ?", "%"+keyword+"%");
			
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			pageResult = foodService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("foodTypeList", foodTypeList);
			request.put("pageResult_food", pageResult);

		}
		return "search";
	}
	
	/**
	 *放入餐车 
	 */
	@SuppressWarnings("unchecked")
	public String put() throws Exception{
		
		Order order = (Order) ServletActionContext.getRequest().getSession().getAttribute("order");
		QueryHelper queryHelper = new QueryHelper(OrderDetail.class, "o");
		queryHelper.addCondition("o.order = ?", order);
		List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper);
		HashSet<String> set = new HashSet<String>();
		for(OrderDetail detail:orderDetailList){
			set.add(detail.getFood().getId());
		}
		if(set.contains(foodId)){
			queryHelper.addCondition("and o.food.id = ?", foodId);
			orderDetailService.getAll(queryHelper).get(0).setFoodCount(orderDetailService.getAll(queryHelper).get(0).getFoodCount()+1);
			orderDetailService.update(orderDetailService.getAll(queryHelper).get(0));
		}else{
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setFood(foodService.findById(foodId));
			orderDetail.setFoodCount(1);
			orderDetailService.save(orderDetail);
		}
		
		List<FoodType> foodTypeList = foodTypeService.getAll();
		QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
		queryHelper1.addCondition("o.order = ?", order);
		orderDetailList = orderDetailService.getAll(queryHelper1);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("foodTypeList", foodTypeList);
		request.put("orderDetailList", orderDetailList);
		return "put";
	}
	
	
	
	
	/**
	 * 下单
	 * @param return_map
	 */
	@SuppressWarnings("unchecked")
	public String order() throws Exception{
		Order order = (Order) ServletActionContext.getRequest().getSession().getAttribute("order");
		if(money!=null){
			order.setOrderDate(new Date());
			order.setTotalPrice(money);
			orderService.update(order);
		}
		List<FoodType> foodTypeList = foodTypeService.getAll();
		QueryHelper queryHelper1 = new QueryHelper(OrderDetail.class, "o");
		queryHelper1.addCondition("o.order = ?", order);
		List<OrderDetail> orderDetailList = orderDetailService.getAll(queryHelper1);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("foodTypeList", foodTypeList);
		request.put("orderDetailList", orderDetailList);
		return "order";
	}
	
	
	@SuppressWarnings("unchecked")
	public String pay() throws Exception{
		Order order = (Order) ServletActionContext.getRequest().getSession().getAttribute("order");
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("order", order);
		request.put("money", money);
		return "pay";
		
	}
	
	/**
	 * 在线支付
	 * @param return_map
	 */
	public String payOrder() throws Exception{
		Order order = (Order) ServletActionContext.getRequest().getSession().getAttribute("order");
		// 付款需要的参数:
		String p0_Cmd = "Buy"; // 业务类型:
		String p1_MerId = "10001126856";// 商户编号:
		String p2_Order = order.getId();// 订单编号:
		String p3_Amt = "0.01"; // 付款金额:
		String p4_Cur = "CNY"; // 交易币种:
		String p5_Pid = ""; // 商品名称:
		String p6_Pcat = ""; // 商品种类:
		String p7_Pdesc = ""; // 商品描述:
		String p8_Url = "http://localhost:8080/hotel/callBack.action"; // 商户接收支付成功数据的地址:
		String p9_SAF = ""; // 送货地址:
		String pa_MP = ""; // 商户扩展信息:
		String pd_FrpId = this.pd_FrpId;// 支付通道编码:
		String pr_NeedResponse = "1"; // 应答机制:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// 向易宝发送请求:
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		
		// 重定向:向易宝出发:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}
	
	// 付款成功后跳转回来的路径:
		@SuppressWarnings("unchecked")
		public String callBack() throws Exception{
			// 修改订单的状态:
			Order order = orderService.findById(r6_Order);
			// 修改订单状态为2:已经付款:
			order.setOrderStatus(1);
			orderService.update(order);
			this.addActionMessage("支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("paySuccess", "支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
			return "callBack";
		}
	
	
	
	public String getEatTime1() {
			return eatTime1;
	}
	public void setEatTime1(String eatTime1) {
		this.eatTime1 = eatTime1;
	}
	public String getEatTime2() {
		return eatTime2;
	}
	public void setEatTime2(String eatTime2) {
		this.eatTime2 = eatTime2;
	}
	public void setDinnerTable(DinnerTable dinnerTable) {
		this.dinnerTable = dinnerTable;
	}
	public DinnerTable getDinnerTable() {
		return dinnerTable;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Food getFood() {
		return food;
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
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getPd_FrpId() {
		return pd_FrpId;
	}
	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	public String getR3_Amt() {
		return r3_Amt;
	}
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}
	public String getR6_Order() {
		return r6_Order;
	}
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}
}
