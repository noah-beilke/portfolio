<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CourseEdit.aspx.cs" Inherits="Finalprog.Course_Function.CourseEdit" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            &nbsp;<asp:Button ID="btnLogout" runat="server" BorderStyle="None" Height="25px" OnClick="btnLogout_Click" Text="Log Out" Width="130px" />
            <asp:Button ID="btnAdmin" runat="server" BorderStyle="None" Height="25px" OnClick="btnAdmin_Click" Text="AdminPage" Visible="False" Width="130px" />
            <asp:Button ID="btnUser" runat="server" BorderStyle="None" Height="25px" OnClick="btnUser_Click" Text="User Page" Width="130px" />
            &nbsp;<br />
            <br />
            Select the course that you would like to edit:<br />
            <br />
            <asp:DropDownList ID="courselist" runat="server" Width="350px">
            </asp:DropDownList>
            <br />
            <br />
            <asp:Button ID="loadInfoBtn" runat="server" OnClick="loadInfoBtn_Click" Text="Load Course info" Width="201px" />
            <br />
            <br />
            Id:
            <asp:TextBox ID="idTxt" runat="server" ReadOnly="True" Width="119px"></asp:TextBox>
            <br />
            Description:
            <asp:TextBox ID="descTxt" runat="server"></asp:TextBox>
            <br />
            VideoUrl:
            <asp:TextBox ID="videoTxt" runat="server"></asp:TextBox>
            <br />
            Professor Name:
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
            <asp:Button ID="ChangeInfoBtn" runat="server" OnClick="ChangeInfoBtn_Click" Text="Change Course info" Width="183px" />
            <asp:Label ID="successLbl" runat="server" ForeColor="Lime" Text="Success!"></asp:Label>
            <br />
            <asp:Label ID="errorLbl" runat="server" ForeColor="#CC0000" Text="Error" Visible="False"></asp:Label>
        </div>
    </form>
</body>
</html>
