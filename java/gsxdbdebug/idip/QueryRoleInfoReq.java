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
/*    */ public class QueryRoleInfoReq
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
/* 31 */   public String RoleName = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public String RoleNo = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public String RoleId = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 45 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 46 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 47 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 48 */     _js_.marshal("RoleName", this.RoleName);
/* 49 */     _js_.marshal("RoleNo", this.RoleNo);
/* 50 */     _js_.marshal("RoleId", this.RoleId);
/* 51 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 56 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 57 */     this.Partition = _js_.unmarshal_int("Partition");
/* 58 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 59 */     this.RoleName = _js_.unmarshal_string("RoleName");
/* 60 */     this.RoleNo = _js_.unmarshal_string("RoleNo");
/* 61 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 62 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryRoleInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */