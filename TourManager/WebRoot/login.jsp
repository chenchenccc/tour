<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>登陆</TITLE>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>
<STYLE type="text/css">
A: link{COLOR: #ffffff;FONT-SIZE: 12px;TEXT-DECORATION: none}
A: visited{COLOR: #ffffff;FONT-SIZE: 12px;TEXT-DECORATION: none}
A: hover{COLOR: #ffffff}
BODY input{MARGIN-TOP: 2px;FONT: 12px "微软雅黑";}
TD{LINE-HEIGHT: 15px;FONT-SIZE: 12px}
</STYLE>
</HEAD>
<BODY>
<DIV align=center><BR><BR><BR><BR><BR>
<TABLE id=__01 border=0 cellSpacing=1 cellPadding=0 width=668 align=center>
  <TBODY>
  <TR>
    <TD>
      <TABLE border=0 cellSpacing=1 cellPadding=0 width="667" background="html/images/banner2.jpg" height="408">
        <TBODY>
        <tr>
        <td height="230"></td>
        </tr>
        <TR>
          <TD>
            <TABLE border=0 cellSpacing=0 cellPadding=2 width=660>
              <FORM method=post id=login action="login.action">
              <TBODY>
              <TR>
                <TD height=25 width="37%">
                  <DIV align=right>用户名：</DIV></TD>
                <TD width="63%">
                  <DIV align=left><INPUT style="WIDTH: 200px" id="username" 
                  size=25 name="username"></DIV></TD></TR>
              <TR>
                <TD height=25>
                  <DIV align=right>密码：</DIV></TD>
                <TD>
                  <DIV align=left><INPUT style="WIDTH: 200px" id="password" 
                  size=25 type=password name="password"></DIV></TD></TR>
              <TR>
                <TD height=37>
                  <DIV align=left></DIV></TD>
                <TD>
                  <DIV align=left><P><INPUT value=登陆 type="button" onclick="login()" name=B1>&nbsp;&nbsp;<INPUT value=取消 type="button" onclick="cancel()" name=B2></P></DIV>
				</TD>
			</TR>
			</FORM>
		</TBODY>
	</TABLE>
</TD>
</TR>
</TBODY>
</TABLE>
</TD>
</TR>
</TBODY>
</TABLE>
</DIV>
</BODY>
<script type="text/javascript" src="js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="html/js/login.js"></script>
</HTML>
