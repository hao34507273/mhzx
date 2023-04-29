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
/*    */ public class SArchiveInfo
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int ArchiveId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public byte IsReach = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 25 */     _js_.marshal("ArchiveId", Integer.valueOf(this.ArchiveId));
/* 26 */     _js_.marshal("IsReach", Byte.valueOf(this.IsReach));
/* 27 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 32 */     this.ArchiveId = _js_.unmarshal_int("ArchiveId");
/* 33 */     this.IsReach = _js_.unmarshal_byte("IsReach");
/* 34 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\SArchiveInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */