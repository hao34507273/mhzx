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
/*    */ public class QueryAllPrizeReq
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
/* 31 */   public int TagId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public int PageNo = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 40 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 41 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 42 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 43 */     _js_.marshal("TagId", Integer.valueOf(this.TagId));
/* 44 */     _js_.marshal("PageNo", Integer.valueOf(this.PageNo));
/* 45 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 50 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 51 */     this.Partition = _js_.unmarshal_int("Partition");
/* 52 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 53 */     this.TagId = _js_.unmarshal_int("TagId");
/* 54 */     this.PageNo = _js_.unmarshal_int("PageNo");
/* 55 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryAllPrizeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */