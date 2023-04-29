/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ 
/*    */ public class POnJoinGang extends mzm.gsp.gang.event.JoinGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     java.util.List<xbean.NewerChannel> newerChannels = NewerManager.getNewerChannels();
/* 10 */     NewerManager.rmNewerList(((GangArg)this.arg).extraMemberList, newerChannels);
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */