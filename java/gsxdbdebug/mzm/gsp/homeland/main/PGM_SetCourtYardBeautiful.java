/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*    */ import xbean.HomeInfo;
/*    */ import xbean.HomeOperate;
/*    */ 
/*    */ public class PGM_SetCourtYardBeautiful extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int num;
/*    */   
/*    */   public PGM_SetCourtYardBeautiful(long roleId, int num)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.num = num;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (this.num < 0)
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.roleId, "美观度设置值小于0");
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.roleId, true);
/* 30 */     if (homeInfoWrapper == null)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有家园");
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 37 */     int courtYardLevel = xHomeInfo.getCourtyardlevel();
/* 38 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 39 */     if (sCourtyardCfg == null)
/*    */     {
/* 41 */       GmManager.getInstance().sendResultToGM(this.roleId, "庭院等级配置不存在" + courtYardLevel);
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     int maxBeautifual = sCourtyardCfg.max_beautifual;
/* 46 */     if (this.num > maxBeautifual)
/*    */     {
/* 48 */       GmManager.getInstance().sendResultToGM(this.roleId, "当前庭院美观度上限是" + maxBeautifual);
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     xHomeInfo.setCourt_yard_beautiful(this.num);
/*    */     
/* 54 */     boolean isOwner = this.roleId == homeInfoWrapper.getOwnerRoleId();
/* 55 */     HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/*    */     
/* 57 */     CourtYardManager.changeCourtYardBeautifulIntoWorld(xHomeInfo, homeInfoWrapper.getOwnerRoleId());
/*    */     
/* 59 */     HomelandManager.sendSSynHomelandRes(this.roleId, isOwner, xHomeInfo, xHomeOperate);
/*    */     
/* 61 */     GmManager.getInstance().sendResultToGM(this.roleId, "当前庭院美观度是 " + xHomeInfo.getCourt_yard_beautiful());
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PGM_SetCourtYardBeautiful.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */