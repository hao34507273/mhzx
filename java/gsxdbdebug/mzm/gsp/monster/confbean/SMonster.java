/*     */ package mzm.gsp.monster.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMonster implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMonster> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMonster> all = null;
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
/*     */   public int catchRate;
/*     */   public int monsterModelId;
/*     */   public int modelColorId;
/*     */   public int modelFigureId;
/*     */   public int catchedMonsterId;
/*     */   public double HP_RATIO;
/*     */   public double MAG_RATIO;
/*     */   public double PHY_ATK_RATIO;
/*     */   public double PHY_DEF_RATIO;
/*     */   public double MAG_ATK_RATIO;
/*     */   public double MAG_DEF_RATIO;
/*     */   public double PHY_CRT_LEVEL_RATIO;
/*     */   public double MAG_CRT_LEVEL_RATIO;
/*     */   public double PHY_CRT_DEF_LEVEL_RATIO;
/*     */   public double MAG_CRT_DEF_LEVEL_RATIO;
/*     */   public double PHY_CRT_RATE_RATIO;
/*     */   public double MAG_CRT_RATE_RATIO;
/*     */   public double HEAL_CRT_RATE_RATIO;
/*     */   public double PHY_CRT_RATIO;
/*     */   public double MAG_CRT_RATIO;
/*     */   public double SEAL_HIT_LEVEL_RATIO;
/*     */   public double SEAL_RES_LEVEL_RATIO;
/*     */   public double PHY_HIT_LEVEL_RATIO;
/*     */   public double PHY_DODGE_LEVEL_RATIO;
/*     */   public double MAG_HIT_LEVEL_RATIO;
/*     */   public double MAG_DODGE_LEVEL_RATIO;
/*     */   public double SPEED_RATIO;
/*     */   public double ANGER_RATIO;
/*  57 */   public java.util.LinkedList<MonsterSkillProbInfo> monsterSkillProbList = new java.util.LinkedList();
/*     */   public int rewardTableId;
/*     */   public String monsterStrategy;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  63 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  64 */     this.propertyTierId = Integer.valueOf(rootElement.attributeValue("propertyTierId")).intValue();
/*  65 */     this.categoryId = Integer.valueOf(rootElement.attributeValue("categoryId")).intValue();
/*  66 */     this.typeId = Integer.valueOf(rootElement.attributeValue("typeId")).intValue();
/*  67 */     this.groupId = Integer.valueOf(rootElement.attributeValue("groupId")).intValue();
/*  68 */     this.levelLow = Integer.valueOf(rootElement.attributeValue("levelLow")).intValue();
/*  69 */     this.levelHigh = Integer.valueOf(rootElement.attributeValue("levelHigh")).intValue();
/*  70 */     this.name = rootElement.attributeValue("name");
/*  71 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  72 */     this.classType = Integer.valueOf(rootElement.attributeValue("classType")).intValue();
/*  73 */     this.classLevel = Integer.valueOf(rootElement.attributeValue("classLevel")).intValue();
/*  74 */     this.catchRate = Integer.valueOf(rootElement.attributeValue("catchRate")).intValue();
/*  75 */     this.monsterModelId = Integer.valueOf(rootElement.attributeValue("monsterModelId")).intValue();
/*  76 */     this.modelColorId = Integer.valueOf(rootElement.attributeValue("modelColorId")).intValue();
/*  77 */     this.modelFigureId = Integer.valueOf(rootElement.attributeValue("modelFigureId")).intValue();
/*  78 */     this.catchedMonsterId = Integer.valueOf(rootElement.attributeValue("catchedMonsterId")).intValue();
/*  79 */     this.HP_RATIO = Double.valueOf(rootElement.attributeValue("HP_RATIO")).doubleValue();
/*  80 */     this.MAG_RATIO = Double.valueOf(rootElement.attributeValue("MAG_RATIO")).doubleValue();
/*  81 */     this.PHY_ATK_RATIO = Double.valueOf(rootElement.attributeValue("PHY_ATK_RATIO")).doubleValue();
/*  82 */     this.PHY_DEF_RATIO = Double.valueOf(rootElement.attributeValue("PHY_DEF_RATIO")).doubleValue();
/*  83 */     this.MAG_ATK_RATIO = Double.valueOf(rootElement.attributeValue("MAG_ATK_RATIO")).doubleValue();
/*  84 */     this.MAG_DEF_RATIO = Double.valueOf(rootElement.attributeValue("MAG_DEF_RATIO")).doubleValue();
/*  85 */     this.PHY_CRT_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("PHY_CRT_LEVEL_RATIO")).doubleValue();
/*  86 */     this.MAG_CRT_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("MAG_CRT_LEVEL_RATIO")).doubleValue();
/*  87 */     this.PHY_CRT_DEF_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("PHY_CRT_DEF_LEVEL_RATIO")).doubleValue();
/*  88 */     this.MAG_CRT_DEF_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("MAG_CRT_DEF_LEVEL_RATIO")).doubleValue();
/*  89 */     this.PHY_CRT_RATE_RATIO = Double.valueOf(rootElement.attributeValue("PHY_CRT_RATE_RATIO")).doubleValue();
/*  90 */     this.MAG_CRT_RATE_RATIO = Double.valueOf(rootElement.attributeValue("MAG_CRT_RATE_RATIO")).doubleValue();
/*  91 */     this.HEAL_CRT_RATE_RATIO = Double.valueOf(rootElement.attributeValue("HEAL_CRT_RATE_RATIO")).doubleValue();
/*  92 */     this.PHY_CRT_RATIO = Double.valueOf(rootElement.attributeValue("PHY_CRT_RATIO")).doubleValue();
/*  93 */     this.MAG_CRT_RATIO = Double.valueOf(rootElement.attributeValue("MAG_CRT_RATIO")).doubleValue();
/*  94 */     this.SEAL_HIT_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("SEAL_HIT_LEVEL_RATIO")).doubleValue();
/*  95 */     this.SEAL_RES_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("SEAL_RES_LEVEL_RATIO")).doubleValue();
/*  96 */     this.PHY_HIT_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("PHY_HIT_LEVEL_RATIO")).doubleValue();
/*  97 */     this.PHY_DODGE_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("PHY_DODGE_LEVEL_RATIO")).doubleValue();
/*  98 */     this.MAG_HIT_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("MAG_HIT_LEVEL_RATIO")).doubleValue();
/*  99 */     this.MAG_DODGE_LEVEL_RATIO = Double.valueOf(rootElement.attributeValue("MAG_DODGE_LEVEL_RATIO")).doubleValue();
/* 100 */     this.SPEED_RATIO = Double.valueOf(rootElement.attributeValue("SPEED_RATIO")).doubleValue();
/* 101 */     this.ANGER_RATIO = Double.valueOf(rootElement.attributeValue("ANGER_RATIO")).doubleValue();
/*     */     
/* 103 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "monsterSkillProbList");
/* 104 */     if (collectionElement == null)
/*     */     {
/* 106 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 109 */     List<?> _nodeList = collectionElement.elements();
/* 110 */     int _len = _nodeList.size();
/* 111 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 113 */       Element elem = (Element)_nodeList.get(i);
/* 114 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.MonsterSkillProbInfo"))
/*     */       {
/*     */         MonsterSkillProbInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 121 */           _v_ = new MonsterSkillProbInfo();
/* 122 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 129 */         this.monsterSkillProbList.add(_v_);
/*     */       }
/*     */     }
/* 132 */     this.rewardTableId = Integer.valueOf(rootElement.attributeValue("rewardTableId")).intValue();
/* 133 */     this.monsterStrategy = rootElement.attributeValue("monsterStrategy");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 138 */     _os_.marshal(this.id);
/* 139 */     _os_.marshal(this.propertyTierId);
/* 140 */     _os_.marshal(this.categoryId);
/* 141 */     _os_.marshal(this.typeId);
/* 142 */     _os_.marshal(this.groupId);
/* 143 */     _os_.marshal(this.levelLow);
/* 144 */     _os_.marshal(this.levelHigh);
/* 145 */     _os_.marshal(this.name, "UTF-8");
/* 146 */     _os_.marshal(this.gender);
/* 147 */     _os_.marshal(this.classType);
/* 148 */     _os_.marshal(this.classLevel);
/* 149 */     _os_.marshal(this.catchRate);
/* 150 */     _os_.marshal(this.monsterModelId);
/* 151 */     _os_.marshal(this.modelColorId);
/* 152 */     _os_.marshal(this.modelFigureId);
/* 153 */     _os_.marshal(this.catchedMonsterId);
/* 154 */     _os_.marshal(this.HP_RATIO);
/* 155 */     _os_.marshal(this.MAG_RATIO);
/* 156 */     _os_.marshal(this.PHY_ATK_RATIO);
/* 157 */     _os_.marshal(this.PHY_DEF_RATIO);
/* 158 */     _os_.marshal(this.MAG_ATK_RATIO);
/* 159 */     _os_.marshal(this.MAG_DEF_RATIO);
/* 160 */     _os_.marshal(this.PHY_CRT_LEVEL_RATIO);
/* 161 */     _os_.marshal(this.MAG_CRT_LEVEL_RATIO);
/* 162 */     _os_.marshal(this.PHY_CRT_DEF_LEVEL_RATIO);
/* 163 */     _os_.marshal(this.MAG_CRT_DEF_LEVEL_RATIO);
/* 164 */     _os_.marshal(this.PHY_CRT_RATE_RATIO);
/* 165 */     _os_.marshal(this.MAG_CRT_RATE_RATIO);
/* 166 */     _os_.marshal(this.HEAL_CRT_RATE_RATIO);
/* 167 */     _os_.marshal(this.PHY_CRT_RATIO);
/* 168 */     _os_.marshal(this.MAG_CRT_RATIO);
/* 169 */     _os_.marshal(this.SEAL_HIT_LEVEL_RATIO);
/* 170 */     _os_.marshal(this.SEAL_RES_LEVEL_RATIO);
/* 171 */     _os_.marshal(this.PHY_HIT_LEVEL_RATIO);
/* 172 */     _os_.marshal(this.PHY_DODGE_LEVEL_RATIO);
/* 173 */     _os_.marshal(this.MAG_HIT_LEVEL_RATIO);
/* 174 */     _os_.marshal(this.MAG_DODGE_LEVEL_RATIO);
/* 175 */     _os_.marshal(this.SPEED_RATIO);
/* 176 */     _os_.marshal(this.ANGER_RATIO);
/* 177 */     _os_.compact_uint32(this.monsterSkillProbList.size());
/* 178 */     for (MonsterSkillProbInfo _v_ : this.monsterSkillProbList)
/*     */     {
/* 180 */       _os_.marshal(_v_);
/*     */     }
/* 182 */     _os_.marshal(this.rewardTableId);
/* 183 */     _os_.marshal(this.monsterStrategy, "UTF-8");
/* 184 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 189 */     this.id = _os_.unmarshal_int();
/* 190 */     this.propertyTierId = _os_.unmarshal_int();
/* 191 */     this.categoryId = _os_.unmarshal_int();
/* 192 */     this.typeId = _os_.unmarshal_int();
/* 193 */     this.groupId = _os_.unmarshal_int();
/* 194 */     this.levelLow = _os_.unmarshal_int();
/* 195 */     this.levelHigh = _os_.unmarshal_int();
/* 196 */     this.name = _os_.unmarshal_String("UTF-8");
/* 197 */     this.gender = _os_.unmarshal_int();
/* 198 */     this.classType = _os_.unmarshal_int();
/* 199 */     this.classLevel = _os_.unmarshal_int();
/* 200 */     this.catchRate = _os_.unmarshal_int();
/* 201 */     this.monsterModelId = _os_.unmarshal_int();
/* 202 */     this.modelColorId = _os_.unmarshal_int();
/* 203 */     this.modelFigureId = _os_.unmarshal_int();
/* 204 */     this.catchedMonsterId = _os_.unmarshal_int();
/* 205 */     this.HP_RATIO = _os_.unmarshal_float();
/* 206 */     this.MAG_RATIO = _os_.unmarshal_float();
/* 207 */     this.PHY_ATK_RATIO = _os_.unmarshal_float();
/* 208 */     this.PHY_DEF_RATIO = _os_.unmarshal_float();
/* 209 */     this.MAG_ATK_RATIO = _os_.unmarshal_float();
/* 210 */     this.MAG_DEF_RATIO = _os_.unmarshal_float();
/* 211 */     this.PHY_CRT_LEVEL_RATIO = _os_.unmarshal_float();
/* 212 */     this.MAG_CRT_LEVEL_RATIO = _os_.unmarshal_float();
/* 213 */     this.PHY_CRT_DEF_LEVEL_RATIO = _os_.unmarshal_float();
/* 214 */     this.MAG_CRT_DEF_LEVEL_RATIO = _os_.unmarshal_float();
/* 215 */     this.PHY_CRT_RATE_RATIO = _os_.unmarshal_float();
/* 216 */     this.MAG_CRT_RATE_RATIO = _os_.unmarshal_float();
/* 217 */     this.HEAL_CRT_RATE_RATIO = _os_.unmarshal_float();
/* 218 */     this.PHY_CRT_RATIO = _os_.unmarshal_float();
/* 219 */     this.MAG_CRT_RATIO = _os_.unmarshal_float();
/* 220 */     this.SEAL_HIT_LEVEL_RATIO = _os_.unmarshal_float();
/* 221 */     this.SEAL_RES_LEVEL_RATIO = _os_.unmarshal_float();
/* 222 */     this.PHY_HIT_LEVEL_RATIO = _os_.unmarshal_float();
/* 223 */     this.PHY_DODGE_LEVEL_RATIO = _os_.unmarshal_float();
/* 224 */     this.MAG_HIT_LEVEL_RATIO = _os_.unmarshal_float();
/* 225 */     this.MAG_DODGE_LEVEL_RATIO = _os_.unmarshal_float();
/* 226 */     this.SPEED_RATIO = _os_.unmarshal_float();
/* 227 */     this.ANGER_RATIO = _os_.unmarshal_float();
/* 228 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 231 */       MonsterSkillProbInfo _v_ = new MonsterSkillProbInfo();
/* 232 */       _v_.unmarshal(_os_);
/* 233 */       this.monsterSkillProbList.add(_v_);
/*     */     }
/* 235 */     this.rewardTableId = _os_.unmarshal_int();
/* 236 */     this.monsterStrategy = _os_.unmarshal_String("UTF-8");
/* 237 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 242 */     String path = dir + "mzm.gsp.monster.confbean.SMonster.xml";
/*     */     
/*     */     try
/*     */     {
/* 246 */       all = new java.util.HashMap();
/* 247 */       SAXReader reader = new SAXReader();
/* 248 */       org.dom4j.Document doc = reader.read(new File(path));
/* 249 */       Element root = doc.getRootElement();
/* 250 */       List<?> nodeList = root.elements();
/* 251 */       int len = nodeList.size();
/* 252 */       for (int i = 0; i < len; i++)
/*     */       {
/* 254 */         Element elem = (Element)nodeList.get(i);
/* 255 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SMonster"))
/*     */         {
/*     */ 
/* 258 */           SMonster obj = new SMonster();
/* 259 */           obj.loadFromXml(elem);
/* 260 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 261 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 266 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMonster> all)
/*     */   {
/* 272 */     String path = dir + "mzm.gsp.monster.confbean.SMonster.xml";
/*     */     
/*     */     try
/*     */     {
/* 276 */       SAXReader reader = new SAXReader();
/* 277 */       org.dom4j.Document doc = reader.read(new File(path));
/* 278 */       Element root = doc.getRootElement();
/* 279 */       List<?> nodeList = root.elements();
/* 280 */       int len = nodeList.size();
/* 281 */       for (int i = 0; i < len; i++)
/*     */       {
/* 283 */         Element elem = (Element)nodeList.get(i);
/* 284 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SMonster"))
/*     */         {
/*     */ 
/* 287 */           SMonster obj = new SMonster();
/* 288 */           obj.loadFromXml(elem);
/* 289 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 290 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 295 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 301 */     all = new java.util.HashMap();
/*     */     
/* 303 */     String path = dir + "mzm.gsp.monster.confbean.SMonster.bny";
/*     */     try
/*     */     {
/* 306 */       File file = new File(path);
/* 307 */       if (file.exists())
/*     */       {
/* 309 */         byte[] bytes = new byte['Ѐ'];
/* 310 */         FileInputStream fis = new FileInputStream(file);
/* 311 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 312 */         int len = 0;
/* 313 */         while ((len = fis.read(bytes)) > 0)
/* 314 */           baos.write(bytes, 0, len);
/* 315 */         fis.close();
/* 316 */         bytes = baos.toByteArray();
/* 317 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 318 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 320 */           _os_.unmarshal_int();
/* 321 */           _os_.unmarshal_int();
/* 322 */           _os_.unmarshal_int();
/*     */         }
/* 324 */         _os_.unmarshal_int();
/* 325 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 328 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 330 */           SMonster _v_ = new SMonster();
/* 331 */           _v_.unmarshal(_os_);
/* 332 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 333 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 338 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 343 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMonster> all)
/*     */   {
/* 350 */     String path = dir + "mzm.gsp.monster.confbean.SMonster.bny";
/*     */     try
/*     */     {
/* 353 */       File file = new File(path);
/* 354 */       if (file.exists())
/*     */       {
/* 356 */         byte[] bytes = new byte['Ѐ'];
/* 357 */         FileInputStream fis = new FileInputStream(file);
/* 358 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 359 */         int len = 0;
/* 360 */         while ((len = fis.read(bytes)) > 0)
/* 361 */           baos.write(bytes, 0, len);
/* 362 */         fis.close();
/* 363 */         bytes = baos.toByteArray();
/* 364 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 365 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 367 */           _os_.unmarshal_int();
/* 368 */           _os_.unmarshal_int();
/* 369 */           _os_.unmarshal_int();
/*     */         }
/* 371 */         _os_.unmarshal_int();
/* 372 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 375 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 377 */           SMonster _v_ = new SMonster();
/* 378 */           _v_.unmarshal(_os_);
/* 379 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 380 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 385 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 390 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMonster getOld(int key)
/*     */   {
/* 398 */     return (SMonster)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMonster get(int key)
/*     */   {
/* 403 */     return (SMonster)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMonster> getOldAll()
/*     */   {
/* 408 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMonster> getAll()
/*     */   {
/* 413 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMonster> newAll)
/*     */   {
/* 418 */     oldAll = all;
/* 419 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 424 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\confbean\SMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */