/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.aixtor.student.core.model.impl;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalServiceUtil;

/**
 * The extended model base implementation for the Student service. Represents a row in the &quot;aixtor_Student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentImpl
 * @see Student
 * @generated
 */
public abstract class StudentBaseImpl
	extends StudentModelImpl implements Student {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student model instance should use the <code>Student</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			StudentLocalServiceUtil.addStudent(this);
		}
		else {
			StudentLocalServiceUtil.updateStudent(this);
		}
	}

}