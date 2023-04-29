/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ShiTuTaskInfo;
/*    */ import xtable.Role2properties;
/*    */ import xtable.Role2shitutask;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PChangeShiTuTaskPublishState
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long masterRoleId;
/*    */   private final Set<Long> roleIdSet;
/*    */   private final int beforeState;
/*    */   private final int afterState;
/*    */   
/*    */   public PChangeShiTuTaskPublishState(long masterRoleId, Set<Long> roleIdSet, int beforeState, int afterState)
/*    */   {
/* 30 */     this.masterRoleId = masterRoleId;
/* 31 */     this.roleIdSet = roleIdSet;
/* 32 */     this.beforeState = beforeState;
/* 33 */     this.afterState = afterState;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 39 */     List<String> userIds = new ArrayList();
/*    */     
/*    */ 
/* 42 */     for (Long roleId : this.roleIdSet)
/*    */     {
/* 44 */       String userId = RoleInterface.getUserId(roleId.longValue());
/* 45 */       if (userId != null)
/*    */       {
/*    */ 
/*    */ 
/* 49 */         userIds.add(userId);
/*    */       }
/*    */     }
/*    */     
/* 53 */     super.lock(User.getTable(), userIds);
/*    */     
/* 55 */     super.lock(Role2properties.getTable(), this.roleIdSet);
/*    */     
/*    */ 
/* 58 */     for (Long roleId : this.roleIdSet)
/*    */     {
/* 60 */       ShiTuTaskInfo xShiTuTaskInfo = Role2shitutask.get(roleId);
/* 61 */       if (xShiTuTaskInfo.getPublish_state() == this.beforeState)
/*    */       {
/*    */ 
/* 64 */         OnlineManager.getInstance().sendMulti(ShiTuManager.changeShiTuTaskPublishState(roleId.longValue(), this.beforeState, this.afterState), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), roleId }));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PChangeShiTuTaskPublishState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */