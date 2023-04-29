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
/*    */ public class SMailInfo
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public String RoleId = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public String MailTitle = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int GetTime = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public String TagId = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public int MailId = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 40 */     _js_.marshal("RoleId", this.RoleId);
/* 41 */     _js_.marshal("MailTitle", this.MailTitle);
/* 42 */     _js_.marshal("GetTime", Integer.valueOf(this.GetTime));
/* 43 */     _js_.marshal("TagId", this.TagId);
/* 44 */     _js_.marshal("MailId", Integer.valueOf(this.MailId));
/* 45 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 50 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 51 */     this.MailTitle = _js_.unmarshal_string("MailTitle");
/* 52 */     this.GetTime = _js_.unmarshal_int("GetTime");
/* 53 */     this.TagId = _js_.unmarshal_string("TagId");
/* 54 */     this.MailId = _js_.unmarshal_int("MailId");
/* 55 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\SMailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */