/*******************************************************************************
 * Copyright (C) 2010 - 2014 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *  
 * Unless you have purchased a commercial license agreement from Jaspersoft, 
 * the following license terms apply:
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Jaspersoft Studio Team - initial API and implementation
 ******************************************************************************/
package com.jaspersoft.studio.components.bridge.model;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;

import com.jaspersoft.jasperreports.components.bridge.design.BridgeDesignComponent;
import com.jaspersoft.studio.components.bridge.properties.SPBridgeItemDataList;
import com.jaspersoft.studio.property.descriptor.text.NTextPropertyDescriptor;
import com.jaspersoft.studio.property.section.AbstractSection;
import com.jaspersoft.studio.property.section.widgets.ASPropertyWidget;

/**
 * Property descriptor for the {@link BridgeDesignComponent#PROPERTY_ITEM_DATA} property.
 * 
 * @author Massimo Rabbi (mrabbi@users.sourceforge.net)
 *
 */
public class BridgeItemDataDescriptor extends NTextPropertyDescriptor {

	public BridgeItemDataDescriptor(Object id, String displayName) {
		super(id, displayName);
	}

	@Override
	public CellEditor createPropertyEditor(Composite parent) {
		return null;
	}
	
	@Override
	public ILabelProvider getLabelProvider() {
		return new BridgeItemDataLabelProvider();
	}
	
	@Override
	public ASPropertyWidget createWidget(Composite parent,
			AbstractSection section) {
		return new SPBridgeItemDataList(parent,section,this);
	}
	
}
