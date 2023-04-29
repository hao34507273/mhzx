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
/*    */ public class QueryRoleSocialReq
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
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 40 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 41 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 42 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 43 */     _js_.marshal("OpenId", this.OpenId);
/* 44 */     _js_.marshal("RoleId", this.RoleId);
/* 45 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 50 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 51 */     this.Partition = _js_.unmarshal_int("Partition");
/* 52 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 53 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 54 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 55 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryRoleSocialReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */