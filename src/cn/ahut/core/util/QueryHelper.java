package cn.ahut.core.util;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	
	//from�Ӿ�
		private String fromClause = "";
		//where�Ӿ�
		private String whereClause = "";
		//order by�Ӿ�
		private String orderByClause = "";
		
		private List<Object> parameters;
		//����˳��
		public static String ORDER_BY_DESC = "DESC";//����
		public static String ORDER_BY_ASC = "ASC";//����
		
		/**
		 * ����from �Ӿ�
		 * @param clazz ʵ����
		 * @param alias ʵ�����Ӧ�ı���
		 */
		public QueryHelper(Class clazz, String alias){
			fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
		}
		
		/**
		 * ����where�Ӿ�
		 * @param condition ��ѯ������䣻���磺f.foodName like ?
		 * @param params ��ѯ���������?��Ӧ�Ĳ�ѯ����ֵ�����磺 %����%
		 */
		public void addCondition(String condition, Object... params){
			if (whereClause.length() > 1) {//�ǵ�һ����ѯ����
				whereClause += condition;
			} else {//��һ����ѯ����
				whereClause = " WHERE " + condition+" ";
			}
			
			//���ò�ѯ����ֵ����ѯ����ֵ������
			if(parameters == null){
				parameters = new ArrayList<Object>();
			}
			if(params != null){
				for(Object param: params){
					parameters.add(param);
				}
			}
		}
		
		/**
		 * ����order by�Ӿ�
		 * @param property �������ԣ��磺i.createTime
		 * @param order ����˳���磺DESC ���� ASC
		 */
		public void addOrderByProperty(String property, String order){
			if (orderByClause.length() > 1) {//�ǵ�һ����������
				orderByClause += "," + property + " " + order;
			} else {//��һ����������
				orderByClause = " ORDER BY " + property + " " + order;
			}
		}

		//��ѯhql���
		public String getQueryListHql(){
			return fromClause + whereClause + orderByClause;
		}
		
		//��ѯͳ������hql���
		public String getQueryCountHql(){
			return "SELECT COUNT(*) " + fromClause + whereClause;
		}
		
		//��ѯhql�����?��Ӧ�Ĳ�ѯ����ֵ����
		public List<Object> getParameters(){
			return parameters;
		}

}
