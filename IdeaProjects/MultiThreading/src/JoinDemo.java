public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {

        Ramesh rameshobj =new Ramesh();

        Suresh suresjobj =new Suresh();
        rameshobj.suresh = suresjobj;  //suresjobj is an instance variable(obj ref ) got set here

        rameshobj.start();   //register with thread scheduler and  it will invoke the run method
        suresjobj.start();

        rameshobj.join();
        suresjobj.join();
        //thread,sleep,yield,join
        System.out.println("S3-Parsing data from files and save to DB");

    }
}
class Ramesh extends Thread {

    Suresh suresh; //null

    @Override
    public void run() {
        try {
            suresh.join();
        } catch (InterruptedException e) {
            e.printStackTrace(); //if exception occurs it shows the where it comes.
        }
        System.out.println("S2-Connecting to AWS to read files");
    }
}
class Suresh extends Thread {

    @Override
    public void run(){
        System.out.println("S1-fetch credentials from Filestore");
    }
}