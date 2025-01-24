package org.example;

import org.example.dao.Empresa;
import org.example.entities.empleado;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Empresa empresa = new Empresa();

        empleado e1 = new empleado("Juan", "Juan@empresa.com","RRHH");
        empleado e2 = new empleado("Pedro", "Pedro@hotmail.com","IT");
        empleado e3 = new empleado("María", "Maria@gmail.com","Administración");

        empresa.AnyadirEmpleados(e1);
        empresa.AnyadirEmpleados(e2);
        empresa.AnyadirEmpleados(e3);

        empresa.ListarEmpleados();



    }
}