/*     */ package mzm.gsp.singlebattle.grab;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.singlebattle.SSynGrapPositionRes;
/*     */ import mzm.gsp.singlebattle.confbean.SPositionInfoCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STGrabPositionCfg;
/*     */ import mzm.gsp.singlebattle.confbean.SingleBattleConsts;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleGrabData;
/*     */ import xbean.GrabPositionData;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleGrabData;
/*     */ import xtable.Grabposition;
/*     */ import xtable.Role2rolegrabdata;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GrabPlayHandlerImpl
/*     */ {
/*     */   static void onBattleStart(long battleId, int playCfgId)
/*     */   {
/*  41 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(battleId, true);
/*  42 */     if (globalInfo == null)
/*     */     {
/*  44 */       GameServer.logger().error(String.format("[grab]GrabPlayHandlerImpl.onBattleStart@ no globalInfo!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */       
/*     */ 
/*  47 */       return;
/*     */     }
/*  49 */     long worldId = globalInfo.getBattleWorldId();
/*  50 */     if (worldId <= 0L)
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[grab]GrabPlayHandlerImpl.onBattleStart@ no worldId!|battleId=%d|playCfgId=%d|world=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Long.valueOf(worldId) }));
/*     */       
/*     */ 
/*  55 */       return;
/*     */     }
/*  57 */     STGrabPositionCfg cfg = STGrabPositionCfg.get(playCfgId);
/*  58 */     if (cfg == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[grab]GrabPlayHandlerImpl.onBattleStart@ no STGrabPositionCfg!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */       
/*     */ 
/*  63 */       return;
/*     */     }
/*     */     
/*  66 */     BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(battleId));
/*  67 */     if (xBattleGrabData != null)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[grab]GrabPlayHandlerImpl.onBattleStart@ xBattleGrabData not null!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  74 */       Grabposition.remove(Long.valueOf(battleId));
/*     */     }
/*  76 */     Grabposition.insert(Long.valueOf(battleId), xBattleGrabData = Pod.newBattleGrabData());
/*  77 */     for (Iterator i$ = cfg.positionDatas.iterator(); i$.hasNext();) { int positionCfgId = ((Integer)i$.next()).intValue();
/*     */       
/*  79 */       GrabPositionData xGrabPositionData = Pod.newGrabPositionData();
/*  80 */       xGrabPositionData.setState(1);
/*  81 */       xGrabPositionData.setInstanceid(GlobalPositionData.getNewPositionId());
/*  82 */       xBattleGrabData.getPositiondatas().put(Integer.valueOf(positionCfgId), xGrabPositionData);
/*     */       
/*     */ 
/*  85 */       SPositionInfoCfg positionInfoCfg = SPositionInfoCfg.get(positionCfgId);
/*  86 */       if (positionInfoCfg == null)
/*     */       {
/*  88 */         GameServer.logger().error(String.format("[grab]GrabPlayHandlerImpl.onBattleStart@ positionInfoCfg is null!|battleId=%d|playCfgId=%d|positionCfgId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Integer.valueOf(positionCfgId) }));
/*     */         
/*     */ 
/*     */ 
/*  92 */         return;
/*     */       }
/*  94 */       Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/*  95 */       intExtraInfoEntries.put(Integer.valueOf(1300), Integer.valueOf(0));
/*  96 */       MapInterface.addMapEntity(MapEntityType.MET_SINGLE_BATTLE_POSITION, xGrabPositionData.getInstanceid(), worldId, globalInfo.getBattleMapId(), positionInfoCfg.positionX, positionInfoCfg.positionY, positionCfgId, intExtraInfoEntries, null, null, new MapCallback()
/*     */       {
/*     */ 
/*     */ 
/*     */         public boolean onResult(Boolean result)
/*     */         {
/*     */ 
/*     */ 
/* 104 */           GameServer.logger().info(String.format("[singleBattle]onBattleStart.MapCallback@ create map entity!|battleId=%d|positionCfgId=%d|result=%s", new Object[] { Long.valueOf(this.val$battleId), Integer.valueOf(this.val$positionCfgId), result }));
/*     */           
/*     */ 
/*     */ 
/* 108 */           return true;
/*     */         }
/*     */         
/*     */ 
/*     */         public boolean isCallInProcedure()
/*     */         {
/* 114 */           return false;
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */ 
/* 120 */     new SynGrabSourceObserver(battleId, SingleBattleConsts.getInstance().positionSourceCalInterval);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onRoleJoinBattle(long battleId, int playCfgId, long roleId)
/*     */   {
/* 141 */     long roleBattleId = SingleBattleInterface.getBattleId(roleId, false);
/* 142 */     if (roleBattleId != battleId)
/*     */     {
/* 144 */       GameServer.logger().error(String.format("[grab]GrabPlayHandlerImpl.onRoleJoinBattle@ not in this battle!!!!|battleId=%d|playCfgId=%d|roleId=%d|roleBattleid=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Long.valueOf(roleId), Long.valueOf(roleBattleId) }));
/*     */       
/*     */ 
/*     */ 
/* 148 */       return;
/*     */     }
/*     */     
/* 151 */     BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(battleId));
/* 152 */     if (xBattleGrabData == null)
/*     */     {
/* 154 */       GameServer.logger().error(String.format("[grab]GrabPlayHandlerImpl.onRoleJoinBattle@ xBattleGrabData is null!|battleId=%d|playCfgId=%d|roleId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 158 */       return;
/*     */     }
/* 160 */     RoleGrabData xRoleGrabData = Role2rolegrabdata.get(Long.valueOf(roleId));
/* 161 */     if (xRoleGrabData != null)
/*     */     {
/* 163 */       GameServer.logger().error(String.format("[grab]GrabPlayHandlerImpl.onRoleJoinBattle@ xRoleGrabData is not null!|battleId=%d|playCfgId=%d|roleId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 168 */       Role2rolegrabdata.remove(Long.valueOf(roleId));
/*     */     }
/* 170 */     Role2rolegrabdata.insert(Long.valueOf(roleId), xRoleGrabData = Pod.newRoleGrabData());
/*     */     
/*     */ 
/* 173 */     GrabPositionManager.synBattlePositionInfo(xBattleGrabData, roleId);
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
/*     */   static void onRoleQuitBattle(long battleId, int playCfgId, long roleId, SingleBattleInterface.LeaveBattleReason leaveReason)
/*     */   {
/* 186 */     RoleGrabData xRoleGrabData = Role2rolegrabdata.get(Long.valueOf(roleId));
/* 187 */     if (xRoleGrabData == null)
/*     */     {
/* 189 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ no xRoleGrabData!|battleId=%d|roleId=%d|leaveReason=%s", new Object[] { Long.valueOf(battleId), Long.valueOf(roleId), leaveReason }));
/*     */       
/*     */ 
/* 192 */       return;
/*     */     }
/*     */     
/* 195 */     RoleStatusInterface.unsetStatus(roleId, 1514);
/* 196 */     if (xRoleGrabData.getGrabpositionid() > 0)
/*     */     {
/*     */ 
/* 199 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ is graping!|battleId=%d|roleId=%d|leaveReason=%s", new Object[] { Long.valueOf(battleId), Long.valueOf(roleId), leaveReason }));
/*     */     }
/*     */     
/*     */ 
/* 203 */     Role2rolegrabdata.remove(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */   static void onMatchEnd(long battleId, int playCfgId)
/*     */   {
/* 209 */     BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(battleId));
/* 210 */     if (xBattleGrabData == null)
/*     */     {
/* 212 */       GameServer.logger().error(String.format("[grab]onMatchEnd.processImp@ no grab position data!|battleId=%d", new Object[] { Long.valueOf(battleId) }));
/*     */       
/* 214 */       return;
/*     */     }
/*     */     
/* 217 */     for (Map.Entry<Integer, GrabPositionData> entry : xBattleGrabData.getPositiondatas().entrySet())
/*     */     {
/* 219 */       GrabPositionData xGrabPositionData = (GrabPositionData)entry.getValue();
/* 220 */       if (xGrabPositionData.getState() == 2)
/*     */       {
/*     */ 
/*     */ 
/* 224 */         new PStopGrab(xGrabPositionData.getGrabingroleid(), 3).execute();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void onStartClean(long battleId, int playCfgId)
/*     */   {
/* 231 */     BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(battleId));
/* 232 */     if (xBattleGrabData == null)
/*     */     {
/* 234 */       GameServer.logger().error(String.format("[grab]onStartClean.processImp@ no grab position data!|battleId=%d", new Object[] { Long.valueOf(battleId) }));
/*     */       
/* 236 */       return;
/*     */     }
/* 238 */     Map<Long, Pair<Integer, Long>> role2positions = new HashMap();
/* 239 */     fillFirstGrabInfo(xBattleGrabData, role2positions);
/*     */     
/* 241 */     SSynGrapPositionRes res = new SSynGrapPositionRes();
/* 242 */     for (Map.Entry<Long, Pair<Integer, Long>> entry : role2positions.entrySet())
/*     */     {
/* 244 */       res.position2firstblood.put(((Pair)entry.getValue()).first, entry.getKey());
/*     */     }
/*     */     
/* 247 */     SingleBattleInterface.battleBro(battleId, res, false);
/*     */   }
/*     */   
/*     */   private static void fillFirstGrabInfo(BattleGrabData xBattleGrabData, Map<Long, Pair<Integer, Long>> role2positions)
/*     */   {
/* 252 */     for (Map.Entry<Integer, GrabPositionData> entry : xBattleGrabData.getPositiondatas().entrySet())
/*     */     {
/* 254 */       int positionId = ((Integer)entry.getKey()).intValue();
/* 255 */       GrabPositionData xGrabPositionData = (GrabPositionData)entry.getValue();
/*     */       
/* 257 */       long firstRoleId = xGrabPositionData.getFirstgrabroleid();
/* 258 */       if (firstRoleId > 0L)
/*     */       {
/*     */ 
/*     */ 
/* 262 */         Pair<Integer, Long> pair = (Pair)role2positions.get(Long.valueOf(firstRoleId));
/* 263 */         if ((pair == null) || (((Long)pair.second).longValue() > xGrabPositionData.getFirstgrabtime()))
/*     */         {
/* 265 */           role2positions.put(Long.valueOf(firstRoleId), new Pair(Integer.valueOf(positionId), Long.valueOf(xGrabPositionData.getFirstgrabtime())));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onBattleEnd(long battleId, int playCfgId)
/*     */   {
/* 279 */     BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(battleId));
/* 280 */     if (xBattleGrabData == null)
/*     */     {
/* 282 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ no grab position data!|battleId=%d", new Object[] { Long.valueOf(battleId) }));
/*     */       
/* 284 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 289 */     Grabposition.remove(Long.valueOf(battleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\GrabPlayHandlerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */