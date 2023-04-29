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
/*     */ public class SItemCangBaoTuCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SItemCangBaoTuCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SItemCangBaoTuCfg> all = null;
/*     */   
/*  19 */   public java.util.ArrayList<MapID2Prop> mapIdProp = new java.util.ArrayList();
/*     */   public int awardPoolId;
/*     */   public int baotutype;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  27 */     this.name = rootElement.attributeValue("name");
/*  28 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  29 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  30 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  31 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  32 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  33 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  34 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  35 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  36 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  37 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*     */     
/*  39 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "mapIdProp");
/*  40 */     if (collectionElement == null)
/*     */     {
/*  42 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  45 */     List<?> _nodeList = collectionElement.elements();
/*  46 */     int _len = _nodeList.size();
/*  47 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  49 */       Element elem = (Element)_nodeList.get(i);
/*  50 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.MapID2Prop"))
/*     */       {
/*     */         MapID2Prop _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  57 */           _v_ = new MapID2Prop();
/*  58 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  65 */         this.mapIdProp.add(_v_);
/*     */       }
/*     */     }
/*  68 */     this.awardPoolId = Integer.valueOf(rootElement.attributeValue("awardPoolId")).intValue();
/*  69 */     this.baotutype = Integer.valueOf(rootElement.attributeValue("baotutype")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _os_.marshal(this.id);
/*  75 */     _os_.marshal(this.type);
/*  76 */     _os_.marshal(this.name, "UTF-8");
/*  77 */     _os_.marshal(this.namecolor);
/*  78 */     _os_.marshal(this.icon);
/*  79 */     _os_.marshal(this.pilemax);
/*  80 */     _os_.marshal(this.sellSilver);
/*  81 */     _os_.marshal(this.isProprietary);
/*  82 */     _os_.marshal(this.canSellAndThrow);
/*  83 */     _os_.marshal(this.awardRoleLevelMin);
/*  84 */     _os_.marshal(this.awardRoleLevelMax);
/*  85 */     _os_.marshal(this.useLevel);
/*  86 */     _os_.marshal(this.sort);
/*  87 */     _os_.compact_uint32(this.mapIdProp.size());
/*  88 */     for (MapID2Prop _v_ : this.mapIdProp)
/*     */     {
/*  90 */       _os_.marshal(_v_);
/*     */     }
/*  92 */     _os_.marshal(this.awardPoolId);
/*  93 */     _os_.marshal(this.baotutype);
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     this.id = _os_.unmarshal_int();
/* 100 */     this.type = _os_.unmarshal_int();
/* 101 */     this.name = _os_.unmarshal_String("UTF-8");
/* 102 */     this.namecolor = _os_.unmarshal_int();
/* 103 */     this.icon = _os_.unmarshal_int();
/* 104 */     this.pilemax = _os_.unmarshal_int();
/* 105 */     this.sellSilver = _os_.unmarshal_int();
/* 106 */     this.isProprietary = _os_.unmarshal_boolean();
/* 107 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/* 108 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/* 109 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/* 110 */     this.useLevel = _os_.unmarshal_int();
/* 111 */     this.sort = _os_.unmarshal_int();
/* 112 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 115 */       MapID2Prop _v_ = new MapID2Prop();
/* 116 */       _v_.unmarshal(_os_);
/* 117 */       this.mapIdProp.add(_v_);
/*     */     }
/* 119 */     this.awardPoolId = _os_.unmarshal_int();
/* 120 */     this.baotutype = _os_.unmarshal_int();
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 126 */     String path = dir + "mzm.gsp.item.confbean.SItemCangBaoTuCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 130 */       all = new java.util.HashMap();
/* 131 */       SAXReader reader = new SAXReader();
/* 132 */       org.dom4j.Document doc = reader.read(new File(path));
/* 133 */       Element root = doc.getRootElement();
/* 134 */       List<?> nodeList = root.elements();
/* 135 */       int len = nodeList.size();
/* 136 */       for (int i = 0; i < len; i++)
/*     */       {
/* 138 */         Element elem = (Element)nodeList.get(i);
/* 139 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemCangBaoTuCfg"))
/*     */         {
/*     */ 
/* 142 */           SItemCangBaoTuCfg obj = new SItemCangBaoTuCfg();
/* 143 */           obj.loadFromXml(elem);
/* 144 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 145 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 150 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SItemCangBaoTuCfg> all)
/*     */   {
/* 156 */     String path = dir + "mzm.gsp.item.confbean.SItemCangBaoTuCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 160 */       SAXReader reader = new SAXReader();
/* 161 */       org.dom4j.Document doc = reader.read(new File(path));
/* 162 */       Element root = doc.getRootElement();
/* 163 */       List<?> nodeList = root.elements();
/* 164 */       int len = nodeList.size();
/* 165 */       for (int i = 0; i < len; i++)
/*     */       {
/* 167 */         Element elem = (Element)nodeList.get(i);
/* 168 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemCangBaoTuCfg"))
/*     */         {
/*     */ 
/* 171 */           SItemCangBaoTuCfg obj = new SItemCangBaoTuCfg();
/* 172 */           obj.loadFromXml(elem);
/* 173 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 179 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 185 */     all = new java.util.HashMap();
/*     */     
/* 187 */     String path = dir + "mzm.gsp.item.confbean.SItemCangBaoTuCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SItemCangBaoTuCfg _v_ = new SItemCangBaoTuCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SItemCangBaoTuCfg> all)
/*     */   {
/* 234 */     String path = dir + "mzm.gsp.item.confbean.SItemCangBaoTuCfg.bny";
/*     */     try
/*     */     {
/* 237 */       File file = new File(path);
/* 238 */       if (file.exists())
/*     */       {
/* 240 */         byte[] bytes = new byte['Ѐ'];
/* 241 */         FileInputStream fis = new FileInputStream(file);
/* 242 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 243 */         int len = 0;
/* 244 */         while ((len = fis.read(bytes)) > 0)
/* 245 */           baos.write(bytes, 0, len);
/* 246 */         fis.close();
/* 247 */         bytes = baos.toByteArray();
/* 248 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 251 */           _os_.unmarshal_int();
/* 252 */           _os_.unmarshal_int();
/* 253 */           _os_.unmarshal_int();
/*     */         }
/* 255 */         _os_.unmarshal_int();
/* 256 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 259 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 261 */           SItemCangBaoTuCfg _v_ = new SItemCangBaoTuCfg();
/* 262 */           _v_.unmarshal(_os_);
/* 263 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 264 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 269 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 274 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 280 */     for (Map.Entry<Integer, SItemCangBaoTuCfg> entry : all.entrySet())
/*     */     {
/* 282 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 284 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 288 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SItemCangBaoTuCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 295 */     for (Map.Entry<Integer, SItemCangBaoTuCfg> entry : all.entrySet())
/*     */     {
/* 297 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 299 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 303 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SItemCangBaoTuCfg getOld(int key)
/*     */   {
/* 310 */     return (SItemCangBaoTuCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SItemCangBaoTuCfg get(int key)
/*     */   {
/* 315 */     return (SItemCangBaoTuCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemCangBaoTuCfg> getOldAllSelf()
/*     */   {
/* 320 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemCangBaoTuCfg> getAllSelf()
/*     */   {
/* 325 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SItemCangBaoTuCfg> newAll)
/*     */   {
/* 330 */     oldAll = all;
/* 331 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 336 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SItemCangBaoTuCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */