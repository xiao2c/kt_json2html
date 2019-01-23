package cy.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Instance {

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("kind_type")
	@Expose
	private List<String> kindType = null;
	@SerializedName("feature_values")
	@Expose
	private List<FeatureValue> featureValues = null;

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

	public List<String> getKindType() {
		return kindType;
	}

	public void setKindType(List<String> kindType) {
		this.kindType = kindType;
	}

	public List<FeatureValue> getFeatureValues() {
		return featureValues;
	}

	public void setFeatureValues(List<FeatureValue> featureValues) {
		this.featureValues = featureValues;
	}

}