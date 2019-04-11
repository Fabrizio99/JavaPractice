package aplicativo;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    
    //Indicando el formato de la fecha
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //Obtener la fecha actual
    private static LocalDate actualDate = LocalDate.now();
    
    //Creando los atributos de la clase
    private String name;
    private String ID;
    private String age;
    private double payment;
    private double discount;
    private double finalPayment;
    private LocalDate dateOfBirth;
    
    
    //Métodos
    
    //M. para hallar el descuento correspondiente
    public double findDiscount(double payment){
        this.payment = payment;
            //si el monto pagado esta entre 0 y 100 soles, descuento del 10%
        if(payment>=0 && payment<=100){
            discount = 0.10;
            
            //si el monto pagado esta entre 100 y 1000 soles, descuento del 12%
        } else if(payment>100 && payment<=1000){
            discount = 0.12;
            
            //si el monto pagado es mayor a 1000, descuento del 15%
        } else {
            discount = 0.15;
        }
        
        return payment*(1-discount);
    }
    
    public void calculateData(){
        
        this.name         = Ventana.fillName.getText();
        this.ID           = Ventana.fillID.getText();
        this.finalPayment = findDiscount(Double.parseDouble(Ventana.fillPayment.getText()));
        this.dateOfBirth  = LocalDate.parse(Ventana.fillDOB.getText(), dateFormat);
        Period periodo    = Period.between(dateOfBirth,actualDate );
        
        Ventana.conclusion.setText("<html>Sr. "+name+" con N° DNI: "+ID+" cuya edad es "+periodo.getYears()+ ", tiene un "+discount*100+"%, por lo tanto debe pagar  s/."+finalPayment+". </html>");
        
    }
    
}
