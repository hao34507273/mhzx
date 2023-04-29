/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SReceiveMasterTaskRewardRep;
/*     */ import mzm.gsp.shitu.SSynShiTuTaskStatus;
/*     */ import mzm.gsp.shitu.confbean.SShiTuTaskCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTask;
/*     */ import xbean.ShiTuTaskInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2properties;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.Role2shitutask;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCReceiveMasterTaskRewardReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long masterRoleId;
/*     */   private final long apprenticeRoleId;
/*     */   private final int graphId;
/*     */   private final int taskId;
/*     */   
/*     */   public PCReceiveMasterTaskRewardReq(long masterRoleId, long apprenticeRoleId, int graphId, int taskId)
/*     */   {
/*  41 */     this.masterRoleId = masterRoleId;
/*  42 */     this.apprenticeRoleId = apprenticeRoleId;
/*  43 */     this.graphId = graphId;
/*  44 */     this.taskId = taskId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!ShiTuManager.isShiTuTaskOpen(this.masterRoleId))
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (!RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1641, true))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     String masterUserId = RoleInterface.getUserId(this.masterRoleId);
/*  60 */     String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/*  61 */     if ((masterUserId == null) || (apprenticeUserId == null))
/*     */     {
/*  63 */       onFailed(4);
/*  64 */       return false;
/*     */     }
/*  66 */     super.lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*     */ 
/*  69 */     super.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*     */ 
/*  72 */     if (ItemInterface.isBagFull(this.masterRoleId, 340600000, true))
/*     */     {
/*  74 */       onFailed(8);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId));
/*  79 */     if (xApprenticeShiTuInfo == null)
/*     */     {
/*  81 */       onFailed(3);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/*  86 */     if (xApprenticeInfo.getMasterroleid() != this.masterRoleId)
/*     */     {
/*  88 */       onFailed(3);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(this.masterRoleId));
/*  93 */     if (xMasterShiTuInfo == null)
/*     */     {
/*  95 */       onFailed(3);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     MasterInfo xMasterInfo = xMasterShiTuInfo.getMasterinfo();
/* 101 */     Map<Long, ShiTuTimeInfo> xNowMasterApprenticeInfoMap = xMasterInfo.getApprentice_now();
/* 102 */     ShiTuTimeInfo xMasterTimeInfo = (ShiTuTimeInfo)xNowMasterApprenticeInfoMap.get(Long.valueOf(this.apprenticeRoleId));
/*     */     
/* 104 */     if (xMasterTimeInfo == null)
/*     */     {
/* 106 */       onFailed(3);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     ShiTuTaskInfo xShiTuTaskInfo = Role2shitutask.get(Long.valueOf(this.apprenticeRoleId));
/* 112 */     if (xShiTuTaskInfo == null)
/*     */     {
/* 114 */       onFailed(5);
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     if (xShiTuTaskInfo.getPublish_state() != 2)
/*     */     {
/* 121 */       onFailed(6);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     ShiTuTask xShituTask = (ShiTuTask)xShiTuTaskInfo.getTask_infos().get(Integer.valueOf(this.graphId));
/* 126 */     if ((xShituTask == null) || (xShituTask.getTask_id() != this.taskId))
/*     */     {
/* 128 */       onFailed(2);
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     if (xShituTask.getTask_state() != 2)
/*     */     {
/* 135 */       onFailed(6);
/* 136 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 140 */     xShituTask.setTask_state(4);
/*     */     
/*     */ 
/* 143 */     SShiTuTaskCfg sShiTuTaskCfg = SShiTuTaskCfg.get(this.taskId);
/* 144 */     if ((sShiTuTaskCfg == null) || (sShiTuTaskCfg.master_reward_id <= 0))
/*     */     {
/* 146 */       onFailed(2);
/* 147 */       return false;
/*     */     }
/* 149 */     AwardReason reason = new AwardReason(LogReason.SHI_TU_TASK_MASTER_AWARD);
/*     */     
/* 151 */     AwardModel awardModel = null;
/* 152 */     if (sShiTuTaskCfg.master_reward_type == 2)
/*     */     {
/* 154 */       awardModel = AwardInterface.awardFixAward(sShiTuTaskCfg.master_reward_id, masterUserId, this.masterRoleId, false, true, reason);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 159 */       awardModel = AwardInterface.award(sShiTuTaskCfg.master_reward_id, masterUserId, this.masterRoleId, false, true, reason);
/*     */     }
/*     */     
/* 162 */     if (awardModel == null)
/*     */     {
/* 164 */       onFailed(7);
/* 165 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 169 */     SReceiveMasterTaskRewardRep rsp = new SReceiveMasterTaskRewardRep();
/* 170 */     rsp.result = 1;
/* 171 */     OnlineManager.getInstance().send(this.masterRoleId, rsp);
/*     */     
/*     */ 
/* 174 */     SSynShiTuTaskStatus pro = new SSynShiTuTaskStatus();
/* 175 */     pro.role_id = this.apprenticeRoleId;
/* 176 */     pro.graph_id = this.graphId;
/* 177 */     pro.task_id = this.taskId;
/* 178 */     pro.task_state = xShituTask.getTask_state();
/* 179 */     OnlineManager.getInstance().send(this.masterRoleId, pro);
/*     */     
/* 181 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int error_code)
/*     */   {
/* 186 */     onFailed(error_code, null);
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
/* 197 */     SReceiveMasterTaskRewardRep rsp = new SReceiveMasterTaskRewardRep();
/* 198 */     rsp.result = error_code;
/* 199 */     OnlineManager.getInstance().sendAtOnce(this.masterRoleId, rsp);
/*     */     
/* 201 */     StringBuffer logBuilder = new StringBuffer();
/* 202 */     logBuilder.append("[shitu]PCReceiveMasterTaskRewardReq.onFailed@processImp() failed");
/* 203 */     logBuilder.append('|').append("masterId=").append(this.masterRoleId);
/* 204 */     logBuilder.append('|').append("apprenticeId=").append(this.apprenticeRoleId);
/* 205 */     logBuilder.append('|').append("graphId=").append(this.graphId);
/* 206 */     logBuilder.append('|').append("taskId=").append(this.taskId);
/* 207 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 209 */     if (extraParams != null)
/*     */     {
/* 211 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 213 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 217 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCReceiveMasterTaskRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */