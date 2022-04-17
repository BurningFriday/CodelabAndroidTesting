package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    // 1. 앞서 생성한 테스트 클래스를 open
    // 2. 테스트 함수를 생성.
    // 3. 테스트임을 나타내기 위해 함수 이름 위에 @Test annotation을 추가.
    @Test
    fun getActiveAndCompletedStats_완료된작업이없는경우엔_zero로계산되는가() {

        // 4. 작업 목록 만들기
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // 5. 계산 함수인 getActiveAndCompletedStats()를 호출
        val result = getActiveAndCompletedStats(tasks)

        // 6. assertion을 사용하여 결과를 확인
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)
    }


}