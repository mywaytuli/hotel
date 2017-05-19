package cn.ahut.sys.dinnertable.action;


import java.util.List;
import java.util.Map;



import javax.annotation.Resource;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ahut.sys.dinnertable.entity.DinnerTable;
import cn.ahut.sys.dinnertable.entity.TableDetail;
import cn.ahut.sys.dinnertable.service.IDinnerTableService;
import cn.ahut.sys.dinnertable.service.ITableDetailService;
import cn.ahut.sys.dinnertable.service.impl.DinnerTableService;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

@Controller
@Scope("prototype")
public class DinnerTableAction extends ActionSupport {
	
	@Resource
	private IDinnerTableService dinnerTableService;
	@Resource
	private ITableDetailService tableDetailService;
	
	private DinnerTable dinnerTable;
	private TableDetail tableDetail; 
	private String keyword;
	private String id;
	private String eatTime1;
	private String eatTime2;
	private PageResult pageResult;
	private int pageNo;
	private int pageSize;
	//Ĭ��ҳ��С
	public static int DEFAULT_PAGE_SIZE = 5;
	
	public String list()  throws Exception{
		try{
			QueryHelper queryHelper = new QueryHelper(DinnerTable.class, "d");
			PageResult pageResult = dinnerTableService.getPageResult(queryHelper, getPageNo(), getPageSize());
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("pageResult", pageResult);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	public String add() throws Exception{
		if(dinnerTable!=null){
			dinnerTableService.save(dinnerTable);
		}
		return "add";
	}
	
	public String delete() throws Exception{
		if(dinnerTable!=null&&dinnerTable.getId()!=null){
			dinnerTableService.delete(dinnerTable.getId());
		}
		return "delete";
	}

	public String search() throws Exception{
		if(keyword!=null){
			QueryHelper queryHelper = new QueryHelper(DinnerTable.class, "d");
			queryHelper.addCondition("d.tableName like ?", "%"+keyword+"%");
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			pageResult = dinnerTableService.getPageResult(queryHelper, getPageNo(), getPageSize());
			request.put("pageResult", pageResult);
		}
		return "search";
	}
	
	public String tableDetail_list() throws Exception{
		DinnerTable table = null;
		if(dinnerTable!=null){
			table = dinnerTableService.findById(dinnerTable.getId());
		}else{
			table = (DinnerTable) ServletActionContext.getRequest().getSession().getAttribute("td.table");
		}
		QueryHelper queryHelper = new QueryHelper(TableDetail.class, "t");
		queryHelper.addCondition("t.dinnerTable = ?", table);
		List<TableDetail> tableDetailList = tableDetailService.getAll(queryHelper);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("tableDetailList", tableDetailList);
		return "tableDetail_list";
	}
	
	/**
	 * ����
	 * @param dinnerTable
	 */
	public String tableDetail_delete() throws Exception{
		TableDetail td = tableDetailService.findById(tableDetail.getId());
		ServletActionContext.getRequest().getSession().setAttribute("td.table", td.getDinnerTable());
		tableDetailService.delete(tableDetail.getId());
		return "tableDetail_delete";
	}
	
	public String middle() throws Exception {
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("tableid", dinnerTable.getId());
		return "middle";
	}
	
	/**
	 * ����Ԥ��
	 * @param dinnerTable
	 */
	public String order() throws Exception{
		TableDetail tableDetail = new TableDetail();
		tableDetail.setDinnerTable(dinnerTableService.findById(dinnerTable.getId()));
		tableDetail.setEatDate(eatTime1+eatTime2);
		tableDetailService.save(tableDetail);
		return"order";
	}
	
	public void setDinnerTable(DinnerTable dinnerTable) {
		this.dinnerTable = dinnerTable;
	}
	public DinnerTable getDinnerTable() {
		return dinnerTable;
	}
	public TableDetail getTableDetail() {
		return tableDetail;
	}
	public void setTableDetail(TableDetail tableDetail) {
		this.tableDetail = tableDetail;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
}
