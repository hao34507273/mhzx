/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.skill.SSyncTempSkillListAdd;
/*    */ import xbean.RoleTempSkillList;
/*    */ import xtable.Role2skillbag;
/*    */ import xtable.Role2tempskill;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     xbean.RoleSkillBags xRoleSkillBags = Role2skillbag.get((Long)this.arg);
/* 18 */     if (xRoleSkillBags == null)
/*    */     {
/*    */ 
/*    */ 
/* 22 */       MenPaiSkillBagManager.getInstance().openFunction(((Long)this.arg).longValue());
/* 23 */       return true;
/*    */     }
/*    */     
/* 26 */     MenPaiSkillBagManager.getInstance().syncBagInfo(xRoleSkillBags, ((Long)this.arg).longValue());
/*    */     
/* 28 */     RoleTempSkillList xRoleTempSkillList = Role2tempskill.get((Long)this.arg);
/* 29 */     if (xRoleTempSkillList != null) {
/* 30 */       SSyncTempSkillListAdd sSyncTempSkillListAdd = new SSyncTempSkillListAdd();
/* 31 */       for (Map.Entry<Integer, Integer> skillEntry : xRoleTempSkillList.getSkilllist().entrySet()) {
/* 32 */         sSyncTempSkillListAdd.skillmap.put(skillEntry.getKey(), skillEntry.getValue());
/*    */       }
/* 34 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncTempSkillListAdd);
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */