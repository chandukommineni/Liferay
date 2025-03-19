package com.aixtor.student.rest.builder.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author kommineni.chandu
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false", "osgi.jaxrs.application.base=/aixtor-student",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=AixtorStudentS"
	},
	service = Application.class
)
@Generated("")
public class AixtorStudentRestBuilderApplication extends Application {
}