/*    */ package mzm.gsp.qiuqian.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.qiuqian.confbean.SQiuQianCfg;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QiuQianManager
/*    */ {
/* 16 */   static Logger logger = Logger.getLogger("qiuqian");
/* 17 */   static int QIU_QIAN_VAILD_INTERVAL = 30;
/*    */   
/*    */ 
/*    */ 
/*    */   static final int PROBABILITY_SUM = 10000;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isQiuQianSwitchOpenForRole(long roleid, int qiuqianid)
/*    */   {
/* 28 */     if (!OpenInterface.getOpenStatus(214))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     SQiuQianCfg cfg = SQiuQianCfg.get(qiuqianid);
/* 33 */     if (cfg == null)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     if (OpenInterface.isBanPlay(roleid, 214))
/*    */     {
/* 43 */       OpenInterface.sendBanPlayMsg(roleid, 214);
/* 44 */       return false;
/*    */     }
/* 46 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*    */     {
/* 48 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 49 */       return false;
/*    */     }
/* 51 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean checkRoleStatus(long roleid, int status)
/*    */   {
/* 62 */     return RoleStatusInterface.checkCanSetStatus(roleid, status, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\main\QiuQianManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */