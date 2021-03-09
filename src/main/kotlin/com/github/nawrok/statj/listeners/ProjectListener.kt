package com.github.nawrok.statj.listeners

import com.github.nawrok.statj.services.StatisticService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

internal class ProjectListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        project.service<StatisticService>()
    }
}
