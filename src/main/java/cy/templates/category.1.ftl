<#list obj.children as childset>
<div id="cat_childset_${obj.name}_${childset_index}">
	<strong>Select a sub-category under ${obj.name}:</strong><#if obj.name != "Entity"> (<a href="#" onClick="backTo('${obj.name}')">Deselect ${obj.name}</a>)</#if><br>
	<table class="thintable"><tr><th>Type</th><th>Description</th><th>Sample Instances</th></tr>
	<#list childset as child>
	<tr>
		<td nowrap><input type="radio" name="cat_radio_${obj.name}_${childset_index}" value="cat_${child}">&nbsp;<span class="cat-option-text" id="cat_${child}">${child}</span></td>
		<td id="td_description-cat_${child}"></td>
		<td id="td_examples-cat_${child}"></td>
	</tr>
	</#list>
	</table>
	<br>
</div>
</#list>
<div id="cat_${obj.name}_dialog" style="display:none">
	<div id="cat_${obj.name}_description">${dialog_description}</div>
	<div id="cat_${obj.name}_examples">${dialog_examples}</div>
	<div id="cat_${obj.name}_features">${json_features}</div>
</div>
