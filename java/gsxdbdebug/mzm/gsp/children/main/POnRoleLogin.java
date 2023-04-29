/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.children.SSyncChildrenInfo;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import xbean.Role2ChildrenInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2children;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleId = ((Long)this.arg).longValue();
/* 18 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/*    */     
/*    */ 
/* 21 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(roleId, false);
/* 22 */     if (marriedRoleId > 0L)
/*    */     {
/* 24 */       String marriedUserId = mzm.gsp.role.main.RoleInterface.getUserId(marriedRoleId);
/* 25 */       Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/* 26 */       Lockeys.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(marriedRoleId) }));
/*    */       
/* 28 */       long marriedId = MarriageInterface.getMarriedId(roleId, true);
/*    */       
/* 30 */       lock(Lockeys.get(xtable.Marriage.getTable(), Long.valueOf(marriedId)));
/*    */     }
/*    */     else
/*    */     {
/* 34 */       Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*    */     }
/*    */     
/* 37 */     SSyncChildrenInfo sSyncChildrenInfo = new SSyncChildrenInfo();
/*    */     
/* 39 */     List<Long> childIdList = new ArrayList();
/*    */     
/* 41 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/* 42 */     if (xRole2ChildrenInfo != null)
/*    */     {
/* 44 */       sSyncChildrenInfo.bag_child_id_list.addAll(xRole2ChildrenInfo.getChild_bag_id_list());
/* 45 */       sSyncChildrenInfo.show_child_id = xRole2ChildrenInfo.getShow_child_id();
/* 46 */       sSyncChildrenInfo.show_child_period = xRole2ChildrenInfo.getShow_child_period();
/* 47 */       childIdList.addAll(xRole2ChildrenInfo.getChild_id_list());
/*    */     }
/*    */     else
/*    */     {
/* 51 */       sSyncChildrenInfo.show_child_id = -1L;
/*    */     }
/*    */     
/* 54 */     if (marriedRoleId > 0L)
/*    */     {
/* 56 */       Role2ChildrenInfo xMarriedChildrenInfo = Role2children.get(Long.valueOf(marriedRoleId));
/* 57 */       if (xMarriedChildrenInfo != null)
/*    */       {
/* 59 */         childIdList.addAll(xMarriedChildrenInfo.getChild_id_list());
/*    */       }
/*    */     }
/*    */     
/* 63 */     lock(xtable.Children.getTable(), childIdList);
/*    */     
/* 65 */     ChildrenManager.syncChildrenInfo(roleId, marriedRoleId, childIdList, sSyncChildrenInfo, 0);
/*    */     
/*    */ 
/* 68 */     ChildrenManager.refreshRoleRating(roleId);
/*    */     
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */