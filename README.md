# ComponetDemo
# buildSrc 整合 
参考文档 https://handstandsam.com/2018/02/11/kotlin-buildsrc-for-better-gradle-dependency-management/ 

Kotlin + buildSrc == Android Studio Autocomplete
![img](https://handstandsam.com/wp-content/uploads/2015/02/AutoComplete.gif)


# ARouter集成
可参考 https://github.com/alibaba/ARouter

# 组件单独运行
需要手动修改每个module 下的 gradle.properties 文件， isApplication=true，并修改其他module 为false。
