<%@ Page Language="C#" AutoEventWireup="true" CodeFile="VistaAgregar.aspx.cs" Inherits="VistaAgregar" %>

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
        Tipo de Propiedad:<asp:DropDownList ID="ListaTipoPropiedad" runat="server">
            <asp:ListItem Selected="True">Seleccione tipo de propiedad</asp:ListItem>
            <asp:ListItem>Casa</asp:ListItem>
            <asp:ListItem>Apartamento</asp:ListItem>
        </asp:DropDownList>
        <p>
            Dirección de Propiedad:<asp:TextBox ID="DireccionPropiedadTB" runat="server"></asp:TextBox>
        </p>
        <p>
            Ubicación:<asp:DropDownList ID="UbicacionPropiedad" runat="server">
                <asp:ListItem Selected="True">Seleccione Ubicacion</asp:ListItem>
                <asp:ListItem>Usaquen</asp:ListItem>
                <asp:ListItem>Chapinero</asp:ListItem>
                <asp:ListItem>Teusaquillo</asp:ListItem>
                <asp:ListItem>Bosa</asp:ListItem>
                <asp:ListItem>Suba</asp:ListItem>
                <asp:ListItem>Usme</asp:ListItem>
                <asp:ListItem>Keneddy</asp:ListItem>
                <asp:ListItem>Puente Aranda</asp:ListItem>
                <asp:ListItem>Santa Fe</asp:ListItem>
                <asp:ListItem>Fontobón</asp:ListItem>
                <asp:ListItem>Tunjuelito</asp:ListItem>
                <asp:ListItem>Barrios Unidos</asp:ListItem>
                <asp:ListItem>La Candelaria</asp:ListItem>
            </asp:DropDownList>
        </p>
        Número de Habitaciones:<asp:TextBox ID="NumeroHabitacionesTB" runat="server"></asp:TextBox>
        <p>
            Renta:<asp:TextBox ID="RentaTB" runat="server"></asp:TextBox>
        </p>
        ID Propietario:&nbsp;&nbsp;
        <asp:TextBox ID="IDPropietarioTB" runat="server"></asp:TextBox>
        <p>
            <asp:Button ID="AgregarPropiedad" runat="server" OnClick="Button1_Click" Text="Agregar Propiedad" />
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click1" Text="Regresar a menu" />
        </p>
        <p>
            &nbsp;</p>
        <asp:Label ID="Label1" runat="server" Text=" "></asp:Label>
    </form>
</body>
</html>
