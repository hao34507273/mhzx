/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class POnDissolveFaction extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private List<Long> roleIds;
/*    */   
/*    */   POnDissolveFaction(List<Long> roleIds)
/*    */   {
/* 11 */     this.roleIds = roleIds;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     List<xbean.NewerChannel> newerChannels = NewerManager.getNewerChannels();
/* 17 */     for (Long roleId : this.roleIds) {
/* 18 */       NewerManager.addNewer(roleId.longValue(), newerChannels);
/*    */     }
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnDissolveFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */