/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.MapFightContext.EXTRADATA_TYPE;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SDeamonTransferMapCfg;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2jiuxiao;
/*     */ 
/*     */ public class PCLuanShiYaoMoNpcFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   
/*     */   public PCLuanShiYaoMoNpcFight(long roleid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     int mapcfgid = MapInterface.getRoleMapId(this.roleid);
/*  31 */     SDeamonTransferMapCfg deamonTransferMapCfg = SDeamonTransferMapCfg.get(mapcfgid);
/*  32 */     if (deamonTransferMapCfg == null) {
/*  33 */       GameServer.logger().info(String.format("[PCLuanShiYaoMoNpcFight]PCLuanShiYaoMoNpcFight.processImp@role map config id is wrong|roleid=%d|mapcfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(mapcfgid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  38 */       return false;
/*     */     }
/*  40 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 93, true)) {
/*  41 */       return false;
/*     */     }
/*  43 */     int npcid = deamonTransferMapCfg.npcid;
/*  44 */     List<Integer> fightids = deamonTransferMapCfg.fightids;
/*  45 */     int serviceid = deamonTransferMapCfg.npcServiceid;
/*  46 */     if ((deamonTransferMapCfg.skyNpcid > 0) && (deamonTransferMapCfg.skyFightids.size() > 0) && 
/*  47 */       (RoleStatusInterface.containsStatus(this.roleid, 2))) {
/*  48 */       npcid = deamonTransferMapCfg.skyNpcid;
/*  49 */       fightids = deamonTransferMapCfg.skyFightids;
/*  50 */       serviceid = deamonTransferMapCfg.skyNpcServiceid;
/*     */     }
/*     */     
/*     */ 
/*  54 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(npcid, serviceid, this.roleid)) {
/*  55 */       GameServer.logger().info(String.format("[PCLuanShiYaoMoNpcFight]PCLuanShiYaoMoNpcFight.processImp@npc service not useable|roleid=%d|mapCfgid=%d|npcid=%d|serviceid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(mapcfgid), Integer.valueOf(deamonTransferMapCfg.npcid), Integer.valueOf(serviceid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     List<Long> normalList = new ArrayList();
/*  64 */     List<Long> beforeTeamList = TeamInterface.getNormalRoleList(this.roleid);
/*  65 */     normalList.addAll(beforeTeamList);
/*  66 */     if (normalList.size() <= 0) {
/*  67 */       normalList.add(Long.valueOf(this.roleid));
/*     */     }
/*  69 */     if (((Long)normalList.get(0)).longValue() != this.roleid)
/*     */     {
/*  71 */       if (normalList.contains(Long.valueOf(this.roleid))) {
/*  72 */         GameServer.logger().info(String.format("[PCLuanShiYaoMoNpcFight]PCLuanShiYaoMoNpcFight.processImp@role is not teamLeader|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  77 */         return false;
/*     */       }
/*     */       
/*  80 */       normalList.clear();
/*  81 */       normalList.add(Long.valueOf(this.roleid));
/*     */     }
/*  83 */     lock(Role2jiuxiao.getTable(), normalList);
/*     */     
/*  85 */     List<Long> tmpNormalList = TeamInterface.getNormalRoleList(this.roleid);
/*  86 */     if ((tmpNormalList.size() != beforeTeamList.size()) || (!tmpNormalList.containsAll(beforeTeamList))) {
/*  87 */       GameServer.logger().info(String.format("[PCLuanShiYaoMoNpcFight]PCLuanShiYaoMoNpcFight.processImp@team changed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     VisibleMonsterFightHandler.asynInitActivtyData(this.roleid, SLuanShiYaoMoConsts.getInstance().ACTIVITYID);
/*  94 */     int idx = xdb.Xdb.random().nextInt(fightids.size());
/*  95 */     int id = ((Integer)fightids.get(idx)).intValue();
/*  96 */     MapVisibleMonsterFightContext context = new MapVisibleMonsterFightContext(this.roleid, -1, -1, -1, MapInterface.getCenterWorldid());
/*     */     
/*  98 */     context.putExtra(MapFightContext.EXTRADATA_TYPE.ENTER_FIGHT_LOW_LEVEL_LIMIT, deamonTransferMapCfg.awardLevel);
/*  99 */     FightInterface.startPVEFight(this.roleid, id, context, FightReason.LUANSHIYAOMO_FIGHT);
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\PCLuanShiYaoMoNpcFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */