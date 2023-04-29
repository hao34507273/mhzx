/*    */ package mzm.gsp.buff.event;
/*    */ 
/*    */ public class InstallBuffArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final int buffid;
/*    */   public final long installTime;
/*    */   public final int state;
/*    */   
/*    */   public InstallBuffArg(long roleid, int buffid, long installTime, int state)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.buffid = buffid;
/* 14 */     this.installTime = installTime;
/* 15 */     this.state = state;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\event\InstallBuffArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */