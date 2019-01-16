const Personal = require('./Personal')

const PersonalHistory =  {
    Id: "personalhistoryid",
    Propietario: Personal.Id,
    Accion: "Dio de alta el producto 5000 del contenedor 5",
    Hora: new Date().getTime()
  }
  Personal.PersonalHistory.push(PersonalHistory)

  module.exports = PersonalHistory