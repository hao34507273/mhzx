/*    */ package mzm.gsp.qingyunzhi.main;
/*    */ 
/*    */ import mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg;
/*    */ import xbean.QingData;
/*    */ import xtable.Role2qingyun;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QingInterface
/*    */ {
/*    */   public static boolean isPassed(long roleId, int qingYunZhiCfgid, boolean remainRoleLock)
/*    */   {
/* 23 */     SQingYunZhiCfg cfg = SQingYunZhiCfg.get(qingYunZhiCfgid);
/* 24 */     if (cfg == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     return isPassed(roleId, cfg.challengeType, cfg.chapterNum, cfg.sectionNum, remainRoleLock);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isPassed(long roleId, int type, int chapter, int section, boolean remainRoleLock)
/*    */   {
/* 52 */     QingData xQingData = null;
/* 53 */     if (remainRoleLock)
/*    */     {
/* 55 */       xQingData = Role2qingyun.get(Long.valueOf(roleId));
/*    */     }
/*    */     else
/*    */     {
/* 59 */       xQingData = Role2qingyun.select(Long.valueOf(roleId));
/*    */     }
/* 61 */     if (xQingData == null)
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     return RoleQingManager.isPassed(roleId, type, xQingData, chapter, section);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\QingInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */