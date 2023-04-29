/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*    */ import mzm.gsp.children.event.ChildShowModelChangeProcedure;
/*    */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleChildShowModelChange;
/*    */ 
/*    */ public class POnRoleChildShowModelChange extends ChildShowModelChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((ChildShowModelChangeArg)this.arg).roleId;
/* 14 */     ChildShowModelChangeReason reason = ((ChildShowModelChangeArg)this.arg).changeReason;
/* 15 */     mzm.gsp.children.main.ChildrenInterface.ShowChildObj showChildObj = ChildrenInterface.getShowChildObj(roleid, true);
/* 16 */     new MMH_OnRoleChildShowModelChange(roleid, reason, showChildObj).execute();
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleChildShowModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */