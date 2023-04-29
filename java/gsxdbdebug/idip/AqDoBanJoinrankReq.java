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
/*    */ public class AqDoBanJoinrankReq
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
/* 41 */   public byte IsZeroRank = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public byte Type = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public int Time = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   public String Tip = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 61 */   public int Source = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 66 */   public String Serial = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 70 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 71 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 72 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 73 */     _js_.marshal("OpenId", this.OpenId);
/* 74 */     _js_.marshal("RoleId", this.RoleId);
/* 75 */     _js_.marshal("IsZeroRank", Byte.valueOf(this.IsZeroRank));
/* 76 */     _js_.marshal("Type", Byte.valueOf(this.Type));
/* 77 */     _js_.marshal("Time", Integer.valueOf(this.Time));
/* 78 */     _js_.marshal("Tip", this.Tip);
/* 79 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 80 */     _js_.marshal("Serial", this.Serial);
/* 81 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 86 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 87 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 88 */     this.Partition = _js_.unmarshal_int("Partition");
/* 89 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 90 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 91 */     this.IsZeroRank = _js_.unmarshal_byte("IsZeroRank");
/* 92 */     this.Type = _js_.unmarshal_byte("Type");
/* 93 */     this.Time = _js_.unmarshal_int("Time");
/* 94 */     this.Tip = _js_.unmarshal_string("Tip");
/* 95 */     this.Source = _js_.unmarshal_int("Source");
/* 96 */     this.Serial = _js_.unmarshal_string("Serial");
/* 97 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\AqDoBanJoinrankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */