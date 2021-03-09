package com.github.nawrok.statjintelijplugin.services

import com.github.nawrok.statjintelijplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
