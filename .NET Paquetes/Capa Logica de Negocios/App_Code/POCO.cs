using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de POCO
/// </summary>
public class POCO
{

    PropiedadDataContext p = new PropiedadDataContext();

    public POCO()
    {

    }

    public bool eliminar(Decimal id)
    {
        /*
        //fetch the connection string from web.config
        string connString =
             ConfigurationManager.ConnectionStrings["OPRSDBConnectionString1"].ConnectionString;
        //SQL statement to delete from products
        string sql = String.Format(@"Delete from propiedad
                                    where ID = {0}",
                                        id);
        using (SqlConnection conn = new SqlConnection(connString))
        {
            conn.Open();
            //Initialize command object
            using (SqlCommand cmd = new SqlCommand(sql, conn))
            {
                cmd.ExecuteNonQuery();
            }
        }
        */

        
        var query = from pro in p.PROPIEDAD
                    where pro.ID == id
                    select pro;

        foreach (PROPIEDAD pro in query)
        {
            p.PROPIEDAD.DeleteOnSubmit(pro);
        }

        try
        {
            p.SubmitChanges();
            return true;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            // Provide for exceptions.
        }

        return false;
    }

    public void actualizar(int id, String propietario, String direccion, int renta, String localidad, String tipo, int nCuartos)
    {

        var query = from pro in p.PROPIEDAD
                    where pro.ID == id
                    select pro;

        foreach (PROPIEDAD pro in query)
        {
            pro.DIRECCION = direccion;
            pro.Localidad = localidad;
            pro.Propietario = propietario;
            pro.Tipo = tipo;
            pro.NCuartos = nCuartos;
            pro.Renta = renta;
            // Insert any additional changes to column values.
        }

        try
        {
            p.SubmitChanges();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            // Provide for exceptions.
        }
    }

    public List<PROPIEDAD> buscar(int id, String propietario, String direccion, int renta, String localidad, String tipo, int nCuartos)
    {
        List<PROPIEDAD> propiedades = new List<PROPIEDAD>();
        List<PROPIEDAD> propiedadesAux = new List<PROPIEDAD>();
       

        if (id != null)
        {
            propiedadesAux = null;
            propiedadesAux = buscarID(id);
            foreach (PROPIEDAD pro in propiedadesAux)
            {
                propiedades.Add(pro);
                
            }
        }

        if ((propietario != null) && (id == null))
        {
            propiedadesAux = null;
            propiedadesAux = buscarPropietario(propietario);
            foreach (PROPIEDAD pro in propiedadesAux)
            {
                propiedades.Add(pro);
            }
        }

        if ((direccion != null) && (id == null) && (propietario == null))
        {
            propiedadesAux = null;
            propiedadesAux = buscarDireccion(direccion);
            foreach (PROPIEDAD pro in propiedadesAux)
            {
                propiedades.Add(pro);
            }
        }

        if ((renta != null) && (id == null) && (propietario == null) && (direccion == null))
        {
            propiedadesAux = null;
            propiedadesAux = buscarRenta(renta);
            foreach (PROPIEDAD pro in propiedadesAux)
            {
                propiedades.Add(pro);
            }
        }

        if ((tipo != null) && (id == null) && (propietario == null) && (direccion == null) && (renta == null))
        {
            propiedadesAux = null;
            propiedadesAux = buscarTipo(tipo);
            foreach (PROPIEDAD pro in propiedadesAux)
            {
                propiedades.Add(pro);
            }
        }

        if ((localidad != null) && (id == null) && (propietario == null) && (direccion == null) && (renta == null) && (tipo == null))
        {
            propiedadesAux = null;
            propiedadesAux = buscarLocalidad(localidad);
            foreach (PROPIEDAD pro in propiedadesAux)
            {
                propiedades.Add(pro);
            }
        }

        if ((nCuartos != null) && (localidad == null) && (id == null) && (propietario == null) && (direccion == null) && (renta == null) && (tipo == null))
        {
            propiedadesAux = null;
            propiedadesAux = buscarNCUartos(nCuartos);
            foreach (PROPIEDAD pro in propiedadesAux)
            {
                propiedades.Add(pro);
            }
        }

        return propiedades;
    }

    
    
    //verificar existencia en lista
    //public List<PROPIEDAD> existe();
    
    
    //Buscar por Renta
    public List<PROPIEDAD> buscarRenta(int renta)
    {

        return (from pr in p.PROPIEDAD
                where pr.Renta == renta
                select pr).ToList();
    }

    //Buscar por ID
    public List<PROPIEDAD> buscarID(int id)
    {

        return (from pr in p.PROPIEDAD
                where pr.ID == id
                select pr).ToList();
    }

    //Buscar por Propietario 
    public List<PROPIEDAD> buscarPropietario(String propietario)
    {

        return (from pr in p.PROPIEDAD
                where pr.Propietario == propietario
                select pr).ToList();
    }

    //Buscar por Direccion 
    public List<PROPIEDAD> buscarDireccion(String direccion)
    {

        return (from pr in p.PROPIEDAD
                where pr.DIRECCION == direccion
                select pr).ToList();
    }

    //Buscar por Localidad 
    public List<PROPIEDAD> buscarLocalidad(String localidad)
    {

        return (from pr in p.PROPIEDAD
                where pr.Localidad == localidad
                select pr).ToList();
    }

    //Buscar por Tipo 
    public List<PROPIEDAD> buscarTipo(String tipo)
    {

        return (from pr in p.PROPIEDAD
                where pr.Tipo == tipo
                select pr).ToList();
    }

    //Buscar por NCuartos 
    public List<PROPIEDAD> buscarNCUartos(int nCuartos)
    {

        return (from pr in p.PROPIEDAD
                where pr.NCuartos == nCuartos
                select pr).ToList();
    }
}