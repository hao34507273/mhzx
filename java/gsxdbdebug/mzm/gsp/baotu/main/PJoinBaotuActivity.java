/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PJoinBaotuActivity
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PJoinBaotuActivity(long roleId)
/*    */   {
/* 26 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!BaotuManager.isBaotuSwitchOpenForRole(this.roleId))
/*    */     {
/* 35 */       String logStr = String.format("[baotu]PJoinBaotuActivity.processImp@baotu activity switch closed|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 37 */       BaoTuItemModule.logger.error(logStr);
/*    */       
/* 39 */       return false;
/*    */     }
/* 41 */     if (!NpcInterface.checkNpcService(BaoTuActivityCfgConsts.getInstance().NPC_ID, BaoTuActivityCfgConsts.getInstance().NPC_SERVICE, this.roleId))
/*    */     {
/*    */ 
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     if (!BaotuManager.isRoleStateCanJoinBaotuActivity(this.roleId))
/*    */     {
/* 49 */       String logStr = String.format("[baotu]PJoinBaotuActivity.processImp@role state can not join baotu activity|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 51 */       BaoTuItemModule.logger.info(logStr);
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     String userid = RoleInterface.getUserId(this.roleId);
/* 56 */     lock(Lockeys.get(User.getTable(), userid));
/* 57 */     Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 59 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID);
/*    */     
/* 61 */     if (!res.isCanJoin())
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     int count = ActivityInterface.getActivityCount(userid, this.roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, true);
/* 66 */     if (count >= BaoTuActivityCfgConsts.getInstance().MAX_AWARD_COUNT)
/*    */     {
/* 68 */       return false;
/*    */     }
/* 70 */     boolean ret = TaskInterface.goNextTask(this.roleId, BaoTuActivityCfgConsts.getInstance().GRAPH_ID);
/* 71 */     if (!ret)
/*    */     {
/* 73 */       String logStr = String.format("[baotu]PJoinBaotuActivity.processImp@baotu activity go next task error|roleid=%d|graphid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(BaoTuActivityCfgConsts.getInstance().GRAPH_ID) });
/*    */       
/*    */ 
/* 76 */       BaoTuItemModule.logger.error(logStr);
/*    */     }
/*    */     
/* 79 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\PJoinBaotuActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */