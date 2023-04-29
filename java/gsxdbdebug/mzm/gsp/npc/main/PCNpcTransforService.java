/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import mzm.gsp.bulletin.main.BulletinInterface;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.PGM_DeleteItem;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.ZanZhuTeam;
/*    */ import mzm.gsp.npc.confbean.SServiceTransfor;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCNpcTransforService
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int needitem;
/*    */   private final int fightitem;
/*    */   private int npcid;
/*    */   private int serviceid;
/*    */   private long roleid;
/*    */   
/*    */   public PCNpcTransforService(long var1, int var3, int var4)
/*    */   {
/* 27 */     this.npcid = var3;
/* 28 */     this.serviceid = var4;
/* 29 */     this.roleid = var1;
/* 30 */     this.needitem = SServiceTransfor.get(this.serviceid).needitem;
/* 31 */     this.fightitem = SServiceTransfor.get(this.serviceid).fightitem;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 35 */     if (!NpcServiceManager.checkNpcService(this.npcid, this.serviceid, this.roleid)) {
/* 36 */       return false;
/*    */     }
/* 38 */     Long var1 = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 39 */     int var2 = ItemInterface.getItemNumberById(this.roleid, this.needitem);
/* 40 */     int var3 = ItemInterface.getItemNumberById(this.roleid, this.fightitem);
/* 41 */     SServiceTransfor var4 = NpcServiceManager.getServiceTransfor(this.serviceid);
/*    */     
/* 43 */     if ((this.needitem == 0) && (this.fightitem == 0)) {
/* 44 */       if (MapInterface.isWorldMap(var4.mapId)) {
/* 45 */         MapInterface.transferToScene(this.roleid, var4.mapId, var4.x, var4.y);
/*    */       } else {
/* 47 */         long var5 = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 48 */         MapInterface.transferToScene(this.roleid, var5, var4.mapId, var4.x, var4.y);
/*    */       }
/*    */     } else {
/* 51 */       if (var1 != null) {
/* 52 */         return false;
/*    */       }
/*    */       
/* 55 */       if ((var2 <= 0) && (var3 <= 0)) {
/* 56 */         return false;
/*    */       }
/*    */       
/* 59 */       if (MapInterface.isWorldMap(var4.mapId)) {
/* 60 */         MapInterface.transferToScene(this.roleid, var4.mapId, var4.x, var4.y);
/* 61 */         long var5 = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 62 */         TeamInterface.registerJoinTeam(var5, new ZanZhuTeam());
/* 63 */         if ((this.needitem != 0) || (this.fightitem != 0)) {
/* 64 */           if (this.fightitem != 0) {
/* 65 */             Procedure.execute(new PGM_DeleteItem(this.roleid, 340600000, this.fightitem, 1, 0));
/*    */           }
/*    */           
/* 68 */           if (this.needitem != 0) {
/* 69 */             BulletinInterface.sendNotice("缘聚山海：尊敬的玩家【" + RoleInterface.getName(this.roleid) + "】使用混沌之匙进入了万兽妖谷，妖谷内被其他玩家击败将会回到京城，请各位玩家小心！！！");
/*    */           }
/*    */         }
/*    */       } else {
/* 73 */         long var5 = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 74 */         MapInterface.transferToScene(this.roleid, var5, var4.mapId, var4.x, var4.y);
/*    */       }
/*    */     }
/*    */     
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\PCNpcTransforService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */