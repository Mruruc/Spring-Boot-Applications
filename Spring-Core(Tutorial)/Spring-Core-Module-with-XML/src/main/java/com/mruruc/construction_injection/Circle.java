package com.mruruc.construction_injection;

public class Circle {
    private Double radius;
    private Double customPI;

    public Circle(Double r, Double customPI){
        this.radius =r;
        this.customPI=customPI;
    }
    public Circle(Double r){
        this.radius =r;
    }

    public Double getRadius() {
        return radius;
    }

    public Double getCustomPI() {
        return customPI;
    }

    public void draw(){
        System.out.println("Circle Drew with Radius " + getRadius());
    }
    public void calculateTheArea(){
      if(this.customPI==null){
          System.out.println("Result With Default PI value:" +
                  " "+Math.PI * this.radius);
          return;
      }
        System.out.println("You have used your custom PI value:" +
                " " + customPI * radius);
    }

}
