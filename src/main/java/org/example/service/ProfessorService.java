package org.example.service;



import org.example.interfaces.IService;
import org.example.model.Professor;
import org.example.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service //indica que é uma camada de serviço(negócio)
public class ProfessorService implements IService<Professor, Integer> {

    @Autowired //injeção de dependência
    private ProfessorRepository professorRepository;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Professor create(Professor entity) {
        return professorRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Professor get(Integer id) {
        Optional<Professor> professorEncontrado = professorRepository.findById(id);
        if(professorEncontrado.isPresent()){
            return professorEncontrado.get(); //pega o objeto dentro do Optional e devolve para a classe que o chamou
        }
        else {
            return new Professor(); //não encontrei o Professor;
        }
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Professor> get() {
        return professorRepository.findAll();
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
    public Professor update(Integer id, Professor entity) {

        Professor professorEncontrado = this.get(id);

        if(professorEncontrado.getId()!=0 || professorEncontrado.getId()!=null){
            return professorRepository.save(entity);
        }
        else{
            //return null;
            return new Professor();
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
        professorRepository.deleteById(id);
    }
}
