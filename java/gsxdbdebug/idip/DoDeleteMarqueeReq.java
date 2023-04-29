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
/*    */ public class DoDeleteMarqueeReq
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int AreaId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public byte PlatId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int Partition = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public long MarqueeId = 0L;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 35 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 36 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 37 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 38 */     _js_.marshal("MarqueeId", Long.valueOf(this.MarqueeId));
/* 39 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 44 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 45 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 46 */     this.Partition = _js_.unmarshal_int("Partition");
/* 47 */     this.MarqueeId = _js_.unmarshal_long("MarqueeId");
/* 48 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoDeleteMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */