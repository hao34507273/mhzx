/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_SimplifyCrossCompete
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final String onOrOff;
/*    */   
/*    */   public PGM_SimplifyCrossCompete(long gmid, String onOrOff)
/*    */   {
/* 17 */     this.gmid = gmid;
/* 18 */     this.onOrOff = onOrOff;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     if (this.onOrOff == null) {
/* 24 */       GmManager.getInstance().sendResultToGM(this.gmid, "格式错误：.simplifycrosscompete on|off");
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     if (this.onOrOff.equals("on")) {
/* 29 */       CrossCompeteManager.simplified = true;
/* 30 */       GmManager.getInstance().sendResultToAll("简化跨服帮战门槛on：报名时，不限制帮派创建时间、帮派活跃度、满足参与等级的玩家数量；参加时，不限制入帮时间");
/*    */ 
/*    */     }
/* 33 */     else if (this.onOrOff.equals("off")) {
/* 34 */       CrossCompeteManager.simplified = false;
/* 35 */       GmManager.getInstance().sendResultToAll("简化跨服帮战门槛off");
/*    */     }
/*    */     else {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmid, "格式错误：.simplifycrosscompete on|off");
/*    */     }
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PGM_SimplifyCrossCompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */