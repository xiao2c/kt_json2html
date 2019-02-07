<#list obj.children as childset>
<div id="cat_childset_${obj.name}_${childset_index}">
	<strong>Select a sub-category under ${obj.name}:</strong><br>
	<#list childset as child>
	<input type="radio" name="cat_radio_${obj.name}_${childset_index}" value="cat_${child}"> <span class="cat-option-text" id="cat_${child}">${child}</span><br>
	</#list>
	<br><br>
</div>
</#list>
<div id="cat_${obj.name}_dialog" style="display:none">
	<div id="cat_${obj.name}_description">${dialog_description}</div>
	<div id="cat_${obj.name}_examples">${dialog_examples}</div>
	<div id="cat_${obj.name}_features">${json_features}</div>
</div>
