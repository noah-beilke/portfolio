<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Quiz_Page.aspx.cs" Inherits="Finalprog.Quiz_Page" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="background-color: #ebe7e0">
    <form id="form1" runat="server">
        <div>
            <asp:Button ID="btnLogout" runat="server" Height="25px" OnClick="btnLogout_Click" Text="Log Out" Width="130px" BorderStyle="None" />
            
            <asp:Button ID="btnAdmin" runat="server" OnClick="btnAdmin_Click" Text="AdminPage" Visible="False" BorderStyle="None" Height="25px" Width="130px" />
            <asp:Button ID="btnUser" runat="server" OnClick="btnUser_Click" Text="User Page" BorderStyle="None" Height="25px" Width="130px" />
&nbsp;<hr />
            <br />
            <br />
            <asp:Label ID="quizTitle" runat="server" Text="Label" Font-Bold="True"></asp:Label>
        </div>
        <asp:Panel ID="Panel1" runat="server" style="margin-left: 304px">
            <asp:Label ID="scoreLBL" runat="server" Font-Bold="True" Font-Size="X-Large" Text="Score: " Visible="False"></asp:Label>
            <asp:Label ID="scoreLabel" runat="server" Text="Label" Visible="False" Font-Bold="True" Font-Size="X-Large"></asp:Label>
        </asp:Panel>
        <br />
        <asp:Label ID="Question_1" runat="server" Text="Question_1" Font-Bold="True"></asp:Label>
        <asp:RadioButtonList ID="RadioButtonList1" runat="server" Width="622px">
            <asp:ListItem>A)</asp:ListItem>
            <asp:ListItem>B)</asp:ListItem>
            <asp:ListItem>C)</asp:ListItem>
            <asp:ListItem>D)</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <asp:Label ID="Question_2" runat="server" Text="Question 2" Font-Bold="True"></asp:Label>
        <br />
        <asp:RadioButtonList ID="RadioButtonList2" runat="server" Width="683px">
            <asp:ListItem>A)</asp:ListItem>
            <asp:ListItem>B)</asp:ListItem>
            <asp:ListItem>C)</asp:ListItem>
            <asp:ListItem>D)</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <asp:Label ID="Question_3" runat="server" Text="Question 3" Font-Bold="True"></asp:Label>
        <br />
        <asp:RadioButtonList ID="RadioButtonList3" runat="server" Width="624px">
            <asp:ListItem>A)</asp:ListItem>
            <asp:ListItem>B)</asp:ListItem>
            <asp:ListItem>C)</asp:ListItem>
            <asp:ListItem>D)</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <asp:Label ID="Question_4" runat="server" Text="Question 4" Font-Bold="True"></asp:Label>
        <br />
        <asp:RadioButtonList ID="RadioButtonList4" runat="server" Width="652px">
            <asp:ListItem>A)</asp:ListItem>
            <asp:ListItem>B)</asp:ListItem>
            <asp:ListItem>C)</asp:ListItem>
            <asp:ListItem>D)</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <asp:Label ID="Question_5" runat="server" Text="Question 5" Font-Bold="True"></asp:Label>
        <br />
        <asp:RadioButtonList ID="RadioButtonList5" runat="server" Width="599px">
            <asp:ListItem>A)</asp:ListItem>
            <asp:ListItem>B)</asp:ListItem>
            <asp:ListItem>C)</asp:ListItem>
            <asp:ListItem>D)</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <asp:Button ID="Button1" runat="server" Text="Submit" OnClick="Button1_Click1" />
        <br />
    </form>
</body>
</html>
