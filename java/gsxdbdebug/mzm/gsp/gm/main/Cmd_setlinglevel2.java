/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PGM_CheckLingLevel;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setlinglevel2
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int itemid;
/*    */   private int level;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 23 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 25 */     if (this.m_arguments == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     int index = 0;
/*    */     
/* 30 */     if (index >= this.m_arguments.size()) {
/* 31 */       return false;
/*    */     }
/* 33 */     Long targetId = null;
/* 34 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 36 */     if (targetId != null)
/*    */     {
/* 38 */       this.roleId = targetId.longValue();
/* 39 */       index++;
/*    */     }
/*    */     
/* 42 */     if (index >= this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     Integer I_itemid = parseInt((String)this.m_arguments.get(index++));
/* 46 */     if (I_itemid == null) {
/* 47 */       return false;
/*    */     }
/* 49 */     this.itemid = I_itemid.intValue();
/*    */     
/* 51 */     if (index >= this.m_arguments.size()) {
/* 52 */       return false;
/*    */     }
/* 54 */     Integer I_level = parseInt((String)this.m_arguments.get(index++));
/* 55 */     if (I_level == null) {
/* 56 */       return false;
/*    */     }
/* 58 */     this.level = I_level.intValue();
/*    */     
/* 60 */     if (index != this.m_arguments.size()) {
/* 61 */       return false;
/*    */     }
/* 63 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 72 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 79 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 85 */         PGM_CheckLingLevel.setLingLevelByItemId(Cmd_setlinglevel2.this.m_gmRole.getRoleid(), Cmd_setlinglevel2.this.roleId, Cmd_setlinglevel2.this.itemid, Cmd_setlinglevel2.this.level);
/* 86 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setlinglevel2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */