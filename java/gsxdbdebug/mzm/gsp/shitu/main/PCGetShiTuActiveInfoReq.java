/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SGetShiTuActiveInfoRep;
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
/*     */ 
/*     */ 
/*     */ public class PCGetShiTuActiveInfoReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetShiTuActiveInfoReq(long roleId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!ShiTuManager.isShiTuActiveOpen(this.roleId))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1641, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     String apprenticeUserId = RoleInterface.getUserId(this.roleId);
/*  49 */     if (apprenticeUserId == null)
/*     */     {
/*  51 */       onFailed(3);
/*  52 */       return false;
/*     */     }
/*  54 */     lock(Lockeys.get(User.getTable(), apprenticeUserId));
/*     */     
/*     */ 
/*  57 */     role2ShiTuInfo xShiTuInfo = Role2shitu.get(Long.valueOf(this.roleId));
/*  58 */     if (xShiTuInfo == null)
/*     */     {
/*  60 */       onFailed(2);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     MasterInfo xMasterInfo = xShiTuInfo.getMasterinfo();
/*  66 */     Map<Long, ShiTuTimeInfo> xNowMasterApprenticeInfoMap = xMasterInfo.getApprentice_now();
/*     */     
/*     */ 
/*  69 */     Set<Long> roleIdSet = new HashSet(xNowMasterApprenticeInfoMap.keySet());
/*     */     
/*  71 */     if (ShiTuManager.getMasterId(xShiTuInfo) > 0L)
/*     */     {
/*  73 */       roleIdSet.add(Long.valueOf(this.roleId));
/*     */     }
/*     */     
/*     */ 
/*  77 */     ActiveInterface.getTotalActiveValue(this.roleId);
/*     */     
/*  79 */     if (roleIdSet.size() > 0) {
/*  80 */       new PSynAllShiTuActiveInfos(this.roleId, roleIdSet).execute();
/*     */     } else {
/*  82 */       onFailed(2);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     SGetShiTuActiveInfoRep rsp = new SGetShiTuActiveInfoRep();
/*  88 */     rsp.result = 1;
/*  89 */     OnlineManager.getInstance().send(this.roleId, rsp);
/*     */     
/*  91 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int error_code)
/*     */   {
/*  96 */     onFailed(error_code, null);
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
/* 107 */     SGetShiTuActiveInfoRep rsp = new SGetShiTuActiveInfoRep();
/* 108 */     rsp.result = error_code;
/* 109 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 111 */     StringBuffer logBuilder = new StringBuffer();
/* 112 */     logBuilder.append("[shitu]PCGetShiTuActiveInfoReq.onFailed@processImp() failed");
/* 113 */     logBuilder.append('|').append("roleId=").append(this.roleId);
/* 114 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 116 */     if (extraParams != null)
/*     */     {
/* 118 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 120 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 124 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCGetShiTuActiveInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */