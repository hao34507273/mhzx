/*     */ package mzm.gsp.item.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SLongJingItem extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SLongJingItem> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SLongJingItem> all = null;
/*     */   
/*  19 */   public HashMap<Integer, Integer> attrMap = new HashMap();
/*     */   public int lv;
/*     */   public int nextId;
/*     */   public int complexNextCount;
/*     */   public int longjingtype;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  29 */     this.name = rootElement.attributeValue("name");
/*  30 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  31 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  32 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  33 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  34 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  35 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  36 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  37 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  38 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  39 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*     */     
/*  41 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "attrMap");
/*  42 */     if (mapTypeElement == null)
/*     */     {
/*  44 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  47 */     List<?> entryNodeList = mapTypeElement.elements();
/*  48 */     int entryLen = entryNodeList.size();
/*  49 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  51 */       Element entryElement = (Element)entryNodeList.get(i);
/*  52 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  57 */         Element keyElem = null;
/*  58 */         Element valueElem = null;
/*     */         
/*  60 */         List<?> _nodeList = entryElement.elements();
/*  61 */         int _len = _nodeList.size();
/*  62 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  64 */           Element elem = (Element)_nodeList.get(j);
/*  65 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  67 */             keyElem = elem;
/*     */           }
/*  69 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  71 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  75 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  77 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  84 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  85 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  92 */         this.attrMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  95 */     this.lv = Integer.valueOf(rootElement.attributeValue("lv")).intValue();
/*  96 */     this.nextId = Integer.valueOf(rootElement.attributeValue("nextId")).intValue();
/*  97 */     this.complexNextCount = Integer.valueOf(rootElement.attributeValue("complexNextCount")).intValue();
/*  98 */     this.longjingtype = Integer.valueOf(rootElement.attributeValue("longjingtype")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 103 */     _os_.marshal(this.id);
/* 104 */     _os_.marshal(this.type);
/* 105 */     _os_.marshal(this.name, "UTF-8");
/* 106 */     _os_.marshal(this.namecolor);
/* 107 */     _os_.marshal(this.icon);
/* 108 */     _os_.marshal(this.pilemax);
/* 109 */     _os_.marshal(this.sellSilver);
/* 110 */     _os_.marshal(this.isProprietary);
/* 111 */     _os_.marshal(this.canSellAndThrow);
/* 112 */     _os_.marshal(this.awardRoleLevelMin);
/* 113 */     _os_.marshal(this.awardRoleLevelMax);
/* 114 */     _os_.marshal(this.useLevel);
/* 115 */     _os_.marshal(this.sort);
/* 116 */     _os_.compact_uint32(this.attrMap.size());
/* 117 */     for (Map.Entry<Integer, Integer> _e_ : this.attrMap.entrySet())
/*     */     {
/* 119 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 120 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 122 */     _os_.marshal(this.lv);
/* 123 */     _os_.marshal(this.nextId);
/* 124 */     _os_.marshal(this.complexNextCount);
/* 125 */     _os_.marshal(this.longjingtype);
/* 126 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 131 */     this.id = _os_.unmarshal_int();
/* 132 */     this.type = _os_.unmarshal_int();
/* 133 */     this.name = _os_.unmarshal_String("UTF-8");
/* 134 */     this.namecolor = _os_.unmarshal_int();
/* 135 */     this.icon = _os_.unmarshal_int();
/* 136 */     this.pilemax = _os_.unmarshal_int();
/* 137 */     this.sellSilver = _os_.unmarshal_int();
/* 138 */     this.isProprietary = _os_.unmarshal_boolean();
/* 139 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/* 140 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/* 141 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/* 142 */     this.useLevel = _os_.unmarshal_int();
/* 143 */     this.sort = _os_.unmarshal_int();
/* 144 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 147 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 149 */       int _v_ = _os_.unmarshal_int();
/* 150 */       this.attrMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 152 */     this.lv = _os_.unmarshal_int();
/* 153 */     this.nextId = _os_.unmarshal_int();
/* 154 */     this.complexNextCount = _os_.unmarshal_int();
/* 155 */     this.longjingtype = _os_.unmarshal_int();
/* 156 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 161 */     String path = dir + "mzm.gsp.item.confbean.SLongJingItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 165 */       all = new HashMap();
/* 166 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 167 */       org.dom4j.Document doc = reader.read(new File(path));
/* 168 */       Element root = doc.getRootElement();
/* 169 */       List<?> nodeList = root.elements();
/* 170 */       int len = nodeList.size();
/* 171 */       for (int i = 0; i < len; i++)
/*     */       {
/* 173 */         Element elem = (Element)nodeList.get(i);
/* 174 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SLongJingItem"))
/*     */         {
/*     */ 
/* 177 */           SLongJingItem obj = new SLongJingItem();
/* 178 */           obj.loadFromXml(elem);
/* 179 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 180 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 185 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLongJingItem> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.item.confbean.SLongJingItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 195 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 196 */       org.dom4j.Document doc = reader.read(new File(path));
/* 197 */       Element root = doc.getRootElement();
/* 198 */       List<?> nodeList = root.elements();
/* 199 */       int len = nodeList.size();
/* 200 */       for (int i = 0; i < len; i++)
/*     */       {
/* 202 */         Element elem = (Element)nodeList.get(i);
/* 203 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SLongJingItem"))
/*     */         {
/*     */ 
/* 206 */           SLongJingItem obj = new SLongJingItem();
/* 207 */           obj.loadFromXml(elem);
/* 208 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 214 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 220 */     all = new HashMap();
/*     */     
/* 222 */     String path = dir + "mzm.gsp.item.confbean.SLongJingItem.bny";
/*     */     try
/*     */     {
/* 225 */       File file = new File(path);
/* 226 */       if (file.exists())
/*     */       {
/* 228 */         byte[] bytes = new byte['Ѐ'];
/* 229 */         FileInputStream fis = new FileInputStream(file);
/* 230 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 231 */         int len = 0;
/* 232 */         while ((len = fis.read(bytes)) > 0)
/* 233 */           baos.write(bytes, 0, len);
/* 234 */         fis.close();
/* 235 */         bytes = baos.toByteArray();
/* 236 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 239 */           _os_.unmarshal_int();
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/*     */         }
/* 243 */         _os_.unmarshal_int();
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 247 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 249 */           SLongJingItem _v_ = new SLongJingItem();
/* 250 */           _v_.unmarshal(_os_);
/* 251 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 252 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 257 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 262 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLongJingItem> all)
/*     */   {
/* 269 */     String path = dir + "mzm.gsp.item.confbean.SLongJingItem.bny";
/*     */     try
/*     */     {
/* 272 */       File file = new File(path);
/* 273 */       if (file.exists())
/*     */       {
/* 275 */         byte[] bytes = new byte['Ѐ'];
/* 276 */         FileInputStream fis = new FileInputStream(file);
/* 277 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 278 */         int len = 0;
/* 279 */         while ((len = fis.read(bytes)) > 0)
/* 280 */           baos.write(bytes, 0, len);
/* 281 */         fis.close();
/* 282 */         bytes = baos.toByteArray();
/* 283 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 284 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 286 */           _os_.unmarshal_int();
/* 287 */           _os_.unmarshal_int();
/* 288 */           _os_.unmarshal_int();
/*     */         }
/* 290 */         _os_.unmarshal_int();
/* 291 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 294 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 296 */           SLongJingItem _v_ = new SLongJingItem();
/* 297 */           _v_.unmarshal(_os_);
/* 298 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 299 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 304 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 309 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 315 */     for (Map.Entry<Integer, SLongJingItem> entry : all.entrySet())
/*     */     {
/* 317 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 319 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 323 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SLongJingItem> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 330 */     for (Map.Entry<Integer, SLongJingItem> entry : all.entrySet())
/*     */     {
/* 332 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 334 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 338 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SLongJingItem getOld(int key)
/*     */   {
/* 345 */     return (SLongJingItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLongJingItem get(int key)
/*     */   {
/* 350 */     return (SLongJingItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLongJingItem> getOldAllSelf()
/*     */   {
/* 355 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLongJingItem> getAllSelf()
/*     */   {
/* 360 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLongJingItem> newAll)
/*     */   {
/* 365 */     oldAll = all;
/* 366 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 371 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SLongJingItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */