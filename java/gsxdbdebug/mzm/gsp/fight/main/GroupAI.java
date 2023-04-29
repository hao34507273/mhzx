/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.ai.util.FighterAIFactory;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class GroupAI
/*     */ {
/*     */   private mzm.gsp.fight.ai.util.GroupAI groupAI;
/*     */   
/*     */   GroupAI(String name)
/*     */   {
/*  16 */     if (name == null) {
/*  17 */       return;
/*     */     }
/*  19 */     this.groupAI = FighterAIFactory.getInstance().getGroupAI(name.trim());
/*     */   }
/*     */   
/*  22 */   private List<FighterAIOperator> unRoundsOperators = new ArrayList();
/*     */   
/*     */   GroupAI getGroupAI() {
/*  25 */     if (this.groupAI == null) {
/*  26 */       return null;
/*     */     }
/*  28 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onRoundBegin(Fight fight, Set<Fighter> set)
/*     */   {
/*     */     try
/*     */     {
/*  40 */       this.groupAI.init(new FightInfo(fight), getFighterSet(set));
/*  41 */       this.groupAI.getAiOperators().clear();
/*  42 */       this.groupAI.onRoundBegin();
/*  43 */       for (FighterAIOperator aiOperator : this.groupAI.getAiOperators()) {
/*  44 */         if (aiOperator.isNeedRound()) {
/*  45 */           aiOperator.excute(fight);
/*     */         } else {
/*  47 */           this.unRoundsOperators.add(aiOperator);
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  51 */       GameServer.logger().error("执行AI出错：className" + this.groupAI.getClass().getName(), e);
/*  52 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onRoundEnd(Fight fight, Set<Fighter> set)
/*     */   {
/*     */     try
/*     */     {
/*  65 */       this.groupAI.init(new FightInfo(fight), getFighterSet(set));
/*  66 */       this.groupAI.getAiOperators().clear();
/*  67 */       this.groupAI.onRoundEnd();
/*  68 */       for (FighterAIOperator operator : this.groupAI.getAiOperators()) {
/*  69 */         operator.excute(fight);
/*     */       }
/*     */     } catch (Exception e) {
/*  72 */       GameServer.logger().error("执行AI出错：className" + this.groupAI.getClass().getName(), e);
/*  73 */       fight.onFightEnd(false, 102);
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
/*  85 */       for (FighterAIOperator operator : this.unRoundsOperators) {
/*  86 */         operator.excute(fight);
/*     */       }
/*  88 */       this.unRoundsOperators.clear();
/*     */     } catch (Exception e) {
/*  90 */       GameServer.logger().error("执行AI出错：className" + this.groupAI.getClass().getName(), e);
/*  91 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onFighterDie(Fight fight, Set<Fighter> set, int tfid)
/*     */   {
/*     */     try
/*     */     {
/* 105 */       this.groupAI.init(new FightInfo(fight), getFighterSet(set));
/*     */       
/* 107 */       this.groupAI.onFighterDie(tfid);
/*     */     } catch (Exception e) {
/* 109 */       GameServer.logger().error("执行AI出错：className" + this.groupAI.getClass().getName(), e);
/* 110 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onFighterRelive(Fight fight, Set<Fighter> set, int tfid)
/*     */   {
/*     */     try
/*     */     {
/* 124 */       this.groupAI.init(new FightInfo(fight), getFighterSet(set));
/*     */       
/* 126 */       this.groupAI.onFighterRelive(tfid);
/*     */     } catch (Exception e) {
/* 128 */       GameServer.logger().error("执行AI出错：className" + this.groupAI.getClass().getName(), e);
/* 129 */       fight.onFightEnd(false, 102);
/*     */     }
/*     */   }
/*     */   
/*     */   private Set<Integer> getFighterSet(Set<Fighter> set)
/*     */   {
/* 135 */     Set<Integer> fighteridSet = new java.util.HashSet();
/* 136 */     for (Fighter fighter : set) {
/* 137 */       fighteridSet.add(Integer.valueOf(fighter.fighterid));
/*     */     }
/* 139 */     return fighteridSet;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\GroupAI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */