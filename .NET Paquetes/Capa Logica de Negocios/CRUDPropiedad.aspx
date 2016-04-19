<%@ Page Language="C#" AutoEventWireup="true" CodeFile="CRUDPropiedad.aspx.cs" Inherits="CRUDPropiedad" EnableEventValidation="true"%>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    
    <form id="form1" runat="server" aria-disabled="False">
    <div>
    
        <asp:Button ID="menu" runat="server" OnClick="menu_Click" Text="Regresar a menu" Width="120px" />
    
        <br />
        ID Propiedad:
        <asp:TextBox ID="IDPropiedadTB" runat="server"></asp:TextBox>
        <br />
        Propietario:&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="PropietarioTB" runat="server"></asp:TextBox>
        <br />
        Direccion:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="DireccionTB" runat="server"></asp:TextBox>
        <br />
        Renta:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="RentaTB" runat="server"></asp:TextBox>
        <br />
        Localidad:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="LocalidadTB" runat="server"></asp:TextBox>
        <br />
        Tipo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="TipoTB" runat="server"></asp:TextBox>
        <br />
        NCuartos:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="NCuartosTB" runat="server"></asp:TextBox>
            
    </div>
        <br />
        <asp:GridView ID="GridView2" runat="server" AutoGenerateColumns="False" DataSourceID="ObjectDataSource2" DataKeyNames="ID" OnSelectedIndexChanged="GridView2_SelectedIndexChanged">
            <Columns>
                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowSelectButton="True" />
                <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID"  />
                <asp:BoundField DataField="Propietario" HeaderText="Propietario" SortExpression="Propietario" />
                <asp:BoundField DataField="DIRECCION" HeaderText="DIRECCION" SortExpression="DIRECCION" />
                <asp:BoundField DataField="Renta" HeaderText="Renta" SortExpression="Renta" />
                <asp:BoundField DataField="Localidad" HeaderText="Localidad" SortExpression="Localidad" />
                <asp:BoundField DataField="Tipo" HeaderText="Tipo" SortExpression="Tipo" />
                <asp:BoundField DataField="NCuartos" HeaderText="NCuartos" SortExpression="NCuartos" />
            </Columns>
        </asp:GridView>
        <asp:ObjectDataSource ID="ObjectDataSource2" runat="server" DeleteMethod="eliminar" SelectMethod="buscar" TypeName="POCO" UpdateMethod="actualizar">
            <DeleteParameters>
                <asp:ControlParameter ControlID="GridView2" Name="id" PropertyName="SelectedDataKey" Type="Decimal" />
            </DeleteParameters>
            <SelectParameters>
                <asp:ControlParameter ControlID="IDPropiedadTB" Name="id" PropertyName="Text" Type="Int32" />
                <asp:ControlParameter ControlID="PropietarioTB" Name="propietario" PropertyName="Text" Type="String" />
                <asp:ControlParameter ControlID="DireccionTB" Name="direccion" PropertyName="Text" Type="String" />
                <asp:ControlParameter ControlID="RentaTB" Name="renta" PropertyName="Text" Type="Int32" />
                <asp:ControlParameter ControlID="LocalidadTB" Name="localidad" PropertyName="Text" Type="String" />
                <asp:ControlParameter ControlID="TipoTB" Name="tipo" PropertyName="Text" Type="String" />
                <asp:ControlParameter ControlID="NCuartosTB" Name="nCuartos" PropertyName="Text" Type="Int32" />
            </SelectParameters>
            <UpdateParameters>
                <asp:Parameter Name="id" Type="Int32" />
                <asp:Parameter Name="propietario" Type="String" />
                <asp:Parameter Name="direccion" Type="String" />
                <asp:Parameter Name="renta" Type="Int32" />
                <asp:Parameter Name="localidad" Type="String" />
                <asp:Parameter Name="tipo" Type="String" />
                <asp:Parameter Name="nCuartos" Type="Int32" />
            </UpdateParameters>
        </asp:ObjectDataSource>
        <br />
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Buscar" />
        <br />
        <br />
        <br />
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        <br />
        <br />
    </form>
</body>
</html>
