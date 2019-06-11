package cy;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import cy.model.Category;
import cy.model.Instance;
import cy.model.KindType;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public final class App {
	static ArrayList<Category> CategoryList = new ArrayList<>();
	static ArrayList<KindType> KindTypeList = new ArrayList<>();
	static ArrayList<Instance> InstanceList = new ArrayList<>();
	static List<String> genericQuestions = null;

	private App() {
	}

	public static void main(String[] args) throws Exception {
		System.out.println("\n\n==== CY APP Start ====\n");

		loadDataFile();

		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);

		cfg.setClassForTemplateLoading(App.class, "templates");
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		Template template = cfg.getTemplate("category.1.ftl");
		Writer consoleWriter = new OutputStreamWriter(System.out);

		Gson gson = new Gson();
		for (Category cat : CategoryList) {
			// Get information for dialog
			String examples = String.join(", ", cat.getExampleInstances());
			String features = gson.toJson(cat.getFeatureTypes());
			String qnFeatureFillings = gson.toJson(cat.getQnFeatureFilling());
			String qnFeatureMakings = gson.toJson(cat.getQnFeatureMaking());

			Map<String, Object> input = new HashMap<String, Object>();
			input.put("obj", cat);
			input.put("dialog_description", cat.getDescription());
			input.put("dialog_examples", examples);
			input.put("json_features", features);
			input.put("json_qnFeatureFilling", qnFeatureFillings);
			input.put("json_qnFeatureMaking", qnFeatureMakings);

			template.process(input, consoleWriter);

			// For the sake of example, also write output into a file:
			// Writer fileWriter = new FileWriter(new File("output.html"));
			// try {
			// template.process(input, fileWriter);
			// } finally {
			// fileWriter.close();
			// }
		}

		Template template2 = cfg.getTemplate("global.ftl");
		Map<String, Object> input = new HashMap<String, Object>();
		if(genericQuestions != null) {
			String generic_questions_str = gson.toJson(genericQuestions);
			input.put("generic_questions", generic_questions_str);
		}
		template2.process(input, consoleWriter);

		System.out.println("\n\n==== CY APP End ====\n");
		System.out.println("ktjson:\n" + gson.toJson(KindTypeList));
	}

	static void loadDataFile() throws Exception {
		String content = new String(Files.readAllBytes(Paths.get("/Users/chenyi/Downloads/Kindtype/updated_json_template_f.json")));
		JsonElement jelement = new JsonParser().parse(content);
		JsonArray jarray = jelement.getAsJsonArray();

		Gson gson = new Gson();

		for (JsonElement el : jarray) {
			JsonObject obj = el.getAsJsonObject();
			String s = obj.getAsJsonPrimitive("type").getAsString();
			// System.out.println("type: " + s);
			switch (s) {
			case "category":
				Category cat = gson.fromJson(obj, Category.class);
				CategoryList.add(cat);
				break;
			case "kind_type":
				KindType kt = gson.fromJson(obj, KindType.class);
				KindTypeList.add(kt);
				break;
			case "instance":
				Instance ins = gson.fromJson(obj, Instance.class);
				InstanceList.add(ins);
				break;
			case "generic_questions":
				genericQuestions = gson.fromJson(obj.getAsJsonArray("qn_feature_filling"), new TypeToken<List<String>>(){}.getType());
				break;
			}
		}
	}
}
