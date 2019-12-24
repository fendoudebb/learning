package structure.flyweight;

public class Client {

    //Tom正在使用新闻网站
    //Jack正在使用博客网站
    //Smith正在使用博客网站
    //Alice正在使用博客网站
    //2
    public static void main(String[] args) {
        WebsiteFactory factory = new WebsiteFactory();
        Website news = factory.getWebsite("新闻");
        news.use(new User("Tom"));

        Website blog = factory.getWebsite("博客");
        blog.use(new User("Jack"));

        Website blog2 = factory.getWebsite("博客");
        blog2.use(new User("Smith"));
        Website blog3 = factory.getWebsite("博客");
        blog3.use(new User("Alice"));

        System.out.println(factory.getCacheSize());

        //-Djava.lang.Integer.IntegerCache.high=250
        Integer a = new Integer("127");
        Integer b = new Integer("127");
        Integer x = Integer.valueOf("127");
        Integer y = Integer.valueOf("127");
        System.out.println(a.equals(b));//true
        System.out.println(a == b);//false
        System.out.println(x.equals(y));//true
        System.out.println(x == y);//true
        assert 2 == 1 : "2 != 1";
    }

}
