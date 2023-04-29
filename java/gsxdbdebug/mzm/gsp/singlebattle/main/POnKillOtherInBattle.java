/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*     */ import mzm.gsp.singlebattle.event.EventArg_KillOther;
/*     */ import mzm.gsp.singlebattle.event.KillOtherInBattleProcedure;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleSingleBattle;
/*     */ import xtable.Role2singlebattle;
/*     */ 
/*     */ 
/*     */ public class POnKillOtherInBattle
/*     */   extends KillOtherInBattleProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  19 */     new HandRoleKillPoint(((EventArg_KillOther)this.arg).getRoleId(), true).execute();
/*     */     
/*  21 */     for (Iterator i$ = ((EventArg_KillOther)this.arg).getOtherIds().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  23 */       new HandRoleKillPoint(roleId, false).execute();
/*     */     }
/*  25 */     return true;
/*     */   }
/*     */   
/*     */   private final class HandRoleKillPoint extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final boolean add;
/*     */     
/*     */     public HandRoleKillPoint(long roleId, boolean add)
/*     */     {
/*  35 */       this.roleId = roleId;
/*  36 */       this.add = add;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  42 */       RoleSingleBattle xRoleSingleBattle = Role2singlebattle.get(Long.valueOf(this.roleId));
/*  43 */       if (xRoleSingleBattle == null)
/*     */       {
/*  45 */         return false;
/*     */       }
/*  47 */       SSingleBattleCfg cfg = SSingleBattleCfg.get(xRoleSingleBattle.getBattlecfgid());
/*  48 */       if (cfg == null)
/*     */       {
/*  50 */         return false;
/*     */       }
/*     */       
/*  53 */       if (this.add)
/*     */       {
/*  55 */         addKillPoint(xRoleSingleBattle, cfg);
/*     */       }
/*     */       else
/*     */       {
/*  59 */         cutKillPoint(xRoleSingleBattle, cfg);
/*     */       }
/*  61 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void cutKillPoint(RoleSingleBattle xRoleSingleBattle, SSingleBattleCfg cfg)
/*     */     {
/*  73 */       int orgPoint = xRoleSingleBattle.getKilladdpoint();
/*  74 */       if (orgPoint <= 0)
/*     */       {
/*  76 */         return;
/*     */       }
/*  78 */       int cutValue = cfg.cutPointPerBeKilled;
/*  79 */       int finalPoint = orgPoint - cutValue;
/*  80 */       if (finalPoint <= 0)
/*     */       {
/*  82 */         finalPoint = 0;
/*  83 */         cutValue = orgPoint;
/*     */       }
/*     */       
/*  86 */       xRoleSingleBattle.setKilladdpoint(finalPoint);
/*     */       
/*  88 */       SingleBattleInterface.cutRolePoint(xRoleSingleBattle.getBattleid(), xRoleSingleBattle.getCampid(), this.roleId, cutValue);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void addKillPoint(RoleSingleBattle xRoleSingleBattle, SSingleBattleCfg cfg)
/*     */     {
/* 100 */       int orgPoint = xRoleSingleBattle.getKilladdpoint();
/* 101 */       int addPointMax = cfg.addKillPointMax;
/* 102 */       if (orgPoint >= addPointMax)
/*     */       {
/* 104 */         return;
/*     */       }
/* 106 */       int addValue = cfg.addPointPerKillOne;
/* 107 */       int finalPoint = orgPoint + addValue;
/* 108 */       if (finalPoint >= addPointMax)
/*     */       {
/* 110 */         finalPoint = addPointMax;
/* 111 */         addValue = addPointMax - orgPoint;
/*     */       }
/*     */       
/* 114 */       xRoleSingleBattle.setKilladdpoint(finalPoint);
/*     */       
/* 116 */       SingleBattleInterface.addRolePoint(xRoleSingleBattle.getBattleid(), xRoleSingleBattle.getCampid(), this.roleId, addValue);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\POnKillOtherInBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */