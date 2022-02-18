<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="SearchPage.aspx.cs" Inherits="Finalprog.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
       
        <style>
        .rcorners1 {
        border-radius: 25px;
        background: ;
        }
        
        .center {
        position: absolute;
        left:50%;
        top:50%;
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
        outline: none;
        }

        .outer1 {
        margin: 5px 5px 5px 5px;
        display: inline-block;
        border-radius: 25px;
        background: #73AD21;
        justify-content: center;
        outline: none;
        }

        html {
         height:100%;
        }

        body {
          margin:0;
        }
        
        .bg {
          animation:slide 10s ease-in-out infinite alternate;
          background-image: linear-gradient(-60deg, #6c3 50%, #09f 50%);
          bottom:0;
          left:-50%;
          opacity:.5;
          position:fixed;
          right:-50%;
          top:0;
          z-index:-1;
        }
        
        .bg2 {
          animation-direction:alternate-reverse;
          animation-duration:10s;
        }
        
        .bg3 {
          animation-duration:12s;
        }
        
        @keyframes slide {
          0% {
            transform:translateX(-25%);
          }
          100% {
            transform:translateX(25%);
          }

          

        }
        </style>

        <div class="bg"></div>
        <div class="bg bg2"></div>
        <div class="bg bg3">
            <br />
            <br />
            <br />
        </div>



        <div class ="center" >
               <div id ="searchBox">
                    <asp:TextBox class="outer" Padding="20px" ID="txtSearch" runat="server" BorderStyle="Solid" Width="331px" Height="18px" Font-Names="Arial" BackColor="#CCCCCC" BorderColor="Black" BorderWidth="4px" Font-Bold="True" Font-Size="Large"></asp:TextBox>
                &nbsp;&nbsp;&nbsp;
                    <asp:Button class="outer" ID="btnSearch" runat="server" OnClick="btnSearch_Click" Text="Search" BorderStyle="Solid" Height="66px" Width="112px" Font-Names="Arial" BackColor="Transparent" BorderColor="Black" Font-Size="Large" BorderWidth="4px" Font-Bold="True" />
                </div>
            </div>


        

            

            <asp:Button class="outer1" ID="btnLogout" runat="server" bottom="95%" Height="50px" OnClick="btnLogout_Click" Text="Log Out" Width="130px" BorderStyle="Solid" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
            <asp:Button class="outer1" ID="btnAdmin" runat="server" OnClick="btnAdmin_Click" Text="Admin Page" Visible="False" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
            <asp:Button class="outer1" ID="btnUser" runat="server" OnClick="btnUser_Click" Text="User Page" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
&nbsp;</form>
</body>
</html>
