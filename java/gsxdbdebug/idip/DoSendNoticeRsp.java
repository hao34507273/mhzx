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
/*    */ public class DoSendNoticeRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public long NoticeId = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public int Result = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public String RetMsg = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 30 */     _js_.marshal("NoticeId", Long.valueOf(this.NoticeId));
/* 31 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/* 32 */     _js_.marshal("RetMsg", this.RetMsg);
/* 33 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 38 */     this.NoticeId = _js_.unmarshal_long("NoticeId");
/* 39 */     this.Result = _js_.unmarshal_int("Result");
/* 40 */     this.RetMsg = _js_.unmarshal_string("RetMsg");
/* 41 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoSendNoticeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */