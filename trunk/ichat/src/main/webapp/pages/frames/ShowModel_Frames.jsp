<%@ page language="java" pageEncoding="GB2312"%>
<%
	//��ģ�⣩��ȡ��¼��Ψһ�û�ID���ŵ�SESSION��online_list.jsp���������û��б�
	String uname = request.getParameter("uname");
	uname=new String(uname.getBytes("ISO-8859-1"),"gbk");
	String pwd = request.getParameter("pwd");
	request.getSession().setAttribute("uname",uname);
	request.getSession().setAttribute("pwd",pwd);
%>

<html>
<head>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<title>������������</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<frameset cols="*,230" frameborder="yes" border="0" framespacing="0">
	<frameset rows="400,*" frameborder=yes border="5" framespacing="5">
	  <frame src="<%=request.getContextPath() %>/pages/main/show_msg.jsp" name="main_one" scrolling=yes noresize>
	  <frame src="<%=request.getContextPath() %>/pages/main/excute_sent.jsp" name="main_two" scrolling=yes noresize>
	</frameset>
	<frame src="<%=request.getContextPath() %>/pages/main/online_list.jsp" name="main_top" scrolling=no noresize>
</frameset>
<noframes>
<body>
�ܱ�ǫ����ʹ�õ��������֧�ֿ�ܹ��ܣ�������°汾���������
</body>
</noframes>

</html>