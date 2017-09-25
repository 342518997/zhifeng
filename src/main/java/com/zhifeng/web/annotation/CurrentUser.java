/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zhifeng.web.annotation;



import java.lang.annotation.*;

/**
 * <p>绑定当前登录的用户</p>
 * <p>不同于@ModelAttribute</p>
 *
 *
 */
/*作用于参数列表上*/
@Target({ElementType.PARAMETER})
/*这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.*/
@Retention(RetentionPolicy.RUNTIME)
/*表明这个注解应该被 javadoc工具记录*/
@Documented



/*用于向程序分析工具或虚拟机提供
package class field methed 等方面的信息,
它和其他类没什么区别,除了使用方式.
* */
public @interface CurrentUser {

    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default Constants.CURRENT_USER;

}
    /*和它等价的java类为:*/
    /*
    * public class CurrentUser extends java.lang.annotation.Annotation{
     private String value = Constants.CURRENT_USER;
     public void setValue(String value){
          this.value = value;
     }
     public String getValue(){
          return value;
      }
    *
    * */