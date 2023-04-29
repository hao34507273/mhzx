/*    */ package mzm.gsp.online.main;
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*  4 */ public class LoginArgs { private static LoginArgs instance = new LoginArgs();
/*    */   
/*    */   public static LoginArgs getInstance() {
/*  7 */     return instance;
/*    */   }
/*    */   
/* 10 */   int maxPlayerNum = 3000;
/* 11 */   int intervalLoginNum = 100;
/* 12 */   int tryLoginInterval = 1000;
/* 13 */   int notifyLoginInterval = 600;
/* 14 */   boolean accountNumLimit = true;
/* 15 */   int accountNum = 4000;
/* 16 */   int queueCapacity = 1000;
/* 17 */   int maxTaskPerRole = 100;
/* 18 */   int loginProtectMil = 120000;
/* 19 */   int checkLoginProtectSec = 30;
/*    */   
/*    */ 
/*    */   static void init()
/*    */   {
/* 24 */     instance = (LoginArgs)ConfManager.getInstance().getconf("mzm.gsp.online.main.LoginArgs");
/* 25 */     if (instance == null) {
/* 26 */       throw new RuntimeException("找不到登陆程序配置：mzm.gsp.online.main.LoginArgs");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\LoginArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */