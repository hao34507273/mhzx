/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SAgreeOrRefuseMasterRecommendRep;
/*     */ import mzm.gsp.shitu.ShiTuRoleInfoAndModelInfo;
/*     */ import mzm.gsp.shitu.SynApprenticeRecommendInfo;
/*     */ import mzm.gsp.shitu.confbean.SMasterRecommendConsts;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAgreeOrRefuseMasterRecommendReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int operator;
/*     */   private final long sessionid;
/*     */   
/*     */   public PCAgreeOrRefuseMasterRecommendReq(long roleId, int operator, long sessionid)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.operator = operator;
/*  29 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     Session session = Session.getSession(this.sessionid);
/*  40 */     MasterRecommendSession masterRecommendSession = null;
/*  41 */     if ((session instanceof MasterRecommendSession))
/*     */     {
/*  43 */       masterRecommendSession = (MasterRecommendSession)session;
/*     */     }
/*  45 */     if (masterRecommendSession == null)
/*     */     {
/*  47 */       onFailed(2);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     Session.removeSession(this.sessionid);
/*     */     
/*     */ 
/*  55 */     if (!ShiTuManager.isShiTuRecommemdOpen(this.roleId))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     String apprenticeUserId = RoleInterface.getUserId(this.roleId);
/*  62 */     if (apprenticeUserId == null)
/*     */     {
/*  64 */       onFailed(4);
/*  65 */       return false;
/*     */     }
/*  67 */     lock(xdb.Lockeys.get(User.getTable(), apprenticeUserId));
/*     */     
/*     */ 
/*  70 */     role2ShiTuInfo xShiTuInfo = Role2shitu.get(Long.valueOf(this.roleId));
/*     */     
/*  72 */     if (xShiTuInfo == null)
/*     */     {
/*  74 */       onFailed(4);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1643, true, true))
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     if (this.operator == 1)
/*     */     {
/*     */ 
/*  88 */       if (xShiTuInfo.getApprenticeinfo().getMasterroleid() > 0L)
/*     */       {
/*  90 */         onFailed(3);
/*  91 */         return false;
/*     */       }
/*     */       
/*  94 */       if (RoleInterface.getLevel(this.roleId) >= SMasterRecommendConsts.getInstance().APPRENTICE_MAX_LEVEL)
/*     */       {
/*     */ 
/*  97 */         ShiTuManager.triggerMasterRecommendEvent(this.roleId, masterRecommendSession.getRecommendRoleIds(), false);
/*     */       }
/*     */       
/* 100 */       SynApprenticeRecommendInfo synApprenticeRecommendInfo = new SynApprenticeRecommendInfo();
/* 101 */       synApprenticeRecommendInfo.apprentice_recommend_info = ShiTuManager.setShiTuRoleInfoAndModelInfo(this.roleId, new ShiTuRoleInfoAndModelInfo());
/*     */       
/* 103 */       OnlineManager.getInstance().sendMulti(synApprenticeRecommendInfo, masterRecommendSession.getRecommendRoleIds());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 109 */       xShiTuInfo.setRefusemasterrecommend(true);
/*     */       
/*     */ 
/* 112 */       ShiTuManager.triggerMasterRecommendEvent(this.roleId, masterRecommendSession.getRecommendRoleIds(), false);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 118 */     SAgreeOrRefuseMasterRecommendRep sAgreeOrRefuseMasterRecommendRep = new SAgreeOrRefuseMasterRecommendRep();
/* 119 */     sAgreeOrRefuseMasterRecommendRep.result = 1;
/* 120 */     sAgreeOrRefuseMasterRecommendRep.operator = this.operator;
/* 121 */     OnlineManager.getInstance().send(this.roleId, sAgreeOrRefuseMasterRecommendRep);
/*     */     
/*     */ 
/* 124 */     ShiTuTLogManager.tlogShiTuRecommend(this.roleId, apprenticeUserId, masterRecommendSession.getRecommendRoleIds(), this.operator == 1 ? ShiTuRecommendEnum.AGREE_RECOMMEND : ShiTuRecommendEnum.REFUSE_RECOMMEND);
/*     */     
/*     */ 
/* 127 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 132 */     onFailed(retcode, null);
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
/* 143 */     SAgreeOrRefuseMasterRecommendRep rsp = new SAgreeOrRefuseMasterRecommendRep();
/* 144 */     rsp.result = error_code;
/* 145 */     rsp.operator = this.operator;
/* 146 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 148 */     StringBuffer logBuilder = new StringBuffer();
/* 149 */     logBuilder.append("[shitu]PCAgreeOrRefuseMasterRecommendReq.onFailed@processImp() failed");
/* 150 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 151 */     logBuilder.append('|').append("operator=").append(this.operator);
/* 152 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 154 */     if (extraParams != null)
/*     */     {
/* 156 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 158 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 162 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCAgreeOrRefuseMasterRecommendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */