/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SPublishShiTuTaskRep;
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
/*     */ public class PCPublishShiTuTaskReq extends LogicProcedure
/*     */ {
/*     */   private final long masterRoleId;
/*     */   private final long apprenticeRoleId;
/*     */   
/*     */   public PCPublishShiTuTaskReq(long masterRoleId, long apprenticeRoleId)
/*     */   {
/*  31 */     this.masterRoleId = masterRoleId;
/*  32 */     this.apprenticeRoleId = apprenticeRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!ShiTuManager.isShiTuTaskOpen(this.masterRoleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1641, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     String masterUserId = RoleInterface.getUserId(this.masterRoleId);
/*  48 */     String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/*  49 */     if ((masterUserId == null) || (apprenticeUserId == null))
/*     */     {
/*  51 */       onFailed(3);
/*  52 */       return false;
/*     */     }
/*  54 */     super.lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*     */ 
/*  57 */     super.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*  59 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId));
/*  60 */     if (xApprenticeShiTuInfo == null)
/*     */     {
/*  62 */       onFailed(2);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/*  67 */     if (xApprenticeInfo.getMasterroleid() != this.masterRoleId)
/*     */     {
/*  69 */       onFailed(2);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(this.masterRoleId));
/*  74 */     if (xMasterShiTuInfo == null)
/*     */     {
/*  76 */       onFailed(2);
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  81 */     MasterInfo xMasterInfo = xMasterShiTuInfo.getMasterinfo();
/*  82 */     Map<Long, ShiTuTimeInfo> xNowMasterApprenticeInfoMap = xMasterInfo.getApprentice_now();
/*  83 */     ShiTuTimeInfo xMasterTimeInfo = (ShiTuTimeInfo)xNowMasterApprenticeInfoMap.get(Long.valueOf(this.apprenticeRoleId));
/*     */     
/*  85 */     if (xMasterTimeInfo == null)
/*     */     {
/*  87 */       onFailed(2);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (ShiTuManager.isMaxPublishTimes(xMasterInfo))
/*     */     {
/*  93 */       onFailed(6);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     ShiTuTaskInfo xShiTuTaskInfo = Role2shitutask.get(Long.valueOf(this.apprenticeRoleId));
/*  98 */     if (xShiTuTaskInfo == null)
/*     */     {
/* 100 */       onFailed(4);
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     if (xShiTuTaskInfo.getPublish_state() != 0)
/*     */     {
/* 107 */       onFailed(5);
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     xMasterInfo.setPublish_times(xMasterInfo.getPublish_times() + 1);
/*     */     
/* 114 */     if (ShiTuManager.isMaxPublishTimes(xMasterInfo))
/*     */     {
/*     */ 
/* 117 */       Set<Long> roleIdSet = new HashSet(xNowMasterApprenticeInfoMap.keySet());
/* 118 */       roleIdSet.remove(Long.valueOf(this.apprenticeRoleId));
/* 119 */       if (roleIdSet.size() > 0)
/*     */       {
/* 121 */         new PChangeShiTuTaskPublishState(this.masterRoleId, roleIdSet, 0, 7).execute();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 127 */     xShiTuTaskInfo.setPublish_state(1);
/*     */     
/*     */ 
/* 130 */     SPublishShiTuTaskRep rsp = new SPublishShiTuTaskRep();
/* 131 */     rsp.result = 1;
/* 132 */     rsp.role_id = this.apprenticeRoleId;
/* 133 */     OnlineManager.getInstance().send(this.masterRoleId, rsp);
/*     */     
/*     */ 
/* 136 */     OnlineManager.getInstance().sendMulti(ShiTuManager.getAndCheckResetShiTuTaskInfo(this.apprenticeRoleId), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 140 */     ShiTuTLogManager.tlogShiTuTaskMaster(this.masterRoleId, masterUserId, this.apprenticeRoleId, apprenticeUserId, xShiTuTaskInfo);
/*     */     
/* 142 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int error_code)
/*     */   {
/* 147 */     onFailed(error_code, null);
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
/* 158 */     SPublishShiTuTaskRep rsp = new SPublishShiTuTaskRep();
/* 159 */     rsp.result = error_code;
/* 160 */     rsp.role_id = this.apprenticeRoleId;
/* 161 */     OnlineManager.getInstance().sendAtOnce(this.masterRoleId, rsp);
/*     */     
/* 163 */     StringBuffer logBuilder = new StringBuffer();
/* 164 */     logBuilder.append("[shitu]PCPublishShiTuTaskReq.onFailed@processImp() failed");
/* 165 */     logBuilder.append('|').append("masterId=").append(this.masterRoleId);
/* 166 */     logBuilder.append('|').append("apprenticeId=").append(this.apprenticeRoleId);
/* 167 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 169 */     if (extraParams != null)
/*     */     {
/* 171 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 173 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 177 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCPublishShiTuTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */