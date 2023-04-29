/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SReceiveShiTuTaskRep;
/*     */ import mzm.gsp.shitu.confbean.SShiTuTaskConsts;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ShiTuTask;
/*     */ import xbean.ShiTuTaskInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.Role2shitutask;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCReceiveShiTuTaskReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int graphId;
/*     */   private final int taskId;
/*     */   
/*     */   public PCReceiveShiTuTaskReq(long roleId, int graphId, int taskId)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.graphId = graphId;
/*  36 */     this.taskId = taskId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!ShiTuManager.isShiTuTaskOpen(this.roleId))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     String apprenticeUserId = RoleInterface.getUserId(this.roleId);
/*  49 */     if (apprenticeUserId == null)
/*     */     {
/*  51 */       onFailed(5);
/*  52 */       return false;
/*     */     }
/*  54 */     lock(Lockeys.get(User.getTable(), apprenticeUserId));
/*     */     
/*     */ 
/*  57 */     ShiTuTaskInfo xShiTuTaskInfo = Role2shitutask.get(Long.valueOf(this.roleId));
/*  58 */     if (xShiTuTaskInfo == null)
/*     */     {
/*  60 */       onFailed(6);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1641, true, true))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     if ((xShiTuTaskInfo.getPublish_state() != 1) && (xShiTuTaskInfo.getPublish_state() != 2))
/*     */     {
/*     */ 
/*  73 */       onFailed(7);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     ShiTuTask xShiTuTask = (ShiTuTask)xShiTuTaskInfo.getTask_infos().get(Integer.valueOf(this.graphId));
/*     */     
/*     */ 
/*  80 */     if (xShiTuTask == null)
/*     */     {
/*  82 */       onFailed(2);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (xShiTuTask.getTask_id() != this.taskId)
/*     */     {
/*  88 */       onFailed(2);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (xShiTuTask.getTask_state() != 0)
/*     */     {
/*  94 */       onFailed(2);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     if ((TeamInterface.isRoleInTeam(this.roleId, true)) && (TeamInterface.isTeamMemberNormal(this.roleId)))
/*     */     {
/* 101 */       onFailed(3);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     long masterId = ShiTuManager.getMasterId(Role2shitu.get(Long.valueOf(this.roleId)));
/* 107 */     if (masterId <= 0L)
/*     */     {
/* 109 */       onFailed(2);
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     if (xShiTuTaskInfo.getShitu_task_count() >= SShiTuTaskConsts.getInstance().RECEIVE_MAX_TIMES)
/*     */     {
/* 116 */       xShiTuTaskInfo.setPublish_state(4);
/* 117 */       onFailed(4);
/*     */       
/* 119 */       OnlineManager.getInstance().sendMulti(ShiTuManager.getAndCheckResetShiTuTaskInfo(this.roleId), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(masterId) }));
/*     */       
/*     */ 
/* 122 */       ShiTuTLogManager.tlogShiTuTaskApprentice(this.roleId, apprenticeUserId, xShiTuTaskInfo);
/* 123 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 127 */     if (RoleInterface.getLevel(this.roleId) > SShiTuTaskConsts.getInstance().RECEIVE_MAX_LEVEL)
/*     */     {
/* 129 */       xShiTuTaskInfo.setPublish_state(3);
/* 130 */       onFailed(8);
/*     */       
/* 132 */       OnlineManager.getInstance().sendMulti(ShiTuManager.getAndCheckResetShiTuTaskInfo(this.roleId), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(masterId) }));
/*     */       
/*     */ 
/* 135 */       ShiTuTLogManager.tlogShiTuTaskApprentice(this.roleId, apprenticeUserId, xShiTuTaskInfo);
/* 136 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 140 */     if (xShiTuTaskInfo.getPublish_state() != 2)
/*     */     {
/*     */ 
/* 143 */       xShiTuTaskInfo.setShitu_task_count(xShiTuTaskInfo.getShitu_task_count() + 1);
/*     */       
/* 145 */       xShiTuTaskInfo.setPublish_state(2);
/*     */       
/* 147 */       OnlineManager.getInstance().sendMulti(ShiTuManager.getAndCheckResetShiTuTaskInfo(this.roleId), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(masterId) }));
/*     */       
/*     */ 
/* 150 */       ShiTuTLogManager.tlogShiTuTaskApprentice(this.roleId, apprenticeUserId, xShiTuTaskInfo);
/*     */     }
/*     */     
/*     */ 
/* 154 */     TaskInterface.acceptGraphXTask(this.roleId, this.graphId, this.taskId);
/*     */     
/*     */ 
/* 157 */     SReceiveShiTuTaskRep rsp = new SReceiveShiTuTaskRep();
/* 158 */     rsp.result = 1;
/* 159 */     OnlineManager.getInstance().send(this.roleId, rsp);
/*     */     
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int error_code)
/*     */   {
/* 166 */     onFailed(error_code, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int error_code, Map<String, Object> extraParams)
/*     */   {
/* 177 */     SReceiveShiTuTaskRep rsp = new SReceiveShiTuTaskRep();
/* 178 */     rsp.result = error_code;
/* 179 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 181 */     StringBuffer logBuilder = new StringBuffer();
/* 182 */     logBuilder.append("[shitu]PCReceiveShiTuTaskReq.onFailed@processImp() failed");
/* 183 */     logBuilder.append('|').append("roleId=").append(this.roleId);
/* 184 */     logBuilder.append('|').append("graphId=").append(this.graphId);
/* 185 */     logBuilder.append('|').append("taskId=").append(this.taskId);
/* 186 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 188 */     if (extraParams != null)
/*     */     {
/* 190 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 192 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 196 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCReceiveShiTuTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */