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
/*     */ public class SEquipSiftConCfg extends SItemSiftConCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SEquipSiftConCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SEquipSiftConCfg> all = null;
/*     */   
/*     */   public int maxUseLevel;
/*     */   public int minUseLevel;
/*     */   public int menPai;
/*     */   public int sex;
/*     */   public int wearPos;
/*     */   public int isProprietary;
/*     */   public int color;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     this.itemType = Integer.valueOf(rootElement.attributeValue("itemType")).intValue();
/*  31 */     this.maxUseLevel = Integer.valueOf(rootElement.attributeValue("maxUseLevel")).intValue();
/*  32 */     this.minUseLevel = Integer.valueOf(rootElement.attributeValue("minUseLevel")).intValue();
/*  33 */     this.menPai = Integer.valueOf(rootElement.attributeValue("menPai")).intValue();
/*  34 */     this.sex = Integer.valueOf(rootElement.attributeValue("sex")).intValue();
/*  35 */     this.wearPos = Integer.valueOf(rootElement.attributeValue("wearPos")).intValue();
/*  36 */     this.isProprietary = Integer.valueOf(rootElement.attributeValue("isProprietary")).intValue();
/*  37 */     this.color = Integer.valueOf(rootElement.attributeValue("color")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  42 */     _os_.marshal(this.id);
/*  43 */     _os_.marshal(this.itemType);
/*  44 */     _os_.marshal(this.maxUseLevel);
/*  45 */     _os_.marshal(this.minUseLevel);
/*  46 */     _os_.marshal(this.menPai);
/*  47 */     _os_.marshal(this.sex);
/*  48 */     _os_.marshal(this.wearPos);
/*  49 */     _os_.marshal(this.isProprietary);
/*  50 */     _os_.marshal(this.color);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  56 */     this.id = _os_.unmarshal_int();
/*  57 */     this.itemType = _os_.unmarshal_int();
/*  58 */     this.maxUseLevel = _os_.unmarshal_int();
/*  59 */     this.minUseLevel = _os_.unmarshal_int();
/*  60 */     this.menPai = _os_.unmarshal_int();
/*  61 */     this.sex = _os_.unmarshal_int();
/*  62 */     this.wearPos = _os_.unmarshal_int();
/*  63 */     this.isProprietary = _os_.unmarshal_int();
/*  64 */     this.color = _os_.unmarshal_int();
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  70 */     String path = dir + "mzm.gsp.item.confbean.SEquipSiftConCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  74 */       all = new java.util.HashMap();
/*  75 */       SAXReader reader = new SAXReader();
/*  76 */       org.dom4j.Document doc = reader.read(new File(path));
/*  77 */       Element root = doc.getRootElement();
/*  78 */       List<?> nodeList = root.elements();
/*  79 */       int len = nodeList.size();
/*  80 */       for (int i = 0; i < len; i++)
/*     */       {
/*  82 */         Element elem = (Element)nodeList.get(i);
/*  83 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SEquipSiftConCfg"))
/*     */         {
/*     */ 
/*  86 */           SEquipSiftConCfg obj = new SEquipSiftConCfg();
/*  87 */           obj.loadFromXml(elem);
/*  88 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  89 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  94 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SEquipSiftConCfg> all)
/*     */   {
/* 100 */     String path = dir + "mzm.gsp.item.confbean.SEquipSiftConCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 104 */       SAXReader reader = new SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       List<?> nodeList = root.elements();
/* 108 */       int len = nodeList.size();
/* 109 */       for (int i = 0; i < len; i++)
/*     */       {
/* 111 */         Element elem = (Element)nodeList.get(i);
/* 112 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SEquipSiftConCfg"))
/*     */         {
/*     */ 
/* 115 */           SEquipSiftConCfg obj = new SEquipSiftConCfg();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 129 */     all = new java.util.HashMap();
/*     */     
/* 131 */     String path = dir + "mzm.gsp.item.confbean.SEquipSiftConCfg.bny";
/*     */     try
/*     */     {
/* 134 */       File file = new File(path);
/* 135 */       if (file.exists())
/*     */       {
/* 137 */         byte[] bytes = new byte['Ѐ'];
/* 138 */         FileInputStream fis = new FileInputStream(file);
/* 139 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 140 */         int len = 0;
/* 141 */         while ((len = fis.read(bytes)) > 0)
/* 142 */           baos.write(bytes, 0, len);
/* 143 */         fis.close();
/* 144 */         bytes = baos.toByteArray();
/* 145 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 146 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 148 */           _os_.unmarshal_int();
/* 149 */           _os_.unmarshal_int();
/* 150 */           _os_.unmarshal_int();
/*     */         }
/* 152 */         _os_.unmarshal_int();
/* 153 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 156 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 158 */           SEquipSiftConCfg _v_ = new SEquipSiftConCfg();
/* 159 */           _v_.unmarshal(_os_);
/* 160 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 161 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 166 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SEquipSiftConCfg> all)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.item.confbean.SEquipSiftConCfg.bny";
/*     */     try
/*     */     {
/* 181 */       File file = new File(path);
/* 182 */       if (file.exists())
/*     */       {
/* 184 */         byte[] bytes = new byte['Ѐ'];
/* 185 */         FileInputStream fis = new FileInputStream(file);
/* 186 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 187 */         int len = 0;
/* 188 */         while ((len = fis.read(bytes)) > 0)
/* 189 */           baos.write(bytes, 0, len);
/* 190 */         fis.close();
/* 191 */         bytes = baos.toByteArray();
/* 192 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 193 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 195 */           _os_.unmarshal_int();
/* 196 */           _os_.unmarshal_int();
/* 197 */           _os_.unmarshal_int();
/*     */         }
/* 199 */         _os_.unmarshal_int();
/* 200 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 203 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 205 */           SEquipSiftConCfg _v_ = new SEquipSiftConCfg();
/* 206 */           _v_.unmarshal(_os_);
/* 207 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 208 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 213 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 218 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 224 */     for (Map.Entry<Integer, SEquipSiftConCfg> entry : all.entrySet())
/*     */     {
/* 226 */       if (SItemSiftConCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 228 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 232 */       SItemSiftConCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SEquipSiftConCfg> all, Map<Integer, SItemSiftConCfg> parent)
/*     */   {
/* 239 */     for (Map.Entry<Integer, SEquipSiftConCfg> entry : all.entrySet())
/*     */     {
/* 241 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 243 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 247 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SEquipSiftConCfg getOld(int key)
/*     */   {
/* 254 */     return (SEquipSiftConCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SEquipSiftConCfg get(int key)
/*     */   {
/* 259 */     return (SEquipSiftConCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEquipSiftConCfg> getOldAllSelf()
/*     */   {
/* 264 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEquipSiftConCfg> getAllSelf()
/*     */   {
/* 269 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SEquipSiftConCfg> newAll)
/*     */   {
/* 274 */     oldAll = all;
/* 275 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 280 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SEquipSiftConCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */