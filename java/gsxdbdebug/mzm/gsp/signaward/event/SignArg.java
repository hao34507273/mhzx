/*    */ package mzm.gsp.signaward.event;
/*    */ 
/*    */ 
/*    */ public class SignArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final int signday;
/*    */   public final int itemid;
/*    */   public final int itemcount;
/*    */   public final boolean isResign;
/*    */   
/*    */   public SignArg(long roleid, int signday, int itemid, int itemcount, boolean isResign)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.signday = signday;
/* 16 */     this.itemid = itemid;
/* 17 */     this.itemcount = itemcount;
/* 18 */     this.isResign = isResign;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\event\SignArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */