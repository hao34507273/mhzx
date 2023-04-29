/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.NewerChannel;
/*    */ 
/*    */ public class PRoleLogOff extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   PRoleLogOff(long roleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (GangInterface.hasGang(this.roleId))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     List<NewerChannel> newerChannels = NewerManager.getNewerChannels();
/* 25 */     NewerManager.rmNewer(this.roleId, newerChannels);
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PRoleLogOff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */