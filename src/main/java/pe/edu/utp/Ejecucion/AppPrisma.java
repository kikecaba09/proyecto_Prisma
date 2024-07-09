package pe.edu.utp.Ejecucion;

import pe.edu.utp.Servlets.*;
import pe.edu.utp.utils.JettyUTP;
import java.net.URL;

public class AppPrisma {
    public static void main(String[] args) throws Exception {
        String path = "src\\main\\resources\\";

        JettyUTP webserver = new JettyUTP(8080, path);
        webserver.addServlet(SolicitarVacanteServlet.class,"/solicitarVacante");
        webserver.addServlet(RegistrarAdminServlet.class,"/registrarAdmin");
        webserver.addServlet(LoginAdminServlet.class,"/loginAdmin");
        webserver.addServlet(ListarCursosServlet.class,"/listarCursos");
        webserver.addServlet(RegistrarCursoServlet.class,"/registrarCurso");


        URL myURL = new URL("http://localhost:8080");
        System.out.println("*********************************************************");
        System.out.println("CLICK AQUI PARA ABRIR LA APLICACION:" + myURL);
        System.out.println("*********************************************************");
        webserver.start();
    }

    public static String getErrorLogFile() {
        String archivo = new String(
                "src/main/resources/errores.txt");
        return archivo;
    }
}

