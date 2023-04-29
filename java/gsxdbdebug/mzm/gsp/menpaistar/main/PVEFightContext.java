/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ 
/*    */ public class PVEFightContext
/*    */   implements FightContext
/*    */ {
/*    */   private long roleid;
/*    */   private FightReason fightReson;
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 14 */     return false;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 19 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public void setRoleid(long roleid)
/*    */   {
/* 24 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public FightReason getFightReson()
/*    */   {
/* 29 */     return this.fightReson;
/*    */   }
/*    */   
/*    */   public void setFightReson(FightReason fightReson)
/*    */   {
/* 34 */     this.fightReson = fightReson;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PVEFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */