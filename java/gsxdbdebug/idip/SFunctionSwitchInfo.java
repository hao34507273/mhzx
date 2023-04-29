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
/*    */ public class SFunctionSwitchInfo
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int FunctionId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public byte Status = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 25 */     _js_.marshal("FunctionId", Integer.valueOf(this.FunctionId));
/* 26 */     _js_.marshal("Status", Byte.valueOf(this.Status));
/* 27 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 32 */     this.FunctionId = _js_.unmarshal_int("FunctionId");
/* 33 */     this.Status = _js_.unmarshal_byte("Status");
/* 34 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\SFunctionSwitchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */