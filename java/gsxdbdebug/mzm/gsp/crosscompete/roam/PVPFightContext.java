/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PVPFightContext
/*    */   implements FightContext
/*    */ {
/*    */   public final long activeFactionid;
/*    */   public final long passiveFactionid;
/*    */   
/*    */   public PVPFightContext(long activeFactionid, long passiveFactionid)
/*    */   {
/* 16 */     this.activeFactionid = activeFactionid;
/* 17 */     this.passiveFactionid = passiveFactionid;
/*    */   }
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PVPFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */