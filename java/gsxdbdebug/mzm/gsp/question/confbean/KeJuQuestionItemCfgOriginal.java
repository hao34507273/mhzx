/*     */ package mzm.gsp.question.confbean;
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
/*     */ public class KeJuQuestionItemCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, KeJuQuestionItemCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, KeJuQuestionItemCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int questionLv;
/*  21 */   public java.util.ArrayList<String> answerList = new java.util.ArrayList();
/*     */   public int useTimeYear;
/*     */   public int useTimeMonth;
/*     */   public int useTimeDay;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.templatename = rootElement.attributeValue("templatename");
/*  30 */     this.questionLv = Integer.valueOf(rootElement.attributeValue("questionLv")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "answerList");
/*  33 */     if (collectionElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> _nodeList = collectionElement.elements();
/*  39 */     int _len = _nodeList.size();
/*  40 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  42 */       Element elem = (Element)_nodeList.get(i);
/*  43 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  57 */         this.answerList.add(_v_);
/*     */       }
/*     */     }
/*  60 */     this.useTimeYear = Integer.valueOf(rootElement.attributeValue("useTimeYear")).intValue();
/*  61 */     this.useTimeMonth = Integer.valueOf(rootElement.attributeValue("useTimeMonth")).intValue();
/*  62 */     this.useTimeDay = Integer.valueOf(rootElement.attributeValue("useTimeDay")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _os_.marshal(this.id);
/*  68 */     _os_.marshal(this.templatename, "UTF-8");
/*  69 */     _os_.marshal(this.questionLv);
/*  70 */     _os_.compact_uint32(this.answerList.size());
/*  71 */     for (String _v_ : this.answerList)
/*     */     {
/*  73 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/*  75 */     _os_.marshal(this.useTimeYear);
/*  76 */     _os_.marshal(this.useTimeMonth);
/*  77 */     _os_.marshal(this.useTimeDay);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     this.id = _os_.unmarshal_int();
/*  84 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  85 */     this.questionLv = _os_.unmarshal_int();
/*  86 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  89 */       String _v_ = _os_.unmarshal_String("UTF-8");
/*  90 */       this.answerList.add(_v_);
/*     */     }
/*  92 */     this.useTimeYear = _os_.unmarshal_int();
/*  93 */     this.useTimeMonth = _os_.unmarshal_int();
/*  94 */     this.useTimeDay = _os_.unmarshal_int();
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 100 */     String path = dir + "mzm.gsp.question.confbean.KeJuQuestionItemCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 104 */       all = new java.util.HashMap();
/* 105 */       SAXReader reader = new SAXReader();
/* 106 */       org.dom4j.Document doc = reader.read(new File(path));
/* 107 */       Element root = doc.getRootElement();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element elem = (Element)nodeList.get(i);
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.KeJuQuestionItemCfgOriginal"))
/*     */         {
/*     */ 
/* 116 */           KeJuQuestionItemCfgOriginal obj = new KeJuQuestionItemCfgOriginal();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, KeJuQuestionItemCfgOriginal> all)
/*     */   {
/* 130 */     String path = dir + "mzm.gsp.question.confbean.KeJuQuestionItemCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 134 */       SAXReader reader = new SAXReader();
/* 135 */       org.dom4j.Document doc = reader.read(new File(path));
/* 136 */       Element root = doc.getRootElement();
/* 137 */       List<?> nodeList = root.elements();
/* 138 */       int len = nodeList.size();
/* 139 */       for (int i = 0; i < len; i++)
/*     */       {
/* 141 */         Element elem = (Element)nodeList.get(i);
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.KeJuQuestionItemCfgOriginal"))
/*     */         {
/*     */ 
/* 145 */           KeJuQuestionItemCfgOriginal obj = new KeJuQuestionItemCfgOriginal();
/* 146 */           obj.loadFromXml(elem);
/* 147 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 148 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 159 */     all = new java.util.HashMap();
/*     */     
/* 161 */     String path = dir + "mzm.gsp.question.confbean.KeJuQuestionItemCfgOriginal.bny";
/*     */     try
/*     */     {
/* 164 */       File file = new File(path);
/* 165 */       if (file.exists())
/*     */       {
/* 167 */         byte[] bytes = new byte['Ѐ'];
/* 168 */         FileInputStream fis = new FileInputStream(file);
/* 169 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 170 */         int len = 0;
/* 171 */         while ((len = fis.read(bytes)) > 0)
/* 172 */           baos.write(bytes, 0, len);
/* 173 */         fis.close();
/* 174 */         bytes = baos.toByteArray();
/* 175 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 176 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/* 180 */           _os_.unmarshal_int();
/*     */         }
/* 182 */         _os_.unmarshal_int();
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 186 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 188 */           KeJuQuestionItemCfgOriginal _v_ = new KeJuQuestionItemCfgOriginal();
/* 189 */           _v_.unmarshal(_os_);
/* 190 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 191 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 196 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, KeJuQuestionItemCfgOriginal> all)
/*     */   {
/* 208 */     String path = dir + "mzm.gsp.question.confbean.KeJuQuestionItemCfgOriginal.bny";
/*     */     try
/*     */     {
/* 211 */       File file = new File(path);
/* 212 */       if (file.exists())
/*     */       {
/* 214 */         byte[] bytes = new byte['Ѐ'];
/* 215 */         FileInputStream fis = new FileInputStream(file);
/* 216 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 217 */         int len = 0;
/* 218 */         while ((len = fis.read(bytes)) > 0)
/* 219 */           baos.write(bytes, 0, len);
/* 220 */         fis.close();
/* 221 */         bytes = baos.toByteArray();
/* 222 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 223 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/* 227 */           _os_.unmarshal_int();
/*     */         }
/* 229 */         _os_.unmarshal_int();
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 233 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 235 */           KeJuQuestionItemCfgOriginal _v_ = new KeJuQuestionItemCfgOriginal();
/* 236 */           _v_.unmarshal(_os_);
/* 237 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 238 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 243 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 248 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static KeJuQuestionItemCfgOriginal getOld(int key)
/*     */   {
/* 256 */     return (KeJuQuestionItemCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static KeJuQuestionItemCfgOriginal get(int key)
/*     */   {
/* 261 */     return (KeJuQuestionItemCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, KeJuQuestionItemCfgOriginal> getOldAll()
/*     */   {
/* 266 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, KeJuQuestionItemCfgOriginal> getAll()
/*     */   {
/* 271 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, KeJuQuestionItemCfgOriginal> newAll)
/*     */   {
/* 276 */     oldAll = all;
/* 277 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 282 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\confbean\KeJuQuestionItemCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */