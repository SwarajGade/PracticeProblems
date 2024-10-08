public class SynchronisationThredDemo {

    public static void main(String[] args) {
        DisplayInfo di=new DisplayInfo(); //master object

        GoodMorning gm=new GoodMorning();
        gm.displayInfo=di;

        GoodEvening ge=new GoodEvening();
        ge.displayInfo=di;
        ge.start();

        gm.start();
    }
}
class GoodMorning extends Thread {
    DisplayInfo displayInfo;

    @Override
    public void run(){
        displayInfo.displayMessage("Good Morning",5);
    }

}
class GoodEvening extends Thread {
    DisplayInfo displayInfo; //null

    @Override
    public void run(){
        displayInfo.displayMessage("Good Evening",5);
    }

}
class DisplayInfo {


    void displayMessage(String message, int count) {
        //only one thread can access this area
        synchronized (this)
        {
            for (int i = 1; i <= count; i++)
            {
                System.out.println(message + " ** " + i);
            }
        }
    }
}