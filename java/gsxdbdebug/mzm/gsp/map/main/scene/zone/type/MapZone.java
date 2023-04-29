/*    */ package mzm.gsp.map.main.scene.zone.type;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapZone
/*    */   extends EventZone
/*    */ {
/*    */   protected int id;
/*    */   
/*    */   public MapZone(int zoneId, ZoneForm zoneForm)
/*    */   {
/* 15 */     super(zoneForm, 1);
/* 16 */     this.id = zoneId;
/*    */   }
/*    */   
/*    */   public int getId()
/*    */   {
/* 21 */     return this.id;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\type\MapZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */