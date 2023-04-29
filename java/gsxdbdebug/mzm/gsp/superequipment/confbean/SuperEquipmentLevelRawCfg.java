/*     */ package mzm.gsp.superequipment.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SuperEquipmentLevelRawCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SuperEquipmentLevelRawCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SuperEquipmentLevelRawCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int level;
/*     */   public int equipmentType;
/*  21 */   public ArrayList<SuperEquipmentPropertyImproveBean> improveBeans = new ArrayList();
/*     */   public int requiredStrengthLevel;
/*     */   public int requiredStage;
/*     */   public int requiredCurrencyType;
/*     */   public int requiredCurrencyNum;
/*  26 */   public ArrayList<SuperEquipmentLevelRequiredItem> requiredItems = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  32 */     this.equipmentType = Integer.valueOf(rootElement.attributeValue("equipmentType")).intValue();
/*     */     
/*  34 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "improveBeans");
/*  35 */     if (collectionElement == null)
/*     */     {
/*  37 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  40 */     List<?> _nodeList = collectionElement.elements();
/*  41 */     int _len = _nodeList.size();
/*  42 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  44 */       Element elem = (Element)_nodeList.get(i);
/*  45 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SuperEquipmentPropertyImproveBean"))
/*     */       {
/*     */         SuperEquipmentPropertyImproveBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  52 */           _v_ = new SuperEquipmentPropertyImproveBean();
/*  53 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  60 */         this.improveBeans.add(_v_);
/*     */       }
/*     */     }
/*  63 */     this.requiredStrengthLevel = Integer.valueOf(rootElement.attributeValue("requiredStrengthLevel")).intValue();
/*  64 */     this.requiredStage = Integer.valueOf(rootElement.attributeValue("requiredStage")).intValue();
/*  65 */     this.requiredCurrencyType = Integer.valueOf(rootElement.attributeValue("requiredCurrencyType")).intValue();
/*  66 */     this.requiredCurrencyNum = Integer.valueOf(rootElement.attributeValue("requiredCurrencyNum")).intValue();
/*     */     
/*  68 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "requiredItems");
/*  69 */     if (collectionElement == null)
/*     */     {
/*  71 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  74 */     List<?> _nodeList = collectionElement.elements();
/*  75 */     int _len = _nodeList.size();
/*  76 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  78 */       Element elem = (Element)_nodeList.get(i);
/*  79 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SuperEquipmentLevelRequiredItem"))
/*     */       {
/*     */         SuperEquipmentLevelRequiredItem _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  86 */           _v_ = new SuperEquipmentLevelRequiredItem();
/*  87 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  94 */         this.requiredItems.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 101 */     _os_.marshal(this.id);
/* 102 */     _os_.marshal(this.level);
/* 103 */     _os_.marshal(this.equipmentType);
/* 104 */     _os_.compact_uint32(this.improveBeans.size());
/* 105 */     for (SuperEquipmentPropertyImproveBean _v_ : this.improveBeans)
/*     */     {
/* 107 */       _os_.marshal(_v_);
/*     */     }
/* 109 */     _os_.marshal(this.requiredStrengthLevel);
/* 110 */     _os_.marshal(this.requiredStage);
/* 111 */     _os_.marshal(this.requiredCurrencyType);
/* 112 */     _os_.marshal(this.requiredCurrencyNum);
/* 113 */     _os_.compact_uint32(this.requiredItems.size());
/* 114 */     for (SuperEquipmentLevelRequiredItem _v_ : this.requiredItems)
/*     */     {
/* 116 */       _os_.marshal(_v_);
/*     */     }
/* 118 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 123 */     this.id = _os_.unmarshal_int();
/* 124 */     this.level = _os_.unmarshal_int();
/* 125 */     this.equipmentType = _os_.unmarshal_int();
/* 126 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 129 */       SuperEquipmentPropertyImproveBean _v_ = new SuperEquipmentPropertyImproveBean();
/* 130 */       _v_.unmarshal(_os_);
/* 131 */       this.improveBeans.add(_v_);
/*     */     }
/* 133 */     this.requiredStrengthLevel = _os_.unmarshal_int();
/* 134 */     this.requiredStage = _os_.unmarshal_int();
/* 135 */     this.requiredCurrencyType = _os_.unmarshal_int();
/* 136 */     this.requiredCurrencyNum = _os_.unmarshal_int();
/* 137 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 140 */       SuperEquipmentLevelRequiredItem _v_ = new SuperEquipmentLevelRequiredItem();
/* 141 */       _v_.unmarshal(_os_);
/* 142 */       this.requiredItems.add(_v_);
/*     */     }
/* 144 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 149 */     String path = dir + "mzm.gsp.superequipment.confbean.SuperEquipmentLevelRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 153 */       all = new java.util.HashMap();
/* 154 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 155 */       org.dom4j.Document doc = reader.read(new File(path));
/* 156 */       Element root = doc.getRootElement();
/* 157 */       List<?> nodeList = root.elements();
/* 158 */       int len = nodeList.size();
/* 159 */       for (int i = 0; i < len; i++)
/*     */       {
/* 161 */         Element elem = (Element)nodeList.get(i);
/* 162 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SuperEquipmentLevelRawCfg"))
/*     */         {
/*     */ 
/* 165 */           SuperEquipmentLevelRawCfg obj = new SuperEquipmentLevelRawCfg();
/* 166 */           obj.loadFromXml(elem);
/* 167 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 168 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 173 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SuperEquipmentLevelRawCfg> all)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.superequipment.confbean.SuperEquipmentLevelRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 183 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 184 */       org.dom4j.Document doc = reader.read(new File(path));
/* 185 */       Element root = doc.getRootElement();
/* 186 */       List<?> nodeList = root.elements();
/* 187 */       int len = nodeList.size();
/* 188 */       for (int i = 0; i < len; i++)
/*     */       {
/* 190 */         Element elem = (Element)nodeList.get(i);
/* 191 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SuperEquipmentLevelRawCfg"))
/*     */         {
/*     */ 
/* 194 */           SuperEquipmentLevelRawCfg obj = new SuperEquipmentLevelRawCfg();
/* 195 */           obj.loadFromXml(elem);
/* 196 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 202 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 208 */     all = new java.util.HashMap();
/*     */     
/* 210 */     String path = dir + "mzm.gsp.superequipment.confbean.SuperEquipmentLevelRawCfg.bny";
/*     */     try
/*     */     {
/* 213 */       File file = new File(path);
/* 214 */       if (file.exists())
/*     */       {
/* 216 */         byte[] bytes = new byte['Ѐ'];
/* 217 */         FileInputStream fis = new FileInputStream(file);
/* 218 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 219 */         int len = 0;
/* 220 */         while ((len = fis.read(bytes)) > 0)
/* 221 */           baos.write(bytes, 0, len);
/* 222 */         fis.close();
/* 223 */         bytes = baos.toByteArray();
/* 224 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 227 */           _os_.unmarshal_int();
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/*     */         }
/* 231 */         _os_.unmarshal_int();
/* 232 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 235 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 237 */           SuperEquipmentLevelRawCfg _v_ = new SuperEquipmentLevelRawCfg();
/* 238 */           _v_.unmarshal(_os_);
/* 239 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 240 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 245 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 250 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SuperEquipmentLevelRawCfg> all)
/*     */   {
/* 257 */     String path = dir + "mzm.gsp.superequipment.confbean.SuperEquipmentLevelRawCfg.bny";
/*     */     try
/*     */     {
/* 260 */       File file = new File(path);
/* 261 */       if (file.exists())
/*     */       {
/* 263 */         byte[] bytes = new byte['Ѐ'];
/* 264 */         FileInputStream fis = new FileInputStream(file);
/* 265 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 266 */         int len = 0;
/* 267 */         while ((len = fis.read(bytes)) > 0)
/* 268 */           baos.write(bytes, 0, len);
/* 269 */         fis.close();
/* 270 */         bytes = baos.toByteArray();
/* 271 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 272 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 274 */           _os_.unmarshal_int();
/* 275 */           _os_.unmarshal_int();
/* 276 */           _os_.unmarshal_int();
/*     */         }
/* 278 */         _os_.unmarshal_int();
/* 279 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 282 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 284 */           SuperEquipmentLevelRawCfg _v_ = new SuperEquipmentLevelRawCfg();
/* 285 */           _v_.unmarshal(_os_);
/* 286 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 287 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 292 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 297 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SuperEquipmentLevelRawCfg getOld(int key)
/*     */   {
/* 305 */     return (SuperEquipmentLevelRawCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SuperEquipmentLevelRawCfg get(int key)
/*     */   {
/* 310 */     return (SuperEquipmentLevelRawCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SuperEquipmentLevelRawCfg> getOldAll()
/*     */   {
/* 315 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SuperEquipmentLevelRawCfg> getAll()
/*     */   {
/* 320 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SuperEquipmentLevelRawCfg> newAll)
/*     */   {
/* 325 */     oldAll = all;
/* 326 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 331 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\confbean\SuperEquipmentLevelRawCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */