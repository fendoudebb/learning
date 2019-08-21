package learn.protobuf.demo;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        StudentProto.Student student = StudentProto.Student.newBuilder()
                .setName("张三")
                .setAge(20)
                .setAddress("北京")
                .build();

        byte[] studentByteArray = student.toByteArray();

        StudentProto.Student student2 = StudentProto.Student.parseFrom(studentByteArray);

        System.out.println(student2.toString());
    }

}
