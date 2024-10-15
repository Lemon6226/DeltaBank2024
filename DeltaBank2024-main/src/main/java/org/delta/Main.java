package org.delta;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.print.BankInjector;

public class Main {
    public static void main(String[] args) {
        //App app = new App();

        try {
            Injector injector = Guice.createInjector(new BankInjector());
            App app = injector.getInstance(App.class);
            app.run();
        } catch (ArithmeticException e) {
            System.out.println("Pocitas blbe, " + e.getMessage());
        } catch (Throwable thr) {
            System.out.println("Neco se ti pokazilo");
            thr.printStackTrace();
        }
    }
}
