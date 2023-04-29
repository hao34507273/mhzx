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
/*     */ public class SDrugInFightSiftConCfg extends SItemSiftConCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SDrugInFightSiftConCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SDrugInFightSiftConCfg> all = null;
/*     */   
/*     */   public int maxDrugPro;
/*     */   public int minDrugPro;
/*     */   public int fun;
/*     */   public int isProprietary;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  27 */     this.itemType = Integer.valueOf(rootElement.attributeValue("itemType")).intValue();
/*  28 */     this.maxDrugPro = Integer.valueOf(rootElement.attributeValue("maxDrugPro")).intValue();
/*  29 */     this.minDrugPro = Integer.valueOf(rootElement.attributeValue("minDrugPro")).intValue();
/*  30 */     this.fun = Integer.valueOf(rootElement.attributeValue("fun")).intValue();
/*  31 */     this.isProprietary = Integer.valueOf(rootElement.attributeValue("isProprietary")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  36 */     _os_.marshal(this.id);
/*  37 */     _os_.marshal(this.itemType);
/*  38 */     _os_.marshal(this.maxDrugPro);
/*  39 */     _os_.marshal(this.minDrugPro);
/*  40 */     _os_.marshal(this.fun);
/*  41 */     _os_.marshal(this.isProprietary);
/*  42 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  47 */     this.id = _os_.unmarshal_int();
/*  48 */     this.itemType = _os_.unmarshal_int();
/*  49 */     this.maxDrugPro = _os_.unmarshal_int();
/*  50 */     this.minDrugPro = _os_.unmarshal_int();
/*  51 */     this.fun = _os_.unmarshal_int();
/*  52 */     this.isProprietary = _os_.unmarshal_int();
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  58 */     String path = dir + "mzm.gsp.item.confbean.SDrugInFightSiftConCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  62 */       all = new java.util.HashMap();
/*  63 */       SAXReader reader = new SAXReader();
/*  64 */       org.dom4j.Document doc = reader.read(new File(path));
/*  65 */       Element root = doc.getRootElement();
/*  66 */       List<?> nodeList = root.elements();
/*  67 */       int len = nodeList.size();
/*  68 */       for (int i = 0; i < len; i++)
/*     */       {
/*  70 */         Element elem = (Element)nodeList.get(i);
/*  71 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SDrugInFightSiftConCfg"))
/*     */         {
/*     */ 
/*  74 */           SDrugInFightSiftConCfg obj = new SDrugInFightSiftConCfg();
/*  75 */           obj.loadFromXml(elem);
/*  76 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  77 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  82 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SDrugInFightSiftConCfg> all)
/*     */   {
/*  88 */     String path = dir + "mzm.gsp.item.confbean.SDrugInFightSiftConCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SDrugInFightSiftConCfg"))
/*     */         {
/*     */ 
/* 103 */           SDrugInFightSiftConCfg obj = new SDrugInFightSiftConCfg();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 117 */     all = new java.util.HashMap();
/*     */     
/* 119 */     String path = dir + "mzm.gsp.item.confbean.SDrugInFightSiftConCfg.bny";
/*     */     try
/*     */     {
/* 122 */       File file = new File(path);
/* 123 */       if (file.exists())
/*     */       {
/* 125 */         byte[] bytes = new byte['Ѐ'];
/* 126 */         FileInputStream fis = new FileInputStream(file);
/* 127 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 128 */         int len = 0;
/* 129 */         while ((len = fis.read(bytes)) > 0)
/* 130 */           baos.write(bytes, 0, len);
/* 131 */         fis.close();
/* 132 */         bytes = baos.toByteArray();
/* 133 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 134 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 136 */           _os_.unmarshal_int();
/* 137 */           _os_.unmarshal_int();
/* 138 */           _os_.unmarshal_int();
/*     */         }
/* 140 */         _os_.unmarshal_int();
/* 141 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 144 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 146 */           SDrugInFightSiftConCfg _v_ = new SDrugInFightSiftConCfg();
/* 147 */           _v_.unmarshal(_os_);
/* 148 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 149 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 154 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 159 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SDrugInFightSiftConCfg> all)
/*     */   {
/* 166 */     String path = dir + "mzm.gsp.item.confbean.SDrugInFightSiftConCfg.bny";
/*     */     try
/*     */     {
/* 169 */       File file = new File(path);
/* 170 */       if (file.exists())
/*     */       {
/* 172 */         byte[] bytes = new byte['Ѐ'];
/* 173 */         FileInputStream fis = new FileInputStream(file);
/* 174 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 175 */         int len = 0;
/* 176 */         while ((len = fis.read(bytes)) > 0)
/* 177 */           baos.write(bytes, 0, len);
/* 178 */         fis.close();
/* 179 */         bytes = baos.toByteArray();
/* 180 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 181 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 183 */           _os_.unmarshal_int();
/* 184 */           _os_.unmarshal_int();
/* 185 */           _os_.unmarshal_int();
/*     */         }
/* 187 */         _os_.unmarshal_int();
/* 188 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 191 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 193 */           SDrugInFightSiftConCfg _v_ = new SDrugInFightSiftConCfg();
/* 194 */           _v_.unmarshal(_os_);
/* 195 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 196 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 201 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 212 */     for (Map.Entry<Integer, SDrugInFightSiftConCfg> entry : all.entrySet())
/*     */     {
/* 214 */       if (SItemSiftConCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 216 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 220 */       SItemSiftConCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SDrugInFightSiftConCfg> all, Map<Integer, SItemSiftConCfg> parent)
/*     */   {
/* 227 */     for (Map.Entry<Integer, SDrugInFightSiftConCfg> entry : all.entrySet())
/*     */     {
/* 229 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 231 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 235 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SDrugInFightSiftConCfg getOld(int key)
/*     */   {
/* 242 */     return (SDrugInFightSiftConCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SDrugInFightSiftConCfg get(int key)
/*     */   {
/* 247 */     return (SDrugInFightSiftConCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDrugInFightSiftConCfg> getOldAllSelf()
/*     */   {
/* 252 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDrugInFightSiftConCfg> getAllSelf()
/*     */   {
/* 257 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SDrugInFightSiftConCfg> newAll)
/*     */   {
/* 262 */     oldAll = all;
/* 263 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 268 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SDrugInFightSiftConCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */