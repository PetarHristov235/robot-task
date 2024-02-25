package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// I am so sorry for the changing of the skeleton, however I have to make the code work
// (we can create a new Instance of RobotOperations in the RobotRestController class and to not use the
// @Service annotation however I don't think it is good practice overall)
public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     *         algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     *         number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     *         days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        int stones = 0;
        int robots = 1;
        List<RobotAction> actions = new ArrayList<>();

        for (int day = 1; day <= days; day++) {
            if (robots <= days / 2) {
                actions.add(RobotAction.CLONE);
                robots++;
            } else {
                actions.add(RobotAction.DIG);
                stones += robots;
            }
        }

        return new RobotPlan(days, stones, actions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     *         provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     *         {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     *         {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        int days = 0;
        int collectedStones = 0;
        int robots = 1;
        List<RobotAction> actions = new ArrayList<>();

        while (collectedStones < numberOfStones) {
            if (robots < Math.sqrt(numberOfStones - collectedStones)) {
                actions.add(RobotAction.CLONE);
                robots++;
            } else {
                actions.add(RobotAction.DIG);
                collectedStones += robots;
            }
            days++;
        }

        return new RobotPlan(days, numberOfStones, actions);
    }
}
