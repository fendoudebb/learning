package learn.netty.demo.example06_protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo2.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo2.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo2.MyMessage myMessage = null;
        int random = new Random().nextInt(3);
        if (random == 0) {
            myMessage = MyDataInfo2.MyMessage.newBuilder()
                    .setDataType(MyDataInfo2.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo2.Person.newBuilder()
                            .setName("王五")
                            .setAddress("深圳")
                            .setAge(22)
                            .build())
                    .build();
        } else if (random == 1) {
            myMessage = MyDataInfo2.MyMessage.newBuilder()
                    .setDataType(MyDataInfo2.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo2.Dog.newBuilder()
                            .setName("This is a dog")
                            .setAge(3)
                            .build())
                    .build();
        } else {
            myMessage = MyDataInfo2.MyMessage.newBuilder()
                    .setDataType(MyDataInfo2.MyMessage.DataType.CatType)
                    .setCat(MyDataInfo2.Cat.newBuilder()
                            .setName("This is a cat")
                            .setCity("成都")
                            .build())
                    .build();
        }

        ctx.channel().writeAndFlush(myMessage);

//        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setName("李四").setAge(21).setAddress("上海").build();
//        ctx.channel().writeAndFlush(person);
    }
}
