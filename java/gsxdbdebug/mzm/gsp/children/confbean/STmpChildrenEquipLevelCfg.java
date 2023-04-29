/*     */ package mzm.gsp.children.confbean;
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
/*     */ public class STmpChildrenEquipLevelCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STmpChildrenEquipLevelCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STmpChildrenEquipLevelCfg> all = null;
/*     */   
/*     */   public int templateId;
/*     */   public int levelTypeid;
/*     */   public int level;
/*     */   public int needStage;
/*     */   public int levelUpExp;
/*  23 */   public HashMap<Integer, Integer> proMap = new HashMap();
/*  24 */   public java.util.ArrayList<Integer> itemids = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.templateId = Integer.valueOf(rootElement.attributeValue("templateId")).intValue();
/*  29 */     this.levelTypeid = Integer.valueOf(rootElement.attributeValue("levelTypeid")).intValue();
/*  30 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  31 */     this.needStage = Integer.valueOf(rootElement.attributeValue("needStage")).intValue();
/*  32 */     this.levelUpExp = Integer.valueOf(rootElement.attributeValue("levelUpExp")).intValue();
/*     */     
/*  34 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "proMap");
/*  35 */     if (mapTypeElement == null)
/*     */     {
/*  37 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  40 */     List<?> entryNodeList = mapTypeElement.elements();
/*  41 */     int entryLen = entryNodeList.size();
/*  42 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  44 */       Element entryElement = (Element)entryNodeList.get(i);
/*  45 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  50 */         Element keyElem = null;
/*  51 */         Element valueElem = null;
/*     */         
/*  53 */         List<?> _nodeList = entryElement.elements();
/*  54 */         int _len = _nodeList.size();
/*  55 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  57 */           Element elem = (Element)_nodeList.get(j);
/*  58 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  60 */             keyElem = elem;
/*     */           }
/*  62 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  64 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  68 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  70 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  77 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  78 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  85 */         this.proMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  89 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemids");
/*  90 */     if (collectionElement == null)
/*     */     {
/*  92 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  95 */     List<?> _nodeList = collectionElement.elements();
/*  96 */     int _len = _nodeList.size();
/*  97 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  99 */       Element elem = (Element)_nodeList.get(i);
/* 100 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 107 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 114 */         this.itemids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 121 */     _os_.marshal(this.templateId);
/* 122 */     _os_.marshal(this.levelTypeid);
/* 123 */     _os_.marshal(this.level);
/* 124 */     _os_.marshal(this.needStage);
/* 125 */     _os_.marshal(this.levelUpExp);
/* 126 */     _os_.compact_uint32(this.proMap.size());
/* 127 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.proMap.entrySet())
/*     */     {
/* 129 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 130 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 132 */     _os_.compact_uint32(this.itemids.size());
/* 133 */     for (Integer _v_ : this.itemids)
/*     */     {
/* 135 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 137 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 142 */     this.templateId = _os_.unmarshal_int();
/* 143 */     this.levelTypeid = _os_.unmarshal_int();
/* 144 */     this.level = _os_.unmarshal_int();
/* 145 */     this.needStage = _os_.unmarshal_int();
/* 146 */     this.levelUpExp = _os_.unmarshal_int();
/* 147 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 150 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 152 */       int _v_ = _os_.unmarshal_int();
/* 153 */       this.proMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 155 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 158 */       int _v_ = _os_.unmarshal_int();
/* 159 */       this.itemids.add(Integer.valueOf(_v_));
/*     */     }
/* 161 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 166 */     String path = dir + "mzm.gsp.children.confbean.STmpChildrenEquipLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 170 */       all = new HashMap();
/* 171 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 172 */       org.dom4j.Document doc = reader.read(new File(path));
/* 173 */       Element root = doc.getRootElement();
/* 174 */       List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element elem = (Element)nodeList.get(i);
/* 179 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.STmpChildrenEquipLevelCfg"))
/*     */         {
/*     */ 
/* 182 */           STmpChildrenEquipLevelCfg obj = new STmpChildrenEquipLevelCfg();
/* 183 */           obj.loadFromXml(elem);
/* 184 */           if (all.put(Integer.valueOf(obj.templateId), obj) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + obj.templateId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 190 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STmpChildrenEquipLevelCfg> all)
/*     */   {
/* 196 */     String path = dir + "mzm.gsp.children.confbean.STmpChildrenEquipLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 200 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 201 */       org.dom4j.Document doc = reader.read(new File(path));
/* 202 */       Element root = doc.getRootElement();
/* 203 */       List<?> nodeList = root.elements();
/* 204 */       int len = nodeList.size();
/* 205 */       for (int i = 0; i < len; i++)
/*     */       {
/* 207 */         Element elem = (Element)nodeList.get(i);
/* 208 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.STmpChildrenEquipLevelCfg"))
/*     */         {
/*     */ 
/* 211 */           STmpChildrenEquipLevelCfg obj = new STmpChildrenEquipLevelCfg();
/* 212 */           obj.loadFromXml(elem);
/* 213 */           if (all.put(Integer.valueOf(obj.templateId), obj) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + obj.templateId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 225 */     all = new HashMap();
/*     */     
/* 227 */     String path = dir + "mzm.gsp.children.confbean.STmpChildrenEquipLevelCfg.bny";
/*     */     try
/*     */     {
/* 230 */       File file = new File(path);
/* 231 */       if (file.exists())
/*     */       {
/* 233 */         byte[] bytes = new byte['Ѐ'];
/* 234 */         FileInputStream fis = new FileInputStream(file);
/* 235 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 236 */         int len = 0;
/* 237 */         while ((len = fis.read(bytes)) > 0)
/* 238 */           baos.write(bytes, 0, len);
/* 239 */         fis.close();
/* 240 */         bytes = baos.toByteArray();
/* 241 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/* 246 */           _os_.unmarshal_int();
/*     */         }
/* 248 */         _os_.unmarshal_int();
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 252 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 254 */           STmpChildrenEquipLevelCfg _v_ = new STmpChildrenEquipLevelCfg();
/* 255 */           _v_.unmarshal(_os_);
/* 256 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 257 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 262 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STmpChildrenEquipLevelCfg> all)
/*     */   {
/* 274 */     String path = dir + "mzm.gsp.children.confbean.STmpChildrenEquipLevelCfg.bny";
/*     */     try
/*     */     {
/* 277 */       File file = new File(path);
/* 278 */       if (file.exists())
/*     */       {
/* 280 */         byte[] bytes = new byte['Ѐ'];
/* 281 */         FileInputStream fis = new FileInputStream(file);
/* 282 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 283 */         int len = 0;
/* 284 */         while ((len = fis.read(bytes)) > 0)
/* 285 */           baos.write(bytes, 0, len);
/* 286 */         fis.close();
/* 287 */         bytes = baos.toByteArray();
/* 288 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 289 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 291 */           _os_.unmarshal_int();
/* 292 */           _os_.unmarshal_int();
/* 293 */           _os_.unmarshal_int();
/*     */         }
/* 295 */         _os_.unmarshal_int();
/* 296 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 299 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 301 */           STmpChildrenEquipLevelCfg _v_ = new STmpChildrenEquipLevelCfg();
/* 302 */           _v_.unmarshal(_os_);
/* 303 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 304 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 309 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 314 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STmpChildrenEquipLevelCfg getOld(int key)
/*     */   {
/* 322 */     return (STmpChildrenEquipLevelCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STmpChildrenEquipLevelCfg get(int key)
/*     */   {
/* 327 */     return (STmpChildrenEquipLevelCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STmpChildrenEquipLevelCfg> getOldAll()
/*     */   {
/* 332 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STmpChildrenEquipLevelCfg> getAll()
/*     */   {
/* 337 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STmpChildrenEquipLevelCfg> newAll)
/*     */   {
/* 342 */     oldAll = all;
/* 343 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 348 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\STmpChildrenEquipLevelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */