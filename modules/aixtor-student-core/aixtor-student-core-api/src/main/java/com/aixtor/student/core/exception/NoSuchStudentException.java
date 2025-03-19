/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.aixtor.student.core.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchStudentException extends NoSuchModelException {

	public NoSuchStudentException() {
	}

	public NoSuchStudentException(String msg) {
		super(msg);
	}

	public NoSuchStudentException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchStudentException(Throwable throwable) {
		super(throwable);
	}

}