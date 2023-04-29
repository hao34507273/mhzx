/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import xbean.GroupInfo;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ public class POnRoleLevelUp extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/*    */     
/* 15 */     GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(roleid));
/* 16 */     if (xGroupInfo == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     GroupAsynTaskManager.getInstance().addTask(new PMemberLeveluUpNotify(roleid, xGroupInfo.getCreate_same_zone_groupids().keySet(), xGroupInfo.getJoin_same_zone_groupids().keySet(), ((RoleLevelUpArg)this.arg).newLevel));
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */