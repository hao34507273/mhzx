/*     */ package mzm.gsp.singlebattle.buff;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.singlebattle.SRoleBuffInfo;
/*     */ import mzm.gsp.singlebattle.confbean.SBuffPlayCfg;
/*     */ import mzm.gsp.singlebattle.main.BattleTaskOneByOne;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.SingleBattleBuff;
/*     */ import xbean.ZoneInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Single_battle_buffs;
/*     */ 
/*     */ public class BuffManager
/*     */ {
/*  29 */   private static AtomicLong idGenerator = new AtomicLong(0L);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getMapEntityInstanceid()
/*     */   {
/*  38 */     return idGenerator.incrementAndGet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void refreshBuff(long battleid, boolean initial)
/*     */   {
/*  50 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(battleid, true);
/*  51 */     if (globalInfo == null)
/*     */     {
/*     */ 
/*  54 */       return;
/*     */     }
/*  56 */     int playCfgid = globalInfo.getPlayCfgId(5);
/*  57 */     if (playCfgid < 0)
/*     */     {
/*     */ 
/*  60 */       return;
/*     */     }
/*  62 */     SBuffPlayCfg cfg = SBuffPlayCfg.get(playCfgid);
/*  63 */     if (cfg == null)
/*     */     {
/*     */ 
/*  66 */       return;
/*     */     }
/*  68 */     SingleBattleBuff xSingleBattleBuff = Single_battle_buffs.get(Long.valueOf(battleid));
/*  69 */     if (xSingleBattleBuff == null)
/*     */     {
/*  71 */       xSingleBattleBuff = Pod.newSingleBattleBuff();
/*  72 */       Single_battle_buffs.insert(Long.valueOf(battleid), xSingleBattleBuff);
/*     */     }
/*  74 */     int sceneid = MapInterface.getSceneInstanceId(globalInfo.getBattleWorldId(), globalInfo.getBattleMapId(), false);
/*  75 */     for (Map.Entry<Integer, mzm.gsp.singlebattle.confbean.BuffInfo> entry : cfg.buff_infos.entrySet())
/*     */     {
/*  77 */       int sortid = ((Integer)entry.getKey()).intValue();
/*  78 */       mzm.gsp.singlebattle.confbean.BuffInfo buffInfo = (mzm.gsp.singlebattle.confbean.BuffInfo)entry.getValue();
/*  79 */       if (initial)
/*     */       {
/*  81 */         BuffZoneForm buffZoneForm = new BuffZoneForm(buffInfo.x, buffInfo.y, buffInfo.radius, battleid, sortid);
/*  82 */         MapInterface.registerZoneEvent(sceneid, buffZoneForm, 3, new BuffZoneListener(), new RegisterZoneEventCallBack(battleid, sortid));
/*     */         
/*     */ 
/*  85 */         ZoneInfo xZoneInfo = Pod.newZoneInfo();
/*  86 */         xSingleBattleBuff.getZone_infos().put(Integer.valueOf(sortid), xZoneInfo);
/*     */       }
/*     */       
/*  89 */       long mapEntityInstanceid = getMapEntityInstanceid();
/*  90 */       MapInterface.addMapEntity(MapEntityType.MET_SINGLE_BATTLE_BUFF, mapEntityInstanceid, globalInfo.getBattleWorldId(), globalInfo.getBattleMapId(), buffInfo.x, buffInfo.y, buffInfo.buff_info_cfg_id, null, null, null, null);
/*     */       
/*     */ 
/*  93 */       xbean.BuffInfo xBuffInfo = Pod.newBuffInfo();
/*  94 */       xBuffInfo.setMap_entity_instance_id(mapEntityInstanceid);
/*  95 */       xSingleBattleBuff.getBuff_infos().put(Integer.valueOf(sortid), xBuffInfo);
/*     */       
/*  97 */       ZoneInfo xZoneInfo = (ZoneInfo)xSingleBattleBuff.getZone_infos().get(Integer.valueOf(sortid));
/*  98 */       long roleid = randomGetElement(xZoneInfo.getRole_set());
/*  99 */       if (roleid > 0L)
/*     */       {
/* 101 */         BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(battleid), new POnRoleEnterBuffZone(roleid, battleid, sortid));
/*     */       }
/*     */     }
/* 104 */     if (xSingleBattleBuff.getSession() != null)
/*     */     {
/* 106 */       xSingleBattleBuff.getSession().stopTimer();
/*     */     }
/* 108 */     xSingleBattleBuff.setSession(new RemoveBuffSession(cfg.disappear_interval_in_minute * 60L, battleid));
/* 109 */     GameServer.logger().info(String.format("[singlebattle]BuffManager.refreshBuff@refresh buff|battle_id=%d|initial=%b", new Object[] { Long.valueOf(battleid), Boolean.valueOf(initial) }));
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
/*     */   static void removeBuff(long battleid, boolean startSession)
/*     */   {
/* 122 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(battleid, true);
/* 123 */     if (globalInfo == null)
/*     */     {
/*     */ 
/* 126 */       return;
/*     */     }
/* 128 */     int playCfgid = globalInfo.getPlayCfgId(5);
/* 129 */     if (playCfgid < 0)
/*     */     {
/*     */ 
/* 132 */       return;
/*     */     }
/* 134 */     SBuffPlayCfg cfg = SBuffPlayCfg.get(playCfgid);
/* 135 */     if (cfg == null)
/*     */     {
/*     */ 
/* 138 */       return;
/*     */     }
/* 140 */     SingleBattleBuff xSingleBattleBuff = Single_battle_buffs.get(Long.valueOf(battleid));
/* 141 */     if (xSingleBattleBuff == null)
/*     */     {
/*     */ 
/* 144 */       return;
/*     */     }
/* 146 */     int sceneid = MapInterface.getSceneInstanceId(globalInfo.getBattleWorldId(), globalInfo.getBattleMapId(), false);
/* 147 */     if (!startSession)
/*     */     {
/* 149 */       for (ZoneInfo xZoneInfo : xSingleBattleBuff.getZone_infos().values())
/*     */       {
/* 151 */         MapInterface.unregisterZoneEvent(sceneid, xZoneInfo.getEventid());
/*     */       }
/*     */     }
/* 154 */     for (xbean.BuffInfo xBuffInfo : xSingleBattleBuff.getBuff_infos().values())
/*     */     {
/* 156 */       MapInterface.removeMapEntity(MapEntityType.MET_SINGLE_BATTLE_BUFF, xBuffInfo.getMap_entity_instance_id(), null);
/*     */     }
/* 158 */     xSingleBattleBuff.getBuff_infos().clear();
/* 159 */     if (xSingleBattleBuff.getSession() != null)
/*     */     {
/* 161 */       xSingleBattleBuff.getSession().stopTimer();
/*     */     }
/* 163 */     if (startSession)
/*     */     {
/* 165 */       long interval = (cfg.min_refresh_interval_in_minute - cfg.disappear_interval_in_minute) * 60L + Xdb.random().nextInt((cfg.max_refresh_interval_in_minute - cfg.min_refresh_interval_in_minute) * 60);
/*     */       
/* 167 */       xSingleBattleBuff.setSession(new RefreshBuffSession(interval, battleid));
/*     */     }
/* 169 */     GameServer.logger().info(String.format("[singlebattle]BuffManager.removeBuff@remove buff|battle_id=%d|start_session=%b", new Object[] { Long.valueOf(battleid), Boolean.valueOf(startSession) }));
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
/*     */   static void refreshRoleBuffInfo(long roleid, boolean retainRoleLock)
/*     */   {
/* 183 */     List<Integer> allBuffCfgids = new ArrayList();
/* 184 */     allBuffCfgids.addAll(mzm.gsp.singlebattle.confbean.BuffCfgid2InfoCfgidCfg.getAll().keySet());
/* 185 */     List<Integer> buffCfgids = mzm.gsp.buff.main.BuffInterface.contains(roleid, allBuffCfgids, retainRoleLock);
/* 186 */     if (buffCfgids.isEmpty())
/*     */     {
/* 188 */       MapInterface.unSetModelProtocol(roleid, 12621599);
/* 189 */       GameServer.logger().info(String.format("[singlebattle]BuffManager.refreshRoleBuffInfo@remove role buff info|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/* 191 */       return;
/*     */     }
/* 193 */     SRoleBuffInfo protocol = new SRoleBuffInfo();
/* 194 */     protocol.buff_cfg_ids.addAll(buffCfgids);
/* 195 */     MapInterface.setModelProtocol(roleid, protocol);
/* 196 */     GameServer.logger().info(String.format("[singlebattle]BuffManager.refreshRoleBuffInfo@refresh role buff info|roleid=%d|buff_cfg_ids=%s", new Object[] { Long.valueOf(roleid), buffCfgids }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeRoleBuffInfo(long roleid)
/*     */   {
/* 208 */     MapInterface.unSetModelProtocol(roleid, 12621599);
/* 209 */     GameServer.logger().info(String.format("[singlebattle]BuffManager.removeRoleBuffInfo@remove role buff info|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */   }
/*     */   
/*     */ 
/*     */   private static long randomGetElement(Set<Long> _set)
/*     */   {
/* 215 */     if ((_set == null) || (_set.isEmpty()))
/*     */     {
/* 217 */       return -1L;
/*     */     }
/* 219 */     List<Long> _list = new ArrayList();
/* 220 */     _list.addAll(_set);
/* 221 */     return ((Long)_list.get(Xdb.random().nextInt(_list.size()))).longValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\BuffManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */