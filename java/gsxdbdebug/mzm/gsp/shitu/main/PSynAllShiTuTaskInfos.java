/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.SSynAllShiTuTaskInfos;
/*    */ import mzm.gsp.shitu.SSynShiTuTaskInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSynAllShiTuTaskInfos
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Set<Long> roleIdSet;
/*    */   
/*    */   public PSynAllShiTuTaskInfos(long roleId, Set<Long> roleIdSet)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.roleIdSet = roleIdSet;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     List<String> userIds = new ArrayList();
/*    */     
/*    */ 
/* 35 */     for (Long roleId : this.roleIdSet) {
/* 36 */       String userId = RoleInterface.getUserId(roleId.longValue());
/* 37 */       if (userId != null)
/*    */       {
/*    */ 
/*    */ 
/* 41 */         userIds.add(userId);
/*    */       }
/*    */     }
/*    */     
/* 45 */     super.lock(User.getTable(), userIds);
/*    */     
/* 47 */     super.lock(Role2properties.getTable(), this.roleIdSet);
/*    */     
/* 49 */     SSynAllShiTuTaskInfos syn = new SSynAllShiTuTaskInfos();
/* 50 */     for (Long roleId : this.roleIdSet) {
/* 51 */       syn.all_shitu_task_infos.add(ShiTuManager.getAndCheckResetShiTuTaskInfo(roleId.longValue()).shitu_task_info);
/*    */     }
/* 53 */     OnlineManager.getInstance().send(this.roleId, syn);
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PSynAllShiTuTaskInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */