public class TesteArvore {
    public static void main(String[] args) {
        ArvoreBinariaMorse teste = new ArvoreBinariaMorse();

        teste.inserirCaractere("---",'O');
        teste.inserirCaractere("...",'S');
        teste.exibirArvoreMorse();

        System.out.println("Mensagem: " + teste.decifrarMensagem("... --- ..."));
    }
}
