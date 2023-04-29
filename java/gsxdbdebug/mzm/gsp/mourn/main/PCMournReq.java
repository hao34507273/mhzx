/*     */ package mzm.gsp.mourn.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity2.confbean.MournConsts;
/*     */ import mzm.gsp.activity2.confbean.SMournCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.XMTaskInfo;
/*     */ import xbean.XMournInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2mourn;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCMournReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int mournId;
/*     */   
/*     */   public PCMournReq(long roleId, int mournId)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.mournId = mournId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!MournManager.isMournOpen())
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     SMournCfg cfg = SMournCfg.get(this.mournId);
/*  47 */     if (cfg == null)
/*     */     {
/*  49 */       GameServer.logger().error(String.format("[mourn]PCMournReq.processImp@ mournId is not exist!|roleId=%d|mournId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mournId) }));
/*     */       
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userId = RoleInterface.getUserId(this.roleId);
/*  55 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  57 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  59 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, MournConsts.getInstance().activityId);
/*     */     
/*  61 */     if (!res.isCanJoin())
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[mourn]PCMournReq.processImp@ activity is forbid!|roleId=%d|mournId=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mournId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*  66 */       return false;
/*     */     }
/*  68 */     XMournInfo xMournInfo = Role2mourn.get(Long.valueOf(this.roleId));
/*  69 */     if (xMournInfo == null)
/*     */     {
/*  71 */       xMournInfo = Pod.newXMournInfo();
/*  72 */       Role2mourn.insert(Long.valueOf(this.roleId), xMournInfo);
/*     */     }
/*     */     
/*  75 */     XMTaskInfo xmTaskInfo = (XMTaskInfo)xMournInfo.getMourndatas().get(Integer.valueOf(this.mournId));
/*  76 */     if (xmTaskInfo == null)
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[mourn]PCMournReq.processImp@ not own this mourn id!|roleId=%d|mournId=%d|ownMournIds=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mournId), xMournInfo.getMourndatas().keySet().toString() }));
/*     */       
/*     */ 
/*  81 */       return false;
/*     */     }
/*  83 */     int xState = xmTaskInfo.getState();
/*  84 */     if (xState != 1)
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[mourn]PCMournReq.processImp@ can not accept mourn!|roleId=%d|mournId=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mournId), Integer.valueOf(xState) }));
/*     */       
/*     */ 
/*  89 */       return false;
/*     */     }
/*  91 */     int finishCount = 0;
/*  92 */     for (Map.Entry<Integer, XMTaskInfo> entry : xMournInfo.getMourndatas().entrySet())
/*     */     {
/*  94 */       int state = ((XMTaskInfo)entry.getValue()).getState();
/*  95 */       if (state == 3)
/*     */       {
/*  97 */         finishCount++;
/*     */       }
/*     */     }
/*     */     
/* 101 */     if (finishCount >= MournConsts.getInstance().countMax)
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[mourn]PCMournReq.processImp@ already finished all mourn!|roleId=%d|mournId=%d|finishCount=%s|cfgCountMax=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mournId), Integer.valueOf(finishCount), Integer.valueOf(MournConsts.getInstance().countMax) }));
/*     */       
/*     */ 
/*     */ 
/* 107 */       MournManager.sendMournNotice(Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), false, 2, new String[0]);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     Set<Integer> containedGraphIds = MournManager.isHaveMGraph(this.roleId);
/* 112 */     if (containedGraphIds.size() > 0)
/*     */     {
/* 114 */       GameServer.logger().error(String.format("[mourn]PCMournReq.processImp@ can not accept mourn, pls finish mourn task!|roleId=%d|mournId=%d|graphIds", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mournId), containedGraphIds }));
/*     */       
/*     */ 
/*     */ 
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (TaskInterface.isHaveGraphId(this.roleId, MournConsts.getInstance().questionGraphId))
/*     */     {
/* 123 */       GameServer.logger().error(String.format("[mourn]PCMournReq.processImp@ can not accept mourn, pls finish question!|roleId=%d|mournId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mournId) }));
/*     */       
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     TaskInterface.goNextTask(this.roleId, cfg.graphId);
/*     */     
/* 132 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\PCMournReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */