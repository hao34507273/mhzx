/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.CrossBattleSelectionMatchInfo;
/*     */ import mzm.gsp.crossbattle.CrossBattleSelectionMatchRoleInfo;
/*     */ import mzm.gsp.crossbattle.SCrossBattleSelectionMatchRoleInfo;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchSucceedArg;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchSucceedProcedure;
/*     */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*     */ import mzm.gsp.crossserver.main.KnockOutRoleInfo;
/*     */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.CrossTokenCheckObserver;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xdb.Executor;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnSelectionOrFinalMatchSucceed extends SelectionOrFinalMatchSucceedProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  33 */     KnockOutTeamInfo ownCrossBattleTeamInfo = ((SelectionOrFinalMatchSucceedArg)this.arg).getOwnCrossBattleTeamInfo();
/*  34 */     Map<Long, String> roleid2Userid = new HashMap();
/*  35 */     final List<Long> roleids = new ArrayList();
/*  36 */     for (KnockOutRoleInfo roleCrossBattleInfo : ownCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  38 */       long roleid = roleCrossBattleInfo.getRoleid();
/*  39 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*  40 */       roleid2Userid.put(Long.valueOf(roleid), userid);
/*  41 */       roleids.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  44 */     GameServer.logger().info(String.format("[crossbattle_selection]POnSelectionOrFinalMatchSucceed.processImp@match success|roleids=%s", new Object[] { roleids }));
/*     */     
/*     */ 
/*     */ 
/*  48 */     lock(User.getTable(), roleid2Userid.values());
/*  49 */     lock(xtable.Role2properties.getTable(), roleids);
/*     */     
/*  51 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  53 */       RoleStatusInterface.unsetStatus(roleid, 1551);
/*     */     }
/*     */     
/*  56 */     KnockOutProcessContext processContext = ((SelectionOrFinalMatchSucceedArg)this.arg).getSelectionFinalProcessContext();
/*     */     
/*  58 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/*  59 */     if (sCrossBattleKnockOutCfg != null)
/*     */     {
/*  61 */       final KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(((SelectionOrFinalMatchSucceedArg)this.arg).getFightType()));
/*  62 */       if (knockOutCfg != null)
/*     */       {
/*     */ 
/*  65 */         Long prepareWorldId = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId();
/*  66 */         if (prepareWorldId != null)
/*     */         {
/*     */ 
/*  69 */           xdb.Xdb.executor().schedule(new Runnable()
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */             public void run() {
/*  75 */               MapInterface.forceTransferAllRole(roleids, MapInterface.getBigWorldid(), knockOutCfg.out_map_cfg_id, knockOutCfg.out_map_transfer_x, knockOutCfg.out_map_transfer_y); } }, 4000L, java.util.concurrent.TimeUnit.MILLISECONDS);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */     RoleStatusInterface.setStatus(roleids, 41, false);
/*     */     
/*  86 */     CrossTokenCheckObserver.createCrossTokenCheckObserver(roleids);
/*     */     
/*  88 */     CrossBattleKnockoutManager.doUnMatch(roleids);
/*     */     
/*  90 */     SCrossBattleSelectionMatchRoleInfo selectionMatchInfo = new SCrossBattleSelectionMatchRoleInfo();
/*  91 */     fillCrossBattleSelectionMatchInfo(selectionMatchInfo.matchteamainfos, ((SelectionOrFinalMatchSucceedArg)this.arg).getOwnCrossBattleTeamInfo(), processContext);
/*     */     
/*  93 */     fillCrossBattleSelectionMatchInfo(selectionMatchInfo.matchteambinfos, ((SelectionOrFinalMatchSucceedArg)this.arg).getOpponentCrossBattleTeamInfo(), processContext);
/*     */     
/*     */ 
/*  96 */     selectionMatchInfo.fight_stage = ((SelectionOrFinalMatchSucceedArg)this.arg).getFightStage();
/*  97 */     selectionMatchInfo.fight_type = ((SelectionOrFinalMatchSucceedArg)this.arg).getFightType();
/*  98 */     OnlineManager.getInstance().sendMulti(selectionMatchInfo, roleids);
/*  99 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillCrossBattleSelectionMatchInfo(CrossBattleSelectionMatchInfo selectionMatchInfo, KnockOutTeamInfo crossBattleTeamInfo, KnockOutProcessContext processContext)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 117 */     selectionMatchInfo.corps_id = crossBattleTeamInfo.getCorpsId();
/* 118 */     selectionMatchInfo.corps_icon = crossBattleTeamInfo.getCorpsBadgeId();
/* 119 */     selectionMatchInfo.corps_name.setString(crossBattleTeamInfo.getCorpsName(), "UTF-8");
/* 120 */     selectionMatchInfo.corps_zone_id = crossBattleTeamInfo.getZoneId();
/*     */     
/* 122 */     for (KnockOutRoleInfo roleCrossBattleInfo : crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 124 */       CrossBattleSelectionMatchRoleInfo matchRoleInfo = new CrossBattleSelectionMatchRoleInfo();
/* 125 */       matchRoleInfo.avatar_id = roleCrossBattleInfo.getAvatarId();
/* 126 */       matchRoleInfo.gender = roleCrossBattleInfo.getGender();
/* 127 */       matchRoleInfo.occupation = roleCrossBattleInfo.getOccupation();
/* 128 */       matchRoleInfo.process = 0;
/* 129 */       matchRoleInfo.role_level = roleCrossBattleInfo.getLevel();
/* 130 */       matchRoleInfo.role_name.setString(roleCrossBattleInfo.getRoleName(), "UTF-8");
/* 131 */       matchRoleInfo.roleid = roleCrossBattleInfo.getRoleid();
/*     */       
/* 133 */       selectionMatchInfo.match_role_list.add(matchRoleInfo);
/*     */       
/* 135 */       processContext.putRoleProcess(roleCrossBattleInfo.getRoleid(), 0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnSelectionOrFinalMatchSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */