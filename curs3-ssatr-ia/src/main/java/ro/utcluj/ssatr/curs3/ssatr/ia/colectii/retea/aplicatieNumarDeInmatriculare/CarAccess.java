/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs3.ssatr.ia.colectii.retea.aplicatieNumarDeInmatriculare;
 
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author mihai.hulea
 */
public class CarAccess {
    private String plateNumber;
    private long accessTime; 
 
    public CarAccess(String plateNumber, long accessTime) {
        this.plateNumber = plateNumber;
        this.accessTime = accessTime;
    }
 
    public String getPlateNumber() {
        return plateNumber;
    }
 
    public long getAccessTime() {
        return accessTime;
    }
 
    @Override
    public String toString() {
        return "CarAccess{" + "plateNumber=" + plateNumber + ", accessTime=" + accessTime + '}';
    }
 
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }


    public static void main(String[] args) {
       CarAccess ca1 = new CarAccess("CJ-99-HCM", System.currentTimeMillis()); 
       System.out.println(ca1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CarAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("time="+(System.currentTimeMillis() - ca1.getAccessTime())); 

        ArrayList<CarAccess> list = new ArrayList<>();
        list.add(ca1);

        String test = "CJ-99-HCM";
        // 1. metoda 1 cautare si stergere obiect
        if(list.contains(new CarAccess(test, System.currentTimeMillis()))){
            System.out.println("Plate number found.");
            list.remove(new CarAccess(test, System.currentTimeMillis()));
        }
        else{
            System.out.println("Plate number not found.");
        }

    }
}