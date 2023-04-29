/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/*    */ 
/*    */ public class AppInfo
/*    */ {
/*    */   @XStreamAsAttribute
/*    */   String appid;
/*    */   @XStreamAsAttribute
/*    */   String appkey;
/*    */   @XStreamAsAttribute
/*    */   String channel;
/*    */   
/*    */   public String getAppId()
/*    */   {
/* 16 */     return this.appid;
/*    */   }
/*    */   
/*    */   public String getAppKey()
/*    */   {
/* 21 */     return this.appkey;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */