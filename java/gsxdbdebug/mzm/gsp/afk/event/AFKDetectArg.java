/*    */ package mzm.gsp.afk.event;
/*    */ 
/*    */ public class AFKDetectArg
/*    */ {
/*    */   private final long roleid;
/*    */   private final int cfgid;
/*    */   
/*    */   public AFKDetectArg(long roleid, int cfgid)
/*    */   {
/* 10 */     this.roleid = roleid;
/* 11 */     this.cfgid = cfgid;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 16 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int getCfgid()
/*    */   {
/* 21 */     return this.cfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\afk\event\AFKDetectArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */