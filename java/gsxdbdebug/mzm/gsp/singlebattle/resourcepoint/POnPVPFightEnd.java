/*     */ package mzm.gsp.singlebattle.resourcepoint;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.singlebattle.SSynResourcePointUpdateInfo;
/*     */ import mzm.gsp.singlebattle.confbean.SResourcePointCfg;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleFightContext;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import xbean.ResourcePoint;
/*     */ import xbean.RoleResourcePointInfo;
/*     */ import xtable.Resource_points;
/*     */ 
/*     */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     if ((!(((PVPFightEndArg)this.arg).context instanceof SingleBattleFightContext)) || (((PVPFightEndArg)this.arg).fightReason != FightReason.SINGLE_BATTLE_FIGHT.value))
/*     */     {
/*     */ 
/*  24 */       return false;
/*     */     }
/*  26 */     SingleBattleFightContext context = (SingleBattleFightContext)((PVPFightEndArg)this.arg).context;
/*  27 */     int cfgid = context.getPlayCfgId(3);
/*  28 */     if (cfgid < 0)
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     SResourcePointCfg cfg = SResourcePointCfg.get(cfgid);
/*  33 */     if (cfg == null)
/*     */     {
/*     */ 
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if ((((PVPFightEndArg)this.arg).activeRoleList.size() != 1) || (((PVPFightEndArg)this.arg).passiveRoleList.size() != 1))
/*     */     {
/*     */ 
/*  42 */       return false;
/*     */     }
/*  44 */     long activeRoleid = ((Long)((PVPFightEndArg)this.arg).activeRoleList.get(0)).longValue();
/*  45 */     long passiveRoleid = ((Long)((PVPFightEndArg)this.arg).passiveRoleList.get(0)).longValue();
/*     */     
/*     */ 
/*  48 */     ResourcePoint xResourcePoint = Resource_points.get(Long.valueOf(context.getBattleId()));
/*  49 */     if (xResourcePoint == null)
/*     */     {
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     RoleResourcePointInfo xActiveRoleResourcePointInfo = (RoleResourcePointInfo)xResourcePoint.getRole_resource_point_infos().get(Long.valueOf(activeRoleid));
/*     */     
/*  57 */     if (xActiveRoleResourcePointInfo == null)
/*     */     {
/*     */ 
/*  60 */       return false;
/*     */     }
/*  62 */     RoleResourcePointInfo xPassiveRoleResourcePointInfo = (RoleResourcePointInfo)xResourcePoint.getRole_resource_point_infos().get(Long.valueOf(passiveRoleid));
/*     */     
/*  64 */     if (xPassiveRoleResourcePointInfo == null)
/*     */     {
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     int activeRoleOriginalResourcePoint = xActiveRoleResourcePointInfo.getResource_point();
/*  70 */     int passiveRoleOriginalResourcePoint = xPassiveRoleResourcePointInfo.getResource_point();
/*     */     
/*  72 */     int changePoint = 0;
/*  73 */     if (cfg.grab_resource_point_per_fight > 0)
/*     */     {
/*  75 */       if (((PVPFightEndArg)this.arg).isActiveWin)
/*     */       {
/*  77 */         if ((xActiveRoleResourcePointInfo.getResource_point() < cfg.max_resource_point) && (xPassiveRoleResourcePointInfo.getResource_point() > cfg.min_resource_point))
/*     */         {
/*     */ 
/*  80 */           changePoint = Math.min(Math.min(cfg.max_resource_point - xActiveRoleResourcePointInfo.getResource_point(), xPassiveRoleResourcePointInfo.getResource_point() - cfg.min_resource_point), cfg.grab_resource_point_per_fight);
/*     */           
/*     */ 
/*  83 */           xActiveRoleResourcePointInfo.setResource_point(xActiveRoleResourcePointInfo.getResource_point() + changePoint);
/*     */           
/*  85 */           xPassiveRoleResourcePointInfo.setResource_point(xPassiveRoleResourcePointInfo.getResource_point() - changePoint);
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*  91 */       else if ((xPassiveRoleResourcePointInfo.getResource_point() < cfg.max_resource_point) && (xActiveRoleResourcePointInfo.getResource_point() > cfg.min_resource_point))
/*     */       {
/*     */ 
/*  94 */         changePoint = Math.min(Math.min(cfg.max_resource_point - xPassiveRoleResourcePointInfo.getResource_point(), xActiveRoleResourcePointInfo.getResource_point() - cfg.min_resource_point), cfg.grab_resource_point_per_fight);
/*     */         
/*     */ 
/*  97 */         xPassiveRoleResourcePointInfo.setResource_point(xPassiveRoleResourcePointInfo.getResource_point() + changePoint);
/*     */         
/*  99 */         xActiveRoleResourcePointInfo.setResource_point(xActiveRoleResourcePointInfo.getResource_point() - changePoint);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 105 */     if (changePoint > 0)
/*     */     {
/* 107 */       SSynResourcePointUpdateInfo protocol = new SSynResourcePointUpdateInfo();
/* 108 */       protocol.reason = 1;
/* 109 */       protocol.resource_point_update_infos.put(Long.valueOf(activeRoleid), Integer.valueOf(xActiveRoleResourcePointInfo.getResource_point()));
/* 110 */       protocol.resource_point_update_infos.put(Long.valueOf(passiveRoleid), Integer.valueOf(xPassiveRoleResourcePointInfo.getResource_point()));
/* 111 */       protocol.long_extra_infos.put(Integer.valueOf(0), Long.valueOf(((PVPFightEndArg)this.arg).isActiveWin ? activeRoleid : passiveRoleid));
/*     */       
/* 113 */       protocol.long_extra_infos.put(Integer.valueOf(1), Long.valueOf(!((PVPFightEndArg)this.arg).isActiveWin ? activeRoleid : passiveRoleid));
/*     */       
/* 115 */       SingleBattleInterface.battleBro(context.getBattleId(), protocol, false);
/*     */     }
/*     */     
/* 118 */     GameServer.logger().info(String.format("[resourcepoint]POnPVPFightEnd.processImp@pvp fight end process|active_roleid=%d|passive_roleid=%d|change_point=%d|active_role_original_point=%d|active_role_point=%d|passive_role_original_point=%d|passive_role_point=%d", new Object[] { Long.valueOf(activeRoleid), Long.valueOf(passiveRoleid), Integer.valueOf(changePoint), Integer.valueOf(activeRoleOriginalResourcePoint), Integer.valueOf(xActiveRoleResourcePointInfo.getResource_point()), Integer.valueOf(passiveRoleOriginalResourcePoint), Integer.valueOf(xPassiveRoleResourcePointInfo.getResource_point()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\resourcepoint\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */