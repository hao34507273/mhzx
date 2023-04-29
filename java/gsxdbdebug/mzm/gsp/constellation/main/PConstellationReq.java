/*    */ package mzm.gsp.constellation.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.constellation.confbean.SConstellationConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleConstellation;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class PConstellationReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PConstellationReq(long roleid)
/*    */   {
/* 22 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!OpenInterface.getOpenStatus(227)) {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     if (!ActivityInterface.isActivityOpen(SConstellationConsts.getInstance().Activityid))
/*    */     {
/* 35 */       ConstellationManager.sendNormalResult(this.roleid, 2);
/*    */       
/* 37 */       ConstellationManager.logError("PConstellationReq.processImp@activity not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/*    */ 
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/*    */ 
/* 47 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 49 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 51 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, SConstellationConsts.getInstance().Activityid);
/*    */     
/* 53 */     if (!result.isCanJoin()) {
/* 54 */       ConstellationManager.logError("PConstellationReq.processImp@cannot join activity|roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(result.getReasonValue()) });
/*    */       
/*    */ 
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     RoleConstellation xRoleConstellation = ConstellationManager.getXRoleConstellationIfNotExist(this.roleid);
/*    */     
/*    */ 
/* 63 */     ConstellationManager.sendConstellationRes(this.roleid, xRoleConstellation);
/*    */     
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\PConstellationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */