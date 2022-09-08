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
                    println "Chiste de informático"
                  }                  
                }
            }
        }  
      
      stage('humor negro') {
            steps {
                script{
                  if(date.getDay() == 5){
                    println "Chiste de humor negro"
                  }                  
                }
            }
        }
      
      stage('futbol') {
            steps {
                script{
                  if(date.getDay() == 1){
                    println "Chiste de fútbol"
                  }                  
                }
            }
        }
      
      stage('politica') {
            steps {
                script{
                  if(date.getDay() == 2){
                    println "Chiste de politica"
                  }                  
                }
            }
        }
      
      stage('medicos') {
            steps {
                script{
                  if(date.getDay() == 3){
                    println "Chiste de médicos"
                  }                  
                }
            }
        }
    }
}
