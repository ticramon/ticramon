/**
 *
 * @author Ramón Méndez García
 */

package personas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Personas {
    int id;
    String nombre, apellidoPaterno, apellidoMaterno;
    char sexo;
    LocalDate fechaNacimiento;

    public Personas(int id, String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int calcularEdad(){
        LocalDate hoy = LocalDate.now();
        return Period.between(fechaNacimiento, hoy).getYears();
    }
    
    public String toString(){
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre +" "+apellidoPaterno+
                " "+apellidoMaterno+ '\'' +
                ", sexo='" + sexo + '\'' +
                ", Fecha de nacimiento=" + formatDate(fechaNacimiento) +
                '}';
    }
    
    private String formatDate(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    public static void main(String[] args) {
        LocalDate birthdate = LocalDate.of(1992, 7, 23);
        Personas ramonmg=new Personas(1, "Ramón", "Méndez", "García", 'H', birthdate);
        
        System.out.println("Datos personales:");
        System.out.println("Nombre: " + ramonmg.getNombre());
        System.out.println("Sexo: " + ramonmg.getSexo());
        System.out.println("Fecha de nacimiento: " + ramonmg.getFechaNacimiento());
        System.out.println("Edad: " + ramonmg.calcularEdad());
        
    }
}
