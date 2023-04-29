/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.SUseFireWorksItemRes;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCUseFireWorksItem
/*    */   extends LogicProcedure implements MapCallback<Map<Long, Position>>
/*    */ {
/*    */   private final long roleid;
/*    */   private final long uuid;
/*    */   
/*    */   public PCUseFireWorksItem(long roleid, long uuid)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.uuid = uuid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 31 */       String logStr = String.format("[item]PCUseFireWorksItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 32 */       ItemManager.logger.info(logStr);
/* 33 */       return false;
/*    */     }
/* 35 */     MapInterface.getRolePosition(this.roleid, this);
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public boolean onResult(Map<Long, Position> result)
/*    */   {
/* 46 */     Position position = (Position)result.get(Long.valueOf(this.roleid));
/* 47 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/* 48 */     if (item == null) {
/* 49 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 50 */       return false;
/*    */     }
/* 52 */     SItemCfg fireWorksItemCfg = SItemCfg.get(item.getCfgId());
/* 53 */     if ((fireWorksItemCfg == null) || (fireWorksItemCfg.type != 75)) {
/* 54 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_FIREWORKS_REM);
/* 59 */     boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/* 60 */     if (ret)
/*    */     {
/* 62 */       SUseFireWorksItemRes useFireWorksItemRes = new SUseFireWorksItemRes();
/* 63 */       useFireWorksItemRes.roleid = this.roleid;
/* 64 */       useFireWorksItemRes.itemcfgid = fireWorksItemCfg.id;
/* 65 */       int mapCfgid = MapInterface.getRoleMapId(this.roleid);
/* 66 */       useFireWorksItemRes.mapcfgid = mapCfgid;
/* 67 */       useFireWorksItemRes.x = position.getX();
/* 68 */       useFireWorksItemRes.y = position.getY();
/*    */       
/* 70 */       MapInterface.brocadCastInSomebodyView(this.roleid, useFireWorksItemRes, false);
/*    */       
/* 72 */       OnlineManager.getInstance().send(this.roleid, useFireWorksItemRes);
/*    */     }
/* 74 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCUseFireWorksItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */