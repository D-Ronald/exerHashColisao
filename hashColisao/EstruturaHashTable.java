package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados{
    private Integer tabela[];
    private Integer porao[];
    //TODO adicionar elementos necessários para implementar o porão

    public EstruturaHashTable() {
        //esse número pode ser alterado
        tabela = new Integer[1000];
        porao = new Integer[100];
    }

    @Override
    public boolean insert(int chave) {
        // TODO quando inserir, se a posição estiver ocupada, o elemento NÃO é inserido e retorna false. Caso contrário, o elemento é inserido na posição calculada e retorna true.
        int posicao = hash(chave);
        
        if (tabela[posicao] == null) {
            tabela[posicao] = chave;
            return true;
        }
        
        int i = 1;
        while (i <= 100 && porao[i - 1] != null) {
            i++;
        }
        
        if (i > 100) {
            return false;
        }
        
        porao[i - 1] = chave;
        return true;
        
    }

    @Override
    public boolean delete(int chave) {
        // TODO quando inserir, se a posição estiver ocupada, torna o elemento da posição como null e retorna true. Caso contrário, retorna false.
        int posicao = search(chave);
        
        if (posicao == -1) {
            return false;
        }
        
        if (posicao >= 1000) {
            porao[posicao - 1000] = null;
        } else {
            tabela[posicao] = null;
        }
        
        return true;
        
    }

    @Override
    public int search(int chave) {
        // TODO se o elemento estiver presente retorna a sua posição. Caso contrário, retorna -1.
        int posicao = hash(chave);
        
        if (tabela[posicao] != null && tabela[posicao] == chave) {
            return posicao;
        }
        
        for (int i = 0; i < 100; i++) {
            if (porao[i] != null && porao[i] == chave) {
                return 1000 + i;
            }
        }
        
        return -1;
    }
    
    private int hash(int chave) {
        return chave % 1000;
    }

}
