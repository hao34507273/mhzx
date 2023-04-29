/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.map.confbean.DirectionInfo;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.confbean.SMapFurnitureCfg;
/*     */ import mzm.gsp.map.main.proto.Cell;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapFurniture
/*     */   extends MapEntity
/*     */ {
/*     */   public MapFurniture(MapEntityType entityType, long instanceid, int bornSceneid, int x, int y, int cfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries)
/*     */   {
/*  27 */     super(entityType, instanceid, bornSceneid, x, y, cfgid, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean changeInfos(int x, int y, int cfgid, Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys)
/*     */   {
/*  36 */     if ((removeExtraInfoKeys != null) && (removeExtraInfoKeys.contains(Integer.valueOf(0))))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     Integer oldDir = (Integer)this.intExtraInfos.get(Integer.valueOf(0));
/*  42 */     if (oldDir == null)
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     Integer dir = (Integer)replaceIntExtraInfoEntries.get(Integer.valueOf(0));
/*  48 */     if (dir == null)
/*     */     {
/*  50 */       dir = oldDir;
/*     */     }
/*     */     
/*  53 */     int oldX = this.position.getX();
/*  54 */     int oldY = this.position.getY();
/*  55 */     boolean isChecked = false;
/*  56 */     int sceneid; if ((cfgid != this.cfgid) || (dir != oldDir) || (x != oldX) || (y != oldY))
/*     */     {
/*  58 */       sceneid = this.position.getSceneId();
/*  59 */       if (!onChangeCheck(cfgid, dir.intValue(), sceneid, x, y))
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       isChecked = true;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  69 */       if (!super.changeInfos(x, y, cfgid, replaceIntExtraInfoEntries, replaceLongExtraInfoEntries, replaceStringExtraInfoEntries, removeExtraInfoKeys))
/*     */       {
/*     */ 
/*  72 */         return 0;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  77 */       if (isChecked)
/*     */       {
/*  79 */         setCellsFlag();
/*     */       }
/*     */     }
/*     */     
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean changeExtraInfos(Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys)
/*     */   {
/*  91 */     if ((removeExtraInfoKeys != null) && (removeExtraInfoKeys.contains(Integer.valueOf(0))))
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     Integer oldDir = (Integer)this.intExtraInfos.get(Integer.valueOf(0));
/*  97 */     if (oldDir == null)
/*     */     {
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     Integer dir = (Integer)replaceIntExtraInfoEntries.get(Integer.valueOf(0));
/* 103 */     boolean isChecked = false;
/* 104 */     int sceneid; if ((dir != null) && (dir != oldDir))
/*     */     {
/* 106 */       sceneid = this.position.getSceneId();
/* 107 */       int x = this.position.getX();
/* 108 */       int y = this.position.getY();
/* 109 */       if (!onChangeCheck(this.cfgid, dir.intValue(), sceneid, x, y))
/*     */       {
/* 111 */         return false;
/*     */       }
/*     */       
/* 114 */       isChecked = true;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 119 */       if (!super.changeExtraInfos(replaceIntExtraInfoEntries, replaceLongExtraInfoEntries, replaceStringExtraInfoEntries, removeExtraInfoKeys))
/*     */       {
/*     */ 
/* 122 */         return 0;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 127 */       if (isChecked)
/*     */       {
/* 129 */         setCellsFlag();
/*     */       }
/*     */     }
/*     */     
/* 133 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean onChangeCheck(int cfgid, int dir, int sceneid, int x, int y)
/*     */   {
/* 139 */     unsetCellsFlag();
/*     */     
/* 141 */     if (!check(cfgid, dir, sceneid, x, y))
/*     */     {
/* 143 */       setCellsFlag();
/*     */       
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onAddCheck()
/*     */   {
/* 154 */     Integer dir = (Integer)this.intExtraInfos.get(Integer.valueOf(0));
/* 155 */     if (dir == null)
/*     */     {
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     int sceneid = this.position.getSceneId();
/* 161 */     int x = this.position.getX();
/* 162 */     int y = this.position.getY();
/* 163 */     return check(this.cfgid, dir.intValue(), sceneid, x, y);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onSpawn()
/*     */   {
/* 169 */     super.onSpawn();
/*     */     
/* 171 */     setCellsFlag();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDestroy()
/*     */   {
/* 177 */     unsetCellsFlag();
/*     */     
/* 179 */     super.onDestroy();
/*     */   }
/*     */   
/*     */   private void setCellsFlag()
/*     */   {
/* 184 */     Integer dir = (Integer)this.intExtraInfos.get(Integer.valueOf(0));
/* 185 */     if (dir == null)
/*     */     {
/* 187 */       return;
/*     */     }
/*     */     
/* 190 */     int sceneid = this.position.getSceneId();
/* 191 */     int x = this.position.getX();
/* 192 */     int y = this.position.getY();
/* 193 */     setCellsFlag(this.cfgid, dir.intValue(), sceneid, x, y);
/*     */   }
/*     */   
/*     */   private void setCellsFlag(int furnitureCfgid, int dir, int sceneid, int x, int y)
/*     */   {
/* 198 */     updateCellsFlag(furnitureCfgid, dir, sceneid, x, y, false);
/*     */   }
/*     */   
/*     */   private void unsetCellsFlag()
/*     */   {
/* 203 */     Integer dir = (Integer)this.intExtraInfos.get(Integer.valueOf(0));
/* 204 */     if (dir == null)
/*     */     {
/* 206 */       return;
/*     */     }
/*     */     
/* 209 */     int sceneid = this.position.getSceneId();
/* 210 */     int x = this.position.getX();
/* 211 */     int y = this.position.getY();
/* 212 */     unsetCellsFlag(this.cfgid, dir.intValue(), sceneid, x, y);
/*     */   }
/*     */   
/*     */   private void unsetCellsFlag(int furnitureCfgid, int dir, int sceneid, int x, int y)
/*     */   {
/* 217 */     updateCellsFlag(furnitureCfgid, dir, sceneid, x, y, true);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void updateCellsFlag(int furnitureCfgid, int dir, int sceneid, int x, int y, boolean unsetbit)
/*     */   {
/* 223 */     SMapFurnitureCfg cfg = SMapFurnitureCfg.get(furnitureCfgid);
/* 224 */     if (cfg == null)
/*     */     {
/* 226 */       return;
/*     */     }
/*     */     
/* 229 */     DirectionInfo directionInfo = (DirectionInfo)cfg.directions.get(Integer.valueOf(dir));
/* 230 */     if (directionInfo == null)
/*     */     {
/* 232 */       return;
/*     */     }
/*     */     
/* 235 */     Scene scene = SceneManager.getInstance().getScene(sceneid);
/* 236 */     if (scene == null)
/*     */     {
/* 238 */       return;
/*     */     }
/*     */     
/* 241 */     TestFurnitureCellTypeCond cond = null;
/* 242 */     CellOperation op = null;
/* 243 */     int posEnum = HomelandInterface.getFurniturePosEnum(furnitureCfgid);
/* 244 */     switch (posEnum)
/*     */     {
/*     */ 
/*     */ 
/*     */     case 4: 
/* 249 */       cond = new TestFurnitureCellTypeCond_FurnitureCarpet();
/* 250 */       op = unsetbit ? new CellOP_UnsetFurnitureCarpet() : new CellOP_SetFurnitureCarpet();
/*     */       
/* 252 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 2: 
/* 257 */       cond = new TestFurnitureCellTypeCond_FurnitureWallDecor();
/* 258 */       op = unsetbit ? new CellOP_UnsetFurnitureWallDecor() : new CellOP_SetFurnitureWallDecor();
/*     */       
/* 260 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 3: 
/* 265 */       cond = new TestFurnitureCellTypeCond_FurnitureBlock();
/* 266 */       op = unsetbit ? new CellOP_UnsetFurnitureBlock() : new CellOP_SetFurnitureBlock();
/*     */       
/* 268 */       break;
/*     */     
/*     */     default: 
/* 271 */       return;
/*     */     }
/*     */     
/* 274 */     Logger logger = GameServer.logger();
/* 275 */     SMapConfig mapConfig = scene.getMapConfig();
/* 276 */     int leftTopX = x + directionInfo.offseX;
/* 277 */     int leftTopY = y - directionInfo.offseY;
/* 278 */     int rightBottomX = leftTopX + directionInfo.countX * cfg.cellWidth;
/* 279 */     int rightBottomY = leftTopY + directionInfo.countY * cfg.cellHeight;
/* 280 */     List<Integer> cells = directionInfo.cells;
/* 281 */     int xx = leftTopX; for (int cellCol = 0; xx < rightBottomX; cellCol++)
/*     */     {
/* 283 */       int yy = leftTopY; for (int cellRow = 0; yy < rightBottomY; cellRow++)
/*     */       {
/* 285 */         int cellIndex = cellCol + cellRow * directionInfo.countX;
/* 286 */         if (cellIndex < cells.size())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 291 */           int flags = ((Integer)cells.get(cellIndex)).intValue();
/* 292 */           if (cond.test(flags))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 297 */             Cell cell = scene.createCellIfNeed(mapConfig, xx, yy);
/* 298 */             if (cell != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 303 */               op.operate(cell);
/*     */               
/* 305 */               if (logger.isDebugEnabled())
/*     */               {
/* 307 */                 int mapCellCol = xx / mapConfig.cellWidth;
/* 308 */                 int mapCellRow = yy / mapConfig.cellHeight;
/* 309 */                 int mapCellIndex = mapCellCol + mapConfig.cellCols * mapCellRow;
/* 310 */                 logger.debug(String.format("[map]MapFurniture.updateCellsFlag@set cell flag|furniture_cfgid=%d|direction=%d|sceneid=%d|x=%d|y=%d|map_cfgid=%d|xx=%d|yy=%d|map_cell_col=%d|map_cell_row=%d|map_cell_index=%d|furniture_cell_col=%d|furniture_cell_row=%d|furniture_cell_index=%d", new Object[] { Integer.valueOf(furnitureCfgid), Integer.valueOf(dir), Integer.valueOf(sceneid), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(mapConfig.id), Integer.valueOf(xx), Integer.valueOf(yy), Integer.valueOf(mapCellCol), Integer.valueOf(mapCellRow), Integer.valueOf(mapCellIndex), Integer.valueOf(cellCol), Integer.valueOf(cellRow), Integer.valueOf(cellIndex) }));
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 283 */         yy += cfg.cellHeight;
/*     */       }
/* 281 */       xx += cfg.cellWidth;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean check(int furnitureCfgid, int dir, int sceneid, int x, int y)
/*     */   {
/* 321 */     Scene scene = SceneManager.getInstance().getScene(sceneid);
/* 322 */     if (scene == null)
/*     */     {
/* 324 */       return false;
/*     */     }
/*     */     
/* 327 */     SMapFurnitureCfg cfg = SMapFurnitureCfg.get(furnitureCfgid);
/* 328 */     if (cfg == null)
/*     */     {
/* 330 */       return false;
/*     */     }
/*     */     
/* 333 */     DirectionInfo directionInfo = (DirectionInfo)cfg.directions.get(Integer.valueOf(dir));
/* 334 */     if (directionInfo == null)
/*     */     {
/* 336 */       return false;
/*     */     }
/*     */     
/* 339 */     TestFurnitureCellTypeCond testFurnitureCellTypeCond = null;
/* 340 */     List<CellTestCondition> conds = new ArrayList(2);
/* 341 */     int posEnum = HomelandInterface.getFurniturePosEnum(furnitureCfgid);
/* 342 */     switch (posEnum)
/*     */     {
/*     */ 
/*     */ 
/*     */     case 4: 
/* 347 */       byte flag = 0;
/* 348 */       flag = (byte)(flag | 0x1);
/* 349 */       flag = (byte)(flag | 0x20);
/* 350 */       flag = (byte)(flag | 0x4);
/* 351 */       conds.add(new CellTestCond_ContainsFlag(flag));
/*     */       
/* 353 */       testFurnitureCellTypeCond = new TestFurnitureCellTypeCond_FurnitureCarpet();
/*     */       
/* 355 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 2: 
/* 360 */       byte flag = 0;
/* 361 */       flag = (byte)(flag | 0x8);
/* 362 */       conds.add(new CellTestCond_ContainsFlag(flag));
/* 363 */       conds.add(new CellTestCond_NotWall());
/*     */       
/* 365 */       testFurnitureCellTypeCond = new TestFurnitureCellTypeCond_FurnitureWallDecor();
/*     */       
/* 367 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 3: 
/* 372 */       byte flag = 0;
/* 373 */       flag = (byte)(flag | 0x1);
/* 374 */       flag = (byte)(flag | 0x20);
/* 375 */       flag = (byte)(flag | 0x2);
/* 376 */       conds.add(new CellTestCond_ContainsFlag(flag));
/*     */       
/* 378 */       testFurnitureCellTypeCond = new TestFurnitureCellTypeCond_FurnitureBlock();
/*     */       
/* 380 */       break;
/*     */     
/*     */     default: 
/* 383 */       return false;
/*     */     }
/*     */     
/* 386 */     SMapConfig mapConfig = scene.getMapConfig();
/* 387 */     int leftTopX = x + directionInfo.offseX;
/* 388 */     int leftTopY = y - directionInfo.offseY;
/* 389 */     int rightBottomX = leftTopX + directionInfo.countX * cfg.cellWidth;
/* 390 */     int rightBottomY = leftTopY + directionInfo.countY * cfg.cellHeight;
/* 391 */     List<Integer> cells = directionInfo.cells;
/* 392 */     int xx = leftTopX; for (int cellCol = 0; xx < rightBottomX; cellCol++)
/*     */     {
/* 394 */       int yy = leftTopY; for (int cellRow = 0; yy < rightBottomY; cellRow++)
/*     */       {
/* 396 */         int cellIndex = cellCol + cellRow * directionInfo.countX;
/* 397 */         Cell cell; if (cellIndex < cells.size())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 402 */           int flags = ((Integer)cells.get(cellIndex)).intValue();
/* 403 */           if (testFurnitureCellTypeCond.test(flags))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 408 */             cell = scene.getCell(mapConfig, xx, yy);
/* 409 */             if (cell == null)
/*     */             {
/* 411 */               return false;
/*     */             }
/*     */             
/* 414 */             for (CellTestCondition cond : conds)
/*     */             {
/* 416 */               if (cond.test(cell))
/*     */               {
/* 418 */                 return false;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 394 */         yy += cfg.cellHeight;
/*     */       }
/* 392 */       xx += cfg.cellWidth;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 424 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapFurniture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */