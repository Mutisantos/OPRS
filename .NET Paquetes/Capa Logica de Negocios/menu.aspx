<%@ Page Language="C#" AutoEventWireup="true" CodeFile="menu.aspx.cs" Inherits="menu" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
        <asp:Button ID="AGREGAR" runat="server" OnClick="AGREGAR_Click" Text="Agregar Propiedad" />
        <asp:Button ID="CRUD" runat="server" OnClick="CRUD_Click" Text="CRUD Propiedad" />
    </form>
</body>
</html>
