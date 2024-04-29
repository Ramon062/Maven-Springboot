package org.example.service;


import org.example.interfaces.IService;
import org.example.model.Disciplina;
import org.example.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service //indica que é uma camada de serviço(negócio)
public class DisciplinaService implements IService<Disciplina, Integer> {

    @Autowired //injeção de dependência
    private DisciplinaRepository disciplinaRepository;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Disciplina create(Disciplina entity) {
        return disciplinaRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Disciplina get(Integer id) {
        Optional<Disciplina> disciplinaEncontrado = disciplinaRepository.findById(id);
        if(disciplinaEncontrado.isPresent()){
            return disciplinaEncontrado.get(); //pega o objeto dentro do Optional e devolve para a classe que o chamou
        }
        else {
            return new Disciplina(); //não encontrei o Disciplina;
        }
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Disciplina> get() {
        return disciplinaRepository.findAll();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Disciplina update(Integer id, Disciplina entity) {

        Disciplina disciplinaEncontrado = this.get(id);

        if(disciplinaEncontrado.getId()!=0 || disciplinaEncontrado.getId()!=null){
            return disciplinaRepository.save(entity);
        }
        else{
            //return null;
            return new Disciplina();
        }
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        disciplinaRepository.deleteById(id);
    }
}
