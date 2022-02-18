<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Admin.aspx.cs" Inherits="Finalprog.User_Function.Admin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <%--    <link rel="stylesheet" href="Navigation Bar.css" />--%>
    <title></title>
</head>
<body class="bg">
    <style>
        .rcorners1 {
            border-radius: 25px;
            background:;
        }

        .center {
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translateX(-50%) translateY(-50%);
            text-align: left;
            margin: 1px;
        }

        .outer {
            margin: 1px 5px 1px 1px;
            display: inline-block;
            border-radius: 25px;
            background: #73AD21;
            padding: 20px;
        }

        .outer1 {
            margin: 1px 5px 1px 1px;
            display: inline-block;
            border-radius: 25px;
            background: #73AD21;
            justify-content: center;
        }

        html {
            height: 100%;
        }

        body {
            margin: 0;
        }

        .bg {
            background-color: #0093E9;
            background-image: linear-gradient(160deg, #0093E9 0%, #80D0C7 100%);
            height: 100%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .bg2 {
            animation-direction: alternate-reverse;
            animation-duration: 4s;
        }

        .bg3 {
            animation-duration: 5s;
        }

        @keyframes slide {
            0% {
                transform: translateX(-25%);
            }

            100% {
                transform: translateX(25%);
            }
        }

        .mydatagrid {
            width: 80%;
            border: solid 2px black;
            min-width: 80%;
        }

        .header {
            background-color: #000;
            font-family: Arial;
            color: White;
            height: 25px;
            text-align: center;
            font-size: 16px;
        }

        .rows {
            background-color: #fff;
            font-family: Arial;
            font-size: 14px;
            color: #000;
            min-height: 25px;
            text-align: left;
        }

            .rows:hover {
                background-color: #5badff;
                color: #fff;
            }

        .mydatagrid a /** FOR THE PAGING ICONS **/ {
            background-color: Transparent;
            padding: 5px 5px 5px 5px;
            color: #fff;
            text-decoration: none;
            font-weight: bold;
        }

            .mydatagrid a:hover /** FOR THE PAGING ICONS HOVER STYLES**/ {
                background-color: #000;
                color: #fff;
            }

        .mydatagrid span /** FOR THE PAGING ICONS CURRENT PAGE INDICATOR **/ {
            background-color: #fff;
            color: #000;
            padding: 5px 5px 5px 5px;
        }

        .pager {
            background-color: #5badff;
            font-family: Arial;
            color: White;
            height: 30px;
            text-align: left;
        }

        .mydatagrid td {
            padding: 5px;
        }

        .mydatagrid th {
            padding: 5px;
        }
    </style>
    <form id="form1" runat="server">
        <header>
            <%--<asp:Button ID="btnLogout" runat="server" Height="25px" OnClick="btnLogout_Click" Text="Log Out" Width="130px" BorderStyle="None" />
            <asp:Button ID="btnCourse" runat="server" OnClick="btnCourse_Click" Text="Course Search" BorderStyle="None" Height="25px" Width="130px" />
            <asp:Button ID="btnUser" runat="server" OnClick="btnUser_Click" Text="User Page" BorderStyle="None" Height="25px" Width="130px" />--%>
            <div class="NavBar" runat="server">
                <asp:Button class="outer1" ID="btnLogout" runat="server" OnClick="btnLogout_Click" Text="Log Out" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
                <asp:Button class="outer1" ID="btnCourse" runat="server" OnClick="btnCourse_Click" Text="Course Search" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
                <asp:Button class="outer1" ID="btnUser" runat="server" OnClick="btnUser_Click" Text="User Page" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />

            </div>
            &nbsp;

        </header>

        <br />
        <br />
        <br />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="SqlDataSource1" CssClass="mydatagrid" PagerStyle-CssClass="pager"
            HeaderStyle-CssClass="header" RowStyle-CssClass="rows" AllowPaging="True">
            <Columns>
                <asp:BoundField DataField="username" HeaderText="username" SortExpression="username" />
                <asp:BoundField DataField="first_name" HeaderText="first_name" SortExpression="first_name" />
                <asp:BoundField DataField="last_name" HeaderText="last_name" SortExpression="last_name" />
                <asp:BoundField DataField="phone_number" HeaderText="phone_number" SortExpression="phone_number" />
                <asp:BoundField DataField="degree" HeaderText="degree" SortExpression="degree" />
                <asp:BoundField DataField="organization" HeaderText="organization" SortExpression="organization" />
                <asp:BoundField DataField="email" HeaderText="email" SortExpression="email" />
                <asp:BoundField DataField="status" HeaderText="status" SortExpression="status" />
                <asp:BoundField DataField="RoleID" HeaderText="Role " SortExpression="RoleID" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:UsersConnectionString %>" SelectCommand="SELECT [username], [first_name], [last_name], [phone_number], [degree], [organization], [email], [status], [RoleID] FROM [user] ORDER BY [username]"></asp:SqlDataSource>
        <br />
        <asp:GridView ID="GridView2" runat="server" AutoGenerateColumns="False" DataSourceID="SqlDataSource2" CssClass="mydatagrid" PagerStyle-CssClass="pager"
            HeaderStyle-CssClass="header" RowStyle-CssClass="rows" AllowPaging="True">
            <Columns>
                <asp:BoundField DataField="courseTitle" HeaderText="courseTitle" SortExpression="courseTitle" />
                <asp:BoundField DataField="professorName" HeaderText="professorName" SortExpression="professorName" />
                <asp:BoundField DataField="description" HeaderText="description" SortExpression="description" />
                <asp:BoundField DataField="lectureHours" HeaderText="lectureHours" SortExpression="lectureHours" />
                <asp:BoundField DataField="credits" HeaderText="credits" SortExpression="credits" />
                <asp:BoundField DataField="review" HeaderText="review" SortExpression="review" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:UsersConnectionString %>" SelectCommand="SELECT [courseTitle], [professorName], [description], [lectureHours], [credits], [review] FROM [Classes]"></asp:SqlDataSource>
    </form>
</body>
</html>
