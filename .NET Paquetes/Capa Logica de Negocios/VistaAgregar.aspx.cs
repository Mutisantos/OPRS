using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


public partial class VistaAgregar : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        bool validado = true;
        bool esCorrecto = true;
        String correcto = "";
        String direccion, localidad;
        PropiedadDataContext p = new PropiedadDataContext();
        PROPIEDAD prp = new PROPIEDAD();
        var propiedades = (from l in p.PROPIEDAD select l.ID).Max();
        prp.ID = propiedades + 1;
        String a = DireccionPropiedadTB.Text;
        validado = validarDireccion(p,a);

        if (validado==true && a != null)
        {
            try
            {
                prp.Tipo = ListaTipoPropiedad.SelectedItem.Text;
                if (prp.Tipo == "Seleccione tipo de propiedad")
                {
                    esCorrecto = false;
                    correcto += "No se selecciono un tipo de propiedad ";
                }                    
                prp.DIRECCION = DireccionPropiedadTB.Text;
                direccion = DireccionPropiedadTB.Text;
                prp.Localidad = UbicacionPropiedad.Text;
                localidad = UbicacionPropiedad.Text;
                if (prp.Localidad == "Seleccione Ubicacion")
                {
                    esCorrecto = false;
                    correcto += "No se selecciono un tipo de ubicacion ";
                } 
                try
                {
                    prp.NCuartos = Int32.Parse(NumeroHabitacionesTB.Text);
                }catch(Exception errorCuartos)
                {
                    correcto += "Número de cuartos no es un válido ";
                    esCorrecto = false;
                }
                try
                {
                    prp.Renta = Int32.Parse(RentaTB.Text);
                }
                catch (Exception errorRenta)
                {
                    correcto += "Valor de la renta no es correcto ";
                    esCorrecto = false;
                }

                if (IDPropietarioTB.Text == "")
                {
                    correcto += "ID de propietariono es correcto ";
                    esCorrecto = false;
                }
                else
                    prp.Propietario = IDPropietarioTB.Text;
                                
                if (esCorrecto == true)
                {
                    WS_SuperNotariado.NewWebService proxy = new WS_SuperNotariado.NewWebService();
                    bool wsNotariado = proxy.validar(direccion, localidad, Int32.Parse(NumeroHabitacionesTB.Text), Int32.Parse(RentaTB.Text));
                    if (wsNotariado == true)
                    {
                        p.PROPIEDAD.InsertOnSubmit(prp);
                        p.SubmitChanges();
                        Label1.Text = "Propiedad agregada exitosamente ";
                    }
                    else
                        Label1.Text = "La propiedad no existe en la Superintendencia de Notariado y Registro";
                }
                else
                    Label1.Text = correcto;
            }
            catch (Exception error)
            {
                Label1.Text = "Error al agregar la propiedad ";
            }
        }
        else
            if(a=="")
                Label1.Text = "Por favor ingrese una direccion.";
            else
                Label1.Text = "Error al agregar la propiedad, esta dirección ya existe.";

        ListaTipoPropiedad.SelectedIndex = 0;
        DireccionPropiedadTB.Text = "";
        UbicacionPropiedad.SelectedIndex = 0;
        NumeroHabitacionesTB.Text = "";
        NumeroHabitacionesTB.Text = "";
        RentaTB.Text = "";
        IDPropietarioTB.Text = "";
    }
    public bool validarDireccion(PropiedadDataContext p, String a)
    {
        bool validado = true;
        var variable = (from l in p.PROPIEDAD select l).ToList();
        foreach (PROPIEDAD pro in variable)
        {
            String b = pro.DIRECCION.ToString().Trim();
            if (a==b)
                validado = false;
        }
        return validado;
    }
    protected void Button1_Click1(object sender, EventArgs e)
    {
        Response.Redirect("menu.aspx");
    }
}