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
package com.jaspersoft.studio.background.action;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbenchPart;

import com.jaspersoft.studio.background.MBackgrounImage;
import com.jaspersoft.studio.editor.action.ACachedSelectionAction;
import com.jaspersoft.studio.messages.Messages;
import com.jaspersoft.studio.property.SetValueCommand;

/**
 * Action to enclose the selected elements into a frame. All
 * the selected elements must have the same parent
 * 
 * @author Orlandin Marco
 * 
 */
public class BackgroundKeepRatioAction extends ACachedSelectionAction {
  
  public static final String ID = "BackgroundKeepRatio"; //$NON-NLS-1$
  
	public BackgroundKeepRatioAction(IWorkbenchPart part) {
		super(part, IAction.AS_CHECK_BOX);
		setLazyEnablementCalculation(true);
	}
	
	@Override
	protected void init() {
		super.init();
		setText(Messages.MBackgrounImage_labelKeepRatio);
		setId(ID);
		setEnabled(false);
	}

	@Override
	protected Command createCommand() {
		List<Object> background = editor.getSelectionCache().getSelectionModelForType(MBackgrounImage.class);
		if (background.isEmpty()) return null;
		MBackgrounImage backgroundModel = (MBackgrounImage)background.get(0);
		
		boolean isKeepRatio = backgroundModel.isKeepRatio();
		
		SetValueCommand command = new SetValueCommand();
		command.setTarget(backgroundModel);
		command.setPropertyId(MBackgrounImage.PROPERTY_KEEP_RATIO);
		command.setPropertyValue(!isKeepRatio);
		
		return command;
	}
	
	@Override
	public void run() {
		super.run();
		//Since the command change without a selection we need to refresh it manually
		fresh = false;
		calculateEnabled();
		//allow to refresh the check state of the command after the command was executed
		firePropertyChange(new PropertyChangeEvent(this, IAction.CHECKED, false, true));
	}
	
	@Override
	public boolean isChecked() {
		List<Object> background = editor.getSelectionCache().getSelectionModelForType(MBackgrounImage.class);
		if (background.isEmpty()) return false;
		MBackgrounImage backgroundModel = (MBackgrounImage)background.get(0);
		return backgroundModel.isKeepRatio();
	}
}

