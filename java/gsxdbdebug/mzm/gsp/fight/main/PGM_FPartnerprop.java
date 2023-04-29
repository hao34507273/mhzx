/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.PropertyManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_FPartnerprop extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int partnerid;
/*    */   
/*    */   public PGM_FPartnerprop(long gmRoleid, long roleid, int partnerid)
/*    */   {
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.roleid = roleid;
/* 20 */     this.partnerid = partnerid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/* 26 */     if (fight == null) {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "玩家不再战斗中");
/* 28 */       return true;
/*    */     }
/* 30 */     Set<Fighter> fighters = new HashSet();
/* 31 */     fighters.addAll(fight.getActiveTeam().getFighters());
/* 32 */     fighters.addAll(fight.getPassiveTeam().getFighters());
/* 33 */     for (Fighter fighter : fighters) {
/* 34 */       if ((fighter.isFellow()) && ((fighter instanceof FighterFellow))) {
/* 35 */         FighterFellow fighterFellow = (FighterFellow)fighter;
/* 36 */         if ((fighterFellow.getOwnerid() == this.roleid) && (fighterFellow.getPartnerid() == this.partnerid)) {
/* 37 */           Map<Integer, Integer> propMap = fighter.getFinalPropMap();
/* 38 */           String retResult = PropertyManager.getPropCHNInfo(propMap);
/* 39 */           GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("伙伴%d战斗内属性为:\n%s\r\n乱敏浮动万分比为:%d", new Object[] { Integer.valueOf(this.partnerid), retResult, Integer.valueOf(fighter.getExtra(FighterExtra.Speed_Fluctuate_Rate)) }));
/*    */           
/*    */ 
/*    */ 
/* 43 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 48 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "当前结果中没有玩家伙伴，伙伴id:" + this.partnerid);
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_FPartnerprop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */