<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="<%=request.getContextPath() %>/fckeditor/fckeditor.js"></script>
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
	var msg = getEditorHTMLContents('edt1'); // �����Ϣ����
	ChatManager.send(sender, msg); // ������Ϣ
	SetEditorContents('edt1','');//��ձ༭���з��͵���Ϣ
}
//��ȡ�༭����HTML����
function getEditorHTMLContents(EditorName)
{ 
    var oEditor = FCKeditorAPI.GetInstance(EditorName);
    return oEditor.GetXHTML(true); 
}
//���ñ༭��������
function SetEditorContents(EditorName, ContentStr)
{ 
    var oEditor = FCKeditorAPI.GetInstance(EditorName) ; 
    oEditor.SetHTML(ContentStr) ; 
}

</script>
</head>
<body style="margin: 0px;">
<form method="post" name="frm1">
    <script type="text/javascript">
        var oFCKeditor = new FCKeditor("edt1");
        oFCKeditor.BasePath = "<%=request.getContextPath() %>/fckeditor/";
        oFCKeditor.ToolbarSet="ichat";
        oFCKeditor.Height='160';
        oFCKeditor.Value="";
        oFCKeditor.Create();
    </script>
    <input type="button" value="��  ��" onclick="send();">
</form>
</body>
</html>