package action.observer;

public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        BaiduSite baiduSite = new BaiduSite();
        weatherData.registerObserver(baiduSite);
        weatherData.setData(20, 100, 30);
        weatherData.removeObserver(baiduSite);
        weatherData.setData(10, 50, 15);
    }
}
