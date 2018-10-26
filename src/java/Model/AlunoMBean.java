/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ismae
 */

@ManagedBean

public class AlunoMBean {
    private Aluno aluno;
    private List<Aluno> lista;
    private AlunoDAO alunodao;
    
    
    @PostConstruct
    public void init(){
        this.aluno = new Aluno();
        this.alunodao = new AlunoDAO();
    }
    
    public void salvar(){
        alunodao.salvar(aluno);
        init();
        
        lista = alunodao.listar();
    }
 
    
    public String delete(){
       return "aluno;";
    }
    
    public String edit(Aluno aluno){
        this.aluno = aluno;
        return "manageAluno";
    }
    
    public String save(){
        return "aluno";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoDAO getAlunodao() {
        return alunodao;
    }

    public void setAlunodao(AlunoDAO alunodao) {
        this.alunodao = alunodao;
    }

    public List<Aluno> getLista() {
        lista = alunodao.listar();
        return lista;
    }

    public void setLista(List<Aluno> lista) {
        this.lista = lista;
    }
    
}
