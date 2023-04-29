/*    */ package mzm.gsp.award.drop;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.DropInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2drop;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 27 */     String userid = RoleInterface.getUserId(roleId);
/* 28 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 30 */     DropInfo xDropInfo = Role2drop.get(Long.valueOf(roleId));
/* 31 */     if (xDropInfo == null)
/*    */     {
/*    */ 
/* 34 */       return false;
/*    */     }
/* 36 */     Set<Integer> rmItems = rmUseLessDBData(xDropInfo);
/* 37 */     if (rmItems.size() == 0)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     GameServer.logger().info(String.format("[drop]POnRoleLogin.processImp@rm useless DB data!|roleId=%d|rmItems=%s", new Object[] { Long.valueOf(roleId), rmItems.toString() }));
/*    */     
/*    */ 
/* 44 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private Set<Integer> rmUseLessDBData(DropInfo xDropInfo)
/*    */   {
/* 55 */     Set<Integer> rmItems = new HashSet();
/* 56 */     List<Integer> allItemDropIds = DropManager.getAllGlobalItemDropIds();
/* 57 */     Iterator<Map.Entry<Integer, Integer>> it = xDropInfo.getDropcounts().entrySet().iterator();
/* 58 */     while (it.hasNext())
/*    */     {
/* 60 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 61 */       int itemId = ((Integer)entry.getKey()).intValue();
/* 62 */       if (!allItemDropIds.contains(Integer.valueOf(itemId)))
/*    */       {
/*    */ 
/*    */ 
/* 66 */         rmItems.add(Integer.valueOf(itemId));
/* 67 */         it.remove();
/*    */       } }
/* 69 */     return rmItems;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\drop\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */