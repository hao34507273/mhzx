/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.jiuxiao.main.PGM_EnterJiuXiaoMap;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ public class Cmd_jiuxiaomap
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int floor;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 17 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     Long targetId = null;
/* 28 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 30 */     if (targetId != null)
/*    */     {
/* 32 */       this.roleId = targetId.longValue();
/* 33 */       index++;
/*    */     }
/*    */     
/* 36 */     if (index >= this.m_arguments.size()) {
/* 37 */       return false;
/*    */     }
/* 39 */     Integer I_floor = parseInt((String)this.m_arguments.get(index++));
/* 40 */     if (I_floor == null) {
/* 41 */       return false;
/*    */     }
/* 43 */     this.floor = I_floor.intValue();
/*    */     
/* 45 */     if (index != this.m_arguments.size()) {
/* 46 */       return false;
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 56 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 62 */     Role.addRoleProcedure(this.roleId, new PGM_EnterJiuXiaoMap(this.roleId, this.floor));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_jiuxiaomap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */