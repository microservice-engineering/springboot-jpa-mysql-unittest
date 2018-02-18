/**  
 * All rights Reserved, Designed By IBM
 * @Title:  JsonResponse.java   
 * @Package com.springboot.jpa.entity   
 * @Description:    TODO
 * @author: IBM    
 * @date:   Feb 15, 2018 3:04:58 PM   
 * @version V1.0 
 * @Copyright: 2018 IBM. All rights reserved. 
 */
package com.springboot.jpa.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Integer OK = 0;
    public static final Integer ERROR = 103;

    private Integer code;
    private String message;
    private boolean success;
    private T data;

}
