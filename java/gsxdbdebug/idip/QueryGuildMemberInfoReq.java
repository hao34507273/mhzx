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
/*    */ public class QueryGuildMemberInfoReq
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
/* 41 */   public String GuildId = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public int PageNo = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 50 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 51 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 52 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 53 */     _js_.marshal("OpenId", this.OpenId);
/* 54 */     _js_.marshal("RoleId", this.RoleId);
/* 55 */     _js_.marshal("GuildId", this.GuildId);
/* 56 */     _js_.marshal("PageNo", Integer.valueOf(this.PageNo));
/* 57 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 62 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 63 */     this.Partition = _js_.unmarshal_int("Partition");
/* 64 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 65 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 66 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 67 */     this.GuildId = _js_.unmarshal_string("GuildId");
/* 68 */     this.PageNo = _js_.unmarshal_int("PageNo");
/* 69 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryGuildMemberInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */