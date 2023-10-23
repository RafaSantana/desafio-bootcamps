package one.digitalinnovation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import one.digitalinnovation.dominio.Bootcamp;
import one.digitalinnovation.dominio.Conteudo;
import one.digitalinnovation.dominio.Curso;
import one.digitalinnovation.dominio.Dev;
import one.digitalinnovation.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {

        Curso cursoJavaBasico = new Curso();
        cursoJavaBasico.setTitulo("Curso Java Básico");
        cursoJavaBasico.setDescricao("Aprenda Java com quem sabe");
        cursoJavaBasico.setCargaHoraria(8);

        Curso cursoDotNet = new Curso();
        cursoDotNet.setTitulo(".NET Básico");
        cursoDotNet.setDescricao("Aprenda os conceitos basicos de C#");
        cursoDotNet.setCargaHoraria(8);

        Curso cursoJavaAvancado = new Curso();
        cursoJavaAvancado.setTitulo("Curso Java Avançado");
        cursoJavaAvancado.setDescricao("Aprenda Java com quem sabe");
        cursoJavaAvancado.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aprendendo Orientação a Objetos com Java");
        mentoria.setDescricao("Imersão sobre os pilares da OO");
        mentoria.setData(LocalDateTime.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setInicio(LocalDate.now());
        bootcamp.setFim(bootcamp.getInicio().plusDays(45));
        bootcamp.setNome("Bootcamp Java Developer");
        List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, cursoDotNet, mentoria);
        bootcamp.setConteudos(conteudosBootcamp);

        Dev santana = new Dev();
        santana.setNome("Santana");

        Dev joao = new Dev();

        santana.inscrever(bootcamp);
        santana.inscrever(cursoDotNet);
        santana.progredir();
        santana.progredir();
        santana.progredir();

        joao.inscrever(bootcamp);
        joao.setNome("João");
        joao.progredir();
        joao.progredir();

        System.out.println(String.format("XP %s: %.2f", santana.getNome(), santana.calcularTotalXp()));

        System.out.println(String.format("XP %s: %.2f", joao.getNome(), joao.calcularTotalXp()));

        List<Dev> ranking = Arrays.asList(santana, joao).stream().sorted((dev1, dev2) -> Double
                .compare(dev2.calcularTotalXp(), dev1.calcularTotalXp())).toList();

        for (Dev dev : ranking) {
            System.out.println(String.format("Dev: %s - XP: %.2f", dev.getNome(), dev.calcularTotalXp()));
        }
    }
}
