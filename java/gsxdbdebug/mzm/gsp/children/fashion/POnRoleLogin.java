/*    */ package mzm.gsp.children.fashion;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.children.SSyncFashionInfo;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.ChildFashionInfo;
/*    */ import xbean.Role2ChildrenInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProtectProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 21 */     String userId = RoleInterface.getUserId(roleid);
/* 22 */     long marriedRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(roleid, false);
/* 23 */     if (marriedRoleid > 0L)
/*    */     {
/* 25 */       String marriedUserId = RoleInterface.getUserId(marriedRoleid);
/* 26 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/* 27 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(marriedRoleid) }));
/*    */     }
/*    */     else
/*    */     {
/* 31 */       lock(Lockeys.get(User.getTable(), userId));
/* 32 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */     }
/*    */     
/*    */ 
/* 36 */     FashionManager.onLogin(roleid, marriedRoleid);
/*    */     
/* 38 */     Role2ChildrenInfo xRole2ChildrenInfo = xtable.Role2children.get(Long.valueOf(roleid));
/* 39 */     if (xRole2ChildrenInfo == null)
/*    */     {
/* 41 */       return true;
/*    */     }
/* 43 */     ChildFashionInfo xChildFashionInfo = xRole2ChildrenInfo.getFashion_info();
/* 44 */     if (xChildFashionInfo.getFashions().isEmpty())
/*    */     {
/* 46 */       return true;
/*    */     }
/*    */     
/* 49 */     SSyncFashionInfo msg = new SSyncFashionInfo();
/* 50 */     for (Map.Entry<Integer, xbean.FashionInfo> xEntry : xChildFashionInfo.getFashions().entrySet())
/*    */     {
/* 52 */       long startTime = ((xbean.FashionInfo)xEntry.getValue()).getStart_time();
/* 53 */       msg.fashions.put(xEntry.getKey(), new mzm.gsp.children.FashionInfo((int)TimeUnit.MILLISECONDS.toSeconds(startTime)));
/*    */     }
/* 55 */     mzm.gsp.online.main.OnlineManager.getInstance().send(roleid, msg);
/*    */     
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */