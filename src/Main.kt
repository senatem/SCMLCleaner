package com.pungo.tools

import java.io.File

fun main() {
    File("input").walk().forEach {
        println(it.name)
        if(it.name.endsWith(".scml")) {
            File("output\\${it.name}").writeText("")
            cleanFile(it)
        }
    }
}

fun cleanFile(file: File){
    val readContent = file.readLines()

    for(line in readContent) {
        if(line.contains("object_ref")){
            if(!line.contains("skin")) {
                File("output\\${file.name}").appendText("$line\n")
            }
        }
        else{
            File("output\\${file.name}").appendText("$line\n")
        }
    }
}