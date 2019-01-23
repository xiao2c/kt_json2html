package cy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeatureType {

	@SerializedName("feature_name")
	@Expose
	private String featureName;
	@SerializedName("example")
	@Expose
	private String example;
	@SerializedName("explain")
	@Expose
	private String explain;

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

}