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
/*    */ public class MarqueeInfo
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public long MarqueeId = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public long BeginTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public long EndTime = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public String MailTitle = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public String MailContent = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public int Rollfre = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public int Rollnum = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 50 */     _js_.marshal("MarqueeId", Long.valueOf(this.MarqueeId));
/* 51 */     _js_.marshal("BeginTime", Long.valueOf(this.BeginTime));
/* 52 */     _js_.marshal("EndTime", Long.valueOf(this.EndTime));
/* 53 */     _js_.marshal("MailTitle", this.MailTitle);
/* 54 */     _js_.marshal("MailContent", this.MailContent);
/* 55 */     _js_.marshal("Rollfre", Integer.valueOf(this.Rollfre));
/* 56 */     _js_.marshal("Rollnum", Integer.valueOf(this.Rollnum));
/* 57 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 62 */     this.MarqueeId = _js_.unmarshal_long("MarqueeId");
/* 63 */     this.BeginTime = _js_.unmarshal_long("BeginTime");
/* 64 */     this.EndTime = _js_.unmarshal_long("EndTime");
/* 65 */     this.MailTitle = _js_.unmarshal_string("MailTitle");
/* 66 */     this.MailContent = _js_.unmarshal_string("MailContent");
/* 67 */     this.Rollfre = _js_.unmarshal_int("Rollfre");
/* 68 */     this.Rollnum = _js_.unmarshal_int("Rollnum");
/* 69 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\MarqueeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */