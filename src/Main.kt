import kotlin.reflect.typeOf
import kotlin.time.times
import kotlin.NumberFormatException
import kotlin.properties.Delegates

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var pegada: Double
    val fatorEletricidade = 0.475
    val fatorGas = 2.0
    var tipoEnergia by Delegates.notNull<Int>()
    var consumoEnergia by Delegates.notNull<Int>()

    println("Calculando a pegada de carbono")

    fun entradaUsuario() {
        try {
            println("Digite 1 se você utiliza eletricidade\nDigite 2 para gás natural: ")
            tipoEnergia = readlnOrNull()!!.toInt()

        } catch (ex: NumberFormatException ){
            entradaUsuario()
        }
    }

    fun entradaConsumo() {
        try {
            println("Qual o seu consumo de energia? Entre com um valor inteiro")
            consumoEnergia = readlnOrNull()!!.toInt()

        } catch (ex: NumberFormatException ){
            entradaConsumo()
        }
    }

    entradaUsuario()

    while (tipoEnergia != 1 && tipoEnergia != 2){
        entradaUsuario()
    }

    entradaConsumo()

    if (tipoEnergia == 1){
        pegada = (fatorEletricidade * consumoEnergia.toDouble())
    } else{
        pegada = (fatorGas * consumoEnergia.toDouble())
    }

    println("A pegada de carbono associada ao consumo de $consumoEnergia kWh é de $pegada kg de Carbono")

}