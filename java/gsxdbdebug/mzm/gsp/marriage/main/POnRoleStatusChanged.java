/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.status.event.RoleStatusChangeArg;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ import xtable.Marriageparade;
/*    */ 
/*    */ public class POnRoleStatusChanged extends mzm.gsp.status.event.RoleStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     lock(xtable.Role2marriage.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(((RoleStatusChangeArg)this.arg).roleid) }));
/* 16 */     MarriageParades xMarriageParades = Marriageparade.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 17 */     if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 18 */       return false;
/*    */     }
/* 20 */     MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 21 */     long roleid1 = xMarriageParade.getRoleid1();
/* 22 */     long roleid2 = xMarriageParade.getRoleid2();
/* 23 */     if ((((RoleStatusChangeArg)this.arg).roleid != roleid1) && (((RoleStatusChangeArg)this.arg).roleid != roleid2)) {
/* 24 */       return false;
/*    */     }
/* 26 */     boolean inFight = ((RoleStatusChangeArg)this.arg).addedset.contains(Integer.valueOf(0));
/* 27 */     boolean outFight = ((RoleStatusChangeArg)this.arg).remedSet.contains(Integer.valueOf(0));
/* 28 */     boolean isBride = mzm.gsp.role.main.RoleInterface.getGender(((RoleStatusChangeArg)this.arg).roleid) == 2;
/* 29 */     if (inFight) {
/* 30 */       if (isBride) {
/* 31 */         xMarriageParade.setBridefightstatus(MarriageManager.setFightStatus(1, xMarriageParade.getBridefightstatus()));
/*    */         
/* 33 */         xMarriageParade.setBridefightstatus(MarriageManager.unsetFightState(4, xMarriageParade.getBridefightstatus()));
/*    */       }
/*    */       else {
/* 36 */         xMarriageParade.setGroomfightstatus(MarriageManager.setFightStatus(1, xMarriageParade.getGroomfightstatus()));
/*    */         
/* 38 */         xMarriageParade.setGroomfightstatus(MarriageManager.unsetFightState(4, xMarriageParade.getGroomfightstatus()));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 43 */     if (outFight) {
/* 44 */       if (isBride) {
/* 45 */         xMarriageParade.setBridefightstatus(MarriageManager.setFightStatus(4, xMarriageParade.getBridefightstatus()));
/*    */       }
/*    */       else {
/* 48 */         xMarriageParade.setGroomfightstatus(MarriageManager.setFightStatus(4, xMarriageParade.getGroomfightstatus()));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnRoleStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */