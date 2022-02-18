<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CoursePage.aspx.cs" Inherits="Finalprog.CoursePage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">


        .credits-logo {
            fill: currentColor;
            display: inline-block;
            vertical-align: bottom;
            width: 1.6em;
            height: 1.6em;
            margin: 0 0.5em 0 0;
        }

        svg {
            background: #ebe7e0;
        }

        .form-group {
            height: 249px;
            margin-bottom: 1px;
        }
    </style>
</head>
<body id="back" style="background-color: #ebe7e0">
    <form id="form1" runat="server">
        <div>
            <asp:Button ID="btnLogout" runat="server" Height="25px" OnClick="btnLogout_Click" Text="Log Out" Width="130px" BorderStyle="None" />
            
            <asp:Button ID="btnAdmin" runat="server" OnClick="btnAdmin_Click" Text="AdminPage" Visible="False" BorderStyle="None" Height="25px" Width="130px" />
            <asp:Button ID="btnUser" runat="server" OnClick="btnUser_Click" Text="User Page" BorderStyle="None" Height="25px" Width="130px" />
&nbsp;<asp:Button ID="btnCourseAdmin" runat="server" OnClick="btnCourseAdmin_Click" Text="Course Admin" BorderStyle="None" Height="25px" Width="130px" Visible="False" />
            <hr />
            <br />
            <br />
            <br />
            <asp:Label ID="lblCourse" runat="server" Style="font-weight: 700; font-size: xx-large" Text="Label"></asp:Label>
            <br />
            <asp:Panel ID="Panel11" runat="server" Height="32px" style="margin-left: 4px">
                <asp:Label ID="dailyAnn" runat="server" Font-Bold="True" Font-Size="X-Large" Text="Daily Annoucment: "></asp:Label>
                <asp:Label ID="announceLabel" runat="server" Text="Annoucment" Font-Size="Larger"></asp:Label>
            </asp:Panel>
            <br />
            <asp:Panel ID="test" runat="server" Height="59px">
                <asp:Panel ID="Panel2" runat="server">
                    <asp:Label ID="Label3" runat="server" Font-Bold="True" Font-Size="Larger" Text="Description: "></asp:Label>
                    <asp:Label ID="descriptionLabel" runat="server" Text="Discription"></asp:Label>
                    <asp:Panel ID="Panel3" runat="server">
                        <asp:Label ID="Label1" runat="server" Font-Bold="True" Font-Size="Larger" Text="Zoom Url: "></asp:Label>
                        <asp:Label ID="zoomLabel" runat="server" Text="Zoom"></asp:Label>
                        <asp:Panel ID="Panel4" runat="server">
                            <asp:Label ID="Label2" runat="server" Font-Bold="True" Font-Size="Larger" Text="Teacher: "></asp:Label>
                            <asp:Label ID="teachLabel" runat="server" Text="Teacher"></asp:Label>
                        </asp:Panel>
                    </asp:Panel>
                </asp:Panel>
            </asp:Panel>
            <asp:Panel ID="Panel6" runat="server" Height="102px" style="margin-left: 4px">
            </asp:Panel>
            <br />
            <br />
            <br />
        </div>

        <div class="form-group">
        </div>
        <asp:Panel ID="Panel8" runat="server">
        </asp:Panel>
        <asp:Panel ID="Panel10" runat="server">
            <asp:Button ID="testButton" runat="server" Height="46px" OnClick="testButton_Click" Text="Take Test" Width="85px" />
        </asp:Panel>
    </form>
</body>
</html>
