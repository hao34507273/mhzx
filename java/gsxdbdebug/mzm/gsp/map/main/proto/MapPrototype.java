/*     */ package mzm.gsp.map.main.proto;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.map.confbean.CellSegment;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.confbean.SMapRegionConfig;
/*     */ import mzm.gsp.map.confbean.SMapTransferRegion;
/*     */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*     */ import mzm.gsp.map.main.MapCfgManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class MapPrototype
/*     */ {
/*     */   private final int cfgid;
/*     */   
/*     */   public MapPrototype(int cfgid)
/*     */   {
/*  26 */     this.cfgid = cfgid;
/*     */   }
/*     */   
/*     */   public int getTemplateId()
/*     */   {
/*  31 */     return this.cfgid;
/*     */   }
/*     */   
/*     */   public SMapConfig getMapConfig()
/*     */   {
/*  36 */     return SMapConfig.get(this.cfgid);
/*     */   }
/*     */   
/*     */   public Cell getCellPrototype(int col, int row)
/*     */   {
/*  41 */     return getCellPrototype(getMapConfig(), col, row);
/*     */   }
/*     */   
/*     */   public static Cell getCellPrototype(SMapConfig mapConfig, int col, int row)
/*     */   {
/*  46 */     if ((mapConfig == null) || (col < 0) || (row < 0))
/*     */     {
/*  48 */       return null;
/*     */     }
/*     */     
/*  51 */     if ((col >= mapConfig.cellCols) || (row >= mapConfig.cellRows))
/*     */     {
/*  53 */       return null;
/*     */     }
/*     */     
/*  56 */     byte flag = 0;
/*  57 */     int index = col + row * mapConfig.cellCols;
/*  58 */     if (mapConfig.blockCellInfos.containsKey(Integer.valueOf(index)))
/*     */     {
/*  60 */       flag = (byte)(flag | 0x1);
/*     */     }
/*  62 */     if (mapConfig.wallCellInfos.contains(Integer.valueOf(index)))
/*     */     {
/*  64 */       flag = (byte)(flag | 0x20);
/*     */     }
/*  66 */     return Cell.getPrototypeCell(flag);
/*     */   }
/*     */   
/*     */   public int getMapType()
/*     */   {
/*  71 */     return getMapType(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getMapType(SMapConfig mapConfig)
/*     */   {
/*  76 */     if (mapConfig == null)
/*     */     {
/*  78 */       return 0;
/*     */     }
/*     */     
/*  81 */     return mapConfig.mapType;
/*     */   }
/*     */   
/*     */   public boolean isWorldMap()
/*     */   {
/*  86 */     return isWorldMap(getMapConfig());
/*     */   }
/*     */   
/*     */   public static boolean isWorldMap(int mapCfgid)
/*     */   {
/*  91 */     return isWorldMap(SMapConfig.get(mapCfgid));
/*     */   }
/*     */   
/*     */   public static boolean isWorldMap(SMapConfig mapConfig)
/*     */   {
/*  96 */     if (mapConfig == null)
/*     */     {
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     return mapConfig.mapType == 0;
/*     */   }
/*     */   
/*     */   public boolean isFubenMap()
/*     */   {
/* 106 */     return isFubenMap(getMapConfig());
/*     */   }
/*     */   
/*     */   public static boolean isFubenMap(int mapCfgid)
/*     */   {
/* 111 */     return isFubenMap(SMapConfig.get(mapCfgid));
/*     */   }
/*     */   
/*     */   public static boolean isFubenMap(SMapConfig mapConfig)
/*     */   {
/* 116 */     if (mapConfig == null)
/*     */     {
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     return (mapConfig.mapType == 1) || (mapConfig.mapType == 4) || (mapConfig.mapType == 2) || (mapConfig.mapType == 3);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isHomelandMap()
/*     */   {
/* 127 */     return isHomelandMap(getMapConfig());
/*     */   }
/*     */   
/*     */   public static boolean isHomelandMap(int mapCfgid)
/*     */   {
/* 132 */     return isHomelandMap(SMapConfig.get(mapCfgid));
/*     */   }
/*     */   
/*     */   public static boolean isHomelandMap(SMapConfig mapConfig)
/*     */   {
/* 137 */     if (mapConfig == null)
/*     */     {
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     return (mapConfig.mapType == 2) || (mapConfig.mapType == 3);
/*     */   }
/*     */   
/*     */   public boolean isGangMap()
/*     */   {
/* 147 */     return isGangMap(getMapConfig());
/*     */   }
/*     */   
/*     */   public static boolean isGangMap(int mapCfgid)
/*     */   {
/* 152 */     return isGangMap(SMapConfig.get(mapCfgid));
/*     */   }
/*     */   
/*     */   public static boolean isGangMap(SMapConfig mapConfig)
/*     */   {
/* 157 */     if (mapConfig == null)
/*     */     {
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     return mapConfig.mapType == 4;
/*     */   }
/*     */   
/*     */   public static boolean canDirectTransfer(int mapCfgid)
/*     */   {
/* 167 */     return canDirectTransfer(SMapConfig.get(mapCfgid));
/*     */   }
/*     */   
/*     */   public static boolean canDirectTransfer(SMapConfig mapConfig)
/*     */   {
/* 172 */     if (mapConfig == null)
/*     */     {
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     return mapConfig.canDirectTransfer;
/*     */   }
/*     */   
/*     */   public List<SMapVisibleMonster> getVisibleMonsterList()
/*     */   {
/* 182 */     return getVisibleMonsterList(getMapConfig());
/*     */   }
/*     */   
/*     */   public static List<SMapVisibleMonster> getVisibleMonsterList(SMapConfig mapConfig)
/*     */   {
/* 187 */     if (mapConfig == null)
/*     */     {
/* 189 */       return null;
/*     */     }
/*     */     
/* 192 */     return mapConfig.visibleMonsters;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 197 */     return getName(getMapConfig());
/*     */   }
/*     */   
/*     */   public static String getName(SMapConfig mapConfig)
/*     */   {
/* 202 */     if (mapConfig == null)
/*     */     {
/* 204 */       return null;
/*     */     }
/*     */     
/* 207 */     return mapConfig.name;
/*     */   }
/*     */   
/*     */   public int getWidth()
/*     */   {
/* 212 */     return getWidth(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getWidth(SMapConfig mapConfig)
/*     */   {
/* 217 */     if (mapConfig == null)
/*     */     {
/* 219 */       return 0;
/*     */     }
/*     */     
/* 222 */     return mapConfig.width;
/*     */   }
/*     */   
/*     */   public int getHeight()
/*     */   {
/* 227 */     return getHeight(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getHeight(SMapConfig mapConfig)
/*     */   {
/* 232 */     if (mapConfig == null)
/*     */     {
/* 234 */       return 0;
/*     */     }
/* 236 */     return mapConfig.height;
/*     */   }
/*     */   
/*     */   public int getCellWidth()
/*     */   {
/* 241 */     return getCellWidth(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getCellWidth(SMapConfig mapConfig)
/*     */   {
/* 246 */     if (mapConfig == null)
/*     */     {
/* 248 */       return 0;
/*     */     }
/* 250 */     return mapConfig.cellWidth;
/*     */   }
/*     */   
/*     */   public int getCellHeight()
/*     */   {
/* 255 */     return getCellHeight(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getCellHeight(SMapConfig mapConfig)
/*     */   {
/* 260 */     if (mapConfig == null)
/*     */     {
/* 262 */       return 0;
/*     */     }
/* 264 */     return mapConfig.cellHeight;
/*     */   }
/*     */   
/*     */   public int getCellRows()
/*     */   {
/* 269 */     return getCellRows(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getCellRows(SMapConfig mapConfig)
/*     */   {
/* 274 */     if (mapConfig == null)
/*     */     {
/* 276 */       return 0;
/*     */     }
/*     */     
/* 279 */     return mapConfig.cellRows;
/*     */   }
/*     */   
/*     */   public int getCellCols()
/*     */   {
/* 284 */     return getCellCols(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getCellCols(SMapConfig mapConfig)
/*     */   {
/* 289 */     if (mapConfig == null)
/*     */     {
/* 291 */       return 0;
/*     */     }
/*     */     
/* 294 */     return mapConfig.cellCols;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getGridRows()
/*     */   {
/* 302 */     return getGridRows(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getGridRows(SMapConfig mapConfig)
/*     */   {
/* 307 */     if (mapConfig == null)
/*     */     {
/* 309 */       return 0;
/*     */     }
/*     */     
/* 312 */     return mapConfig.gridRows;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getGridCols()
/*     */   {
/* 320 */     return getGridCols(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getGridCols(SMapConfig mapConfig)
/*     */   {
/* 325 */     if (mapConfig == null)
/*     */     {
/* 327 */       return 0;
/*     */     }
/*     */     
/* 330 */     return mapConfig.gridCols;
/*     */   }
/*     */   
/*     */   public boolean canFly()
/*     */   {
/* 335 */     return canFly(getMapConfig());
/*     */   }
/*     */   
/*     */   public static boolean canFly(SMapConfig mapConfig)
/*     */   {
/* 340 */     if (mapConfig == null)
/*     */     {
/* 342 */       return false;
/*     */     }
/* 344 */     return mapConfig.canFly;
/*     */   }
/*     */   
/*     */   public int getChannelCapacity()
/*     */   {
/* 349 */     return getChannelCapacity(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getChannelCapacity(SMapConfig mapConfig)
/*     */   {
/* 354 */     if (mapConfig == null)
/*     */     {
/* 356 */       return 0;
/*     */     }
/* 358 */     return mapConfig.channelCapacity;
/*     */   }
/*     */   
/*     */   public int getMinMeetMonsterCellNum()
/*     */   {
/* 363 */     return getMinMeetMonsterCellNum(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getMinMeetMonsterCellNum(SMapConfig mapConfig)
/*     */   {
/* 368 */     if (mapConfig == null)
/*     */     {
/* 370 */       return 0;
/*     */     }
/* 372 */     return mapConfig.minMeetMonsterCellNum;
/*     */   }
/*     */   
/*     */   public double getMinMeetMonsterProb()
/*     */   {
/* 377 */     return getMinMeetMonsterProb(getMapConfig());
/*     */   }
/*     */   
/*     */   public static double getMinMeetMonsterProb(SMapConfig mapConfig)
/*     */   {
/* 382 */     if (mapConfig == null)
/*     */     {
/* 384 */       return 0.0D;
/*     */     }
/* 386 */     return mapConfig.minMeetMonsterProb;
/*     */   }
/*     */   
/*     */   public int getDarkMonsterTableId()
/*     */   {
/* 391 */     return getDarkMonsterTableId(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getDarkMonsterTableId(SMapConfig mapConfig)
/*     */   {
/* 396 */     if (mapConfig == null)
/*     */     {
/* 398 */       return 0;
/*     */     }
/* 400 */     return mapConfig.inVisibleMonsterCfgId;
/*     */   }
/*     */   
/*     */   public List<SMapTransferRegion> getTransferRegions()
/*     */   {
/* 405 */     return getTransferRegions(getMapConfig());
/*     */   }
/*     */   
/*     */   public static List<SMapTransferRegion> getTransferRegions(SMapConfig mapConfig)
/*     */   {
/* 410 */     if (mapConfig == null)
/*     */     {
/* 412 */       return null;
/*     */     }
/* 414 */     return mapConfig.transferRegions;
/*     */   }
/*     */   
/*     */   public int getMarkValue()
/*     */   {
/* 419 */     return getMarkValue(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getMarkValue(SMapConfig mapConfig)
/*     */   {
/* 424 */     if (mapConfig == null)
/*     */     {
/* 426 */       return 0;
/*     */     }
/* 428 */     return mapConfig.markValue;
/*     */   }
/*     */   
/*     */   public List<mzm.gsp.map.confbean.SMapNPC> getNpcCfgList()
/*     */   {
/* 433 */     return getNpcCfgList(getMapConfig());
/*     */   }
/*     */   
/*     */   public static List<mzm.gsp.map.confbean.SMapNPC> getNpcCfgList(SMapConfig mapConfig)
/*     */   {
/* 438 */     if (mapConfig == null)
/*     */     {
/* 440 */       return null;
/*     */     }
/* 442 */     return mapConfig.npcs;
/*     */   }
/*     */   
/*     */   public int getDefaultTransferPosX()
/*     */   {
/* 447 */     return getDefaultTransferPosX(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getDefaultTransferPosX(SMapConfig mapConfig)
/*     */   {
/* 452 */     if (mapConfig == null)
/*     */     {
/* 454 */       return 0;
/*     */     }
/*     */     
/* 457 */     return mapConfig.defaultTransPosX;
/*     */   }
/*     */   
/*     */   public static int getDefaultTransferPosX(int mapCfgid)
/*     */   {
/* 462 */     SMapConfig mapConfig = SMapConfig.get(mapCfgid);
/* 463 */     return getDefaultTransferPosX(mapConfig);
/*     */   }
/*     */   
/*     */   public int getDefaultTransferPosY()
/*     */   {
/* 468 */     return getDefaultTransferPosY(getMapConfig());
/*     */   }
/*     */   
/*     */   public static int getDefaultTransferPosY(SMapConfig mapConfig)
/*     */   {
/* 473 */     if (mapConfig == null)
/*     */     {
/* 475 */       return 0;
/*     */     }
/*     */     
/* 478 */     return mapConfig.defaultTransPosY;
/*     */   }
/*     */   
/*     */   public static int getDefaultTransferPosY(int mapCfgid)
/*     */   {
/* 483 */     SMapConfig mapConfig = SMapConfig.get(mapCfgid);
/* 484 */     return getDefaultTransferPosY(mapConfig);
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getTaskIdToFightIdMap()
/*     */   {
/* 489 */     return getTaskIdToFightIdMap(getMapConfig());
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> getTaskIdToFightIdMap(SMapConfig mapConfig)
/*     */   {
/* 494 */     if (mapConfig == null)
/*     */     {
/* 496 */       return null;
/*     */     }
/*     */     
/* 499 */     return mapConfig.taskCfgidToFightCfgid;
/*     */   }
/*     */   
/*     */   public Set<Integer> getMapItems()
/*     */   {
/* 504 */     return getMapItems(getMapConfig());
/*     */   }
/*     */   
/*     */   public static Set<Integer> getMapItems(SMapConfig mapConfig)
/*     */   {
/* 509 */     if (mapConfig == null)
/*     */     {
/* 511 */       return null;
/*     */     }
/*     */     
/* 514 */     return mapConfig.items;
/*     */   }
/*     */   
/*     */   public TreeMap<Integer, Integer> getRegions()
/*     */   {
/* 519 */     return getRegions(getMapConfig());
/*     */   }
/*     */   
/*     */   public static TreeMap<Integer, Integer> getRegions(SMapConfig mapConfig)
/*     */   {
/* 524 */     if (mapConfig == null)
/*     */     {
/* 526 */       return null;
/*     */     }
/* 528 */     return mapConfig.randomRegions;
/*     */   }
/*     */   
/*     */   public static Position getPositionByCellIndex(SMapConfig mapConfig, int cellIndex)
/*     */   {
/* 533 */     int col = cellIndex % mapConfig.cellCols;
/* 534 */     int row = cellIndex / mapConfig.cellCols;
/* 535 */     if ((col < 0) || (row < 0))
/*     */     {
/* 537 */       return null;
/*     */     }
/*     */     
/* 540 */     if ((col >= mapConfig.cellCols) || (row >= mapConfig.cellRows))
/*     */     {
/* 542 */       return null;
/*     */     }
/*     */     
/* 545 */     int x = col * mapConfig.cellWidth + Xdb.random().nextInt(mapConfig.cellWidth);
/* 546 */     int y = row * mapConfig.cellHeight + Xdb.random().nextInt(mapConfig.cellHeight);
/* 547 */     return new Position(x, y, 0, mapConfig.id);
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
/*     */   public static int getNearbyReachableCellIndex(SMapConfig mapConfig, int x, int y)
/*     */   {
/* 561 */     int cellWidth = mapConfig.cellWidth;
/* 562 */     int cellHeight = mapConfig.cellHeight;
/* 563 */     int col = x / cellWidth;
/* 564 */     int row = y / cellHeight;
/*     */     
/* 566 */     if ((col < 0) || (row < 0))
/*     */     {
/* 568 */       return -2;
/*     */     }
/*     */     
/* 571 */     if ((col >= mapConfig.cellCols) || (row >= mapConfig.cellRows))
/*     */     {
/* 573 */       return -2;
/*     */     }
/*     */     
/* 576 */     int index = col + row * mapConfig.cellCols;
/* 577 */     Integer reachableCellIndex = (Integer)mapConfig.blockCellInfos.get(Integer.valueOf(index));
/* 578 */     if (reachableCellIndex == null)
/*     */     {
/* 580 */       return -1;
/*     */     }
/*     */     
/* 583 */     return reachableCellIndex.intValue();
/*     */   }
/*     */   
/*     */   public Position randomPos(int sceneid)
/*     */   {
/* 588 */     SMapConfig mapConfig = getMapConfig();
/* 589 */     if (mapConfig == null)
/*     */     {
/* 591 */       return null;
/*     */     }
/*     */     
/* 594 */     return randomPos(mapConfig, sceneid);
/*     */   }
/*     */   
/*     */   public static Position randomPos(SMapConfig mapConfig, int sceneid)
/*     */   {
/* 599 */     if (mapConfig.randomCellSegments.isEmpty())
/*     */     {
/* 601 */       return null;
/*     */     }
/*     */     
/* 604 */     int prob = Xdb.random().nextInt(mapConfig.randomCellSegmentProbBase);
/* 605 */     Map.Entry<Integer, CellSegment> entry = mapConfig.randomCellSegments.ceilingEntry(Integer.valueOf(prob));
/* 606 */     if (entry == null)
/*     */     {
/* 608 */       return null;
/*     */     }
/*     */     
/* 611 */     CellSegment segment = (CellSegment)entry.getValue();
/* 612 */     int size = segment.endIndex - segment.beginIndex;
/* 613 */     if (size == 0)
/*     */     {
/* 615 */       return null;
/*     */     }
/*     */     
/* 618 */     int cellIndex = segment.beginIndex;
/* 619 */     if (size > 1)
/*     */     {
/* 621 */       cellIndex += Xdb.random().nextInt(size);
/*     */     }
/*     */     
/*     */ 
/* 625 */     int cellCols = mapConfig.cellCols - 16;
/* 626 */     int col = cellIndex % cellCols + 8;
/* 627 */     int row = cellIndex / cellCols + 8;
/* 628 */     int x = col * mapConfig.cellWidth + Xdb.random().nextInt(mapConfig.cellWidth);
/* 629 */     int y = row * mapConfig.cellHeight + Xdb.random().nextInt(mapConfig.cellHeight);
/* 630 */     return new Position(x, y, 0, sceneid);
/*     */   }
/*     */   
/*     */   public Position randomPosInAir(int sceneid)
/*     */   {
/* 635 */     SMapConfig mapConfig = getMapConfig();
/* 636 */     if (mapConfig == null)
/*     */     {
/* 638 */       return null;
/*     */     }
/*     */     
/* 641 */     return randomPosInAir(mapConfig, sceneid);
/*     */   }
/*     */   
/*     */   public static Position randomPosInAir(SMapConfig mapConfig, int sceneid)
/*     */   {
/* 646 */     int marginX = mapConfig.cellWidth << 4;
/* 647 */     int minX = marginX;
/* 648 */     int maxX = mapConfig.width - marginX;
/* 649 */     if (minX >= maxX)
/*     */     {
/* 651 */       return null;
/*     */     }
/*     */     
/* 654 */     int minY = mapConfig.cellHeight << 5;
/* 655 */     int maxY = mapConfig.height - (mapConfig.cellHeight << 4);
/* 656 */     if (minY >= maxY)
/*     */     {
/* 658 */       return null;
/*     */     }
/*     */     
/* 661 */     int x = minX + Xdb.random().nextInt(maxX - minX);
/* 662 */     int y = minY + Xdb.random().nextInt(maxY - minY);
/*     */     
/* 664 */     return new Position(x, y, 0, mapConfig.id);
/*     */   }
/*     */   
/*     */   public Position randomPosFromAllRegions()
/*     */   {
/* 669 */     SMapConfig mapConfig = getMapConfig();
/* 670 */     if (mapConfig == null)
/*     */     {
/* 672 */       return null;
/*     */     }
/*     */     
/* 675 */     return randomPosFromAllRegions(mapConfig);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Position randomPosFromAllRegions(int mapCfgid)
/*     */   {
/* 687 */     MapPrototype prototype = MapCfgManager.getInstance().getMapProtoById(mapCfgid);
/* 688 */     if (prototype == null)
/*     */     {
/* 690 */       return null;
/*     */     }
/*     */     
/* 693 */     return prototype.randomPosFromAllRegions();
/*     */   }
/*     */   
/*     */   public static Position randomPosFromAllRegions(SMapConfig mapConfig)
/*     */   {
/* 698 */     if (mapConfig.randomRegions.isEmpty())
/*     */     {
/* 700 */       return null;
/*     */     }
/*     */     
/* 703 */     int prob = Xdb.random().nextInt(mapConfig.randomRegionProbBase);
/* 704 */     Map.Entry<Integer, Integer> entry = mapConfig.randomRegions.ceilingEntry(Integer.valueOf(prob));
/* 705 */     if (entry == null)
/*     */     {
/* 707 */       return null;
/*     */     }
/*     */     
/* 710 */     int regionCfgid = ((Integer)entry.getValue()).intValue();
/* 711 */     return randomPosFromRegion(mapConfig, regionCfgid);
/*     */   }
/*     */   
/*     */   public Position randomPosFromRegion(int regionCfgid)
/*     */   {
/* 716 */     SMapConfig mapConfig = getMapConfig();
/* 717 */     if (mapConfig == null)
/*     */     {
/* 719 */       return null;
/*     */     }
/*     */     
/* 722 */     return randomPosFromRegion(mapConfig, regionCfgid);
/*     */   }
/*     */   
/*     */   public static Position randomPosFromRegion(int mapCfgid, int regionCfgid)
/*     */   {
/* 727 */     MapPrototype prototype = MapCfgManager.getInstance().getMapProtoById(mapCfgid);
/* 728 */     if (prototype == null)
/*     */     {
/* 730 */       return null;
/*     */     }
/*     */     
/* 733 */     SMapConfig mapConfig = prototype.getMapConfig();
/* 734 */     if (mapConfig == null)
/*     */     {
/* 736 */       return null;
/*     */     }
/*     */     
/* 739 */     return randomPosFromRegion(mapConfig, regionCfgid);
/*     */   }
/*     */   
/*     */   public static Position randomPosFromRegion(SMapConfig mapConfig, int regionCfgid)
/*     */   {
/* 744 */     SMapRegionConfig regionConfig = SMapRegionConfig.get(regionCfgid);
/* 745 */     if (regionConfig == null)
/*     */     {
/* 747 */       return null;
/*     */     }
/*     */     
/* 750 */     List<Integer> reachableCellIndices = regionConfig.randomCells;
/* 751 */     int size = reachableCellIndices.size();
/* 752 */     if (size == 0)
/*     */     {
/* 754 */       return null;
/*     */     }
/*     */     
/* 757 */     int cellIndex = (size == 1 ? (Integer)reachableCellIndices.get(0) : (Integer)reachableCellIndices.get(Xdb.random().nextInt(size))).intValue();
/*     */     
/* 759 */     int cellWidth = mapConfig.cellWidth;
/* 760 */     int cellHeight = mapConfig.cellHeight;
/* 761 */     int cellCols = mapConfig.cellCols;
/* 762 */     int col = cellIndex % cellCols;
/* 763 */     int row = cellIndex / cellCols;
/* 764 */     int x = col * cellWidth + Xdb.random().nextInt(cellWidth);
/* 765 */     int y = row * cellHeight + Xdb.random().nextInt(cellHeight);
/*     */     
/* 767 */     return new Position(x, y, 0, mapConfig.id);
/*     */   }
/*     */   
/*     */   public Position randomPosFromAirRegion(int regionCfgid)
/*     */   {
/* 772 */     SMapConfig mapConfig = getMapConfig();
/* 773 */     if (mapConfig == null)
/*     */     {
/* 775 */       return null;
/*     */     }
/*     */     
/* 778 */     return randomPosFromAirRegion(mapConfig, regionCfgid);
/*     */   }
/*     */   
/*     */   public static Position randomPosFromAirRegion(SMapConfig mapConfig, int regionCfgid)
/*     */   {
/* 783 */     SMapRegionConfig regionConfig = SMapRegionConfig.get(regionCfgid);
/* 784 */     if (regionConfig == null)
/*     */     {
/* 786 */       return null;
/*     */     }
/*     */     
/* 789 */     int marginX = mapConfig.cellWidth << 4;
/* 790 */     int minX = Math.max(regionConfig.x, marginX);
/* 791 */     int maxX = Math.min(regionConfig.x + regionConfig.w, mapConfig.width - marginX);
/* 792 */     if (minX >= maxX)
/*     */     {
/* 794 */       return null;
/*     */     }
/*     */     
/* 797 */     int minY = Math.max(regionConfig.y, mapConfig.cellHeight << 5);
/* 798 */     int maxY = Math.min(regionConfig.y + regionConfig.h, mapConfig.height - (mapConfig.cellHeight << 4));
/* 799 */     if (minY >= maxY)
/*     */     {
/* 801 */       return null;
/*     */     }
/*     */     
/* 804 */     int x = minX + Xdb.random().nextInt(maxX - minX);
/* 805 */     int y = minY + Xdb.random().nextInt(maxY - minY);
/*     */     
/* 807 */     return new Position(x, y, 0, mapConfig.id);
/*     */   }
/*     */   
/*     */   public HashSet<Integer> getPkData()
/*     */   {
/* 812 */     return getPkData(getMapConfig());
/*     */   }
/*     */   
/*     */   public static HashSet<Integer> getPkData(SMapConfig mapConfig)
/*     */   {
/* 817 */     if (mapConfig == null)
/*     */     {
/* 819 */       return null;
/*     */     }
/*     */     
/* 822 */     return mapConfig.pkCellInfos;
/*     */   }
/*     */   
/*     */   public boolean isExistVisibleMonster(int monsterCfgid)
/*     */   {
/* 827 */     List<SMapVisibleMonster> mapVisibleMonsters = getVisibleMonsterList();
/* 828 */     if (mapVisibleMonsters == null)
/*     */     {
/* 830 */       return false;
/*     */     }
/*     */     
/* 833 */     for (SMapVisibleMonster visibleMonster : mapVisibleMonsters)
/*     */     {
/* 835 */       if (visibleMonster.cfgid == monsterCfgid)
/*     */       {
/* 837 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 841 */     return false;
/*     */   }
/*     */   
/*     */   public SMapVisibleMonster getVisibleMonster(int monsterCfgid)
/*     */   {
/* 846 */     List<SMapVisibleMonster> mapVisibleMonsters = getVisibleMonsterList();
/* 847 */     if (mapVisibleMonsters == null)
/*     */     {
/* 849 */       return null;
/*     */     }
/*     */     
/* 852 */     for (SMapVisibleMonster visibleMonster : mapVisibleMonsters)
/*     */     {
/* 854 */       if (visibleMonster.cfgid == monsterCfgid)
/*     */       {
/* 856 */         return visibleMonster;
/*     */       }
/*     */     }
/*     */     
/* 860 */     return null;
/*     */   }
/*     */   
/*     */   public int getMonsterNumber()
/*     */   {
/* 865 */     List<SMapVisibleMonster> mapVisibleMonsters = getVisibleMonsterList();
/* 866 */     if (mapVisibleMonsters == null)
/*     */     {
/* 868 */       return 0;
/*     */     }
/*     */     
/* 871 */     return mapVisibleMonsters.size();
/*     */   }
/*     */   
/*     */   public static Integer getContainsPointPolygonCfgid(SMapConfig mapConfig, int x, int y)
/*     */   {
/* 876 */     if (mapConfig == null)
/*     */     {
/* 878 */       return null;
/*     */     }
/*     */     
/* 881 */     if (mapConfig.polygons.isEmpty())
/*     */     {
/* 883 */       return Integer.valueOf(0);
/*     */     }
/*     */     
/* 886 */     MapPolygonPrototype mapPolygonProto = null;
/* 887 */     for (Integer polygonCfgid : mapConfig.polygons)
/*     */     {
/* 889 */       mapPolygonProto = MapCfgManager.getInstance().getMapPolygonProtoById(polygonCfgid.intValue());
/* 890 */       if (mapPolygonProto == null)
/*     */       {
/* 892 */         return null;
/*     */       }
/*     */       
/* 895 */       if (mapPolygonProto.contains(x, y))
/*     */       {
/* 897 */         return polygonCfgid;
/*     */       }
/*     */     }
/*     */     
/* 901 */     return Integer.valueOf(0);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\proto\MapPrototype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */