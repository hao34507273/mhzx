/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PGM_ReSetPetPoint;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_resetpetpoint
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private long petId;
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
/* 27 */     Long L_roleId = parseLong((String)this.m_arguments.get(index++));
/* 28 */     if (L_roleId == null)
/* 29 */       return false;
/* 30 */     this.roleId = L_roleId.longValue();
/*    */     
/* 32 */     if (index >= this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     Long L_petId = parseLong((String)this.m_arguments.get(index++));
/* 36 */     if (L_petId == null)
/* 37 */       return false;
/* 38 */     this.petId = L_petId.longValue();
/*    */     
/* 40 */     if (index != this.m_arguments.size()) {
/* 41 */       return false;
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 59 */     new PGM_ReSetPetPoint(this.m_gmRole.getRoleid(), this.roleId, this.petId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_resetpetpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */