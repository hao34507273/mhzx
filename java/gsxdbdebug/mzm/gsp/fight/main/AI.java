/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.ai.util.FighterAI;
/*     */ import mzm.gsp.fight.ai.util.FighterAIFactory;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AI
/*     */ {
/*     */   private FighterAI fighterAI;
/*     */   
/*     */   AI(String name)
/*     */   {
/*  16 */     this.fighterAI = FighterAIFactory.getInstance().getFighterAI(name);
/*     */   }
/*     */   
/*  19 */   private List<FighterAIOperator> unRoundsOperators = new ArrayList();
/*     */   
/*     */   AI getAi() {
/*  22 */     if (this.fighterAI == null) {
/*  23 */       return null;
/*     */     }
/*  25 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onRoundBegin(Fight fight, Fighter fighter)
/*     */   {
/*     */     try
/*     */     {
/*  37 */       this.fighterAI.init(new FightInfo(fight), fighter.getid());
/*  38 */       this.fighterAI.getAiOperators().clear();
/*  39 */       this.unRoundsOperators.clear();
/*  40 */       this.fighterAI.onRoundBegin();
/*  41 */       for (FighterAIOperator aiOperator : this.fighterAI.getAiOperators()) {
/*  42 */         if (aiOperator.isNeedRound()) {
/*  43 */           aiOperator.excute(fight);
/*     */         } else {
/*  45 */           this.unRoundsOperators.add(aiOperator);
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  49 */       GameServer.logger().error("执行AI出错：className" + this.fighterAI.getClass().getName(), e);
/*  50 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onRoundEnd(Fight fight, Fighter fighter)
/*     */   {
/*     */     try
/*     */     {
/*  63 */       this.fighterAI.init(new FightInfo(fight), fighter.getid());
/*  64 */       this.fighterAI.getAiOperators().clear();
/*  65 */       this.unRoundsOperators.clear();
/*  66 */       this.fighterAI.onRoundEnd();
/*  67 */       for (FighterAIOperator operator : this.fighterAI.getAiOperators()) {
/*  68 */         operator.excute(fight);
/*     */       }
/*     */     } catch (Exception e) {
/*  71 */       GameServer.logger().error("执行AI出错：className" + this.fighterAI.getClass().getName(), e);
/*  72 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void runUnRoundOperator(Fight fight)
/*     */   {
/*     */     try
/*     */     {
/*  84 */       for (FighterAIOperator operator : this.unRoundsOperators) {
/*  85 */         operator.excute(fight);
/*     */       }
/*  87 */       this.unRoundsOperators.clear();
/*     */     } catch (Exception e) {
/*  89 */       GameServer.logger().error("执行AI出错：className" + this.fighterAI.getClass().getName(), e);
/*  90 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onFighterDie(Fight fight, Fighter fighter, int tfid)
/*     */   {
/*     */     try
/*     */     {
/* 104 */       this.fighterAI.init(new FightInfo(fight), fighter.getid());
/*     */       
/* 106 */       this.fighterAI.onFighterDie(tfid);
/*     */     } catch (Exception e) {
/* 108 */       GameServer.logger().error("执行AI出错：className" + this.fighterAI.getClass().getName(), e);
/* 109 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */   
/*     */   void onFighterRelive(Fight fight, Fighter fighter, int tfid)
/*     */   {
/*     */     try {
/* 116 */       this.fighterAI.init(new FightInfo(fight), fighter.getid());
/*     */       
/* 118 */       this.fighterAI.onFighterRelive(tfid);
/*     */     } catch (Exception e) {
/* 120 */       GameServer.logger().error("执行AI出错：className" + this.fighterAI.getClass().getName(), e);
/* 121 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\AI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */