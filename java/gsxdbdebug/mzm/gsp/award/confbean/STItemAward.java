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
/*     */ public class STItemAward implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STItemAward> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STItemAward> all = null;
/*     */   
/*     */   public int itemAwardId;
/*  19 */   public java.util.ArrayList<Integer> sAwardItemIds = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.itemAwardId = Integer.valueOf(rootElement.attributeValue("itemAwardId")).intValue();
/*     */     
/*  25 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "sAwardItemIds");
/*  26 */     if (collectionElement == null)
/*     */     {
/*  28 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  31 */     List<?> _nodeList = collectionElement.elements();
/*  32 */     int _len = _nodeList.size();
/*  33 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  35 */       Element elem = (Element)_nodeList.get(i);
/*  36 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  43 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  50 */         this.sAwardItemIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  57 */     _os_.marshal(this.itemAwardId);
/*  58 */     _os_.compact_uint32(this.sAwardItemIds.size());
/*  59 */     for (Integer _v_ : this.sAwardItemIds)
/*     */     {
/*  61 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     this.itemAwardId = _os_.unmarshal_int();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  72 */       int _v_ = _os_.unmarshal_int();
/*  73 */       this.sAwardItemIds.add(Integer.valueOf(_v_));
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  80 */     String path = dir + "mzm.gsp.award.confbean.STItemAward.xml";
/*     */     
/*     */     try
/*     */     {
/*  84 */       all = new java.util.HashMap();
/*  85 */       SAXReader reader = new SAXReader();
/*  86 */       org.dom4j.Document doc = reader.read(new File(path));
/*  87 */       Element root = doc.getRootElement();
/*  88 */       List<?> nodeList = root.elements();
/*  89 */       int len = nodeList.size();
/*  90 */       for (int i = 0; i < len; i++)
/*     */       {
/*  92 */         Element elem = (Element)nodeList.get(i);
/*  93 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STItemAward"))
/*     */         {
/*     */ 
/*  96 */           STItemAward obj = new STItemAward();
/*  97 */           obj.loadFromXml(elem);
/*  98 */           if (all.put(Integer.valueOf(obj.itemAwardId), obj) != null) {
/*  99 */             throw new RuntimeException("duplicate key : " + obj.itemAwardId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STItemAward> all)
/*     */   {
/* 110 */     String path = dir + "mzm.gsp.award.confbean.STItemAward.xml";
/*     */     
/*     */     try
/*     */     {
/* 114 */       SAXReader reader = new SAXReader();
/* 115 */       org.dom4j.Document doc = reader.read(new File(path));
/* 116 */       Element root = doc.getRootElement();
/* 117 */       List<?> nodeList = root.elements();
/* 118 */       int len = nodeList.size();
/* 119 */       for (int i = 0; i < len; i++)
/*     */       {
/* 121 */         Element elem = (Element)nodeList.get(i);
/* 122 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STItemAward"))
/*     */         {
/*     */ 
/* 125 */           STItemAward obj = new STItemAward();
/* 126 */           obj.loadFromXml(elem);
/* 127 */           if (all.put(Integer.valueOf(obj.itemAwardId), obj) != null) {
/* 128 */             throw new RuntimeException("duplicate key : " + obj.itemAwardId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 133 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 139 */     all = new java.util.HashMap();
/*     */     
/* 141 */     String path = dir + "mzm.gsp.award.confbean.STItemAward.bny";
/*     */     try
/*     */     {
/* 144 */       File file = new File(path);
/* 145 */       if (file.exists())
/*     */       {
/* 147 */         byte[] bytes = new byte['Ѐ'];
/* 148 */         FileInputStream fis = new FileInputStream(file);
/* 149 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 150 */         int len = 0;
/* 151 */         while ((len = fis.read(bytes)) > 0)
/* 152 */           baos.write(bytes, 0, len);
/* 153 */         fis.close();
/* 154 */         bytes = baos.toByteArray();
/* 155 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 156 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/* 160 */           _os_.unmarshal_int();
/*     */         }
/* 162 */         _os_.unmarshal_int();
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 166 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 168 */           STItemAward _v_ = new STItemAward();
/* 169 */           _v_.unmarshal(_os_);
/* 170 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 171 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 176 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 181 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STItemAward> all)
/*     */   {
/* 188 */     String path = dir + "mzm.gsp.award.confbean.STItemAward.bny";
/*     */     try
/*     */     {
/* 191 */       File file = new File(path);
/* 192 */       if (file.exists())
/*     */       {
/* 194 */         byte[] bytes = new byte['Ѐ'];
/* 195 */         FileInputStream fis = new FileInputStream(file);
/* 196 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 197 */         int len = 0;
/* 198 */         while ((len = fis.read(bytes)) > 0)
/* 199 */           baos.write(bytes, 0, len);
/* 200 */         fis.close();
/* 201 */         bytes = baos.toByteArray();
/* 202 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 203 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/* 207 */           _os_.unmarshal_int();
/*     */         }
/* 209 */         _os_.unmarshal_int();
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 213 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 215 */           STItemAward _v_ = new STItemAward();
/* 216 */           _v_.unmarshal(_os_);
/* 217 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 218 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 223 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 228 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STItemAward getOld(int key)
/*     */   {
/* 236 */     return (STItemAward)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STItemAward get(int key)
/*     */   {
/* 241 */     return (STItemAward)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STItemAward> getOldAll()
/*     */   {
/* 246 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STItemAward> getAll()
/*     */   {
/* 251 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STItemAward> newAll)
/*     */   {
/* 256 */     oldAll = all;
/* 257 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 262 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\STItemAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */