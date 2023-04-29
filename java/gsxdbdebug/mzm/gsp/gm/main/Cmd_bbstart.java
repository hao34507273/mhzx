/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.ballbattle.main.RGM_BallBattleStart;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_bbstart
/*    */   extends CmdBase
/*    */ {
/*    */   private int activityId;
/*    */   private String roleIds;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     Integer I_activityId = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_activityId == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.activityId = I_activityId.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     this.roleIds = ((String)this.m_arguments.get(index++));
/* 37 */     if (index != this.m_arguments.size()) {
/* 38 */       return false;
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 54 */     new RGM_BallBattleStart(this.m_gmRole.getRoleid(), this.activityId, this.roleIds).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_bbstart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */