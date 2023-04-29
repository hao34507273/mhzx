/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_addbaotu extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int itemid;
/*  9 */   private int mapid = 330000001;
/* 10 */   private int x = 408;
/* 11 */   private int y = 25;
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
/* 25 */       return false;
/*    */     }
/* 27 */     int index = 0;
/*    */     
/* 29 */     if (index >= this.m_arguments.size()) {
/* 30 */       return false;
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
/* 42 */       return false;
/*    */     }
/* 44 */     Integer I_itemid = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_itemid == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.itemid = I_itemid.intValue();
/*    */     
/* 50 */     if (index >= this.m_arguments.size()) {
/* 51 */       return true;
/*    */     }
/* 53 */     Integer I_mapid = parseInt((String)this.m_arguments.get(index++));
/* 54 */     if (I_mapid == null) {
/* 55 */       return false;
/*    */     }
/* 57 */     this.mapid = I_mapid.intValue();
/*    */     
/* 59 */     if (index >= this.m_arguments.size()) {
/* 60 */       return true;
/*    */     }
/* 62 */     Integer I_x = parseInt((String)this.m_arguments.get(index++));
/* 63 */     if (I_x == null) {
/* 64 */       return false;
/*    */     }
/* 66 */     this.x = I_x.intValue();
/*    */     
/* 68 */     if (index >= this.m_arguments.size()) {
/* 69 */       return true;
/*    */     }
/* 71 */     Integer I_y = parseInt((String)this.m_arguments.get(index++));
/* 72 */     if (I_y == null) {
/* 73 */       return false;
/*    */     }
/* 75 */     this.y = I_y.intValue();
/*    */     
/* 77 */     if (index != this.m_arguments.size()) {
/* 78 */       return false;
/*    */     }
/* 80 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 89 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 96 */     new mzm.gsp.item.main.PGM_AddBaotu(this.m_gmRole.getRoleid(), this.roleId, this.itemid, this.mapid, this.x, this.y).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addbaotu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */