/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ 
/*    */ public class LineUpPartnerEventArg
/*    */   extends PartnerEventArg
/*    */ {
/*    */   private final int lineUpNum;
/*    */   
/*    */   private final int lineUpMembersNum;
/*    */   
/*    */ 
/*    */   public LineUpPartnerEventArg(long roleId, int partnerId, int lineUpNum, int lineUpMembersNum)
/*    */   {
/* 14 */     super(roleId, partnerId);
/* 15 */     this.lineUpNum = lineUpNum;
/* 16 */     this.lineUpMembersNum = lineUpMembersNum;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getLineUpNum()
/*    */   {
/* 24 */     return this.lineUpNum;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getLineUpMembersNum()
/*    */   {
/* 32 */     return this.lineUpMembersNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\LineUpPartnerEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */