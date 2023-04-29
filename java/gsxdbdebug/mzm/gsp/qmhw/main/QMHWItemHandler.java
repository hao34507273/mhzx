/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.main.ItemReasonHandler;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qmhw.SBrocastQMHWItem;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class QMHWItemHandler implements ItemReasonHandler
/*    */ {
/* 12 */   private static final QMHWItemHandler instance = new QMHWItemHandler();
/*    */   
/*    */   public static QMHWItemHandler getInstance() {
/* 15 */     return instance;
/*    */   }
/*    */   
/*    */   public void gainPreciousItem(long roleid, Map<Integer, Integer> itemid2num)
/*    */   {
/* 20 */     SBrocastQMHWItem brd = new SBrocastQMHWItem();
/* 21 */     brd.rolename = RoleInterface.getName(roleid);
/* 22 */     brd.roleid = roleid;
/* 23 */     brd.item2count.putAll(itemid2num);
/* 24 */     OnlineManager.getInstance().sendAll(brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */