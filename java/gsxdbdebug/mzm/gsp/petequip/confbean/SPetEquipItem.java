/*     */ package mzm.gsp.petequip.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SPetEquipItem extends mzm.gsp.item.confbean.SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SPetEquipItem> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SPetEquipItem> all = null;
/*     */   
/*     */   public int equipType;
/*     */   public int property1Rate;
/*     */   public int property2Rate;
/*     */   public int PetPropertyTableId;
/*     */   public int monsterSkillId;
/*     */   public int random1Skil2Prop;
/*     */   public int equipLevel;
/*  26 */   public java.util.ArrayList<MonsterSkill2Prop> monsterSkillPropList = new java.util.ArrayList();
/*     */   public int initSkillID1;
/*     */   public int initSkillID2;
/*     */   public boolean isMerge;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  35 */     this.name = rootElement.attributeValue("name");
/*  36 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  37 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  38 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  39 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  40 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  41 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  42 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  43 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  44 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  45 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  46 */     this.equipType = Integer.valueOf(rootElement.attributeValue("equipType")).intValue();
/*  47 */     this.property1Rate = Integer.valueOf(rootElement.attributeValue("property1Rate")).intValue();
/*  48 */     this.property2Rate = Integer.valueOf(rootElement.attributeValue("property2Rate")).intValue();
/*  49 */     this.PetPropertyTableId = Integer.valueOf(rootElement.attributeValue("PetPropertyTableId")).intValue();
/*  50 */     this.monsterSkillId = Integer.valueOf(rootElement.attributeValue("monsterSkillId")).intValue();
/*  51 */     this.random1Skil2Prop = Integer.valueOf(rootElement.attributeValue("random1Skil2Prop")).intValue();
/*  52 */     this.equipLevel = Integer.valueOf(rootElement.attributeValue("equipLevel")).intValue();
/*     */     
/*  54 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "monsterSkillPropList");
/*  55 */     if (collectionElement == null)
/*     */     {
/*  57 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  60 */     List<?> _nodeList = collectionElement.elements();
/*  61 */     int _len = _nodeList.size();
/*  62 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  64 */       Element elem = (Element)_nodeList.get(i);
/*  65 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.petequip.confbean.MonsterSkill2Prop"))
/*     */       {
/*     */         MonsterSkill2Prop _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  72 */           _v_ = new MonsterSkill2Prop();
/*  73 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  80 */         this.monsterSkillPropList.add(_v_);
/*     */       }
/*     */     }
/*  83 */     this.initSkillID1 = Integer.valueOf(rootElement.attributeValue("initSkillID1")).intValue();
/*  84 */     this.initSkillID2 = Integer.valueOf(rootElement.attributeValue("initSkillID2")).intValue();
/*  85 */     this.isMerge = Boolean.valueOf(rootElement.attributeValue("isMerge")).booleanValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  90 */     _os_.marshal(this.id);
/*  91 */     _os_.marshal(this.type);
/*  92 */     _os_.marshal(this.name, "UTF-8");
/*  93 */     _os_.marshal(this.namecolor);
/*  94 */     _os_.marshal(this.icon);
/*  95 */     _os_.marshal(this.pilemax);
/*  96 */     _os_.marshal(this.sellSilver);
/*  97 */     _os_.marshal(this.isProprietary);
/*  98 */     _os_.marshal(this.canSellAndThrow);
/*  99 */     _os_.marshal(this.awardRoleLevelMin);
/* 100 */     _os_.marshal(this.awardRoleLevelMax);
/* 101 */     _os_.marshal(this.useLevel);
/* 102 */     _os_.marshal(this.sort);
/* 103 */     _os_.marshal(this.equipType);
/* 104 */     _os_.marshal(this.property1Rate);
/* 105 */     _os_.marshal(this.property2Rate);
/* 106 */     _os_.marshal(this.PetPropertyTableId);
/* 107 */     _os_.marshal(this.monsterSkillId);
/* 108 */     _os_.marshal(this.random1Skil2Prop);
/* 109 */     _os_.marshal(this.equipLevel);
/* 110 */     _os_.compact_uint32(this.monsterSkillPropList.size());
/* 111 */     for (MonsterSkill2Prop _v_ : this.monsterSkillPropList)
/*     */     {
/* 113 */       _os_.marshal(_v_);
/*     */     }
/* 115 */     _os_.marshal(this.initSkillID1);
/* 116 */     _os_.marshal(this.initSkillID2);
/* 117 */     _os_.marshal(this.isMerge);
/* 118 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 123 */     this.id = _os_.unmarshal_int();
/* 124 */     this.type = _os_.unmarshal_int();
/* 125 */     this.name = _os_.unmarshal_String("UTF-8");
/* 126 */     this.namecolor = _os_.unmarshal_int();
/* 127 */     this.icon = _os_.unmarshal_int();
/* 128 */     this.pilemax = _os_.unmarshal_int();
/* 129 */     this.sellSilver = _os_.unmarshal_int();
/* 130 */     this.isProprietary = _os_.unmarshal_boolean();
/* 131 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/* 132 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/* 133 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/* 134 */     this.useLevel = _os_.unmarshal_int();
/* 135 */     this.sort = _os_.unmarshal_int();
/* 136 */     this.equipType = _os_.unmarshal_int();
/* 137 */     this.property1Rate = _os_.unmarshal_int();
/* 138 */     this.property2Rate = _os_.unmarshal_int();
/* 139 */     this.PetPropertyTableId = _os_.unmarshal_int();
/* 140 */     this.monsterSkillId = _os_.unmarshal_int();
/* 141 */     this.random1Skil2Prop = _os_.unmarshal_int();
/* 142 */     this.equipLevel = _os_.unmarshal_int();
/* 143 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 146 */       MonsterSkill2Prop _v_ = new MonsterSkill2Prop();
/* 147 */       _v_.unmarshal(_os_);
/* 148 */       this.monsterSkillPropList.add(_v_);
/*     */     }
/* 150 */     this.initSkillID1 = _os_.unmarshal_int();
/* 151 */     this.initSkillID2 = _os_.unmarshal_int();
/* 152 */     this.isMerge = _os_.unmarshal_boolean();
/* 153 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 158 */     String path = dir + "mzm.gsp.petequip.confbean.SPetEquipItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 162 */       all = new java.util.HashMap();
/* 163 */       SAXReader reader = new SAXReader();
/* 164 */       org.dom4j.Document doc = reader.read(new File(path));
/* 165 */       Element root = doc.getRootElement();
/* 166 */       List<?> nodeList = root.elements();
/* 167 */       int len = nodeList.size();
/* 168 */       for (int i = 0; i < len; i++)
/*     */       {
/* 170 */         Element elem = (Element)nodeList.get(i);
/* 171 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petequip.confbean.SPetEquipItem"))
/*     */         {
/*     */ 
/* 174 */           SPetEquipItem obj = new SPetEquipItem();
/* 175 */           obj.loadFromXml(elem);
/* 176 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 177 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 182 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPetEquipItem> all)
/*     */   {
/* 188 */     String path = dir + "mzm.gsp.petequip.confbean.SPetEquipItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 192 */       SAXReader reader = new SAXReader();
/* 193 */       org.dom4j.Document doc = reader.read(new File(path));
/* 194 */       Element root = doc.getRootElement();
/* 195 */       List<?> nodeList = root.elements();
/* 196 */       int len = nodeList.size();
/* 197 */       for (int i = 0; i < len; i++)
/*     */       {
/* 199 */         Element elem = (Element)nodeList.get(i);
/* 200 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petequip.confbean.SPetEquipItem"))
/*     */         {
/*     */ 
/* 203 */           SPetEquipItem obj = new SPetEquipItem();
/* 204 */           obj.loadFromXml(elem);
/* 205 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 206 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 217 */     all = new java.util.HashMap();
/*     */     
/* 219 */     String path = dir + "mzm.gsp.petequip.confbean.SPetEquipItem.bny";
/*     */     try
/*     */     {
/* 222 */       File file = new File(path);
/* 223 */       if (file.exists())
/*     */       {
/* 225 */         byte[] bytes = new byte['Ѐ'];
/* 226 */         FileInputStream fis = new FileInputStream(file);
/* 227 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 228 */         int len = 0;
/* 229 */         while ((len = fis.read(bytes)) > 0)
/* 230 */           baos.write(bytes, 0, len);
/* 231 */         fis.close();
/* 232 */         bytes = baos.toByteArray();
/* 233 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 234 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 236 */           _os_.unmarshal_int();
/* 237 */           _os_.unmarshal_int();
/* 238 */           _os_.unmarshal_int();
/*     */         }
/* 240 */         _os_.unmarshal_int();
/* 241 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 244 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 246 */           SPetEquipItem _v_ = new SPetEquipItem();
/* 247 */           _v_.unmarshal(_os_);
/* 248 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 249 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 254 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 259 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPetEquipItem> all)
/*     */   {
/* 266 */     String path = dir + "mzm.gsp.petequip.confbean.SPetEquipItem.bny";
/*     */     try
/*     */     {
/* 269 */       File file = new File(path);
/* 270 */       if (file.exists())
/*     */       {
/* 272 */         byte[] bytes = new byte['Ѐ'];
/* 273 */         FileInputStream fis = new FileInputStream(file);
/* 274 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 275 */         int len = 0;
/* 276 */         while ((len = fis.read(bytes)) > 0)
/* 277 */           baos.write(bytes, 0, len);
/* 278 */         fis.close();
/* 279 */         bytes = baos.toByteArray();
/* 280 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 281 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 283 */           _os_.unmarshal_int();
/* 284 */           _os_.unmarshal_int();
/* 285 */           _os_.unmarshal_int();
/*     */         }
/* 287 */         _os_.unmarshal_int();
/* 288 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 291 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 293 */           SPetEquipItem _v_ = new SPetEquipItem();
/* 294 */           _v_.unmarshal(_os_);
/* 295 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 296 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 301 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 306 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 312 */     for (Map.Entry<Integer, SPetEquipItem> entry : all.entrySet())
/*     */     {
/* 314 */       if (mzm.gsp.item.confbean.SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 316 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 320 */       mzm.gsp.item.confbean.SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SPetEquipItem> all, Map<Integer, mzm.gsp.item.confbean.SItemCfg> parent)
/*     */   {
/* 327 */     for (Map.Entry<Integer, SPetEquipItem> entry : all.entrySet())
/*     */     {
/* 329 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 331 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 335 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SPetEquipItem getOld(int key)
/*     */   {
/* 342 */     return (SPetEquipItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPetEquipItem get(int key)
/*     */   {
/* 347 */     return (SPetEquipItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetEquipItem> getOldAllSelf()
/*     */   {
/* 352 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetEquipItem> getAllSelf()
/*     */   {
/* 357 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPetEquipItem> newAll)
/*     */   {
/* 362 */     oldAll = all;
/* 363 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 368 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petequip\confbean\SPetEquipItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */