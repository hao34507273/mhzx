/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.gsp.homeland.event.HomeStateChangeArg;
/*    */ import xbean.CatInfo;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class POnHomeStateChange extends mzm.gsp.homeland.event.HomeStateChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((HomeStateChangeArg)this.arg).roleId;
/*    */     
/* 13 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 14 */     if (userid == null)
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 20 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/* 21 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 23 */     CatInfo xCatInfo = CatManager.getHomelandCat(roleid, true);
/* 24 */     if (xCatInfo == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 30 */     lock(Lockeys.get(xtable.Catexploreobservers.getTable(), Long.valueOf(xCatInfo.getId())));
/*    */     
/* 32 */     int newState = ((HomeStateChangeArg)this.arg).newState;
/* 33 */     if (newState == 1)
/*    */     {
/* 35 */       CatManager.onHomelandNone(userid, roleid, xCatInfo);
/*    */     }
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\POnHomeStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */