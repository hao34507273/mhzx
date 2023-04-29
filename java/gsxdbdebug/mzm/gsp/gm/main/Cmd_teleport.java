/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ 
/*    */ public class Cmd_teleport extends CmdBase
/*    */ {
/*    */   private long roleId;
/*  9 */   private int mapId = 1;
/* 10 */   private int posX = 1;
/* 11 */   private int posY = 1;
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
/* 22 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 24 */     if (this.m_arguments == null) {
/* 25 */       return true;
/*    */     }
/* 27 */     int index = 0;
/*    */     
/* 29 */     if (index >= this.m_arguments.size()) {
/* 30 */       return true;
/*    */     }
/* 32 */     Long targetId = null;
/* 33 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 35 */     if (targetId != null)
/*    */     {
/* 37 */       this.roleId = targetId.longValue();
/* 38 */       index++;
/*    */     }
/*    */     
/* 41 */     if (index >= this.m_arguments.size()) {
/* 42 */       return true;
/*    */     }
/* 44 */     Integer I_mapId = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_mapId == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.mapId = I_mapId.intValue();
/*    */     
/* 50 */     if (index >= this.m_arguments.size()) {
/* 51 */       return true;
/*    */     }
/* 53 */     Integer I_posX = parseInt((String)this.m_arguments.get(index++));
/* 54 */     if (I_posX == null) {
/* 55 */       return false;
/*    */     }
/* 57 */     this.posX = I_posX.intValue();
/*    */     
/* 59 */     if (index >= this.m_arguments.size()) {
/* 60 */       return true;
/*    */     }
/* 62 */     Integer I_posY = parseInt((String)this.m_arguments.get(index++));
/* 63 */     if (I_posY == null) {
/* 64 */       return false;
/*    */     }
/* 66 */     this.posY = I_posY.intValue();
/*    */     
/* 68 */     if (index != this.m_arguments.size()) {
/* 69 */       return false;
/*    */     }
/* 71 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 80 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 86 */     new mzm.gsp.map.main.message.MMH_GMCmdTeleportToDefaultPos(this.m_gmRole.getRoleid(), this.roleId, this.mapId, this.posX, this.posY).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_teleport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */