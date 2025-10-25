package view.WorkoutsUI;

import model.Workout;
import model.WorkoutXMLParser;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WorkoutListPanel extends JPanel {

    public WorkoutListPanel() {
        setLayout(new GridLayout(0, 3, 20, 20));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        List<Workout> workouts = WorkoutXMLParser.parseWorkouts("workouts.xml");

        for (Workout workout : workouts) {
            add(new WorkoutCard(workout));
        }
    }
}