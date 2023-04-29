/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.arena.SGainPreciousItemsBrd;
/*    */ import mzm.gsp.item.main.ItemReasonHandler;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArenaItemHandler
/*    */   implements ItemReasonHandler
/*    */ {
/* 17 */   private static final ArenaItemHandler instance = new ArenaItemHandler();
/*    */   
/*    */   public static ArenaItemHandler getInstance() {
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */   public void gainPreciousItem(long roleid, Map<Integer, Integer> itemid2num)
/*    */   {
/* 25 */     SGainPreciousItemsBrd brd = new SGainPreciousItemsBrd();
/* 26 */     brd.roleid = roleid;
/* 27 */     brd.name = RoleInterface.getName(roleid);
/* 28 */     brd.items.putAll(itemid2num);
/* 29 */     OnlineManager.getInstance().sendAll(brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */