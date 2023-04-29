/*    */ package mzm.gsp.seasontask.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCJoinSingleSeasonTaskReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCJoinSingleSeasonTaskReq(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 226, true))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     if (!SummerTaskManager.isSingleOpen(this.roleId)) {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 37 */     String userid = RoleInterface.getUserId(this.roleId);
/* 38 */     lock(Lockeys.get(User.getTable(), userid));
/* 39 */     Map<Long, String> roleidToUserid = new HashMap();
/* 40 */     roleidToUserid.put(Long.valueOf(this.roleId), userid);
/*    */     
/* 42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 44 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), SummerTaskManager.getSingleActivityId()).isCanJoin())
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     if (!SummerTaskManager.canJoinSingleTask(userid, this.roleId)) {
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 54 */     if (roleLevel < SummerTaskManager.getSIngleCanJoinLevel()) {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     if (!MapInterface.isNearByNPC(this.roleId, SummerTaskManager.getSingleNpcId()))
/*    */     {
/* 60 */       SummerTaskManager.sendNormalResult(this.roleId, 5, new String[0]);
/*    */       
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     TaskInterface.goNextTask(this.roleId, SummerTaskManager.getSingleGraph());
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\PCJoinSingleSeasonTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */