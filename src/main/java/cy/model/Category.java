package cy.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("children")
	@Expose
	private List<List<String>> children = null;
	@SerializedName("feature_types")
	@Expose
	private List<FeatureType> featureTypes = null;
	@SerializedName("example_instances")
	@Expose
	private List<String> exampleInstances = null;
	@SerializedName("qn_feature_filling")
	@Expose
	private List<String> qnFeatureFilling = null;
	@SerializedName("qn_feature_making")
	@Expose
	private List<String> qnFeatureMaking = null;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<List<String>> getChildren() {
		return children;
	}

	public void setChildren(List<List<String>> children) {
		this.children = children;
	}

	public List<FeatureType> getFeatureTypes() {
		return featureTypes;
	}

	public void setFeatureTypes(List<FeatureType> featureTypes) {
		this.featureTypes = featureTypes;
	}

	public List<String> getExampleInstances() {
		return exampleInstances;
	}

	public void setExampleInstances(List<String> exampleInstances) {
		this.exampleInstances = exampleInstances;
	}

	public List<String> getQnFeatureFilling() {
		return qnFeatureFilling;
	}

	public void setQnFeatureFilling(List<String> qnFeatureFilling) {
		this.qnFeatureFilling = qnFeatureFilling;
	}

	public List<String> getQnFeatureMaking() {
		return qnFeatureMaking;
	}

	public void setQnFeatureMaking(List<String> qnFeatureMaking) {
		this.qnFeatureMaking = qnFeatureMaking;
	}

}