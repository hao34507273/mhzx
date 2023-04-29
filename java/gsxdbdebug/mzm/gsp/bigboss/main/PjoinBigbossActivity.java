/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BigBoss;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PjoinBigbossActivity extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PjoinBigbossActivity(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!BigbossManager.isRoleStateCanJoinBigbossActivity(this.roleid))
/*    */     {
/* 28 */       String logStr = String.format("[bigboss]PjoinBigbossActivity.processImp@role state can not join bigboss activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 30 */       BigbossManager.logger.info(logStr);
/* 31 */       return false;
/*    */     }
/* 33 */     if (!BigbossManager.isBigBossSwitchOpenForRole(this.roleid))
/*    */     {
/* 35 */       String logstr = String.format("[bigboss]PjoinBigbossActivity.processImp@Bigboss switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 37 */       BigbossManager.logger.info(logstr);
/*    */       
/* 39 */       return false;
/*    */     }
/* 41 */     long starttime = BigbossManager.getActivityStarttime();
/* 42 */     if (starttime == 0L)
/*    */     {
/* 44 */       BigbossManager.sendErrorInfo(this.roleid, 5);
/* 45 */       return false;
/*    */     }
/* 47 */     long endtime = BigbossManager.getActivityEndTime();
/* 48 */     if (endtime == 0L)
/*    */     {
/* 50 */       BigbossManager.sendErrorInfo(this.roleid, 5);
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     String userId = RoleInterface.getUserId(this.roleid);
/* 55 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 56 */     Lockeys.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 58 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleid, SBigbossCfgConsts.getInstance().ACTIVITYID);
/*    */     
/*    */ 
/* 61 */     if (!joinResult.isCanJoin())
/*    */     {
/* 63 */       if (joinResult.isActivityNotOpen())
/*    */       {
/* 65 */         BigbossManager.sendErrorInfo(this.roleid, 5);
/*    */       }
/*    */       
/* 68 */       if (joinResult.isRoleLevelWrong())
/*    */       {
/* 70 */         BigbossManager.sendErrorInfo(this.roleid, 3);
/*    */       }
/*    */       
/* 73 */       if (joinResult.isSingleRoleTeam())
/*    */       {
/* 75 */         BigbossManager.sendErrorInfo(this.roleid, 4);
/*    */       }
/*    */       
/*    */ 
/* 79 */       return false;
/*    */     }
/*    */     
/* 82 */     int monstersortid = BigbossManager.getBigbossActivityMonsterSordId();
/* 83 */     BigBoss xBigBoss = BigbossManager.getBigboss(this.roleid, true);
/* 84 */     if (xBigBoss == null)
/*    */     {
/* 86 */       return false;
/*    */     }
/* 88 */     BigbossManager.synBigbossActivityData(this.roleid, RoleInterface.getOccupationId(this.roleid), xBigBoss, endtime, monstersortid, starttime);
/*    */     
/*    */ 
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PjoinBigbossActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */