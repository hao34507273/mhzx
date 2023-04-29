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
/*     */ public class SActiveGraphItemCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SActiveGraphItemCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SActiveGraphItemCfg> all = null;
/*     */   
/*     */   public int graphId;
/*     */   public int useType;
/*     */   public boolean limitDayUseCount;
/*     */   public int dayUseCount;
/*     */   public boolean limitGlobalActiveCount;
/*     */   public int globalActiveCount;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  30 */     this.name = rootElement.attributeValue("name");
/*  31 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  32 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  33 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  34 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  35 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  36 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  37 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  38 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  39 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  40 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  41 */     this.graphId = Integer.valueOf(rootElement.attributeValue("graphId")).intValue();
/*  42 */     this.useType = Integer.valueOf(rootElement.attributeValue("useType")).intValue();
/*  43 */     this.limitDayUseCount = Boolean.valueOf(rootElement.attributeValue("limitDayUseCount")).booleanValue();
/*  44 */     this.dayUseCount = Integer.valueOf(rootElement.attributeValue("dayUseCount")).intValue();
/*  45 */     this.limitGlobalActiveCount = Boolean.valueOf(rootElement.attributeValue("limitGlobalActiveCount")).booleanValue();
/*  46 */     this.globalActiveCount = Integer.valueOf(rootElement.attributeValue("globalActiveCount")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.id);
/*  52 */     _os_.marshal(this.type);
/*  53 */     _os_.marshal(this.name, "UTF-8");
/*  54 */     _os_.marshal(this.namecolor);
/*  55 */     _os_.marshal(this.icon);
/*  56 */     _os_.marshal(this.pilemax);
/*  57 */     _os_.marshal(this.sellSilver);
/*  58 */     _os_.marshal(this.isProprietary);
/*  59 */     _os_.marshal(this.canSellAndThrow);
/*  60 */     _os_.marshal(this.awardRoleLevelMin);
/*  61 */     _os_.marshal(this.awardRoleLevelMax);
/*  62 */     _os_.marshal(this.useLevel);
/*  63 */     _os_.marshal(this.sort);
/*  64 */     _os_.marshal(this.graphId);
/*  65 */     _os_.marshal(this.useType);
/*  66 */     _os_.marshal(this.limitDayUseCount);
/*  67 */     _os_.marshal(this.dayUseCount);
/*  68 */     _os_.marshal(this.limitGlobalActiveCount);
/*  69 */     _os_.marshal(this.globalActiveCount);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.type = _os_.unmarshal_int();
/*  77 */     this.name = _os_.unmarshal_String("UTF-8");
/*  78 */     this.namecolor = _os_.unmarshal_int();
/*  79 */     this.icon = _os_.unmarshal_int();
/*  80 */     this.pilemax = _os_.unmarshal_int();
/*  81 */     this.sellSilver = _os_.unmarshal_int();
/*  82 */     this.isProprietary = _os_.unmarshal_boolean();
/*  83 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  84 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  85 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  86 */     this.useLevel = _os_.unmarshal_int();
/*  87 */     this.sort = _os_.unmarshal_int();
/*  88 */     this.graphId = _os_.unmarshal_int();
/*  89 */     this.useType = _os_.unmarshal_int();
/*  90 */     this.limitDayUseCount = _os_.unmarshal_boolean();
/*  91 */     this.dayUseCount = _os_.unmarshal_int();
/*  92 */     this.limitGlobalActiveCount = _os_.unmarshal_boolean();
/*  93 */     this.globalActiveCount = _os_.unmarshal_int();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  99 */     String path = dir + "mzm.gsp.item.confbean.SActiveGraphItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 103 */       all = new java.util.HashMap();
/* 104 */       SAXReader reader = new SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       List<?> nodeList = root.elements();
/* 108 */       int len = nodeList.size();
/* 109 */       for (int i = 0; i < len; i++)
/*     */       {
/* 111 */         Element elem = (Element)nodeList.get(i);
/* 112 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SActiveGraphItemCfg"))
/*     */         {
/*     */ 
/* 115 */           SActiveGraphItemCfg obj = new SActiveGraphItemCfg();
/* 116 */           obj.loadFromXml(elem);
/* 117 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 118 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SActiveGraphItemCfg> all)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.item.confbean.SActiveGraphItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 133 */       SAXReader reader = new SAXReader();
/* 134 */       org.dom4j.Document doc = reader.read(new File(path));
/* 135 */       Element root = doc.getRootElement();
/* 136 */       List<?> nodeList = root.elements();
/* 137 */       int len = nodeList.size();
/* 138 */       for (int i = 0; i < len; i++)
/*     */       {
/* 140 */         Element elem = (Element)nodeList.get(i);
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SActiveGraphItemCfg"))
/*     */         {
/*     */ 
/* 144 */           SActiveGraphItemCfg obj = new SActiveGraphItemCfg();
/* 145 */           obj.loadFromXml(elem);
/* 146 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 147 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 158 */     all = new java.util.HashMap();
/*     */     
/* 160 */     String path = dir + "mzm.gsp.item.confbean.SActiveGraphItemCfg.bny";
/*     */     try
/*     */     {
/* 163 */       File file = new File(path);
/* 164 */       if (file.exists())
/*     */       {
/* 166 */         byte[] bytes = new byte['Ѐ'];
/* 167 */         FileInputStream fis = new FileInputStream(file);
/* 168 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 169 */         int len = 0;
/* 170 */         while ((len = fis.read(bytes)) > 0)
/* 171 */           baos.write(bytes, 0, len);
/* 172 */         fis.close();
/* 173 */         bytes = baos.toByteArray();
/* 174 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 175 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 177 */           _os_.unmarshal_int();
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/*     */         }
/* 181 */         _os_.unmarshal_int();
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 185 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 187 */           SActiveGraphItemCfg _v_ = new SActiveGraphItemCfg();
/* 188 */           _v_.unmarshal(_os_);
/* 189 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 190 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 195 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 200 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SActiveGraphItemCfg> all)
/*     */   {
/* 207 */     String path = dir + "mzm.gsp.item.confbean.SActiveGraphItemCfg.bny";
/*     */     try
/*     */     {
/* 210 */       File file = new File(path);
/* 211 */       if (file.exists())
/*     */       {
/* 213 */         byte[] bytes = new byte['Ѐ'];
/* 214 */         FileInputStream fis = new FileInputStream(file);
/* 215 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 216 */         int len = 0;
/* 217 */         while ((len = fis.read(bytes)) > 0)
/* 218 */           baos.write(bytes, 0, len);
/* 219 */         fis.close();
/* 220 */         bytes = baos.toByteArray();
/* 221 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/*     */         }
/* 228 */         _os_.unmarshal_int();
/* 229 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 232 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 234 */           SActiveGraphItemCfg _v_ = new SActiveGraphItemCfg();
/* 235 */           _v_.unmarshal(_os_);
/* 236 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 237 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 242 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 247 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 253 */     for (Map.Entry<Integer, SActiveGraphItemCfg> entry : all.entrySet())
/*     */     {
/* 255 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 257 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 261 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SActiveGraphItemCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 268 */     for (Map.Entry<Integer, SActiveGraphItemCfg> entry : all.entrySet())
/*     */     {
/* 270 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 272 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 276 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SActiveGraphItemCfg getOld(int key)
/*     */   {
/* 283 */     return (SActiveGraphItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SActiveGraphItemCfg get(int key)
/*     */   {
/* 288 */     return (SActiveGraphItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SActiveGraphItemCfg> getOldAllSelf()
/*     */   {
/* 293 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SActiveGraphItemCfg> getAllSelf()
/*     */   {
/* 298 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SActiveGraphItemCfg> newAll)
/*     */   {
/* 303 */     oldAll = all;
/* 304 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 309 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SActiveGraphItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */