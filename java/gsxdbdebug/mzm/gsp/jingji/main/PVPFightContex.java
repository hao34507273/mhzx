/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ 
/*    */ public class PVPFightContex
/*    */   implements FightContext
/*    */ {
/*    */   private long roleid;
/*    */   private long opponentRoleid;
/*    */   private FightReason fightReson;
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 15 */     return false;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 20 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public void setRoleid(long roleid)
/*    */   {
/* 25 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public long getOpponentRoleid()
/*    */   {
/* 30 */     return this.opponentRoleid;
/*    */   }
/*    */   
/*    */   public void setOpponentRoleid(long opponentRoleid)
/*    */   {
/* 35 */     this.opponentRoleid = opponentRoleid;
/*    */   }
/*    */   
/*    */   public FightReason getFightReson()
/*    */   {
/* 40 */     return this.fightReson;
/*    */   }
/*    */   
/*    */   public void setFightReson(FightReason fightReson)
/*    */   {
/* 45 */     this.fightReson = fightReson;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PVPFightContex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */