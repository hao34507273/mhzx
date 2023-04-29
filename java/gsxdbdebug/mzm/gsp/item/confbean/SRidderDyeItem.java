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
/*     */ public class SRidderDyeItem extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SRidderDyeItem> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SRidderDyeItem> all = null;
/*     */   
/*  19 */   public java.util.ArrayList<Dyeid2Rate> dyeids = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  24 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  25 */     this.name = rootElement.attributeValue("name");
/*  26 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  27 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  28 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  29 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  30 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  31 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  32 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  33 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  34 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  35 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*     */     
/*  37 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "dyeids");
/*  38 */     if (collectionElement == null)
/*     */     {
/*  40 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  43 */     List<?> _nodeList = collectionElement.elements();
/*  44 */     int _len = _nodeList.size();
/*  45 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  47 */       Element elem = (Element)_nodeList.get(i);
/*  48 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.Dyeid2Rate"))
/*     */       {
/*     */         Dyeid2Rate _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  55 */           _v_ = new Dyeid2Rate();
/*  56 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  63 */         this.dyeids.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _os_.marshal(this.id);
/*  71 */     _os_.marshal(this.type);
/*  72 */     _os_.marshal(this.name, "UTF-8");
/*  73 */     _os_.marshal(this.namecolor);
/*  74 */     _os_.marshal(this.icon);
/*  75 */     _os_.marshal(this.pilemax);
/*  76 */     _os_.marshal(this.sellSilver);
/*  77 */     _os_.marshal(this.isProprietary);
/*  78 */     _os_.marshal(this.canSellAndThrow);
/*  79 */     _os_.marshal(this.awardRoleLevelMin);
/*  80 */     _os_.marshal(this.awardRoleLevelMax);
/*  81 */     _os_.marshal(this.useLevel);
/*  82 */     _os_.marshal(this.sort);
/*  83 */     _os_.compact_uint32(this.dyeids.size());
/*  84 */     for (Dyeid2Rate _v_ : this.dyeids)
/*     */     {
/*  86 */       _os_.marshal(_v_);
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     this.id = _os_.unmarshal_int();
/*  94 */     this.type = _os_.unmarshal_int();
/*  95 */     this.name = _os_.unmarshal_String("UTF-8");
/*  96 */     this.namecolor = _os_.unmarshal_int();
/*  97 */     this.icon = _os_.unmarshal_int();
/*  98 */     this.pilemax = _os_.unmarshal_int();
/*  99 */     this.sellSilver = _os_.unmarshal_int();
/* 100 */     this.isProprietary = _os_.unmarshal_boolean();
/* 101 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/* 102 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/* 103 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/* 104 */     this.useLevel = _os_.unmarshal_int();
/* 105 */     this.sort = _os_.unmarshal_int();
/* 106 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 109 */       Dyeid2Rate _v_ = new Dyeid2Rate();
/* 110 */       _v_.unmarshal(_os_);
/* 111 */       this.dyeids.add(_v_);
/*     */     }
/* 113 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 118 */     String path = dir + "mzm.gsp.item.confbean.SRidderDyeItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 122 */       all = new java.util.HashMap();
/* 123 */       SAXReader reader = new SAXReader();
/* 124 */       org.dom4j.Document doc = reader.read(new File(path));
/* 125 */       Element root = doc.getRootElement();
/* 126 */       List<?> nodeList = root.elements();
/* 127 */       int len = nodeList.size();
/* 128 */       for (int i = 0; i < len; i++)
/*     */       {
/* 130 */         Element elem = (Element)nodeList.get(i);
/* 131 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SRidderDyeItem"))
/*     */         {
/*     */ 
/* 134 */           SRidderDyeItem obj = new SRidderDyeItem();
/* 135 */           obj.loadFromXml(elem);
/* 136 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 137 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 142 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SRidderDyeItem> all)
/*     */   {
/* 148 */     String path = dir + "mzm.gsp.item.confbean.SRidderDyeItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 152 */       SAXReader reader = new SAXReader();
/* 153 */       org.dom4j.Document doc = reader.read(new File(path));
/* 154 */       Element root = doc.getRootElement();
/* 155 */       List<?> nodeList = root.elements();
/* 156 */       int len = nodeList.size();
/* 157 */       for (int i = 0; i < len; i++)
/*     */       {
/* 159 */         Element elem = (Element)nodeList.get(i);
/* 160 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SRidderDyeItem"))
/*     */         {
/*     */ 
/* 163 */           SRidderDyeItem obj = new SRidderDyeItem();
/* 164 */           obj.loadFromXml(elem);
/* 165 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 166 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 177 */     all = new java.util.HashMap();
/*     */     
/* 179 */     String path = dir + "mzm.gsp.item.confbean.SRidderDyeItem.bny";
/*     */     try
/*     */     {
/* 182 */       File file = new File(path);
/* 183 */       if (file.exists())
/*     */       {
/* 185 */         byte[] bytes = new byte['Ѐ'];
/* 186 */         FileInputStream fis = new FileInputStream(file);
/* 187 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 188 */         int len = 0;
/* 189 */         while ((len = fis.read(bytes)) > 0)
/* 190 */           baos.write(bytes, 0, len);
/* 191 */         fis.close();
/* 192 */         bytes = baos.toByteArray();
/* 193 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 194 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 196 */           _os_.unmarshal_int();
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/*     */         }
/* 200 */         _os_.unmarshal_int();
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 204 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 206 */           SRidderDyeItem _v_ = new SRidderDyeItem();
/* 207 */           _v_.unmarshal(_os_);
/* 208 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 214 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SRidderDyeItem> all)
/*     */   {
/* 226 */     String path = dir + "mzm.gsp.item.confbean.SRidderDyeItem.bny";
/*     */     try
/*     */     {
/* 229 */       File file = new File(path);
/* 230 */       if (file.exists())
/*     */       {
/* 232 */         byte[] bytes = new byte['Ѐ'];
/* 233 */         FileInputStream fis = new FileInputStream(file);
/* 234 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 235 */         int len = 0;
/* 236 */         while ((len = fis.read(bytes)) > 0)
/* 237 */           baos.write(bytes, 0, len);
/* 238 */         fis.close();
/* 239 */         bytes = baos.toByteArray();
/* 240 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 241 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 243 */           _os_.unmarshal_int();
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/*     */         }
/* 247 */         _os_.unmarshal_int();
/* 248 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 251 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 253 */           SRidderDyeItem _v_ = new SRidderDyeItem();
/* 254 */           _v_.unmarshal(_os_);
/* 255 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 256 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 261 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 266 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 272 */     for (Map.Entry<Integer, SRidderDyeItem> entry : all.entrySet())
/*     */     {
/* 274 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 276 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 280 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SRidderDyeItem> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 287 */     for (Map.Entry<Integer, SRidderDyeItem> entry : all.entrySet())
/*     */     {
/* 289 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 291 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 295 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SRidderDyeItem getOld(int key)
/*     */   {
/* 302 */     return (SRidderDyeItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SRidderDyeItem get(int key)
/*     */   {
/* 307 */     return (SRidderDyeItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRidderDyeItem> getOldAllSelf()
/*     */   {
/* 312 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRidderDyeItem> getAllSelf()
/*     */   {
/* 317 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SRidderDyeItem> newAll)
/*     */   {
/* 322 */     oldAll = all;
/* 323 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 328 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SRidderDyeItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */