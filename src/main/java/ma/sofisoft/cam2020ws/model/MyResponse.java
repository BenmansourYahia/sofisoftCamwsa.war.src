 package ma.sofisoft.cam2020ws.model;
 
 import java.io.Serializable;
 
 public class MyResponse
   implements Serializable {
   private boolean success;
   private int code;
   private String data;
   private Object dataObject;
   private String message;
   private Exception exception;
   
   public boolean isSuccess() {
/* 15 */     return this.success;
   }
   public void setSuccess(boolean success) {
/* 18 */     this.success = success;
   }
   public int getCode() {
/* 21 */     return this.code;
   }
   public void setCode(int code) {
/* 24 */     this.code = code;
   }
   public String getData() {
/* 27 */     return this.data;
   }
   public void setData(String data) {
/* 30 */     this.data = data;
   }
   public String getMessage() {
/* 33 */     return this.message;
   }
   public void setMessage(String message) {
/* 36 */     this.message = message;
   }
   public Exception getException() {
/* 39 */     return this.exception;
   }
   public void setException(Exception exception) {
/* 42 */     this.exception = exception;
   }
   public Object getDataObject() {
/* 45 */     return this.dataObject;
   }
   public void setDataObject(Object dataObject) {
/* 48 */     this.dataObject = dataObject;
   }
 }

