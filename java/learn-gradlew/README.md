# gradle生成gradlew设置版本及属性
## 生成gradlew命令
```bash
gradle wrapper
```

## 4.8之前
```groovy
// Configuring the wrapper, the old way (gradle < 4.8 )
// see https://docs.gradle.org/4.4/userguide/gradle_wrapper.html#sec:wrapper_generation
task wrapper(type: Wrapper) {
    gradleVersion = '4.4'
    distributionType = Wrapper.DistributionType.BIN
}
```

## 4.8之后
```groovy
// Configuring the wrapper, the new way (since Gradle 4.8) 
// see https://docs.gradle.org/current/userguide/gradle_wrapper.html#customizing_wrapper
wrapper{
    gradleVersion = '5.1'
    distributionType = Wrapper.DistributionType.BIN
}
```

## 参考
[https://stackoverflow.com/questions/53521437/how-to-declare-gradle-version-5-0-in-build-gradle](https://stackoverflow.com/questions/53521437/how-to-declare-gradle-version-5-0-in-build-gradle)