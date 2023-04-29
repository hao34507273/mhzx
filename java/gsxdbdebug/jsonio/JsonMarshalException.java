/*    */ package jsonio;
/*    */ 
/*    */ import org.json.JSONException;
/*    */ 
/*    */ public class JsonMarshalException extends JSONException
/*    */ {
/*    */   private static final long serialVersionUID = 8359217006384151422L;
/*    */   
/*    */   public JsonMarshalException(String message)
/*    */   {
/* 11 */     super(message);
/*    */   }
/*    */   
/*    */   public JsonMarshalException(Throwable t)
/*    */   {
/* 16 */     super(t);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\jsonio\JsonMarshalException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */