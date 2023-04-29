/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.PropertyManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_FPetProp extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_FPetProp(long gmRoleid, long roleid)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/* 24 */     if (fight == null) {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "玩家不再战斗中");
/* 26 */       return true;
/*    */     }
/* 28 */     Set<Fighter> fighters = new HashSet();
/* 29 */     fighters.addAll(fight.getActiveTeam().getFighters());
/* 30 */     fighters.addAll(fight.getPassiveTeam().getFighters());
/* 31 */     for (Fighter fighter : fighters) {
/* 32 */       if ((fighter.isPet()) && ((fighter instanceof FighterPet))) {
/* 33 */         FighterPet fighterpet = (FighterPet)fighter;
/* 34 */         if (fighterpet.getOwnerid() == this.roleid) {
/* 35 */           Map<Integer, Integer> propMap = fighter.getFinalPropMap();
/* 36 */           String retResult = PropertyManager.getPropCHNInfo(propMap);
/* 37 */           GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("宠物战斗内属性为:\n%s\r\n乱敏浮动万分比为:%d", new Object[] { retResult, Integer.valueOf(fighter.getExtra(FighterExtra.Speed_Fluctuate_Rate)) }));
/*    */           
/*    */ 
/*    */ 
/* 41 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 46 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "当前结果中没有玩家宠物");
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_FPetProp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */