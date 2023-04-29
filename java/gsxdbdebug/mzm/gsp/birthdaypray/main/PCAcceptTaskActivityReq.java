/*    */ package mzm.gsp.birthdaypray.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.birthdaypray.SAcceptTaskActivitySuccess;
/*    */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg;
/*    */ import mzm.gsp.nationalholiday.confbean.STaskActivityId2ActivityIdCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.singletask.main.PAcceptSingleTask;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCAcceptTaskActivityReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int taskActivityId;
/*    */   
/*    */   public PCAcceptTaskActivityReq(long roleId, int taskActivityId)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.taskActivityId = taskActivityId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     STaskActivityId2ActivityIdCfg sTaskActivityId2ActivityIdCfg = STaskActivityId2ActivityIdCfg.get(this.taskActivityId);
/* 35 */     if (sTaskActivityId2ActivityIdCfg == null)
/*    */     {
/* 37 */       BirthdayPrayManager.logger.error(String.format("[birthdaypray]PCAcceptTaskActivityReq.processImp@accept task activity fail sTaskActivityId2ActivityIdCfg is null|roleId=%d|taskActivityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.taskActivityId) }));
/*    */       
/*    */ 
/* 40 */       return false;
/*    */     }
/* 42 */     SBirthdayPrayCfg sBirthdayPrayCfg = SBirthdayPrayCfg.get(sTaskActivityId2ActivityIdCfg.activityId);
/* 43 */     if (sBirthdayPrayCfg == null)
/*    */     {
/* 45 */       BirthdayPrayManager.logger.error(String.format("[birthdaypray]PCAcceptTaskActivityReq.processImp@accept task activity fail sBirthdayPrayCfg is null|roleId=%d|taskActivityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.taskActivityId) }));
/*    */       
/*    */ 
/* 48 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 53 */     if (!BirthdayPrayManager.isBirthdayPraySwitchOpen(this.roleId, sBirthdayPrayCfg.openId))
/*    */     {
/* 55 */       BirthdayPrayManager.logger.error(String.format("[birthdaypray]PCAcceptTaskActivityReq.processImp@accept task activity fail switch not open|roleId=%d|taskActivityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.taskActivityId) }));
/*    */       
/*    */ 
/* 58 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 65 */     String userId = RoleInterface.getUserId(this.roleId);
/* 66 */     int count = ActivityInterface.getActivityCount(userId, this.roleId, sTaskActivityId2ActivityIdCfg.activityId, false);
/* 67 */     if (count > 0)
/*    */     {
/* 69 */       BirthdayPrayManager.logger.error(String.format("[birthdaypray]PCAcceptTaskActivityReq.processImp@accept task activity fail count error|roleId=%d|taskActivityId=%d|count=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.taskActivityId), Integer.valueOf(count) }));
/*    */       
/*    */ 
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     boolean result = new PAcceptSingleTask(this.roleId, this.taskActivityId).call();
/* 76 */     if (!result)
/*    */     {
/* 78 */       return false;
/*    */     }
/*    */     
/* 81 */     SAcceptTaskActivitySuccess protocol = new SAcceptTaskActivitySuccess();
/* 82 */     protocol.activity_cfg_id = this.taskActivityId;
/* 83 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*    */     
/* 85 */     BirthdayPrayManager.logger.info(String.format("[birthdaypray]PCAcceptTaskActivityReq.processImp@accept task activity success|roleId=%d|taskActivityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.taskActivityId) }));
/*    */     
/*    */ 
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\PCAcceptTaskActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */