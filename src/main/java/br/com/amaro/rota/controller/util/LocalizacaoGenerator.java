package br.com.amaro.rota.controller.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LocalizacaoGenerator {
    public static List<String> consultaLocalizacao(String endereco){

        HashMap<String, List<String>> mapa = new HashMap<>();
        mapa.put("Praça Nova Iorque, 403 - Utinga, Santo André - SP, 09220-800", Arrays.asList("-23.618.800.863.386.700","-465.360.755.735.561"));
        mapa.put("R. Liguria, 525 - Parque Capuava, Santo André - SP, 09271-020",Arrays.asList("-2.364.080.744.434.270","-4.649.212.495.821.480"));
        mapa.put("R. Itacoatiara, 311 - Parque Erasmo Assunção, Santo André - SP, 09271-210",Arrays.asList("-2.364.145.273.040.980","-4.650.205.600.239.070"));
        mapa.put("R. Cáucaso, 1351 - Parque Capuava, Santo André - SP, 09260-010",Arrays.asList("-23.637.818.411.426.400","-4.650.002.418.889.650"));
        mapa.put("R. Padre Augusto Rizi, 306-242 - Jardim Ana Maria, Santo André - SP, 09260-560",Arrays.asList("-23.628.491.685.270.300,00","-4.648.691.603.257.140"));
        mapa.put("R. Tanger, 304 - Parque Oratorio, Santo André - SP, 09251-140",Arrays.asList("-23.629.165.008.692.800","-4.650.667.830.107.840"));
        mapa.put("Rua Batista Fergusio, 1056 - Vila Cardoso Franco, São Paulo - SP, 03978-180",Arrays.asList("-23.621.582.211.150.900","-46.509.362.567.486.400"));
        mapa.put("Rua Caro-Sacaibu, 236 - Jardim Elba, São Paulo - SP, 03980-000",Arrays.asList("-2.361.719.036.385.750","-46.515.698.187.985.100"));
        mapa.put("R. Alexandre Ribeiro, 164a - Jardim das Maravilhas, Santo André - SP, 09250-340",Arrays.asList("-2.362.446.904.599.900","-465.169.141.428.097"));
        mapa.put("R. Carminé de Laura, 9 - Vila Alto de Santo Andre, Santo André - SP, 09240-770",Arrays.asList("-23.625.949.742.078.300","-4.652.055.048.323.050"));
        mapa.put("R. Sumatra, 99-1 - Parque Oratorio, Santo André - SP, 09250-470",Arrays.asList("-23.626.196.523.130.900","-4.651.022.507.215.890"));
        mapa.put("Jardim do Carmo, Santo André - State of São Paulo, 09280-660",Arrays.asList("-2.364.125.999.096.050","-46.525.531.638.649.100"));
        mapa.put("R. Rio Claro, 289 - Utinga, Santo André - SP, 09230-370",Arrays.asList("-2.361.818.660.582.610","-4.652.930.265.834.480"));
        mapa.put("R. Alcântara Machado, 282 - Jardim Utinga, Santo André - SP, 09230-720",Arrays.asList("-2.362.229.980.641.370","-4.652.144.636.731.200"));
        mapa.put("Tv. Suzano, 16 - Vila Alto de Santo Andre, Santo André - SP, 09240-560",Arrays.asList("-2.363.151.290.708.670,00","-4.651.785.491.998.280"));
        mapa.put("Rua Júlia Grisi, 1 - Jardim Sao Roberto, São Paulo - SP, 03978-520",Arrays.asList("-23.620.459.217.627.100","-4.650.058.851.355.080"));
        mapa.put("Tv. Filipe Celli - Fazenda da Juta, São Paulo - SP, 03977-636",Arrays.asList("-23.623.831.993.133.800","-4.648.990.395.774.620"));
        mapa.put("R. Baleares, 184 - Jardim das Maravilhas, Santo André - SP, 09250-170",Arrays.asList("-23.621.576.486.580.000","-4.651.463.630.646.430"));
        mapa.put("R. Lourenço de Almada, 302 - Vila Alto de Santo Andre, Santo André - SP, 09240-590",Arrays.asList("-2.362.992.593.270.240","-46.518.766.470.893.000"));
        mapa.put("R. Anhaia, 896 - Vila Curuca, Santo André - SP, 09280-490",Arrays.asList("-23.641.729.413.753.800","-46.509.967.424.936.300"));
        mapa.put("R. Germânia, 278 - Parque Novo Oratório, Santo André - SP, 09260-250",Arrays.asList("-2.362.856.866.980.750","-4.649.775.650.401.680"));
        mapa.put("R. Boa Vista - Vila Camilopolis, Santo André - SP, 09240-110",Arrays.asList("-23.625.771.841.306.100","-46.526.802.334.292.200"));
        mapa.put("R. Tunísia, 506-650 - Parque Oratorio, Santo André - SP, 09251-100",Arrays.asList("-23.630.131.577.368.400","-4.650.826.148.745.490"));
        mapa.put("R. Helena Ferreira, 87-1 - Vila Clarice, Santo André - SP, 09250-720",Arrays.asList("-23.626.194.056.889.100","-4.651.541.242.871.760"));
        mapa.put("R. Calábria, 154 - Parque Novo Oratório, Santo André - SP, 09260-270",Arrays.asList("-23.626.439.983.686.900,00","-46.499.754.208.004.600"));
        mapa.put("Rua Sargento Edgard Lourenço Pinto, 116 - Conj. Hab. Mal. Mascarenhas de Morais, São Paulo - SP, 03977-180",Arrays.asList("-2.361.656.783.354.810","-4.649.565.977.155.560"));
        mapa.put("Jardim Elba, São Paulo - State of São Paulo",Arrays.asList("-23.616.855.765.349.300","-4.651.505.358.713.360"));
        mapa.put("R. Antônio de Castilho, 140-318 - Jardim Elba, São Paulo - SP, 03980-020",Arrays.asList("-236.175.961.585.045","-4.651.101.320.888.820"));
        mapa.put("Rua das Savelhas, 6-118 - Conj. Res. Sitio Oratorio, São Paulo - SP, 03978-280",Arrays.asList("-23.621.709.377.628.000","-46.508.140.051.024.800"));
        mapa.put("Tv. Suzano, 31-1 - Vila Alto de Santo Andre, Santo André - SP, 09240-560",Arrays.asList("-23.631.615.177.861.600","-4.651.760.913.859.460"));
        mapa.put("Viela João Trainoti, 502 - Jardim Sonia Maria, Mauá - SP, 09380-275",Arrays.asList("-23.629.237.960.076.400","-4.648.092.416.435.260"));
        mapa.put("R. São Jorge, 392 - Vila Sao Pedro, Santo André - SP, 09210-420",Arrays.asList("-23.640.397.739.370.600","-46.530.772.919.616.700"));
        mapa.put("R. Vilna, 49 - Vila Francisco Matarazzo, Santo André - SP, 09241-110",Arrays.asList("-2.363.434.325.914.630","-46.515.280.481.590.300"));
        mapa.put("R. Arizona, 276 - Parque Oratorio, Santo André - SP, 09250-450",Arrays.asList("-2.362.714.828.550.020","-4.650.957.274.126.480"));
        mapa.put("R. Catigua, 231 - Parque Erasmo Assunção, Santo André - SP, 09271-250",Arrays.asList("-2.364.161.646.451.920","-46.504.122.492.984.000"));
        mapa.put("R. Serro Frio, 149 - Vila Sapopemba, São Paulo - SP, 03978-010",Arrays.asList("-2.361.729.881.930.430","-4.650.530.261.857.650"));
        mapa.put("R. dos Pessegueiros, 68 - Conj. Res. Sitio Oratorio, São Paulo - SP, 03978-340",Arrays.asList("-23.623.610.891.801.100","-4.650.718.363.953.170"));
        mapa.put("Rua Batista Fergusio, 221 - Vila Cardoso Franco, São Paulo - SP, 03978-180",Arrays.asList("-2.362.245.097.084.790","-46.509.651.234.486.800"));
        mapa.put("R. Capão Bonito, 120 - Vila Clarice, Santo André - SP, 09250-770",Arrays.asList("-23.624.157.276.605.400","-4.651.271.188.095.070"));
        mapa.put("R. Francisco de Souza, 96 - Vila Alto de Santo Andre, Santo André - SP, 09240-640",Arrays.asList("-2.362.839.374.532.250","-4.651.915.088.030.660"));
        mapa.put("R. Farsalia, 71 - Jardim das Maravilhas, Santo André - SP, 09250-150",Arrays.asList("-23.622.039.669.802.900","-4.651.685.202.916.490"));
        mapa.put("Rua Planalto dos Acantilados, 608 - Parque Santa Madalena, São Paulo - SP, 03981-110",Arrays.asList("23.613.036.117.956.500","-465.158.776.731.473"));
        mapa.put("R. Palmeira de Vinho, 549 - Jardim Elba, São Paulo - SP, 03980-060",Arrays.asList("-23.618.116.570.166.000","-4.651.158.738.422.720"));
        mapa.put("Rua Júlia Grisi, 22 - Jardim Sao Roberto, São Paulo - SP, 03978-520",Arrays.asList("-23.622.270.791.686.400","-4.650.266.174.839.470"));
        mapa.put("Viela João Trainoti, 502 - Jardim Sonia Maria, Mauá - SP, 09380-275",Arrays.asList("-23.622.483.332.969.100","-46.496.415.694.986.400"));
        mapa.put("R. Srg. Paulo Moreira, 10-86 - Conj. Hab. Mal. Mascarenhas de Morais, São Paulo - SP, 03977-160",Arrays.asList("-23.619.553.965.822.000","-4.649.718.817.852.550"));
        mapa.put("R. Srg. Hermínio Aurélio Sampaio, 274-356 - Conj. Hab. Mal. Mascarenhas de Morais, São Paulo - SP, 03977-220",Arrays.asList("-23.616.083.934.940.400","-464.942.270.436.541"));
        mapa.put("Tv. Luís da Veiga, 22 - Fazenda da Juta, São Paulo - SP, 03977-670",Arrays.asList("-23.622.757.552.791.400","-46.491.691.455.507.700"));
        mapa.put("R. Francesco Lúcio, 707 - Fazenda da Juta, São Paulo - SP, 03977-690",Arrays.asList("-23.620.211.642.106.100","-464.931.828.104.838"));
        mapa.put("R. Srg. Benevides Valente Montes, 83-23 - Conj. Hab. Mal. Mascarenhas de Morais, São Paulo - SP, 03977-190",Arrays.asList("-2.361.695.781.772.490","-4.649.507.107.738.620"));
        mapa.put("R. Sd. Jesuíno Ventura, 16 - Conj. Hab. Mal. Mascarenhas de Morais, São Paulo - SP, 03977-150",Arrays.asList("-23.618.864.836.120.100","-46.497.656.751.810.300"));
        mapa.put("R. Osório Duque Estrada, 39 - Conj. Dona Beatriz, Santo André - SP, 09260-770",Arrays.asList("-23.625.374.096.918.000","-46.500.544.131.256.500"));

        if(mapa.containsKey(endereco)){

            return mapa.get(endereco);
        }else{
            throw new RuntimeException();
        }
    }
}
