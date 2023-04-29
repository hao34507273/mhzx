/*     */ package mzm.gsp.tmpactivity.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCJoinActivity
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCJoinActivity(long roleId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     String userid = RoleInterface.getUserId(this.roleId);
/*  36 */     lock(Lockeys.get(User.getTable(), userid));
/*  37 */     Map<Long, String> roleidToUserid = new HashMap();
/*  38 */     roleidToUserid.put(Long.valueOf(this.roleId), userid);
/*     */     
/*  40 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  42 */     if (!canJoin(roleidToUserid))
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     if (!startActivity(roleidToUserid))
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean canJoin(Map<Long, String> roleidToUserid)
/*     */   {
/*  60 */     if (!TmpActivityManager.isTmpOpened(this.roleId))
/*     */     {
/*  62 */       return false;
/*     */     }
/*  64 */     int count = ActivityInterface.getActivityCount((String)roleidToUserid.get(Long.valueOf(this.roleId)), this.roleId, TmpActivityManager.getActivityId(), false);
/*     */     
/*     */ 
/*  67 */     if (count >= TmpActivityManager.finishCount())
/*     */     {
/*  69 */       TmpActivityManager.sendNormalResult(this.roleId, 1, new String[0]);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), TmpActivityManager.getActivityId()).isCanJoin())
/*     */     {
/*     */ 
/*  76 */       TmpActivityManager.sendNormalResult(this.roleId, 4, new String[0]);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (TaskInterface.isHaveGraphId(this.roleId, TmpActivityManager.getGraphId()))
/*     */     {
/*  82 */       TmpActivityManager.sendNormalResult(this.roleId, 3, new String[0]);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (!TmpActivityManager.nearByNpc(this.roleId, TmpActivityManager.getJoinNpcId()))
/*     */     {
/*  88 */       TmpActivityManager.sendNormalResult(this.roleId, 2, new String[0]);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (!NpcInterface.isNpcServiceAvailable(TmpActivityManager.getServiceId(), this.roleId))
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[tmpactivity]PCJoinActivity.canJoin@ service unAvailable!|roleId=%d|serviceId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(TmpActivityManager.getServiceId()) }));
/*     */       
/*     */ 
/*  97 */       return false;
/*     */     }
/*  99 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean startActivity(Map<Long, String> roleidToUserid)
/*     */   {
/* 105 */     if (!TaskInterface.activeGraph(Long.valueOf(this.roleId), TmpActivityManager.getGraphId()))
/*     */     {
/* 107 */       GameServer.logger().error(String.format("[tmpactivity]PCJoinActivity.startActivity@ open graph error!|roleId=%d|graphId=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(TmpActivityManager.getGraphId()) }));
/*     */       
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tmpactivity\main\PCJoinActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */