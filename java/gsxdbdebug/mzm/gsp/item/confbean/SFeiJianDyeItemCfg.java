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
/*     */ public class SFeiJianDyeItemCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SFeiJianDyeItemCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SFeiJianDyeItemCfg> all = null;
/*     */   
/*     */ 
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  22 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  23 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  24 */     this.name = rootElement.attributeValue("name");
/*  25 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  26 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  27 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  28 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  29 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  30 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  31 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  32 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  33 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  34 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  39 */     _os_.marshal(this.id);
/*  40 */     _os_.marshal(this.type);
/*  41 */     _os_.marshal(this.name, "UTF-8");
/*  42 */     _os_.marshal(this.namecolor);
/*  43 */     _os_.marshal(this.icon);
/*  44 */     _os_.marshal(this.pilemax);
/*  45 */     _os_.marshal(this.sellSilver);
/*  46 */     _os_.marshal(this.isProprietary);
/*  47 */     _os_.marshal(this.canSellAndThrow);
/*  48 */     _os_.marshal(this.awardRoleLevelMin);
/*  49 */     _os_.marshal(this.awardRoleLevelMax);
/*  50 */     _os_.marshal(this.useLevel);
/*  51 */     _os_.marshal(this.sort);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  57 */     this.id = _os_.unmarshal_int();
/*  58 */     this.type = _os_.unmarshal_int();
/*  59 */     this.name = _os_.unmarshal_String("UTF-8");
/*  60 */     this.namecolor = _os_.unmarshal_int();
/*  61 */     this.icon = _os_.unmarshal_int();
/*  62 */     this.pilemax = _os_.unmarshal_int();
/*  63 */     this.sellSilver = _os_.unmarshal_int();
/*  64 */     this.isProprietary = _os_.unmarshal_boolean();
/*  65 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  66 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  67 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  68 */     this.useLevel = _os_.unmarshal_int();
/*  69 */     this.sort = _os_.unmarshal_int();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.item.confbean.SFeiJianDyeItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  79 */       all = new java.util.HashMap();
/*  80 */       SAXReader reader = new SAXReader();
/*  81 */       org.dom4j.Document doc = reader.read(new File(path));
/*  82 */       Element root = doc.getRootElement();
/*  83 */       List<?> nodeList = root.elements();
/*  84 */       int len = nodeList.size();
/*  85 */       for (int i = 0; i < len; i++)
/*     */       {
/*  87 */         Element elem = (Element)nodeList.get(i);
/*  88 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SFeiJianDyeItemCfg"))
/*     */         {
/*     */ 
/*  91 */           SFeiJianDyeItemCfg obj = new SFeiJianDyeItemCfg();
/*  92 */           obj.loadFromXml(elem);
/*  93 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  94 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  99 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFeiJianDyeItemCfg> all)
/*     */   {
/* 105 */     String path = dir + "mzm.gsp.item.confbean.SFeiJianDyeItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 109 */       SAXReader reader = new SAXReader();
/* 110 */       org.dom4j.Document doc = reader.read(new File(path));
/* 111 */       Element root = doc.getRootElement();
/* 112 */       List<?> nodeList = root.elements();
/* 113 */       int len = nodeList.size();
/* 114 */       for (int i = 0; i < len; i++)
/*     */       {
/* 116 */         Element elem = (Element)nodeList.get(i);
/* 117 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SFeiJianDyeItemCfg"))
/*     */         {
/*     */ 
/* 120 */           SFeiJianDyeItemCfg obj = new SFeiJianDyeItemCfg();
/* 121 */           obj.loadFromXml(elem);
/* 122 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 123 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 128 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 134 */     all = new java.util.HashMap();
/*     */     
/* 136 */     String path = dir + "mzm.gsp.item.confbean.SFeiJianDyeItemCfg.bny";
/*     */     try
/*     */     {
/* 139 */       File file = new File(path);
/* 140 */       if (file.exists())
/*     */       {
/* 142 */         byte[] bytes = new byte['Ѐ'];
/* 143 */         FileInputStream fis = new FileInputStream(file);
/* 144 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 145 */         int len = 0;
/* 146 */         while ((len = fis.read(bytes)) > 0)
/* 147 */           baos.write(bytes, 0, len);
/* 148 */         fis.close();
/* 149 */         bytes = baos.toByteArray();
/* 150 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 151 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 153 */           _os_.unmarshal_int();
/* 154 */           _os_.unmarshal_int();
/* 155 */           _os_.unmarshal_int();
/*     */         }
/* 157 */         _os_.unmarshal_int();
/* 158 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 161 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 163 */           SFeiJianDyeItemCfg _v_ = new SFeiJianDyeItemCfg();
/* 164 */           _v_.unmarshal(_os_);
/* 165 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 166 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 171 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFeiJianDyeItemCfg> all)
/*     */   {
/* 183 */     String path = dir + "mzm.gsp.item.confbean.SFeiJianDyeItemCfg.bny";
/*     */     try
/*     */     {
/* 186 */       File file = new File(path);
/* 187 */       if (file.exists())
/*     */       {
/* 189 */         byte[] bytes = new byte['Ѐ'];
/* 190 */         FileInputStream fis = new FileInputStream(file);
/* 191 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 192 */         int len = 0;
/* 193 */         while ((len = fis.read(bytes)) > 0)
/* 194 */           baos.write(bytes, 0, len);
/* 195 */         fis.close();
/* 196 */         bytes = baos.toByteArray();
/* 197 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 198 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/*     */         }
/* 204 */         _os_.unmarshal_int();
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 208 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 210 */           SFeiJianDyeItemCfg _v_ = new SFeiJianDyeItemCfg();
/* 211 */           _v_.unmarshal(_os_);
/* 212 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 213 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 218 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 223 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 229 */     for (Map.Entry<Integer, SFeiJianDyeItemCfg> entry : all.entrySet())
/*     */     {
/* 231 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 233 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 237 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SFeiJianDyeItemCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 244 */     for (Map.Entry<Integer, SFeiJianDyeItemCfg> entry : all.entrySet())
/*     */     {
/* 246 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 248 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 252 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SFeiJianDyeItemCfg getOld(int key)
/*     */   {
/* 259 */     return (SFeiJianDyeItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFeiJianDyeItemCfg get(int key)
/*     */   {
/* 264 */     return (SFeiJianDyeItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiJianDyeItemCfg> getOldAllSelf()
/*     */   {
/* 269 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiJianDyeItemCfg> getAllSelf()
/*     */   {
/* 274 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFeiJianDyeItemCfg> newAll)
/*     */   {
/* 279 */     oldAll = all;
/* 280 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 285 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SFeiJianDyeItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */