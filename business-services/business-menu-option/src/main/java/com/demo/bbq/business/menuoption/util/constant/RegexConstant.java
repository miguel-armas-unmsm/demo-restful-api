package com.demo.bbq.business.menuoption.util.constant;

/**
 * <br/>Clase Constant que define expresiones regulares.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
public class RegexConstant {

  private RegexConstant() {}

  public static final String ANY_STRING = "^([.0-9a-zA-ZŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÒÓÔÕÖ×ØÙÚÛÜÝàáâãäåæçèéêëìíîïòóôõöùúûüýÿÑñáéíóúÁÉÍÓÚ´‘-]+\\s)*[.0-9a-zA-ZŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÒÓÔÕÖ×ØÙÚÛÜÝàáâãäåæçèéêëìíîïòóôõöùúûüýÿÑñáéíóúÁÉÍÓÚ‘´-]+$";
  public static final String MENU_OPTION_CATEGORY = "^(main-dish|drink|dessert)$";

}
