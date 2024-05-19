package com.poli.songstock;

import javax.sql.DataSource;
import java.sql.SQLException;

public class conexion {
    private DataSource dataSource;

    public conexion(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean probarConexion() {
        try {
            dataSource.getConnection().close();
            System.out.println("Conexión exitosa al servidor PostgreSQL.");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la conexión: " + e.getMessage());
            return false;
        }
    }
}
