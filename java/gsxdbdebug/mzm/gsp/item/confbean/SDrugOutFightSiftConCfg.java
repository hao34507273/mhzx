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
/*     */ public class SDrugOutFightSiftConCfg extends SItemSiftConCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SDrugOutFightSiftConCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SDrugOutFightSiftConCfg> all = null;
/*     */   
/*     */   public int maxDrugPro;
/*     */   public int minDrugPro;
/*     */   public int isProprietary;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.itemType = Integer.valueOf(rootElement.attributeValue("itemType")).intValue();
/*  27 */     this.maxDrugPro = Integer.valueOf(rootElement.attributeValue("maxDrugPro")).intValue();
/*  28 */     this.minDrugPro = Integer.valueOf(rootElement.attributeValue("minDrugPro")).intValue();
/*  29 */     this.isProprietary = Integer.valueOf(rootElement.attributeValue("isProprietary")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  34 */     _os_.marshal(this.id);
/*  35 */     _os_.marshal(this.itemType);
/*  36 */     _os_.marshal(this.maxDrugPro);
/*  37 */     _os_.marshal(this.minDrugPro);
/*  38 */     _os_.marshal(this.isProprietary);
/*  39 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  44 */     this.id = _os_.unmarshal_int();
/*  45 */     this.itemType = _os_.unmarshal_int();
/*  46 */     this.maxDrugPro = _os_.unmarshal_int();
/*  47 */     this.minDrugPro = _os_.unmarshal_int();
/*  48 */     this.isProprietary = _os_.unmarshal_int();
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  54 */     String path = dir + "mzm.gsp.item.confbean.SDrugOutFightSiftConCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  58 */       all = new java.util.HashMap();
/*  59 */       SAXReader reader = new SAXReader();
/*  60 */       org.dom4j.Document doc = reader.read(new File(path));
/*  61 */       Element root = doc.getRootElement();
/*  62 */       List<?> nodeList = root.elements();
/*  63 */       int len = nodeList.size();
/*  64 */       for (int i = 0; i < len; i++)
/*     */       {
/*  66 */         Element elem = (Element)nodeList.get(i);
/*  67 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SDrugOutFightSiftConCfg"))
/*     */         {
/*     */ 
/*  70 */           SDrugOutFightSiftConCfg obj = new SDrugOutFightSiftConCfg();
/*  71 */           obj.loadFromXml(elem);
/*  72 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  73 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  78 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SDrugOutFightSiftConCfg> all)
/*     */   {
/*  84 */     String path = dir + "mzm.gsp.item.confbean.SDrugOutFightSiftConCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       List<?> nodeList = root.elements();
/*  92 */       int len = nodeList.size();
/*  93 */       for (int i = 0; i < len; i++)
/*     */       {
/*  95 */         Element elem = (Element)nodeList.get(i);
/*  96 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SDrugOutFightSiftConCfg"))
/*     */         {
/*     */ 
/*  99 */           SDrugOutFightSiftConCfg obj = new SDrugOutFightSiftConCfg();
/* 100 */           obj.loadFromXml(elem);
/* 101 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 102 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 107 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 113 */     all = new java.util.HashMap();
/*     */     
/* 115 */     String path = dir + "mzm.gsp.item.confbean.SDrugOutFightSiftConCfg.bny";
/*     */     try
/*     */     {
/* 118 */       File file = new File(path);
/* 119 */       if (file.exists())
/*     */       {
/* 121 */         byte[] bytes = new byte['Ѐ'];
/* 122 */         FileInputStream fis = new FileInputStream(file);
/* 123 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 124 */         int len = 0;
/* 125 */         while ((len = fis.read(bytes)) > 0)
/* 126 */           baos.write(bytes, 0, len);
/* 127 */         fis.close();
/* 128 */         bytes = baos.toByteArray();
/* 129 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 130 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 132 */           _os_.unmarshal_int();
/* 133 */           _os_.unmarshal_int();
/* 134 */           _os_.unmarshal_int();
/*     */         }
/* 136 */         _os_.unmarshal_int();
/* 137 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 140 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 142 */           SDrugOutFightSiftConCfg _v_ = new SDrugOutFightSiftConCfg();
/* 143 */           _v_.unmarshal(_os_);
/* 144 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 145 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 150 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 155 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SDrugOutFightSiftConCfg> all)
/*     */   {
/* 162 */     String path = dir + "mzm.gsp.item.confbean.SDrugOutFightSiftConCfg.bny";
/*     */     try
/*     */     {
/* 165 */       File file = new File(path);
/* 166 */       if (file.exists())
/*     */       {
/* 168 */         byte[] bytes = new byte['Ѐ'];
/* 169 */         FileInputStream fis = new FileInputStream(file);
/* 170 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 171 */         int len = 0;
/* 172 */         while ((len = fis.read(bytes)) > 0)
/* 173 */           baos.write(bytes, 0, len);
/* 174 */         fis.close();
/* 175 */         bytes = baos.toByteArray();
/* 176 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 177 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 179 */           _os_.unmarshal_int();
/* 180 */           _os_.unmarshal_int();
/* 181 */           _os_.unmarshal_int();
/*     */         }
/* 183 */         _os_.unmarshal_int();
/* 184 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 187 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 189 */           SDrugOutFightSiftConCfg _v_ = new SDrugOutFightSiftConCfg();
/* 190 */           _v_.unmarshal(_os_);
/* 191 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 192 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 197 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 202 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 208 */     for (Map.Entry<Integer, SDrugOutFightSiftConCfg> entry : all.entrySet())
/*     */     {
/* 210 */       if (SItemSiftConCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 212 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 216 */       SItemSiftConCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SDrugOutFightSiftConCfg> all, Map<Integer, SItemSiftConCfg> parent)
/*     */   {
/* 223 */     for (Map.Entry<Integer, SDrugOutFightSiftConCfg> entry : all.entrySet())
/*     */     {
/* 225 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 227 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 231 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SDrugOutFightSiftConCfg getOld(int key)
/*     */   {
/* 238 */     return (SDrugOutFightSiftConCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SDrugOutFightSiftConCfg get(int key)
/*     */   {
/* 243 */     return (SDrugOutFightSiftConCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDrugOutFightSiftConCfg> getOldAllSelf()
/*     */   {
/* 248 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDrugOutFightSiftConCfg> getAllSelf()
/*     */   {
/* 253 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SDrugOutFightSiftConCfg> newAll)
/*     */   {
/* 258 */     oldAll = all;
/* 259 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 264 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SDrugOutFightSiftConCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */