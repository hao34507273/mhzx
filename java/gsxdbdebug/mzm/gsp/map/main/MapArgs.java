/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class MapArgs
/*    */ {
/* 11 */   private static MapArgs instance = new MapArgs();
/*    */   
/*    */ 
/*    */ 
/* 15 */   public static MapArgs getInstance() { return instance; }
/*    */   @com.thoughtworks.xstream.annotations.XStreamAlias("fault_positions")
/*    */   @com.thoughtworks.xstream.annotations.XStreamAsAttribute
/* 18 */   List<mzm.gsp.map.main.scene.UnModifyPosition> faultPositions = new java.util.ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void init()
/*    */   {
/* 27 */     instance = (MapArgs)ConfManager.getInstance().getconf("mzm.gsp.map.main.MapArgs");
/* 28 */     if (instance == null)
/*    */     {
/* 30 */       throw new RuntimeException("找不到登陆程序配置：mzm.gsp.map.main.MapArgs");
/*    */     }
/*    */   }
/*    */   
/*    */   public Position randomFaultPos()
/*    */   {
/* 36 */     int size = this.faultPositions.size();
/* 37 */     if (size <= 0)
/*    */     {
/* 39 */       return null;
/*    */     }
/*    */     
/* 42 */     return new Position((Position)this.faultPositions.get(Xdb.random().nextInt(size)));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */