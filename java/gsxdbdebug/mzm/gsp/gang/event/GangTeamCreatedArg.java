/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ 
/*    */ public class GangTeamCreatedArg
/*    */ {
/*    */   public final long gangid;
/*    */   
/*    */   public final long roleid;
/*    */   
/*    */   public final long gangTeamid;
/*    */   
/*    */ 
/*    */   public GangTeamCreatedArg(long gangid, long roleid, long gangTeamid)
/*    */   {
/* 15 */     this.gangid = gangid;
/* 16 */     this.roleid = roleid;
/* 17 */     this.gangTeamid = gangTeamid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangTeamCreatedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */