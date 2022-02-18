<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ForgotPassword.aspx.cs" Inherits="Finalprog.ForgotPassword" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body class="bg" style="font-size: x-large; text-align: center;">
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
    </style>
    <form id="form1" runat="server">
        <p>
            &nbsp;
        </p>
        <p>
            &nbsp;
        </p>
        <p>
            &nbsp;Enter Your Email Address:
        </p>
        <p>
            <asp:TextBox ID="txtEmail" runat="server" Height="20px" Width="250px"></asp:TextBox>
            &nbsp;&nbsp;&nbsp;
            <asp:Button class="outer1" ID="btnSend" runat="server" OnClick="btnSend_Click" Text="Send Recovery #" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
        </p>
        <p>
            <asp:Label ID="Label1" runat="server" Text="Label" Visible="False"></asp:Label>
        </p>
        <p>
            <asp:Label ID="lblConfirm" runat="server" Text="Recovery #:" Visible="False"></asp:Label>
            &nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txtConfirm" runat="server" Visible="False"></asp:TextBox>
            &nbsp;
            <asp:Button ID="btnComfirm" runat="server" OnClick="btnComfirm_Click" Text="Confirm" Visible="False" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
        </p>
        <p>
            <asp:Label ID="lblFalse" runat="server" Text="Incorrect Recovery #" Visible="False"></asp:Label>
        </p>
        <p>
            <asp:Label ID="lblNew" runat="server" Text="New Password: " Visible="False"></asp:Label>
            &nbsp;<asp:TextBox ID="txtNew" runat="server" Visible="False"></asp:TextBox>
        </p>
        <p>
            <asp:Label ID="lblNewConfirm" runat="server" Text="Confirm Password:" Visible="False"></asp:Label>
            &nbsp;
            <asp:TextBox ID="txtNewConfirm" runat="server" Visible="False"></asp:TextBox>
            &nbsp;&nbsp;
            <asp:Button class="outer1" ID="btnConfirmNew" runat="server" OnClick="btnConfirmNew_Click" Text="Confrim" Visible="False" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
        </p>
        <p>
            <asp:Label ID="lblChanged" runat="server" ForeColor="#00CC00" Text="Password Changed" Visible="False"></asp:Label>
        </p>
        <p>
            &nbsp;
        </p>
        <p>
            <asp:Button class="outer1" ID="btnReturn" runat="server" OnClick="btnReturn_Click" Text="Return to Login" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
        </p>
        <p>
            &nbsp;
        </p>
    </form>
</body>
</html>
