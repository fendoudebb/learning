package learn.grpc;

import io.grpc.stub.StreamObserver;
import learn.grpc.proto.*;

import java.util.UUID;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("get from client#" + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealName("zhangsan").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("get from client#" + request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setName("张三stream").setAge(20).setCity("BJ").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("李四stream").setAge(30).setCity("SH").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("王五stream").setAge(40).setCity("GZ").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("赵六stream").setAge(50).setCity("SZ").build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext#" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError#" + t.getMessage());

            }

            @Override
            public void onCompleted() {
                StudentResponse.Builder student = StudentResponse.newBuilder().setName("张三").setAge(20).setCity("北京");
                StudentResponse.Builder student2 = StudentResponse.newBuilder().setName("张三2").setAge(30).setCity("北京");

                StudentResponseList list = StudentResponseList.newBuilder().addStudentResponse(student).addStudentResponse(student2).build();

                responseObserver.onNext(list);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
