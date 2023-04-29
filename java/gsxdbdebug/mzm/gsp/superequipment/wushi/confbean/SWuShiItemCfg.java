/*     */ package mzm.gsp.superequipment.wushi.confbean;
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
/*     */ public class SWuShiItemCfg extends mzm.gsp.item.confbean.SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SWuShiItemCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SWuShiItemCfg> all = null;
/*     */   
/*     */   public String source;
/*     */   public int fragmentCount;
/*     */   public int wuShiCfgId;
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
/*  38 */     this.source = rootElement.attributeValue("source");
/*  39 */     this.fragmentCount = Integer.valueOf(rootElement.attributeValue("fragmentCount")).intValue();
/*  40 */     this.wuShiCfgId = Integer.valueOf(rootElement.attributeValue("wuShiCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  45 */     _os_.marshal(this.id);
/*  46 */     _os_.marshal(this.type);
/*  47 */     _os_.marshal(this.name, "UTF-8");
/*  48 */     _os_.marshal(this.namecolor);
/*  49 */     _os_.marshal(this.icon);
/*  50 */     _os_.marshal(this.pilemax);
/*  51 */     _os_.marshal(this.sellSilver);
/*  52 */     _os_.marshal(this.isProprietary);
/*  53 */     _os_.marshal(this.canSellAndThrow);
/*  54 */     _os_.marshal(this.awardRoleLevelMin);
/*  55 */     _os_.marshal(this.awardRoleLevelMax);
/*  56 */     _os_.marshal(this.useLevel);
/*  57 */     _os_.marshal(this.sort);
/*  58 */     _os_.marshal(this.source, "UTF-8");
/*  59 */     _os_.marshal(this.fragmentCount);
/*  60 */     _os_.marshal(this.wuShiCfgId);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  66 */     this.id = _os_.unmarshal_int();
/*  67 */     this.type = _os_.unmarshal_int();
/*  68 */     this.name = _os_.unmarshal_String("UTF-8");
/*  69 */     this.namecolor = _os_.unmarshal_int();
/*  70 */     this.icon = _os_.unmarshal_int();
/*  71 */     this.pilemax = _os_.unmarshal_int();
/*  72 */     this.sellSilver = _os_.unmarshal_int();
/*  73 */     this.isProprietary = _os_.unmarshal_boolean();
/*  74 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  75 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  76 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  77 */     this.useLevel = _os_.unmarshal_int();
/*  78 */     this.sort = _os_.unmarshal_int();
/*  79 */     this.source = _os_.unmarshal_String("UTF-8");
/*  80 */     this.fragmentCount = _os_.unmarshal_int();
/*  81 */     this.wuShiCfgId = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.SWuShiItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  91 */       all = new java.util.HashMap();
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.wushi.confbean.SWuShiItemCfg"))
/*     */         {
/*     */ 
/* 103 */           SWuShiItemCfg obj = new SWuShiItemCfg();
/* 104 */           obj.loadFromXml(elem);
/* 105 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 106 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SWuShiItemCfg> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.SWuShiItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.wushi.confbean.SWuShiItemCfg"))
/*     */         {
/*     */ 
/* 132 */           SWuShiItemCfg obj = new SWuShiItemCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 146 */     all = new java.util.HashMap();
/*     */     
/* 148 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.SWuShiItemCfg.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/*     */         }
/* 169 */         _os_.unmarshal_int();
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 173 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 175 */           SWuShiItemCfg _v_ = new SWuShiItemCfg();
/* 176 */           _v_.unmarshal(_os_);
/* 177 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 183 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SWuShiItemCfg> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.SWuShiItemCfg.bny";
/*     */     try
/*     */     {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists())
/*     */       {
/* 201 */         byte[] bytes = new byte['Ѐ'];
/* 202 */         FileInputStream fis = new FileInputStream(file);
/* 203 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 204 */         int len = 0;
/* 205 */         while ((len = fis.read(bytes)) > 0)
/* 206 */           baos.write(bytes, 0, len);
/* 207 */         fis.close();
/* 208 */         bytes = baos.toByteArray();
/* 209 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/*     */         }
/* 216 */         _os_.unmarshal_int();
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 220 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 222 */           SWuShiItemCfg _v_ = new SWuShiItemCfg();
/* 223 */           _v_.unmarshal(_os_);
/* 224 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 230 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 235 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 241 */     for (Map.Entry<Integer, SWuShiItemCfg> entry : all.entrySet())
/*     */     {
/* 243 */       if (mzm.gsp.item.confbean.SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 245 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 249 */       mzm.gsp.item.confbean.SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SWuShiItemCfg> all, Map<Integer, mzm.gsp.item.confbean.SItemCfg> parent)
/*     */   {
/* 256 */     for (Map.Entry<Integer, SWuShiItemCfg> entry : all.entrySet())
/*     */     {
/* 258 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 260 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 264 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SWuShiItemCfg getOld(int key)
/*     */   {
/* 271 */     return (SWuShiItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SWuShiItemCfg get(int key)
/*     */   {
/* 276 */     return (SWuShiItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SWuShiItemCfg> getOldAllSelf()
/*     */   {
/* 281 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SWuShiItemCfg> getAllSelf()
/*     */   {
/* 286 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SWuShiItemCfg> newAll)
/*     */   {
/* 291 */     oldAll = all;
/* 292 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 297 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\confbean\SWuShiItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */