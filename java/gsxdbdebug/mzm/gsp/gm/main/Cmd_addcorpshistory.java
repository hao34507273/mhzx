/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_addcorpshistory extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int type;
/*  9 */   private ArrayList<String> parameters = new ArrayList();
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
/* 42 */     Integer I_type = parseInt((String)this.m_arguments.get(index++));
/* 43 */     if (I_type == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.type = I_type.intValue();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 51 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 54 */       if (index >= this.m_arguments.size()) {
/* 55 */         return false;
/*    */       }
/* 57 */       this.parameters.add(this.m_arguments.get(index++));
/*    */     }
/* 59 */     if (index != this.m_arguments.size()) {
/* 60 */       return false;
/*    */     }
/* 62 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 71 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 77 */     new mzm.gsp.corps.main.PGM_AddCorpsHistory(this.roleId, this.type, this.parameters).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addcorpshistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */