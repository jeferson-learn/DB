package support;

import java.io.File;

public class CriarPasta {

    public static void criarRelatorioPasta(String caminho){

        File diretorioRelatorio = new File(caminho);

        if (!diretorioRelatorio.exists()){
            diretorioRelatorio.mkdir();
        }



    }

}
