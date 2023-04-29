/*    */ package idip;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AqDoCleartSayRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int Result = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public String RetMsg = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 25 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/* 26 */     _js_.marshal("RetMsg", this.RetMsg);
/* 27 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 32 */     this.Result = _js_.unmarshal_int("Result");
/* 33 */     this.RetMsg = _js_.unmarshal_string("RetMsg");
/* 34 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\AqDoCleartSayRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */