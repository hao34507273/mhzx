/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.ShiTuActiveInfo;
/*    */ import mzm.gsp.shitu.SynAllShiTuActiveInfos;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSynAllShiTuActiveInfos
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Set<Long> roleIdSet;
/*    */   
/*    */   public PSynAllShiTuActiveInfos(long roleId, Set<Long> roleIdSet)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.roleIdSet = roleIdSet;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     Set<Long> lockRoleIdSet = new HashSet(this.roleIdSet);
/* 35 */     lockRoleIdSet.add(Long.valueOf(this.roleId));
/*    */     
/* 37 */     Set<String> userIds = new HashSet();
/*    */     
/* 39 */     for (Long roleId : lockRoleIdSet)
/*    */     {
/* 41 */       String userId = RoleInterface.getUserId(roleId.longValue());
/* 42 */       if (userId != null)
/*    */       {
/*    */ 
/*    */ 
/* 46 */         userIds.add(userId);
/*    */       }
/*    */     }
/*    */     
/* 50 */     super.lock(User.getTable(), userIds);
/*    */     
/* 52 */     super.lock(Role2properties.getTable(), lockRoleIdSet);
/*    */     
/* 54 */     List<ShiTuActiveInfo> shiTuActiveInfoList = ShiTuManager.getAndCheckResetShiTuActiveInfo(this.roleId, this.roleIdSet);
/*    */     
/*    */ 
/* 57 */     SynAllShiTuActiveInfos syn = new SynAllShiTuActiveInfos();
/* 58 */     syn.all_shitu_active_infos.addAll(shiTuActiveInfoList);
/* 59 */     OnlineManager.getInstance().send(this.roleId, syn);
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PSynAllShiTuActiveInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */