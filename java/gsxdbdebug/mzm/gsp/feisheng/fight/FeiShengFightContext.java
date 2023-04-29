/*    */ package mzm.gsp.feisheng.fight;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FeiShengFightContext
/*    */   implements FightContext
/*    */ {
/*    */   public final long roleid;
/*    */   public final int activityCfgid;
/*    */   public final int sortid;
/*    */   
/*    */   public FeiShengFightContext(long roleid, int activityCfgid, int sortid)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.activityCfgid = activityCfgid;
/* 19 */     this.sortid = sortid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\fight\FeiShengFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */