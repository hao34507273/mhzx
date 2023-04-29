/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ 
/*    */ public class POnCreateGang extends mzm.gsp.gang.event.CreateGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     java.util.List<xbean.NewerChannel> newerChannels = NewerManager.getNewerChannels();
/* 10 */     NewerManager.rmNewer(((GangArg)this.arg).roleId, newerChannels);
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnCreateGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */