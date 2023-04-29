/*     */ package mzm.gsp.npcreward.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.npcreward.confbean.SNPCRewardCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NPCRewardManager
/*     */ {
/*     */   static boolean isFunOpen(int activityId)
/*     */   {
/*  21 */     SNPCRewardCfg sNPCRewardCfg = SNPCRewardCfg.get(activityId);
/*  22 */     if (sNPCRewardCfg == null) {
/*  23 */       return false;
/*     */     }
/*  25 */     if (!OpenInterface.getOpenStatus(sNPCRewardCfg.openCfgid))
/*     */     {
/*  27 */       GameServer.logger().error("[npcreward]NPCRewardManager.isFunOpen@fun not open");
/*  28 */       return false;
/*     */     }
/*  30 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFunOpen(long roleid, int activityId)
/*     */   {
/*  41 */     SNPCRewardCfg sNPCRewardCfg = SNPCRewardCfg.get(activityId);
/*  42 */     if (sNPCRewardCfg == null) {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!OpenInterface.getOpenStatus(sNPCRewardCfg.openCfgid))
/*     */     {
/*  47 */       GameServer.logger().error("[npcreward]NPCRewardManager.isFunOpen@fun not open");
/*  48 */       return false;
/*     */     }
/*  50 */     if (OpenInterface.isBanPlay(roleid, sNPCRewardCfg.openCfgid))
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[npcreward]NPCRewardManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*  53 */       OpenInterface.sendBanPlayMsg(roleid, sNPCRewardCfg.openCfgid);
/*  54 */       return false;
/*     */     }
/*  56 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNpcController(int activityCfgid)
/*     */   {
/*  66 */     SNPCRewardCfg sNPCRewardCfg = SNPCRewardCfg.get(activityCfgid);
/*  67 */     if (sNPCRewardCfg == null)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[npcreward]NPCRewardManager.getNpcController@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*     */       
/*  71 */       return -1;
/*     */     }
/*  73 */     SNpc npc = NpcInterface.getNpc(sNPCRewardCfg.npcCfgid);
/*  74 */     if (npc == null)
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[npcreward]NPCRewardManager.getNpcController@npc cfg is null|activity_cfgid=%d|npc_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(sNPCRewardCfg.npcCfgid) }));
/*     */       
/*     */ 
/*  79 */       return -1;
/*     */     }
/*  81 */     return npc.controllerId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onOpenChange(int activityCfgid, boolean open)
/*     */   {
/*  91 */     if (!ActivityInterface.isActivityOpen(activityCfgid))
/*     */     {
/*  93 */       return;
/*     */     }
/*     */     
/*  96 */     int controller = getNpcController(activityCfgid);
/*  97 */     if (controller <= 0)
/*     */     {
/*  99 */       return;
/*     */     }
/*     */     
/* 102 */     if (open)
/*     */     {
/* 104 */       ControllerInterface.triggerController(controller);
/*     */     }
/*     */     else
/*     */     {
/* 108 */       ControllerInterface.collectController(controller);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npcreward\main\NPCRewardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */