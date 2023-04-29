/*    */ package mzm.gsp.children.guanyin;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.children.confbean.GuanYinConsts;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.qiuqian.event.QiuQianSuccessArg;
/*    */ import mzm.gsp.qiuqian.event.QiuQianSuccessProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.Marriage;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnQiuQianSuccess
/*    */   extends QiuQianSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     long roleid = ((QiuQianSuccessArg)this.arg).roleid;
/* 23 */     int qiuqianid = ((QiuQianSuccessArg)this.arg).qiuqianid;
/* 24 */     int addPoint = ((QiuQianSuccessArg)this.arg).addPoint;
/*    */     
/* 26 */     if (qiuqianid != GuanYinConsts.getInstance().QIUQIAN_ID)
/*    */     {
/*    */ 
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     long marriageid = MarriageInterface.getMarriedId(roleid, false);
/* 34 */     long partnerid = MarriageInterface.getMarriedRoleid(roleid);
/*    */     
/* 36 */     String userid = RoleInterface.getUserId(roleid);
/* 37 */     if (partnerid < 0L)
/*    */     {
/*    */ 
/* 40 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */       
/* 42 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     }
/*    */     else
/*    */     {
/* 46 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*    */       
/* 48 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*    */       
/* 50 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(partnerid) }));
/*    */       
/* 52 */       lock(Marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(marriageid) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 57 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, GuanYinConsts.getInstance().QIUQIAN_ACTIVITY_CFG_ID);
/*    */     
/* 59 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/*    */ 
/* 62 */       return false;
/*    */     }
/* 64 */     ActivityInterface.addActivityCount(userid, roleid, GuanYinConsts.getInstance().QIUQIAN_ACTIVITY_CFG_ID);
/*    */     
/*    */ 
/*    */ 
/* 68 */     ChildrenInterface.addSignalWayChildScore(roleid, addPoint);
/*    */     
/* 70 */     StringBuilder sb = new StringBuilder();
/* 71 */     sb.append(String.format("[guanyin]POnQiuQianSuccess.processImp@qiu qian success process success|roleid=%d|qiuqianid=%d|add_point=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(qiuqianid), Integer.valueOf(addPoint) }));
/*    */     
/*    */ 
/* 74 */     GuanYinManager.logger.info(sb.toString());
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\guanyin\POnQiuQianSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */