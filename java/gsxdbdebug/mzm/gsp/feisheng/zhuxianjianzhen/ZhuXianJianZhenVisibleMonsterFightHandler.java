/*    */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.IMonsterFightHandler;
/*    */ import mzm.gsp.map.main.MapFightContext;
/*    */ import mzm.gsp.map.main.MapFightContext.EXTRADATA_TYPE;
/*    */ import mzm.gsp.monster.main.MonsterInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZhuXianJianZhenVisibleMonsterFightHandler
/*    */   implements IMonsterFightHandler
/*    */ {
/* 23 */   private final Set<Integer> monsterGroupIdSet = new HashSet();
/*    */   private final FightReason reason;
/*    */   private final int moduleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public ZhuXianJianZhenVisibleMonsterFightHandler(FightReason reason, int moduleid, int activityCfgid)
/*    */   {
/* 30 */     this.reason = reason;
/* 31 */     this.moduleid = moduleid;
/* 32 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   public void addGroupId(int groupid)
/*    */   {
/* 37 */     this.monsterGroupIdSet.add(Integer.valueOf(groupid));
/*    */   }
/*    */   
/*    */ 
/*    */   public int startFight(long roleId, int fightId, MapFightContext context)
/*    */   {
/* 43 */     int monsterId = FightInterface.getFightFirstMonsterid(fightId);
/* 44 */     int groupid = MonsterInterface.getMonsterCategoryId(monsterId);
/* 45 */     if (this.monsterGroupIdSet.contains(Integer.valueOf(groupid)))
/*    */     {
/* 47 */       if ((!OpenInterface.getOpenStatus(this.moduleid)) || (OpenInterface.isBanPlay(roleId, this.moduleid)))
/*    */       {
/* 49 */         return 5;
/*    */       }
/* 51 */       context.putExtra(MapFightContext.EXTRADATA_TYPE.ACTIVITY_CFG_ID, this.activityCfgid);
/* 52 */       FightInterface.startPVEFight(roleId, fightId, context, this.reason);
/* 53 */       return 1;
/*    */     }
/* 55 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\ZhuXianJianZhenVisibleMonsterFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */