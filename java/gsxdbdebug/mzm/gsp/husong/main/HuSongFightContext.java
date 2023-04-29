/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ class HuSongFightContext implements FightContext
/*    */ {
/*    */   public final int husongcfgid;
/*    */   
/*    */   public HuSongFightContext(int husongcfgid)
/*    */   {
/* 11 */     this.husongcfgid = husongcfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\HuSongFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */