package com.cedarsoft.otec.lecture.di.invoices;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( {ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD} )
@BindingAnnotation
public @interface ShippingCosts {
}
