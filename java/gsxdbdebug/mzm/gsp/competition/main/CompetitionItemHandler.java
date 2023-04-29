/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.competition.SGainPreciousItemsBrd;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.item.main.ItemReasonHandler;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class CompetitionItemHandler implements ItemReasonHandler
/*    */ {
/* 15 */   private static final CompetitionItemHandler instance = new CompetitionItemHandler();
/*    */   
/*    */   public static CompetitionItemHandler getInstance() {
/* 18 */     return instance;
/*    */   }
/*    */   
/*    */   public void gainPreciousItem(long roleid, Map<Integer, Integer> itemid2num)
/*    */   {
/* 23 */     String name = RoleInterface.getName(roleid);
/* 24 */     Gang faction = GangInterface.getGangByRoleId(roleid, false);
/* 25 */     if (faction == null) {
/* 26 */       CompetitionManager.logger.error("帮派竞赛玩家 " + roleid + "(" + name + ") 获得珍贵物品出错：居然没有帮派！");
/* 27 */       return;
/*    */     }
/* 29 */     SGainPreciousItemsBrd brd = new SGainPreciousItemsBrd();
/* 30 */     brd.roleid = roleid;
/* 31 */     brd.name = RoleInterface.getName(roleid);
/* 32 */     brd.faction = faction.getName();
/* 33 */     brd.items.putAll(itemid2num);
/* 34 */     OnlineManager.getInstance().sendAll(brd);
/*    */   }
/*    */   
/*    */   void gainPreciousItem(long roleid, int itemid, int itemNum) {
/* 38 */     Map<Integer, Integer> itemid2num = new HashMap();
/* 39 */     itemid2num.put(Integer.valueOf(itemid), Integer.valueOf(itemNum));
/* 40 */     gainPreciousItem(roleid, itemid2num);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */