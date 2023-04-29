/*    */ package mzm.gsp.bulletin.main;
/*    */ 
/*    */ import mzm.gsp.bulletin.SBulletinInfo;
/*    */ import mzm.gsp.bulletin.SSystemInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BulletinInterface
/*    */ {
/*    */   public static void sendBulletin(SBulletinInfo bulletinInfo)
/*    */   {
/* 17 */     OnlineManager.getInstance().sendAll(bulletinInfo);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void sendNotice(String info)
/*    */   {
/* 27 */     SSystemInfo s = new SSystemInfo(info);
/* 28 */     OnlineManager.getInstance().sendAllAtOnce(s);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bulletin\main\BulletinInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */