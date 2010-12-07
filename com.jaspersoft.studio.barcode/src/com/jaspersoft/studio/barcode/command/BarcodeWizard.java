/*
 * Jaspersoft Open Studio - Eclipse-based JasperReports Designer.
 * Copyright (C) 2005 - 2010 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of iReport.
 *
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.studio.barcode.command;

import org.eclipse.jface.wizard.Wizard;

import com.jaspersoft.studio.barcode.model.MBarcode;

public class BarcodeWizard extends Wizard {
	private BarcodeWizardPage page0;
	private MBarcode barcode;

	public BarcodeWizard() {
		super();
		setWindowTitle(Messages.BarcodeWizard_window_title);
	}

	@Override
	public void addPages() {
		page0 = new BarcodeWizardPage();
		addPage(page0);
	}

	public MBarcode getBarcode() {
		if (page0 != null)
			return page0.getBarcode();
		return barcode;
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
