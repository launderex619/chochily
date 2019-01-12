Personal{
  Id: String,
  ImageSrc: String,
  Nombre: String,
  Codigo: String,
  Contratado: Date,
  Despedido: Date,
  Cargo: String,
  Correo: String,
  Tipo: String, //admin, user
  Contraseña: String,
},
HistorialPersonal{
  Id: String,
  Propietario: Personal.Id,
  Accion: String,
  Hora: Date
},

Contenedor{
  Id: String,
  Codigo: String,
  Tipo: String, //fresa o mermelada
  Disponible: Boolean
},

SaboresFresas{
  Id: String
  Sabor: String,
},

HistorialContenedores{
  Id: String,
  MovimientosPersonal: [Personal.Id],
  Contenedor: Contenedor.Id,
  DuracionTotal: Integer,
  FechaInicio: Date,
  FechaFin: Date,
  Estado: String, //fase actual
  DescripcionEstado?: String, //instrucciones para ejectuar en el estado actual
  ProximoMovimiento?: Date,
  PesoInicial?: Integer,
  PesoFinal?: Integer
  SaboresDestino?: [{
    Porcentaje: Integer,
    Sabor: SaboresFresas.Sabor
    }]
},

Inventario{
  Id: String,
  NombreProducto: String,
  CantidadAlmacen: Integer,
  TipoCantidad?: String, // kg, lts, unidades, etc
  MaximoDeseado?: Integer,
  LimiteAceptable: Integer,
  LimiteCritico: Integer,
  AltaPersonal: Personal.Id,
},

HistorialInventario{
  Id: String,
  Elemento: Inventario.Id,
  Movimiento: String, // compra, venta, alta, baja
  PrecioTotal: Integer,
  Fecha: Date,
  Cantidad?: Inventario.CantidadAlmacen,
  TipoCantidad?: Inventario.TipoCantidad,
  AltaPersonal: Personal.Id,
},

Produccion{
  Id: String,
  Nombre: String,
  Descripcion?: String,
  Tamaño?: String,
  Tipo?: String, // fresas, mermeladas, etc
  Sabor?: SaboresFresas.Id
  Precio?: Integer
},

HistorialProduccion{
  Id: String,
  AltaPersonal: Personal.Id,
  Tipo: Produccion.Id,
  Cantidad: Integer,
  Fecha: Date,
},

Alarmas{
  Id: String,
  Nombre: String,
  Tiempo: Integer,
  Inicio: Date,
  Fin: Date,
  Creador: String || Personal.Id || system
}
