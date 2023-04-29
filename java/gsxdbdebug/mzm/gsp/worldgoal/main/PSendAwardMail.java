/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSendAwardMail
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int sectionid;
/*    */   
/*    */   public PSendAwardMail(long roleid, int activityCfgid, int sectionid)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.activityCfgid = activityCfgid;
/* 19 */     this.sectionid = sectionid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     return WorldGoalManager.sendAwardMail(this.roleid, this.activityCfgid, this.sectionid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PSendAwardMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */