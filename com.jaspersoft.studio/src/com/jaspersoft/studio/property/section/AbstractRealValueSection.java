/*******************************************************************************
 * Copyright (C) 2005 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com.
 * 
 * Unless you have purchased  a commercial license agreement from Jaspersoft,
 * the following license terms  apply:
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package com.jaspersoft.studio.property.section;

import java.beans.PropertyChangeEvent;

import com.jaspersoft.studio.model.APropertyNode;

	/**
	 * Override the original refresh and propertyChange methods to retrieve from the items it's attributes
	 * actual values, independently if it's inherited of real. Every section that want paint into 
	 * the widget the actual value and avoid the inherited values should extend this section instead
	 * of AbstractSection. Also when the setData method is called is specified both the inherited value and the own
	 * value, that can be the same when the own value is different from null
	 * 
	 * @author Orlandin Marco
	 *
	 */
	abstract public class AbstractRealValueSection extends AbstractSection {
		
		public void refresh() {
			setRefreshing(true);
			APropertyNode element = getElement();
			if (element != null) {
				element.getPropertyDescriptors();
				for (Object key : widgets.keySet()) {
					//Use actual and current value to check if a value is inherited or not
					Object currentValue = element.getPropertyActualValue(key);
					Object ownValue = element.getPropertyValue(key);
					widgets.get(key).setData(element, currentValue, ownValue);
				}
			}
			setRefreshing(false);
		}
		
		/**
		 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
		 */
		public void propertyChange(PropertyChangeEvent evt) {
			if (!isDisposed()) {
				String n = evt.getPropertyName();
				setRefreshing(true);
				APropertyNode element = getElement();
				if (element != null) {
					element.getPropertyDescriptors();
					for (Object key : widgets.keySet()) {
						if (n.equals(key)){
							//Use actual and current value to check if a value is inherited or not
							Object currentValue = element.getPropertyActualValue(key);
							Object ownValue = element.getPropertyValue(key);
							if (ownValue != null)
							widgets.get(key).setData(element, currentValue, ownValue);
						}
					}
				}
				setRefreshing(false);
			}
		}
}
