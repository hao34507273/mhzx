/*     */ package mzm.gsp.treasurehunt.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.treasurehunt.SLeaveTreasureHuntSuccess;
/*     */ import mzm.gsp.treasurehunt.STreasureHuntNormalFail;
/*     */ import mzm.gsp.treasurehunt.confbean.STreasureHuntCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2TreasureHuntWorldInfo;
/*     */ import xtable.Role2treasurehuntworld;
/*     */ 
/*     */ public class PCLeaveTreasureHunt extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   
/*     */   public PCLeaveTreasureHunt(long roleId, int activityCfgId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*     */     
/*  27 */     this.activityCfgId = activityCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     STreasureHuntCfg sTreasureHuntCfg = STreasureHuntCfg.get(this.activityCfgId);
/*  34 */     if (sTreasureHuntCfg == null)
/*     */     {
/*  36 */       onFail(1);
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     Role2TreasureHuntWorldInfo xRole2TreasureHuntWorldInfo = Role2treasurehuntworld.get(Long.valueOf(this.roleId));
/*  41 */     if (xRole2TreasureHuntWorldInfo == null)
/*     */     {
/*  43 */       onFail(8);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     Session session = Session.getSession(xRole2TreasureHuntWorldInfo.getSession_id());
/*  48 */     if (session == null)
/*     */     {
/*  50 */       onFail(9);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2193, true))
/*     */     {
/*  56 */       onFail(10);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     RoleStatusInterface.unsetStatus(this.roleId, 2191);
/*     */     
/*  62 */     session.stopTimer();
/*     */     
/*  64 */     MapInterface.forceTransferToScene(this.roleId, sTreasureHuntCfg.out_map_cfg_id, sTreasureHuntCfg.out_position_x, sTreasureHuntCfg.out_position_y, null);
/*     */     
/*     */ 
/*  67 */     TreasureHuntManager.onLeaveTreasureHunt(this.roleId, xRole2TreasureHuntWorldInfo.getTrigger_buff_set());
/*     */     
/*  69 */     TeamInterface.unRegisterJoinTeam(xRole2TreasureHuntWorldInfo.getWorld_id());
/*     */     
/*  71 */     MapInterface.destroyWorld(xRole2TreasureHuntWorldInfo.getWorld_id());
/*     */     
/*  73 */     Role2treasurehuntworld.remove(Long.valueOf(this.roleId));
/*     */     
/*  75 */     SLeaveTreasureHuntSuccess sLeaveTreasureHuntSuccess = new SLeaveTreasureHuntSuccess();
/*  76 */     sLeaveTreasureHuntSuccess.activity_cfg_id = this.activityCfgId;
/*     */     
/*  78 */     OnlineManager.getInstance().send(this.roleId, sLeaveTreasureHuntSuccess);
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/*  85 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/*  90 */     StringBuilder sBuilder = new StringBuilder();
/*  91 */     sBuilder.append("[treasure_hunt]PCLeaveTreasureHunt.processImp@leave treasure hunt failed");
/*  92 */     sBuilder.append("|ret=").append(ret);
/*  93 */     sBuilder.append("|role_id=").append(this.roleId);
/*  94 */     sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */     
/*  96 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/*  98 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 100 */         sBuilder.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 103 */     GameServer.logger().error(sBuilder.toString());
/*     */     
/* 105 */     STreasureHuntNormalFail sTreasureHuntNormalFail = new STreasureHuntNormalFail();
/* 106 */     sTreasureHuntNormalFail.result = ret;
/*     */     
/* 108 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sTreasureHuntNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\PCLeaveTreasureHunt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */