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
/*    */ public class DoUpdateMarqueeReq
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
/* 31 */   public long MarqueeId = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public long BeginTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public long EndTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public String MailTitle = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public String MailContent = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   public int Rollfre = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 61 */   public int Rollnum = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 66 */   public int Source = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 70 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 71 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 72 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 73 */     _js_.marshal("MarqueeId", Long.valueOf(this.MarqueeId));
/* 74 */     _js_.marshal("BeginTime", Long.valueOf(this.BeginTime));
/* 75 */     _js_.marshal("EndTime", Long.valueOf(this.EndTime));
/* 76 */     _js_.marshal("MailTitle", this.MailTitle);
/* 77 */     _js_.marshal("MailContent", this.MailContent);
/* 78 */     _js_.marshal("Rollfre", Integer.valueOf(this.Rollfre));
/* 79 */     _js_.marshal("Rollnum", Integer.valueOf(this.Rollnum));
/* 80 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 81 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 86 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 87 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 88 */     this.Partition = _js_.unmarshal_int("Partition");
/* 89 */     this.MarqueeId = _js_.unmarshal_long("MarqueeId");
/* 90 */     this.BeginTime = _js_.unmarshal_long("BeginTime");
/* 91 */     this.EndTime = _js_.unmarshal_long("EndTime");
/* 92 */     this.MailTitle = _js_.unmarshal_string("MailTitle");
/* 93 */     this.MailContent = _js_.unmarshal_string("MailContent");
/* 94 */     this.Rollfre = _js_.unmarshal_int("Rollfre");
/* 95 */     this.Rollnum = _js_.unmarshal_int("Rollnum");
/* 96 */     this.Source = _js_.unmarshal_int("Source");
/* 97 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoUpdateMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */