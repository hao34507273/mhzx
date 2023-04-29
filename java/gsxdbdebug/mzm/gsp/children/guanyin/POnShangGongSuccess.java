/*    */ package mzm.gsp.children.guanyin;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.children.confbean.GuanYinConsts;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shanggong.event.ShangGongSuccessArg;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnShangGongSuccess extends mzm.gsp.shanggong.event.ShangGongSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long roleid = ((ShangGongSuccessArg)this.arg).roleid;
/* 19 */     int shanggongid = ((ShangGongSuccessArg)this.arg).shanggongid;
/* 20 */     int addPoint = ((ShangGongSuccessArg)this.arg).addPoint;
/*    */     
/* 22 */     if (shanggongid != GuanYinConsts.getInstance().SHANGGONG_ID)
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     long marriageid = MarriageInterface.getMarriedId(roleid, false);
/* 29 */     long partnerid = MarriageInterface.getMarriedRoleid(roleid);
/*    */     
/* 31 */     String userid = RoleInterface.getUserId(roleid);
/* 32 */     if (partnerid < 0L)
/*    */     {
/*    */ 
/* 35 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */       
/* 37 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     }
/*    */     else
/*    */     {
/* 41 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*    */       
/* 43 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*    */       
/* 45 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(partnerid) }));
/*    */       
/* 47 */       lock(xtable.Marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(marriageid) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 52 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, GuanYinConsts.getInstance().SHANGGONG_ACTIVITY_CFG_ID);
/*    */     
/* 54 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/*    */ 
/* 57 */       return false;
/*    */     }
/* 59 */     ActivityInterface.addActivityCount(userid, roleid, GuanYinConsts.getInstance().SHANGGONG_ACTIVITY_CFG_ID);
/*    */     
/*    */ 
/*    */ 
/* 63 */     ChildrenInterface.addSignalWayChildScore(roleid, addPoint);
/*    */     
/* 65 */     StringBuilder sb = new StringBuilder();
/* 66 */     sb.append(String.format("[guanyin]POnShangGongSuccess.processImp@shang gong success process success|roleid=%d|shanggongid=%d|add_point=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(shanggongid), Integer.valueOf(addPoint) }));
/*    */     
/*    */ 
/* 69 */     GuanYinManager.logger.info(sb.toString());
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\guanyin\POnShangGongSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */