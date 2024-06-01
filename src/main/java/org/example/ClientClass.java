package org.example;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.TimeZone;

import java.util.Arrays;
import java.util.Collections;

public class ClientClass {

    //FILTER = tcp.port == 8080 && (ip.addr == 127.0.0.1 || ip.dst == 127.0.0.1)

    public static void main(String[] args) throws XmlRpcException, MalformedURLException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:8080"));

        XmlRpcClient rc = new XmlRpcClient();
        rc.setConfig(config);

        String res = (String) rc.execute("SERVER.echo", Collections.singletonList("HELLO XMLRPC"));

        System.out.println(res);

        //Servicio WordPress
        boolean entradaPublicada = (boolean) rc.execute("SERVER.publicarEntrada", Arrays.asList("Título de la entrada", "Contenido de la entrada"));
        System.out.println("Entrada publicada: " + entradaPublicada);

        boolean comentarioModerado = (boolean) rc.execute("SERVER.moderarComentario", Arrays.asList(123, true));
        System.out.println("Comentario moderado: " + comentarioModerado);

        //Servicio de Blogger
        boolean blogCreado = (boolean) rc.execute("SERVER.crearBlog", Arrays.asList("Título del blog", "Descripción del blog"));
        System.out.println("Blog creado: " + blogCreado);

        boolean postPublicado = (boolean) rc.execute("SERVER.publicarPost", Arrays.asList(1, "Título del post", "Contenido del post"));
        System.out.println("Post publicado: " + postPublicado);
    }



}
