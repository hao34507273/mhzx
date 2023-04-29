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
/*    */ public class QueryNoticeReq
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
/* 31 */   public long StartTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public long EndTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public int PageNo = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 45 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 46 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 47 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 48 */     _js_.marshal("StartTime", Long.valueOf(this.StartTime));
/* 49 */     _js_.marshal("EndTime", Long.valueOf(this.EndTime));
/* 50 */     _js_.marshal("PageNo", Integer.valueOf(this.PageNo));
/* 51 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 56 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 57 */     this.Partition = _js_.unmarshal_int("Partition");
/* 58 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 59 */     this.StartTime = _js_.unmarshal_long("StartTime");
/* 60 */     this.EndTime = _js_.unmarshal_long("EndTime");
/* 61 */     this.PageNo = _js_.unmarshal_int("PageNo");
/* 62 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */