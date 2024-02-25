package com.comsystem.homework;

import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.comsystem.homework.model.RobotAction.CLONE;
import static com.comsystem.homework.model.RobotAction.DIG;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RobotOperationsTest {
    // we can use Mockito to mock the RobotOperations class, however it's not needed for this purpose.
    @Autowired
    private RobotOperations robotOperations;

    @Test
    @DisplayName("""
            TEST01: testExcavateStonesForDays_fiveDays()
            GIVEN: Number of days: 5
            WHEN: The excavateStonesForDays method is called
            THEN: The result is a RobotPlan with 5 days, 9 stones, and the actions [CLONE, CLONE, DIG, DIG, DIG]""")
    public void testExcavateStonesForDays_fiveDays() {
        RobotPlan expected = new RobotPlan(5, 9, List.of(CLONE, CLONE, DIG, DIG, DIG));
        RobotPlan actual = robotOperations.excavateStonesForDays(5);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @DisplayName("""
            TEST02: testDaysRequiredToCollectStones_nineStones()
            GIVEN: Number of stones: 9
            WHEN: The daysRequiredToCollectStones method is called
            THEN: The result is a RobotPlan with 5 days, 9 stones, and the actions [CLONE, CLONE, DIG, DIG, DIG]""")
    public void testDaysRequiredToCollectStones_nineStones() {
        RobotPlan expected = new RobotPlan(5, 9,List.of(CLONE, CLONE, DIG, DIG, DIG));
        RobotPlan actual = robotOperations.daysRequiredToCollectStones(9);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @DisplayName("""
            TEST03: testExcavateStonesForDays_sixDays()
            GIVEN: Number of days: 10
            WHEN: The excavateStonesForDays method is called
            THEN: The result is a RobotPlan with 10 days, 16 stones,
            and the actions [CLONE, CLONE, CLONE, DIG, DIG, DIG]""")
    public void testExcavateStonesForDays_sixDays() {
        RobotPlan expected = new RobotPlan(6, 12,
                List.of(CLONE, CLONE, CLONE, DIG, DIG, DIG));
        RobotPlan actual = robotOperations.excavateStonesForDays(6);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @DisplayName("""
            TEST04: daysRequiredToCollectStones_twelveStones()
            GIVEN: Number of stones: 12
            WHEN: The daysRequiredToCollectStones method is called
            THEN: The result is a RobotPlan with 6 days, 12 stones,
            and the actions [CLONE, CLONE, CLONE, DIG, DIG, DIG]""")
    public void daysRequiredToCollectStones_twelveStones() {
        RobotPlan expected = new RobotPlan(6, 12,
                List.of(CLONE, CLONE, CLONE, DIG, DIG, DIG));
        RobotPlan actual = robotOperations.daysRequiredToCollectStones(12);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

}