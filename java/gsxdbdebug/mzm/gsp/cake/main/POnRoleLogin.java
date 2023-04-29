/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.cake.CakeDetailInfo;
/*     */ import mzm.gsp.cake.RoleCakeInfo;
/*     */ import mzm.gsp.cake.SSynMakeCakeStage;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.CakeData;
/*     */ import xbean.CakeDetailData;
/*     */ import xbean.CakeInfo;
/*     */ import xbean.FactionCakeData;
/*     */ import xbean.FactionCakeInfo;
/*     */ import xbean.GlobalCakeData;
/*     */ import xbean.GlobalCakeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Factioncake;
/*     */ import xtable.Globalcake;
/*     */ import xtable.Role2cakeinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*     */ 
/*  35 */     new CheckRoleStatus(roleId).execute();
/*     */     
/*     */ 
/*  38 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/*  39 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  41 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/*  43 */     long factionId = GangInterface.getGangId(roleId);
/*  44 */     if (factionId <= 0L)
/*     */     {
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     FactionCakeInfo xFactionCakeInfo = Factioncake.get(Long.valueOf(factionId));
/*  51 */     if (xFactionCakeInfo == null)
/*     */     {
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     GlobalCakeInfo xGlobalCakeInfo = Globalcake.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  59 */     if (xGlobalCakeInfo == null)
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     CakeInfo xCakeInfo = Role2cakeinfo.get(Long.valueOf(roleId));
/*  64 */     if (xCakeInfo == null)
/*     */     {
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  70 */     Map<Integer, RoleCakeInfo> activityInfos = new HashMap();
/*  71 */     for (SCakeActivityCfg cfg : SCakeActivityCfg.getAll().values())
/*     */     {
/*  73 */       int activityId = cfg.activityId;
/*  74 */       GlobalCakeData xGlobalCakeData = (GlobalCakeData)xGlobalCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*  75 */       if (xGlobalCakeData != null)
/*     */       {
/*     */ 
/*     */ 
/*  79 */         int stage = CakeManager.getCookStage(cfg, curTime);
/*  80 */         if ((stage >= 0) && 
/*     */         
/*     */ 
/*     */ 
/*  84 */           (xGlobalCakeData.getIsgoing()) && 
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  89 */           (!xGlobalCakeData.getRecovery()))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  94 */           FactionCakeData xFactionCakeData = (FactionCakeData)xFactionCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*  95 */           if (xFactionCakeData != null)
/*     */           {
/*     */ 
/*     */ 
/*  99 */             CakeData xCakeData = (CakeData)xCakeInfo.getCakedatas().get(Integer.valueOf(activityId));
/* 100 */             if (xCakeData != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */               RoleCakeInfo roleCakeInfo = new RoleCakeInfo();
/*     */               
/* 108 */               CakeDetailData xCakeDetailData = getCakeDetailData(xFactionCakeInfo, roleId, activityId);
/* 109 */               if (xCakeDetailData == null)
/*     */               {
/*     */ 
/* 112 */                 roleCakeInfo.curturn = xGlobalCakeData.getCurturn();
/* 113 */                 roleCakeInfo.cookselfcount = 0;
/* 114 */                 roleCakeInfo.cookothercount = 0;
/* 115 */                 roleCakeInfo.effectfactionid = 0L;
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/* 120 */                 roleCakeInfo.curturn = xFactionCakeData.getCurturn();
/* 121 */                 roleCakeInfo.cookselfcount = xCakeData.getCookselfcount();
/* 122 */                 roleCakeInfo.cookothercount = xCakeData.getCookothercount();
/* 123 */                 roleCakeInfo.effectfactionid = xCakeData.getEffectfactionid();
/*     */                 
/*     */ 
/* 126 */                 CakeManager.fillPCakeDetailInfo(roleCakeInfo.cakeinfo, xCakeDetailData, xFactionCakeData.getCurturn());
/*     */               }
/*     */               
/* 129 */               activityInfos.put(Integer.valueOf(activityId), roleCakeInfo);
/*     */             } } } } }
/* 131 */     if (activityInfos.isEmpty())
/*     */     {
/* 133 */       return false;
/*     */     }
/* 135 */     SSynMakeCakeStage p = new SSynMakeCakeStage();
/* 136 */     p.activityinfos.putAll(activityInfos);
/* 137 */     OnlineManager.getInstance().send(roleId, p);
/*     */     
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   private CakeDetailData getCakeDetailData(FactionCakeInfo xFactionCakeInfo, long roleId, int activityId)
/*     */   {
/* 144 */     if (xFactionCakeInfo == null)
/*     */     {
/* 146 */       return null;
/*     */     }
/* 148 */     FactionCakeData xFactionCakeData = (FactionCakeData)xFactionCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/* 149 */     if (xFactionCakeData == null)
/*     */     {
/* 151 */       return null;
/*     */     }
/* 153 */     return (CakeDetailData)xFactionCakeData.getRolecakes().get(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */   void fillCakeInfo(FactionCakeInfo xFactionCakeInfo, long roleId, int activityId, CakeDetailInfo cakeinfo)
/*     */   {
/* 158 */     if (xFactionCakeInfo == null)
/*     */     {
/* 160 */       return;
/*     */     }
/* 162 */     FactionCakeData xFactionCakeData = (FactionCakeData)xFactionCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/* 163 */     if (xFactionCakeData == null)
/*     */     {
/* 165 */       return;
/*     */     }
/* 167 */     CakeDetailData xCakeDetailData = (CakeDetailData)xFactionCakeData.getRolecakes().get(Long.valueOf(roleId));
/* 168 */     if (xCakeDetailData == null)
/*     */     {
/* 170 */       return;
/*     */     }
/* 172 */     CakeManager.fillPCakeDetailInfo(cakeinfo, xCakeDetailData, xFactionCakeData.getCurturn());
/*     */   }
/*     */   
/*     */   boolean isCakeInfoValid(GlobalCakeData xGlobalCakeData, CakeData xCakeData)
/*     */   {
/* 177 */     if (!xGlobalCakeData.getRecovery())
/*     */     {
/*     */ 
/* 180 */       return false;
/*     */     }
/* 182 */     if (xGlobalCakeData.getCurturn() != xCakeData.getCurturn())
/*     */     {
/*     */ 
/* 185 */       return false;
/*     */     }
/* 187 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private class CheckRoleStatus
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */ 
/*     */     public CheckRoleStatus(long roleId)
/*     */     {
/* 202 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 208 */       POperCookState.operRoleStatusOnLogin(this.roleId, SCakeActivityCfg.getAll().keySet());
/* 209 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */