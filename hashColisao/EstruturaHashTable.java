package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados{
    private Integer tabela[];
    private Integer porao[];
    public EstruturaHashTable() {
        tabela = new Integer[1000];
        porao = new Integer[100];
    }

    @Override
    public boolean insert(int chave){
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
