/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.bounty.SBrocastBountyItem;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.operation.GetTaskAwardHandler;
/*    */ 
/*    */ public class BountyGetAwardHandler
/*    */   implements GetTaskAwardHandler
/*    */ {
/* 13 */   private static final BountyGetAwardHandler instance = new BountyGetAwardHandler();
/*    */   
/*    */   public static BountyGetAwardHandler getInstance()
/*    */   {
/* 17 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public void bulletinTreasure(long roleId, int graphId, int taskId, Map<Integer, Integer> itemMap)
/*    */   {
/* 23 */     if ((itemMap == null) || (itemMap.size() == 0))
/*    */     {
/* 25 */       return;
/*    */     }
/* 27 */     SBrocastBountyItem brd = new SBrocastBountyItem();
/* 28 */     brd.roleid = roleId;
/* 29 */     brd.rolename = RoleInterface.getName(roleId);
/* 30 */     brd.taskid = taskId;
/* 31 */     brd.itemid2count.putAll(itemMap);
/* 32 */     OnlineManager.getInstance().sendAll(brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\BountyGetAwardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */