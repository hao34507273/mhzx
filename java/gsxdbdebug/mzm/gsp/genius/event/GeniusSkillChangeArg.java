/*    */ package mzm.gsp.genius.event;
/*    */ 
/*    */ import mzm.gsp.genius.main.GeniusSkillChangeReason;
/*    */ 
/*    */ public class GeniusSkillChangeArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final GeniusSkillChangeReason reason;
/*    */   
/*    */   public GeniusSkillChangeArg(long roleid, GeniusSkillChangeReason reason)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.reason = reason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\event\GeniusSkillChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */