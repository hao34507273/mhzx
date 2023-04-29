/*     */ package mzm.gsp.question.confbean;
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
/*     */ public class SQYXTForceAnswerQuestionCheckCfg extends SQYXTQuestionCheckCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SQYXTForceAnswerQuestionCheckCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SQYXTForceAnswerQuestionCheckCfg> all = null;
/*     */   
/*     */   public int indexId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  24 */     this.questionLv = Integer.valueOf(rootElement.attributeValue("questionLv")).intValue();
/*  25 */     this.answerNum = Integer.valueOf(rootElement.attributeValue("answerNum")).intValue();
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
/*  55 */     this.indexId = Integer.valueOf(rootElement.attributeValue("indexId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _os_.marshal(this.id);
/*  61 */     _os_.marshal(this.questionLv);
/*  62 */     _os_.marshal(this.answerNum);
/*  63 */     _os_.compact_uint32(this.answerList.size());
/*  64 */     for (String _v_ : this.answerList)
/*     */     {
/*  66 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/*  68 */     _os_.marshal(this.indexId);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     this.id = _os_.unmarshal_int();
/*  75 */     this.questionLv = _os_.unmarshal_int();
/*  76 */     this.answerNum = _os_.unmarshal_int();
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  80 */       String _v_ = _os_.unmarshal_String("UTF-8");
/*  81 */       this.answerList.add(_v_);
/*     */     }
/*  83 */     this.indexId = _os_.unmarshal_int();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  89 */     String path = dir + "mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCheckCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  93 */       all = new java.util.HashMap();
/*  94 */       SAXReader reader = new SAXReader();
/*  95 */       org.dom4j.Document doc = reader.read(new File(path));
/*  96 */       Element root = doc.getRootElement();
/*  97 */       List<?> nodeList = root.elements();
/*  98 */       int len = nodeList.size();
/*  99 */       for (int i = 0; i < len; i++)
/*     */       {
/* 101 */         Element elem = (Element)nodeList.get(i);
/* 102 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCheckCfg"))
/*     */         {
/*     */ 
/* 105 */           SQYXTForceAnswerQuestionCheckCfg obj = new SQYXTForceAnswerQuestionCheckCfg();
/* 106 */           obj.loadFromXml(elem);
/* 107 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 108 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 113 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SQYXTForceAnswerQuestionCheckCfg> all)
/*     */   {
/* 119 */     String path = dir + "mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCheckCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 123 */       SAXReader reader = new SAXReader();
/* 124 */       org.dom4j.Document doc = reader.read(new File(path));
/* 125 */       Element root = doc.getRootElement();
/* 126 */       List<?> nodeList = root.elements();
/* 127 */       int len = nodeList.size();
/* 128 */       for (int i = 0; i < len; i++)
/*     */       {
/* 130 */         Element elem = (Element)nodeList.get(i);
/* 131 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCheckCfg"))
/*     */         {
/*     */ 
/* 134 */           SQYXTForceAnswerQuestionCheckCfg obj = new SQYXTForceAnswerQuestionCheckCfg();
/* 135 */           obj.loadFromXml(elem);
/* 136 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 137 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 142 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 148 */     all = new java.util.HashMap();
/*     */     
/* 150 */     String path = dir + "mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCheckCfg.bny";
/*     */     try
/*     */     {
/* 153 */       File file = new File(path);
/* 154 */       if (file.exists())
/*     */       {
/* 156 */         byte[] bytes = new byte['Ѐ'];
/* 157 */         FileInputStream fis = new FileInputStream(file);
/* 158 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 159 */         int len = 0;
/* 160 */         while ((len = fis.read(bytes)) > 0)
/* 161 */           baos.write(bytes, 0, len);
/* 162 */         fis.close();
/* 163 */         bytes = baos.toByteArray();
/* 164 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 165 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 167 */           _os_.unmarshal_int();
/* 168 */           _os_.unmarshal_int();
/* 169 */           _os_.unmarshal_int();
/*     */         }
/* 171 */         _os_.unmarshal_int();
/* 172 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 175 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 177 */           SQYXTForceAnswerQuestionCheckCfg _v_ = new SQYXTForceAnswerQuestionCheckCfg();
/* 178 */           _v_.unmarshal(_os_);
/* 179 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 180 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 185 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 190 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SQYXTForceAnswerQuestionCheckCfg> all)
/*     */   {
/* 197 */     String path = dir + "mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCheckCfg.bny";
/*     */     try
/*     */     {
/* 200 */       File file = new File(path);
/* 201 */       if (file.exists())
/*     */       {
/* 203 */         byte[] bytes = new byte['Ѐ'];
/* 204 */         FileInputStream fis = new FileInputStream(file);
/* 205 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 206 */         int len = 0;
/* 207 */         while ((len = fis.read(bytes)) > 0)
/* 208 */           baos.write(bytes, 0, len);
/* 209 */         fis.close();
/* 210 */         bytes = baos.toByteArray();
/* 211 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 212 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 214 */           _os_.unmarshal_int();
/* 215 */           _os_.unmarshal_int();
/* 216 */           _os_.unmarshal_int();
/*     */         }
/* 218 */         _os_.unmarshal_int();
/* 219 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 222 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 224 */           SQYXTForceAnswerQuestionCheckCfg _v_ = new SQYXTForceAnswerQuestionCheckCfg();
/* 225 */           _v_.unmarshal(_os_);
/* 226 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 227 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 232 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 237 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 243 */     for (Map.Entry<Integer, SQYXTForceAnswerQuestionCheckCfg> entry : all.entrySet())
/*     */     {
/* 245 */       if (SQYXTQuestionCheckCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 247 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 251 */       SQYXTQuestionCheckCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SQYXTForceAnswerQuestionCheckCfg> all, Map<Integer, SQYXTQuestionCheckCfg> parent)
/*     */   {
/* 258 */     for (Map.Entry<Integer, SQYXTForceAnswerQuestionCheckCfg> entry : all.entrySet())
/*     */     {
/* 260 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 262 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 266 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SQYXTForceAnswerQuestionCheckCfg getOld(int key)
/*     */   {
/* 273 */     return (SQYXTForceAnswerQuestionCheckCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SQYXTForceAnswerQuestionCheckCfg get(int key)
/*     */   {
/* 278 */     return (SQYXTForceAnswerQuestionCheckCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQYXTForceAnswerQuestionCheckCfg> getOldAllSelf()
/*     */   {
/* 283 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQYXTForceAnswerQuestionCheckCfg> getAllSelf()
/*     */   {
/* 288 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SQYXTForceAnswerQuestionCheckCfg> newAll)
/*     */   {
/* 293 */     oldAll = all;
/* 294 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 299 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\confbean\SQYXTForceAnswerQuestionCheckCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */