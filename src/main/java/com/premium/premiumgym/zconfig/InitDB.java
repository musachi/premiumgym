package com.premium.premiumgym.zconfig;

import com.premium.premiumgym.classification.Category;
import com.premium.premiumgym.classification.CategoryRepository;
import com.premium.premiumgym.classification.Classification;
import com.premium.premiumgym.classification.ClassificationRepository;
import com.premium.premiumgym.client.Client;
import com.premium.premiumgym.client.ClientService;
import com.premium.premiumgym.exercise.Execution.*;
import com.premium.premiumgym.exercise.Exercise;
import com.premium.premiumgym.exercise.ExerciseRepository;
import com.premium.premiumgym.exercise.Target;
import com.premium.premiumgym.exercise.TargetRepository;
import com.premium.premiumgym.shift.Shift;
import com.premium.premiumgym.shift.ShiftRepository;
import com.premium.premiumgym.shift.Week;
import com.premium.premiumgym.shift.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class InitDB implements ApplicationRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TargetRepository targetRepository;

	@Autowired
	private ClassificationRepository classificationRepository;
	@Autowired
	private ExerciseRepository exerciseRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Insert Categories into the databases
		//Insert Classifications into Categories

		CategoriesClassifications();

		getTargets();

		getExercises();

		//getSeries();

		getExecutions();

		getShifts();

		getWeeks();

		getClients();
	}

	public List<Category> CategoriesClassifications() {
		List<Category> categories = Category.generateCategories();

		HashMap<String, List<String>> catClassification = new HashMap<String, List<String>>() {
			{
				put("Movimiento", new ArrayList<String>(Arrays.asList(new String[]{
						"Extensión de Piernas",
						"Extensión de Cadera",
						"Extensión de Brazos",
						"Flexión de Brazos"})));

				put("Plano Muscular", new ArrayList<String>(Arrays.asList(new String[]{
						"Piernas - Parte anterior -",
						"Piernas y glúteos",
						"Piernas - Parte posterior -, gluteos y tronco",
						"Brazos y pectorales"})));

				put("Implemento", new ArrayList<String>(Arrays.asList(new String[]{
						"Ejercicio con barra",
						"Ejercicio c-mancuernas",
						"Ejercicio c-Kettlebells",
						"Ejercicio c-Peso Corporal"})));
			}
		};
		catClassification.forEach((key, value) -> {
			Category category = new Category();
			category.setName(key);
			Category newCategory = categoryRepository.save(category);
			//List<Classification> classifications = new ArrayList<>();

			for (String claString : value) {
				Classification classification = new Classification();
				classification.setName(claString);
				classification.setCategory(newCategory);

				classification = classificationRepository.save(classification);
				newCategory.addClassification(classification);
				categoryRepository.save(newCategory);
			}
		});

		return categories;
	}

	public List<Target> getTargets() {
		List<Target> targets = new ArrayList<>();
		for (Target t : Target.generateTargets()) {
			targets.add(targetRepository.save(t));
		}

		return targets;
	}

	public List<Exercise> getExercises() {
		List<Exercise> exercises = new ArrayList<>();
		for (Exercise exercise : Exercise.generateExercises()) {
			exercises.add(exerciseRepository.save(exercise));
		}

		return exercises;
	}

	@Autowired
	public SerieRepository serieRepository;

	public List<Serie> getSeries() {

		List<Serie> series = new ArrayList<>();

		for (Serie serie : Serie.generateSeries()) {
			series.add(serieRepository.save(serie));
		}

		return series;
	}

	@Autowired
	public ExecutionRepository executionRepository;

	public List<Execution> getExecutions() {
		List<Execution> executions = new ArrayList<>();

		CompletableFuture.supplyAsync(() -> getSeries()).thenAcceptAsync((result) -> {
			List<Serie> series = new ArrayList<>();
			series = result;

			for (Execution execution : Execution.generateExecution()) {

				execution.getSeries().add(series.get(0));
				execution.getSeries().add(series.get(1));
				execution.getSeries().add(series.get(2));

				executions.add(executionRepository.save(execution));
			}
		});

		return executions;
	}

	@Autowired
	public ShiftRepository shiftRepository;

	public List<Shift> getShifts() {
		List<Shift> shifts = new ArrayList<>();
		for (Shift shift : Shift.generateShifts()) {
			shifts.add(shiftRepository.save(shift));
		}
		return shifts;
	}

	@Autowired
	public WeekRepository weekRepository;

	public List<Week> getWeeks()
	{
		List<Week> weeks = new ArrayList<>();

		for (Week week : Week.generateWeeks())
		{
			weeks.add(weekRepository.save(week));
		}

		return weeks;
	}

	//TODO remove generetad values series
	@Autowired
	ClientService clientService;
	public void getClients()
	{
		for(Client client: Client.generateClients())
		{
			clientService.create(client);
		}
	}
}
