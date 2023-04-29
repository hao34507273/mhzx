/*     */ package mzm.gsp.bigboss.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SBigboss implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBigboss> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBigboss> all = null;
/*     */   
/*     */   public int sort;
/*     */   public int id;
/*     */   public int fightId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.fightId = Integer.valueOf(rootElement.attributeValue("fightId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  31 */     _os_.marshal(this.sort);
/*  32 */     _os_.marshal(this.id);
/*  33 */     _os_.marshal(this.fightId);
/*  34 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  39 */     this.sort = _os_.unmarshal_int();
/*  40 */     this.id = _os_.unmarshal_int();
/*  41 */     this.fightId = _os_.unmarshal_int();
/*  42 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  47 */     String path = dir + "mzm.gsp.bigboss.confbean.SBigboss.xml";
/*     */     
/*     */     try
/*     */     {
/*  51 */       all = new java.util.TreeMap();
/*  52 */       SAXReader reader = new SAXReader();
/*  53 */       org.dom4j.Document doc = reader.read(new File(path));
/*  54 */       Element root = doc.getRootElement();
/*  55 */       List<?> nodeList = root.elements();
/*  56 */       int len = nodeList.size();
/*  57 */       for (int i = 0; i < len; i++)
/*     */       {
/*  59 */         Element elem = (Element)nodeList.get(i);
/*  60 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.bigboss.confbean.SBigboss"))
/*     */         {
/*     */ 
/*  63 */           SBigboss obj = new SBigboss();
/*  64 */           obj.loadFromXml(elem);
/*  65 */           if (all.put(Integer.valueOf(obj.sort), obj) != null) {
/*  66 */             throw new RuntimeException("duplicate key : " + obj.sort);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  71 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBigboss> all)
/*     */   {
/*  77 */     String path = dir + "mzm.gsp.bigboss.confbean.SBigboss.xml";
/*     */     
/*     */     try
/*     */     {
/*  81 */       SAXReader reader = new SAXReader();
/*  82 */       org.dom4j.Document doc = reader.read(new File(path));
/*  83 */       Element root = doc.getRootElement();
/*  84 */       List<?> nodeList = root.elements();
/*  85 */       int len = nodeList.size();
/*  86 */       for (int i = 0; i < len; i++)
/*     */       {
/*  88 */         Element elem = (Element)nodeList.get(i);
/*  89 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.bigboss.confbean.SBigboss"))
/*     */         {
/*     */ 
/*  92 */           SBigboss obj = new SBigboss();
/*  93 */           obj.loadFromXml(elem);
/*  94 */           if (all.put(Integer.valueOf(obj.sort), obj) != null) {
/*  95 */             throw new RuntimeException("duplicate key : " + obj.sort);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 100 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 106 */     all = new java.util.TreeMap();
/*     */     
/* 108 */     String path = dir + "mzm.gsp.bigboss.confbean.SBigboss.bny";
/*     */     try
/*     */     {
/* 111 */       File file = new File(path);
/* 112 */       if (file.exists())
/*     */       {
/* 114 */         byte[] bytes = new byte['Ѐ'];
/* 115 */         FileInputStream fis = new FileInputStream(file);
/* 116 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 117 */         int len = 0;
/* 118 */         while ((len = fis.read(bytes)) > 0)
/* 119 */           baos.write(bytes, 0, len);
/* 120 */         fis.close();
/* 121 */         bytes = baos.toByteArray();
/* 122 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 123 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 125 */           _os_.unmarshal_int();
/* 126 */           _os_.unmarshal_int();
/* 127 */           _os_.unmarshal_int();
/*     */         }
/* 129 */         _os_.unmarshal_int();
/* 130 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 133 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 135 */           SBigboss _v_ = new SBigboss();
/* 136 */           _v_.unmarshal(_os_);
/* 137 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 138 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 143 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBigboss> all)
/*     */   {
/* 155 */     String path = dir + "mzm.gsp.bigboss.confbean.SBigboss.bny";
/*     */     try
/*     */     {
/* 158 */       File file = new File(path);
/* 159 */       if (file.exists())
/*     */       {
/* 161 */         byte[] bytes = new byte['Ѐ'];
/* 162 */         FileInputStream fis = new FileInputStream(file);
/* 163 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 164 */         int len = 0;
/* 165 */         while ((len = fis.read(bytes)) > 0)
/* 166 */           baos.write(bytes, 0, len);
/* 167 */         fis.close();
/* 168 */         bytes = baos.toByteArray();
/* 169 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 172 */           _os_.unmarshal_int();
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/*     */         }
/* 176 */         _os_.unmarshal_int();
/* 177 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 180 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 182 */           SBigboss _v_ = new SBigboss();
/* 183 */           _v_.unmarshal(_os_);
/* 184 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 190 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 195 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBigboss getOld(int key)
/*     */   {
/* 203 */     return (SBigboss)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBigboss get(int key)
/*     */   {
/* 208 */     return (SBigboss)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBigboss> getOldAll()
/*     */   {
/* 213 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBigboss> getAll()
/*     */   {
/* 218 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBigboss> newAll)
/*     */   {
/* 223 */     oldAll = all;
/* 224 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 229 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\confbean\SBigboss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */