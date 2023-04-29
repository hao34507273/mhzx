/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GiveItemArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final long receiveItemRoleId;
/*    */   public final Map<Integer, Integer> itemCfgId2Num;
/*    */   
/*    */   public GiveItemArg(long roleId, long receiveItemRoleId, Map<Integer, Integer> itemCfgId2Num)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.receiveItemRoleId = receiveItemRoleId;
/* 17 */     this.itemCfgId2Num = itemCfgId2Num;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\GiveItemArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */