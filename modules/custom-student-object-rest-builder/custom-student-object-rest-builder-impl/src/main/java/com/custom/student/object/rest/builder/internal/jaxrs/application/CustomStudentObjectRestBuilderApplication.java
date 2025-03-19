package com.custom.student.object.rest.builder.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author kommineni.chandu
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/custom-student-object-rest-builder",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=CustomStudentObjectRestBuilder"
	},
	service = Application.class
)
@Generated("")
public class CustomStudentObjectRestBuilderApplication extends Application {
}