public class ArvoreBinariaMorse {
    class No {
        char caractere;
        No esquerda;
        No direita;

        public No(char caractere) {
            this.caractere = caractere;
            esquerda = null;
            direita = null;
        }
    }

    private No raiz;

    public ArvoreBinariaMorse() {
        inicializar();
    }

    private void inicializar() {
        raiz = new No('\0');
    }

    public void inserirCaractere(String codigoMorse, char caractere) {
        No atual = raiz;

        for (int i = 0; i < codigoMorse.length(); i++) {
            char sinalMorse = codigoMorse.charAt(i);

            if (sinalMorse == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new No('\0');
                }
                atual = atual.esquerda;
            } else if (sinalMorse == '-') {
                if (atual.direita == null) {
                    atual.direita = new No('\0');
                }
                atual = atual.direita;
            }
        }
        atual.caractere = caractere;
    }

    public char buscarCaractere(String codigoMorse) {
        No atual = raiz;

        for (int i = 0; i < codigoMorse.length(); i++) {
            char sinalMorse = codigoMorse.charAt(i);

            if (sinalMorse == '.') {
                if (atual.esquerda == null) return '\0';
                atual = atual.esquerda;
            } else if (sinalMorse == '-') {
                if (atual.direita == null) return '\0';
                atual = atual.direita;
            }
        }
        return atual.caractere;
    }

    public String decifrarMensagem(String mensagemMorse) {
        String mensagemDecifrada = "";
        String atual = "";
        int indice = 0;

        while(indice < mensagemMorse.length()) {
            char sinalMorse = mensagemMorse.charAt(indice);

            if(sinalMorse != ' ') {
                atual += sinalMorse;
            }
            else {
                int proximo = indice + 1;
                boolean espaco = (proximo < mensagemMorse.length() && mensagemMorse.charAt(proximo) == ' ');

                if(atual.length() > 0) {
                    char letra = buscarCaractere(atual);
                    if(letra != '\0') mensagemDecifrada += letra;
                    atual = "";
                }
                if(espaco) {
                    mensagemDecifrada += " ";
                    indice++;
                }
            }
            indice++;
        }
        if(atual.length() > 0) {
            char letra = buscarCaractere(atual);
            if(letra != '\0') mensagemDecifrada += letra;
        }
        return mensagemDecifrada;
    }

    public String criarMorse(String mensagem) {
        String[] sinais = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--..",
                "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."
        };
        char[] caracteres = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        String mensagemCodificada = "";
        int tamanhoSinais = 36;

        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);

            if (caractere == ' ') {
                mensagemCodificada += caractere;
            } else {
                for (int j = 0; j < tamanhoSinais; j++) {
                    if (caractere == caracteres[j]) {
                        mensagemCodificada += sinais[j] + " ";
                        break;
                    }
                }
            }
        }
        return mensagemCodificada;
    }

    public void preencherArvore() {
        String[] sinais = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--..",
                "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."
        };
        char[] caracteres = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        int tamanho = 36;
        for (int i = 0; i < tamanho; i++) {
            inserirCaractere(sinais[i], caracteres[i]);
        }
    }

    public void exibirArvoreMorse() {
        exibirRec(raiz, "");
    }

    private void exibirRec(No raiz, String codigoMorse) {
        if (raiz != null) {
            if (raiz.caractere != '\0') System.out.println(codigoMorse + "  " + raiz.caractere);
            exibirRec(raiz.esquerda, codigoMorse + ".");
            exibirRec(raiz.direita, codigoMorse + "-");
        }
    }
}
