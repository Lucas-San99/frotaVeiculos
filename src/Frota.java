
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
import java.util.ArrayList;

public class Frota {
    public static ArrayList<Veiculo> veiculos = new ArrayList<>(); // inseri na UML da classe Veiculo erroneamente
    static Veiculo veiculo;

    public Frota() {

    }

    /**
     * insere um veiculo na frota de veiculos. Para tal é preciso ter as seguintes informações
     * @param placa
     * @param tipoVeiculo
     * @param aquisicao
     */
    public static void inserirNovoVeiculo(String placa, String tipoVeiculo, String aquisicao) {
        veiculo = new Veiculo(placa, tipoVeiculo, aquisicao);
        veiculos.add(veiculo);
        System.out.println("Veículo Inserido com sucesso!");
    }

    /**
     * remove um veículo da lista de acordo com a placa indicada, se não existir não será excluido. 
     * @param placa
     */
    public static void removerVeiculo(String placa) {
        Veiculo veiculo = Veiculo.localizarveiculo(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            System.out.println("Veiculo removido com sucesso!");
        } else {
            System.out.println("Veiculo não encontrado na base de dados.\n\n");
        }

    }
}
