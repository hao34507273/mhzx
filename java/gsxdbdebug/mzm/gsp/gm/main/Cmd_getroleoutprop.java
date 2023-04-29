/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.main.PropertyManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_getroleoutprop
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 24 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 26 */     if (this.m_arguments == null) {
/* 27 */       return true;
/*    */     }
/* 29 */     int index = 0;
/*    */     
/* 31 */     if (index >= this.m_arguments.size()) {
/* 32 */       return true;
/*    */     }
/* 34 */     Long targetId = null;
/* 35 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 37 */     if (targetId != null)
/*    */     {
/* 39 */       this.roleId = targetId.longValue();
/* 40 */       index++;
/*    */     }
/*    */     
/* 43 */     if (index != this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 55 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 61 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 67 */         RoleOutFightObj role = RoleInterface.getRoleOutFightObject(Cmd_getroleoutprop.this.roleId);
/* 68 */         Map<Integer, Integer> props = role.getFinalPropertyMap();
/* 69 */         GmManager.getInstance().sendResultToGM(Cmd_getroleoutprop.this.roleId, PropertyManager.getPropCHNInfo(props));
/* 70 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_getroleoutprop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */