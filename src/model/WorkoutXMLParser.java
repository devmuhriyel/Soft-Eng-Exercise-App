package model;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

public class WorkoutXMLParser {

    public static List<Workout> parseWorkouts(String xmlFilePath) {
        List<Workout> workouts = new ArrayList<>();

        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList workoutNodes = doc.getElementsByTagName("workout");

            for (int i = 0; i < workoutNodes.getLength(); i++) {
                Node workoutNode = workoutNodes.item(i);

                if (workoutNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element workoutElement = (Element) workoutNode;

                    String title = getElementText(workoutElement, "title");
                    String difficulty = getElementText(workoutElement, "difficulty");
                    String category = getElementText(workoutElement, "category");
                    String imageUrl = getElementText(workoutElement, "imageUrl");
                    String description = getElementText(workoutElement, "description");

                    List<String> equipment = getListElements(workoutElement, "equipment", "item");
                    List<String> targetMuscles = getListElements(workoutElement, "targetMuscles", "muscle");

                    Color headerColor = getColorForDifficulty(difficulty);

                    workouts.add(new Workout(title, difficulty, category, imageUrl,
                            equipment, targetMuscles, description, headerColor));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            workouts.addAll(getSampleWorkouts());
        }

        return workouts;
    }

    private static String getElementText(Element parent, String tagName) {
        NodeList nodeList = parent.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }

    private static List<String> getListElements(Element parent, String listTag, String itemTag) {
        List<String> items = new ArrayList<>();
        NodeList listNodes = parent.getElementsByTagName(listTag);

        if (listNodes.getLength() > 0) {
            Element listElement = (Element) listNodes.item(0);
            NodeList itemNodes = listElement.getElementsByTagName(itemTag);

            for (int i = 0; i < itemNodes.getLength(); i++) {
                items.add(itemNodes.item(i).getTextContent());
            }
        }

        return items;
    }

    private static Color getColorForDifficulty(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "beginner": return new Color(76, 175, 80);
            case "novice": return new Color(255, 193, 7);
            case "intermediate": return new Color(255, 152, 0);
            case "advanced": return new Color(244, 67, 54);
            default: return new Color(158, 158, 158);
        }
    }

    private static List<Workout> getSampleWorkouts() {
        List<Workout> workouts = new ArrayList<>();

        workouts.add(new Workout(
                "Full Body Novice Bodybuilding - Day 1",
                "Novice",
                "Full Body",
                "sample_image_1.jpg",
                Arrays.asList("Dumbbells", "Bench"),
                Arrays.asList("Chest", "Legs", "Back"),
                "Complete full body workout for novice bodybuilders",
                new Color(255, 193, 7)
        ));

        workouts.add(new Workout(
                "Full Body Novice Bodybuilding - Day 2",
                "Novice",
                "Full Body",
                "sample_image_2.jpg",
                Arrays.asList("Dumbbells"),
                Arrays.asList("Arms", "Chest", "Back"),
                "Second day of full body training",
                new Color(255, 193, 7)
        ));

        workouts.add(new Workout(
                "Full Body Novice Bodybuilding - Day 3",
                "Novice",
                "Full Body",
                "sample_image_3.jpg",
                Arrays.asList("Dumbbells", "Mat"),
                Arrays.asList("Core", "Legs"),
                "Third day of full body training",
                new Color(255, 193, 7)
        ));

        workouts.add(new Workout(
                "The 1 Dumbbell Workout",
                "Beginner",
                "Full Body",
                "sample_image_4.jpg",
                Arrays.asList("Dumbbell"),
                Arrays.asList("Full Body"),
                "Complete workout with just one dumbbell",
                new Color(76, 175, 80)
        ));

        workouts.add(new Workout(
                "Beginner Dumbbell Workout",
                "Beginner",
                "Full Body",
                "sample_image_5.jpg",
                Arrays.asList("Dumbbells"),
                Arrays.asList("Full Body"),
                "Perfect for beginners starting with dumbbells",
                new Color(76, 175, 80)
        ));

        workouts.add(new Workout(
                "Triceps for Beginners",
                "Beginner",
                "Upper Body",
                "sample_image_6.jpg",
                Arrays.asList("Dumbbells", "Bench"),
                Arrays.asList("Triceps"),
                "Focus on building stronger triceps",
                new Color(76, 175, 80)
        ));

        return workouts;
    }
}
