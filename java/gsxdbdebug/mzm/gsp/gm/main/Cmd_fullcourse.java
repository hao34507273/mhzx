/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_fullcourse extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private long childid;
/*  9 */   private int random = 1;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 20 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 22 */     if (this.m_arguments == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     int index = 0;
/*    */     
/* 27 */     if (index >= this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     Long targetId = null;
/* 31 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 33 */     if (targetId != null)
/*    */     {
/* 35 */       this.roleId = targetId.longValue();
/* 36 */       index++;
/*    */     }
/*    */     
/* 39 */     if (index >= this.m_arguments.size()) {
/* 40 */       return false;
/*    */     }
/* 42 */     Long L_childid = parseLong((String)this.m_arguments.get(index++));
/* 43 */     if (L_childid == null)
/* 44 */       return false;
/* 45 */     this.childid = L_childid.longValue();
/*    */     
/* 47 */     if (index >= this.m_arguments.size()) {
/* 48 */       return true;
/*    */     }
/* 50 */     Integer I_random = parseInt((String)this.m_arguments.get(index++));
/* 51 */     if (I_random == null) {
/* 52 */       return false;
/*    */     }
/* 54 */     this.random = I_random.intValue();
/*    */     
/* 56 */     if (index != this.m_arguments.size()) {
/* 57 */       return false;
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 75 */     new mzm.gsp.children.childhood.PGM_FullCourse(this.m_gmRole.getRoleid(), this.roleId, this.childid, this.random == 1).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_fullcourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */