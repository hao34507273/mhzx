/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SYaoShouTuXiConsts;
/*    */ import mzm.gsp.visiblemonsterfight.main.robber.VisiableMonsterFightInit;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2jiuxiao;
/*    */ 
/*    */ 
/*    */ public class PGM_PVEFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int fightid;
/*    */   
/*    */   public PGM_PVEFight(int Fightid, long roleId)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.fightid = Fightid;
/*    */   }
/*    */   
/*    */   private void asynInitActivtyData(long roleId, int activityid)
/*    */   {
/* 32 */     List<Long> memberList = TeamInterface.getNormalRoleList(roleId);
/* 33 */     if (!memberList.contains(Long.valueOf(roleId))) {
/* 34 */       memberList.clear();
/*    */     }
/* 36 */     if (memberList.size() <= 0) {
/* 37 */       memberList.add(Long.valueOf(roleId));
/*    */     }
/* 39 */     Procedure.execute(new VisiableMonsterFightInit(memberList, activityid));
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 45 */     List<Long> normalList = new ArrayList();
/* 46 */     List<Long> beforeTeamList = TeamInterface.getNormalRoleList(this.roleId);
/* 47 */     normalList.addAll(beforeTeamList);
/* 48 */     if (normalList.size() <= 0) {
/* 49 */       normalList.add(Long.valueOf(this.roleId));
/*    */     }
/* 51 */     if (((Long)normalList.get(0)).longValue() != this.roleId)
/*    */     {
/* 53 */       if (normalList.contains(Long.valueOf(this.roleId)))
/*    */       {
/* 55 */         GameServer.logger().info(String.format("[PCLuanShiYaoMoNpcFight]PCLuanShiYaoMoNpcFight.processImp@role is not teamLeader|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 56 */         return false;
/*    */       }
/* 58 */       normalList.clear();
/* 59 */       normalList.add(Long.valueOf(this.roleId));
/*    */     }
/* 61 */     lock(Role2jiuxiao.getTable(), normalList);
/* 62 */     List<Long> tmpNormalList = TeamInterface.getNormalRoleList(this.roleId);
/* 63 */     if ((tmpNormalList.size() != beforeTeamList.size()) || (!tmpNormalList.containsAll(beforeTeamList)))
/*    */     {
/* 65 */       GameServer.logger().info(String.format("[PCLuanShiYaoMoNpcFight]PCLuanShiYaoMoNpcFight.processImp@team changed|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 67 */       return false;
/*    */     }
/* 69 */     asynInitActivtyData(this.roleId, SYaoShouTuXiConsts.getInstance().ACTIVITYID);
/* 70 */     MapVisibleMonsterFightContext context = new MapVisibleMonsterFightContext(this.roleId, -1, -1, -1, MapInterface.getCenterWorldid());
/* 71 */     context.putExtra(MapFightContext.EXTRADATA_TYPE.ENTER_FIGHT_LOW_LEVEL_LIMIT, RoleInterface.getLevel(this.roleId));
/* 72 */     FightInterface.startPVEFight(this.roleId, this.fightid, context, FightReason.YAOSHOUTUXI_FIGHT);
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_PVEFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */