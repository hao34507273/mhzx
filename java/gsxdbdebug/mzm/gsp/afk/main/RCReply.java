/*    */ package mzm.gsp.afk.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RCReply
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long roleid;
/*    */   private final int afkDetectCfgid;
/*    */   
/*    */   public RCReply(long roleid, int afkDetectCfgid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.afkDetectCfgid = afkDetectCfgid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 23 */     AFKDetector.getInstance().resetRole(this.roleid, this.afkDetectCfgid, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\afk\main\RCReply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */