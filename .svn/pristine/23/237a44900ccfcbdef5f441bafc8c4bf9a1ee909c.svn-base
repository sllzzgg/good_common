package com.dshl.commons.aop.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author zhouguojun
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DatabaseConfiguration {
	/**
	 * annotation description
	 * 
	 * @return {@link java.lang.String}
	 */
	String description() default "";

	/**
	 * annotation value ,default value "dataSource"
	 * 
	 * @return {@link java.lang.String}
	 */
	String value() default "";
}
