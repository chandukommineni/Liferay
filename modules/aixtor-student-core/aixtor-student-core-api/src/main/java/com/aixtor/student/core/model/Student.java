/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.aixtor.student.core.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Student service. Represents a row in the &quot;aixtor_Student&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StudentModel
 * @generated
 */
@ImplementationClassName("com.aixtor.student.core.model.impl.StudentImpl")
@ProviderType
public interface Student extends PersistedModel, StudentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.aixtor.student.core.model.impl.StudentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Student, Long> STUDENT_ID_ACCESSOR =
		new Accessor<Student, Long>() {

			@Override
			public Long get(Student student) {
				return student.getStudentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Student> getTypeClass() {
				return Student.class;
			}

		};

}