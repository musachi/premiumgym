package com.premium.premiumgym.zconfig;

public class Queries {

    public static final String FIND_BY_TRAINING_DAY_ID_VAR_NAME = "TrainingDayEE.findByTrainingDayId";
    public static final String FIND_BY_TRAINING_DAY_ID = "select t from TrainingDayEE t where t.trainingDay.id = :trainingDayID order by t.exerciseExecutionOrder";

}
