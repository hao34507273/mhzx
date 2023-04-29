/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SGetShiTuTaskInfoRep;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetShiTuTaskInfoReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetShiTuTaskInfoReq(long roleId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!ShiTuManager.isShiTuTaskOpen(this.roleId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1641, true))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     String apprenticeUserId = RoleInterface.getUserId(this.roleId);
/*  46 */     if (apprenticeUserId == null)
/*     */     {
/*  48 */       onFailed(3);
/*  49 */       return false;
/*     */     }
/*  51 */     lock(Lockeys.get(User.getTable(), apprenticeUserId));
/*     */     
/*     */ 
/*  54 */     role2ShiTuInfo xShiTuInfo = Role2shitu.get(Long.valueOf(this.roleId));
/*  55 */     if (xShiTuInfo == null)
/*     */     {
/*  57 */       onFailed(2);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     MasterInfo xMasterInfo = xShiTuInfo.getMasterinfo();
/*  63 */     Map<Long, ShiTuTimeInfo> xNowMasterApprenticeInfoMap = xMasterInfo.getApprentice_now();
/*     */     
/*     */ 
/*  66 */     Set<Long> roleIdSet = new HashSet(xNowMasterApprenticeInfoMap.keySet());
/*     */     
/*  68 */     if (ShiTuManager.getMasterId(xShiTuInfo) > 0L)
/*     */     {
/*  70 */       roleIdSet.add(Long.valueOf(this.roleId));
/*     */     }
/*  72 */     if (roleIdSet.size() > 0) {
/*  73 */       new PSynAllShiTuTaskInfos(this.roleId, roleIdSet).execute();
/*     */     } else {
/*  75 */       onFailed(2);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     SGetShiTuTaskInfoRep rsp = new SGetShiTuTaskInfoRep();
/*  81 */     rsp.result = 1;
/*  82 */     OnlineManager.getInstance().send(this.roleId, rsp);
/*     */     
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int error_code)
/*     */   {
/*  89 */     onFailed(error_code, null);
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
/* 100 */     SGetShiTuTaskInfoRep rsp = new SGetShiTuTaskInfoRep();
/* 101 */     rsp.result = error_code;
/* 102 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 104 */     StringBuffer logBuilder = new StringBuffer();
/* 105 */     logBuilder.append("[shitu]PCGetShiTuTaskInfoReq.onFailed@processImp() failed");
/* 106 */     logBuilder.append('|').append("roleId=").append(this.roleId);
/* 107 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 109 */     if (extraParams != null)
/*     */     {
/* 111 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 113 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 117 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCGetShiTuTaskInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */