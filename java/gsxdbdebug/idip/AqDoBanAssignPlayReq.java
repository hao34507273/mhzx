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
/*    */ public class AqDoBanAssignPlayReq
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
/* 41 */   public int BanType = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public long BanPlayTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public String Reminder = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 55 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 56 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 57 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 58 */     _js_.marshal("OpenId", this.OpenId);
/* 59 */     _js_.marshal("RoleId", this.RoleId);
/* 60 */     _js_.marshal("BanType", Integer.valueOf(this.BanType));
/* 61 */     _js_.marshal("BanPlayTime", Long.valueOf(this.BanPlayTime));
/* 62 */     _js_.marshal("Reminder", this.Reminder);
/* 63 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 68 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 69 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 70 */     this.Partition = _js_.unmarshal_int("Partition");
/* 71 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 72 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 73 */     this.BanType = _js_.unmarshal_int("BanType");
/* 74 */     this.BanPlayTime = _js_.unmarshal_long("BanPlayTime");
/* 75 */     this.Reminder = _js_.unmarshal_string("Reminder");
/* 76 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\AqDoBanAssignPlayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */