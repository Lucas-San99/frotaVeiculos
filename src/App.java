import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

/*MIT License

Copyright (c) 2022 Lucas Lima 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
public class App {
    static Frota xulambex;

    public static void adicionaVeiculo(String placa, String tipoVeiculo, String dataAquisicao) {
        xulambex = new Frota();
        xulambex.inserirNovoVeiculo(placa, tipoVeiculo, dataAquisicao);
    }

    public static void main(String[] args) throws Exception {
        String placa;
        String data;
        String tipoVeiculo;
        Scanner entrada = new Scanner(System.in);
        int ent = -1;
        while (ent != 0) {
            System.out.println("\n\n\n\nDIGITE UMA DAS OPÇÕES:");
            System.out.println("1 para adicionar 4 veiculos (SE APERTAR UM DE NOVO VAI DUPLICAR DADOS)");
            System.out.println("2 para puxar veiculos adicionados");
            System.out.println("3 para registrar os KM/L no veiculo de placa JFF-5983 e GBH-0025");
            System.out.println("4 para calcular quanto vai gastar com abastecimento no veiculo com placa JFF-5983");
            System.out.println("5 para localizar dados dos veiculos de placa JFF-598 e ZWS-0258");
            System.out.println("6 para localizar veiculo com maior quilometragem TOTAL");
            System.out.println("7 para localizar veiculo com maior quilometragem MEDIA");
            System.out.println("8 para adicionar novo veiculo---(Dados base: Placa, Tipo de veiculo, Data aquisição)");
            System.out.println("9 para remover um veiculo--------( você deve passar a placa)");
            System.out.println("0 para sair do programa");
            System.out.print("\nDigite a Opção desejada: ");
            ent = entrada.nextInt();
            System.out.println("\n\n");
            switch (ent) {
                case 1:
                    xulambex = new Frota();
                    adicionaVeiculo("JFF-5983", "Carro", "02/03/2022");
                    adicionaVeiculo("ZWS-0258", "Caminhão", "15/05/2012");
                    adicionaVeiculo("GBH-0025", "Carro", "08/10/2020");
                    adicionaVeiculo("TRF-8883", "Caminhão", "13/01/2005");
                    xulambex.veiculo.inseriNovaRota(10, "JFF-5983");
                    xulambex.veiculo.inserirNovaKm(50.82, "JFF-5983");
                    xulambex.veiculo.inseriNovaRota(65, "TRF-8883");
                    xulambex.veiculo.inserirNovaKm(85.9, "TRF-8883");
                    xulambex.veiculo.inseriNovaRota(80, "ZWS-0258");
                    xulambex.veiculo.inserirNovaKm(250.87, "ZWS-0258");
                    xulambex.veiculo.inseriNovaRota(5, "GBH-0025");
                    xulambex.veiculo.inserirNovaKm(79.1, "GBH-0025");
                    break;

                case 2:
                    Veiculo.gerarRelatorioGeral();
                    break;

                case 3:
                    xulambex.veiculo.calcularQuilometroPorLitro("JFF-5983", 30.00, 71);
                    xulambex.veiculo.gerarRelatorioVeiculoUnico("JFF-5983");
                    xulambex.veiculo.calcularQuilometroPorLitro("TRF-8883", 500.00, 89.3);
                    xulambex.veiculo.gerarRelatorioVeiculoUnico("TRF-8883");
                    break;

                case 4:
                    System.out.println("Sentimos muito! Essa ferramenta ainda está em desenvolvimento.");
                    break;

                case 5:
                    xulambex.veiculo.gerarRelatorioVeiculoUnico("JFF-5983");
                    xulambex.veiculo.gerarRelatorioVeiculoUnico("ZWS-0258");
                    break;

                case 6:
                    xulambex.veiculo.exibirVeiculoMaiorKmTotal();

                    break;

                case 7:
                    xulambex.veiculo.exibirVeiculoMaiorKmMedia();
                    break;

                case 8:
                    System.out.printf("Digite a placa do veiculo a ser adicionado: ");
                    placa = entrada.next();
                    System.out.printf("Digite a data que o veículo foi adquirido: ");
                    data = entrada.next();
                    placa = placa.toUpperCase();
                    System.out.printf("Digite que tipo de veículo é esse: ");
                    tipoVeiculo = entrada.next();
                    if (placa == null || data == null || tipoVeiculo == null) {
                        System.out.println("Dados incompletos! Tente novamente.");
                        ent = 8;
                        break;

                    }
                    xulambex.inserirNovoVeiculo(placa, tipoVeiculo, data);
                    System.out.println(
                            "\n\nComo o sistema é fechado para testes, você poderá apenas ver os dados do veículo sem direito a alteração das demais especificações.");
                    System.out.println("Veja se o veícula se encontra na lista");
                    xulambex.veiculo.gerarRelatorioGeral();
                    break;

                case 9:
                    System.out.printf("Digite a placa do veiculo a ser removido: ");
                    placa = entrada.next();
                    placa = placa.toUpperCase();
                    xulambex.removerVeiculo(placa);
                    System.out.println("Veirifique se o veículo ainda está na lista\n\n");
                    xulambex.veiculo.gerarRelatorioGeral();
                    break;

                case 0:
                    System.out.println("Obrigado por testar!");

                default:
                    System.out.println("Digite um número válido!\n\n");
                    break;
            }
        }

    }
}