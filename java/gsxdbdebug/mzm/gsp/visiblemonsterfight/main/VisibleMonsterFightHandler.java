/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.IMonsterFightHandler;
/*    */ import mzm.gsp.map.main.MapFightContext;
/*    */ import mzm.gsp.monster.main.MonsterInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.visiblemonsterfight.main.robber.VisiableMonsterFightInit;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VisibleMonsterFightHandler
/*    */   implements IMonsterFightHandler
/*    */ {
/* 22 */   private Set<Integer> monsterGroupIdSet = new HashSet();
/*    */   private FightReason reason;
/*    */   private int moduleId;
/*    */   private int activityid;
/*    */   
/*    */   public VisibleMonsterFightHandler(FightReason reason, int moduleid, int activityid) {
/* 28 */     this.reason = reason;
/* 29 */     this.moduleId = moduleid;
/* 30 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   public void addGroupId(int id) {
/* 34 */     this.monsterGroupIdSet.add(Integer.valueOf(id));
/*    */   }
/*    */   
/*    */   public int startFight(long roleId, int fightId, MapFightContext context)
/*    */   {
/* 39 */     int monsterId = FightInterface.getFightFirstMonsterid(fightId);
/* 40 */     int group = MonsterInterface.getMonsterCategoryId(monsterId);
/* 41 */     if (this.monsterGroupIdSet.contains(Integer.valueOf(group))) {
/* 42 */       if ((!OpenInterface.getOpenStatus(this.moduleId)) || (OpenInterface.isBanPlay(roleId, this.moduleId))) {
/* 43 */         OpenInterface.sendBanPlayMsg(roleId, this.moduleId);
/* 44 */         return 5;
/*    */       }
/* 46 */       asynInitActivtyData(roleId, this.activityid);
/* 47 */       FightInterface.startPVEFight(roleId, fightId, context, this.reason);
/* 48 */       return 1;
/*    */     }
/* 50 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void asynInitActivtyData(long roleId, int activityid)
/*    */   {
/* 60 */     List<Long> memberList = TeamInterface.getNormalRoleList(roleId);
/* 61 */     if (!memberList.contains(Long.valueOf(roleId))) {
/* 62 */       memberList.clear();
/*    */     }
/* 64 */     if (memberList.size() <= 0) {
/* 65 */       memberList.add(Long.valueOf(roleId));
/*    */     }
/* 67 */     Procedure.execute(new VisiableMonsterFightInit(memberList, activityid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\VisibleMonsterFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */