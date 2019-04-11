package aplicativo;

public class Person {
    
    //Creando los atributos de la clase
    private String name;
    private String ID;
    private String dateOfBirth;
    private String age;
    private double payment;
    private double discount;
    private double finalPayment;
    
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
        this.dateOfBirth  = Ventana.fillDOB.getText();
        this.finalPayment = findDiscount(Double.parseDouble(Ventana.fillPayment.getText()));
        
        Ventana.conclusion.setText("<html>Sr. "+name+" con N° DNI: "+ID+" cuya \n edad es "+dateOfBirth+ ", tiene un "+discount*100+"%, por lo cual es pago final es "+finalPayment+". </html>");
    }
}
