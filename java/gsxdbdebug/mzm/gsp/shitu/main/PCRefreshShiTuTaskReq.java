/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SRefreshShiTuTaskRep;
/*     */ import mzm.gsp.shitu.confbean.SShiTuTaskConsts;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTaskInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.Role2shitutask;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCRefreshShiTuTaskReq extends LogicProcedure
/*     */ {
/*     */   private final long masterRoleId;
/*     */   private final long apprenticeRoleId;
/*     */   
/*     */   public PCRefreshShiTuTaskReq(long masterRoleId, long apprenticeRoleId)
/*     */   {
/*  30 */     this.masterRoleId = masterRoleId;
/*  31 */     this.apprenticeRoleId = apprenticeRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!ShiTuManager.isShiTuTaskOpen(this.masterRoleId))
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1641, true))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     String masterUserId = RoleInterface.getUserId(this.masterRoleId);
/*  47 */     String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/*  48 */     if ((masterUserId == null) || (apprenticeUserId == null))
/*     */     {
/*  50 */       onFailed(4);
/*  51 */       return false;
/*     */     }
/*  53 */     super.lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*     */ 
/*  56 */     super.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*  58 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId));
/*  59 */     if (xApprenticeShiTuInfo == null)
/*     */     {
/*  61 */       onFailed(2);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/*  66 */     if (xApprenticeInfo.getMasterroleid() != this.masterRoleId)
/*     */     {
/*  68 */       onFailed(2);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(this.masterRoleId));
/*  73 */     if (xMasterShiTuInfo == null)
/*     */     {
/*  75 */       onFailed(2);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     MasterInfo xMasterInfo = xMasterShiTuInfo.getMasterinfo();
/*  81 */     Map<Long, ShiTuTimeInfo> xNowMasterApprenticeInfoMap = xMasterInfo.getApprentice_now();
/*  82 */     ShiTuTimeInfo xMasterTimeInfo = (ShiTuTimeInfo)xNowMasterApprenticeInfoMap.get(Long.valueOf(this.apprenticeRoleId));
/*     */     
/*  84 */     if (xMasterTimeInfo == null)
/*     */     {
/*  86 */       onFailed(2);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     ShiTuTaskInfo xShiTuTaskInfo = Role2shitutask.get(Long.valueOf(this.apprenticeRoleId));
/*  92 */     if (xShiTuTaskInfo == null)
/*     */     {
/*  94 */       onFailed(5);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     if (xShiTuTaskInfo.getPublish_state() != 0)
/*     */     {
/* 101 */       onFailed(7);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     if (xShiTuTaskInfo.getRefresh_times() >= SShiTuTaskConsts.getInstance().DAILY_MAX_REFRESH_TIMES)
/*     */     {
/* 108 */       onFailed(3);
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 113 */     if (!ShiTuManager.refreshShiTuTasks(this.apprenticeRoleId, xShiTuTaskInfo))
/*     */     {
/* 115 */       onFailed(6);
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     xShiTuTaskInfo.setRefresh_times(xShiTuTaskInfo.getRefresh_times() + 1);
/*     */     
/*     */ 
/* 123 */     SRefreshShiTuTaskRep rsp = new SRefreshShiTuTaskRep();
/* 124 */     rsp.result = 1;
/* 125 */     OnlineManager.getInstance().send(this.masterRoleId, rsp);
/*     */     
/*     */ 
/* 128 */     OnlineManager.getInstance().send(this.masterRoleId, ShiTuManager.getAndCheckResetShiTuTaskInfo(this.apprenticeRoleId));
/*     */     
/*     */ 
/* 131 */     ShiTuTLogManager.tlogShiTuTaskMaster(this.masterRoleId, masterUserId, this.apprenticeRoleId, apprenticeUserId, xShiTuTaskInfo);
/*     */     
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int error_code)
/*     */   {
/* 138 */     onFailed(error_code, null);
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
/* 149 */     SRefreshShiTuTaskRep rsp = new SRefreshShiTuTaskRep();
/* 150 */     rsp.result = error_code;
/* 151 */     OnlineManager.getInstance().sendAtOnce(this.masterRoleId, rsp);
/*     */     
/* 153 */     StringBuffer logBuilder = new StringBuffer();
/* 154 */     logBuilder.append("[shitu]PCRefreshShiTuTaskReq.onFailed@processImp() failed");
/* 155 */     logBuilder.append('|').append("masterId=").append(this.masterRoleId);
/* 156 */     logBuilder.append('|').append("apprenticeId=").append(this.apprenticeRoleId);
/* 157 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 159 */     if (extraParams != null)
/*     */     {
/* 161 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 163 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 167 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCRefreshShiTuTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */