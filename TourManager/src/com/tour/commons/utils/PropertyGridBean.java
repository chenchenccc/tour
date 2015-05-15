package com.tour.commons.utils;

/**
 * propertyGrid实体类
 * 
 * @author chenrh
 * @date 2015-5-15
 * @param <T>
 */
public class PropertyGridBean<T> {
    
    private String name;
    private String value;
    private String group;
    private T      editor;
    
    public String getName() {
        return name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue( String value ) {
        this.value = value;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup( String group ) {
        this.group = group;
    }
    
    public T getEditor() {
        return editor;
    }
    
    public void setEditor( T editor ) {
        this.editor = editor;
    }
    
}
