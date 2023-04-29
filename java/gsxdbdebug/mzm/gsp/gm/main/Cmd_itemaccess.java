/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.PQueryItemAccessWay;
/*    */ import mzm.gsp.item.main.PQueryItemSiftCfgAccessWay;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_itemaccess
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int itemid;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 26 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 28 */     if (this.m_arguments == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     int index = 0;
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Long targetId = null;
/* 37 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 39 */     if (targetId != null)
/*    */     {
/* 41 */       this.roleId = targetId.longValue();
/* 42 */       index++;
/*    */     }
/*    */     
/* 45 */     if (index >= this.m_arguments.size()) {
/* 46 */       return false;
/*    */     }
/* 48 */     Integer I_itemid = parseInt((String)this.m_arguments.get(index++));
/* 49 */     if (I_itemid == null) {
/* 50 */       return false;
/*    */     }
/* 52 */     this.itemid = I_itemid.intValue();
/*    */     
/* 54 */     if (index != this.m_arguments.size()) {
/* 55 */       return false;
/*    */     }
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 66 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 74 */     if (ItemInterface.isItemExist(this.itemid))
/*    */     {
/* 76 */       List<Integer> itemliList = new ArrayList();
/* 77 */       itemliList.add(Integer.valueOf(this.itemid));
/* 78 */       PQueryItemAccessWay p = new PQueryItemAccessWay(this.roleId, itemliList);
/* 79 */       p.execute();
/*    */     }
/*    */     else {
/* 82 */       PQueryItemSiftCfgAccessWay pQueryItemAccessWay = new PQueryItemSiftCfgAccessWay(this.roleId, this.itemid);
/* 83 */       pQueryItemAccessWay.execute();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_itemaccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */