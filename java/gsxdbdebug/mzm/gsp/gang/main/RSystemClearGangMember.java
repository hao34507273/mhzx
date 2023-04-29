/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.Gang;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RSystemClearGangMember
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gangid;
/*    */   
/*    */   RSystemClearGangMember(long gangid)
/*    */   {
/* 15 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     Gang xGang = GangManager.getXGang(this.gangid, false);
/* 22 */     if (xGang == null) {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     for (Long memberid : GangManager.getMembers(xGang)) {
/* 27 */       new PSystemClearGangMember(memberid.longValue(), this.gangid).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RSystemClearGangMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */