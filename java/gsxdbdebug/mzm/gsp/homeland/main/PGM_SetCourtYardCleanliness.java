/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*    */ import xbean.HomeInfo;
/*    */ 
/*    */ public class PGM_SetCourtYardCleanliness extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int num;
/*    */   
/*    */   public PGM_SetCourtYardCleanliness(long roleId, int num)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (this.num < 0)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.roleId, "清洁度设置值小于0");
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.roleId, true);
/* 28 */     if (homeInfoWrapper == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有家园");
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 35 */     int courtYardLevel = xHomeInfo.getCourtyardlevel();
/* 36 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 37 */     if (sCourtyardCfg == null)
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.roleId, "庭院等级配置不存在" + courtYardLevel);
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     int maxCleanliness = sCourtyardCfg.max_cleanliness;
/* 44 */     if (this.num > maxCleanliness)
/*    */     {
/* 46 */       GmManager.getInstance().sendResultToGM(this.roleId, "当前庭院清洁度上限是" + maxCleanliness);
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     xHomeInfo.setCourt_yard_cleanliness(this.num);
/*    */     
/* 52 */     boolean isOwner = this.roleId == homeInfoWrapper.getOwnerRoleId();
/* 53 */     xbean.HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/*    */     
/* 55 */     CourtYardManager.changeCourtYardCleanlinessIntoWorld(xHomeInfo, homeInfoWrapper.getOwnerRoleId());
/*    */     
/* 57 */     HomelandManager.sendSSynHomelandRes(this.roleId, isOwner, xHomeInfo, xHomeOperate);
/*    */     
/* 59 */     GmManager.getInstance().sendResultToGM(this.roleId, "当前庭院清洁度是 " + xHomeInfo.getCourt_yard_cleanliness());
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PGM_SetCourtYardCleanliness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */