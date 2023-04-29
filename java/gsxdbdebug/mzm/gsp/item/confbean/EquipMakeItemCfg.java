/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class EquipMakeItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, EquipMakeItemCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, EquipMakeItemCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int goldNum;
/*     */   public int silverNum;
/*     */   public int vigorNum;
/*  22 */   public ArrayList<NeedItemId2Num> needItemList = new ArrayList();
/*  23 */   public ArrayList<DesItemId2Rate> desItemList = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.goldNum = Integer.valueOf(rootElement.attributeValue("goldNum")).intValue();
/*  29 */     this.silverNum = Integer.valueOf(rootElement.attributeValue("silverNum")).intValue();
/*  30 */     this.vigorNum = Integer.valueOf(rootElement.attributeValue("vigorNum")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "needItemList");
/*  33 */     if (collectionElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> _nodeList = collectionElement.elements();
/*  39 */     int _len = _nodeList.size();
/*  40 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  42 */       Element elem = (Element)_nodeList.get(i);
/*  43 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.NeedItemId2Num"))
/*     */       {
/*     */         NeedItemId2Num _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = new NeedItemId2Num();
/*  51 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.needItemList.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  62 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "desItemList");
/*  63 */     if (collectionElement == null)
/*     */     {
/*  65 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  68 */     List<?> _nodeList = collectionElement.elements();
/*  69 */     int _len = _nodeList.size();
/*  70 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  72 */       Element elem = (Element)_nodeList.get(i);
/*  73 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.DesItemId2Rate"))
/*     */       {
/*     */         DesItemId2Rate _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  80 */           _v_ = new DesItemId2Rate();
/*  81 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  88 */         this.desItemList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  95 */     _os_.marshal(this.id);
/*  96 */     _os_.marshal(this.goldNum);
/*  97 */     _os_.marshal(this.silverNum);
/*  98 */     _os_.marshal(this.vigorNum);
/*  99 */     _os_.compact_uint32(this.needItemList.size());
/* 100 */     for (NeedItemId2Num _v_ : this.needItemList)
/*     */     {
/* 102 */       _os_.marshal(_v_);
/*     */     }
/* 104 */     _os_.compact_uint32(this.desItemList.size());
/* 105 */     for (DesItemId2Rate _v_ : this.desItemList)
/*     */     {
/* 107 */       _os_.marshal(_v_);
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 114 */     this.id = _os_.unmarshal_int();
/* 115 */     this.goldNum = _os_.unmarshal_int();
/* 116 */     this.silverNum = _os_.unmarshal_int();
/* 117 */     this.vigorNum = _os_.unmarshal_int();
/* 118 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 121 */       NeedItemId2Num _v_ = new NeedItemId2Num();
/* 122 */       _v_.unmarshal(_os_);
/* 123 */       this.needItemList.add(_v_);
/*     */     }
/* 125 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 128 */       DesItemId2Rate _v_ = new DesItemId2Rate();
/* 129 */       _v_.unmarshal(_os_);
/* 130 */       this.desItemList.add(_v_);
/*     */     }
/* 132 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.item.confbean.EquipMakeItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 141 */       all = new java.util.HashMap();
/* 142 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 143 */       org.dom4j.Document doc = reader.read(new File(path));
/* 144 */       Element root = doc.getRootElement();
/* 145 */       List<?> nodeList = root.elements();
/* 146 */       int len = nodeList.size();
/* 147 */       for (int i = 0; i < len; i++)
/*     */       {
/* 149 */         Element elem = (Element)nodeList.get(i);
/* 150 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.EquipMakeItemCfg"))
/*     */         {
/*     */ 
/* 153 */           EquipMakeItemCfg obj = new EquipMakeItemCfg();
/* 154 */           obj.loadFromXml(elem);
/* 155 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 156 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 161 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, EquipMakeItemCfg> all)
/*     */   {
/* 167 */     String path = dir + "mzm.gsp.item.confbean.EquipMakeItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 171 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 172 */       org.dom4j.Document doc = reader.read(new File(path));
/* 173 */       Element root = doc.getRootElement();
/* 174 */       List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element elem = (Element)nodeList.get(i);
/* 179 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.EquipMakeItemCfg"))
/*     */         {
/*     */ 
/* 182 */           EquipMakeItemCfg obj = new EquipMakeItemCfg();
/* 183 */           obj.loadFromXml(elem);
/* 184 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 190 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 196 */     all = new java.util.HashMap();
/*     */     
/* 198 */     String path = dir + "mzm.gsp.item.confbean.EquipMakeItemCfg.bny";
/*     */     try
/*     */     {
/* 201 */       File file = new File(path);
/* 202 */       if (file.exists())
/*     */       {
/* 204 */         byte[] bytes = new byte['Ѐ'];
/* 205 */         FileInputStream fis = new FileInputStream(file);
/* 206 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 207 */         int len = 0;
/* 208 */         while ((len = fis.read(bytes)) > 0)
/* 209 */           baos.write(bytes, 0, len);
/* 210 */         fis.close();
/* 211 */         bytes = baos.toByteArray();
/* 212 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 215 */           _os_.unmarshal_int();
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/*     */         }
/* 219 */         _os_.unmarshal_int();
/* 220 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 223 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 225 */           EquipMakeItemCfg _v_ = new EquipMakeItemCfg();
/* 226 */           _v_.unmarshal(_os_);
/* 227 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 228 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 233 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 238 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, EquipMakeItemCfg> all)
/*     */   {
/* 245 */     String path = dir + "mzm.gsp.item.confbean.EquipMakeItemCfg.bny";
/*     */     try
/*     */     {
/* 248 */       File file = new File(path);
/* 249 */       if (file.exists())
/*     */       {
/* 251 */         byte[] bytes = new byte['Ѐ'];
/* 252 */         FileInputStream fis = new FileInputStream(file);
/* 253 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 254 */         int len = 0;
/* 255 */         while ((len = fis.read(bytes)) > 0)
/* 256 */           baos.write(bytes, 0, len);
/* 257 */         fis.close();
/* 258 */         bytes = baos.toByteArray();
/* 259 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 260 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 262 */           _os_.unmarshal_int();
/* 263 */           _os_.unmarshal_int();
/* 264 */           _os_.unmarshal_int();
/*     */         }
/* 266 */         _os_.unmarshal_int();
/* 267 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 270 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 272 */           EquipMakeItemCfg _v_ = new EquipMakeItemCfg();
/* 273 */           _v_.unmarshal(_os_);
/* 274 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 275 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 280 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 285 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static EquipMakeItemCfg getOld(int key)
/*     */   {
/* 293 */     return (EquipMakeItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static EquipMakeItemCfg get(int key)
/*     */   {
/* 298 */     return (EquipMakeItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, EquipMakeItemCfg> getOldAll()
/*     */   {
/* 303 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, EquipMakeItemCfg> getAll()
/*     */   {
/* 308 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, EquipMakeItemCfg> newAll)
/*     */   {
/* 313 */     oldAll = all;
/* 314 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 319 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\EquipMakeItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */