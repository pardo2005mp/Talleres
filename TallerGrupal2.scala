import scala.util.Try
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@main def ejecutarTaller(): Unit = {

  // Ejercicio 1: Raíz cuadrada segura (Option)
  def safeSqrt(number: Double): Option[Double] = {
    if (number < 0) None
    else Some(Math.sqrt(number))
  }

  println(safeSqrt(25))    // Some(5.0)
  println(safeSqrt(0))     // Some(0.0)
  println(safeSqrt(2))     // Some(1.4142135623730951)
  println(safeSqrt(-9))    // None
  println(safeSqrt(-1))    // None

  // Ejercicio 2: Validar edad de usuario (Either)
  def validarEdad(edad: Int): Either[String, Int] = {
    if (edad < 0) Left("Error: La edad no puede ser negativa")
    else if (edad < 18) Left("Error: Debe ser mayor de 18 años")
    else if (edad > 120) Left("Error: Edad no válida")
    else Right(edad)
  }

  println(validarEdad(25))     // Right(25)
  println(validarEdad(18))     // Right(18)
  println(validarEdad(120))    // Right(120)
  println(validarEdad(15))     // Left(Error: Debe ser mayor de 18 años)
  println(validarEdad(-5))     // Left(Error: La edad no puede ser negativa)
  println(validarEdad(150))    // Left(Error: Edad no válida)

  // Ejercicio 3: Conversión de texto a fecha (Try)
  def parseDate(dateString: String): Try[LocalDate] = {
    val formato = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    Try(LocalDate.parse(dateString, formato))
  }

  val fechasTexto: List[String] = List(
    "01/01/2024",
    "15/08/2023",
    "2024/02/31",
    "hola",
    "25/12/2024"
  )

  val fechasConvertidas = fechasTexto.map(parseDate)
  println(fechasConvertidas)
}