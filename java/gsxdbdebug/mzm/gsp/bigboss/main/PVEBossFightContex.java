/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ 
/*    */ public class PVEBossFightContex
/*    */   implements FightContext
/*    */ {
/*    */   private long roleid;
/*    */   private int monsterid;
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
/*    */   public FightReason getFightReson()
/*    */   {
/* 30 */     return this.fightReson;
/*    */   }
/*    */   
/*    */   public void setFightReson(FightReason fightReson)
/*    */   {
/* 35 */     this.fightReson = fightReson;
/*    */   }
/*    */   
/*    */   public int getMonsterid()
/*    */   {
/* 40 */     return this.monsterid;
/*    */   }
/*    */   
/*    */   public void setMonsterid(int monsterid)
/*    */   {
/* 45 */     this.monsterid = monsterid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PVEBossFightContex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */