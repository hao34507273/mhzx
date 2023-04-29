/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class PCJoinGangTaskReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCJoinGangTaskReq(long roleId)
/*    */   {
/* 23 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!GangTaskManager.isFactionTaskOpen(this.roleId))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     String userid = RoleInterface.getUserId(this.roleId);
/* 37 */     lock(Lockeys.get(User.getTable(), userid));
/* 38 */     Map<Long, String> roleidToUserid = new HashMap();
/* 39 */     roleidToUserid.put(Long.valueOf(this.roleId), userid);
/*    */     
/*    */ 
/* 42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 44 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 209, true))
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     if (!GangTaskManager.canJoinActivity(roleidToUserid, this.roleId))
/*    */     {
/*    */ 
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     if (!GangTaskManager.isRoleInGang(this.roleId))
/*    */     {
/* 57 */       GangTaskManager.sendNormalResult(this.roleId, 1, new String[0]);
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 62 */     if (roleLevel < GangTaskManager.getCanJoinLevel())
/*    */     {
/*    */ 
/* 65 */       return false;
/*    */     }
/*    */     
/* 68 */     if (!MapInterface.isNearByNPC(this.roleId, GangTaskManager.getGangTaskNpcId()))
/*    */     {
/* 70 */       GangTaskManager.sendNormalResult(this.roleId, 3, new String[0]);
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     TaskInterface.goNextTask(this.roleId, GangTaskManager.getGangTaskGraph());
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\PCJoinGangTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */