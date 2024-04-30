package org.example.service;


import org.example.interfaces.IService;
import org.example.model.Avaliacao;
import org.example.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service //indica que é uma camada de serviço(negócio)
public class AvaliacaoService implements IService<Avaliacao, Integer> {

    @Autowired //injeção de dependência
    private  AvaliacaoRepository avaliacaoRepository;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Avaliacao create(Avaliacao entity) {
        return avaliacaoRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Avaliacao get(Integer id) {
        Optional<Avaliacao> avaliacaoEncontrado = avaliacaoRepository.findById(id);
        if(avaliacaoEncontrado.isPresent()){
            return avaliacaoEncontrado.get(); //pega o objeto dentro do Optional e devolve para a classe que o chamou
        }
        else {
            return new Avaliacao(); //não encontrei a avaliacao;
        }
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Avaliacao> get() {
        return avaliacaoRepository.findAll();
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
    public Avaliacao update(Integer id, Avaliacao entity) {

        Avaliacao avaliacaoEncontrado = this.get(id);

        if(avaliacaoEncontrado.getId()!=0 || avaliacaoEncontrado.getId()!=null){
            return avaliacaoRepository.save(entity);
        }
        else{
            //return null;
            return new Avaliacao();
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
        avaliacaoRepository.deleteById(id);
    }
}
