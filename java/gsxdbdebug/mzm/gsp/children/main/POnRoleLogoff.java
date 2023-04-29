/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.Role2ChildrenInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2children;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogoff extends mzm.gsp.online.event.PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleId = ((Long)this.arg).longValue();
/* 18 */     String userId = RoleInterface.getUserId(roleId);
/*    */     
/* 20 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(roleId, false);
/* 21 */     if (marriedRoleId > 0L)
/*    */     {
/* 23 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/* 24 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/* 25 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(marriedRoleId) }));
/*    */     }
/*    */     else
/*    */     {
/* 29 */       lock(Lockeys.get(User.getTable(), userId));
/*    */     }
/*    */     
/* 32 */     long marriageId = MarriageInterface.getMarriedId(roleId, true);
/* 33 */     if (marriageId > 0L)
/*    */     {
/* 35 */       lock(Lockeys.get(xtable.Marriage.getTable(), Long.valueOf(marriageId)));
/*    */     }
/*    */     
/* 38 */     List<Long> childIdList = null;
/* 39 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/* 40 */     if (xRole2ChildrenInfo != null)
/*    */     {
/* 42 */       childIdList = new ArrayList();
/* 43 */       childIdList.addAll(xRole2ChildrenInfo.getChild_id_list());
/*    */     }
/*    */     
/* 46 */     if (marriedRoleId > 0L)
/*    */     {
/* 48 */       Role2ChildrenInfo xMarriedChildrenInfo = Role2children.get(Long.valueOf(marriedRoleId));
/* 49 */       if (xMarriedChildrenInfo != null)
/*    */       {
/* 51 */         if (childIdList == null)
/*    */         {
/* 53 */           childIdList = new ArrayList();
/*    */         }
/* 55 */         childIdList.addAll(xMarriedChildrenInfo.getChild_id_list());
/*    */       }
/*    */     }
/*    */     
/* 59 */     if ((childIdList == null) || (childIdList.isEmpty()))
/*    */     {
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     lock(xtable.Children.getTable(), childIdList);
/*    */     
/*    */ 
/* 67 */     ChildrenManager.onBabyChildLogoff(roleId, marriedRoleId, childIdList);
/*    */     
/*    */ 
/* 70 */     mzm.gsp.children.childhood.ChildhoodManager.onLogoff(roleId, marriedRoleId, childIdList);
/*    */     
/*    */ 
/* 73 */     ChildrenManager.handleBagChildLogoff(roleId, xRole2ChildrenInfo);
/*    */     
/*    */ 
/* 76 */     ChildrenManager.handleGiveBirthObserverLogoff(roleId, marriedRoleId, marriageId);
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */