package JSONObject;

import org.json.JSONObject;

public class TarefaJson {

    public String dadoTarefa(){

        JSONObject criandoJson = new JSONObject();
        criandoJson.put("title", "API atualizado");
        criandoJson.put("description", "Testando api do tarefa");
        criandoJson.put("deadline", "");
        criandoJson.put("done", false);

        return criandoJson.toString();
    }

    public String editarTarefa(){
        JSONObject editandoJson = new JSONObject();
        editandoJson.put("title", "API 2 atualizado");
        editandoJson.put("description", "Testando api do tarefa 2");
        editandoJson.put("done", true);

        return editandoJson.toString();
    }

}
