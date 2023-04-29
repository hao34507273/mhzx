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
/*    */ public class DoDeleteNoticeReq
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int AreaId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public int Partition = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public byte PlatId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public long NoticeId = 0L;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 35 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 36 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 37 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 38 */     _js_.marshal("NoticeId", Long.valueOf(this.NoticeId));
/* 39 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 44 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 45 */     this.Partition = _js_.unmarshal_int("Partition");
/* 46 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 47 */     this.NoticeId = _js_.unmarshal_long("NoticeId");
/* 48 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoDeleteNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */