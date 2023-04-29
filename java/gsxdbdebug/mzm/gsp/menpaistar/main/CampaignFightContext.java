/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ 
/*    */ 
/*    */ public class CampaignFightContext
/*    */   implements FightContext
/*    */ {
/*    */   private long roleid;
/*    */   private long opponentRoleid;
/*    */   private FightReason fightReson;
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 16 */     return false;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 21 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public void setRoleid(long roleid)
/*    */   {
/* 26 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public long getOpponentRoleid()
/*    */   {
/* 31 */     return this.opponentRoleid;
/*    */   }
/*    */   
/*    */   public void setOpponentRoleid(long opponentRoleid)
/*    */   {
/* 36 */     this.opponentRoleid = opponentRoleid;
/*    */   }
/*    */   
/*    */   public FightReason getFightReson()
/*    */   {
/* 41 */     return this.fightReson;
/*    */   }
/*    */   
/*    */   public void setFightReson(FightReason fightReson)
/*    */   {
/* 46 */     this.fightReson = fightReson;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\CampaignFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */