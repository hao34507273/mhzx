/*     */ package mzm.gsp.superequipment.jewel.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SSuperEquipmentJewelItem extends mzm.gsp.item.confbean.SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SSuperEquipmentJewelItem> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SSuperEquipmentJewelItem> all = null;
/*     */   
/*     */   public int jewelLevel;
/*     */   public int jewelType;
/*     */   public int typeId;
/*  22 */   public ArrayList<Integer> properTypes = new ArrayList();
/*  23 */   public ArrayList<Integer> propertyValues = new ArrayList();
/*     */   public int nextLevelId;
/*     */   public int craftNextLevelCount;
/*     */   public int craftNextLevelMoneyType;
/*     */   public int craftNextLevelMoneyCount;
/*     */   public int craftNextLevelItemId;
/*     */   public int craftNextLevelItemCount;
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
/*  46 */     this.jewelLevel = Integer.valueOf(rootElement.attributeValue("jewelLevel")).intValue();
/*  47 */     this.jewelType = Integer.valueOf(rootElement.attributeValue("jewelType")).intValue();
/*  48 */     this.typeId = Integer.valueOf(rootElement.attributeValue("typeId")).intValue();
/*     */     
/*  50 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "properTypes");
/*  51 */     if (collectionElement == null)
/*     */     {
/*  53 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  56 */     List<?> _nodeList = collectionElement.elements();
/*  57 */     int _len = _nodeList.size();
/*  58 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  60 */       Element elem = (Element)_nodeList.get(i);
/*  61 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  68 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  75 */         this.properTypes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  79 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyValues");
/*  80 */     if (collectionElement == null)
/*     */     {
/*  82 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  85 */     List<?> _nodeList = collectionElement.elements();
/*  86 */     int _len = _nodeList.size();
/*  87 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  89 */       Element elem = (Element)_nodeList.get(i);
/*  90 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  97 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 104 */         this.propertyValues.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 107 */     this.nextLevelId = Integer.valueOf(rootElement.attributeValue("nextLevelId")).intValue();
/* 108 */     this.craftNextLevelCount = Integer.valueOf(rootElement.attributeValue("craftNextLevelCount")).intValue();
/* 109 */     this.craftNextLevelMoneyType = Integer.valueOf(rootElement.attributeValue("craftNextLevelMoneyType")).intValue();
/* 110 */     this.craftNextLevelMoneyCount = Integer.valueOf(rootElement.attributeValue("craftNextLevelMoneyCount")).intValue();
/* 111 */     this.craftNextLevelItemId = Integer.valueOf(rootElement.attributeValue("craftNextLevelItemId")).intValue();
/* 112 */     this.craftNextLevelItemCount = Integer.valueOf(rootElement.attributeValue("craftNextLevelItemCount")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 117 */     _os_.marshal(this.id);
/* 118 */     _os_.marshal(this.type);
/* 119 */     _os_.marshal(this.name, "UTF-8");
/* 120 */     _os_.marshal(this.namecolor);
/* 121 */     _os_.marshal(this.icon);
/* 122 */     _os_.marshal(this.pilemax);
/* 123 */     _os_.marshal(this.sellSilver);
/* 124 */     _os_.marshal(this.isProprietary);
/* 125 */     _os_.marshal(this.canSellAndThrow);
/* 126 */     _os_.marshal(this.awardRoleLevelMin);
/* 127 */     _os_.marshal(this.awardRoleLevelMax);
/* 128 */     _os_.marshal(this.useLevel);
/* 129 */     _os_.marshal(this.sort);
/* 130 */     _os_.marshal(this.jewelLevel);
/* 131 */     _os_.marshal(this.jewelType);
/* 132 */     _os_.marshal(this.typeId);
/* 133 */     _os_.compact_uint32(this.properTypes.size());
/* 134 */     for (Integer _v_ : this.properTypes)
/*     */     {
/* 136 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 138 */     _os_.compact_uint32(this.propertyValues.size());
/* 139 */     for (Integer _v_ : this.propertyValues)
/*     */     {
/* 141 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 143 */     _os_.marshal(this.nextLevelId);
/* 144 */     _os_.marshal(this.craftNextLevelCount);
/* 145 */     _os_.marshal(this.craftNextLevelMoneyType);
/* 146 */     _os_.marshal(this.craftNextLevelMoneyCount);
/* 147 */     _os_.marshal(this.craftNextLevelItemId);
/* 148 */     _os_.marshal(this.craftNextLevelItemCount);
/* 149 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 154 */     this.id = _os_.unmarshal_int();
/* 155 */     this.type = _os_.unmarshal_int();
/* 156 */     this.name = _os_.unmarshal_String("UTF-8");
/* 157 */     this.namecolor = _os_.unmarshal_int();
/* 158 */     this.icon = _os_.unmarshal_int();
/* 159 */     this.pilemax = _os_.unmarshal_int();
/* 160 */     this.sellSilver = _os_.unmarshal_int();
/* 161 */     this.isProprietary = _os_.unmarshal_boolean();
/* 162 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/* 163 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/* 164 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/* 165 */     this.useLevel = _os_.unmarshal_int();
/* 166 */     this.sort = _os_.unmarshal_int();
/* 167 */     this.jewelLevel = _os_.unmarshal_int();
/* 168 */     this.jewelType = _os_.unmarshal_int();
/* 169 */     this.typeId = _os_.unmarshal_int();
/* 170 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 173 */       int _v_ = _os_.unmarshal_int();
/* 174 */       this.properTypes.add(Integer.valueOf(_v_));
/*     */     }
/* 176 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 179 */       int _v_ = _os_.unmarshal_int();
/* 180 */       this.propertyValues.add(Integer.valueOf(_v_));
/*     */     }
/* 182 */     this.nextLevelId = _os_.unmarshal_int();
/* 183 */     this.craftNextLevelCount = _os_.unmarshal_int();
/* 184 */     this.craftNextLevelMoneyType = _os_.unmarshal_int();
/* 185 */     this.craftNextLevelMoneyCount = _os_.unmarshal_int();
/* 186 */     this.craftNextLevelItemId = _os_.unmarshal_int();
/* 187 */     this.craftNextLevelItemCount = _os_.unmarshal_int();
/* 188 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 193 */     String path = dir + "mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 197 */       all = new java.util.HashMap();
/* 198 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 199 */       org.dom4j.Document doc = reader.read(new File(path));
/* 200 */       Element root = doc.getRootElement();
/* 201 */       List<?> nodeList = root.elements();
/* 202 */       int len = nodeList.size();
/* 203 */       for (int i = 0; i < len; i++)
/*     */       {
/* 205 */         Element elem = (Element)nodeList.get(i);
/* 206 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem"))
/*     */         {
/*     */ 
/* 209 */           SSuperEquipmentJewelItem obj = new SSuperEquipmentJewelItem();
/* 210 */           obj.loadFromXml(elem);
/* 211 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 212 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 217 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSuperEquipmentJewelItem> all)
/*     */   {
/* 223 */     String path = dir + "mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 227 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 228 */       org.dom4j.Document doc = reader.read(new File(path));
/* 229 */       Element root = doc.getRootElement();
/* 230 */       List<?> nodeList = root.elements();
/* 231 */       int len = nodeList.size();
/* 232 */       for (int i = 0; i < len; i++)
/*     */       {
/* 234 */         Element elem = (Element)nodeList.get(i);
/* 235 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem"))
/*     */         {
/*     */ 
/* 238 */           SSuperEquipmentJewelItem obj = new SSuperEquipmentJewelItem();
/* 239 */           obj.loadFromXml(elem);
/* 240 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 241 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 252 */     all = new java.util.HashMap();
/*     */     
/* 254 */     String path = dir + "mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem.bny";
/*     */     try
/*     */     {
/* 257 */       File file = new File(path);
/* 258 */       if (file.exists())
/*     */       {
/* 260 */         byte[] bytes = new byte['Ѐ'];
/* 261 */         FileInputStream fis = new FileInputStream(file);
/* 262 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 263 */         int len = 0;
/* 264 */         while ((len = fis.read(bytes)) > 0)
/* 265 */           baos.write(bytes, 0, len);
/* 266 */         fis.close();
/* 267 */         bytes = baos.toByteArray();
/* 268 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 269 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 271 */           _os_.unmarshal_int();
/* 272 */           _os_.unmarshal_int();
/* 273 */           _os_.unmarshal_int();
/*     */         }
/* 275 */         _os_.unmarshal_int();
/* 276 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 279 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 281 */           SSuperEquipmentJewelItem _v_ = new SSuperEquipmentJewelItem();
/* 282 */           _v_.unmarshal(_os_);
/* 283 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 284 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 289 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 294 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSuperEquipmentJewelItem> all)
/*     */   {
/* 301 */     String path = dir + "mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem.bny";
/*     */     try
/*     */     {
/* 304 */       File file = new File(path);
/* 305 */       if (file.exists())
/*     */       {
/* 307 */         byte[] bytes = new byte['Ѐ'];
/* 308 */         FileInputStream fis = new FileInputStream(file);
/* 309 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 310 */         int len = 0;
/* 311 */         while ((len = fis.read(bytes)) > 0)
/* 312 */           baos.write(bytes, 0, len);
/* 313 */         fis.close();
/* 314 */         bytes = baos.toByteArray();
/* 315 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 316 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 318 */           _os_.unmarshal_int();
/* 319 */           _os_.unmarshal_int();
/* 320 */           _os_.unmarshal_int();
/*     */         }
/* 322 */         _os_.unmarshal_int();
/* 323 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 326 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 328 */           SSuperEquipmentJewelItem _v_ = new SSuperEquipmentJewelItem();
/* 329 */           _v_.unmarshal(_os_);
/* 330 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 331 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 336 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 341 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 347 */     for (Map.Entry<Integer, SSuperEquipmentJewelItem> entry : all.entrySet())
/*     */     {
/* 349 */       if (mzm.gsp.item.confbean.SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 351 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 355 */       mzm.gsp.item.confbean.SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SSuperEquipmentJewelItem> all, Map<Integer, mzm.gsp.item.confbean.SItemCfg> parent)
/*     */   {
/* 362 */     for (Map.Entry<Integer, SSuperEquipmentJewelItem> entry : all.entrySet())
/*     */     {
/* 364 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 366 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 370 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SSuperEquipmentJewelItem getOld(int key)
/*     */   {
/* 377 */     return (SSuperEquipmentJewelItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSuperEquipmentJewelItem get(int key)
/*     */   {
/* 382 */     return (SSuperEquipmentJewelItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSuperEquipmentJewelItem> getOldAllSelf()
/*     */   {
/* 387 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSuperEquipmentJewelItem> getAllSelf()
/*     */   {
/* 392 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSuperEquipmentJewelItem> newAll)
/*     */   {
/* 397 */     oldAll = all;
/* 398 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 403 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\confbean\SSuperEquipmentJewelItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */