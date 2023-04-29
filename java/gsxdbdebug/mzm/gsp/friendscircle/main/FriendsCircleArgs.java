/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ public class FriendsCircleArgs
/*    */ {
/*    */   private static volatile FriendsCircleArgs instance;
/*    */   String privateKey;
/*    */   
/*    */   static FriendsCircleArgs getInstance() {
/* 11 */     if (instance == null)
/*    */     {
/* 13 */       synchronized (FriendsCircleArgs.class)
/*    */       {
/* 15 */         if (instance == null)
/*    */         {
/* 17 */           init();
/*    */         }
/*    */       }
/*    */     }
/* 21 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void init()
/*    */   {
/* 28 */     instance = (FriendsCircleArgs)ConfManager.getInstance().getconf("mzm.gsp.friendscircle.main.FriendsCircleArgs");
/* 29 */     if (instance == null)
/*    */     {
/* 31 */       throw new RuntimeException("FriendsCircleArgs文件不存在！");
/*    */     }
/*    */     
/* 34 */     String value = System.getProperty("com.zulong.mhzx.sspkey");
/* 35 */     if ((value != null) && (!value.isEmpty()))
/*    */     {
/* 37 */       instance.privateKey = value;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\FriendsCircleArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */