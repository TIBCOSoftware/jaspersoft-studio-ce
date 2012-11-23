/*******************************************************************************
 * Copyright (C) 2010 - 2012 Jaspersoft Corporation. All rights reserved.
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
 *     Jaspersoft Studio Team - initial API and implementation
 ******************************************************************************/
package com.jaspersoft.studio.plugin;

import org.eclipse.jface.action.Action;

import com.jaspersoft.studio.utils.jasper.JasperReportsConfiguration;

public abstract class AContributorAction extends Action {

	protected JasperReportsConfiguration jrConfig;

	public AContributorAction(String id, String text) {
		super();
		setId(id);
		setText(text);
	}

	public void setJrConfig(JasperReportsConfiguration jrConfig) {
		this.jrConfig = jrConfig;
	}

}
