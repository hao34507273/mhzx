/*     */ package mzm.gsp.treasurehunt.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.treasurehunt.SLeaveTreasureHuntSuccess;
/*     */ import mzm.gsp.treasurehunt.STreasureHuntNormalFail;
/*     */ import mzm.gsp.treasurehunt.confbean.STreasureHuntCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2TreasureHuntWorldInfo;
/*     */ import xtable.Role2treasurehuntworld;
/*     */ 
/*     */ public class TreasureHuntSceneSession extends Session
/*     */ {
/*     */   private final int activityCfgId;
/*     */   private final long worldId;
/*     */   private final int chapterCfgId;
/*     */   
/*     */   public TreasureHuntSceneSession(long interval, long roleId, long worldId, int activityCfgId, int chapterCfgId)
/*     */   {
/*  26 */     super(interval, roleId);
/*  27 */     this.worldId = worldId;
/*  28 */     this.activityCfgId = activityCfgId;
/*  29 */     this.chapterCfgId = chapterCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  35 */     new POnTreasureHuntSessionTimeout(getOwerId(), this.worldId, this.activityCfgId, this.chapterCfgId).execute();
/*     */   }
/*     */   
/*     */   public int getActivityCfgId()
/*     */   {
/*  40 */     return this.activityCfgId;
/*     */   }
/*     */   
/*     */   public long getWroldId()
/*     */   {
/*  45 */     return this.worldId;
/*     */   }
/*     */   
/*     */   public int getChapterCfgId()
/*     */   {
/*  50 */     return this.chapterCfgId;
/*     */   }
/*     */   
/*     */   private static class POnTreasureHuntSessionTimeout
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final long worldId;
/*     */     private final int activityCfgId;
/*     */     private final int chapterCfgId;
/*     */     
/*     */     public POnTreasureHuntSessionTimeout(long roleId, long worldId, int activityCfgId, int chapterCfgId)
/*     */     {
/*  63 */       this.roleId = roleId;
/*  64 */       this.worldId = worldId;
/*  65 */       this.activityCfgId = activityCfgId;
/*  66 */       this.chapterCfgId = chapterCfgId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  72 */       STreasureHuntCfg sTreasureHuntCfg = STreasureHuntCfg.get(this.activityCfgId);
/*  73 */       if (sTreasureHuntCfg == null)
/*     */       {
/*  75 */         onFail(-1, null);
/*  76 */         return false;
/*     */       }
/*     */       
/*  79 */       Role2TreasureHuntWorldInfo xRole2TreasureHuntWorldInfo = Role2treasurehuntworld.get(Long.valueOf(this.roleId));
/*  80 */       if (xRole2TreasureHuntWorldInfo == null)
/*     */       {
/*  82 */         onFail(-2, null);
/*  83 */         return false;
/*     */       }
/*     */       
/*  86 */       if (this.worldId != xRole2TreasureHuntWorldInfo.getWorld_id())
/*     */       {
/*  88 */         onFail(-3, null);
/*     */       }
/*     */       
/*     */ 
/*  92 */       if (this.chapterCfgId != xRole2TreasureHuntWorldInfo.getChapter_cfg_id())
/*     */       {
/*  94 */         Map<String, Object> extraMap = new HashMap();
/*  95 */         extraMap.put("chapter_cfg_id", Integer.valueOf(xRole2TreasureHuntWorldInfo.getChapter_cfg_id()));
/*  96 */         extraMap.put("session_chapter_cfg_id", Integer.valueOf(this.chapterCfgId));
/*     */         
/*  98 */         onFail(-4, extraMap);
/*  99 */         return false;
/*     */       }
/*     */       
/* 102 */       TreasureHuntManager.onLeaveTreasureHunt(this.roleId, xRole2TreasureHuntWorldInfo.getTrigger_buff_set());
/*     */       
/* 104 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(this.roleId, 2191);
/*     */       
/* 106 */       MapInterface.forceTransferToScene(this.roleId, sTreasureHuntCfg.out_map_cfg_id, sTreasureHuntCfg.out_position_x, sTreasureHuntCfg.out_position_y, null);
/*     */       
/*     */ 
/* 109 */       TeamInterface.unRegisterJoinTeam(this.worldId);
/* 110 */       MapInterface.destroyWorld(this.worldId);
/*     */       
/* 112 */       Role2treasurehuntworld.remove(Long.valueOf(this.roleId));
/*     */       
/* 114 */       STreasureHuntNormalFail sTreasureHuntNormalFail = new STreasureHuntNormalFail();
/* 115 */       sTreasureHuntNormalFail.result = 12;
/*     */       
/* 117 */       OnlineManager.getInstance().send(this.roleId, sTreasureHuntNormalFail);
/*     */       
/* 119 */       SLeaveTreasureHuntSuccess sLeaveTreasureHuntSuccess = new SLeaveTreasureHuntSuccess();
/* 120 */       sLeaveTreasureHuntSuccess.activity_cfg_id = this.activityCfgId;
/*     */       
/* 122 */       OnlineManager.getInstance().send(this.roleId, sLeaveTreasureHuntSuccess);
/* 123 */       return true;
/*     */     }
/*     */     
/*     */     private void onFail(int ret, Map<String, ?> extraMap)
/*     */     {
/* 128 */       StringBuilder sBuilder = new StringBuilder();
/* 129 */       sBuilder.append("[treasure_hunt]POnTreasureHuntSessionTimeout.processImp@attend treasure hunt time out");
/* 130 */       sBuilder.append("|ret=").append(ret);
/* 131 */       sBuilder.append("|role_id=").append(this.roleId);
/* 132 */       sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */       
/* 134 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 136 */         for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */         {
/* 138 */           sBuilder.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */         }
/*     */       }
/* 141 */       GameServer.logger().error(sBuilder.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\TreasureHuntSceneSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */