/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NeedSendProtocolsArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */ 
/*    */   private final AwardModel awardModel;
/*    */   
/*    */ 
/*    */ 
/*    */   public NeedSendProtocolsArg(long roleId, AwardModel awardModel)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.awardModel = awardModel;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   void sendNeedSendProtocols()
/*    */   {
/* 25 */     this.awardModel.sendAwardExtroProtocols(this.roleId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 35 */     return this.roleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\NeedSendProtocolsArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */