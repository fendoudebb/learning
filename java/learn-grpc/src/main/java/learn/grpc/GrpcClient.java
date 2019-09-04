package learn.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import learn.grpc.proto.*;

import java.time.LocalDateTime;
import java.util.Iterator;

public class GrpcClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 8899)
                .usePlaintext()
                .build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("张三").build());
        System.out.println(myResponse.getRealName());


        System.out.println("--------------");

        Iterator<StudentResponse> students = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(30).build());

        students.forEachRemaining(studentResponse -> {
            System.out.println(studentResponse.getName() + ", " + studentResponse.getAge() + ", " + studentResponse.getCity());
        });

        System.out.println("#############");

        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                for (StudentResponse studentResponse : value.getStudentResponseList()) {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("*******");
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("client onError#" + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("client onCompleted");
            }
        };

        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);
        StreamObserver<StudentRequest> studentsWrapperByAges = stub.getStudentsWrapperByAges(studentResponseListStreamObserver);
        studentsWrapperByAges.onNext(StudentRequest.newBuilder().setAge(20).build());
        studentsWrapperByAges.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentsWrapperByAges.onNext(StudentRequest.newBuilder().setAge(40).build());
        studentsWrapperByAges.onNext(StudentRequest.newBuilder().setAge(50).build());
        studentsWrapperByAges.onCompleted();

        System.out.println("~~~~~~~~~~~~~~~~~");

        StreamObserver<StreamRequest> streamRequestStreamObserver = stub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("client onError#" + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onComplete");
            }
        });

        for (int i = 0; i < 10; i++) {
            streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
            Thread.sleep(1000);
        }

        Thread.sleep(50000);
    }

}
