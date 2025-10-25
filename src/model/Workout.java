package model;

import java.util.List;
import java.awt.Color;

public class Workout {
    private String title;
    private String difficulty;
    private String category;
    private String imageUrl;
    private List<String> equipment;
    private List<String> targetMuscles;
    private String description;
    private Color headerColor;

    public Workout(String title, String difficulty, String category, String imageUrl,
                   List<String> equipment, List<String> targetMuscles, String description, Color headerColor) {
        this.title = title;
        this.difficulty = difficulty;
        this.category = category;
        this.imageUrl = imageUrl;
        this.equipment = equipment;
        this.targetMuscles = targetMuscles;
        this.description = description;
        this.headerColor = headerColor;
    }

    public String getTitle() { return title; }
    public String getDifficulty() { return difficulty; }
    public String getCategory() { return category; }
    public String getImageUrl() { return imageUrl; }
    public List<String> getEquipment() { return equipment; }
    public List<String> getTargetMuscles() { return targetMuscles; }
    public String getDescription() { return description; }
    public Color getHeaderColor() { return headerColor; }
}

