/*     */ package mzm.gsp.task.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SNpc2Task implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SNpc2Task> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SNpc2Task> all = null;
/*     */   
/*     */   public int npcId;
/*  19 */   public ArrayList<Integer> acceptTaskIds = new ArrayList();
/*  20 */   public ArrayList<Integer> finishTaskIds = new ArrayList();
/*  21 */   public HashMap<Integer, SBattleIds> taskIdToBattleIds = new HashMap();
/*  22 */   public HashMap<Integer, Integer> taskIdToPvcIds = new HashMap();
/*  23 */   public HashMap<Integer, Integer> taskId2QuestionLibId = new HashMap();
/*  24 */   public ArrayList<Integer> dlgTaskIds = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.npcId = Integer.valueOf(rootElement.attributeValue("npcId")).intValue();
/*     */     
/*  30 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "acceptTaskIds");
/*  31 */     if (collectionElement == null)
/*     */     {
/*  33 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  36 */     List<?> _nodeList = collectionElement.elements();
/*  37 */     int _len = _nodeList.size();
/*  38 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  40 */       Element elem = (Element)_nodeList.get(i);
/*  41 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  48 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  55 */         this.acceptTaskIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  59 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "finishTaskIds");
/*  60 */     if (collectionElement == null)
/*     */     {
/*  62 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  65 */     List<?> _nodeList = collectionElement.elements();
/*  66 */     int _len = _nodeList.size();
/*  67 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  69 */       Element elem = (Element)_nodeList.get(i);
/*  70 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  77 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  84 */         this.finishTaskIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  88 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "taskIdToBattleIds");
/*  89 */     if (mapTypeElement == null)
/*     */     {
/*  91 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  94 */     List<?> entryNodeList = mapTypeElement.elements();
/*  95 */     int entryLen = entryNodeList.size();
/*  96 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  98 */       Element entryElement = (Element)entryNodeList.get(i);
/*  99 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 104 */         Element keyElem = null;
/* 105 */         Element valueElem = null;
/*     */         
/* 107 */         List<?> _nodeList = entryElement.elements();
/* 108 */         int _len = _nodeList.size();
/* 109 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 111 */           Element elem = (Element)_nodeList.get(j);
/* 112 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 114 */             keyElem = elem;
/*     */           }
/* 116 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SBattleIds")))
/*     */           {
/* 118 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 122 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 124 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SBattleIds _v_;
/*     */         try
/*     */         {
/* 131 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 132 */           _v_ = new SBattleIds();
/* 133 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 140 */         this.taskIdToBattleIds.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/* 144 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "taskIdToPvcIds");
/* 145 */     if (mapTypeElement == null)
/*     */     {
/* 147 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 150 */     List<?> entryNodeList = mapTypeElement.elements();
/* 151 */     int entryLen = entryNodeList.size();
/* 152 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 154 */       Element entryElement = (Element)entryNodeList.get(i);
/* 155 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 160 */         Element keyElem = null;
/* 161 */         Element valueElem = null;
/*     */         
/* 163 */         List<?> _nodeList = entryElement.elements();
/* 164 */         int _len = _nodeList.size();
/* 165 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 167 */           Element elem = (Element)_nodeList.get(j);
/* 168 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 170 */             keyElem = elem;
/*     */           }
/* 172 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 174 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 178 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 180 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 187 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 188 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 195 */         this.taskIdToPvcIds.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 199 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "taskId2QuestionLibId");
/* 200 */     if (mapTypeElement == null)
/*     */     {
/* 202 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 205 */     List<?> entryNodeList = mapTypeElement.elements();
/* 206 */     int entryLen = entryNodeList.size();
/* 207 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 209 */       Element entryElement = (Element)entryNodeList.get(i);
/* 210 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 215 */         Element keyElem = null;
/* 216 */         Element valueElem = null;
/*     */         
/* 218 */         List<?> _nodeList = entryElement.elements();
/* 219 */         int _len = _nodeList.size();
/* 220 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 222 */           Element elem = (Element)_nodeList.get(j);
/* 223 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 225 */             keyElem = elem;
/*     */           }
/* 227 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 229 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 233 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 235 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 242 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 243 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 250 */         this.taskId2QuestionLibId.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 254 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "dlgTaskIds");
/* 255 */     if (collectionElement == null)
/*     */     {
/* 257 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 260 */     List<?> _nodeList = collectionElement.elements();
/* 261 */     int _len = _nodeList.size();
/* 262 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 264 */       Element elem = (Element)_nodeList.get(i);
/* 265 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 272 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 279 */         this.dlgTaskIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 286 */     _os_.marshal(this.npcId);
/* 287 */     _os_.compact_uint32(this.acceptTaskIds.size());
/* 288 */     for (Integer _v_ : this.acceptTaskIds)
/*     */     {
/* 290 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 292 */     _os_.compact_uint32(this.finishTaskIds.size());
/* 293 */     for (Integer _v_ : this.finishTaskIds)
/*     */     {
/* 295 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 297 */     _os_.compact_uint32(this.taskIdToBattleIds.size());
/* 298 */     for (Map.Entry<Integer, SBattleIds> _e_ : this.taskIdToBattleIds.entrySet())
/*     */     {
/* 300 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 301 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 303 */     _os_.compact_uint32(this.taskIdToPvcIds.size());
/* 304 */     for (Map.Entry<Integer, Integer> _e_ : this.taskIdToPvcIds.entrySet())
/*     */     {
/* 306 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 307 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 309 */     _os_.compact_uint32(this.taskId2QuestionLibId.size());
/* 310 */     for (Map.Entry<Integer, Integer> _e_ : this.taskId2QuestionLibId.entrySet())
/*     */     {
/* 312 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 313 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 315 */     _os_.compact_uint32(this.dlgTaskIds.size());
/* 316 */     for (Integer _v_ : this.dlgTaskIds)
/*     */     {
/* 318 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 320 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 325 */     this.npcId = _os_.unmarshal_int();
/* 326 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 329 */       int _v_ = _os_.unmarshal_int();
/* 330 */       this.acceptTaskIds.add(Integer.valueOf(_v_));
/*     */     }
/* 332 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 335 */       int _v_ = _os_.unmarshal_int();
/* 336 */       this.finishTaskIds.add(Integer.valueOf(_v_));
/*     */     }
/* 338 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 341 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 343 */       SBattleIds _v_ = new SBattleIds();
/* 344 */       _v_.unmarshal(_os_);
/* 345 */       this.taskIdToBattleIds.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 347 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 350 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 352 */       int _v_ = _os_.unmarshal_int();
/* 353 */       this.taskIdToPvcIds.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 355 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 358 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 360 */       int _v_ = _os_.unmarshal_int();
/* 361 */       this.taskId2QuestionLibId.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 363 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 366 */       int _v_ = _os_.unmarshal_int();
/* 367 */       this.dlgTaskIds.add(Integer.valueOf(_v_));
/*     */     }
/* 369 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 374 */     String path = dir + "mzm.gsp.task.confbean.SNpc2Task.xml";
/*     */     
/*     */     try
/*     */     {
/* 378 */       all = new HashMap();
/* 379 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 380 */       org.dom4j.Document doc = reader.read(new java.io.File(path));
/* 381 */       Element root = doc.getRootElement();
/* 382 */       List<?> nodeList = root.elements();
/* 383 */       int len = nodeList.size();
/* 384 */       for (int i = 0; i < len; i++)
/*     */       {
/* 386 */         Element elem = (Element)nodeList.get(i);
/* 387 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SNpc2Task"))
/*     */         {
/*     */ 
/* 390 */           SNpc2Task obj = new SNpc2Task();
/* 391 */           obj.loadFromXml(elem);
/* 392 */           if (all.put(Integer.valueOf(obj.npcId), obj) != null) {
/* 393 */             throw new RuntimeException("duplicate key : " + obj.npcId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 398 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SNpc2Task> all)
/*     */   {
/* 404 */     String path = dir + "mzm.gsp.task.confbean.SNpc2Task.xml";
/*     */     
/*     */     try
/*     */     {
/* 408 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 409 */       org.dom4j.Document doc = reader.read(new java.io.File(path));
/* 410 */       Element root = doc.getRootElement();
/* 411 */       List<?> nodeList = root.elements();
/* 412 */       int len = nodeList.size();
/* 413 */       for (int i = 0; i < len; i++)
/*     */       {
/* 415 */         Element elem = (Element)nodeList.get(i);
/* 416 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SNpc2Task"))
/*     */         {
/*     */ 
/* 419 */           SNpc2Task obj = new SNpc2Task();
/* 420 */           obj.loadFromXml(elem);
/* 421 */           if (all.put(Integer.valueOf(obj.npcId), obj) != null) {
/* 422 */             throw new RuntimeException("duplicate key : " + obj.npcId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 427 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 433 */     all = new HashMap();
/*     */     
/* 435 */     String path = dir + "mzm.gsp.task.confbean.SNpc2Task.bny";
/*     */     try
/*     */     {
/* 438 */       java.io.File file = new java.io.File(path);
/* 439 */       if (file.exists())
/*     */       {
/* 441 */         byte[] bytes = new byte['Ѐ'];
/* 442 */         FileInputStream fis = new FileInputStream(file);
/* 443 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 444 */         int len = 0;
/* 445 */         while ((len = fis.read(bytes)) > 0)
/* 446 */           baos.write(bytes, 0, len);
/* 447 */         fis.close();
/* 448 */         bytes = baos.toByteArray();
/* 449 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 450 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 452 */           _os_.unmarshal_int();
/* 453 */           _os_.unmarshal_int();
/* 454 */           _os_.unmarshal_int();
/*     */         }
/* 456 */         _os_.unmarshal_int();
/* 457 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 460 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 462 */           SNpc2Task _v_ = new SNpc2Task();
/* 463 */           _v_.unmarshal(_os_);
/* 464 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 465 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 470 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 475 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SNpc2Task> all)
/*     */   {
/* 482 */     String path = dir + "mzm.gsp.task.confbean.SNpc2Task.bny";
/*     */     try
/*     */     {
/* 485 */       java.io.File file = new java.io.File(path);
/* 486 */       if (file.exists())
/*     */       {
/* 488 */         byte[] bytes = new byte['Ѐ'];
/* 489 */         FileInputStream fis = new FileInputStream(file);
/* 490 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 491 */         int len = 0;
/* 492 */         while ((len = fis.read(bytes)) > 0)
/* 493 */           baos.write(bytes, 0, len);
/* 494 */         fis.close();
/* 495 */         bytes = baos.toByteArray();
/* 496 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 497 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 499 */           _os_.unmarshal_int();
/* 500 */           _os_.unmarshal_int();
/* 501 */           _os_.unmarshal_int();
/*     */         }
/* 503 */         _os_.unmarshal_int();
/* 504 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 507 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 509 */           SNpc2Task _v_ = new SNpc2Task();
/* 510 */           _v_.unmarshal(_os_);
/* 511 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 512 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 517 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 522 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SNpc2Task getOld(int key)
/*     */   {
/* 530 */     return (SNpc2Task)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SNpc2Task get(int key)
/*     */   {
/* 535 */     return (SNpc2Task)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNpc2Task> getOldAll()
/*     */   {
/* 540 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNpc2Task> getAll()
/*     */   {
/* 545 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SNpc2Task> newAll)
/*     */   {
/* 550 */     oldAll = all;
/* 551 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 556 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\SNpc2Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */