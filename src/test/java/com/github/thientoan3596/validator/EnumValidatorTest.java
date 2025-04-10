package com.github.thientoan3596.validator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.thientoan3596.constraint.ValidEnum;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;

import org.testng.Assert;
import java.util.Set;

import javax.sound.sampled.SourceDataLine;

public class EnumValidatorTest {
  private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
  private final ExecutableValidator executableValidator = validator.forExecutables();
  private ConstraintViolation<Object> first(Set<ConstraintViolation<Object>> set){
    return set.iterator().next();
  }

  public enum MyEnum{
    ValueA,
    ValueB;
  }
  public class ClassWithField{
    @ValidEnum (enumClass = MyEnum.class)
    private String stringifiedEnum;
  }
  @Test
  void hasViolation(){
    ClassWithField classWithField = new ClassWithField();
    classWithField.stringifiedEnum = "BASD";
    Set<ConstraintViolation<Object>> violations = validator.validate(classWithField);
    System.out.println(violations.size());
    //Assert.assertEquals(violations.size(),1);
      //assertThat(violations).hasSize(1);
  }

    

    //@Test
    //public void testValidEnum() {
    //    TestDTO validDTO = new TestDTO("ACTIVE");
    //    Set<jakarta.validation.ConstraintViolation<TestDTO>> violations = validator.validate(validDTO);
    //    Assert.assertTrue(violations.isEmpty(), "Validation failed for ACTIVE status");
    //}
    //
    //@Test
    //public void testInvalidEnum() {
    //    TestDTO invalidDTO = new TestDTO("UNKNOWN");
    //    Set<jakarta.validation.ConstraintViolation<TestDTO>> violations = validator.validate(invalidDTO);
    //    Assert.assertFalse(violations.isEmpty(), "Validation should fail for UNKNOWN status");
    //}
    //
    //@Test
    //public void testNullEnum() {
    //    TestDTO nullDTO = new TestDTO(null);
    //    Set<jakarta.validation.ConstraintViolation<TestDTO>> violations = validator.validate(nullDTO);
    //    Assert.assertTrue(violations.isEmpty(), "Null value should not trigger a validation error");
    //}
    //
    //@Test
    //public void testEmptyEnum() {
    //    TestDTO emptyDTO = new TestDTO("");
    //    Set<jakarta.validation.ConstraintViolation<TestDTO>> violations = validator.validate(emptyDTO);
    //    Assert.assertTrue(violations.isEmpty(), "Empty value should not trigger a validation error");
    //}
    //
    //@Test
    //public void testValidMultiFieldDTO() {
    //    MultiFieldDTO validDTO = new MultiFieldDTO("ACTIVE", "John");
    //    Set<jakarta.validation.ConstraintViolation<MultiFieldDTO>> violations = validator.validate(validDTO);
    //    Assert.assertTrue(violations.isEmpty(), "Validation failed for valid MultiFieldDTO");
    //}
    //
    //@Test
    //public void testInvalidMultiFieldDTO() {
    //    MultiFieldDTO invalidDTO = new MultiFieldDTO("ACTIVE", null);
    //    Set<jakarta.validation.ConstraintViolation<MultiFieldDTO>> violations = validator.validate(invalidDTO);
    //    Assert.assertFalse(violations.isEmpty(), "Validation should fail for invalid MultiFieldDTO");
    //}
}

