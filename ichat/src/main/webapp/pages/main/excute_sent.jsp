<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type='text/javascript' src='/ichat/dwr/interface/ChatManager.js'></script>
<script type='text/javascript' src='/ichat/dwr/engine.js'></script>
<script type='text/javascript' src='/ichat/dwr/util.js'></script>
<script language="javascript">
	/**
 * ������Ϣ
 */
function send() {
	var sender = '<%=request.getSession().getAttribute("uname").toString() %>'; // ��÷���������
	//var receiver = dwr.util.getValue('receiver'); // ��ý�����id
	var msg = getEditorHTMLContents(); // �����Ϣ����
	ChatManager.send(sender, msg); // ������Ϣ
	SetEditorContents('');//��ձ༭���з��͵���Ϣ
}
//��ȡ�༭����HTML����
function getEditorHTMLContents()
{ 
    return document.getElementById('msg').value;
}
//���ñ༭��������
function SetEditorContents(ContentStr)
{ 
	document.getElementById('msg').value = ContentStr;
}

</script>
</head>
<body style="margin: 0px;">
<form method="post" name="frm1">
   	&nbsp;<textarea rows="5" style="width:95%" id="msg"></textarea>
   	<br/>
    &nbsp;<input type="button" value="��  ��" onclick="send();">
</form>
</body>
</html>