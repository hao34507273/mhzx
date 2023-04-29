/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PersonalPraiseArg
/*    */ {
/*    */   public final long roleid;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int praisedNum;
/*    */   
/*    */ 
/*    */ 
/*    */   public final long targetRoleid;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int bePraisedNum;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public PersonalPraiseArg(long roleid, int praisedNum, long targetRoleid, int bePraisedNum)
/*    */   {
/* 27 */     this.roleid = roleid;
/* 28 */     this.praisedNum = praisedNum;
/*    */     
/* 30 */     this.targetRoleid = targetRoleid;
/* 31 */     this.bePraisedNum = bePraisedNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\PersonalPraiseArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */