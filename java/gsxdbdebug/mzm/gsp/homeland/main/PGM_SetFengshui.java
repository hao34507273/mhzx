/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.HomeInfo;
/*    */ 
/*    */ public class PGM_SetFengshui extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleId;
/*    */   private final int fenghsui;
/*    */   
/*    */   public PGM_SetFengshui(long gmRoleid, long roleId, int fenghsui)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleId = roleId;
/* 16 */     this.fenghsui = fenghsui;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (this.fenghsui < 0)
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("家园风水参数非法%d", new Object[] { Integer.valueOf(this.fenghsui) }));
/* 26 */       return false;
/*    */     }
/* 28 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/* 29 */     if (homeInfoWrapper == null)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d没有家园", new Object[] { Long.valueOf(this.roleId) }));
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     homeInfoWrapper.getxHomeInfo().setFengshui(this.fenghsui);
/*    */     
/* 38 */     int newFengshui = HomelandManager.getFengShui(homeInfoWrapper.getxHomeInfo());
/*    */     
/* 40 */     HomelandManager.sendSSynFengshuiRes(this.roleId, newFengshui);
/* 41 */     HomelandManager.sendSSynFengshuiRes(homeInfoWrapper.getPartnerRoleId(), newFengshui);
/*    */     
/* 43 */     HomelandManager.changeHomeFengshuiIntoWorld(homeInfoWrapper);
/*    */     
/* 45 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d的家园风水设置成功，当前风水为%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(HomelandManager.getFengShui(homeInfoWrapper.getxHomeInfo())) }));
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PGM_SetFengshui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */