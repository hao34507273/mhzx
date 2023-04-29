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
/*    */ public class AqDoMaskchatUsrReq
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
/* 46 */   public byte IsClear = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public String MaskReason = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   public int Source = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 61 */   public String Serial = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 65 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 66 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 67 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 68 */     _js_.marshal("OpenId", this.OpenId);
/* 69 */     _js_.marshal("RoleId", this.RoleId);
/* 70 */     _js_.marshal("Time", Integer.valueOf(this.Time));
/* 71 */     _js_.marshal("IsClear", Byte.valueOf(this.IsClear));
/* 72 */     _js_.marshal("MaskReason", this.MaskReason);
/* 73 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 74 */     _js_.marshal("Serial", this.Serial);
/* 75 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 80 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 81 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 82 */     this.Partition = _js_.unmarshal_int("Partition");
/* 83 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 84 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 85 */     this.Time = _js_.unmarshal_int("Time");
/* 86 */     this.IsClear = _js_.unmarshal_byte("IsClear");
/* 87 */     this.MaskReason = _js_.unmarshal_string("MaskReason");
/* 88 */     this.Source = _js_.unmarshal_int("Source");
/* 89 */     this.Serial = _js_.unmarshal_string("Serial");
/* 90 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\AqDoMaskchatUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */