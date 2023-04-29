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
/*     */ public class STaskGoodsCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, STaskGoodsCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, STaskGoodsCfg> all = null;
/*     */   
/*     */   public boolean canuse;
/*     */   public int useEffectType;
/*     */   public int specialEffect;
/*     */   public String displayWords;
/*     */   public int mapid;
/*     */   public int posx;
/*     */   public int posy;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  31 */     this.name = rootElement.attributeValue("name");
/*  32 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  33 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  34 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  35 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  36 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  37 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  38 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  39 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  40 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  41 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  42 */     this.canuse = Boolean.valueOf(rootElement.attributeValue("canuse")).booleanValue();
/*  43 */     this.useEffectType = Integer.valueOf(rootElement.attributeValue("useEffectType")).intValue();
/*  44 */     this.specialEffect = Integer.valueOf(rootElement.attributeValue("specialEffect")).intValue();
/*  45 */     this.displayWords = rootElement.attributeValue("displayWords");
/*  46 */     this.mapid = Integer.valueOf(rootElement.attributeValue("mapid")).intValue();
/*  47 */     this.posx = Integer.valueOf(rootElement.attributeValue("posx")).intValue();
/*  48 */     this.posy = Integer.valueOf(rootElement.attributeValue("posy")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.type);
/*  55 */     _os_.marshal(this.name, "UTF-8");
/*  56 */     _os_.marshal(this.namecolor);
/*  57 */     _os_.marshal(this.icon);
/*  58 */     _os_.marshal(this.pilemax);
/*  59 */     _os_.marshal(this.sellSilver);
/*  60 */     _os_.marshal(this.isProprietary);
/*  61 */     _os_.marshal(this.canSellAndThrow);
/*  62 */     _os_.marshal(this.awardRoleLevelMin);
/*  63 */     _os_.marshal(this.awardRoleLevelMax);
/*  64 */     _os_.marshal(this.useLevel);
/*  65 */     _os_.marshal(this.sort);
/*  66 */     _os_.marshal(this.canuse);
/*  67 */     _os_.marshal(this.useEffectType);
/*  68 */     _os_.marshal(this.specialEffect);
/*  69 */     _os_.marshal(this.displayWords, "UTF-8");
/*  70 */     _os_.marshal(this.mapid);
/*  71 */     _os_.marshal(this.posx);
/*  72 */     _os_.marshal(this.posy);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.id = _os_.unmarshal_int();
/*  79 */     this.type = _os_.unmarshal_int();
/*  80 */     this.name = _os_.unmarshal_String("UTF-8");
/*  81 */     this.namecolor = _os_.unmarshal_int();
/*  82 */     this.icon = _os_.unmarshal_int();
/*  83 */     this.pilemax = _os_.unmarshal_int();
/*  84 */     this.sellSilver = _os_.unmarshal_int();
/*  85 */     this.isProprietary = _os_.unmarshal_boolean();
/*  86 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  87 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  88 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  89 */     this.useLevel = _os_.unmarshal_int();
/*  90 */     this.sort = _os_.unmarshal_int();
/*  91 */     this.canuse = _os_.unmarshal_boolean();
/*  92 */     this.useEffectType = _os_.unmarshal_int();
/*  93 */     this.specialEffect = _os_.unmarshal_int();
/*  94 */     this.displayWords = _os_.unmarshal_String("UTF-8");
/*  95 */     this.mapid = _os_.unmarshal_int();
/*  96 */     this.posx = _os_.unmarshal_int();
/*  97 */     this.posy = _os_.unmarshal_int();
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 103 */     String path = dir + "mzm.gsp.item.confbean.STaskGoodsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 107 */       all = new java.util.HashMap();
/* 108 */       SAXReader reader = new SAXReader();
/* 109 */       org.dom4j.Document doc = reader.read(new File(path));
/* 110 */       Element root = doc.getRootElement();
/* 111 */       List<?> nodeList = root.elements();
/* 112 */       int len = nodeList.size();
/* 113 */       for (int i = 0; i < len; i++)
/*     */       {
/* 115 */         Element elem = (Element)nodeList.get(i);
/* 116 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.STaskGoodsCfg"))
/*     */         {
/*     */ 
/* 119 */           STaskGoodsCfg obj = new STaskGoodsCfg();
/* 120 */           obj.loadFromXml(elem);
/* 121 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 122 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 127 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STaskGoodsCfg> all)
/*     */   {
/* 133 */     String path = dir + "mzm.gsp.item.confbean.STaskGoodsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 137 */       SAXReader reader = new SAXReader();
/* 138 */       org.dom4j.Document doc = reader.read(new File(path));
/* 139 */       Element root = doc.getRootElement();
/* 140 */       List<?> nodeList = root.elements();
/* 141 */       int len = nodeList.size();
/* 142 */       for (int i = 0; i < len; i++)
/*     */       {
/* 144 */         Element elem = (Element)nodeList.get(i);
/* 145 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.STaskGoodsCfg"))
/*     */         {
/*     */ 
/* 148 */           STaskGoodsCfg obj = new STaskGoodsCfg();
/* 149 */           obj.loadFromXml(elem);
/* 150 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 151 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 162 */     all = new java.util.HashMap();
/*     */     
/* 164 */     String path = dir + "mzm.gsp.item.confbean.STaskGoodsCfg.bny";
/*     */     try
/*     */     {
/* 167 */       File file = new File(path);
/* 168 */       if (file.exists())
/*     */       {
/* 170 */         byte[] bytes = new byte['Ѐ'];
/* 171 */         FileInputStream fis = new FileInputStream(file);
/* 172 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 173 */         int len = 0;
/* 174 */         while ((len = fis.read(bytes)) > 0)
/* 175 */           baos.write(bytes, 0, len);
/* 176 */         fis.close();
/* 177 */         bytes = baos.toByteArray();
/* 178 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 181 */           _os_.unmarshal_int();
/* 182 */           _os_.unmarshal_int();
/* 183 */           _os_.unmarshal_int();
/*     */         }
/* 185 */         _os_.unmarshal_int();
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 189 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 191 */           STaskGoodsCfg _v_ = new STaskGoodsCfg();
/* 192 */           _v_.unmarshal(_os_);
/* 193 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 194 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 199 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 204 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STaskGoodsCfg> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.item.confbean.STaskGoodsCfg.bny";
/*     */     try
/*     */     {
/* 214 */       File file = new File(path);
/* 215 */       if (file.exists())
/*     */       {
/* 217 */         byte[] bytes = new byte['Ѐ'];
/* 218 */         FileInputStream fis = new FileInputStream(file);
/* 219 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 220 */         int len = 0;
/* 221 */         while ((len = fis.read(bytes)) > 0)
/* 222 */           baos.write(bytes, 0, len);
/* 223 */         fis.close();
/* 224 */         bytes = baos.toByteArray();
/* 225 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 226 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/* 230 */           _os_.unmarshal_int();
/*     */         }
/* 232 */         _os_.unmarshal_int();
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 236 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 238 */           STaskGoodsCfg _v_ = new STaskGoodsCfg();
/* 239 */           _v_.unmarshal(_os_);
/* 240 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 241 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 246 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 257 */     for (Map.Entry<Integer, STaskGoodsCfg> entry : all.entrySet())
/*     */     {
/* 259 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 261 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 265 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, STaskGoodsCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 272 */     for (Map.Entry<Integer, STaskGoodsCfg> entry : all.entrySet())
/*     */     {
/* 274 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 276 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 280 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static STaskGoodsCfg getOld(int key)
/*     */   {
/* 287 */     return (STaskGoodsCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STaskGoodsCfg get(int key)
/*     */   {
/* 292 */     return (STaskGoodsCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STaskGoodsCfg> getOldAllSelf()
/*     */   {
/* 297 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STaskGoodsCfg> getAllSelf()
/*     */   {
/* 302 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STaskGoodsCfg> newAll)
/*     */   {
/* 307 */     oldAll = all;
/* 308 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 313 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\STaskGoodsCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */