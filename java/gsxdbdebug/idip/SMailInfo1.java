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
/*    */ public class SMailInfo1
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public String MailTitle = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public int TagId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public String MailId = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 30 */     _js_.marshal("MailTitle", this.MailTitle);
/* 31 */     _js_.marshal("TagId", Integer.valueOf(this.TagId));
/* 32 */     _js_.marshal("MailId", this.MailId);
/* 33 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 38 */     this.MailTitle = _js_.unmarshal_string("MailTitle");
/* 39 */     this.TagId = _js_.unmarshal_int("TagId");
/* 40 */     this.MailId = _js_.unmarshal_string("MailId");
/* 41 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\SMailInfo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */