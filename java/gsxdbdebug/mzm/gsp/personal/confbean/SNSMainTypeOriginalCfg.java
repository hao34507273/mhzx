/*     */ package mzm.gsp.personal.confbean;
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
/*     */ public class SNSMainTypeOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SNSMainTypeOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SNSMainTypeOriginalCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String mainTypeName;
/*     */   public int sortId;
/*     */   public int subTypeId1;
/*     */   public int subTypeId2;
/*     */   public int subTypeId3;
/*     */   public int subTypeId4;
/*     */   public int subTypeId5;
/*     */   public int subTypeId6;
/*     */   public int subTypeId7;
/*     */   public int subTypeId8;
/*     */   public int subTypeId9;
/*     */   public int subTypeId10;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.mainTypeName = rootElement.attributeValue("mainTypeName");
/*  36 */     this.sortId = Integer.valueOf(rootElement.attributeValue("sortId")).intValue();
/*  37 */     this.subTypeId1 = Integer.valueOf(rootElement.attributeValue("subTypeId1")).intValue();
/*  38 */     this.subTypeId2 = Integer.valueOf(rootElement.attributeValue("subTypeId2")).intValue();
/*  39 */     this.subTypeId3 = Integer.valueOf(rootElement.attributeValue("subTypeId3")).intValue();
/*  40 */     this.subTypeId4 = Integer.valueOf(rootElement.attributeValue("subTypeId4")).intValue();
/*  41 */     this.subTypeId5 = Integer.valueOf(rootElement.attributeValue("subTypeId5")).intValue();
/*  42 */     this.subTypeId6 = Integer.valueOf(rootElement.attributeValue("subTypeId6")).intValue();
/*  43 */     this.subTypeId7 = Integer.valueOf(rootElement.attributeValue("subTypeId7")).intValue();
/*  44 */     this.subTypeId8 = Integer.valueOf(rootElement.attributeValue("subTypeId8")).intValue();
/*  45 */     this.subTypeId9 = Integer.valueOf(rootElement.attributeValue("subTypeId9")).intValue();
/*  46 */     this.subTypeId10 = Integer.valueOf(rootElement.attributeValue("subTypeId10")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.id);
/*  52 */     _os_.marshal(this.mainTypeName, "UTF-8");
/*  53 */     _os_.marshal(this.sortId);
/*  54 */     _os_.marshal(this.subTypeId1);
/*  55 */     _os_.marshal(this.subTypeId2);
/*  56 */     _os_.marshal(this.subTypeId3);
/*  57 */     _os_.marshal(this.subTypeId4);
/*  58 */     _os_.marshal(this.subTypeId5);
/*  59 */     _os_.marshal(this.subTypeId6);
/*  60 */     _os_.marshal(this.subTypeId7);
/*  61 */     _os_.marshal(this.subTypeId8);
/*  62 */     _os_.marshal(this.subTypeId9);
/*  63 */     _os_.marshal(this.subTypeId10);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.mainTypeName = _os_.unmarshal_String("UTF-8");
/*  71 */     this.sortId = _os_.unmarshal_int();
/*  72 */     this.subTypeId1 = _os_.unmarshal_int();
/*  73 */     this.subTypeId2 = _os_.unmarshal_int();
/*  74 */     this.subTypeId3 = _os_.unmarshal_int();
/*  75 */     this.subTypeId4 = _os_.unmarshal_int();
/*  76 */     this.subTypeId5 = _os_.unmarshal_int();
/*  77 */     this.subTypeId6 = _os_.unmarshal_int();
/*  78 */     this.subTypeId7 = _os_.unmarshal_int();
/*  79 */     this.subTypeId8 = _os_.unmarshal_int();
/*  80 */     this.subTypeId9 = _os_.unmarshal_int();
/*  81 */     this.subTypeId10 = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.personal.confbean.SNSMainTypeOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  91 */       all = new java.util.HashMap();
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.personal.confbean.SNSMainTypeOriginalCfg"))
/*     */         {
/*     */ 
/* 103 */           SNSMainTypeOriginalCfg obj = new SNSMainTypeOriginalCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SNSMainTypeOriginalCfg> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.personal.confbean.SNSMainTypeOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.personal.confbean.SNSMainTypeOriginalCfg"))
/*     */         {
/*     */ 
/* 132 */           SNSMainTypeOriginalCfg obj = new SNSMainTypeOriginalCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 146 */     all = new java.util.HashMap();
/*     */     
/* 148 */     String path = dir + "mzm.gsp.personal.confbean.SNSMainTypeOriginalCfg.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/*     */         }
/* 169 */         _os_.unmarshal_int();
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 173 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 175 */           SNSMainTypeOriginalCfg _v_ = new SNSMainTypeOriginalCfg();
/* 176 */           _v_.unmarshal(_os_);
/* 177 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 183 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SNSMainTypeOriginalCfg> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.personal.confbean.SNSMainTypeOriginalCfg.bny";
/*     */     try
/*     */     {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists())
/*     */       {
/* 201 */         byte[] bytes = new byte['Ѐ'];
/* 202 */         FileInputStream fis = new FileInputStream(file);
/* 203 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 204 */         int len = 0;
/* 205 */         while ((len = fis.read(bytes)) > 0)
/* 206 */           baos.write(bytes, 0, len);
/* 207 */         fis.close();
/* 208 */         bytes = baos.toByteArray();
/* 209 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/*     */         }
/* 216 */         _os_.unmarshal_int();
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 220 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 222 */           SNSMainTypeOriginalCfg _v_ = new SNSMainTypeOriginalCfg();
/* 223 */           _v_.unmarshal(_os_);
/* 224 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 230 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 235 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SNSMainTypeOriginalCfg getOld(int key)
/*     */   {
/* 243 */     return (SNSMainTypeOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SNSMainTypeOriginalCfg get(int key)
/*     */   {
/* 248 */     return (SNSMainTypeOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNSMainTypeOriginalCfg> getOldAll()
/*     */   {
/* 253 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNSMainTypeOriginalCfg> getAll()
/*     */   {
/* 258 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SNSMainTypeOriginalCfg> newAll)
/*     */   {
/* 263 */     oldAll = all;
/* 264 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 269 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\confbean\SNSMainTypeOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */