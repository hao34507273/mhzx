/*     */ package mzm.gsp.util.confbean;
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
/*     */ public class SModelColorTable implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SModelColorTable> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SModelColorTable> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int part1R;
/*     */   public int part1G;
/*     */   public int part1B;
/*     */   public int part1Light;
/*     */   public int part2R;
/*     */   public int part2G;
/*     */   public int part2B;
/*     */   public int part2Light;
/*     */   public int part3R;
/*     */   public int part3G;
/*     */   public int part3B;
/*     */   public int parg3Light;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.templatename = rootElement.attributeValue("templatename");
/*  37 */     this.part1R = Integer.valueOf(rootElement.attributeValue("part1R")).intValue();
/*  38 */     this.part1G = Integer.valueOf(rootElement.attributeValue("part1G")).intValue();
/*  39 */     this.part1B = Integer.valueOf(rootElement.attributeValue("part1B")).intValue();
/*  40 */     this.part1Light = Integer.valueOf(rootElement.attributeValue("part1Light")).intValue();
/*  41 */     this.part2R = Integer.valueOf(rootElement.attributeValue("part2R")).intValue();
/*  42 */     this.part2G = Integer.valueOf(rootElement.attributeValue("part2G")).intValue();
/*  43 */     this.part2B = Integer.valueOf(rootElement.attributeValue("part2B")).intValue();
/*  44 */     this.part2Light = Integer.valueOf(rootElement.attributeValue("part2Light")).intValue();
/*  45 */     this.part3R = Integer.valueOf(rootElement.attributeValue("part3R")).intValue();
/*  46 */     this.part3G = Integer.valueOf(rootElement.attributeValue("part3G")).intValue();
/*  47 */     this.part3B = Integer.valueOf(rootElement.attributeValue("part3B")).intValue();
/*  48 */     this.parg3Light = Integer.valueOf(rootElement.attributeValue("parg3Light")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.templatename, "UTF-8");
/*  55 */     _os_.marshal(this.part1R);
/*  56 */     _os_.marshal(this.part1G);
/*  57 */     _os_.marshal(this.part1B);
/*  58 */     _os_.marshal(this.part1Light);
/*  59 */     _os_.marshal(this.part2R);
/*  60 */     _os_.marshal(this.part2G);
/*  61 */     _os_.marshal(this.part2B);
/*  62 */     _os_.marshal(this.part2Light);
/*  63 */     _os_.marshal(this.part3R);
/*  64 */     _os_.marshal(this.part3G);
/*  65 */     _os_.marshal(this.part3B);
/*  66 */     _os_.marshal(this.parg3Light);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  74 */     this.part1R = _os_.unmarshal_int();
/*  75 */     this.part1G = _os_.unmarshal_int();
/*  76 */     this.part1B = _os_.unmarshal_int();
/*  77 */     this.part1Light = _os_.unmarshal_int();
/*  78 */     this.part2R = _os_.unmarshal_int();
/*  79 */     this.part2G = _os_.unmarshal_int();
/*  80 */     this.part2B = _os_.unmarshal_int();
/*  81 */     this.part2Light = _os_.unmarshal_int();
/*  82 */     this.part3R = _os_.unmarshal_int();
/*  83 */     this.part3G = _os_.unmarshal_int();
/*  84 */     this.part3B = _os_.unmarshal_int();
/*  85 */     this.parg3Light = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.util.confbean.SModelColorTable.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.util.confbean.SModelColorTable"))
/*     */         {
/*     */ 
/* 107 */           SModelColorTable obj = new SModelColorTable();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SModelColorTable> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.util.confbean.SModelColorTable.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.util.confbean.SModelColorTable"))
/*     */         {
/*     */ 
/* 136 */           SModelColorTable obj = new SModelColorTable();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.util.confbean.SModelColorTable.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           SModelColorTable _v_ = new SModelColorTable();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SModelColorTable> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.util.confbean.SModelColorTable.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           SModelColorTable _v_ = new SModelColorTable();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SModelColorTable getOld(int key)
/*     */   {
/* 247 */     return (SModelColorTable)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SModelColorTable get(int key)
/*     */   {
/* 252 */     return (SModelColorTable)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SModelColorTable> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SModelColorTable> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SModelColorTable> newAll)
/*     */   {
/* 267 */     oldAll = all;
/* 268 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 273 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\confbean\SModelColorTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */