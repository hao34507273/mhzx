/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*    */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.HomeInfo;
/*    */ 
/*    */ public class PGM_SetCleanliness extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleId;
/*    */   private final int cleanliness;
/*    */   
/*    */   public PGM_SetCleanliness(long gmRoleid, long roleId, int cleanliness)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.roleId = roleId;
/* 19 */     this.cleanliness = cleanliness;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (this.cleanliness < 0)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("家园清洁度参数非法%d", new Object[] { Integer.valueOf(this.cleanliness) }));
/* 29 */       return false;
/*    */     }
/* 31 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/* 32 */     if (homeInfoWrapper == null)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d没有家园", new Object[] { Long.valueOf(this.roleId) }));
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 39 */     if (sHomelandCfg == null)
/*    */     {
/* 41 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d的家园等级错误，找不到配置，设置清洁度失败", new Object[] { Long.valueOf(this.roleId) }));
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 46 */     if (sCourtyardCfg == null)
/*    */     {
/*    */ 
/* 49 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d的庭院等级错误，找不到配置，设置清洁度失败", new Object[] { Long.valueOf(this.roleId) }));
/* 50 */       return false;
/*    */     }
/* 52 */     homeInfoWrapper.getxHomeInfo().setCleanliness(this.cleanliness);
/*    */     
/* 54 */     HomelandManager.sendSSynCleanlinessRes(this.roleId, homeInfoWrapper.getxHomeInfo().getCleanliness(), homeInfoWrapper.getxHomeInfo().getDaycleancount(), 1);
/*    */     
/*    */ 
/* 57 */     HomelandManager.changeHomeCleanlinessIntoWorld(homeInfoWrapper);
/*    */     
/* 59 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d的家园清洁度设置成功，当前清洁度为%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cleanliness) }));
/*    */     
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PGM_SetCleanliness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */