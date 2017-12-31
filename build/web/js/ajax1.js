//REUTILIZABLES CON JQUERY

function Ajax(tipoparametro,servlet,div){
    $.ajax(
        {   type:tipoparametro,
            dataType:"html",
            url:"/CampusFramework_Original/faces/"+servlet+".xhtml",
            success:function(datos)
            {
                $(div).html(datos);
            }
    }); 
}

function Opciones(pagina){
    Ajax('GET',pagina,'#contenido1');
}

function grabar1(ruta, tabla, op, parametros)
{
    Ajax("GET",ruta,tabla,op,parametros,"#contenido1");
}

function eliminar(ruta, tabla, op, parametros)
{
  
    Ajax("GET",ruta,tabla,op,parametros,"#contenido1");  
 
}

//salir de un formulario
function salir(ruta,servlet,op,parametros)
{
    Ajax("GET",ruta,servlet,op,parametros,"#contenido1");
}

function modificar(ruta, tabla, op, parametros)
{
   Ajax("GET",ruta,tabla,op,parametros,"#contenido1");  
}


function cargar(ruta, tabla, op, parametros)
{
  Ajax("GET",ruta,tabla,op,parametros,"#contenido1");
}
function Menu(ruta,servlet,op,parametros)
{
    Ajax("GET",ruta,servlet,op,parametros,"#contenido1");
}


//login
function enter(ruta)
{
    var rutatotal, usuario,clave,seleccion;
    rutatotal=ruta+"/UsuarioServlet?op=1";
    usuario=document.form.txtnombre.value;
    clave=document.form.txtcontra.value;
    seleccion=document.getElementById('txtseleccion').value;
    if(seleccion=='0')
    {
        alert("SELECCIONAR CATEGORIA PARA INGRESAR");
        document.form.txtseleccion.focus();
        return ;
    }else if(usuario=='')
    {
        alert("Ingrese el usuario por favor!!");
        document.form.txtnombre.focus();
        return;
    }else if(clave=='')
    {
        alert("Ingrese la clave por favor!!");
        document.form.txtcontra.focus();
        return;
    }else{
        document.form.action=rutatotal;
        document.form.method="POST";
        document.form.submit();;
    }
}

function grabarLibros(ruta)
{
    var num,nomb,autor,ejemplar,estado;
    num=document.getElementById('txtcod').value;
    nomb=document.getElementById('txtnom').value;
    autor=document.getElementById('txtautor').value;
    ejemplar=document.getElementById('txtejemplar').value;
    estado=document.getElementById('txtestado').value;
    var parametros = '';
    parametros = "txtcod=" + num + "&";
    parametros += "txtnom=" + nomb + "&";
    parametros += "txtautor=" + autor + "&";
    parametros += "txtejemplar=" + ejemplar + "&";
    parametros += "txtestado=" + estado;
    if(num=='')
    {
        alert("Elija el codigo del libro");
        document.form.txtcod.focus();
        return;
    }else if(nomb=='')
    {
        alert("Ingrese el nombre del libro");
        document.form.txtnom.focus();
        return;
    }else if(autor=='')
    {
        alert("Ingrese el autor del libro");
        document.form.txtautor.focus();
        return;  
    }else if(ejemplar=='')
    {
        alert("Ingrese cantidad de ejemplares");
        document.form.txtejemplar.focus();
        return;
    }else if(estado=='0')
    {
        alert("Ingrese el estado del libro");
        document.form.txtestado.focus();
        return;
    }else
    {
        grabar1(ruta,'Libro', 3, parametros);
    }
}

function modificarLibros(ruta)
{
    var num,nomb,autor,ejemplar,estado;
    num=document.getElementById('txtcod').value;
    nomb=document.getElementById('txtnom').value;
    autor=document.getElementById('txtautor').value;
    ejemplar=document.getElementById('txtejemplar').value;
    estado=document.getElementById('txtestado').value;
    var parametros = '';
    parametros = "txtcod=" + num + "&";
    parametros += "txtnom=" + nomb + "&";
    parametros += "txtautor=" + autor + "&";
    parametros += "txtejemplar=" + ejemplar + "&";
    parametros += "txtestado=" + estado;
    if(num=='')
    {
        alert("Elija el codigo del libro");
        document.form.txtcod.focus();
        return;
    }else if(nomb=='')
    {
        alert("Ingrese el nombre del libro");
        document.form.txtnom.focus();
        return;
    }else if(autor==''){
        alert("Ingrese el autor del libro");
        document.form.txtautor.focus();
        return;    
    }else if(ejemplar==''){
        alert("Ingrese cantidad de ejemplares");
        document.form.txtejemplar.focus();
        return;
    }else if(estado=='0'){
        alert("Ingrese el estado del libro");
        document.form.txtestado.focus();
        return;
    }else
    {
        modificar(ruta,'Libro', 6, parametros);
    }
}
            
function  grabarlaboratorio(ruta){
    var num,nomb,estado;
    num=document.getElementById('txtcod').value;
    nomb=document.getElementById('txtnom').value;
    estado=document.getElementById('txtestado').value;
    var parametros = '';
    parametros = "txtcod=" + num + "&";
    parametros += "txtnom=" + nomb + "&";
    parametros += "txtestado=" + estado;
    if(num=='')
    {
        alert("Elija el codigo del laboratorio");
        document.form.txtcod.focus();
        return;
    }else if(nomb=='')
    {
        alert("Ingrese el nombre del laboratoio");
        document.form.txtnom.focus();
        return;
    }else if(estado=='0')
    {
        alert("Ingrese el estado del laboratorio");
        document.form.txtestado.focus();
        return;
    }else
    {
        grabar1(ruta,'Laboratorio', 3, parametros);
    }
}
function  modificarlaboratorio(ruta){
    var num,nomb,estado;
    num=document.getElementById('txtcod').value;
    nomb=document.getElementById('txtnom').value;
    estado=document.getElementById('txtestado').value;
    var parametros = '';
    parametros = "txtcod=" + num + "&";
    parametros += "txtnom=" + nomb + "&";
    parametros += "txtestado=" + estado;
    if(num=='')
    {
        alert("Elija el codigo del laboratorio");
        document.form.txtcod.focus();
        return;
    }else if(nomb=='')
    {
        alert("Ingrese el nombre del laboratoio");
        document.form.txtnom.focus();
        return;
    }else if(estado=='0')
    {
        alert("Ingrese el estado del laboratorio");
        document.form.txtestado.focus();
        return;
    }else
    {
        modificar(ruta,'Laboratorio', 6, parametros);
    }
}
function  grabaActividad(ruta){
                 var num,nomb,int,estado;
                num=document.getElementById('txtcod').value;
                nomb=document.getElementById('txtnom').value;
                int=document.getElementById('txtinteg').value;
                estado=document.getElementById('txtestado').value;
               

  
    var parametros = '';
    
                        parametros = "txtcod=" + num + "&";
                        parametros += "txtnom=" + nomb + "&";
                        parametros += "txtinteg=" +int + "&";
                        parametros += "txtestado=" + estado;
                     
                         
                    if(num==''){
                    alert("Elija el codigo de la actividad");
                    document.form.txtcod.focus();
                    return;
                }else
                         
                if(nomb==''){
                    alert("Ingrese el nombre de la Actividad");
                    document.form.txtnom.focus();
                    return;
                }else
                if(int==''){
                    alert("Ingrese los integrantes de la Actividad");
                    document.form.txtinteg.focus();
                    return;
                }else if(estado=='0'){
                    alert("Ingrese el estado de la actividad");
                    document.form.txtestado.focus();
                    return;
                }else{
                    grabar1(ruta,'Actividad', 3, parametros);
                }
            }
function  modificaractividad(ruta){
                 var num,nomb,int,estado;
                num=document.getElementById('txtcod').value;
                nomb=document.getElementById('txtnom').value;
                int=document.getElementById('txtinteg').value;
                estado=document.getElementById('txtestado').value;
               

  
    var parametros = '';
    
                        parametros = "txtcod=" + num + "&";
                        parametros += "txtnom=" + nomb + "&";
                        parametros += "txtinteg=" + int +"&";
                        parametros += "txtestado=" + estado;
                     
                         
                      if(num==''){
                    alert("Elija el codigo de la actividad");
                    document.form.txtcod.focus();
                    return;
                }else
                         
                if(nomb==''){
                    alert("Ingrese el nombre de la actividad");
                    document.form.txtnom.focus();
                    return;
                }else
                         
                if(int==''){
                    alert("Ingrese los integrantes de la actividad");
                    document.form.txtinteg.focus();
                    return;
                }else if(estado=='0'){
                    alert("Ingrese el estado de la actividad");
                    document.form.txtestado.focus();
                    return;
                }else{
                    modificar(ruta,'Actividad', 6, parametros);
                }
            }
            


function grabarReservaLibros(ruta)
{
    var num,libro,alumno,fechaentrega,fechadevolucion;
    num=document.getElementById('txtnumreserva').value;
    libro=document.getElementById('cbolibro').value;
    alumno=document.getElementById('cboalumno').value;
    fechaentrega=document.getElementById('txtfechaentrega').value;
    fechadevolucion=document.getElementById('txtfechadevolucion').value;
    var parametros = '';
    parametros = "txtnumreserva=" + num + "&";
    parametros += "cbolibro=" + libro + "&";
    parametros += "cboalumno=" + alumno + "&";
    parametros += "txtfechaentrega=" + fechaentrega + "&";
    parametros += "txtfechadevolucion=" + fechadevolucion;
    if(num=='')
    {
        alert("Elija el codigo del libro");
        document.form.txtnumreserva.focus();
        return;
    }else if(libro=='0')
    {
        alert("Ingrese el nombre del libro");
        document.form.cbolibro.focus();
        return;
    }else if(fechaentrega=='')
    {
        alert("Ingrese la fecha de entrega");
        document.form.txtfechaentrega.focus();
        return;
    }else if(fechadevolucion=='')
    {
        alert("Ingrese la fecha de devolucion");
        document.form.txtfechadevolucion.focus();
        return;
    }else
    {
        grabar1(ruta,'ReservaLibro', 3, parametros);
    }
}

function modificarReservaLibros(ruta)
{
    var num,libro,alumno,fechaentrega,fechadevolucion;
    num=document.getElementById('txtnumreserva').value;
    libro=document.getElementById('cbolibro').value;
    alumno=document.getElementById('cboalumno').value;
    fechaentrega=document.getElementById('txtfechaentrega').value;
    fechadevolucion=document.getElementById('txtfechadevolucion').value;
    var parametros = '';
    parametros = "txtnumreserva=" + num + "&";
    parametros += "cbolibro=" + libro + "&";
    parametros += "cboalumno=" + alumno + "&";
    parametros += "txtfechaentrega=" + fechaentrega + "&";
    parametros += "txtfechadevolucion=" + fechadevolucion;
    if(num=='')
    {
        alert("Elija el codigo del libro");
        document.form.txtnumreserva.focus();
        return;
    }else if(libro=='0')
    {
        alert("Ingrese el nombre del libro");
        document.form.cbolibro.focus();
        return;
    }else if(fechaentrega=='')
    {
        alert("Ingrese la fecha de entrega");
        document.form.txtfechaentrega.focus();
        return;
    }else if(fechadevolucion=='')
    {
        alert("Ingrese la fecha de devolucion");
        document.form.txtfechadevolucion.focus();
        return;
    }else
    {
        modificar(ruta,'ReservaLibro', 5, parametros);
    }
}
function grabarReservaActividad(ruta)
{
    var num,acti,estu,dia,hora;
    num=document.getElementById('txtcod').value;
    acti=document.getElementById('txtacti').value;
    estu=document.getElementById('txtestu').value;
    dia=document.getElementById('txtdia').value;
    hora=document.getElementById('txthora').value;
    var parametros = '';
    parametros = "txtcod=" + num + "&";
    parametros += "txtacti=" + acti + "&";
    parametros += "txtestu=" + estu+"&";
    parametros += "txtdia=" + dia+ "&";
    parametros += "txthora=" + hora;
    if(num==''){
        alert("Elija el codigo de la reserva");
        document.form.txtcod.focus();
        return;
    }else if(acti=='0'){
        alert("Ingrese la actividad a reservar");
        document.form.txtacti.focus();
        return;
    }else if(estu==''){
        alert("Ingrese el estudiante");
        document.form.txtestu.focus();
        return;
    }else if(dia==''){
        alert("Ingrese el dia de la reserva");
        document.form.txtdia.focus();
        return;
    }else if(hora==''){
        alert("Ingrese la hora de la reserva");
        document.form.txthora.focus();
        return;
    }else{
        grabar1(ruta,'ReservaActividad', 3, parametros);
    }
}

function modificarReservaActividad(ruta)
{
    var num,acti,estu,dia,hora;
    num=document.getElementById('txtcod').value;
    acti=document.getElementById('txtacti').value;
    estu=document.getElementById('txtestu').value;
    dia=document.getElementById('txtdia').value;
    hora=document.getElementById('txthora').value;
    var parametros = '';
    parametros = "txtcod=" + num + "&";
    parametros += "txtacti=" + acti + "&";
    parametros += "txtestu=" + estu+"&";
    parametros += "txtdia=" + dia+ "&";
    parametros += "txthora=" + hora;
    if(num==''){
        alert("Elija el codigo de la reserva");
        document.form.txtcod.focus();
        return;
    }else if(acti=='0'){
        alert("Ingrese la actividad a reservar");
        document.form.txtacti.focus();
        return;
    }else if(estu==''){
        alert("Ingrese el estudiante");
        document.form.txtestu.focus();
        return;
    }else if(dia==''){
        alert("Ingrese el dia de la reserva");
        document.form.txtdia.focus();
        return;
    }else if(hora==''){
        alert("Ingrese la hora de la reserva");
        document.form.txthora.focus();
        return;
    }else{
        modificar(ruta,'ReservaActividad', 6, parametros);
    }
}

function grabarReservaLaboratorio(ruta)
{
    var idreslab,lab,estu,horainicio,horafin,dia;
    idreslab=document.getElementById('txtidreslab').value;
    lab=document.getElementById('txtlab').value;
    estu=document.getElementById('txtestu').value;
    horainicio=document.getElementById('txthorainicio').value;
    horafin=document.getElementById('txthorafin').value;
    dia=document.getElementById('txtdia').value;
    
    var parametros = '';
    parametros = "txtidreslab=" + idreslab + "&";
    parametros += "txtlab=" + lab + "&";
    parametros += "txtestu=" + estu+"&";
    parametros += "txthorainicio=" + horainicio+"&";
    parametros += "txthorafin=" + horafin+"&"; 
    parametros += "txtdia=" + dia;
    
    if(idreslab==''){
        alert("Elija el codigo de la reserva");
        document.form.txtcod.focus();
        return;
    }else if(lab=='0'){
        alert("Ingrese la laboratorio a reservar");
        document.form.txtacti.focus();
        return;
    }else if(estu==''){
        alert("Ingrese el estudiante");
        document.form.txtestu.focus();
        return;
    }else if(horainicio==''){
        alert("Ingrese la horainicio de la reserva");
        document.form.txtdia.focus();
        return;
    }else if(horafin==''){
        alert("Ingrese la horafin de la reserva");
        document.form.txthora.focus();
        return;
    }else if(dia==''){
        alert("Ingrese el dia de la reserva");
        document.form.txthorafin.focus();
        return;
    }else{    
        grabar1(ruta,'ReservaLaboratorio', 3, parametros);
        
        
    }
}

function modificarReservaLaboratorio(ruta)
{
    var idreslab,lab,estu,horainicio,horafin,dia;
    idreslab=document.getElementById('txtidreslab').value;
    lab=document.getElementById('txtlab').value;
    estu=document.getElementById('txtestu').value;
    horainicio=document.getElementById('txthorainicio').value;
    horafin=document.getElementById('txthorafin').value;
    dia=document.getElementById('txtdia').value;
    
    var parametros = '';
    parametros = "txtidreslab=" + idreslab + "&";
    parametros += "txtlab=" + lab + "&";
    parametros += "txtestu=" + estu+"&";
    parametros += "txthorainicio=" + horainicio+"&";
    parametros += "txthorafin=" + horafin+"&"; 
    parametros += "txtdia=" + dia;
    
    if(idreslab==''){
        alert("Elija el codigo de la reserva");
        document.form.txtcod.focus();
        return;
    }else if(lab=='0'){
        alert("Ingrese la laboratorio a reservar");
        document.form.txtacti.focus();
        return;
    }else if(estu==''){
        alert("Ingrese el estudiante");
        document.form.txtestu.focus();
        return;
    }else if(horainicio==''){
        alert("Ingrese la horainicio de la reserva");
        document.form.txtdia.focus();
        return;
    }else if(horafin==''){
        alert("Ingrese la horafin de la reserva");
        document.form.txthora.focus();
        return;
    }else if(dia==''){
        alert("Ingrese el dia de la reserva");
        document.form.txthorafin.focus();
        return;
    }else{    
        modificar(ruta,'ReservaLaboratorio', 6, parametros);  
    }
}

function modificarclave(ruta,para)
{
    var clave,repetir;
    clave=document.getElementById('txtclavenueva').value;
    repetir=document.getElementById('txtrepetirclave').value;
    var parametros = '';
    parametros = "txtclavenueva=" + clave + "&";
    parametros += "txtrepetirclave=" + repetir;
    if(clave=='')
    {
        alert("Ingrese la clave nueva");
        document.form.txtclavenueva.focus();
        return;
    }else if(repetir=='')
    {
        alert("Ingrese repetir clave nueva");
        document.form.txtrepetirclave.focus();
        return;
    }else
    {
        modificar(ruta,'Usuario', 11, parametros+"&"+para);
    }
}

function  modificardatos(ruta)
{
    var cod,nombre,correo,telefono,direccion;
    cod=document.getElementById('txtcod').value;
    nombre=document.getElementById('txtnombre').value;
    correo=document.getElementById('txtcorreo').value;
    telefono=document.getElementById('txttelefono').value;
    direccion=document.getElementById('txtdireccion').value;
    var parametros = '';
    parametros = "txtcod=" + cod + "&";
    parametros += "txtnombre=" + nombre + "&";
    parametros += "txtcorreo=" + correo + "&";
    parametros += "txttelefono=" + telefono + "&";
    parametros += "txtdireccion=" + direccion;
    if(cod=='')
    {
        alert("Elija el codigo del usuario");
        document.form.txtcod.focus();
        return;
    }else if(nombre=='')
    {
        alert("Ingrese el nombre del usuario");
        document.form.txtnombre.focus();
        return;
    }else if(correo==''){
        alert("Ingrese el correo del usuario");
        document.form.txtcorreo.focus();
        return;
    }else if(telefono==''){
        alert("Ingrese el telefono del usuario");
        document.form.txttelefono.focus();
        return;
    }else if(direccion==''){
        alert("Ingrese la direccion del usuario");
        document.form.txtdireccion.focus();
        return;
    }else
    {
        modificar(ruta,'Usuario', 13, parametros);
    }
}

   function  grabarusuario(ruta){
                var cod,nombre,correo,telefono,direccion,usuario,clave,tipousuario;
                cod=document.getElementById('txtcod').value;
                nombre=document.getElementById('txtnombre').value;
                correo=document.getElementById('txtcorreo').value;
                telefono=document.getElementById('txttelefono').value;
                direccion=document.getElementById('txtdireccion').value;
                usuario=document.getElementById('txtusuario').value;
                clave=document.getElementById('txtclave').value;
                tipousuario=document.getElementById('txttipousuario').value;

  
    var parametros = '';
    
                        parametros = "txtcod=" + cod + "&";
                        parametros += "txtnombre=" + nombre + "&";
                        parametros += "txtcorreo=" + correo + "&";
                        parametros += "txttelefono=" + telefono + "&";
                        parametros += "txtdireccion=" + direccion + "&";
                        parametros += "txtusuario=" + usuario + "&";
                        parametros += "txtclave=" + clave + "&";
                        parametros += "txttipousuario=" + tipousuario;
                     
                         
                    if(cod==''){
                    alert("Elija el codigo del usuario");
                    document.form.txtcod.focus();
                    return;
                }else
                         
                if(nombre==''){
                    alert("Ingrese el nombre del usuario");
                    document.form.txtnombre.focus();
                    return;
                }else
                if(correo==''){
                    alert("Ingrese el correo del usuario");
                    document.form.txtcorreo.focus();
                    return;
                }else    
                if(telefono==''){
                    alert("Ingrese el telefono del usuario");
                    document.form.txttelefono.focus();
                    return;
                }else    
                if(direccion==''){
                    alert("Ingrese la direccion del usuario");
                    document.form.txtdireccion.focus();
                    return;
                }else    
                if(usuario==''){
                    alert("Ingrese el nombre del usuario");
                    document.form.txtusuario.focus();
                    return;
                }else    
                if(clave==''){
                    alert("Ingrese la clave del usuario");
                    document.form.txtclave.focus();
                    return;    
                }else if(tipousuario=='0'){
                    alert("Ingrese el tipo del usuario");
                    document.form.txttipousuario.focus();
                    return;
                }else{
                    grabar1(ruta,'Usuario', 4, parametros);
                }
            }
   function  modificarusuario(ruta){
                var cod,nombre,correo,telefono,direccion,usuario,clave,tipousuario;
                cod=document.getElementById('txtcod').value;
                nombre=document.getElementById('txtnombre').value;
                correo=document.getElementById('txtcorreo').value;
                telefono=document.getElementById('txttelefono').value;
                direccion=document.getElementById('txtdireccion').value;
                usuario=document.getElementById('txtusuario').value;
                clave=document.getElementById('txtclave').value;
                tipousuario=document.getElementById('txttipousuario').value;

  
    var parametros = '';
    
                        parametros = "txtcod=" + cod + "&";
                        parametros += "txtnombre=" + nombre + "&";
                        parametros += "txtcorreo=" + correo + "&";
                        parametros += "txttelefono=" + telefono + "&";
                        parametros += "txtdireccion=" + direccion + "&";
                        parametros += "txtusuario=" + usuario + "&";
                        parametros += "txtclave=" + clave + "&";
                        parametros += "txttipousuario=" + tipousuario;
                     
                         
                    if(cod==''){
                    alert("Elija el codigo del usuario");
                    document.form.txtcod.focus();
                    return;
                }else
                         
                if(nombre==''){
                    alert("Ingrese el nombre del usuario");
                    document.form.txtnombre.focus();
                    return;
                }else
                if(correo==''){
                    alert("Ingrese el correo del usuario");
                    document.form.txtcorreo.focus();
                    return;
                }else    
                if(telefono==''){
                    alert("Ingrese el telefono del usuario");
                    document.form.txttelefono.focus();
                    return;
                }else    
                if(direccion==''){
                    alert("Ingrese la direccion del usuario");
                    document.form.txtdireccion.focus();
                    return;
                }else    
                if(usuario==''){
                    alert("Ingrese el nombre del usuario");
                    document.form.txtusuario.focus();
                    return;
                }else    
                if(clave==''){
                    alert("Ingrese la clave del usuario");
                    document.form.txtclave.focus();
                    return;    
                }else if(tipousuario=='0'){
                    alert("Ingrese el tipo del usuario");
                    document.form.txttipousuario.focus();
                    return;
                }else{
                    modificar(ruta,'Usuario', 7, parametros);
                }
            }