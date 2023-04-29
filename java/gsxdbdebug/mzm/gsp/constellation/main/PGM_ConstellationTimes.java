/*    */ package mzm.gsp.constellation.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.constellation.confbean.SConstellationConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleConstellation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ConstellationTimes
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final long roleid;
/*    */   private final int times;
/*    */   
/*    */   public PGM_ConstellationTimes(long gmid, long roleid, int times)
/*    */   {
/* 21 */     this.gmid = gmid;
/* 22 */     this.roleid = roleid;
/* 23 */     this.times = times;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!OpenInterface.getOpenStatus(227)) {
/* 30 */       GmManager.getInstance().sendResultToGM(this.gmid, "活动开关未开启");
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     if (!ActivityInterface.isActivityOpen(SConstellationConsts.getInstance().Activityid)) {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmid, "非活动时间，不能修改设置本命星座次数");
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (this.times > SConstellationConsts.getInstance().ChangeTimes) {
/* 41 */       GmManager.getInstance().sendResultToGM(this.gmid, "次数超过上限，修改本命星座次数上限为" + SConstellationConsts.getInstance().ChangeTimes);
/*    */       
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (this.times < 0) {
/* 47 */       GmManager.getInstance().sendResultToGM(this.gmid, "修改本命星座次数不可小于0");
/* 48 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 52 */     RoleConstellation xRoleConstellation = ConstellationManager.getXRoleConstellationIfNotExist(this.roleid);
/* 53 */     xRoleConstellation.setSet_times(this.times);
/*    */     
/* 55 */     ConstellationManager.sendConstellationRes(this.roleid, xRoleConstellation);
/*    */     
/* 57 */     GmManager.getInstance().sendResultToGM(this.gmid, "修改设置本命星座次数成功！当前次数为" + this.times);
/*    */     
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\PGM_ConstellationTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */