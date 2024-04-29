package org.example.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.MappedSuperclass;
import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IResource;
import org.example.model.Pessoa;
import org.example.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //nos ajuda a escrever log no projeto
@RestController //inicida que é uma camada para api
@RequestMapping("api/v1/pessoa")
@MappedSuperclass
public class PessoaResource implements IResource<Pessoa, Integer> {

    @Autowired //faz a injeção de dependência
    private PessoaService pessoaService;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                        MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    ) 
    ///
    @Operation(
            summary = "Cria um pessoa",
            description = "Método responsável para criar um pessoa no sistema",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Pessoa create(@RequestBody Pessoa entity) {

        log.info("Cadastro do pessoa iniciado");
        log.debug("Informações do Pessoa: {}", entity);

        return pessoaService.create(entity);
    }
    ///

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @GetMapping(
            value = "/{id}", //http://localhost:8080/api/v1/pessoa/1
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Recupera um pessoa baseado em um identificador",
            description = "Método responsável para recuperar um pessoa no sistema baseado no identificador",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
            ///
    @Override
    public Pessoa get(@PathVariable("id") Integer id) {
        return pessoaService.get(id);
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Recupera uma lista de pessoas",
            description = "Método responsável para recuperar uma lista de pessoas",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

            ///
    @Override
    public List<Pessoa> get() {
        return pessoaService.get();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Atualiza todos os dados de um pessoa",
            description = "Método responsável para atualizar todos os dados de um pessoa.",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
            ///
    @Override
    public Pessoa update(@PathVariable Integer id, @RequestBody Pessoa entity) {
        return pessoaService.update(id, entity);
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Delete um pessoa com base no identificador.",
            description = "Método responsável para deletar um pessoa com base no identificador.",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "206", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public void delete(@PathVariable Integer id) {
        pessoaService.delete(id);
    }
}
