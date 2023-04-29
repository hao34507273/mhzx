/*     */ package mzm.gsp.zhenfa.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SZhenfaCfgConsts
/*     */ {
/*  13 */   private static volatile SZhenfaCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SZhenfaCfgConsts instance = new SZhenfaCfgConsts();
/*     */   
/*     */ 
/*     */   public int INIT_LEVEL;
/*     */   
/*     */ 
/*     */   public static SZhenfaCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SZhenfaCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*  32 */   public java.util.ArrayList<Integer> UpLevel2NeedExp = new java.util.ArrayList();
/*     */   public int MAX_LEVEL;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  37 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  42 */     String path = dir + "mzm.gsp.zhenfa.confbean.SZhenfaCfgConsts.xml";
/*     */     try
/*     */     {
/*  45 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  46 */       org.dom4j.Document doc = reader.read(new File(path));
/*  47 */       Element root = doc.getRootElement();
/*  48 */       Map<String, Element> data = new java.util.HashMap();
/*  49 */       List<?> nodeList = root.elements();
/*  50 */       int len = nodeList.size();
/*  51 */       for (int i = 0; i < len; i++)
/*     */       {
/*  53 */         Element element = (Element)nodeList.get(i);
/*  54 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  57 */           String name = element.attributeValue("name");
/*  58 */           if (data.put(name, element) != null)
/*  59 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  62 */       this.INIT_LEVEL = Integer.valueOf(((Element)data.get("INIT_LEVEL")).attributeValue("value")).intValue();
/*     */       
/*  64 */       Element collectionElement = (Element)data.get("UpLevel2NeedExp");
/*  65 */       if (collectionElement == null)
/*     */       {
/*  67 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/*  70 */       List<?> _nodeList = collectionElement.elements();
/*  71 */       int _len = _nodeList.size();
/*  72 */       for (int i = 0; i < _len; i++)
/*     */       {
/*  74 */         Element elem = (Element)_nodeList.get(i);
/*  75 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/*  82 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/*  89 */           this.UpLevel2NeedExp.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*  92 */       this.MAX_LEVEL = Integer.valueOf(((Element)data.get("MAX_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  96 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 101 */     String path = dir + "mzm.gsp.zhenfa.confbean.SZhenfaCfgConsts.xml";
/*     */     try
/*     */     {
/* 104 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       Map<String, Element> data = new java.util.HashMap();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element element = (Element)nodeList.get(i);
/* 113 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 116 */           String name = element.attributeValue("name");
/* 117 */           if (data.put(name, element) != null)
/* 118 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 121 */       this.INIT_LEVEL = Integer.valueOf(((Element)data.get("INIT_LEVEL")).attributeValue("value")).intValue();
/*     */       
/* 123 */       Element collectionElement = (Element)data.get("UpLevel2NeedExp");
/* 124 */       if (collectionElement == null)
/*     */       {
/* 126 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 129 */       List<?> _nodeList = collectionElement.elements();
/* 130 */       int _len = _nodeList.size();
/* 131 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 133 */         Element elem = (Element)_nodeList.get(i);
/* 134 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 141 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 148 */           this.UpLevel2NeedExp.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 151 */       this.MAX_LEVEL = Integer.valueOf(((Element)data.get("MAX_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 155 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 159 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 162 */     String path = dir + "mzm.gsp.zhenfa.confbean.SZhenfaCfgConsts.bny";
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
/* 177 */         this.INIT_LEVEL = _os_.unmarshal_int();
/* 178 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 181 */           int _v_ = _os_.unmarshal_int();
/* 182 */           this.UpLevel2NeedExp.add(Integer.valueOf(_v_));
/*     */         }
/* 184 */         this.MAX_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 189 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.zhenfa.confbean.SZhenfaCfgConsts.bny";
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
/* 210 */         this.INIT_LEVEL = _os_.unmarshal_int();
/* 211 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 214 */           int _v_ = _os_.unmarshal_int();
/* 215 */           this.UpLevel2NeedExp.add(Integer.valueOf(_v_));
/*     */         }
/* 217 */         this.MAX_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 222 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SZhenfaCfgConsts newInstance)
/*     */   {
/* 228 */     oldInstance = instance;
/* 229 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 234 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\confbean\SZhenfaCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */