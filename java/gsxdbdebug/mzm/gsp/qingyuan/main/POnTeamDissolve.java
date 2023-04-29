/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.qingyuan.confbean.QingYuanConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveProcedure;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnTeamDissolve
/*    */   extends TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     List<String> userList = new ArrayList();
/* 20 */     for (Iterator i$ = ((TeamDissolveArg)this.arg).members.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 22 */       userList.add(RoleInterface.getUserId(roleId));
/*    */     }
/*    */     
/* 25 */     lock(User.getTable(), userList);
/* 26 */     lock(Role2properties.getTable(), ((TeamDissolveArg)this.arg).members);
/* 27 */     for (Iterator i$ = ((TeamDissolveArg)this.arg).members.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 29 */       BuffInterface.uninstallBuf(roleId, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */