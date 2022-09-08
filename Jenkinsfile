import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

Date date = new Date();
DateFormat dateFormat=new SimpleDateFormat("dd/MM/yy");
pipeline {
    agent any

    stages {
        stage('informaticos') {
            steps {
                script{
                  if(date.getDay() == 4){
                    println "¿Cuántos programadores hacen falta para cambiar una bombilla? – Ninguno, porque es un de problema hardware."
                  }                  
                }
            }
        }  
      
      stage('humor negro') {
            steps {
                script{
                  if(date.getDay() == 5){
                    println "Una vez, Batman disparó a un tiovivo y consiguió un tío muerto."
                  }                  
                }
            }
        }
      
      stage('futbol') {
            steps {
                script{
                  if(date.getDay() == 1){
                    println "-¿Cómo se llama el peor jugador japonés? -Nikito Nitoko."
                  }                  
                }
            }
        }
      
      stage('politica') {
            steps {
                script{
                  if(date.getDay() == 2){
                    println "«Y tú más» -Breve resumen de la política española sobre el partido gobernante y la oposición."
                  }                  
                }
            }
        }
      
      stage('medicos') {
            steps {
                script{
                  if(date.getDay() == 3){
                    println "– Doctor todo el mundo me ignora– Que pase el siguiente por favor."
                  }                  
                }
            }
        }
    }
}
