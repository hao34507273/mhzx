/*    */ package mzm.gsp.fight.ai.util;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.ai.script.fighter.CommonAI;
/*    */ import mzm.gsp.fight.ai.script.group.CommonGroupAI;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FighterAIFactory
/*    */ {
/*    */   private static final String GROUP_AI_PACKAGE = "mzm.gsp.fight.ai.script.group.";
/*    */   private static final String FIGHTER_AI_PACKAGE = "mzm.gsp.fight.ai.script.fighter.";
/* 17 */   private static FighterAIFactory instance = new FighterAIFactory();
/*    */   
/*    */   public static FighterAIFactory getInstance() {
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */   public FighterAI getFighterAI(String aiName) {
/* 24 */     FighterAI ai = null;
/*    */     try {
/* 26 */       if ((aiName == null) || (aiName.isEmpty())) {
/* 27 */         return null;
/*    */       }
/* 29 */       String className = "mzm.gsp.fight.ai.script.fighter." + aiName;
/*    */       
/* 31 */       Class<FighterAI> aiClass = Class.forName(className);
/* 32 */       ai = (FighterAI)aiClass.newInstance();
/*    */     } catch (Exception e) {
/* 34 */       GameServer.logger().error("获取AI对象出错name:" + aiName, e);
/* 35 */       ai = new CommonAI();
/*    */     }
/* 37 */     return ai;
/*    */   }
/*    */   
/*    */   public GroupAI getGroupAI(String aiName) {
/* 41 */     GroupAI ai = null;
/*    */     try {
/* 43 */       if ((aiName == null) || (aiName.isEmpty())) {
/* 44 */         return null;
/*    */       }
/* 46 */       String className = "mzm.gsp.fight.ai.script.group." + aiName;
/*    */       
/* 48 */       Class<GroupAI> groupAiClass = Class.forName(className);
/* 49 */       ai = (GroupAI)groupAiClass.newInstance();
/*    */     } catch (Exception e) {
/* 51 */       GameServer.logger().error("获取GroupAI对象出错 name:" + aiName, e);
/* 52 */       ai = new CommonGroupAI();
/*    */     }
/* 54 */     return ai;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\ai\util\FighterAIFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */