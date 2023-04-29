/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PartnerLoveFlushArg
/*    */   extends PartnerEventArg
/*    */ {
/*    */   private final List<Integer> oldLoves;
/*    */   private final List<Integer> newLoves;
/*    */   
/*    */   public PartnerLoveFlushArg(long roleId, int partnerId, List<Integer> oldLoves, List<Integer> newLoves)
/*    */   {
/* 15 */     super(roleId, partnerId);
/* 16 */     this.oldLoves = oldLoves;
/* 17 */     this.newLoves = newLoves;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Integer> getOldLoves()
/*    */   {
/* 25 */     return this.oldLoves;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Integer> getNewLoves()
/*    */   {
/* 33 */     return this.newLoves;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\PartnerLoveFlushArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */