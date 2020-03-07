package org.geekbong.ioc.java.beans;

import java.beans.*;
import java.util.stream.Stream;

public class BeansinfoDemo{
    public static void main(String args[]) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor ->{
//            System.out.println(propertyDescriptor);
//            propertyDescriptor允许添加属性编辑器
//            gui->text(String)-propertyType
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyName = propertyDescriptor.getName();
            if("age".equals(propertyDescriptor)){//为age字段增加propertyEditor
                //String -> Integer
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
            }
        });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        //text转换成相应的类型 
        @Override
        public void setAsText(String text) throws IllegalArgumentException{
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
