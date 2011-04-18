/*
 * Jaspersoft Open Studio - Eclipse-based JasperReports Designer. Copyright (C) 2005 - 2010 Jaspersoft Corporation. All
 * rights reserved. http://www.jaspersoft.com
 * 
 * Unless you have purchased a commercial license agreement from Jaspersoft, the following license terms apply:
 * 
 * This program is part of Jaspersoft Open Studio.
 * 
 * Jaspersoft Open Studio is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Jaspersoft Open Studio is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with Jaspersoft Open Studio. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.studio.model.text;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.base.JRBaseParagraph;
import net.sf.jasperreports.engine.type.LineSpacingEnum;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import com.jaspersoft.studio.messages.Messages;
import com.jaspersoft.studio.model.APropertyNode;
import com.jaspersoft.studio.property.descriptor.FloatPropertyDescriptor;
import com.jaspersoft.studio.property.descriptor.IntegerPropertyDescriptor;
import com.jaspersoft.studio.property.descriptor.NullEnum;
import com.jaspersoft.studio.utils.EnumHelper;

public class MParagraph extends APropertyNode {

	public MParagraph(JRBaseParagraph bParagraph) {
		super();
		setValue(bParagraph);
	}

	@Override
	public void createPropertyDescriptors(List<IPropertyDescriptor> desc, Map<String, Object> defaultsMap) {

		ComboBoxPropertyDescriptor lineSpacingD = new ComboBoxPropertyDescriptor(JRBaseParagraph.PROPERTY_LINE_SPACING,
				Messages.common_line_spacing, EnumHelper.getEnumNames(LineSpacingEnum.values(), NullEnum.INHERITED));
		lineSpacingD.setDescription(Messages.MTextElement_line_spacing_description);
		desc.add(lineSpacingD);

		FloatPropertyDescriptor lineSpacingSize = new FloatPropertyDescriptor(JRBaseParagraph.PROPERTY_LINE_SPACING_SIZE,
				"Line Spacing Size");
		lineSpacingSize.setDescription("Line spacing size.");
		desc.add(lineSpacingSize);

		IntegerPropertyDescriptor firstLineIdent = new IntegerPropertyDescriptor(
				JRBaseParagraph.PROPERTY_FIRST_LINE_INDENT, "First Line Indent");
		firstLineIdent.setDescription("First line identation size in pixel.");
		desc.add(firstLineIdent);

		IntegerPropertyDescriptor leftIdent = new IntegerPropertyDescriptor(JRBaseParagraph.PROPERTY_LEFT_INDENT,
				"Left Indent");
		leftIdent.setDescription("Left identation size in pixel.");
		desc.add(leftIdent);

		IntegerPropertyDescriptor rightIdent = new IntegerPropertyDescriptor(JRBaseParagraph.PROPERTY_RIGHT_INDENT,
				"Right Indent");
		rightIdent.setDescription("Right identation size in pixel.");
		desc.add(rightIdent);

		IntegerPropertyDescriptor spacingBefore = new IntegerPropertyDescriptor(JRBaseParagraph.PROPERTY_SPACING_BEFORE,
				"Spacing Before");
		spacingBefore.setDescription("Spacing before paragraph in pixel.");
		desc.add(spacingBefore);

		IntegerPropertyDescriptor spacingAfter = new IntegerPropertyDescriptor(JRBaseParagraph.PROPERTY_SPACING_AFTER,
				"Spacing After");
		spacingAfter.setDescription("Spacing after paragraph in pixel.");
		desc.add(spacingAfter);

		IntegerPropertyDescriptor tabStopWidth = new IntegerPropertyDescriptor(JRBaseParagraph.PROPERTY_TAB_STOP_WIDTH,
				"Tab Stop Width");
		tabStopWidth.setDescription("Tab stop width in pixel.");
		desc.add(tabStopWidth);

		lineSpacingD.setCategory("Paragraph");
		lineSpacingSize.setCategory("Paragraph");
		firstLineIdent.setCategory("Paragraph");
		leftIdent.setCategory("Paragraph");
		rightIdent.setCategory("Paragraph");
		spacingBefore.setCategory("Paragraph");
		spacingAfter.setCategory("Paragraph");
		tabStopWidth.setCategory("Paragraph");
	}

	private static IPropertyDescriptor[] descriptors;
	private static Map<String, Object> defaultsMap;

	@Override
	public Map<String, Object> getDefaultsMap() {
		return defaultsMap;
	}

	@Override
	public IPropertyDescriptor[] getDescriptors() {
		return descriptors;
	}

	@Override
	public void setDescriptors(IPropertyDescriptor[] descriptors1, Map<String, Object> defaultsMap1) {
		descriptors = descriptors1;
		defaultsMap = defaultsMap1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {
		JRBaseParagraph jrElement = (JRBaseParagraph) getValue();
		if (jrElement != null) {
			if (id.equals(JRBaseParagraph.PROPERTY_LINE_SPACING))
				return EnumHelper.getValue(jrElement.getOwnLineSpacing(), 0, true);
			if (id.equals(JRBaseParagraph.PROPERTY_LINE_SPACING_SIZE))
				return jrElement.getOwnLineSpacingSize();

			if (id.equals(JRBaseParagraph.PROPERTY_FIRST_LINE_INDENT))
				return jrElement.getOwnFirstLineIndent();

			if (id.equals(JRBaseParagraph.PROPERTY_LEFT_INDENT))
				return jrElement.getOwnLeftIndent();
			if (id.equals(JRBaseParagraph.PROPERTY_RIGHT_INDENT))
				return jrElement.getOwnRightIndent();

			if (id.equals(JRBaseParagraph.PROPERTY_SPACING_BEFORE))
				return jrElement.getOwnSpacingBefore();
			if (id.equals(JRBaseParagraph.PROPERTY_SPACING_AFTER))
				return jrElement.getOwnSpacingAfter();
			if (id.equals(JRBaseParagraph.PROPERTY_TAB_STOP_WIDTH))
				return jrElement.getOwnTabStopWidth();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
		JRBaseParagraph jrElement = (JRBaseParagraph) getValue();
		if (jrElement != null) {
			if (id.equals(JRBaseParagraph.PROPERTY_LINE_SPACING))
				jrElement.setLineSpacing((LineSpacingEnum) EnumHelper.getSetValue(LineSpacingEnum.values(), value, 0, true));
			if (id.equals(JRBaseParagraph.PROPERTY_LINE_SPACING_SIZE))
				jrElement.setLineSpacingSize((Float) value);
			if (id.equals(JRBaseParagraph.PROPERTY_FIRST_LINE_INDENT))
				jrElement.setFirstLineIndent((Integer) value);
			if (id.equals(JRBaseParagraph.PROPERTY_LEFT_INDENT))
				jrElement.setLeftIndent((Integer) value);
			if (id.equals(JRBaseParagraph.PROPERTY_RIGHT_INDENT))
				jrElement.setRightIndent((Integer) value);

			if (id.equals(JRBaseParagraph.PROPERTY_SPACING_BEFORE))
				jrElement.setSpacingBefore((Integer) value);
			if (id.equals(JRBaseParagraph.PROPERTY_SPACING_AFTER))
				jrElement.setSpacingAfter((Integer) value);

			if (id.equals(JRBaseParagraph.PROPERTY_TAB_STOP_WIDTH))
				jrElement.setTabStopWidth((Integer) value);
		}
	}

	public String getDisplayText() {
		return null;
	}

	public ImageDescriptor getImagePath() {
		return null;
	}

}
