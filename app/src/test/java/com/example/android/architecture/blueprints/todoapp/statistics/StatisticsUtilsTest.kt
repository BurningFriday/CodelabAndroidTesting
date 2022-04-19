package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    // 1. 앞서 생성한 테스트 클래스를 open
    // 2. 테스트 함수를 생성.
    // 3. 테스트임을 나타내기 위해 함수 이름 위에 @Test annotation을 추가.
    @Test
    fun getActiveAndCompletedStats_완료된작업이없으면_100과_0으로_계산되는가() {

        // 4. 작업 목록 만들기
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // 5. 계산 함수인 getActiveAndCompletedStats()를 호출
        val result = getActiveAndCompletedStats(tasks)

        // 6. assertion을 사용하여 결과를 확인
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_활성화된작업이없으면_0과_100으로_계산되는가() {
        val tasks = listOf(
            Task("title", "desc", isCompleted = true)
        )
        // When the list of tasks is computed with a completed task
        val result = getActiveAndCompletedStats(tasks)

        // Then the percentages are 0 and 100
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_active와complete두경우모두_제대로계산되는가() {
        // Given 3 completed tasks and 2 active tasks
        val tasks = listOf(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        // When the list of tasks is computed
        val result = getActiveAndCompletedStats(tasks)

        // Then the result is 40-60
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_null이입력되면_0을리턴하는가() {
        // When there's an error loading stats
        val result = getActiveAndCompletedStats(null)

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_빈리스트가입력되면_0을리턴하는가() {
        // When there are no tasks
        val result = getActiveAndCompletedStats(emptyList())

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

}