/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.paraselene.main.JigsawInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_pintu
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int cfgid;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 22 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 24 */     if (this.m_arguments == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     int index = 0;
/*    */     
/* 29 */     if (index >= this.m_arguments.size()) {
/* 30 */       return false;
/*    */     }
/* 32 */     Long targetId = null;
/* 33 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 35 */     if (targetId != null)
/*    */     {
/* 37 */       this.roleId = targetId.longValue();
/* 38 */       index++;
/*    */     }
/*    */     
/* 41 */     if (index >= this.m_arguments.size()) {
/* 42 */       return false;
/*    */     }
/* 44 */     Integer I_cfgid = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_cfgid == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.cfgid = I_cfgid.intValue();
/*    */     
/* 50 */     if (index != this.m_arguments.size()) {
/* 51 */       return false;
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 62 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 70 */     List<Long> roleids = TeamInterface.getNormalRoleList(this.roleId);
/* 71 */     if (roleids.size() == 0) {
/* 72 */       roleids.add(Long.valueOf(this.roleId));
/*    */     }
/* 74 */     JigsawInterface.startJigsaw(roleids, this.cfgid, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_pintu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */