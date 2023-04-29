/*    */ package mzm.gsp.constellation.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.constellation.confbean.SConstellationConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.Constellation;
/*    */ import xbean.RoleConstellation;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 24 */     if (!OpenInterface.getOpenStatus(227)) {
/* 25 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 29 */     if (!ActivityInterface.isActivityOpen(SConstellationConsts.getInstance().Activityid)) {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 36 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 38 */     RoleConstellation xRoleConstellation = ConstellationManager.getXRoleConstellationIfNotExist(roleid);
/*    */     
/* 40 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, SConstellationConsts.getInstance().Activityid);
/*    */     
/* 42 */     if (!result.isCanJoin()) {
/* 43 */       ConstellationManager.logError("POnRoleLogin.processImp@cannot join constellation activity|roleid=%d|reason=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(result.getReasonValue()) });
/*    */       
/*    */ 
/* 46 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 50 */     Constellation xConstellation = ConstellationManager.getXConstellationIfNotExist();
/* 51 */     if (xConstellation.getIndex() < 0)
/*    */     {
/* 53 */       long endMillis = StartCountDownSession.getEndMillis();
/*    */       
/* 55 */       ConstellationManager.sendStageBrd(roleid, 0, endMillis);
/*    */     }
/* 57 */     else if (xConstellation.getIndex() < xConstellation.getCards().size())
/*    */     {
/* 59 */       long endMillis = CardSession.getEndMillis();
/*    */       
/* 61 */       ConstellationManager.sendStageBrd(roleid, 1, endMillis);
/*    */       
/* 63 */       ConstellationManager.syncConstellationCards(xConstellation, roleid, xRoleConstellation);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 68 */       ConstellationManager.sendStageBrd(roleid, 2, 0L);
/*    */     }
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */