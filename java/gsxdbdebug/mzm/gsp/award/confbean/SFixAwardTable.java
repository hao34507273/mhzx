/*     */ package mzm.gsp.award.confbean;
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
/*     */ public class SFixAwardTable implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFixAwardTable> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFixAwardTable> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int awardId;
/*     */   public int occupationType;
/*     */   public int sexType;
/*     */   public int expAwardId;
/*     */   public int moneyAwardId;
/*     */   public int fixItemId;
/*     */   public int appellationId;
/*     */   public int titleId;
/*     */   public boolean activeGet;
/*     */   public int addModifyCnfId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.templatename = rootElement.attributeValue("templatename");
/*  35 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  36 */     this.occupationType = Integer.valueOf(rootElement.attributeValue("occupationType")).intValue();
/*  37 */     this.sexType = Integer.valueOf(rootElement.attributeValue("sexType")).intValue();
/*  38 */     this.expAwardId = Integer.valueOf(rootElement.attributeValue("expAwardId")).intValue();
/*  39 */     this.moneyAwardId = Integer.valueOf(rootElement.attributeValue("moneyAwardId")).intValue();
/*  40 */     this.fixItemId = Integer.valueOf(rootElement.attributeValue("fixItemId")).intValue();
/*  41 */     this.appellationId = Integer.valueOf(rootElement.attributeValue("appellationId")).intValue();
/*  42 */     this.titleId = Integer.valueOf(rootElement.attributeValue("titleId")).intValue();
/*  43 */     this.activeGet = Boolean.valueOf(rootElement.attributeValue("activeGet")).booleanValue();
/*  44 */     this.addModifyCnfId = Integer.valueOf(rootElement.attributeValue("addModifyCnfId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  49 */     _os_.marshal(this.id);
/*  50 */     _os_.marshal(this.templatename, "UTF-8");
/*  51 */     _os_.marshal(this.awardId);
/*  52 */     _os_.marshal(this.occupationType);
/*  53 */     _os_.marshal(this.sexType);
/*  54 */     _os_.marshal(this.expAwardId);
/*  55 */     _os_.marshal(this.moneyAwardId);
/*  56 */     _os_.marshal(this.fixItemId);
/*  57 */     _os_.marshal(this.appellationId);
/*  58 */     _os_.marshal(this.titleId);
/*  59 */     _os_.marshal(this.activeGet);
/*  60 */     _os_.marshal(this.addModifyCnfId);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  66 */     this.id = _os_.unmarshal_int();
/*  67 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  68 */     this.awardId = _os_.unmarshal_int();
/*  69 */     this.occupationType = _os_.unmarshal_int();
/*  70 */     this.sexType = _os_.unmarshal_int();
/*  71 */     this.expAwardId = _os_.unmarshal_int();
/*  72 */     this.moneyAwardId = _os_.unmarshal_int();
/*  73 */     this.fixItemId = _os_.unmarshal_int();
/*  74 */     this.appellationId = _os_.unmarshal_int();
/*  75 */     this.titleId = _os_.unmarshal_int();
/*  76 */     this.activeGet = _os_.unmarshal_boolean();
/*  77 */     this.addModifyCnfId = _os_.unmarshal_int();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  83 */     String path = dir + "mzm.gsp.award.confbean.SFixAwardTable.xml";
/*     */     
/*     */     try
/*     */     {
/*  87 */       all = new java.util.HashMap();
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       List<?> nodeList = root.elements();
/*  92 */       int len = nodeList.size();
/*  93 */       for (int i = 0; i < len; i++)
/*     */       {
/*  95 */         Element elem = (Element)nodeList.get(i);
/*  96 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SFixAwardTable"))
/*     */         {
/*     */ 
/*  99 */           SFixAwardTable obj = new SFixAwardTable();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SFixAwardTable> all)
/*     */   {
/* 113 */     String path = dir + "mzm.gsp.award.confbean.SFixAwardTable.xml";
/*     */     
/*     */     try
/*     */     {
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SFixAwardTable"))
/*     */         {
/*     */ 
/* 128 */           SFixAwardTable obj = new SFixAwardTable();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 142 */     all = new java.util.HashMap();
/*     */     
/* 144 */     String path = dir + "mzm.gsp.award.confbean.SFixAwardTable.bny";
/*     */     try
/*     */     {
/* 147 */       File file = new File(path);
/* 148 */       if (file.exists())
/*     */       {
/* 150 */         byte[] bytes = new byte['Ѐ'];
/* 151 */         FileInputStream fis = new FileInputStream(file);
/* 152 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 153 */         int len = 0;
/* 154 */         while ((len = fis.read(bytes)) > 0)
/* 155 */           baos.write(bytes, 0, len);
/* 156 */         fis.close();
/* 157 */         bytes = baos.toByteArray();
/* 158 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 159 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 161 */           _os_.unmarshal_int();
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/*     */         }
/* 165 */         _os_.unmarshal_int();
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 169 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 171 */           SFixAwardTable _v_ = new SFixAwardTable();
/* 172 */           _v_.unmarshal(_os_);
/* 173 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 179 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFixAwardTable> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.award.confbean.SFixAwardTable.bny";
/*     */     try
/*     */     {
/* 194 */       File file = new File(path);
/* 195 */       if (file.exists())
/*     */       {
/* 197 */         byte[] bytes = new byte['Ѐ'];
/* 198 */         FileInputStream fis = new FileInputStream(file);
/* 199 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 200 */         int len = 0;
/* 201 */         while ((len = fis.read(bytes)) > 0)
/* 202 */           baos.write(bytes, 0, len);
/* 203 */         fis.close();
/* 204 */         bytes = baos.toByteArray();
/* 205 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/*     */         }
/* 212 */         _os_.unmarshal_int();
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 216 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 218 */           SFixAwardTable _v_ = new SFixAwardTable();
/* 219 */           _v_.unmarshal(_os_);
/* 220 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 221 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 226 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFixAwardTable getOld(int key)
/*     */   {
/* 239 */     return (SFixAwardTable)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFixAwardTable get(int key)
/*     */   {
/* 244 */     return (SFixAwardTable)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFixAwardTable> getOldAll()
/*     */   {
/* 249 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFixAwardTable> getAll()
/*     */   {
/* 254 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFixAwardTable> newAll)
/*     */   {
/* 259 */     oldAll = all;
/* 260 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 265 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\SFixAwardTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */