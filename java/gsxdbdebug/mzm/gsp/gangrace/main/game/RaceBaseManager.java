/*    */ package mzm.gsp.gangrace.main.game;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.activity.confbean.SGangRaceActionCfg;
/*    */ 
/*    */ public class RaceBaseManager
/*    */ {
/* 10 */   private ArrayList<RaceBase> raceBaeses = new ArrayList();
/*    */   
/*    */   public void init() {
/* 13 */     this.raceBaeses.clear();
/* 14 */     Map<Integer, RaceBaseAction> hareActions = new TreeMap();
/*    */     
/* 16 */     RaceBase raceBase = new RaceBase();
/* 17 */     for (SGangRaceActionCfg actionCfg : SGangRaceActionCfg.getAll().values()) {
/* 18 */       RaceBaseAction action = new RaceBaseAction(actionCfg.ActCode, actionCfg.MoveStep, actionCfg.MinRound, actionCfg.MaxRound);
/* 19 */       hareActions.put(Integer.valueOf(actionCfg.ActCode), action);
/* 20 */       raceBase.addAction(actionCfg.RandValue, action);
/*    */     }
/* 22 */     this.raceBaeses.add(raceBase);
/*    */   }
/*    */   
/*    */   public RaceBase getRaceBase() {
/* 26 */     return (RaceBase)this.raceBaeses.get(0);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\game\RaceBaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */