/*    */ package mzm.gsp.shanggong.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.shanggong.confbean.SShangGongCfg;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShangGongManager
/*    */ {
/* 16 */   static Logger logger = Logger.getLogger("shanggong");
/* 17 */   static int SHANG_GONG_VAILD_INTERVAL = 30;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isShangGongSwitchOpenForRole(long roleid, int shanggongid)
/*    */   {
/* 27 */     if (!OpenInterface.getOpenStatus(213))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     SShangGongCfg cfg = SShangGongCfg.get(shanggongid);
/* 32 */     if (cfg == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     if (OpenInterface.isBanPlay(roleid, 213))
/*    */     {
/* 42 */       OpenInterface.sendBanPlayMsg(roleid, 213);
/* 43 */       return false;
/*    */     }
/* 45 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*    */     {
/* 47 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 48 */       return false;
/*    */     }
/* 50 */     return true;
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
/* 61 */     return RoleStatusInterface.checkCanSetStatus(roleid, status, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\main\ShangGongManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */