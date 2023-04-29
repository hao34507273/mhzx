/*     */ package mzm.gsp.singlebattle.buff;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.singlebattle.SBrdRoleGetBuff;
/*     */ import mzm.gsp.singlebattle.confbean.SBuffInfoCfg;
/*     */ import mzm.gsp.singlebattle.confbean.SBuffPlayCfg;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.SingleBattleBuff;
/*     */ import xbean.ZoneInfo;
/*     */ 
/*     */ public class POnRoleEnterBuffZone extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long battleid;
/*     */   private final int sortid;
/*     */   
/*     */   public POnRoleEnterBuffZone(long roleid, long battleid, int sortid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.battleid = battleid;
/*  29 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(this.battleid, true);
/*  37 */     if (globalInfo == null)
/*     */     {
/*     */ 
/*  40 */       return false;
/*     */     }
/*  42 */     int playCfgid = globalInfo.getPlayCfgId(5);
/*  43 */     if (playCfgid < 0)
/*     */     {
/*     */ 
/*  46 */       return false;
/*     */     }
/*  48 */     SBuffPlayCfg cfg = SBuffPlayCfg.get(playCfgid);
/*  49 */     if (cfg == null)
/*     */     {
/*     */ 
/*  52 */       return false;
/*     */     }
/*  54 */     SingleBattleBuff xSingleBattleBuff = xtable.Single_battle_buffs.get(Long.valueOf(this.battleid));
/*  55 */     if (xSingleBattleBuff == null)
/*     */     {
/*  57 */       GameServer.logger().info(String.format("[singlebattle]POnRoleEnterBuffZone.processImp@no single battle buff info|battle_id=%d|sort_id=%d|roleid=%d", new Object[] { Long.valueOf(this.battleid), Integer.valueOf(this.sortid), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     ZoneInfo xZoneInfo = (ZoneInfo)xSingleBattleBuff.getZone_infos().get(Integer.valueOf(this.sortid));
/*  65 */     if (xZoneInfo == null)
/*     */     {
/*     */ 
/*  68 */       return false;
/*     */     }
/*  70 */     xZoneInfo.getRole_set().add(Long.valueOf(this.roleid));
/*     */     
/*  72 */     xbean.BuffInfo xBuffInfo = (xbean.BuffInfo)xSingleBattleBuff.getBuff_infos().get(Integer.valueOf(this.sortid));
/*  73 */     if (xBuffInfo == null)
/*     */     {
/*  75 */       GameServer.logger().info(String.format("[singlebattle]POnRoleEnterBuffZone.processImp@no buff info|battle_id=%d|sort_id=%d|roleid=%d", new Object[] { Long.valueOf(this.battleid), Integer.valueOf(this.sortid), Long.valueOf(this.roleid) }));
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  82 */       if (!cfg.buff_infos.containsKey(Integer.valueOf(this.sortid)))
/*     */       {
/*     */ 
/*  85 */         return false;
/*     */       }
/*  87 */       int buffInfoCfgid = ((mzm.gsp.singlebattle.confbean.BuffInfo)cfg.buff_infos.get(Integer.valueOf(this.sortid))).buff_info_cfg_id;
/*  88 */       SBuffInfoCfg buffInfoCfg = SBuffInfoCfg.get(buffInfoCfgid);
/*  89 */       if (buffInfoCfg == null)
/*     */       {
/*     */ 
/*  92 */         return false;
/*     */       }
/*     */       
/*  95 */       BuffInterface.installBuff(this.roleid, buffInfoCfg.buff_cfg_id);
/*  96 */       MapInterface.removeMapEntity(MapEntityType.MET_SINGLE_BATTLE_BUFF, xBuffInfo.getMap_entity_instance_id(), null);
/*  97 */       xSingleBattleBuff.getBuff_infos().remove(Integer.valueOf(this.sortid));
/*     */       
/*  99 */       SBrdRoleGetBuff sBrdRoleGetBuff = new SBrdRoleGetBuff();
/* 100 */       sBrdRoleGetBuff.roleid = this.roleid;
/* 101 */       sBrdRoleGetBuff.buff_cfg_id = buffInfoCfg.buff_cfg_id;
/* 102 */       globalInfo.battleBro(sBrdRoleGetBuff, false);
/*     */       
/* 104 */       BuffManager.refreshRoleBuffInfo(this.roleid, true);
/*     */       
/* 106 */       GameServer.logger().info(String.format("[singlebattle]POnRoleEnterBuffZone.processImp@role get buff|battle_id=%d|sort_id=%d|roleid=%d|buff_info_cfg_id=%d|buff_cfg_id=%d", new Object[] { Long.valueOf(this.battleid), Integer.valueOf(this.sortid), Long.valueOf(this.roleid), Integer.valueOf(buffInfoCfgid), Integer.valueOf(buffInfoCfg.buff_cfg_id) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\POnRoleEnterBuffZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */