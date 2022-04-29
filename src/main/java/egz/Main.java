package egz;


//Bicycle { gears: 1 currentSpeed: 40}
//MountainBike { Bicycle { gears: 5 currentSpeed: 90}, ratio: 4.0}

public class Main {

    public static void main(String[] args) {
        Bicycle[] bicycles = {
                new Bicycle(1, 50),
                new MountainBike(5, 100, 4.0)
        };
        for (Bicycle bicycle : bicycles) {
            bicycle.applyBrake(10);
            System.out.println(bicycle);
        }



    }


    static class Bicycle {
       private int gears;
       private int currentSpeed;

       public void x(){
           super.toString();
       }

        public Bicycle(int gears, int currentSpeed) {
            this.gears = gears;
            this.currentSpeed = currentSpeed;
        }

        public void applyBrake(int x){
            this.currentSpeed = this.currentSpeed -x;
        }

        @Override
        public String toString() {
            return "Bicycle { " +
                    "gears: " + gears +
                    ", currentSpeed: " + currentSpeed +
                    '}';
        }
    }

    static class MountainBike extends Bicycle{
        private double ratio;

        public MountainBike(int number1, int number2, double ratio) {
            super(number1, number2);
            this.ratio = ratio;
        }

        @Override
        public String toString() {
            return "MountainBike { " +
                    super.toString()+", ratio: " + ratio +
                    '}';
        }


    }
}



