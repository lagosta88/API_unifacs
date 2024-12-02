package thiago.projeto.api.rest.maven.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import thiago.projeto.api.rest.maven.api.dto.TarefasDTO;
import thiago.projeto.api.rest.maven.api.web.Tarefas;



@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI {
 @Autowired
 private Tarefas tarefas;

 @PostMapping
 @ResponseBody
 public TarefasDTO criar(@RequestBody TarefasDTO tarefasDTO) {
	 return tarefas.criar(tarefasDTO);
 }
 
 @PutMapping ("/{tarefaId}")
 @ResponseBody
 public  TarefasDTO atualizar(@PathVariable ("tarefaId")Long tarefaId, @RequestBody TarefasDTO tarefasDTO) {
	 return tarefas.atualizar(tarefasDTO, tarefaId);
}
 
 @GetMapping
 @ResponseBody
 public List<TarefasDTO> getll(){
	 return tarefas.getALL();
 }
 
 @DeleteMapping("{tarefaId}")
 @ResponseBody
 public String deletar(@PathVariable("tarefaId") Long tarefasId) {
	 return tarefas.delete(tarefasId);
 }
}