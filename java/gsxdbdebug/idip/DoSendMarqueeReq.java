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
/*    */ public class DoSendMarqueeReq
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
/* 31 */   public long BeginTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public long EndTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public String MailTitle = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public String MailContent = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public int Rollfre = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   public int Rollnum = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 61 */   public int Source = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 66 */   public long MarqueeId = 0L;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 70 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 71 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 72 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 73 */     _js_.marshal("BeginTime", Long.valueOf(this.BeginTime));
/* 74 */     _js_.marshal("EndTime", Long.valueOf(this.EndTime));
/* 75 */     _js_.marshal("MailTitle", this.MailTitle);
/* 76 */     _js_.marshal("MailContent", this.MailContent);
/* 77 */     _js_.marshal("Rollfre", Integer.valueOf(this.Rollfre));
/* 78 */     _js_.marshal("Rollnum", Integer.valueOf(this.Rollnum));
/* 79 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 80 */     _js_.marshal("MarqueeId", Long.valueOf(this.MarqueeId));
/* 81 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 86 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 87 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 88 */     this.Partition = _js_.unmarshal_int("Partition");
/* 89 */     this.BeginTime = _js_.unmarshal_long("BeginTime");
/* 90 */     this.EndTime = _js_.unmarshal_long("EndTime");
/* 91 */     this.MailTitle = _js_.unmarshal_string("MailTitle");
/* 92 */     this.MailContent = _js_.unmarshal_string("MailContent");
/* 93 */     this.Rollfre = _js_.unmarshal_int("Rollfre");
/* 94 */     this.Rollnum = _js_.unmarshal_int("Rollnum");
/* 95 */     this.Source = _js_.unmarshal_int("Source");
/* 96 */     this.MarqueeId = _js_.unmarshal_long("MarqueeId");
/* 97 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoSendMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */