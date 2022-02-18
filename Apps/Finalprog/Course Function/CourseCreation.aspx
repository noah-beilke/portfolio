<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CourseCreation.aspx.cs" Inherits="Finalprog.Course_Function.CourseCreation" %>

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
            <asp:Label ID="Label1" runat="server" ForeColor="#CC0000" Text="* Starred Information is Required *"></asp:Label>
            <br />
            Please Enter Course Information:<br />
            <br />
            *
            Id:
            <asp:TextBox ID="idTxt" runat="server" Width="119px"></asp:TextBox>
            <br />
            *
            Description:
            <asp:TextBox ID="descTxt" runat="server"></asp:TextBox>
            <br />
            *
            VideoUrl:
            <asp:TextBox ID="videoTxt" runat="server"></asp:TextBox>
            <br />
            * Professor Name:
            <asp:TextBox ID="profTxt" runat="server"></asp:TextBox>
            <br />
            Name:
            <asp:TextBox ID="nameTxt" runat="server"></asp:TextBox>
            <br />
            Lecture Hours:
            <asp:TextBox ID="lectureTxt" runat="server"></asp:TextBox>
            <br />
            Student Number:
            <asp:TextBox ID="studentTxt" runat="server"></asp:TextBox>
            <br />
            Credits:<asp:TextBox ID="creditsTxt" runat="server"></asp:TextBox>
            <br />
            Zoom Link (If Applicable):
            <asp:TextBox ID="zoomTxt" runat="server"></asp:TextBox>
            <br />
            Course Title:
            <asp:TextBox ID="titleTxt" runat="server"></asp:TextBox>
            <br />
            Announcement Message (If Available):
            <asp:TextBox ID="announceTxt" runat="server"></asp:TextBox>
            <br />
            <br />
            <br />
            <asp:Button ID="submitBtn" runat="server" OnClick="submitBtn_Click" Text="Submit Course" Width="113px" />
            <asp:Label ID="successLbl" runat="server" ForeColor="Lime" Text="Success!"></asp:Label>
            <br />
            <asp:Label ID="errorLbl" runat="server" ForeColor="#CC0000" Text="Error" Visible="False"></asp:Label>
        </div>
    </form>
</body>
</html>
