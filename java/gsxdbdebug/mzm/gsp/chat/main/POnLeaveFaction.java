/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import xbean.NewerChannel;
/*    */ 
/*    */ public class POnLeaveFaction extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   POnLeaveFaction(long roleId)
/*    */   {
/* 11 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     java.util.List<NewerChannel> newerChannels = NewerManager.getNewerChannels();
/* 17 */     NewerManager.addNewer(this.roleId, newerChannels);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnLeaveFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */