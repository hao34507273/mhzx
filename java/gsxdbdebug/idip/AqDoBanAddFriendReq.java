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
/*    */ public class AqDoBanAddFriendReq
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
/* 41 */   public int Time = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public String Reason = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public int Source = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   public String Serial = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 60 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 61 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 62 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 63 */     _js_.marshal("OpenId", this.OpenId);
/* 64 */     _js_.marshal("RoleId", this.RoleId);
/* 65 */     _js_.marshal("Time", Integer.valueOf(this.Time));
/* 66 */     _js_.marshal("Reason", this.Reason);
/* 67 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 68 */     _js_.marshal("Serial", this.Serial);
/* 69 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 74 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 75 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 76 */     this.Partition = _js_.unmarshal_int("Partition");
/* 77 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 78 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 79 */     this.Time = _js_.unmarshal_int("Time");
/* 80 */     this.Reason = _js_.unmarshal_string("Reason");
/* 81 */     this.Source = _js_.unmarshal_int("Source");
/* 82 */     this.Serial = _js_.unmarshal_string("Serial");
/* 83 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\AqDoBanAddFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */