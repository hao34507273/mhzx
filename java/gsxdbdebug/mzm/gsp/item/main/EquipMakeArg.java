/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ public class EquipMakeArg {
/*    */   public long roleid;
/*    */   public int itemid;
/*    */   public long uuid;
/*    */   public int bagid;
/*    */   
/*    */   EquipMakeArg(long roleid, int itemid, int bagid) {
/* 10 */     this.roleid = roleid;
/* 11 */     this.itemid = itemid;
/* 12 */     this.bagid = bagid;
/*    */   }
/*    */   
/*    */   public long getRoleid() {
/* 16 */     return this.roleid;
/*    */   }
/*    */   
/* 19 */   public void setRoleid(long roleid) { this.roleid = roleid; }
/*    */   
/*    */   public int getItemid() {
/* 22 */     return this.itemid;
/*    */   }
/*    */   
/* 25 */   public void setItemid(int itemid) { this.itemid = itemid; }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getBagid()
/*    */   {
/* 34 */     return this.bagid;
/*    */   }
/*    */   
/* 37 */   public void setBagid(int bagid) { this.bagid = bagid; }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\EquipMakeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */