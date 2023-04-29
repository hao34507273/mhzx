/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STSingleBattlePlayLibCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CampInfo;
/*     */ import xbean.GlobalSingleBattleData;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleSingleBattle;
/*     */ import xbean.roleBattleData;
/*     */ import xtable.Role2singlebattle;
/*     */ 
/*     */ public class PStartSingleBattle extends mzm.gsp.util.LogicRunnable
/*     */ {
/*     */   private final int _battleCfgId;
/*     */   private final Set<Long> _roleIds_1;
/*     */   private final Set<Long> _roleIds_2;
/*     */   private final SingleBattleContext _context;
/*  28 */   private final Map<Integer, Set<Long>> _campId2roleIds = new HashMap();
/*     */   
/*  30 */   private long _battleId = -1L;
/*     */   private SSingleBattleCfg _battleCfg;
/*     */   
/*     */   public PStartSingleBattle(int battleCfgId, Set<Long> roleIds_1, Set<Long> roleIds_2, SingleBattleContext context)
/*     */   {
/*  35 */     this._battleCfgId = battleCfgId;
/*  36 */     this._roleIds_1 = roleIds_1;
/*  37 */     this._roleIds_2 = roleIds_2;
/*  38 */     this._context = context;
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  44 */     createBattle();
/*     */   }
/*     */   
/*     */ 
/*     */   void createBattle()
/*     */   {
/*  50 */     if ((!checkRoleStatus(this._roleIds_1)) || (!checkRoleStatus(this._roleIds_2)))
/*     */     {
/*  52 */       return;
/*     */     }
/*     */     
/*  55 */     if (!prepareCampData())
/*     */     {
/*  57 */       return;
/*     */     }
/*     */     
/*  60 */     prepareAllRoleData();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  65 */     addBattleShouldMembers();
/*     */   }
/*     */   
/*     */   private boolean checkRoleStatus(Set<Long> checkRoleIds)
/*     */   {
/*  70 */     for (Iterator i$ = checkRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  72 */       if (mzm.gsp.status.main.RoleStatusInterface.containsStatus(roleId, 1511))
/*     */       {
/*     */ 
/*     */ 
/*  76 */         GameServer.logger().error(String.format("[singlebattle]PStartSingleBattle.checkRoleStatus@ contains single battle status!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */         
/*     */ 
/*  79 */         return false;
/*     */       } }
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addBattleShouldMembers()
/*     */   {
/*  91 */     Set<Long> allMembers = new HashSet();
/*  92 */     allMembers.addAll(this._roleIds_1);
/*  93 */     allMembers.addAll(this._roleIds_2);
/*  94 */     SingleBattleMemberManager.getInstance().addShouldRoleIds(this._battleCfg.battleType, this._battleId, allMembers);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   CreateSingleBattleInfo getCreateSingleBattleInfo()
/*     */   {
/* 104 */     return new CreateSingleBattleInfo(this._battleCfgId, this._battleId, this._campId2roleIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean prepareCampData()
/*     */   {
/* 113 */     if (!new PrepareCampData(null).call())
/*     */     {
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     initPlays();
/*     */     
/* 120 */     startSesssions();
/*     */     
/* 122 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void startSesssions()
/*     */   {
/* 130 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 136 */         SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(PStartSingleBattle.this._battleId, true);
/* 137 */         if (globalInfo == null)
/*     */         {
/*     */ 
/* 140 */           GameServer.logger().error(String.format("[singlebattle]PStartSingleBattle.startSesssions@ globalInfo is null!|_battleId=%d", new Object[] { Long.valueOf(PStartSingleBattle.this._battleId) }));
/*     */           
/*     */ 
/* 143 */           return false;
/*     */         }
/*     */         
/* 146 */         globalInfo.setStage(1);
/*     */         
/* 148 */         globalInfo.addSessionPrepare(new SessionPrepare(PStartSingleBattle.this._battleId, SingleBattleManager.getPrepareInterval(PStartSingleBattle.this._battleCfg)).getSessionId());
/*     */         
/* 150 */         globalInfo.addSessionPlayEnd(new SessionBattleMatchEnd(PStartSingleBattle.this._battleId, SingleBattleManager.getBattleEndInterval(PStartSingleBattle.this._battleCfg)).getSessionId());
/*     */         
/*     */ 
/* 153 */         globalInfo.addSessionBattleEnd(new SessionBettleRealEnd(PStartSingleBattle.this._battleId, SingleBattleManager.getBattleOverInterval(PStartSingleBattle.this._battleCfg)).getSessionId());
/*     */         
/*     */ 
/* 156 */         new SynBattleInfoObserver(PStartSingleBattle.this._battleId, SingleBattleManager.getBattleSynInfoInterval(PStartSingleBattle.this._battleCfg));
/* 157 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */   private void initPlays()
/*     */   {
/* 164 */     STSingleBattlePlayLibCfg playLibCfg = STSingleBattlePlayLibCfg.get(this._battleCfg.playLibId);
/* 165 */     if (playLibCfg == null)
/*     */     {
/* 167 */       GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.initPlays@ STSingleBattlePlayLibCfg is null!|battleCfgId=%d|playLibId=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId) }));
/*     */       
/*     */ 
/*     */ 
/* 171 */       return;
/*     */     }
/* 173 */     for (Map.Entry<Integer, Integer> entry : playLibCfg.type2cfgId.entrySet())
/*     */     {
/* 175 */       EachPlayTypeHandler handler = SingleBattleRegisterManager.getEachPlayTypeHandler(((Integer)entry.getKey()).intValue());
/* 176 */       if (handler == null)
/*     */       {
/* 178 */         GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.initPlays@ EachPlayTypeHandler is null!|battleCfgId=%d|playLibId=%d|playType=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId), entry.getKey() }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 184 */         initEachPlayOnBattleStart(this._battleId, ((Integer)entry.getValue()).intValue(), handler);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void initEachPlayOnBattleStart(final long battleId, int playCfgId, final EachPlayTypeHandler handler) {
/* 190 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 196 */         handler.onBattleStart(battleId, this.val$playCfgId);
/* 197 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */   private class PrepareCampData extends LogicProcedure
/*     */   {
/*     */     private PrepareCampData() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 208 */       PStartSingleBattle.this._battleCfg = SSingleBattleCfg.get(PStartSingleBattle.this._battleCfgId);
/* 209 */       if (!PStartSingleBattle.this.checkParameters(PStartSingleBattle.this._battleCfg))
/*     */       {
/*     */ 
/* 212 */         return false;
/*     */       }
/*     */       
/* 215 */       randomCamp(PStartSingleBattle.this._battleCfg.camp1, PStartSingleBattle.this._battleCfg.camp2);
/*     */       
/* 217 */       createXSingleBattleGlobalData(PStartSingleBattle.this.createBattleWorld(PStartSingleBattle.this._battleCfg.fightMap));
/* 218 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void randomCamp(int camp1, int camp2)
/*     */     {
/* 229 */       if (xdb.Xdb.random().nextInt(2) == 0)
/*     */       {
/* 231 */         PStartSingleBattle.this._campId2roleIds.put(Integer.valueOf(camp1), new HashSet(PStartSingleBattle.this._roleIds_1));
/* 232 */         PStartSingleBattle.this._campId2roleIds.put(Integer.valueOf(camp2), new HashSet(PStartSingleBattle.this._roleIds_2));
/*     */       }
/*     */       else
/*     */       {
/* 236 */         PStartSingleBattle.this._campId2roleIds.put(Integer.valueOf(camp1), new HashSet(PStartSingleBattle.this._roleIds_2));
/* 237 */         PStartSingleBattle.this._campId2roleIds.put(Integer.valueOf(camp2), new HashSet(PStartSingleBattle.this._roleIds_1));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void createXSingleBattleGlobalData(long battleWorldId)
/*     */     {
/* 250 */       GlobalSingleBattleData xSingleBattleData = Pod.newGlobalSingleBattleData();
/* 251 */       xSingleBattleData.setWorld(battleWorldId);
/* 252 */       xSingleBattleData.setBattlecfgid(PStartSingleBattle.this._battleCfgId);
/* 253 */       xSingleBattleData.setStarttime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 254 */       xSingleBattleData.setContextid(SingleBattleContextContainer.getInstance().addContext(PStartSingleBattle.this._context));
/* 255 */       initRoleState(xSingleBattleData);
/*     */       
/* 257 */       PStartSingleBattle.this._battleId = xtable.Singlebattle.insert(xSingleBattleData).longValue();
/*     */     }
/*     */     
/*     */ 
/*     */     private void initRoleState(GlobalSingleBattleData xSingleBattleData)
/*     */     {
/* 263 */       for (Map.Entry<Integer, Set<Long>> entry : PStartSingleBattle.this._campId2roleIds.entrySet())
/*     */       {
/* 265 */         CampInfo xCampData = Pod.newCampInfo();
/* 266 */         for (Iterator i$ = ((Set)entry.getValue()).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/*     */ 
/* 269 */           roleBattleData xRoleBattleData = Pod.newroleBattleData();
/* 270 */           xRoleBattleData.setState(2);
/* 271 */           xCampData.getRolebattledatas().put(Long.valueOf(roleId), xRoleBattleData);
/*     */         }
/* 273 */         xSingleBattleData.getCampinfos().put(entry.getKey(), xCampData);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   long createBattleWorld(int mapId)
/*     */   {
/* 280 */     long world = mzm.gsp.map.main.MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(mapId) }));
/*     */     
/*     */ 
/*     */ 
/* 284 */     return world;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void prepareAllRoleData()
/*     */   {
/* 292 */     if (this._battleId <= 0L)
/*     */     {
/* 294 */       GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.prepareAllRoleData@ battleId is null!|battleCfgId=%d", new Object[] { Integer.valueOf(this._battleCfgId) }));
/*     */       
/*     */ 
/* 297 */       return;
/*     */     }
/* 299 */     for (Map.Entry<Integer, Set<Long>> entry : this._campId2roleIds.entrySet())
/*     */     {
/* 301 */       campId = ((Integer)entry.getKey()).intValue();
/* 302 */       num = 1;
/* 303 */       for (i$ = ((Set)entry.getValue()).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 305 */         new PrepareRoleData(roleId, campId, num, this._battleId).call();
/* 306 */         num++;
/*     */       }
/*     */     }
/*     */     int campId;
/*     */     int num;
/*     */     Iterator i$;
/*     */   }
/*     */   
/*     */   private class PrepareRoleData extends LogicProcedure {
/*     */     private final long roleId;
/*     */     private final int campId;
/*     */     private final int number;
/*     */     private final long battleId;
/*     */     
/* 320 */     PrepareRoleData(long roleId, int campId, int number, long battleId) { this.roleId = roleId;
/* 321 */       this.campId = campId;
/* 322 */       this.number = number;
/* 323 */       this.battleId = battleId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 330 */       lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 333 */       RoleSingleBattle xRoleSingleBattle = Role2singlebattle.get(Long.valueOf(this.roleId));
/* 334 */       if (xRoleSingleBattle != null)
/*     */       {
/* 336 */         GameServer.logger().error(String.format("[singleBattle]PrepareRoleData.processImp@ xRoleSingleBattle not null!|battleCfgId=%d|roleId=%d|oldBattleId=%d|oldBattleCfgId=%d", new Object[] { Integer.valueOf(PStartSingleBattle.this._battleCfgId), Long.valueOf(this.roleId), Long.valueOf(xRoleSingleBattle.getBattleid()), Integer.valueOf(xRoleSingleBattle.getBattlecfgid()) }));
/*     */         
/*     */ 
/*     */ 
/* 340 */         Role2singlebattle.delete(Long.valueOf(this.roleId));
/*     */       }
/*     */       
/* 343 */       xRoleSingleBattle = Pod.newRoleSingleBattle();
/* 344 */       xRoleSingleBattle.setBattlecfgid(PStartSingleBattle.this._battleCfgId);
/* 345 */       xRoleSingleBattle.setBattleid(this.battleId);
/* 346 */       xRoleSingleBattle.setCampid(this.campId);
/* 347 */       xRoleSingleBattle.setNumber(this.number);
/*     */       
/*     */ 
/* 350 */       Role2singlebattle.insert(Long.valueOf(this.roleId), xRoleSingleBattle);
/* 351 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkParameters(SSingleBattleCfg battleCfg)
/*     */   {
/* 364 */     if (battleCfg == null)
/*     */     {
/* 366 */       GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.checkParameters@ single battle cfg is not exist!|battleCfgId=%d", new Object[] { Integer.valueOf(this._battleCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 370 */       return false;
/*     */     }
/* 372 */     if ((this._roleIds_1.size() == 0) || (this._roleIds_2.size() == 0))
/*     */     {
/* 374 */       GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.checkParameters@ against camp roleList's size is zero!|battleCfgId=%d|roleIds_1=%s|roleIds_2=%s", new Object[] { Integer.valueOf(this._battleCfgId), this._roleIds_1, this._roleIds_2 }));
/*     */       
/*     */ 
/*     */ 
/* 378 */       return false;
/*     */     }
/* 380 */     if (this._context == null)
/*     */     {
/* 382 */       GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.checkParameters@ context is null!|battleCfgId=%d|roleIds_1=%s|roleIds_2=%s", new Object[] { Integer.valueOf(this._battleCfgId), this._roleIds_1, this._roleIds_2 }));
/*     */       
/*     */ 
/*     */ 
/* 386 */       return false;
/*     */     }
/* 388 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\PStartSingleBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */