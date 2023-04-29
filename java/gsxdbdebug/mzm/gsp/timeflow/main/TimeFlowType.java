/*    */ package mzm.gsp.timeflow.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ 
/*    */ public enum TimeFlowType
/*    */ {
/*  7 */   ACTIVITY;
/*    */   
/*    */   private TimeFlowType() {}
/*    */   
/* 11 */   public long toKey() { return GameServerInfoManager.toGlobalId(ordinal()); }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timeflow\main\TimeFlowType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */