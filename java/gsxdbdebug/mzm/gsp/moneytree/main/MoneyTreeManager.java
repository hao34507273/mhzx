/*    */ package mzm.gsp.moneytree.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MoneyTreeManager
/*    */ {
/* 16 */   static volatile boolean postInitFlag = false;
/* 17 */   static Logger logger = Logger.getLogger("moneytree");
/*    */   
/*    */   static void init()
/*    */   {
/* 21 */     ActivityInterface.registerActivityByLogicType(74, new MoneyTreeActivityHandler());
/*    */   }
/*    */   
/*    */   static void postInit()
/*    */   {
/* 26 */     postInitFlag = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isMoneyTreeSwitchOpen()
/*    */   {
/* 36 */     if (!OpenInterface.getOpenStatus(232))
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isMoneyTreeSwitchOpenForRole(long roleid)
/*    */   {
/* 51 */     if (!OpenInterface.getOpenStatus(232))
/*    */     {
/* 53 */       return false;
/*    */     }
/* 55 */     if (OpenInterface.isBanPlay(roleid, 232))
/*    */     {
/* 57 */       OpenInterface.sendBanPlayMsg(roleid, 232);
/* 58 */       return false;
/*    */     }
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\moneytree\main\MoneyTreeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */