using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


public partial class CRUDPropiedad : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

        POCO poco = new POCO();

    }
    protected void menu_Click(object sender, EventArgs e)
    {
        Response.Redirect("menu.aspx");
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
       
    }
    protected void GridView2_SelectedIndexChanged(object sender, EventArgs e)
    {
        

    }

    

    


   
}