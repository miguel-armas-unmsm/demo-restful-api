package com.demo.pay.consultservicedebt.util.constant;

/**
 * <br/>Clase Constant que define expresiones regulares.<br/>
 *
 * <b>Constant</b>: RegexConstant<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
public class RegexConstant {

  private RegexConstant() {}

  public static final String ANY_STRING = "^([.0-9a-zA-ZŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÒÓÔÕÖ×ØÙÚÛÜÝàáâãäåæçèéêëìíîïòóôõöùúûüýÿÑñáéíóúÁÉÍÓÚ´‘-]+\\s)*[.0-9a-zA-ZŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÒÓÔÕÖ×ØÙÚÛÜÝàáâãäåæçèéêëìíîïòóôõöùúûüýÿÑñáéíóúÁÉÍÓÚ‘´-]+$";
  public static final String ACCOUNT_NUMBER = "^/d{13}$";
  public static final String CURRENCY = "^[A-Z]{3}$";

}
