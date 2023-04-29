/*     */ package mzm.gsp.map.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SMapConfig implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMapConfig> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMapConfig> all = null;
/*     */   
/*     */   public int id;
/*     */   public int mapType;
/*     */   public String name;
/*     */   public int width;
/*     */   public int height;
/*     */   public int cellWidth;
/*     */   public int cellHeight;
/*     */   public int cellRows;
/*     */   public int cellCols;
/*     */   public int gridRows;
/*     */   public int gridCols;
/*     */   public int minMeetMonsterCellNum;
/*     */   public double minMeetMonsterProb;
/*     */   public int inVisibleMonsterCfgId;
/*     */   public int markValue;
/*     */   public boolean canFly;
/*     */   public boolean canPK;
/*     */   public boolean canArrestWanted;
/*     */   public boolean canDirectTransfer;
/*     */   public int channelCapacity;
/*  38 */   public HashSet<Integer> pkCellInfos = new HashSet();
/*  39 */   public HashSet<Integer> wallCellInfos = new HashSet();
/*  40 */   public HashMap<Integer, Integer> blockCellInfos = new HashMap();
/*     */   public int randomCellSegmentProbBase;
/*  42 */   public java.util.TreeMap<Integer, CellSegment> randomCellSegments = new java.util.TreeMap();
/*     */   public int randomRegionProbBase;
/*  44 */   public java.util.TreeMap<Integer, Integer> randomRegions = new java.util.TreeMap();
/*     */   public int defaultTransPosX;
/*     */   public int defaultTransPosY;
/*  47 */   public HashMap<Integer, Integer> taskCfgidToFightCfgid = new HashMap();
/*  48 */   public ArrayList<SMapTransferRegion> transferRegions = new ArrayList();
/*  49 */   public ArrayList<SMapNPC> npcs = new ArrayList();
/*  50 */   public ArrayList<SMapVisibleMonster> visibleMonsters = new ArrayList();
/*  51 */   public HashSet<Integer> items = new HashSet();
/*  52 */   public HashSet<Integer> polygons = new HashSet();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  56 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  57 */     this.mapType = Integer.valueOf(rootElement.attributeValue("mapType")).intValue();
/*  58 */     this.name = rootElement.attributeValue("name");
/*  59 */     this.width = Integer.valueOf(rootElement.attributeValue("width")).intValue();
/*  60 */     this.height = Integer.valueOf(rootElement.attributeValue("height")).intValue();
/*  61 */     this.cellWidth = Integer.valueOf(rootElement.attributeValue("cellWidth")).intValue();
/*  62 */     this.cellHeight = Integer.valueOf(rootElement.attributeValue("cellHeight")).intValue();
/*  63 */     this.cellRows = Integer.valueOf(rootElement.attributeValue("cellRows")).intValue();
/*  64 */     this.cellCols = Integer.valueOf(rootElement.attributeValue("cellCols")).intValue();
/*  65 */     this.gridRows = Integer.valueOf(rootElement.attributeValue("gridRows")).intValue();
/*  66 */     this.gridCols = Integer.valueOf(rootElement.attributeValue("gridCols")).intValue();
/*  67 */     this.minMeetMonsterCellNum = Integer.valueOf(rootElement.attributeValue("minMeetMonsterCellNum")).intValue();
/*  68 */     this.minMeetMonsterProb = Double.valueOf(rootElement.attributeValue("minMeetMonsterProb")).doubleValue();
/*  69 */     this.inVisibleMonsterCfgId = Integer.valueOf(rootElement.attributeValue("inVisibleMonsterCfgId")).intValue();
/*  70 */     this.markValue = Integer.valueOf(rootElement.attributeValue("markValue")).intValue();
/*  71 */     this.canFly = Boolean.valueOf(rootElement.attributeValue("canFly")).booleanValue();
/*  72 */     this.canPK = Boolean.valueOf(rootElement.attributeValue("canPK")).booleanValue();
/*  73 */     this.canArrestWanted = Boolean.valueOf(rootElement.attributeValue("canArrestWanted")).booleanValue();
/*  74 */     this.canDirectTransfer = Boolean.valueOf(rootElement.attributeValue("canDirectTransfer")).booleanValue();
/*  75 */     this.channelCapacity = Integer.valueOf(rootElement.attributeValue("channelCapacity")).intValue();
/*     */     
/*  77 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "pkCellInfos");
/*  78 */     if (collectionElement == null)
/*     */     {
/*  80 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  83 */     List<?> _nodeList = collectionElement.elements();
/*  84 */     int _len = _nodeList.size();
/*  85 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  87 */       Element elem = (Element)_nodeList.get(i);
/*  88 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  95 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 102 */         this.pkCellInfos.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 106 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "wallCellInfos");
/* 107 */     if (collectionElement == null)
/*     */     {
/* 109 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 112 */     List<?> _nodeList = collectionElement.elements();
/* 113 */     int _len = _nodeList.size();
/* 114 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 116 */       Element elem = (Element)_nodeList.get(i);
/* 117 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 124 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 131 */         this.wallCellInfos.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 135 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "blockCellInfos");
/* 136 */     if (mapTypeElement == null)
/*     */     {
/* 138 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 141 */     List<?> entryNodeList = mapTypeElement.elements();
/* 142 */     int entryLen = entryNodeList.size();
/* 143 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 145 */       Element entryElement = (Element)entryNodeList.get(i);
/* 146 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 151 */         Element keyElem = null;
/* 152 */         Element valueElem = null;
/*     */         
/* 154 */         List<?> _nodeList = entryElement.elements();
/* 155 */         int _len = _nodeList.size();
/* 156 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 158 */           Element elem = (Element)_nodeList.get(j);
/* 159 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 161 */             keyElem = elem;
/*     */           }
/* 163 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 165 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 169 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 171 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 178 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 179 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 186 */         this.blockCellInfos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 189 */     this.randomCellSegmentProbBase = Integer.valueOf(rootElement.attributeValue("randomCellSegmentProbBase")).intValue();
/*     */     
/* 191 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "randomCellSegments");
/* 192 */     if (mapTypeElement == null)
/*     */     {
/* 194 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 197 */     List<?> entryNodeList = mapTypeElement.elements();
/* 198 */     int entryLen = entryNodeList.size();
/* 199 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 201 */       Element entryElement = (Element)entryNodeList.get(i);
/* 202 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 207 */         Element keyElem = null;
/* 208 */         Element valueElem = null;
/*     */         
/* 210 */         List<?> _nodeList = entryElement.elements();
/* 211 */         int _len = _nodeList.size();
/* 212 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 214 */           Element elem = (Element)_nodeList.get(j);
/* 215 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 217 */             keyElem = elem;
/*     */           }
/* 219 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.CellSegment")))
/*     */           {
/* 221 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 225 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 227 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         CellSegment _v_;
/*     */         try
/*     */         {
/* 234 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 235 */           _v_ = new CellSegment();
/* 236 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 243 */         this.randomCellSegments.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/* 246 */     this.randomRegionProbBase = Integer.valueOf(rootElement.attributeValue("randomRegionProbBase")).intValue();
/*     */     
/* 248 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "randomRegions");
/* 249 */     if (mapTypeElement == null)
/*     */     {
/* 251 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 254 */     List<?> entryNodeList = mapTypeElement.elements();
/* 255 */     int entryLen = entryNodeList.size();
/* 256 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 258 */       Element entryElement = (Element)entryNodeList.get(i);
/* 259 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 264 */         Element keyElem = null;
/* 265 */         Element valueElem = null;
/*     */         
/* 267 */         List<?> _nodeList = entryElement.elements();
/* 268 */         int _len = _nodeList.size();
/* 269 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 271 */           Element elem = (Element)_nodeList.get(j);
/* 272 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 274 */             keyElem = elem;
/*     */           }
/* 276 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 278 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 282 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 284 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 291 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 292 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 299 */         this.randomRegions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 302 */     this.defaultTransPosX = Integer.valueOf(rootElement.attributeValue("defaultTransPosX")).intValue();
/* 303 */     this.defaultTransPosY = Integer.valueOf(rootElement.attributeValue("defaultTransPosY")).intValue();
/*     */     
/* 305 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "taskCfgidToFightCfgid");
/* 306 */     if (mapTypeElement == null)
/*     */     {
/* 308 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 311 */     List<?> entryNodeList = mapTypeElement.elements();
/* 312 */     int entryLen = entryNodeList.size();
/* 313 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 315 */       Element entryElement = (Element)entryNodeList.get(i);
/* 316 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 321 */         Element keyElem = null;
/* 322 */         Element valueElem = null;
/*     */         
/* 324 */         List<?> _nodeList = entryElement.elements();
/* 325 */         int _len = _nodeList.size();
/* 326 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 328 */           Element elem = (Element)_nodeList.get(j);
/* 329 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 331 */             keyElem = elem;
/*     */           }
/* 333 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 335 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 339 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 341 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 348 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 349 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 356 */         this.taskCfgidToFightCfgid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 360 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "transferRegions");
/* 361 */     if (collectionElement == null)
/*     */     {
/* 363 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 366 */     List<?> _nodeList = collectionElement.elements();
/* 367 */     int _len = _nodeList.size();
/* 368 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 370 */       Element elem = (Element)_nodeList.get(i);
/* 371 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapTransferRegion"))
/*     */       {
/*     */         SMapTransferRegion _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 378 */           _v_ = new SMapTransferRegion();
/* 379 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 386 */         this.transferRegions.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 390 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "npcs");
/* 391 */     if (collectionElement == null)
/*     */     {
/* 393 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 396 */     List<?> _nodeList = collectionElement.elements();
/* 397 */     int _len = _nodeList.size();
/* 398 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 400 */       Element elem = (Element)_nodeList.get(i);
/* 401 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapNPC"))
/*     */       {
/*     */         SMapNPC _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 408 */           _v_ = new SMapNPC();
/* 409 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 416 */         this.npcs.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 420 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "visibleMonsters");
/* 421 */     if (collectionElement == null)
/*     */     {
/* 423 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 426 */     List<?> _nodeList = collectionElement.elements();
/* 427 */     int _len = _nodeList.size();
/* 428 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 430 */       Element elem = (Element)_nodeList.get(i);
/* 431 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapVisibleMonster"))
/*     */       {
/*     */         SMapVisibleMonster _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 438 */           _v_ = new SMapVisibleMonster();
/* 439 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 446 */         this.visibleMonsters.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 450 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "items");
/* 451 */     if (collectionElement == null)
/*     */     {
/* 453 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 456 */     List<?> _nodeList = collectionElement.elements();
/* 457 */     int _len = _nodeList.size();
/* 458 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 460 */       Element elem = (Element)_nodeList.get(i);
/* 461 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 468 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 475 */         this.items.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 479 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "polygons");
/* 480 */     if (collectionElement == null)
/*     */     {
/* 482 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 485 */     List<?> _nodeList = collectionElement.elements();
/* 486 */     int _len = _nodeList.size();
/* 487 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 489 */       Element elem = (Element)_nodeList.get(i);
/* 490 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 497 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 504 */         this.polygons.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 511 */     _os_.marshal(this.id);
/* 512 */     _os_.marshal(this.mapType);
/* 513 */     _os_.marshal(this.name, "UTF-8");
/* 514 */     _os_.marshal(this.width);
/* 515 */     _os_.marshal(this.height);
/* 516 */     _os_.marshal(this.cellWidth);
/* 517 */     _os_.marshal(this.cellHeight);
/* 518 */     _os_.marshal(this.cellRows);
/* 519 */     _os_.marshal(this.cellCols);
/* 520 */     _os_.marshal(this.gridRows);
/* 521 */     _os_.marshal(this.gridCols);
/* 522 */     _os_.marshal(this.minMeetMonsterCellNum);
/* 523 */     _os_.marshal(this.minMeetMonsterProb);
/* 524 */     _os_.marshal(this.inVisibleMonsterCfgId);
/* 525 */     _os_.marshal(this.markValue);
/* 526 */     _os_.marshal(this.canFly);
/* 527 */     _os_.marshal(this.canPK);
/* 528 */     _os_.marshal(this.canArrestWanted);
/* 529 */     _os_.marshal(this.canDirectTransfer);
/* 530 */     _os_.marshal(this.channelCapacity);
/* 531 */     _os_.compact_uint32(this.pkCellInfos.size());
/* 532 */     for (Integer _v_ : this.pkCellInfos)
/*     */     {
/* 534 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 536 */     _os_.compact_uint32(this.wallCellInfos.size());
/* 537 */     for (Integer _v_ : this.wallCellInfos)
/*     */     {
/* 539 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 541 */     _os_.compact_uint32(this.blockCellInfos.size());
/* 542 */     for (Map.Entry<Integer, Integer> _e_ : this.blockCellInfos.entrySet())
/*     */     {
/* 544 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 545 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 547 */     _os_.marshal(this.randomCellSegmentProbBase);
/* 548 */     _os_.compact_uint32(this.randomCellSegments.size());
/* 549 */     for (Map.Entry<Integer, CellSegment> _e_ : this.randomCellSegments.entrySet())
/*     */     {
/* 551 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 552 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 554 */     _os_.marshal(this.randomRegionProbBase);
/* 555 */     _os_.compact_uint32(this.randomRegions.size());
/* 556 */     for (Map.Entry<Integer, Integer> _e_ : this.randomRegions.entrySet())
/*     */     {
/* 558 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 559 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 561 */     _os_.marshal(this.defaultTransPosX);
/* 562 */     _os_.marshal(this.defaultTransPosY);
/* 563 */     _os_.compact_uint32(this.taskCfgidToFightCfgid.size());
/* 564 */     for (Map.Entry<Integer, Integer> _e_ : this.taskCfgidToFightCfgid.entrySet())
/*     */     {
/* 566 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 567 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 569 */     _os_.compact_uint32(this.transferRegions.size());
/* 570 */     for (SMapTransferRegion _v_ : this.transferRegions)
/*     */     {
/* 572 */       _os_.marshal(_v_);
/*     */     }
/* 574 */     _os_.compact_uint32(this.npcs.size());
/* 575 */     for (SMapNPC _v_ : this.npcs)
/*     */     {
/* 577 */       _os_.marshal(_v_);
/*     */     }
/* 579 */     _os_.compact_uint32(this.visibleMonsters.size());
/* 580 */     for (SMapVisibleMonster _v_ : this.visibleMonsters)
/*     */     {
/* 582 */       _os_.marshal(_v_);
/*     */     }
/* 584 */     _os_.compact_uint32(this.items.size());
/* 585 */     for (Integer _v_ : this.items)
/*     */     {
/* 587 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 589 */     _os_.compact_uint32(this.polygons.size());
/* 590 */     for (Integer _v_ : this.polygons)
/*     */     {
/* 592 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 594 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 599 */     this.id = _os_.unmarshal_int();
/* 600 */     this.mapType = _os_.unmarshal_int();
/* 601 */     this.name = _os_.unmarshal_String("UTF-8");
/* 602 */     this.width = _os_.unmarshal_int();
/* 603 */     this.height = _os_.unmarshal_int();
/* 604 */     this.cellWidth = _os_.unmarshal_int();
/* 605 */     this.cellHeight = _os_.unmarshal_int();
/* 606 */     this.cellRows = _os_.unmarshal_int();
/* 607 */     this.cellCols = _os_.unmarshal_int();
/* 608 */     this.gridRows = _os_.unmarshal_int();
/* 609 */     this.gridCols = _os_.unmarshal_int();
/* 610 */     this.minMeetMonsterCellNum = _os_.unmarshal_int();
/* 611 */     this.minMeetMonsterProb = _os_.unmarshal_float();
/* 612 */     this.inVisibleMonsterCfgId = _os_.unmarshal_int();
/* 613 */     this.markValue = _os_.unmarshal_int();
/* 614 */     this.canFly = _os_.unmarshal_boolean();
/* 615 */     this.canPK = _os_.unmarshal_boolean();
/* 616 */     this.canArrestWanted = _os_.unmarshal_boolean();
/* 617 */     this.canDirectTransfer = _os_.unmarshal_boolean();
/* 618 */     this.channelCapacity = _os_.unmarshal_int();
/* 619 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 622 */       int _v_ = _os_.unmarshal_int();
/* 623 */       this.pkCellInfos.add(Integer.valueOf(_v_));
/*     */     }
/* 625 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 628 */       int _v_ = _os_.unmarshal_int();
/* 629 */       this.wallCellInfos.add(Integer.valueOf(_v_));
/*     */     }
/* 631 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 634 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 636 */       int _v_ = _os_.unmarshal_int();
/* 637 */       this.blockCellInfos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 639 */     this.randomCellSegmentProbBase = _os_.unmarshal_int();
/* 640 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 643 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 645 */       CellSegment _v_ = new CellSegment();
/* 646 */       _v_.unmarshal(_os_);
/* 647 */       this.randomCellSegments.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 649 */     this.randomRegionProbBase = _os_.unmarshal_int();
/* 650 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 653 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 655 */       int _v_ = _os_.unmarshal_int();
/* 656 */       this.randomRegions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 658 */     this.defaultTransPosX = _os_.unmarshal_int();
/* 659 */     this.defaultTransPosY = _os_.unmarshal_int();
/* 660 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 663 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 665 */       int _v_ = _os_.unmarshal_int();
/* 666 */       this.taskCfgidToFightCfgid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 668 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 671 */       SMapTransferRegion _v_ = new SMapTransferRegion();
/* 672 */       _v_.unmarshal(_os_);
/* 673 */       this.transferRegions.add(_v_);
/*     */     }
/* 675 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 678 */       SMapNPC _v_ = new SMapNPC();
/* 679 */       _v_.unmarshal(_os_);
/* 680 */       this.npcs.add(_v_);
/*     */     }
/* 682 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 685 */       SMapVisibleMonster _v_ = new SMapVisibleMonster();
/* 686 */       _v_.unmarshal(_os_);
/* 687 */       this.visibleMonsters.add(_v_);
/*     */     }
/* 689 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 692 */       int _v_ = _os_.unmarshal_int();
/* 693 */       this.items.add(Integer.valueOf(_v_));
/*     */     }
/* 695 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 698 */       int _v_ = _os_.unmarshal_int();
/* 699 */       this.polygons.add(Integer.valueOf(_v_));
/*     */     }
/* 701 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 706 */     String path = dir + "mzm.gsp.map.confbean.SMapConfig.xml";
/*     */     
/*     */     try
/*     */     {
/* 710 */       all = new HashMap();
/* 711 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 712 */       org.dom4j.Document doc = reader.read(new java.io.File(path));
/* 713 */       Element root = doc.getRootElement();
/* 714 */       List<?> nodeList = root.elements();
/* 715 */       int len = nodeList.size();
/* 716 */       for (int i = 0; i < len; i++)
/*     */       {
/* 718 */         Element elem = (Element)nodeList.get(i);
/* 719 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapConfig"))
/*     */         {
/*     */ 
/* 722 */           SMapConfig obj = new SMapConfig();
/* 723 */           obj.loadFromXml(elem);
/* 724 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 725 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 730 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMapConfig> all)
/*     */   {
/* 736 */     String path = dir + "mzm.gsp.map.confbean.SMapConfig.xml";
/*     */     
/*     */     try
/*     */     {
/* 740 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 741 */       org.dom4j.Document doc = reader.read(new java.io.File(path));
/* 742 */       Element root = doc.getRootElement();
/* 743 */       List<?> nodeList = root.elements();
/* 744 */       int len = nodeList.size();
/* 745 */       for (int i = 0; i < len; i++)
/*     */       {
/* 747 */         Element elem = (Element)nodeList.get(i);
/* 748 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapConfig"))
/*     */         {
/*     */ 
/* 751 */           SMapConfig obj = new SMapConfig();
/* 752 */           obj.loadFromXml(elem);
/* 753 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 754 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 759 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 765 */     all = new HashMap();
/*     */     
/* 767 */     String path = dir + "mzm.gsp.map.confbean.SMapConfig.bny";
/*     */     try
/*     */     {
/* 770 */       java.io.File file = new java.io.File(path);
/* 771 */       if (file.exists())
/*     */       {
/* 773 */         byte[] bytes = new byte['Ѐ'];
/* 774 */         java.io.FileInputStream fis = new java.io.FileInputStream(file);
/* 775 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 776 */         int len = 0;
/* 777 */         while ((len = fis.read(bytes)) > 0)
/* 778 */           baos.write(bytes, 0, len);
/* 779 */         fis.close();
/* 780 */         bytes = baos.toByteArray();
/* 781 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 782 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 784 */           _os_.unmarshal_int();
/* 785 */           _os_.unmarshal_int();
/* 786 */           _os_.unmarshal_int();
/*     */         }
/* 788 */         _os_.unmarshal_int();
/* 789 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 792 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 794 */           SMapConfig _v_ = new SMapConfig();
/* 795 */           _v_.unmarshal(_os_);
/* 796 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 797 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 802 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 807 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMapConfig> all)
/*     */   {
/* 814 */     String path = dir + "mzm.gsp.map.confbean.SMapConfig.bny";
/*     */     try
/*     */     {
/* 817 */       java.io.File file = new java.io.File(path);
/* 818 */       if (file.exists())
/*     */       {
/* 820 */         byte[] bytes = new byte['Ѐ'];
/* 821 */         java.io.FileInputStream fis = new java.io.FileInputStream(file);
/* 822 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 823 */         int len = 0;
/* 824 */         while ((len = fis.read(bytes)) > 0)
/* 825 */           baos.write(bytes, 0, len);
/* 826 */         fis.close();
/* 827 */         bytes = baos.toByteArray();
/* 828 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 829 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 831 */           _os_.unmarshal_int();
/* 832 */           _os_.unmarshal_int();
/* 833 */           _os_.unmarshal_int();
/*     */         }
/* 835 */         _os_.unmarshal_int();
/* 836 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 839 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 841 */           SMapConfig _v_ = new SMapConfig();
/* 842 */           _v_.unmarshal(_os_);
/* 843 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 844 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 849 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 854 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMapConfig getOld(int key)
/*     */   {
/* 862 */     return (SMapConfig)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMapConfig get(int key)
/*     */   {
/* 867 */     return (SMapConfig)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapConfig> getOldAll()
/*     */   {
/* 872 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapConfig> getAll()
/*     */   {
/* 877 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMapConfig> newAll)
/*     */   {
/* 882 */     oldAll = all;
/* 883 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 888 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */