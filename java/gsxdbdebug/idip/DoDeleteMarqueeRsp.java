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
/*    */ public class DoDeleteMarqueeRsp
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
/* 26 */   public long MarqueeId = 0L;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 30 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/* 31 */     _js_.marshal("RetMsg", this.RetMsg);
/* 32 */     _js_.marshal("MarqueeId", Long.valueOf(this.MarqueeId));
/* 33 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 38 */     this.Result = _js_.unmarshal_int("Result");
/* 39 */     this.RetMsg = _js_.unmarshal_string("RetMsg");
/* 40 */     this.MarqueeId = _js_.unmarshal_long("MarqueeId");
/* 41 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoDeleteMarqueeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */