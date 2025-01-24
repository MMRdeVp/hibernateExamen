package org.example.dao;

import org.example.entities.empleado;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Empresa implements EmpresaDAO{

    @Override
    public void ListarEmpleados() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<empleado> empleados =  session.createQuery( "from empleado", empleado.class).list();

        session.close();
        System.out.println(empleados.toString());
    }

    @Override
    public void AnyadirEmpleados(empleado e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();


        try {

            session.save(e);
            tx.commit();

        } catch (Exception ex) {

            if (tx != null) {
                tx.rollback();
            }

            ex.printStackTrace();

        } finally {

            session.close();

        }
    }
}
