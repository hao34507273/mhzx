/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.map.main.MapFightContext.EXTRADATA_TYPE;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SYaoShouTuXiConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ import xtable.Role2jiuxiao;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PYaoShouTuXiNPCStartFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PYaoShouTuXiNPCStartFight(long roleId)
/*    */   {
/* 34 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 39 */     if (!NpcInterface.checkNpcService(SYaoShouTuXiConsts.getInstance().NPCID, 150200038, this.roleId))
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 94, true)) {
/* 44 */       return false;
/*    */     }
/* 46 */     List<Long> normalList = new ArrayList();
/* 47 */     List<Long> beforeTeamList = TeamInterface.getNormalRoleList(this.roleId);
/* 48 */     normalList.addAll(beforeTeamList);
/* 49 */     if (normalList.size() <= 0) {
/* 50 */       normalList.add(Long.valueOf(this.roleId));
/*    */     }
/* 52 */     if (((Long)normalList.get(0)).longValue() != this.roleId)
/*    */     {
/* 54 */       if (normalList.contains(Long.valueOf(this.roleId))) {
/* 55 */         GameServer.logger().info(String.format("[PCLuanShiYaoMoNpcFight]PCLuanShiYaoMoNpcFight.processImp@role is not teamLeader|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 60 */         return false;
/*    */       }
/*    */       
/* 63 */       normalList.clear();
/* 64 */       normalList.add(Long.valueOf(this.roleId));
/*    */     }
/* 66 */     lock(Role2jiuxiao.getTable(), normalList);
/*    */     
/* 68 */     List<Long> tmpNormalList = TeamInterface.getNormalRoleList(this.roleId);
/* 69 */     if ((tmpNormalList.size() != beforeTeamList.size()) || (!tmpNormalList.containsAll(beforeTeamList))) {
/* 70 */       GameServer.logger().info(String.format("[PCLuanShiYaoMoNpcFight]PCLuanShiYaoMoNpcFight.processImp@team changed|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/*    */ 
/* 73 */       return false;
/*    */     }
/* 75 */     if (!ItemInterface.removeItemById(this.roleId, 340600000, SYaoShouTuXiConsts.getInstance().NPC_FIGHT_ITEM_ID, SYaoShouTuXiConsts.getInstance().NPC_FIGHT_ITEM_NUM, new TLogArg(LogReason.YAOSHOUTUXI_ACTIVITY_NPC_STARTFIGHT_REM, SYaoShouTuXiConsts.getInstance().NPC_FIGHT_ITEM_ID)))
/*    */     {
/*    */ 
/*    */ 
/* 79 */       return false;
/*    */     }
/* 81 */     VisibleMonsterFightHandler.asynInitActivtyData(this.roleId, SYaoShouTuXiConsts.getInstance().ACTIVITYID);
/* 82 */     int idx = Xdb.random().nextInt(SYaoShouTuXiConsts.getInstance().FightIDList.size());
/* 83 */     int id = ((Integer)SYaoShouTuXiConsts.getInstance().FightIDList.get(idx)).intValue();
/* 84 */     MapVisibleMonsterFightContext context = new MapVisibleMonsterFightContext(this.roleId, -1, -1, -1, MapInterface.getCenterWorldid());
/*    */     
/* 86 */     context.putExtra(MapFightContext.EXTRADATA_TYPE.ENTER_FIGHT_LOW_LEVEL_LIMIT, RoleInterface.getLevel(this.roleId));
/* 87 */     FightInterface.startPVEFight(this.roleId, id, context, FightReason.YAOSHOUTUXI_FIGHT);
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\PYaoShouTuXiNPCStartFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */