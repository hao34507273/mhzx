/*     */ package mzm.gsp.visiblemonsterfight.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SGangRobberConst
/*     */ {
/*  13 */   private static volatile SGangRobberConst oldInstance = null;
/*     */   
/*  15 */   private static SGangRobberConst instance = new SGangRobberConst();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SGangRobberConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SGangRobberConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int ACTIVITYID = 0;
/*  32 */   public int VISIBLE_MONSTER_ID = 0;
/*  33 */   public ArrayList<Integer> controlers = new ArrayList();
/*  34 */   public ArrayList<Integer> awardids = new ArrayList();
/*  35 */   public ArrayList<Integer> triggerTimes = new ArrayList();
/*  36 */   public int REWARD_LIMIT = 10;
/*  37 */   public int AWARD_GANG_MONEY = 0;
/*  38 */   public int GANG_AWARD_ID = 0;
/*  39 */   public ArrayList<Integer> monsterids = new ArrayList();
/*  40 */   public int TEAM_GANG_MEMBER_NUM = 3;
/*  41 */   public int ROBBER_COUNT_NOTIFY_INTERVAL = 600;
/*  42 */   public int ROBBER_COUNT_NOTIFY_DELAY_SEC = 600;
/*  43 */   public int ROBBER_NEXT_ROUND_MINUTE = 120;
/*  44 */   public int ROBBER_ROUND_INTERVAL_MINUTE = 60;
/*  45 */   public int deductPerMonster = 60;
/*  46 */   public int deductLimit = 1000;
/*  47 */   public int maxRefreshCount = 5;
/*  48 */   public int refreshMonsterNumPer = 2;
/*  49 */   public int deadCountCanAward = 20;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  53 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  58 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst.xml";
/*     */     try
/*     */     {
/*  61 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  62 */       org.dom4j.Document doc = reader.read(new File(path));
/*  63 */       Element root = doc.getRootElement();
/*  64 */       Map<String, Element> data = new java.util.HashMap();
/*  65 */       List<?> nodeList = root.elements();
/*  66 */       int len = nodeList.size();
/*  67 */       for (int i = 0; i < len; i++)
/*     */       {
/*  69 */         Element element = (Element)nodeList.get(i);
/*  70 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  73 */           String name = element.attributeValue("name");
/*  74 */           if (data.put(name, element) != null)
/*  75 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  78 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  79 */       this.VISIBLE_MONSTER_ID = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID")).attributeValue("value")).intValue();
/*     */       
/*  81 */       Element collectionElement = (Element)data.get("controlers");
/*  82 */       if (collectionElement == null)
/*     */       {
/*  84 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/*  87 */       List<?> _nodeList = collectionElement.elements();
/*  88 */       int _len = _nodeList.size();
/*  89 */       for (int i = 0; i < _len; i++)
/*     */       {
/*  91 */         Element elem = (Element)_nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/*  99 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 106 */           this.controlers.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */       
/* 110 */       Element collectionElement = (Element)data.get("awardids");
/* 111 */       if (collectionElement == null)
/*     */       {
/* 113 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 116 */       List<?> _nodeList = collectionElement.elements();
/* 117 */       int _len = _nodeList.size();
/* 118 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 120 */         Element elem = (Element)_nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 128 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 135 */           this.awardids.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */       
/* 139 */       Element collectionElement = (Element)data.get("triggerTimes");
/* 140 */       if (collectionElement == null)
/*     */       {
/* 142 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 145 */       List<?> _nodeList = collectionElement.elements();
/* 146 */       int _len = _nodeList.size();
/* 147 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 149 */         Element elem = (Element)_nodeList.get(i);
/* 150 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 157 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 164 */           this.triggerTimes.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 167 */       this.REWARD_LIMIT = Integer.valueOf(((Element)data.get("REWARD_LIMIT")).attributeValue("value")).intValue();
/* 168 */       this.AWARD_GANG_MONEY = Integer.valueOf(((Element)data.get("AWARD_GANG_MONEY")).attributeValue("value")).intValue();
/* 169 */       this.GANG_AWARD_ID = Integer.valueOf(((Element)data.get("GANG_AWARD_ID")).attributeValue("value")).intValue();
/*     */       
/* 171 */       Element collectionElement = (Element)data.get("monsterids");
/* 172 */       if (collectionElement == null)
/*     */       {
/* 174 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 177 */       List<?> _nodeList = collectionElement.elements();
/* 178 */       int _len = _nodeList.size();
/* 179 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 181 */         Element elem = (Element)_nodeList.get(i);
/* 182 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 189 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 196 */           this.monsterids.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 199 */       this.TEAM_GANG_MEMBER_NUM = Integer.valueOf(((Element)data.get("TEAM_GANG_MEMBER_NUM")).attributeValue("value")).intValue();
/* 200 */       this.ROBBER_COUNT_NOTIFY_INTERVAL = Integer.valueOf(((Element)data.get("ROBBER_COUNT_NOTIFY_INTERVAL")).attributeValue("value")).intValue();
/* 201 */       this.ROBBER_COUNT_NOTIFY_DELAY_SEC = Integer.valueOf(((Element)data.get("ROBBER_COUNT_NOTIFY_DELAY_SEC")).attributeValue("value")).intValue();
/* 202 */       this.ROBBER_NEXT_ROUND_MINUTE = Integer.valueOf(((Element)data.get("ROBBER_NEXT_ROUND_MINUTE")).attributeValue("value")).intValue();
/* 203 */       this.ROBBER_ROUND_INTERVAL_MINUTE = Integer.valueOf(((Element)data.get("ROBBER_ROUND_INTERVAL_MINUTE")).attributeValue("value")).intValue();
/* 204 */       this.deductPerMonster = Integer.valueOf(((Element)data.get("deductPerMonster")).attributeValue("value")).intValue();
/* 205 */       this.deductLimit = Integer.valueOf(((Element)data.get("deductLimit")).attributeValue("value")).intValue();
/* 206 */       this.maxRefreshCount = Integer.valueOf(((Element)data.get("maxRefreshCount")).attributeValue("value")).intValue();
/* 207 */       this.refreshMonsterNumPer = Integer.valueOf(((Element)data.get("refreshMonsterNumPer")).attributeValue("value")).intValue();
/* 208 */       this.deadCountCanAward = Integer.valueOf(((Element)data.get("deadCountCanAward")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 212 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 217 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst.xml";
/*     */     try
/*     */     {
/* 220 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 221 */       org.dom4j.Document doc = reader.read(new File(path));
/* 222 */       Element root = doc.getRootElement();
/* 223 */       Map<String, Element> data = new java.util.HashMap();
/* 224 */       List<?> nodeList = root.elements();
/* 225 */       int len = nodeList.size();
/* 226 */       for (int i = 0; i < len; i++)
/*     */       {
/* 228 */         Element element = (Element)nodeList.get(i);
/* 229 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 232 */           String name = element.attributeValue("name");
/* 233 */           if (data.put(name, element) != null)
/* 234 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 237 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 238 */       this.VISIBLE_MONSTER_ID = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID")).attributeValue("value")).intValue();
/*     */       
/* 240 */       Element collectionElement = (Element)data.get("controlers");
/* 241 */       if (collectionElement == null)
/*     */       {
/* 243 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 246 */       List<?> _nodeList = collectionElement.elements();
/* 247 */       int _len = _nodeList.size();
/* 248 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 250 */         Element elem = (Element)_nodeList.get(i);
/* 251 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 258 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 265 */           this.controlers.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */       
/* 269 */       Element collectionElement = (Element)data.get("awardids");
/* 270 */       if (collectionElement == null)
/*     */       {
/* 272 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 275 */       List<?> _nodeList = collectionElement.elements();
/* 276 */       int _len = _nodeList.size();
/* 277 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 279 */         Element elem = (Element)_nodeList.get(i);
/* 280 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 287 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 294 */           this.awardids.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */       
/* 298 */       Element collectionElement = (Element)data.get("triggerTimes");
/* 299 */       if (collectionElement == null)
/*     */       {
/* 301 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 304 */       List<?> _nodeList = collectionElement.elements();
/* 305 */       int _len = _nodeList.size();
/* 306 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 308 */         Element elem = (Element)_nodeList.get(i);
/* 309 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 316 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 323 */           this.triggerTimes.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 326 */       this.REWARD_LIMIT = Integer.valueOf(((Element)data.get("REWARD_LIMIT")).attributeValue("value")).intValue();
/* 327 */       this.AWARD_GANG_MONEY = Integer.valueOf(((Element)data.get("AWARD_GANG_MONEY")).attributeValue("value")).intValue();
/* 328 */       this.GANG_AWARD_ID = Integer.valueOf(((Element)data.get("GANG_AWARD_ID")).attributeValue("value")).intValue();
/*     */       
/* 330 */       Element collectionElement = (Element)data.get("monsterids");
/* 331 */       if (collectionElement == null)
/*     */       {
/* 333 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 336 */       List<?> _nodeList = collectionElement.elements();
/* 337 */       int _len = _nodeList.size();
/* 338 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 340 */         Element elem = (Element)_nodeList.get(i);
/* 341 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 348 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 355 */           this.monsterids.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 358 */       this.TEAM_GANG_MEMBER_NUM = Integer.valueOf(((Element)data.get("TEAM_GANG_MEMBER_NUM")).attributeValue("value")).intValue();
/* 359 */       this.ROBBER_COUNT_NOTIFY_INTERVAL = Integer.valueOf(((Element)data.get("ROBBER_COUNT_NOTIFY_INTERVAL")).attributeValue("value")).intValue();
/* 360 */       this.ROBBER_COUNT_NOTIFY_DELAY_SEC = Integer.valueOf(((Element)data.get("ROBBER_COUNT_NOTIFY_DELAY_SEC")).attributeValue("value")).intValue();
/* 361 */       this.ROBBER_NEXT_ROUND_MINUTE = Integer.valueOf(((Element)data.get("ROBBER_NEXT_ROUND_MINUTE")).attributeValue("value")).intValue();
/* 362 */       this.ROBBER_ROUND_INTERVAL_MINUTE = Integer.valueOf(((Element)data.get("ROBBER_ROUND_INTERVAL_MINUTE")).attributeValue("value")).intValue();
/* 363 */       this.deductPerMonster = Integer.valueOf(((Element)data.get("deductPerMonster")).attributeValue("value")).intValue();
/* 364 */       this.deductLimit = Integer.valueOf(((Element)data.get("deductLimit")).attributeValue("value")).intValue();
/* 365 */       this.maxRefreshCount = Integer.valueOf(((Element)data.get("maxRefreshCount")).attributeValue("value")).intValue();
/* 366 */       this.refreshMonsterNumPer = Integer.valueOf(((Element)data.get("refreshMonsterNumPer")).attributeValue("value")).intValue();
/* 367 */       this.deadCountCanAward = Integer.valueOf(((Element)data.get("deadCountCanAward")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 371 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 375 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 378 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst.bny";
/*     */     try
/*     */     {
/* 381 */       File file = new File(path);
/* 382 */       if (file.exists())
/*     */       {
/* 384 */         byte[] bytes = new byte['Ѐ'];
/* 385 */         FileInputStream fis = new FileInputStream(file);
/* 386 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 387 */         int len = 0;
/* 388 */         while ((len = fis.read(bytes)) > 0)
/* 389 */           baos.write(bytes, 0, len);
/* 390 */         fis.close();
/* 391 */         bytes = baos.toByteArray();
/* 392 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 393 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 394 */         this.VISIBLE_MONSTER_ID = _os_.unmarshal_int();
/* 395 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 398 */           int _v_ = _os_.unmarshal_int();
/* 399 */           this.controlers.add(Integer.valueOf(_v_));
/*     */         }
/* 401 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 404 */           int _v_ = _os_.unmarshal_int();
/* 405 */           this.awardids.add(Integer.valueOf(_v_));
/*     */         }
/* 407 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 410 */           int _v_ = _os_.unmarshal_int();
/* 411 */           this.triggerTimes.add(Integer.valueOf(_v_));
/*     */         }
/* 413 */         this.REWARD_LIMIT = _os_.unmarshal_int();
/* 414 */         this.AWARD_GANG_MONEY = _os_.unmarshal_int();
/* 415 */         this.GANG_AWARD_ID = _os_.unmarshal_int();
/* 416 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 419 */           int _v_ = _os_.unmarshal_int();
/* 420 */           this.monsterids.add(Integer.valueOf(_v_));
/*     */         }
/* 422 */         this.TEAM_GANG_MEMBER_NUM = _os_.unmarshal_int();
/* 423 */         this.ROBBER_COUNT_NOTIFY_INTERVAL = _os_.unmarshal_int();
/* 424 */         this.ROBBER_COUNT_NOTIFY_DELAY_SEC = _os_.unmarshal_int();
/* 425 */         this.ROBBER_NEXT_ROUND_MINUTE = _os_.unmarshal_int();
/* 426 */         this.ROBBER_ROUND_INTERVAL_MINUTE = _os_.unmarshal_int();
/* 427 */         this.deductPerMonster = _os_.unmarshal_int();
/* 428 */         this.deductLimit = _os_.unmarshal_int();
/* 429 */         this.maxRefreshCount = _os_.unmarshal_int();
/* 430 */         this.refreshMonsterNumPer = _os_.unmarshal_int();
/* 431 */         this.deadCountCanAward = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 436 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 442 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst.bny";
/*     */     try
/*     */     {
/* 445 */       File file = new File(path);
/* 446 */       if (file.exists())
/*     */       {
/* 448 */         byte[] bytes = new byte['Ѐ'];
/* 449 */         FileInputStream fis = new FileInputStream(file);
/* 450 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 451 */         int len = 0;
/* 452 */         while ((len = fis.read(bytes)) > 0)
/* 453 */           baos.write(bytes, 0, len);
/* 454 */         fis.close();
/* 455 */         bytes = baos.toByteArray();
/* 456 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 457 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 458 */         this.VISIBLE_MONSTER_ID = _os_.unmarshal_int();
/* 459 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 462 */           int _v_ = _os_.unmarshal_int();
/* 463 */           this.controlers.add(Integer.valueOf(_v_));
/*     */         }
/* 465 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 468 */           int _v_ = _os_.unmarshal_int();
/* 469 */           this.awardids.add(Integer.valueOf(_v_));
/*     */         }
/* 471 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 474 */           int _v_ = _os_.unmarshal_int();
/* 475 */           this.triggerTimes.add(Integer.valueOf(_v_));
/*     */         }
/* 477 */         this.REWARD_LIMIT = _os_.unmarshal_int();
/* 478 */         this.AWARD_GANG_MONEY = _os_.unmarshal_int();
/* 479 */         this.GANG_AWARD_ID = _os_.unmarshal_int();
/* 480 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 483 */           int _v_ = _os_.unmarshal_int();
/* 484 */           this.monsterids.add(Integer.valueOf(_v_));
/*     */         }
/* 486 */         this.TEAM_GANG_MEMBER_NUM = _os_.unmarshal_int();
/* 487 */         this.ROBBER_COUNT_NOTIFY_INTERVAL = _os_.unmarshal_int();
/* 488 */         this.ROBBER_COUNT_NOTIFY_DELAY_SEC = _os_.unmarshal_int();
/* 489 */         this.ROBBER_NEXT_ROUND_MINUTE = _os_.unmarshal_int();
/* 490 */         this.ROBBER_ROUND_INTERVAL_MINUTE = _os_.unmarshal_int();
/* 491 */         this.deductPerMonster = _os_.unmarshal_int();
/* 492 */         this.deductLimit = _os_.unmarshal_int();
/* 493 */         this.maxRefreshCount = _os_.unmarshal_int();
/* 494 */         this.refreshMonsterNumPer = _os_.unmarshal_int();
/* 495 */         this.deadCountCanAward = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 500 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SGangRobberConst newInstance)
/*     */   {
/* 506 */     oldInstance = instance;
/* 507 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 512 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\confbean\SGangRobberConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */