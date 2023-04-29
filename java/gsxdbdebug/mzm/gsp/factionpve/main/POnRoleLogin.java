/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.FactionPVE;
/*     */ import xbean.FactionPVETmp;
/*     */ import xbean.RoleFactionPVE;
/*     */ import xtable.Factionpve;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     long roleid = ((Long)this.arg).longValue();
/*     */     
/*     */ 
/*  24 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/*     */ 
/*  27 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*     */ 
/*  30 */     Gang faction = GangInterface.getGangByRoleId(roleid, true);
/*     */     
/*  32 */     if (faction != null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  37 */       FactionPVE xFactionPVE = Factionpve.get(Long.valueOf(faction.getGangId()));
/*  38 */       if (xFactionPVE != null)
/*     */       {
/*     */ 
/*  41 */         FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(faction.getGangId());
/*     */         
/*  43 */         FactionPVEManager.checkAndInitXFactionPVEAndXFactionPVETmp(xFactionPVE, xFactionPVETmp);
/*     */         
/*     */ 
/*  46 */         ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, SFactionPVEConsts.getInstance().Activityid);
/*     */         
/*     */ 
/*     */ 
/*  50 */         RoleFactionPVE xRolePVE = FactionPVEManager.getXRoleFactionPVEIfNotExist(roleid);
/*     */         
/*     */ 
/*  53 */         FactionPVEManager.syncParticipateTimes(roleid, xRolePVE);
/*     */         
/*     */ 
/*  56 */         FactionPVEManager.syncStartTime(roleid, xFactionPVE);
/*     */         
/*     */ 
/*  59 */         FactionPVEManager.sendFactionPVETimes(roleid, xFactionPVE);
/*     */         
/*     */ 
/*  62 */         FactionPVEManager.sendFactionPVEStage(roleid, xFactionPVETmp);
/*     */         
/*  64 */         long world = MapInterface.getRoleWorldInstanceId(roleid);
/*  65 */         if (world >= 0L)
/*     */         {
/*     */ 
/*  68 */           if (world == xFactionPVETmp.getWorld())
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  73 */             int stage = xFactionPVETmp.getStage();
/*  74 */             if (stage == 6)
/*     */             {
/*  76 */               FactionPVEManager.leave(roleid, faction);
/*     */             }
/*     */             else
/*     */             {
/*  80 */               int playerCount = MapInterface.getRoleNumInWorld(world);
/*  81 */               FactionPVEManager.syncPlayerCount(roleid, playerCount);
/*     */               
/*  83 */               if (stage > 1)
/*     */               {
/*  85 */                 FactionPVEManager.syncSelfKillMonster(roleid, xRolePVE);
/*     */                 
/*  87 */                 if (stage == 2) {
/*  88 */                   FactionPVEManager.syncFactionKillMonster(roleid, xFactionPVETmp);
/*     */                 }
/*  90 */                 else if (stage >= 4)
/*     */                 {
/*  92 */                   FactionPVEManager.sendKillBossCount(roleid, xFactionPVETmp);
/*     */                 }
/*     */               }
/*     */             }
/*     */             
/*  97 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 102 */     FactionPVEManager.clearActivityStatus(roleid);
/*     */     
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */