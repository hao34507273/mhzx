/*     */ package mzm.gsp.questionvoice.confbean;
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
/*     */ public class SQuestionVoiceCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SQuestionVoiceCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SQuestionVoiceCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public int questionType;
/*  20 */   public java.util.ArrayList<String> answerList = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  25 */     this.questionType = Integer.valueOf(rootElement.attributeValue("questionType")).intValue();
/*     */     
/*  27 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "answerList");
/*  28 */     if (collectionElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> _nodeList = collectionElement.elements();
/*  34 */     int _len = _nodeList.size();
/*  35 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  37 */       Element elem = (Element)_nodeList.get(i);
/*  38 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  45 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  52 */         this.answerList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _os_.marshal(this.id);
/*  60 */     _os_.marshal(this.questionType);
/*  61 */     _os_.compact_uint32(this.answerList.size());
/*  62 */     for (String _v_ : this.answerList)
/*     */     {
/*  64 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  71 */     this.id = _os_.unmarshal_int();
/*  72 */     this.questionType = _os_.unmarshal_int();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  76 */       String _v_ = _os_.unmarshal_String("UTF-8");
/*  77 */       this.answerList.add(_v_);
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  84 */     String path = dir + "mzm.gsp.questionvoice.confbean.SQuestionVoiceCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/*  88 */       all = new java.util.HashMap();
/*  89 */       SAXReader reader = new SAXReader();
/*  90 */       org.dom4j.Document doc = reader.read(new File(path));
/*  91 */       Element root = doc.getRootElement();
/*  92 */       List<?> nodeList = root.elements();
/*  93 */       int len = nodeList.size();
/*  94 */       for (int i = 0; i < len; i++)
/*     */       {
/*  96 */         Element elem = (Element)nodeList.get(i);
/*  97 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.questionvoice.confbean.SQuestionVoiceCfgOriginal"))
/*     */         {
/*     */ 
/* 100 */           SQuestionVoiceCfgOriginal obj = new SQuestionVoiceCfgOriginal();
/* 101 */           obj.loadFromXml(elem);
/* 102 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 103 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SQuestionVoiceCfgOriginal> all)
/*     */   {
/* 114 */     String path = dir + "mzm.gsp.questionvoice.confbean.SQuestionVoiceCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 118 */       SAXReader reader = new SAXReader();
/* 119 */       org.dom4j.Document doc = reader.read(new File(path));
/* 120 */       Element root = doc.getRootElement();
/* 121 */       List<?> nodeList = root.elements();
/* 122 */       int len = nodeList.size();
/* 123 */       for (int i = 0; i < len; i++)
/*     */       {
/* 125 */         Element elem = (Element)nodeList.get(i);
/* 126 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.questionvoice.confbean.SQuestionVoiceCfgOriginal"))
/*     */         {
/*     */ 
/* 129 */           SQuestionVoiceCfgOriginal obj = new SQuestionVoiceCfgOriginal();
/* 130 */           obj.loadFromXml(elem);
/* 131 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 132 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 137 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 143 */     all = new java.util.HashMap();
/*     */     
/* 145 */     String path = dir + "mzm.gsp.questionvoice.confbean.SQuestionVoiceCfgOriginal.bny";
/*     */     try
/*     */     {
/* 148 */       File file = new File(path);
/* 149 */       if (file.exists())
/*     */       {
/* 151 */         byte[] bytes = new byte['Ѐ'];
/* 152 */         FileInputStream fis = new FileInputStream(file);
/* 153 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 154 */         int len = 0;
/* 155 */         while ((len = fis.read(bytes)) > 0)
/* 156 */           baos.write(bytes, 0, len);
/* 157 */         fis.close();
/* 158 */         bytes = baos.toByteArray();
/* 159 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 160 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/* 164 */           _os_.unmarshal_int();
/*     */         }
/* 166 */         _os_.unmarshal_int();
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 170 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 172 */           SQuestionVoiceCfgOriginal _v_ = new SQuestionVoiceCfgOriginal();
/* 173 */           _v_.unmarshal(_os_);
/* 174 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 175 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 180 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 185 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SQuestionVoiceCfgOriginal> all)
/*     */   {
/* 192 */     String path = dir + "mzm.gsp.questionvoice.confbean.SQuestionVoiceCfgOriginal.bny";
/*     */     try
/*     */     {
/* 195 */       File file = new File(path);
/* 196 */       if (file.exists())
/*     */       {
/* 198 */         byte[] bytes = new byte['Ѐ'];
/* 199 */         FileInputStream fis = new FileInputStream(file);
/* 200 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 201 */         int len = 0;
/* 202 */         while ((len = fis.read(bytes)) > 0)
/* 203 */           baos.write(bytes, 0, len);
/* 204 */         fis.close();
/* 205 */         bytes = baos.toByteArray();
/* 206 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 207 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/* 211 */           _os_.unmarshal_int();
/*     */         }
/* 213 */         _os_.unmarshal_int();
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 217 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 219 */           SQuestionVoiceCfgOriginal _v_ = new SQuestionVoiceCfgOriginal();
/* 220 */           _v_.unmarshal(_os_);
/* 221 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 222 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 227 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 232 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SQuestionVoiceCfgOriginal getOld(int key)
/*     */   {
/* 240 */     return (SQuestionVoiceCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SQuestionVoiceCfgOriginal get(int key)
/*     */   {
/* 245 */     return (SQuestionVoiceCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQuestionVoiceCfgOriginal> getOldAll()
/*     */   {
/* 250 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQuestionVoiceCfgOriginal> getAll()
/*     */   {
/* 255 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SQuestionVoiceCfgOriginal> newAll)
/*     */   {
/* 260 */     oldAll = all;
/* 261 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 266 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\confbean\SQuestionVoiceCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */