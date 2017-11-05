/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.tecsup.hibernate;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.CursoDAO;
import pe.edu.tecsup.hibernate.model.Curso;

/**
 *
 * @author Alumno
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {
    
    @Autowired
    CursoDAO cursoDAO;

    //@Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getId()+ " "+curso.getNombre());
            System.out.println();
        }
        Assert.assertTrue(cursos.size() > 0);
    }
    
    //@Test
    public void verifyFind() {
        Curso curso = cursoDAO.get(14l);
        System.out.println(curso.getNombre());
        
        Assert.assertTrue(curso.getId() == 14l);
    }

    //@Test
    public void verifySave() {

        Curso curso = new Curso();
        curso.setCodigo("1020");
        curso.setNombre("Nuevo Curso XDDD");

        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }

    //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso curso = new Curso();
        curso.setId(13l);
        curso.setCodigo("999");
        curso.setNombre("Curso Modificado OLAH");

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(13l).getCodigo().equals("999"));
    }

    //@Test
    public void verifyDelete() {

        Curso programa = new Curso();
        programa.setId(13l);
        cursoDAO.delete(programa);

        Assert.assertTrue(cursoDAO.get(13l) == null);
    }
    
    //@Test
    public void verifyFind2() {
        Curso curso = cursoDAO.get(14l);
        System.out.println(curso.getNombre());
        
        Assert.assertTrue(curso.getId() == 14l);
    }

}
