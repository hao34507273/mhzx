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
/*    */ public class DoSendItemRsp
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
/* 26 */   public String ItemName = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public int BeginValue = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public int EndValue = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 40 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/* 41 */     _js_.marshal("RetMsg", this.RetMsg);
/* 42 */     _js_.marshal("ItemName", this.ItemName);
/* 43 */     _js_.marshal("BeginValue", Integer.valueOf(this.BeginValue));
/* 44 */     _js_.marshal("EndValue", Integer.valueOf(this.EndValue));
/* 45 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 50 */     this.Result = _js_.unmarshal_int("Result");
/* 51 */     this.RetMsg = _js_.unmarshal_string("RetMsg");
/* 52 */     this.ItemName = _js_.unmarshal_string("ItemName");
/* 53 */     this.BeginValue = _js_.unmarshal_int("BeginValue");
/* 54 */     this.EndValue = _js_.unmarshal_int("EndValue");
/* 55 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoSendItemRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */