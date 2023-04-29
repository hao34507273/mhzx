/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ class CrossCompeteData
/*    */ {
/*  9 */   Map<Long, MatchFaction> signedUpFactions = new HashMap();
/*    */   
/* 11 */   private static final CrossCompeteData instance = new CrossCompeteData();
/*    */   
/*    */   static CrossCompeteData getInstance() {
/* 14 */     return instance;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\CrossCompeteData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */