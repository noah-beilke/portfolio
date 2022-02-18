<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CourseAdmin.aspx.cs" Inherits="Finalprog.Course_Function.CourseAdmin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Button ID="btnLogout" runat="server" Height="25px" OnClick="btnLogout_Click" Text="Log Out" Width="130px" BorderStyle="None" />
            
            <asp:Button ID="btnAdmin" runat="server" OnClick="btnAdmin_Click" Text="AdminPage" Visible="False" BorderStyle="None" Height="25px" Width="130px" />
            <asp:Button ID="btnUser" runat="server" OnClick="btnUser_Click" Text="User Page" BorderStyle="None" Height="25px" Width="130px" />
&nbsp;<br />
            <br />
            <br />
            Please select which admin page to use:<br />
            <br />
            <asp:Button ID="btnCourse" runat="server" OnClick="btnCourse_Click" Text="Course Creation" Width="120px" />
            <asp:Button ID="btnQuiz" runat="server" OnClick="btnQuiz_Click" Text="Quiz Creation" Width="120px" />
            <asp:Button ID="btnCourseEdit" runat="server" OnClick="btnCourseEdit_Click" Text="Course Edit" Width="120px" />
            <asp:Button ID="btnQuizEdit" runat="server" OnClick="btnQuizEdit_Click" Text="Quiz Edit" Width="120px" />
        </div>
    </form>
</body>
</html>
