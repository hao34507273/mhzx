/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum MapEntityType
/*     */ {
/*  11 */   MET_FURNITURE(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  16 */   MGT_SERVANT(true, false, true), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   MGT_EXPLORE_CAT(true, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   MGT_HOME_LAND_BASIC_INFO(false, true, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   MGT_WORLD_GOAL_INFO(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   MGT_FLOOR_TILE(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   MGT_WALLPAPER(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   MET_CHILDREN(true, false, true), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   MET_ANIMAL(false, false, true), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   MET_MYSTERY_VISITOR(true, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   MET_BARRIERS(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   MET_ROADS(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   MET_TERRAIN(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   MET_SINGLE_BATTLE_POSITION(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   MET_SINGLE_BATTLE_GATHER_ITEM(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   MET_SINGLE_BATTLE_BUFF(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   MET_GOLD_STATUE(true, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   MET_FLOAT_PARADE(true, false, true), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   MET_CAKE_OVEN(false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   MET_CHRISTMAS_STOCKING(true, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   MET_BALL_BATTLE_GROUND_ITEM(true, false, false);
/*     */   
/* 113 */   private static List<MapEntityType> notOwnViewMapEntityTypes = Arrays.asList(new MapEntityType[] { MET_FURNITURE, MGT_HOME_LAND_BASIC_INFO, MGT_WORLD_GOAL_INFO, MGT_FLOOR_TILE, MGT_WALLPAPER, MET_ANIMAL, MET_BARRIERS, MET_ROADS, MET_TERRAIN, MET_SINGLE_BATTLE_POSITION, MET_SINGLE_BATTLE_GATHER_ITEM, MET_SINGLE_BATTLE_BUFF, MET_CAKE_OVEN });
/*     */   private final boolean ownView;
/*     */   private final boolean worldShare;
/*     */   private final boolean moveable;
/*     */   
/*     */   public static List<MapEntityType> notOwnViewMapEntityTypes() {
/* 119 */     return notOwnViewMapEntityTypes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isOwnView()
/*     */   {
/* 130 */     return this.ownView;
/*     */   }
/*     */   
/*     */   public final boolean isWorldShare()
/*     */   {
/* 135 */     return this.worldShare;
/*     */   }
/*     */   
/*     */   public final boolean canMove()
/*     */   {
/* 140 */     return this.moveable;
/*     */   }
/*     */   
/*     */   private MapEntityType(boolean ownView, boolean worldShare, boolean moveable)
/*     */   {
/* 145 */     this.ownView = ownView;
/* 146 */     this.worldShare = worldShare;
/* 147 */     this.moveable = moveable;
/*     */     
/* 149 */     if ((moveable) && (worldShare))
/*     */     {
/* 151 */       throw new RuntimeException(String.format("[map]MapEntityType.construct@map entity type init error|own_view=%b|world_share=%b|moveable=%b", new Object[] { Boolean.valueOf(this.ownView), Boolean.valueOf(this.worldShare), Boolean.valueOf(this.moveable) }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapEntityType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */