package com.premium.premiumgym.zconfig;


import java.util.Random;

public class ConstantValues {

    //Endpoints
    public static final int NAME_AND_DESCRIPTION_LENGTH = 255;
    public static final int shortNameAndDescriptionLength = 45;

    //Controllers (End Points)
    public static final String CATEGORIES = "/categories";

    public static final String CLASSIFICATIONS = "/classifications";
    public static final String CLASSIFICATIONS_CONTROLLER = CATEGORIES + "/{id}" + CLASSIFICATIONS;

    public static final String TARGETS = "/targets";
    public static final String EXERCISES = "/exercises";

    public static final String SHIFTS = "/shifts";
    public static final String CLIENTS = "/clients";

    public static final String TRAININGDAYS = "/trainingdays";
    public static final String EXECUTIONS = "/executions";

    public static final String MICROS = "/micros";

    public static final String SERIES = "/series";

    private static final String MEASUREMENTS_TEXT = "/measurements";
    public static final String MEASUREMENTS = CLIENTS + "/{id}" + MEASUREMENTS_TEXT;

    public static final String PLANS = "/plans";

    public static final String WEEKS = CLIENTS + "/{id}" + MEASUREMENTS_TEXT;

    public static final String CHANGES_TEXT = "/changes";
    public static final String CHANGES = CLIENTS + "/{id}" + CHANGES_TEXT;

    public static enum TimeUnit {
        SEC,
        MIN,
    }

    public static enum Gender {
        MALE,
        FEMALE,
        OTHER,
    }

    //TODO remove, just for test
    public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static final Random RANDOM = new Random();

    public static String generate(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static enum WEEK_DAYS{
        MONDAY, TUESDAY, WEDNESDAYS, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
