using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de WSFinanciero
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class WSFinanciero : System.Web.Services.WebService {

    public WSFinanciero () {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public int ListaClientes(string numTar, string tipoTar, string nombre, int mesExp, int anoExp, string email, float renta)
    {
        bool validado = false;
        int consecutivo = 1000;
        int contador = 0;
        ClienteCorrienteDataContext cc = new ClienteCorrienteDataContext();
        Regex rcorreo = new Regex(@"\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*");
        
        var clientes = (from c in cc.ClienteCorriente select c).ToList();
        foreach (ClienteCorriente c in clientes)
        {
            if (numTar.Length == 16 && c.numeroTarjeta.Equals(numTar))
            {
                if (rcorreo.IsMatch(email))
                {
                    if (c.tipoTarjeta.Equals(tipoTar) && c.nombreUsuario.Equals(nombre) && c.mesExpiracion == mesExp && c.anoExpiracion == anoExp && c.email.Equals(email))
                        if(c.cupo>=renta)
                        {
                            validado = true;
                            c.cupo = c.cupo - renta;
                            cc.SubmitChanges();
                        }
                            
                } 
            }
            contador++;
        }
        contador++;
        if (validado)
            consecutivo += contador;
        else
            consecutivo = -1;
        return consecutivo;
    }   
}
