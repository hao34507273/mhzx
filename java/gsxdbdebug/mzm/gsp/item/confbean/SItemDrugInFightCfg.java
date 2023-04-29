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
/*     */ public class SItemDrugInFightCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SItemDrugInFightCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SItemDrugInFightCfg> all = null;
/*     */   
/*     */   public int targettype1;
/*     */   public int targettype2;
/*     */   public int targettype3;
/*     */   public int targettype4;
/*  23 */   public java.util.ArrayList<Integer> skillEffectGroupIds = new java.util.ArrayList();
/*     */   public int drugPro;
/*     */   public int fun;
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
/*  42 */     this.targettype1 = Integer.valueOf(rootElement.attributeValue("targettype1")).intValue();
/*  43 */     this.targettype2 = Integer.valueOf(rootElement.attributeValue("targettype2")).intValue();
/*  44 */     this.targettype3 = Integer.valueOf(rootElement.attributeValue("targettype3")).intValue();
/*  45 */     this.targettype4 = Integer.valueOf(rootElement.attributeValue("targettype4")).intValue();
/*     */     
/*  47 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "skillEffectGroupIds");
/*  48 */     if (collectionElement == null)
/*     */     {
/*  50 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  53 */     List<?> _nodeList = collectionElement.elements();
/*  54 */     int _len = _nodeList.size();
/*  55 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  57 */       Element elem = (Element)_nodeList.get(i);
/*  58 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  65 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  72 */         this.skillEffectGroupIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  75 */     this.drugPro = Integer.valueOf(rootElement.attributeValue("drugPro")).intValue();
/*  76 */     this.fun = Integer.valueOf(rootElement.attributeValue("fun")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  81 */     _os_.marshal(this.id);
/*  82 */     _os_.marshal(this.type);
/*  83 */     _os_.marshal(this.name, "UTF-8");
/*  84 */     _os_.marshal(this.namecolor);
/*  85 */     _os_.marshal(this.icon);
/*  86 */     _os_.marshal(this.pilemax);
/*  87 */     _os_.marshal(this.sellSilver);
/*  88 */     _os_.marshal(this.isProprietary);
/*  89 */     _os_.marshal(this.canSellAndThrow);
/*  90 */     _os_.marshal(this.awardRoleLevelMin);
/*  91 */     _os_.marshal(this.awardRoleLevelMax);
/*  92 */     _os_.marshal(this.useLevel);
/*  93 */     _os_.marshal(this.sort);
/*  94 */     _os_.marshal(this.targettype1);
/*  95 */     _os_.marshal(this.targettype2);
/*  96 */     _os_.marshal(this.targettype3);
/*  97 */     _os_.marshal(this.targettype4);
/*  98 */     _os_.compact_uint32(this.skillEffectGroupIds.size());
/*  99 */     for (Integer _v_ : this.skillEffectGroupIds)
/*     */     {
/* 101 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 103 */     _os_.marshal(this.drugPro);
/* 104 */     _os_.marshal(this.fun);
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 110 */     this.id = _os_.unmarshal_int();
/* 111 */     this.type = _os_.unmarshal_int();
/* 112 */     this.name = _os_.unmarshal_String("UTF-8");
/* 113 */     this.namecolor = _os_.unmarshal_int();
/* 114 */     this.icon = _os_.unmarshal_int();
/* 115 */     this.pilemax = _os_.unmarshal_int();
/* 116 */     this.sellSilver = _os_.unmarshal_int();
/* 117 */     this.isProprietary = _os_.unmarshal_boolean();
/* 118 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/* 119 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/* 120 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/* 121 */     this.useLevel = _os_.unmarshal_int();
/* 122 */     this.sort = _os_.unmarshal_int();
/* 123 */     this.targettype1 = _os_.unmarshal_int();
/* 124 */     this.targettype2 = _os_.unmarshal_int();
/* 125 */     this.targettype3 = _os_.unmarshal_int();
/* 126 */     this.targettype4 = _os_.unmarshal_int();
/* 127 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 130 */       int _v_ = _os_.unmarshal_int();
/* 131 */       this.skillEffectGroupIds.add(Integer.valueOf(_v_));
/*     */     }
/* 133 */     this.drugPro = _os_.unmarshal_int();
/* 134 */     this.fun = _os_.unmarshal_int();
/* 135 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 140 */     String path = dir + "mzm.gsp.item.confbean.SItemDrugInFightCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 144 */       all = new java.util.HashMap();
/* 145 */       SAXReader reader = new SAXReader();
/* 146 */       org.dom4j.Document doc = reader.read(new File(path));
/* 147 */       Element root = doc.getRootElement();
/* 148 */       List<?> nodeList = root.elements();
/* 149 */       int len = nodeList.size();
/* 150 */       for (int i = 0; i < len; i++)
/*     */       {
/* 152 */         Element elem = (Element)nodeList.get(i);
/* 153 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemDrugInFightCfg"))
/*     */         {
/*     */ 
/* 156 */           SItemDrugInFightCfg obj = new SItemDrugInFightCfg();
/* 157 */           obj.loadFromXml(elem);
/* 158 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 159 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SItemDrugInFightCfg> all)
/*     */   {
/* 170 */     String path = dir + "mzm.gsp.item.confbean.SItemDrugInFightCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 174 */       SAXReader reader = new SAXReader();
/* 175 */       org.dom4j.Document doc = reader.read(new File(path));
/* 176 */       Element root = doc.getRootElement();
/* 177 */       List<?> nodeList = root.elements();
/* 178 */       int len = nodeList.size();
/* 179 */       for (int i = 0; i < len; i++)
/*     */       {
/* 181 */         Element elem = (Element)nodeList.get(i);
/* 182 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemDrugInFightCfg"))
/*     */         {
/*     */ 
/* 185 */           SItemDrugInFightCfg obj = new SItemDrugInFightCfg();
/* 186 */           obj.loadFromXml(elem);
/* 187 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 188 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 193 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 199 */     all = new java.util.HashMap();
/*     */     
/* 201 */     String path = dir + "mzm.gsp.item.confbean.SItemDrugInFightCfg.bny";
/*     */     try
/*     */     {
/* 204 */       File file = new File(path);
/* 205 */       if (file.exists())
/*     */       {
/* 207 */         byte[] bytes = new byte['Ѐ'];
/* 208 */         FileInputStream fis = new FileInputStream(file);
/* 209 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 210 */         int len = 0;
/* 211 */         while ((len = fis.read(bytes)) > 0)
/* 212 */           baos.write(bytes, 0, len);
/* 213 */         fis.close();
/* 214 */         bytes = baos.toByteArray();
/* 215 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 216 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 218 */           _os_.unmarshal_int();
/* 219 */           _os_.unmarshal_int();
/* 220 */           _os_.unmarshal_int();
/*     */         }
/* 222 */         _os_.unmarshal_int();
/* 223 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 226 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 228 */           SItemDrugInFightCfg _v_ = new SItemDrugInFightCfg();
/* 229 */           _v_.unmarshal(_os_);
/* 230 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 231 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 236 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 241 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SItemDrugInFightCfg> all)
/*     */   {
/* 248 */     String path = dir + "mzm.gsp.item.confbean.SItemDrugInFightCfg.bny";
/*     */     try
/*     */     {
/* 251 */       File file = new File(path);
/* 252 */       if (file.exists())
/*     */       {
/* 254 */         byte[] bytes = new byte['Ѐ'];
/* 255 */         FileInputStream fis = new FileInputStream(file);
/* 256 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 257 */         int len = 0;
/* 258 */         while ((len = fis.read(bytes)) > 0)
/* 259 */           baos.write(bytes, 0, len);
/* 260 */         fis.close();
/* 261 */         bytes = baos.toByteArray();
/* 262 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 263 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 265 */           _os_.unmarshal_int();
/* 266 */           _os_.unmarshal_int();
/* 267 */           _os_.unmarshal_int();
/*     */         }
/* 269 */         _os_.unmarshal_int();
/* 270 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 273 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 275 */           SItemDrugInFightCfg _v_ = new SItemDrugInFightCfg();
/* 276 */           _v_.unmarshal(_os_);
/* 277 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 278 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 283 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 288 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 294 */     for (Map.Entry<Integer, SItemDrugInFightCfg> entry : all.entrySet())
/*     */     {
/* 296 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 298 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 302 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SItemDrugInFightCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 309 */     for (Map.Entry<Integer, SItemDrugInFightCfg> entry : all.entrySet())
/*     */     {
/* 311 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 313 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 317 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SItemDrugInFightCfg getOld(int key)
/*     */   {
/* 324 */     return (SItemDrugInFightCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SItemDrugInFightCfg get(int key)
/*     */   {
/* 329 */     return (SItemDrugInFightCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemDrugInFightCfg> getOldAllSelf()
/*     */   {
/* 334 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemDrugInFightCfg> getAllSelf()
/*     */   {
/* 339 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SItemDrugInFightCfg> newAll)
/*     */   {
/* 344 */     oldAll = all;
/* 345 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 350 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SItemDrugInFightCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */