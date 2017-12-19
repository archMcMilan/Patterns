import java.util.Date;


public class FactoryMethodApp {
    public static void main(String[] args) {
//        Watch watch=new DigitalWatch();
//        watch.showTime();
        WatchMaker maker = getMakerByName("Digital");
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    //method that decide which watch create(additional method)
    public static WatchMaker getMakerByName(String maker ){
        if(maker.equals("Digital")){
            return new DigitalWatchMaker();
        } else if (maker.equals("Roman")) {
            return new RomanWatchMaker();
        }
        throw new RuntimeException("illegal maker name " +maker);
    }
}

//Product
interface Watch {
    void showTime();
}

//Concrete product
class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomanWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("I-XII");
    }
}

//creator
interface WatchMaker {
    Watch createWatch();
}

//concrete creator
class DigitalWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomanWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new RomanWatch();
    }
}