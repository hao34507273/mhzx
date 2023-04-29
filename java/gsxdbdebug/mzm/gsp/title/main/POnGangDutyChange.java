/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gang.event.DutyChangeProcedure;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class POnGangDutyChange extends DutyChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     int gangAppId = TitleManager.getGangAppId();
/* 13 */     for (Iterator i$ = ((GangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 14 */       Procedure.execute(new PGangMemberAppellationChange(roleId, ((GangArg)this.arg).gangId, gangAppId));
/*    */     }
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\POnGangDutyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */