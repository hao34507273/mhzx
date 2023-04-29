/*    */ package mzm.gsp.map.main.scene.zone.type;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.main.proto.Cell;
/*    */ import mzm.gsp.map.main.scene.object.MapEntity;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.map.main.scene.zone.SimpleZone;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import mzm.gsp.map.main.scene.zone.type.event.IInnerZoneListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventZone
/*    */   extends SimpleZone
/*    */ {
/* 22 */   private Set<IInnerZoneListener> zoneListener = new HashSet();
/* 23 */   private List<Cell> regionCells = new ArrayList();
/*    */   
/*    */   public EventZone(ZoneForm zoneForm, int zoneSpace)
/*    */   {
/* 27 */     super(zoneForm, zoneSpace);
/*    */   }
/*    */   
/*    */   public void addZoneListener(IInnerZoneListener izl)
/*    */   {
/* 32 */     this.zoneListener.add(izl);
/*    */   }
/*    */   
/*    */   public void addCell(Cell cell)
/*    */   {
/* 37 */     this.regionCells.add(cell);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onEnterRole(MapRole obj)
/*    */   {
/* 43 */     long roleid = obj.getRoleId();
/* 44 */     for (IInnerZoneListener izl : this.zoneListener)
/*    */     {
/* 46 */       izl.onEnterRole(roleid, this.bbox);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void onLeaveRole(MapRole obj)
/*    */   {
/* 53 */     long roleid = obj.getRoleId();
/* 54 */     for (IInnerZoneListener izl : this.zoneListener)
/*    */     {
/* 56 */       izl.onLeaveRole(roleid, this.bbox);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void onEnterEntity(MapEntity obj)
/*    */   {
/* 63 */     MapEntityType mapEntityType = obj.getEntityType();
/* 64 */     long mapEntityInstanceid = obj.getInstanceid().longValue();
/* 65 */     for (IInnerZoneListener izl : this.zoneListener)
/*    */     {
/* 67 */       izl.onEnterMapEntity(mapEntityType, mapEntityInstanceid, this.bbox);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void onLeaveEntity(MapEntity obj)
/*    */   {
/* 74 */     MapEntityType mapEntityType = obj.getEntityType();
/* 75 */     long mapEntityInstanceid = obj.getInstanceid().longValue();
/* 76 */     for (IInnerZoneListener izl : this.zoneListener)
/*    */     {
/* 78 */       izl.onLeaveMapEntity(mapEntityType, mapEntityInstanceid, this.bbox);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void release()
/*    */   {
/* 85 */     for (Cell cell : this.regionCells)
/*    */     {
/* 87 */       cell.removeZone(this);
/*    */     }
/* 89 */     this.regionCells.clear();
/* 90 */     this.regionCells = null;
/*    */     
/* 92 */     this.zoneListener.clear();
/* 93 */     this.zoneListener = null;
/*    */     
/* 95 */     super.release();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\type\EventZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */