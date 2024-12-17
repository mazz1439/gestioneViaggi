class RivenditoreBiglietti {
    private String nome;

    public RivenditoreBiglietti(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void vendiBiglietti(String gruppo, StringBuilder log) {
        log.append("Pagamento del biglietto del gruppo: ").append(gruppo).append("\n");
        System.out.println("Pagamento del biglietto del gruppo: " + gruppo);
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}