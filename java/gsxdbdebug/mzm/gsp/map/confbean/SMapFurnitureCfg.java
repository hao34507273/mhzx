/*     */ package mzm.gsp.map.confbean;
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
/*     */ public class SMapFurnitureCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMapFurnitureCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMapFurnitureCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int cellWidth;
/*     */   public int cellHeight;
/*  21 */   public HashMap<Integer, DirectionInfo> directions = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.cellWidth = Integer.valueOf(rootElement.attributeValue("cellWidth")).intValue();
/*  27 */     this.cellHeight = Integer.valueOf(rootElement.attributeValue("cellHeight")).intValue();
/*     */     
/*  29 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "directions");
/*  30 */     if (mapTypeElement == null)
/*     */     {
/*  32 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  35 */     List<?> entryNodeList = mapTypeElement.elements();
/*  36 */     int entryLen = entryNodeList.size();
/*  37 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  39 */       Element entryElement = (Element)entryNodeList.get(i);
/*  40 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  45 */         Element keyElem = null;
/*  46 */         Element valueElem = null;
/*     */         
/*  48 */         List<?> _nodeList = entryElement.elements();
/*  49 */         int _len = _nodeList.size();
/*  50 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  52 */           Element elem = (Element)_nodeList.get(j);
/*  53 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  55 */             keyElem = elem;
/*     */           }
/*  57 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.DirectionInfo")))
/*     */           {
/*  59 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  63 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  65 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         DirectionInfo _v_;
/*     */         try
/*     */         {
/*  72 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  73 */           _v_ = new DirectionInfo();
/*  74 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  81 */         this.directions.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  88 */     _os_.marshal(this.id);
/*  89 */     _os_.marshal(this.cellWidth);
/*  90 */     _os_.marshal(this.cellHeight);
/*  91 */     _os_.compact_uint32(this.directions.size());
/*  92 */     for (java.util.Map.Entry<Integer, DirectionInfo> _e_ : this.directions.entrySet())
/*     */     {
/*  94 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  95 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 102 */     this.id = _os_.unmarshal_int();
/* 103 */     this.cellWidth = _os_.unmarshal_int();
/* 104 */     this.cellHeight = _os_.unmarshal_int();
/* 105 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 108 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 110 */       DirectionInfo _v_ = new DirectionInfo();
/* 111 */       _v_.unmarshal(_os_);
/* 112 */       this.directions.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 119 */     String path = dir + "mzm.gsp.map.confbean.SMapFurnitureCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 123 */       all = new HashMap();
/* 124 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 125 */       org.dom4j.Document doc = reader.read(new File(path));
/* 126 */       Element root = doc.getRootElement();
/* 127 */       List<?> nodeList = root.elements();
/* 128 */       int len = nodeList.size();
/* 129 */       for (int i = 0; i < len; i++)
/*     */       {
/* 131 */         Element elem = (Element)nodeList.get(i);
/* 132 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapFurnitureCfg"))
/*     */         {
/*     */ 
/* 135 */           SMapFurnitureCfg obj = new SMapFurnitureCfg();
/* 136 */           obj.loadFromXml(elem);
/* 137 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 138 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 143 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMapFurnitureCfg> all)
/*     */   {
/* 149 */     String path = dir + "mzm.gsp.map.confbean.SMapFurnitureCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 153 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 154 */       org.dom4j.Document doc = reader.read(new File(path));
/* 155 */       Element root = doc.getRootElement();
/* 156 */       List<?> nodeList = root.elements();
/* 157 */       int len = nodeList.size();
/* 158 */       for (int i = 0; i < len; i++)
/*     */       {
/* 160 */         Element elem = (Element)nodeList.get(i);
/* 161 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapFurnitureCfg"))
/*     */         {
/*     */ 
/* 164 */           SMapFurnitureCfg obj = new SMapFurnitureCfg();
/* 165 */           obj.loadFromXml(elem);
/* 166 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 167 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 178 */     all = new HashMap();
/*     */     
/* 180 */     String path = dir + "mzm.gsp.map.confbean.SMapFurnitureCfg.bny";
/*     */     try
/*     */     {
/* 183 */       File file = new File(path);
/* 184 */       if (file.exists())
/*     */       {
/* 186 */         byte[] bytes = new byte['Ѐ'];
/* 187 */         FileInputStream fis = new FileInputStream(file);
/* 188 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 189 */         int len = 0;
/* 190 */         while ((len = fis.read(bytes)) > 0)
/* 191 */           baos.write(bytes, 0, len);
/* 192 */         fis.close();
/* 193 */         bytes = baos.toByteArray();
/* 194 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 195 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/* 199 */           _os_.unmarshal_int();
/*     */         }
/* 201 */         _os_.unmarshal_int();
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 205 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 207 */           SMapFurnitureCfg _v_ = new SMapFurnitureCfg();
/* 208 */           _v_.unmarshal(_os_);
/* 209 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 215 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 220 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMapFurnitureCfg> all)
/*     */   {
/* 227 */     String path = dir + "mzm.gsp.map.confbean.SMapFurnitureCfg.bny";
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
/* 254 */           SMapFurnitureCfg _v_ = new SMapFurnitureCfg();
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
/*     */ 
/*     */   public static SMapFurnitureCfg getOld(int key)
/*     */   {
/* 275 */     return (SMapFurnitureCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMapFurnitureCfg get(int key)
/*     */   {
/* 280 */     return (SMapFurnitureCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapFurnitureCfg> getOldAll()
/*     */   {
/* 285 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapFurnitureCfg> getAll()
/*     */   {
/* 290 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMapFurnitureCfg> newAll)
/*     */   {
/* 295 */     oldAll = all;
/* 296 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 301 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapFurnitureCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */