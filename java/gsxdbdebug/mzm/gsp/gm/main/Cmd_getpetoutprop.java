/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import mzm.gsp.pet.main.PetOutFightObj;
/*    */ import mzm.gsp.role.main.PropertyManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_getpetoutprop
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 25 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 27 */     if (this.m_arguments == null) {
/* 28 */       return true;
/*    */     }
/* 30 */     int index = 0;
/*    */     
/* 32 */     if (index >= this.m_arguments.size()) {
/* 33 */       return true;
/*    */     }
/* 35 */     Long targetId = null;
/* 36 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 38 */     if (targetId != null)
/*    */     {
/* 40 */       this.roleId = targetId.longValue();
/* 41 */       index++;
/*    */     }
/*    */     
/* 44 */     if (index != this.m_arguments.size()) {
/* 45 */       return false;
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */   
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
/* 62 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 68 */         PetOutFightObj pet = PetInterface.getFightPetOutFightObjById(Cmd_getpetoutprop.this.roleId);
/* 69 */         if (pet == null)
/*    */         {
/* 71 */           GmManager.getInstance().sendResultToGM(Cmd_getpetoutprop.this.roleId, "no fight pet!");
/* 72 */           return false;
/*    */         }
/* 74 */         Map<Integer, Integer> props = pet.getFinalPropertyMap();
/* 75 */         GmManager.getInstance().sendResultToGM(Cmd_getpetoutprop.this.roleId, PropertyManager.getPropCHNInfo(props));
/* 76 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_getpetoutprop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */