package com.demo.pay.consultservicedebt.util.constant;

public class ErrorMessages {

  private ErrorMessages() {}

  public static final String ERROR_TO_CALL_ACCOUNT_HOLDER_PROXY = "[AccountHolderServiceImpl] - findById";
  public static final String ERROR_TO_CALL_SERVICE_BILL_PROXY = "[ServiceBillServiceImpl] - findByProvidedServiceId";
  public static final String ERROR_TO_CALL_PROVIDED_SERVICE_PROXY = "[ProvidedServiceServiceImpl] - updateAndFindProvidedServices";
  public static final String ERROR_TO_CALL_SERVICE_PROVIDER_PROXY = "[ServiceProviderServiceImpl] - updateAndFindServiceProviders";

}
