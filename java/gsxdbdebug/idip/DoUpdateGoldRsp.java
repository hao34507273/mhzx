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
/*    */ public class DoUpdateGoldRsp
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
/* 26 */   public int AgoNum = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public int NowNum = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 35 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/* 36 */     _js_.marshal("RetMsg", this.RetMsg);
/* 37 */     _js_.marshal("AgoNum", Integer.valueOf(this.AgoNum));
/* 38 */     _js_.marshal("NowNum", Integer.valueOf(this.NowNum));
/* 39 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 44 */     this.Result = _js_.unmarshal_int("Result");
/* 45 */     this.RetMsg = _js_.unmarshal_string("RetMsg");
/* 46 */     this.AgoNum = _js_.unmarshal_int("AgoNum");
/* 47 */     this.NowNum = _js_.unmarshal_int("NowNum");
/* 48 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoUpdateGoldRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */