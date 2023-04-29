/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapConfiguration
/*    */ {
/* 10 */   public static int GRID_SIZE = 8;
/* 11 */   public static int VIEW_WIDTH = 640;
/* 12 */   public static int VIEW_HEIGHT = 640;
/* 13 */   public static int NPC_STEP_LENGTH = 16;
/*    */   
/* 15 */   public static long MAP_UPDATE_INTERIVAL = 500L;
/* 16 */   public static long SCENE_LOG_INTERVAL = 60000L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public static long SCENE_PROTECT_DURATION = 5L;
/*    */   
/*    */   public static void init(Map<String, String> args)
/*    */   {
/* 25 */     GRID_SIZE = Integer.parseInt((String)args.get("gridSize"));
/* 26 */     VIEW_WIDTH = Integer.parseInt((String)args.get("viewWidth"));
/* 27 */     VIEW_HEIGHT = Integer.parseInt((String)args.get("viewHeight"));
/*    */     
/* 29 */     MAP_UPDATE_INTERIVAL = Long.parseLong((String)args.get("mapUpdateInterval"));
/* 30 */     NPC_STEP_LENGTH = Integer.parseInt((String)args.get("npcStepLength"));
/* 31 */     SCENE_LOG_INTERVAL = Long.parseLong((String)args.get("sceneLogInterval"));
/* 32 */     SCENE_PROTECT_DURATION = Long.parseLong((String)args.get("sceneProtectDuration"));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */