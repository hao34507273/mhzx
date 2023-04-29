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
/*    */ public class DoMonitorBanLoginReq
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
/* 36 */   public byte Type = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public String Msg = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public long StartTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public long EndTime = 0L;
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
/* 69 */     _js_.marshal("Type", Byte.valueOf(this.Type));
/* 70 */     _js_.marshal("Msg", this.Msg);
/* 71 */     _js_.marshal("StartTime", Long.valueOf(this.StartTime));
/* 72 */     _js_.marshal("EndTime", Long.valueOf(this.EndTime));
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
/* 84 */     this.Type = _js_.unmarshal_byte("Type");
/* 85 */     this.Msg = _js_.unmarshal_string("Msg");
/* 86 */     this.StartTime = _js_.unmarshal_long("StartTime");
/* 87 */     this.EndTime = _js_.unmarshal_long("EndTime");
/* 88 */     this.Source = _js_.unmarshal_int("Source");
/* 89 */     this.Serial = _js_.unmarshal_string("Serial");
/* 90 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoMonitorBanLoginReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */