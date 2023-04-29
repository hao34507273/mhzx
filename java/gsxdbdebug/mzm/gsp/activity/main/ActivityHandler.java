/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ 
/*    */ public abstract interface ActivityHandler
/*    */ {
/*    */   public abstract void initData(String paramString, long paramLong, int paramInt1, int paramInt2);
/*    */   
/*    */   public static enum ActivityStartType {
/* 10 */     BIG_TURN,  LITTLE_TURN_FIRST,  START_AGAIN;
/*    */     
/*    */ 
/*    */ 
/*    */     private ActivityStartType() {}
/*    */     
/*    */ 
/*    */ 
/*    */     public boolean isBigTurn()
/*    */     {
/* 20 */       return this == BIG_TURN;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     public boolean isLittleTurnFirst()
/*    */     {
/* 29 */       return this == LITTLE_TURN_FIRST;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     public boolean startAgain()
/*    */     {
/* 38 */       return this == START_AGAIN;
/*    */     }
/*    */   }
/*    */   
/*    */   public abstract AwardReason getRecommendAwardReason();
/*    */   
/*    */   public abstract java.util.List<ActivityStage> getActivityStages();
/*    */   
/*    */   public abstract void onActivityStart(ActivityStartType paramActivityStartType, int paramInt);
/*    */   
/*    */   public abstract void onActivityStageStart(int paramInt1, boolean paramBoolean, int paramInt2);
/*    */   
/*    */   public abstract void onActivityEnd(int paramInt);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */