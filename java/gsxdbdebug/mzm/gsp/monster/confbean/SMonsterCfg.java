/*     */ package mzm.gsp.monster.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SMonsterCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMonsterCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMonsterCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int propertyTierId;
/*     */   public int categoryId;
/*     */   public int typeId;
/*     */   public int groupId;
/*     */   public int levelLow;
/*     */   public int levelHigh;
/*     */   public String name;
/*     */   public int gender;
/*     */   public int classType;
/*     */   public int classLevel;
/*     */   public int monsterModelId;
/*     */   public int modelColorId;
/*     */   public int modelFigureId;
/*     */   public int catchRate;
/*     */   public int catchedMonsterId;
/*     */   public int monsterSkillProbBase;
/*  35 */   public java.util.TreeMap<Integer, Integer> monsterSkillProbs = new java.util.TreeMap();
/*     */   public int rewardTableId;
/*     */   public String monsterStrategy;
/*  38 */   public HashMap<Integer, Double> props = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  42 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  43 */     this.propertyTierId = Integer.valueOf(rootElement.attributeValue("propertyTierId")).intValue();
/*  44 */     this.categoryId = Integer.valueOf(rootElement.attributeValue("categoryId")).intValue();
/*  45 */     this.typeId = Integer.valueOf(rootElement.attributeValue("typeId")).intValue();
/*  46 */     this.groupId = Integer.valueOf(rootElement.attributeValue("groupId")).intValue();
/*  47 */     this.levelLow = Integer.valueOf(rootElement.attributeValue("levelLow")).intValue();
/*  48 */     this.levelHigh = Integer.valueOf(rootElement.attributeValue("levelHigh")).intValue();
/*  49 */     this.name = rootElement.attributeValue("name");
/*  50 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  51 */     this.classType = Integer.valueOf(rootElement.attributeValue("classType")).intValue();
/*  52 */     this.classLevel = Integer.valueOf(rootElement.attributeValue("classLevel")).intValue();
/*  53 */     this.monsterModelId = Integer.valueOf(rootElement.attributeValue("monsterModelId")).intValue();
/*  54 */     this.modelColorId = Integer.valueOf(rootElement.attributeValue("modelColorId")).intValue();
/*  55 */     this.modelFigureId = Integer.valueOf(rootElement.attributeValue("modelFigureId")).intValue();
/*  56 */     this.catchRate = Integer.valueOf(rootElement.attributeValue("catchRate")).intValue();
/*  57 */     this.catchedMonsterId = Integer.valueOf(rootElement.attributeValue("catchedMonsterId")).intValue();
/*  58 */     this.monsterSkillProbBase = Integer.valueOf(rootElement.attributeValue("monsterSkillProbBase")).intValue();
/*     */     
/*  60 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "monsterSkillProbs");
/*  61 */     if (mapTypeElement == null)
/*     */     {
/*  63 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  66 */     List<?> entryNodeList = mapTypeElement.elements();
/*  67 */     int entryLen = entryNodeList.size();
/*  68 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  70 */       Element entryElement = (Element)entryNodeList.get(i);
/*  71 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  76 */         Element keyElem = null;
/*  77 */         Element valueElem = null;
/*     */         
/*  79 */         List<?> _nodeList = entryElement.elements();
/*  80 */         int _len = _nodeList.size();
/*  81 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  83 */           Element elem = (Element)_nodeList.get(j);
/*  84 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  86 */             keyElem = elem;
/*     */           }
/*  88 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  90 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  94 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  96 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 103 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 104 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 111 */         this.monsterSkillProbs.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 114 */     this.rewardTableId = Integer.valueOf(rootElement.attributeValue("rewardTableId")).intValue();
/* 115 */     this.monsterStrategy = rootElement.attributeValue("monsterStrategy");
/*     */     
/* 117 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "props");
/* 118 */     if (mapTypeElement == null)
/*     */     {
/* 120 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 123 */     List<?> entryNodeList = mapTypeElement.elements();
/* 124 */     int entryLen = entryNodeList.size();
/* 125 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 127 */       Element entryElement = (Element)entryNodeList.get(i);
/* 128 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 133 */         Element keyElem = null;
/* 134 */         Element valueElem = null;
/*     */         
/* 136 */         List<?> _nodeList = entryElement.elements();
/* 137 */         int _len = _nodeList.size();
/* 138 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 140 */           Element elem = (Element)_nodeList.get(j);
/* 141 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 143 */             keyElem = elem;
/*     */           }
/* 145 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("float")))
/*     */           {
/* 147 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 151 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 153 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         double _v_;
/*     */         try
/*     */         {
/* 160 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 161 */           _v_ = Double.valueOf(valueElem.getText()).doubleValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 168 */         this.props.put(Integer.valueOf(_k_), Double.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 175 */     _os_.marshal(this.id);
/* 176 */     _os_.marshal(this.propertyTierId);
/* 177 */     _os_.marshal(this.categoryId);
/* 178 */     _os_.marshal(this.typeId);
/* 179 */     _os_.marshal(this.groupId);
/* 180 */     _os_.marshal(this.levelLow);
/* 181 */     _os_.marshal(this.levelHigh);
/* 182 */     _os_.marshal(this.name, "UTF-8");
/* 183 */     _os_.marshal(this.gender);
/* 184 */     _os_.marshal(this.classType);
/* 185 */     _os_.marshal(this.classLevel);
/* 186 */     _os_.marshal(this.monsterModelId);
/* 187 */     _os_.marshal(this.modelColorId);
/* 188 */     _os_.marshal(this.modelFigureId);
/* 189 */     _os_.marshal(this.catchRate);
/* 190 */     _os_.marshal(this.catchedMonsterId);
/* 191 */     _os_.marshal(this.monsterSkillProbBase);
/* 192 */     _os_.compact_uint32(this.monsterSkillProbs.size());
/* 193 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.monsterSkillProbs.entrySet())
/*     */     {
/* 195 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 196 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 198 */     _os_.marshal(this.rewardTableId);
/* 199 */     _os_.marshal(this.monsterStrategy, "UTF-8");
/* 200 */     _os_.compact_uint32(this.props.size());
/* 201 */     for (java.util.Map.Entry<Integer, Double> _e_ : this.props.entrySet())
/*     */     {
/* 203 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 204 */       _os_.marshal(((Double)_e_.getValue()).doubleValue());
/*     */     }
/* 206 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 211 */     this.id = _os_.unmarshal_int();
/* 212 */     this.propertyTierId = _os_.unmarshal_int();
/* 213 */     this.categoryId = _os_.unmarshal_int();
/* 214 */     this.typeId = _os_.unmarshal_int();
/* 215 */     this.groupId = _os_.unmarshal_int();
/* 216 */     this.levelLow = _os_.unmarshal_int();
/* 217 */     this.levelHigh = _os_.unmarshal_int();
/* 218 */     this.name = _os_.unmarshal_String("UTF-8");
/* 219 */     this.gender = _os_.unmarshal_int();
/* 220 */     this.classType = _os_.unmarshal_int();
/* 221 */     this.classLevel = _os_.unmarshal_int();
/* 222 */     this.monsterModelId = _os_.unmarshal_int();
/* 223 */     this.modelColorId = _os_.unmarshal_int();
/* 224 */     this.modelFigureId = _os_.unmarshal_int();
/* 225 */     this.catchRate = _os_.unmarshal_int();
/* 226 */     this.catchedMonsterId = _os_.unmarshal_int();
/* 227 */     this.monsterSkillProbBase = _os_.unmarshal_int();
/* 228 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 231 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 233 */       int _v_ = _os_.unmarshal_int();
/* 234 */       this.monsterSkillProbs.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 236 */     this.rewardTableId = _os_.unmarshal_int();
/* 237 */     this.monsterStrategy = _os_.unmarshal_String("UTF-8");
/* 238 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 241 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 243 */       double _v_ = _os_.unmarshal_float();
/* 244 */       this.props.put(Integer.valueOf(_k_), Double.valueOf(_v_));
/*     */     }
/* 246 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 251 */     String path = dir + "mzm.gsp.monster.confbean.SMonsterCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 255 */       all = new HashMap();
/* 256 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 257 */       org.dom4j.Document doc = reader.read(new File(path));
/* 258 */       Element root = doc.getRootElement();
/* 259 */       List<?> nodeList = root.elements();
/* 260 */       int len = nodeList.size();
/* 261 */       for (int i = 0; i < len; i++)
/*     */       {
/* 263 */         Element elem = (Element)nodeList.get(i);
/* 264 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SMonsterCfg"))
/*     */         {
/*     */ 
/* 267 */           SMonsterCfg obj = new SMonsterCfg();
/* 268 */           obj.loadFromXml(elem);
/* 269 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 270 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 275 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMonsterCfg> all)
/*     */   {
/* 281 */     String path = dir + "mzm.gsp.monster.confbean.SMonsterCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 285 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 286 */       org.dom4j.Document doc = reader.read(new File(path));
/* 287 */       Element root = doc.getRootElement();
/* 288 */       List<?> nodeList = root.elements();
/* 289 */       int len = nodeList.size();
/* 290 */       for (int i = 0; i < len; i++)
/*     */       {
/* 292 */         Element elem = (Element)nodeList.get(i);
/* 293 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SMonsterCfg"))
/*     */         {
/*     */ 
/* 296 */           SMonsterCfg obj = new SMonsterCfg();
/* 297 */           obj.loadFromXml(elem);
/* 298 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 299 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 304 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 310 */     all = new HashMap();
/*     */     
/* 312 */     String path = dir + "mzm.gsp.monster.confbean.SMonsterCfg.bny";
/*     */     try
/*     */     {
/* 315 */       File file = new File(path);
/* 316 */       if (file.exists())
/*     */       {
/* 318 */         byte[] bytes = new byte['Ѐ'];
/* 319 */         FileInputStream fis = new FileInputStream(file);
/* 320 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 321 */         int len = 0;
/* 322 */         while ((len = fis.read(bytes)) > 0)
/* 323 */           baos.write(bytes, 0, len);
/* 324 */         fis.close();
/* 325 */         bytes = baos.toByteArray();
/* 326 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 327 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 329 */           _os_.unmarshal_int();
/* 330 */           _os_.unmarshal_int();
/* 331 */           _os_.unmarshal_int();
/*     */         }
/* 333 */         _os_.unmarshal_int();
/* 334 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 337 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 339 */           SMonsterCfg _v_ = new SMonsterCfg();
/* 340 */           _v_.unmarshal(_os_);
/* 341 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 342 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 347 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 352 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMonsterCfg> all)
/*     */   {
/* 359 */     String path = dir + "mzm.gsp.monster.confbean.SMonsterCfg.bny";
/*     */     try
/*     */     {
/* 362 */       File file = new File(path);
/* 363 */       if (file.exists())
/*     */       {
/* 365 */         byte[] bytes = new byte['Ѐ'];
/* 366 */         FileInputStream fis = new FileInputStream(file);
/* 367 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 368 */         int len = 0;
/* 369 */         while ((len = fis.read(bytes)) > 0)
/* 370 */           baos.write(bytes, 0, len);
/* 371 */         fis.close();
/* 372 */         bytes = baos.toByteArray();
/* 373 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 374 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 376 */           _os_.unmarshal_int();
/* 377 */           _os_.unmarshal_int();
/* 378 */           _os_.unmarshal_int();
/*     */         }
/* 380 */         _os_.unmarshal_int();
/* 381 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 384 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 386 */           SMonsterCfg _v_ = new SMonsterCfg();
/* 387 */           _v_.unmarshal(_os_);
/* 388 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 389 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 394 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 399 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMonsterCfg getOld(int key)
/*     */   {
/* 407 */     return (SMonsterCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMonsterCfg get(int key)
/*     */   {
/* 412 */     return (SMonsterCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMonsterCfg> getOldAll()
/*     */   {
/* 417 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMonsterCfg> getAll()
/*     */   {
/* 422 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMonsterCfg> newAll)
/*     */   {
/* 427 */     oldAll = all;
/* 428 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 433 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\confbean\SMonsterCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */