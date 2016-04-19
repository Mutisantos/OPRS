﻿#pragma warning disable 1591
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.34209
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using System.Linq;
using System.Linq.Expressions;
using System.Reflection;



[global::System.Data.Linq.Mapping.DatabaseAttribute(Name="OPRSDB")]
public partial class PropiedadDataContext : System.Data.Linq.DataContext
{
	
	private static System.Data.Linq.Mapping.MappingSource mappingSource = new AttributeMappingSource();
	
  #region Definiciones de métodos de extensibilidad
  partial void OnCreated();
  partial void InsertPROPIEDAD(PROPIEDAD instance);
  partial void UpdatePROPIEDAD(PROPIEDAD instance);
  partial void DeletePROPIEDAD(PROPIEDAD instance);
  #endregion
	
	public PropiedadDataContext() : 
			base(global::System.Configuration.ConfigurationManager.ConnectionStrings["OPRSDBConnectionString1"].ConnectionString, mappingSource)
	{
		OnCreated();
	}
	
	public PropiedadDataContext(string connection) : 
			base(connection, mappingSource)
	{
		OnCreated();
	}
	
	public PropiedadDataContext(System.Data.IDbConnection connection) : 
			base(connection, mappingSource)
	{
		OnCreated();
	}
	
	public PropiedadDataContext(string connection, System.Data.Linq.Mapping.MappingSource mappingSource) : 
			base(connection, mappingSource)
	{
		OnCreated();
	}
	
	public PropiedadDataContext(System.Data.IDbConnection connection, System.Data.Linq.Mapping.MappingSource mappingSource) : 
			base(connection, mappingSource)
	{
		OnCreated();
	}
	
	public System.Data.Linq.Table<PROPIEDAD> PROPIEDAD
	{
		get
		{
			return this.GetTable<PROPIEDAD>();
		}
	}
}

[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.PROPIEDAD")]
public partial class PROPIEDAD : INotifyPropertyChanging, INotifyPropertyChanged
{
	
	private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
	
	private decimal _ID;
	
	private string _Propietario;
	
	private string _DIRECCION;
	
	private decimal _Renta;
	
	private string _Localidad;
	
	private string _Tipo;
	
	private int _NCuartos;
	
    #region Definiciones de métodos de extensibilidad
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDChanging(decimal value);
    partial void OnIDChanged();
    partial void OnPropietarioChanging(string value);
    partial void OnPropietarioChanged();
    partial void OnDIRECCIONChanging(string value);
    partial void OnDIRECCIONChanged();
    partial void OnRentaChanging(decimal value);
    partial void OnRentaChanged();
    partial void OnLocalidadChanging(string value);
    partial void OnLocalidadChanged();
    partial void OnTipoChanging(string value);
    partial void OnTipoChanged();
    partial void OnNCuartosChanging(int value);
    partial void OnNCuartosChanged();
    #endregion
	
	public PROPIEDAD()
	{
		OnCreated();
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_ID", DbType="Decimal(38,0) NOT NULL", IsPrimaryKey=true)]
	public decimal ID
	{
		get
		{
			return this._ID;
		}
		set
		{
			if ((this._ID != value))
			{
				this.OnIDChanging(value);
				this.SendPropertyChanging();
				this._ID = value;
				this.SendPropertyChanged("ID");
				this.OnIDChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Propietario", DbType="NChar(30) NOT NULL", CanBeNull=false)]
	public string Propietario
	{
		get
		{
			return this._Propietario;
		}
		set
		{
			if ((this._Propietario != value))
			{
				this.OnPropietarioChanging(value);
				this.SendPropertyChanging();
				this._Propietario = value;
				this.SendPropertyChanged("Propietario");
				this.OnPropietarioChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_DIRECCION", DbType="NChar(50) NOT NULL", CanBeNull=false)]
	public string DIRECCION
	{
		get
		{
			return this._DIRECCION;
		}
		set
		{
			if ((this._DIRECCION != value))
			{
				this.OnDIRECCIONChanging(value);
				this.SendPropertyChanging();
				this._DIRECCION = value;
				this.SendPropertyChanged("DIRECCION");
				this.OnDIRECCIONChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Renta", DbType="Decimal(30,0) NOT NULL")]
	public decimal Renta
	{
		get
		{
			return this._Renta;
		}
		set
		{
			if ((this._Renta != value))
			{
				this.OnRentaChanging(value);
				this.SendPropertyChanging();
				this._Renta = value;
				this.SendPropertyChanged("Renta");
				this.OnRentaChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Localidad", DbType="NChar(20) NOT NULL", CanBeNull=false)]
	public string Localidad
	{
		get
		{
			return this._Localidad;
		}
		set
		{
			if ((this._Localidad != value))
			{
				this.OnLocalidadChanging(value);
				this.SendPropertyChanging();
				this._Localidad = value;
				this.SendPropertyChanged("Localidad");
				this.OnLocalidadChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Tipo", DbType="NVarChar(50) NOT NULL", CanBeNull=false)]
	public string Tipo
	{
		get
		{
			return this._Tipo;
		}
		set
		{
			if ((this._Tipo != value))
			{
				this.OnTipoChanging(value);
				this.SendPropertyChanging();
				this._Tipo = value;
				this.SendPropertyChanged("Tipo");
				this.OnTipoChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NCuartos", DbType="Int NOT NULL")]
	public int NCuartos
	{
		get
		{
			return this._NCuartos;
		}
		set
		{
			if ((this._NCuartos != value))
			{
				this.OnNCuartosChanging(value);
				this.SendPropertyChanging();
				this._NCuartos = value;
				this.SendPropertyChanged("NCuartos");
				this.OnNCuartosChanged();
			}
		}
	}
	
	public event PropertyChangingEventHandler PropertyChanging;
	
	public event PropertyChangedEventHandler PropertyChanged;
	
	protected virtual void SendPropertyChanging()
	{
		if ((this.PropertyChanging != null))
		{
			this.PropertyChanging(this, emptyChangingEventArgs);
		}
	}
	
	protected virtual void SendPropertyChanged(String propertyName)
	{
		if ((this.PropertyChanged != null))
		{
			this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
		}
	}
}
#pragma warning restore 1591
