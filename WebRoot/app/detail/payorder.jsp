<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
<style type="text/css">

</style>
</head>
<body>
	
	<div style="height: 100px">
		<div style="height: 20px"></div>
		<img src="${ pageContext.request.contextPath }/images/2wm.png" align="middle" width="70px" height="70px"/>
		您好，您的订单编号为${requestScope.order.id }，需付金额${requestScope.money }元。
	</div>
	
	<hr/>
	<form id="orderForm" action="${ pageContext.request.contextPath }/payOrder.action" method="post">
		
		<div class="span24">
			
					选择银行：<br/>
				<p style="height: 50px">
					<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/abc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/bcc.bmp" align="middle"/>
					<br/>
				</p>
				<p style="height: 50px">
					<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/ccb.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/cmb.bmp" align="middle"/>
					<br/>
				</p>
				<p style="height: 50px">
					<input type="radio" name="pd_FrpId" value="BCCB-NET-B2C"/>北京银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/bj.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CIB-NET-B2C "/>兴业银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/cib.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="NJCB-NET-B2C"/>南京银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/nanjing.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CMBC-NET-B2C"/>民生银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/cmbc.bmp" align="middle"/>
					<br/>
				</p>
				<p style="height: 50px">
					<input type="radio" name="pd_FrpId" value="POST-NET-B2C "/>中国邮政
					<img src="${ pageContext.request.contextPath }/images/bank_img/post.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="SHB-NET-B2C"/>上海银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/sh.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CZ-NET-B2C"/>浙商银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/zheshang.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="HKBEA-NET-B2C "/>东亚银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/dy.bmp" align="middle"/>
					<br/>
				</p>
				<p style="height: 50px">
					<input type="radio" name="pd_FrpId" value="NBCB-NET-B2C"/>宁波银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/ningbo.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="GDB-NET-B2C "/>广东发展银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/gf.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="BJRCB-NET-B2C"/>北京农村商业银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/beijingnongshang.bmp" align="middle"/>
					<br/>
				</p>
				<p style="height: 50px">
					<input type="radio" name="pd_FrpId" value="CBHB-NET-B2C"/>渤海银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/bh.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="SDB-NET-B2C"/>深圳发展银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/sfz.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="SPDB-NET-B2C"/>上海浦东发展银行
					<img src="${ pageContext.request.contextPath }/images/bank_img/shpd.bmp" align="middle"/>
				</p>
				<hr />
				<p style="text-align:left">
					<a href="javascript:document.getElementById('orderForm').submit();">
						<img src="${pageContext.request.contextPath}/images/finalbutton.gif" width="204" height="51" border="0" />
					</a>
				</p>
		</div>
	</form>

		
	
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/images/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					
					<li>
						<a >HOTEL++官网</a>
						|
					</li>
					<li>
						<a>HOTEL++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body>
</html>