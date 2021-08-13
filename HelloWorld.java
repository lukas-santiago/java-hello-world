import java.io.Console;

class HelloWorld {
    public static void main(String[] args) {
        Console cnsl = System.console();

        if (cnsl == null) {
            System.out.println("No console available");
            return;
        }

        String str = cnsl.readLine("Enter your name: ");
        System.out.println("Your name is: " + str);

        // 2) Data completa:
        // Solicite uma data completa no formato d/m/aaaa.O seu programa deverá dizer se
        // a data informada é valida
        // ou não. Considere ano bissexto, meses que tem 28,29 , 30 ou 31 dias e meses
        // que vão de 1 a 12.

        String dataAValidar;
        int dia = 0, mes = 0, ano = 0;
        Boolean bissexto = false;
        // Solicitando data
        dataAValidar = cnsl.readLine("Digite a data no formato dd/mm/aaaa (Ex: 01/02/2019): ");
        // Validando tamanho do data que foi digitada e separando em dia, meses e anos
        if (dataAValidar.length() == 10 && dataAValidar.charAt(2) == '/' && dataAValidar.charAt(5) == '/') {
            try {
                dia = Integer.parseInt(dataAValidar.substring(0, 2));
                System.out.println(dataAValidar.substring(dia));
                mes = Integer.parseInt(dataAValidar.substring(3, 2));
                System.out.println(dataAValidar.substring(mes));
                ano = Integer.parseInt(dataAValidar.substring(6, 4));
                System.out.println(dataAValidar.substring(ano));
            } catch (Exception e) {
                cnsl.readLine(e.getMessage() + "| Data inválida. A data deve ser no formato dd/mm/aaaa.");
                System.exit(0);
            }
        } else {
            cnsl.readLine("Data inválida. Padrão inadequado.");
            System.exit(0);
        }

        // Validando Ano Bissexto
        bissexto = (ano % 4 == 0);
        // Validando mês
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia > 0 && dia <= 31)
                    System.out.println("Data Válida");
                else
                    System.out.println("Data inválida. Dia inadequado.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia > 0 && dia <= 30)
                    System.out.println("Data Válida");
                else
                    System.out.println("Data inválida. Dia inadequado.");
                break;
            case 2:
                if ((dia > 0 && dia <= 28 && bissexto != true) || (dia > 0 && dia <= 29 && bissexto == true))
                    System.out.println("Data Válida");
                else
                    System.out.println("Data inválida. Dia inadequado.");
                break;
            default:
                System.out.println("Data inválida. Mês inadequado.");
                break;
        }

        cnsl.readLine("Enter para sair...");
    }
}