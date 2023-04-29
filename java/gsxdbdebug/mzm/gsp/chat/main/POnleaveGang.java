/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnleaveGang extends mzm.gsp.gang.event.LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     java.util.List<xbean.NewerChannel> newerChannels = NewerManager.getNewerChannels();
/* 10 */     for (Iterator i$ = ((mzm.gsp.gang.event.LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 11 */       NewerManager.addNewer(roleId, newerChannels);
/*    */     }
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnleaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */