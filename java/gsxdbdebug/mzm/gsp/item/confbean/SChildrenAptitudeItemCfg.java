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
/*     */ public class SChildrenAptitudeItemCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SChildrenAptitudeItemCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SChildrenAptitudeItemCfg> all = null;
/*     */   
/*     */   public int expectAddRate;
/*     */   public int fluctuateRate;
/*     */   public int fluctuateMax;
/*     */   public int addMin;
/*     */   public boolean addUseCount;
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
/*  40 */     this.expectAddRate = Integer.valueOf(rootElement.attributeValue("expectAddRate")).intValue();
/*  41 */     this.fluctuateRate = Integer.valueOf(rootElement.attributeValue("fluctuateRate")).intValue();
/*  42 */     this.fluctuateMax = Integer.valueOf(rootElement.attributeValue("fluctuateMax")).intValue();
/*  43 */     this.addMin = Integer.valueOf(rootElement.attributeValue("addMin")).intValue();
/*  44 */     this.addUseCount = Boolean.valueOf(rootElement.attributeValue("addUseCount")).booleanValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  49 */     _os_.marshal(this.id);
/*  50 */     _os_.marshal(this.type);
/*  51 */     _os_.marshal(this.name, "UTF-8");
/*  52 */     _os_.marshal(this.namecolor);
/*  53 */     _os_.marshal(this.icon);
/*  54 */     _os_.marshal(this.pilemax);
/*  55 */     _os_.marshal(this.sellSilver);
/*  56 */     _os_.marshal(this.isProprietary);
/*  57 */     _os_.marshal(this.canSellAndThrow);
/*  58 */     _os_.marshal(this.awardRoleLevelMin);
/*  59 */     _os_.marshal(this.awardRoleLevelMax);
/*  60 */     _os_.marshal(this.useLevel);
/*  61 */     _os_.marshal(this.sort);
/*  62 */     _os_.marshal(this.expectAddRate);
/*  63 */     _os_.marshal(this.fluctuateRate);
/*  64 */     _os_.marshal(this.fluctuateMax);
/*  65 */     _os_.marshal(this.addMin);
/*  66 */     _os_.marshal(this.addUseCount);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.type = _os_.unmarshal_int();
/*  74 */     this.name = _os_.unmarshal_String("UTF-8");
/*  75 */     this.namecolor = _os_.unmarshal_int();
/*  76 */     this.icon = _os_.unmarshal_int();
/*  77 */     this.pilemax = _os_.unmarshal_int();
/*  78 */     this.sellSilver = _os_.unmarshal_int();
/*  79 */     this.isProprietary = _os_.unmarshal_boolean();
/*  80 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  81 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  82 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  83 */     this.useLevel = _os_.unmarshal_int();
/*  84 */     this.sort = _os_.unmarshal_int();
/*  85 */     this.expectAddRate = _os_.unmarshal_int();
/*  86 */     this.fluctuateRate = _os_.unmarshal_int();
/*  87 */     this.fluctuateMax = _os_.unmarshal_int();
/*  88 */     this.addMin = _os_.unmarshal_int();
/*  89 */     this.addUseCount = _os_.unmarshal_boolean();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.item.confbean.SChildrenAptitudeItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  99 */       all = new java.util.HashMap();
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       List<?> nodeList = root.elements();
/* 104 */       int len = nodeList.size();
/* 105 */       for (int i = 0; i < len; i++)
/*     */       {
/* 107 */         Element elem = (Element)nodeList.get(i);
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SChildrenAptitudeItemCfg"))
/*     */         {
/*     */ 
/* 111 */           SChildrenAptitudeItemCfg obj = new SChildrenAptitudeItemCfg();
/* 112 */           obj.loadFromXml(elem);
/* 113 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 114 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 119 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SChildrenAptitudeItemCfg> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.item.confbean.SChildrenAptitudeItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       SAXReader reader = new SAXReader();
/* 130 */       org.dom4j.Document doc = reader.read(new File(path));
/* 131 */       Element root = doc.getRootElement();
/* 132 */       List<?> nodeList = root.elements();
/* 133 */       int len = nodeList.size();
/* 134 */       for (int i = 0; i < len; i++)
/*     */       {
/* 136 */         Element elem = (Element)nodeList.get(i);
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SChildrenAptitudeItemCfg"))
/*     */         {
/*     */ 
/* 140 */           SChildrenAptitudeItemCfg obj = new SChildrenAptitudeItemCfg();
/* 141 */           obj.loadFromXml(elem);
/* 142 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 143 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 154 */     all = new java.util.HashMap();
/*     */     
/* 156 */     String path = dir + "mzm.gsp.item.confbean.SChildrenAptitudeItemCfg.bny";
/*     */     try
/*     */     {
/* 159 */       File file = new File(path);
/* 160 */       if (file.exists())
/*     */       {
/* 162 */         byte[] bytes = new byte['Ѐ'];
/* 163 */         FileInputStream fis = new FileInputStream(file);
/* 164 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 165 */         int len = 0;
/* 166 */         while ((len = fis.read(bytes)) > 0)
/* 167 */           baos.write(bytes, 0, len);
/* 168 */         fis.close();
/* 169 */         bytes = baos.toByteArray();
/* 170 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 171 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/*     */         }
/* 177 */         _os_.unmarshal_int();
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 181 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 183 */           SChildrenAptitudeItemCfg _v_ = new SChildrenAptitudeItemCfg();
/* 184 */           _v_.unmarshal(_os_);
/* 185 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 186 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 191 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SChildrenAptitudeItemCfg> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.item.confbean.SChildrenAptitudeItemCfg.bny";
/*     */     try
/*     */     {
/* 206 */       File file = new File(path);
/* 207 */       if (file.exists())
/*     */       {
/* 209 */         byte[] bytes = new byte['Ѐ'];
/* 210 */         FileInputStream fis = new FileInputStream(file);
/* 211 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 212 */         int len = 0;
/* 213 */         while ((len = fis.read(bytes)) > 0)
/* 214 */           baos.write(bytes, 0, len);
/* 215 */         fis.close();
/* 216 */         bytes = baos.toByteArray();
/* 217 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/*     */         }
/* 224 */         _os_.unmarshal_int();
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 228 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 230 */           SChildrenAptitudeItemCfg _v_ = new SChildrenAptitudeItemCfg();
/* 231 */           _v_.unmarshal(_os_);
/* 232 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 233 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 238 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 243 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 249 */     for (Map.Entry<Integer, SChildrenAptitudeItemCfg> entry : all.entrySet())
/*     */     {
/* 251 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 253 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 257 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SChildrenAptitudeItemCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 264 */     for (Map.Entry<Integer, SChildrenAptitudeItemCfg> entry : all.entrySet())
/*     */     {
/* 266 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 268 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 272 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SChildrenAptitudeItemCfg getOld(int key)
/*     */   {
/* 279 */     return (SChildrenAptitudeItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SChildrenAptitudeItemCfg get(int key)
/*     */   {
/* 284 */     return (SChildrenAptitudeItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChildrenAptitudeItemCfg> getOldAllSelf()
/*     */   {
/* 289 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChildrenAptitudeItemCfg> getAllSelf()
/*     */   {
/* 294 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SChildrenAptitudeItemCfg> newAll)
/*     */   {
/* 299 */     oldAll = all;
/* 300 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 305 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SChildrenAptitudeItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */