/*    */ package mzm.gsp.award.event;
/*    */ 
/*    */ import mzm.gsp.award.main.MultiRoleSelectAwardContext;
/*    */ 
/*    */ public class RoleSelectAwardArg {
/*    */   public final long roleid;
/*    */   public final int itemid;
/*    */   public final int itemCount;
/*    */   public final MultiRoleSelectAwardContext context;
/*    */   
/*    */   public RoleSelectAwardArg(long roleid, int itemid, int itemCount, MultiRoleSelectAwardContext context) {
/* 12 */     this.roleid = roleid;
/* 13 */     this.itemCount = itemCount;
/* 14 */     this.itemid = itemid;
/* 15 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\event\RoleSelectAwardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */