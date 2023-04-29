/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class Cmd_leitaipvp extends CmdBase
/*    */ {
/*  9 */   private ArrayList<String> name = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 27 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 30 */       if (index >= this.m_arguments.size()) {
/* 31 */         return false;
/*    */       }
/* 33 */       this.name.add(this.m_arguments.get(index++));
/*    */     }
/* 35 */     if (index != this.m_arguments.size()) {
/* 36 */       return false;
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 52 */     if (this.name.size() <= 0) {
/* 53 */       return;
/*    */     }
/* 55 */     Long targetId = null;
/* 56 */     targetId = xtable.Name2roleid.select((String)this.name.get(0));
/*    */     
/* 58 */     if (targetId != null) {
/* 59 */       if (this.name.size() > 1) {
/* 60 */         Long targetId2 = null;
/* 61 */         targetId2 = xtable.Name2roleid.select((String)this.name.get(1));
/* 62 */         if (targetId2 != null) {
/* 63 */           boolean activeInTeam = TeamInterface.isRoleInTeam(targetId.longValue(), false);
/* 64 */           boolean passiveInTeam = TeamInterface.isRoleInTeam(targetId2.longValue(), false);
/* 65 */           mzm.gsp.leitai.main.LeiTaiFightContext leiTaiFightContext = new mzm.gsp.leitai.main.LeiTaiFightContext(targetId.longValue(), activeInTeam, targetId2.longValue(), passiveInTeam);
/*    */           
/* 67 */           Role.addRoleProcedure(targetId.longValue(), new mzm.gsp.fight.main.PGM_PVPFight(targetId.longValue(), targetId2.longValue(), leiTaiFightContext));
/*    */         }
/*    */       }
/*    */       else {
/* 71 */         long active = this.m_gmRole.getRoleid();
/* 72 */         boolean activeInTeam = TeamInterface.isRoleInTeam(active, false);
/* 73 */         boolean passiveInTeam = TeamInterface.isRoleInTeam(targetId.longValue(), false);
/* 74 */         mzm.gsp.leitai.main.LeiTaiFightContext leiTaiFightContext = new mzm.gsp.leitai.main.LeiTaiFightContext(active, activeInTeam, targetId.longValue(), passiveInTeam);
/*    */         
/* 76 */         Role.addRoleProcedure(this.m_gmRole.getRoleid(), new mzm.gsp.fight.main.PGM_PVPFight(active, targetId.longValue(), leiTaiFightContext));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_leitaipvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */