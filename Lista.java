class Lista {
    
    private Nodo testa;
    private int contatore;

    public Lista() {
        this.contatore = 0;
        this.testa = null;
    }

    public void stampa()
    {
        Nodo nodoInserito = this.testa;

        System.out.printf("[%d] ", this.contatore);

        while (nodoInserito != null) {
            System.out.printf("%d --> ", nodoInserito.valore);
            nodoInserito = nodoInserito.next;
        }
        System.out.printf("null\n");
    }

    public void inserisci(int valore)
    {
        Nodo nodoInserito = this.testa;
        Nodo vapp = null;

        Nodo n = new Nodo(valore);

        
        while (nodoInserito != null && nodoInserito.valore < valore) {
            vapp = nodoInserito;
            nodoInserito = nodoInserito.next;
        }

        if (vapp == null) {
            
            n.next = this.testa;
            this.testa = n;
        } else {
            
            vapp.next = n;
            n.next = nodoInserito;
        }

        this.contatore++;
    }

    public void rimuovi(int valore)
    {
        Nodo nodoInserito = this.testa;
        Nodo vapp = null;
        Nodo n = null;

       
        while (nodoInserito != null && nodoInserito.valore < valore) {
            vapp = nodoInserito;
            nodoInserito = nodoInserito.next;
        }

        
        if (nodoInserito == null) {
            System.out.printf(" elemento %d non trovato\n", valore);
            return;
        }

        System.out.printf("elemento %d trovato\n", valore);
        this.contatore--;

        
        if (vapp== null) {
            System.out.printf("L'elemento da eliminare e' in testa\n");
            
            this.testa = this.testa.next;  
            return;
        }

        
        System.out.printf("L'elemento da eliminare non e' in testa\n");
        vapp.next = vapp.next.next;
    }
}