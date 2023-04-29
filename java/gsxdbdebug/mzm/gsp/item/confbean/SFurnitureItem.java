/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class SFurnitureItem extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SFurnitureItem> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SFurnitureItem> all = null;
/*     */   
/*     */   public int level;
/*     */   public int addFengShuiValue;
/*     */   public int styleId;
/*     */   public int furnitureType;
/*     */   public int sameFurnitureCfgId;
/*     */   public int pos;
/*     */   public int area;
/*     */   public int addBeautifulValue;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  32 */     this.name = rootElement.attributeValue("name");
/*  33 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  34 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  35 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  36 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  37 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  38 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  39 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  40 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  41 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  42 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  43 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  44 */     this.addFengShuiValue = Integer.valueOf(rootElement.attributeValue("addFengShuiValue")).intValue();
/*  45 */     this.styleId = Integer.valueOf(rootElement.attributeValue("styleId")).intValue();
/*  46 */     this.furnitureType = Integer.valueOf(rootElement.attributeValue("furnitureType")).intValue();
/*  47 */     this.sameFurnitureCfgId = Integer.valueOf(rootElement.attributeValue("sameFurnitureCfgId")).intValue();
/*  48 */     this.pos = Integer.valueOf(rootElement.attributeValue("pos")).intValue();
/*  49 */     this.area = Integer.valueOf(rootElement.attributeValue("area")).intValue();
/*  50 */     this.addBeautifulValue = Integer.valueOf(rootElement.attributeValue("addBeautifulValue")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.type);
/*  57 */     _os_.marshal(this.name, "UTF-8");
/*  58 */     _os_.marshal(this.namecolor);
/*  59 */     _os_.marshal(this.icon);
/*  60 */     _os_.marshal(this.pilemax);
/*  61 */     _os_.marshal(this.sellSilver);
/*  62 */     _os_.marshal(this.isProprietary);
/*  63 */     _os_.marshal(this.canSellAndThrow);
/*  64 */     _os_.marshal(this.awardRoleLevelMin);
/*  65 */     _os_.marshal(this.awardRoleLevelMax);
/*  66 */     _os_.marshal(this.useLevel);
/*  67 */     _os_.marshal(this.sort);
/*  68 */     _os_.marshal(this.level);
/*  69 */     _os_.marshal(this.addFengShuiValue);
/*  70 */     _os_.marshal(this.styleId);
/*  71 */     _os_.marshal(this.furnitureType);
/*  72 */     _os_.marshal(this.sameFurnitureCfgId);
/*  73 */     _os_.marshal(this.pos);
/*  74 */     _os_.marshal(this.area);
/*  75 */     _os_.marshal(this.addBeautifulValue);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     this.id = _os_.unmarshal_int();
/*  82 */     this.type = _os_.unmarshal_int();
/*  83 */     this.name = _os_.unmarshal_String("UTF-8");
/*  84 */     this.namecolor = _os_.unmarshal_int();
/*  85 */     this.icon = _os_.unmarshal_int();
/*  86 */     this.pilemax = _os_.unmarshal_int();
/*  87 */     this.sellSilver = _os_.unmarshal_int();
/*  88 */     this.isProprietary = _os_.unmarshal_boolean();
/*  89 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  90 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  91 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  92 */     this.useLevel = _os_.unmarshal_int();
/*  93 */     this.sort = _os_.unmarshal_int();
/*  94 */     this.level = _os_.unmarshal_int();
/*  95 */     this.addFengShuiValue = _os_.unmarshal_int();
/*  96 */     this.styleId = _os_.unmarshal_int();
/*  97 */     this.furnitureType = _os_.unmarshal_int();
/*  98 */     this.sameFurnitureCfgId = _os_.unmarshal_int();
/*  99 */     this.pos = _os_.unmarshal_int();
/* 100 */     this.area = _os_.unmarshal_int();
/* 101 */     this.addBeautifulValue = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 107 */     String path = dir + "mzm.gsp.item.confbean.SFurnitureItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 111 */       all = new java.util.HashMap();
/* 112 */       SAXReader reader = new SAXReader();
/* 113 */       org.dom4j.Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       List<?> nodeList = root.elements();
/* 116 */       int len = nodeList.size();
/* 117 */       for (int i = 0; i < len; i++)
/*     */       {
/* 119 */         Element elem = (Element)nodeList.get(i);
/* 120 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SFurnitureItem"))
/*     */         {
/*     */ 
/* 123 */           SFurnitureItem obj = new SFurnitureItem();
/* 124 */           obj.loadFromXml(elem);
/* 125 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 126 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 131 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFurnitureItem> all)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.item.confbean.SFurnitureItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 141 */       SAXReader reader = new SAXReader();
/* 142 */       org.dom4j.Document doc = reader.read(new File(path));
/* 143 */       Element root = doc.getRootElement();
/* 144 */       List<?> nodeList = root.elements();
/* 145 */       int len = nodeList.size();
/* 146 */       for (int i = 0; i < len; i++)
/*     */       {
/* 148 */         Element elem = (Element)nodeList.get(i);
/* 149 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SFurnitureItem"))
/*     */         {
/*     */ 
/* 152 */           SFurnitureItem obj = new SFurnitureItem();
/* 153 */           obj.loadFromXml(elem);
/* 154 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 155 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 166 */     all = new java.util.HashMap();
/*     */     
/* 168 */     String path = dir + "mzm.gsp.item.confbean.SFurnitureItem.bny";
/*     */     try
/*     */     {
/* 171 */       File file = new File(path);
/* 172 */       if (file.exists())
/*     */       {
/* 174 */         byte[] bytes = new byte['Ѐ'];
/* 175 */         FileInputStream fis = new FileInputStream(file);
/* 176 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 177 */         int len = 0;
/* 178 */         while ((len = fis.read(bytes)) > 0)
/* 179 */           baos.write(bytes, 0, len);
/* 180 */         fis.close();
/* 181 */         bytes = baos.toByteArray();
/* 182 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/* 187 */           _os_.unmarshal_int();
/*     */         }
/* 189 */         _os_.unmarshal_int();
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 193 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 195 */           SFurnitureItem _v_ = new SFurnitureItem();
/* 196 */           _v_.unmarshal(_os_);
/* 197 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 198 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 203 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFurnitureItem> all)
/*     */   {
/* 215 */     String path = dir + "mzm.gsp.item.confbean.SFurnitureItem.bny";
/*     */     try
/*     */     {
/* 218 */       File file = new File(path);
/* 219 */       if (file.exists())
/*     */       {
/* 221 */         byte[] bytes = new byte['Ѐ'];
/* 222 */         FileInputStream fis = new FileInputStream(file);
/* 223 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 224 */         int len = 0;
/* 225 */         while ((len = fis.read(bytes)) > 0)
/* 226 */           baos.write(bytes, 0, len);
/* 227 */         fis.close();
/* 228 */         bytes = baos.toByteArray();
/* 229 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 232 */           _os_.unmarshal_int();
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/*     */         }
/* 236 */         _os_.unmarshal_int();
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 240 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 242 */           SFurnitureItem _v_ = new SFurnitureItem();
/* 243 */           _v_.unmarshal(_os_);
/* 244 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 245 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 250 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 255 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 261 */     for (Map.Entry<Integer, SFurnitureItem> entry : all.entrySet())
/*     */     {
/* 263 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 265 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 269 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SFurnitureItem> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 276 */     for (Map.Entry<Integer, SFurnitureItem> entry : all.entrySet())
/*     */     {
/* 278 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 280 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 284 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SFurnitureItem getOld(int key)
/*     */   {
/* 291 */     return (SFurnitureItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFurnitureItem get(int key)
/*     */   {
/* 296 */     return (SFurnitureItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFurnitureItem> getOldAllSelf()
/*     */   {
/* 301 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFurnitureItem> getAllSelf()
/*     */   {
/* 306 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFurnitureItem> newAll)
/*     */   {
/* 311 */     oldAll = all;
/* 312 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 317 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SFurnitureItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */