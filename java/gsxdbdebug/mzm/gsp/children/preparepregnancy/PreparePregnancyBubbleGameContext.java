/*    */ package mzm.gsp.children.preparepregnancy;
/*    */ 
/*    */ import mzm.gsp.bubblegame.event.BubbleGameContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PreparePregnancyBubbleGameContext
/*    */   implements BubbleGameContext
/*    */ {
/*    */   public final long marriageid;
/*    */   public final long partnerid;
/*    */   
/*    */   public PreparePregnancyBubbleGameContext(long marriageid, long partnerid)
/*    */   {
/* 16 */     this.marriageid = marriageid;
/* 17 */     this.partnerid = partnerid;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 23 */     return String.format("marriageid=%d|partnerid=%d", new Object[] { Long.valueOf(this.marriageid), Long.valueOf(this.partnerid) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\PreparePregnancyBubbleGameContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */