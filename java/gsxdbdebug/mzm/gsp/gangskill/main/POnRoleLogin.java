/*    */ package mzm.gsp.gangskill.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.role.multirank.MultiFightValueRankManager;
/*    */ import mzm.gsp.role.multirank.RoleMultiFightValueChart;
/*    */ import mzm.gsp.skill.confbean.GangSkillConst;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long roleid = ((Long)this.arg).longValue();
/* 19 */     if (RoleInterface.getLevel(roleid) < GangSkillConst.getInstance().ENABLE_GANG_SKILL_ROLE_LEVEL) {
/* 20 */       return false;
/*    */     }
/* 22 */     boolean changed = false;
/* 23 */     for (Integer num : GangSkillManager.getAllSkillids()) {
/* 24 */       if (GangSkillManager.addGangSkill(roleid, num.intValue(), 0)) {
/* 25 */         changed = true;
/*    */       }
/*    */     }
/* 28 */     if (changed) {
/* 29 */       GangSkillManager.triggerGankSkillChangedEvent(roleid);
/*    */     }
/* 31 */     GangSkillManager.synGangSkill(roleid);
/*    */     
/* 33 */     List<RoleMultiFightValueChart> rankObjs = MultiFightValueRankManager.getInstance().getRankObjs(0, 2);
/* 34 */     for (int i = 0; i < rankObjs.size(); i++) {
/* 35 */       RoleMultiFightValueChart roleFightValueChart = (RoleMultiFightValueChart)rankObjs.get(i);
/* 36 */       if (roleFightValueChart.getRoleid() == roleid) {
/* 37 */         sendToast("{e:0208}{e:0210}{e:0210} [ff0000]排行榜第[-] [0000ff]  " + (i + 1) + " [-] [ff0000]名 【[-][FF0033]" + RoleInterface.getName(roleid) + "[-][ff0000]】上线了[-] {e:0210}{e:0210}{e:0208}");
/* 38 */         return true;
/*    */       }
/*    */     }
/* 41 */     return true;
/*    */   }
/*    */   
/* 44 */   private void sendToast(String message) { SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 45 */     messagetip.result = 42;
/* 46 */     messagetip.args.add(message);
/* 47 */     OnlineManager.getInstance().sendAllAtOnce(messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangskill\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */