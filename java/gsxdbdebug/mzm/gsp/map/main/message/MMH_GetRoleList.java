/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ 
/*    */ 
/*    */ public class MMH_GetRoleList
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldid;
/*    */   private final int mapCfgid;
/*    */   private List<Long> roleList;
/*    */   
/*    */   public MMH_GetRoleList(long worldid)
/*    */   {
/* 19 */     this(worldid, -1);
/*    */   }
/*    */   
/*    */   public MMH_GetRoleList(long worldid, int mapCfgid)
/*    */   {
/* 24 */     this.worldid = worldid;
/* 25 */     this.mapCfgid = mapCfgid;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleList()
/*    */   {
/* 30 */     return this.roleList;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 36 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldid);
/* 37 */     if (instance == null)
/*    */     {
/* 39 */       this.roleList = Collections.emptyList();
/* 40 */       return;
/*    */     }
/*    */     
/* 43 */     if (this.mapCfgid == -1)
/*    */     {
/* 45 */       this.roleList = instance.getAllRole();
/* 46 */       return;
/*    */     }
/*    */     
/* 49 */     Scene scene = instance.getSceneByCfgId(this.mapCfgid);
/* 50 */     if (scene == null)
/*    */     {
/* 52 */       this.roleList = Collections.emptyList();
/* 53 */       return;
/*    */     }
/* 55 */     this.roleList = scene.getRoleList();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetRoleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */