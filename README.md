# springboot-jpa-mysql-unittest

[单元测试参考文章]: http://tengj.top/2017/12/28/springboot12/
[参考文章]: http://www.baeldung.com/spring-boot-testing

这次来介绍下Spring Boot中对单元测试的整合使用，本篇会通过以下4点来介绍，基本满足日常需求

- Service层单元测试
- Controller层单元测试
- 新断言assertThat使用
- 单元测试的回滚

如何对controller层进行Unit Test

    package com.springboot.jpa;
    
    @RunWith(SpringRunner.class)//声明之后就可以进行unit test
    @SpringBootTest
    @AutoConfigureMockMvc //这里允许声明MockMvc
    public class ControllerTest {
    	
    	@Autowired
        private MockMvc mvc;
        
    	/**
    	 * Test method for {@link com.springboot.jpa.controller.HelloController#index()}.
    	 */
    	@Test
    	public void testIndex() {
    		fail("Not yet implemented");
    	}
    
    	/**
    	 * Test method for {@link com.springboot.jpa.controller.HelloController#saveData()}.
    	 */
    	@Test
    	public void testSaveData() {
    		fail("Not yet implemented");
    	}
    
    	/**
    	 * Test method for {@link com.springboot.jpa.controller.HelloController#findByUsername(java.lang.String)}.
    	 */
    	@Test
    	public void testFindByUsername() {
    		try {
    			mvc.perform(get("/findByName")//需要调用的API
    					.param("username", "Alex")//添加参数/findByName？username=Alex
    				      .contentType(MediaType.APPLICATION_JSON))//数据格式
    				      .andExpect(status().isOk())
    				      .andExpect(MockMvcResultMatchers.content().string("{\"id\":2,\"username\":\"Alex\",\"password\":\"aq1sw2de\",\"age\":32,\"emailadress\":\"alex_decimal@126.com\"}"));
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    
    	/**
    	 * Test method for {@link com.springboot.jpa.controller.HelloController#findUser(java.lang.String)}.
    	 */
    	@Test
    	public void testFindUser() {
    		fail("Not yet implemented");
    	}
    
    }
    

对Service层进行Unit Test

    package com.springboot.jpa;
    
    @RunWith(SpringRunner.class)//定义unit test
    @SpringBootTest
    public class UserserviceTest {
    	
    	@Autowired
    	IUserService mUserService;//被测试service
    
    	@Test
    	public void testSaveUser() {
    		fail("Not yet implemented");
    	}
    
    	@Test
    	public void testFindByUsername() {
    		User result = mUserService.findByUsername("Alex");
    		assertThat(result.getUsername(), is("Alex"));
    	}
    
    	@Test
    	public void testFindUser() {
    		fail("Not yet implemented");
    	}
    
    }
    

JPA层进行Unit Test

    package com.springboot.jpa;
    
    /**
     * @author alex
     *
     */
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class UserJPA {
    	
    	@Autowired
    	UserRepository mUserRepository;//需要测试的JPA
    
    	@Test
    	public void test() {
    		fail("Not yet implemented");
    	}
    	
    	@Test
    	public void findByUsername() {
    		User result = mUserRepository.findByUsername("Alex");
    		assertThat(result.getUsername(), is("Alex"));
    	}
    
    }
    

如何使用assertThat

    /**equalTo匹配符断言被测的testedValue等于expectedValue，
    * equalTo可以断言数值之间，字符串之间和对象之间是否相等，相当于Object的equals方法
    */
    assertThat(testedValue, equalTo(expectedValue));
    
    /**equalToIgnoringCase匹配符断言被测的字符串testedString
    *在忽略大小写的情况下等于expectedString
    */
    assertThat(testedString, equalToIgnoringCase(expectedString));
    /**equalToIgnoringWhiteSpace匹配符断言被测的字符串testedString
    *在忽略头尾的任意个空格的情况下等于expectedString，
    *注意：字符串中的空格不能被忽略
    */
    
    assertThat(testedString, equalToIgnoringWhiteSpace(expectedString);
    /**containsString匹配符断言被测的字符串testedString包含子字符串subString**/
    assertThat(testedString, containsString(subString) );
    /**endsWith匹配符断言被测的字符串testedString以子字符串suffix结尾*/
    assertThat(testedString, endsWith(suffix));
    /**startsWith匹配符断言被测的字符串testedString以子字符串prefix开始*/
    assertThat(testedString, startsWith(prefix));
               
    一般匹配符
    /**nullValue()匹配符断言被测object的值为null*/
    assertThat(object,nullValue());
    /**notNullValue()匹配符断言被测object的值不为null*/
    assertThat(object,notNullValue());
    /**is匹配符断言被测的object等于后面给出匹配表达式*/
    assertThat(testedString, is(equalTo(expectedValue)));
    /**is匹配符简写应用之一，is(equalTo(x))的简写，断言testedValue等于expectedValue*/
    assertThat(testedValue, is(expectedValue));
    /**is匹配符简写应用之二，is(instanceOf(SomeClass.class))的简写，
    *断言testedObject为Cheddar的实例
    */
    assertThat(testedObject, is(Cheddar.class));
    /**not匹配符和is匹配符正好相反，断言被测的object不等于后面给出的object*/
    assertThat(testedString, not(expectedString));
    /**allOf匹配符断言符合所有条件，相当于“与”（&&）*/
    assertThat(testedNumber, allOf( greaterThan(8), lessThan(16) ) );
    /**anyOf匹配符断言符合条件之一，相当于“或”（||）*/
    assertThat(testedNumber, anyOf( greaterThan(16), lessThan(8) ) );
    数值相关匹配符
    /**closeTo匹配符断言被测的浮点型数testedDouble在20.0¡À0.5范围之内*/
    assertThat(testedDouble, closeTo( 20.0, 0.5 ));
    /**greaterThan匹配符断言被测的数值testedNumber大于16.0*/
    assertThat(testedNumber, greaterThan(16.0));
    /** lessThan匹配符断言被测的数值testedNumber小于16.0*/
    assertThat(testedNumber, lessThan (16.0));
    /** greaterThanOrEqualTo匹配符断言被测的数值testedNumber大于等于16.0*/
    assertThat(testedNumber, greaterThanOrEqualTo (16.0));
    /** lessThanOrEqualTo匹配符断言被测的testedNumber小于等于16.0*/
    assertThat(testedNumber, lessThanOrEqualTo (16.0));
    集合相关匹配符
    /**hasEntry匹配符断言被测的Map对象mapObject含有一个键值为"key"对应元素值为"value"的Entry项*/
    assertThat(mapObject, hasEntry("key", "value" ) );
    /**hasItem匹配符表明被测的迭代对象iterableObject含有元素element项则测试通过*/
    assertThat(iterableObject, hasItem (element));
    /** hasKey匹配符断言被测的Map对象mapObject含有键值“key”*/
    assertThat(mapObject, hasKey ("key"));
    /** hasValue匹配符断言被测的Map对象mapObject含有元素值value*/
    assertThat(mapObject, hasValue(value));


