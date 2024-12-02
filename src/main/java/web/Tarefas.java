package thiago.projeto.api.rest.maven.api.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import thiago.projeto.api.rest.maven.api.dto.TarefasDTO;

@Service
public class Tarefas {
	private static final Map<Long, TarefasDTO> tarefa = new HashMap<>();
	
	
	public TarefasDTO criar(TarefasDTO tarefaDTO) {
		Long proximoId = (long) (tarefa.keySet().size()+ 1);
		tarefaDTO.setId(proximoId);
		tarefa.put(proximoId, tarefaDTO);
		return tarefaDTO;
	}
	
	public TarefasDTO atualizar (TarefasDTO tarefaDTO, Long tarefaId) {
		tarefa.put(tarefaId, tarefaDTO);
		return tarefaDTO;
	}
	
	public TarefasDTO getById (Long tarefaId) {
		return tarefa.get(tarefaId);
	}
	
	public List<TarefasDTO> getALL (){
		return new ArrayList<>(tarefa.values());
	}
	
	public String delete (Long tarefaId) {
		tarefa.remove(tarefaId);
		return "DELETE";
	}
}
