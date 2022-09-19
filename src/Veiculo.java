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
public class Veiculo {
    private String placa;
    private String tipoVeiculo;
    private String dataAquisicao;
    private int totalRotas;
    private double kmTotalVeiculo;
    private double consumoVeiculo;
    private double KML; // km/l (quilometro por litro)
    private double mediaQuilometros;

    public Veiculo(String placa, String tipoVeiculo, String dataAquisicao) {
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.dataAquisicao = dataAquisicao;
    }

    /**
     * gera um relatorio resumido de todos os veiculos na lista.
     * passando placa e quilometragem dos veiculos
     */
    public static void gerarRelatorioGeral() {
        System.out.println("==> Quilometragem total da frota: " + calcularKmTotalFrota());
        System.out.println("\n\nFrota conta com os seguintes Veiculos: ");
        int cont = 1;
        for (Veiculo todos : Frota.veiculos) {

            if (Frota.veiculos == null) {
                System.out.println("Não há veiculos cadastrados na frota");
            } else {
                System.out.println("Veiculo " + cont + " \nPlaca: " + todos.placa + "\nQuilometragem do veiculo: "
                        + todos.kmTotalVeiculo);

            }
            cont++;
        }
    }

    /**
     * procura na lista de veículos se existe veiculo com a placa passada. Caso
     * exista o veículo é retornado para o método que chamou
     * 
     * @param placa
     * @return
     */
    public static Veiculo localizarveiculo(String placa) {
        // preferi usar o retorno um Veiculo, assim faço o tratamento de erro utilizando
        // if-else nos métodos
        // dessa maneira já faço uma unica corrida na lista ao inves de falar que existe
        // pra então buscar de novo
        for (Veiculo buscado : Frota.veiculos) {
            if (buscado.placa.equals(placa)) {
                return buscado;
            }
        }
        return null;
    }

    /**
     * chama o método de localizar um veiculo. Se o veiculo existir exibe para o
     * usuário detalhes do veiculo
     * 
     * @param placa
     */
    public static void gerarRelatorioVeiculoUnico(String placa) {
        Veiculo veiculo = localizarveiculo(placa);
        if (veiculo != null) {
            System.out.println("Placa do Veiculo: " + veiculo.placa + "\ntipo de Veiculo: " + veiculo.tipoVeiculo
                    + "\nData de Aquisição: " + veiculo.dataAquisicao
                    + "\nTotal de Rotas Realizadas: " + veiculo.totalRotas + "\nQuilometragem total do Veiculo: "
                    + veiculo.kmTotalVeiculo + "\nMedia de quilometros rodados: " + veiculo.mediaQuilometros
                    + "\nConsumo do Veiculo com Abastecimento: " + veiculo.consumoVeiculo);
            System.out.printf("Quantidade de quilometros por litro (KM/L) que o Veiculo está realizando: %.2f\n\n\n",
                    veiculo.KML);

        } else {
            System.out.println("Veiculo não encontrado na base de dados");
        }
    }

    /**
     * retorna somatório da quilometragem dos veiculos da frota
     * 
     * @return
     */
    private static double calcularKmTotalFrota() {
        double somatorioKmFrota = 0;
        for (Veiculo veiculo : Frota.veiculos) {
            if (Frota.veiculos != null) {
                somatorioKmFrota += veiculo.kmTotalVeiculo;
            } else {
                return 0.00;
            }
        }
        return somatorioKmFrota;
    }

    /**
     * verifica na lista de veiculos o veiculo com maior quilometragem total e
     * retorna para o método de exibir quilometragem
     * 
     * @return
     */
    private static Veiculo calcularVeiculoMaiorKmTotal() {
        double baseQuilometragem = 0;
        Veiculo rodado = null;
        if (Frota.veiculos != null) {
            for (Veiculo veiculo : Frota.veiculos) {
                if (veiculo.kmTotalVeiculo > baseQuilometragem) {
                    baseQuilometragem = veiculo.kmTotalVeiculo;
                    rodado = veiculo;
                }
            }
        }
        return rodado;
    }

    /**
     * exibe veiculo com maior quilometragem para o usuário
     */
    public static void exibirVeiculoMaiorKmTotal() {
        if (calcularVeiculoMaiorKmTotal() != null) {
            Veiculo buscado = calcularVeiculoMaiorKmTotal();
            System.out.println("Veiculo com maior quilometragem total: \n\n");
            gerarRelatorioVeiculoUnico(buscado.placa);

        }
    }

    /**
     * verifica na lista de veiculos o veiculo com maior quilometragem média total e
     * retorna para o método de exibir quilometragem
     * 
     * @return
     */
    private static Veiculo calcularVeiculoMaiorKmMedia() {
        double baseQuilometragemMedia = 0;
        Veiculo rodado = null;
        if (Frota.veiculos != null) {
            for (Veiculo veiculo : Frota.veiculos) {
                veiculo.mediaQuilometros = (veiculo.kmTotalVeiculo / veiculo.totalRotas);
                if (veiculo.mediaQuilometros > baseQuilometragemMedia) {
                    baseQuilometragemMedia = veiculo.mediaQuilometros;
                    rodado = veiculo;
                }
            }
        }
        return rodado;
    }

    /**
     * exibe veiculo com maior quilometragem média para o usuário
     */
    public static void exibirVeiculoMaiorKmMedia() {
        Veiculo rodado = calcularVeiculoMaiorKmMedia();
        if (rodado != null) {
            System.out.println("Veiculo com maior média de quilometros rodados: \n\n");
            gerarRelatorioVeiculoUnico(rodado.placa);
        }
    }

    /**
     * insere nova quilometragem no veiculo informado pela placa. Se ele existir os
     * dados são inseridos.
     * 
     * @param kmRodado
     * @param placa
     */
    public static void inserirNovaKm(double kmRodado, String placa) {
        if (localizarveiculo(placa) != null) {
            Veiculo buscado = localizarveiculo(placa);
            buscado.kmTotalVeiculo = +kmRodado;
        }
    }

    /**
     * insere nova rota a um veiculo informado pela placa, caso exista.
     * 
     * @param qtdRotas
     * @param placa
     */
    public static void inseriNovaRota(int qtdRotas, String placa) {
        if (localizarveiculo(placa) != null) {
            Veiculo buscado = localizarveiculo(placa);
            buscado.totalRotas = +qtdRotas;
        }

    }

    /**
     * Procura um veículo pertencente a placa, se existir chama método que faz o
     * calculo (privado)
     * 
     * @param placa
     * @param kmRodados
     * @param litrosAbastecidos
     */
    public static void calcularQuilometroPorLitro(String placa, double kmRodados, double litrosAbastecidos) {
        if (localizarveiculo(placa) != null) {
            calcularQuilometroPorLitro(localizarveiculo(placa), kmRodados, litrosAbastecidos);
        }
    }

    /**
     * calcula os quilometros por litro que um veiculo faz de acordo com os dados
     * informados pelo usuário
     * 
     * @param veiculo
     * @param kmRodados
     * @param litrosAbastecidos
     */
    private static void calcularQuilometroPorLitro(Veiculo veiculo, double kmRodados, double litrosAbastecidos) {
        veiculo.KML = (kmRodados / litrosAbastecidos);
        System.out.printf("O veiculo está rodando aproximadamente %.2f KM/l\n\n", veiculo.KML);
    }

    /**
     * somatório dos gastos financeiros com combustivel de um veículo (não
     * utilizado)
     * 
     * @param valorGasto
     * @param placa
     */
    public static void gastosCombustivel(double valorGasto, String placa) {
        Veiculo buscado = localizarveiculo(placa);
        if (buscado != null) {
            buscado.consumoVeiculo += valorGasto;
        }
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public void setAquisicao(String aquisicao) {
        this.dataAquisicao = aquisicao;
    }
}