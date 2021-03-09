package com.github.nawrok.statj.services

import com.github.nawrok.statj.AppBundle
import com.intellij.openapi.project.Project

class StatisticService(project: Project) {

    init {
        println(AppBundle.message("statisticService", project.name))
    }
}
