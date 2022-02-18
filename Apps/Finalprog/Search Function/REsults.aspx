<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Results.aspx.cs" Inherits="Finalprog.REsults" enableeventvalidation="false" %>

<!DOCTYPE html>
<form id="form2" runat="server" defaultbutton="btnResultsSearch">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <link rel="stylesheet" href="Results.css" />                <!-- This is the link to the Page Specific .css file. -->
    <link rel="stylesheet" href="Navigation Bar.css" />         <!-- This is the link to the Navigation bar's .css file. -->
    <title></title>
    <style>
        body,
         html{
         height: 100%;
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
         .Results{
          position: fixed;
          width: 1000px;
          height: 2000px;
          left: 50%;
          top: 15%;
          margin-left: -500px; /*half the width*/
          text-align: left;
          overflow-y:scroll;
          overflow: hidden;
         }
         .SearchBar{
          position: fixed;
          width: 1000px;
          height: 2000px;
          left: 50%;
          top: 8%;
          margin-left: -500px;
          text-align: left;
          border-radius: 25px;
          outline: none;
         }
         .SearchButton{
          position: fixed;
          left: 93%;
          top: 8%;
          margin-left: -500px;
          text-align: center;
          height: 54px;
          border-radius: 25px;
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
         .hyperlink{
             font-family: Arial;
             font-size: x-large
         }
         .courseNumber{
             font-family: Arial;
             font-size: large
         }
         .description{
             font-family: Times New Roman;
             font-size: large
         }

    </style>
</head>
<body class ="bg">
        <div>
            <div class="NavBar" runat="server">
                <asp:Button class="outer1" ID="btnLogout" runat="server" bottom="95%" Height="50px" OnClick="btnLogout_Click" Text="Log Out" Width="130px" BorderStyle="Solid" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
                <asp:Button class="outer1" ID="btnAdmin" runat="server" OnClick="btnAdmin_Click" Text="Admin Page" Visible="False" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
                <asp:Button class="outer1" ID="btnUser" runat="server" OnClick="btnUser_Click" Text="User Page" BorderStyle="Solid" Height="50px" Width="130px" BackColor="Transparent" BorderWidth="3px" BorderColor="Black" Font-Bold="True" Font-Size="Medium" ForeColor="Black" Font-Names="Arial" />
            </div>
        </div>
        <!-- This is for the search bar. -->
        <div class="SearchBar">
            <asp:TextBox class="outer" ID="txtResultsSearch" runat="server" Width="800px" Height="45px" CssClass="SearchBar" BackColor="#CCCCCC" BorderColor="Black" BorderStyle="Solid" BorderWidth="4px"></asp:TextBox>
            <asp:Button class="outer" ID="btnResultsSearch" runat="server" OnClick="btnResultsSearch_Click" Text="Search" CssClass="SearchButton" Width="150px" BackColor="Transparent" BorderColor="Black" BorderStyle="Solid" BorderWidth="4px" Font-Bold="True" Font-Italic="False" Font-Names="Arial" Font-Size="Large" ForeColor="Black"/>
        </div>

    <div id ="divResults" class="Results" runat="server">
    </div>



</body>
</html>
</form>