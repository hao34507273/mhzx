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
/*    */ public class DoUpdateReputationRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int Result = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public String RetMsg = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int BeginValue = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public int EndValue = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 35 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/* 36 */     _js_.marshal("RetMsg", this.RetMsg);
/* 37 */     _js_.marshal("BeginValue", Integer.valueOf(this.BeginValue));
/* 38 */     _js_.marshal("EndValue", Integer.valueOf(this.EndValue));
/* 39 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 44 */     this.Result = _js_.unmarshal_int("Result");
/* 45 */     this.RetMsg = _js_.unmarshal_string("RetMsg");
/* 46 */     this.BeginValue = _js_.unmarshal_int("BeginValue");
/* 47 */     this.EndValue = _js_.unmarshal_int("EndValue");
/* 48 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoUpdateReputationRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */