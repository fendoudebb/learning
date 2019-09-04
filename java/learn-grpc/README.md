
## 添加build.gradle

```bash
apply plugin: 'java'
apply plugin: 'com.google.protobuf'

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.10'
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.9.0"
    }
    plugins {
        grpc {
            artifact = 'io.grpc:protoc-gen-grpc-java:1.23.0'
        }
    }
    generateProtoTasks {
        all()*.plugins {
            grpc {}
        }
    }
}
```

## 命令
```bash
gradle generateProto
```

## 参考
### 官方网站
[https://www.grpc.io](https://www.grpc.io)

### Quick Start
[https://www.grpc.io/docs/quickstart/java](https://www.grpc.io/docs/quickstart/java/)

### GitHub
- [https://github.com/grpc/grpc-java](https://github.com/grpc/grpc-java)
- [https://github.com/google/protobuf-gradle-plugin](https://github.com/google/protobuf-gradle-plugin)