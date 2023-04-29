/*    */ package mzm.gsp.blacklist.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBlackListReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PBlackListReq(long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     xbean.Blacklist xBlacklist = xtable.Blacklist.select(Long.valueOf(this.roleid));
/*    */     
/* 23 */     BlacklistManager.syncBlacklist(this.roleid, xBlacklist);
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\main\PBlackListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */