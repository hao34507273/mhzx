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
/*    */ public class QueryOwnXianlvReq
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
/* 31 */   public String OpenId = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public String RoleId = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public String XianLvId = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 45 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 46 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 47 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 48 */     _js_.marshal("OpenId", this.OpenId);
/* 49 */     _js_.marshal("RoleId", this.RoleId);
/* 50 */     _js_.marshal("XianLvId", this.XianLvId);
/* 51 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 56 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 57 */     this.Partition = _js_.unmarshal_int("Partition");
/* 58 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 59 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 60 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 61 */     this.XianLvId = _js_.unmarshal_string("XianLvId");
/* 62 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryOwnXianlvReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */