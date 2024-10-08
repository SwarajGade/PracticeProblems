
public class SumOfN
{
    public static void main(String[] args) throws InterruptedException {
        T2 t =new T2();
        t.start();

        //Thread.sleep(0,1);
       // t.join();
        synchronized (t) {
          /*
         wait method  releases lock  and wait for updation-->runnable-->notification--->readytorun this is called inter thread communication.
          */
            t.wait(100);
            System.out.println("Sum is " + t.sum);
        }
    }
}
class T2 extends Thread
{
    int sum;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            this.notify();
        }
    }
}