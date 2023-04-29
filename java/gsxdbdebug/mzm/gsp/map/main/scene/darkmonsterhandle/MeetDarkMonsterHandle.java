/*    */ package mzm.gsp.map.main.scene.darkmonsterhandle;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ 
/*    */ public abstract interface MeetDarkMonsterHandle {
/*    */   public abstract int handle(long paramLong, MeetDarkMonsterHandleContext paramMeetDarkMonsterHandleContext);
/*    */   
/*    */   public static class MeetDarkMonsterHandleContext {
/*    */     public FightReason reason;
/* 10 */     public long doublePointRoleId = -1L;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\darkmonsterhandle\MeetDarkMonsterHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */