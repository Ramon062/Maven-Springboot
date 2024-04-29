package org.example.service;


import org.example.interfaces.IService;
import org.example.model.Pessoa;
import org.example.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service //indica que é uma camada de serviço(negócio)
public class PessoaService implements IService<Pessoa, Integer> {

    @Autowired //injeção de dependência
    private PessoaRepository pessoaRepository;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Pessoa create(Pessoa entity) {
        return pessoaRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Pessoa get(Integer id) {
        Optional<Pessoa> pessoaEncontrado = pessoaRepository.findById(id);
        if(pessoaEncontrado.isPresent()){
            return pessoaEncontrado.get(); //pega o objeto dentro do Optional e devolve para a classe que o chamou
        }
        else {
            return new Pessoa(); //não encontrei o Pessoa;
        }
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Pessoa> get() {
        return pessoaRepository.findAll();
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
    public Pessoa update(Integer id, Pessoa entity) {

        Pessoa pessoaEncontrado = this.get(id);

        if(pessoaEncontrado.getId()!=0 || pessoaEncontrado.getId()!=null){
            return pessoaRepository.save(entity);
        }
        else{
            //return null;
            return new Pessoa();
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
        pessoaRepository.deleteById(id);
    }
}
