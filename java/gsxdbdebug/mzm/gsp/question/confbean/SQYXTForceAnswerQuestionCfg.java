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
/*     */ public class SQYXTForceAnswerQuestionCfg extends SQYXTQuestionCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SQYXTForceAnswerQuestionCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SQYXTForceAnswerQuestionCfg> all = null;
/*     */   
/*     */   public int indexId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  24 */     this.questionLv = Integer.valueOf(rootElement.attributeValue("questionLv")).intValue();
/*  25 */     this.answerNum = Integer.valueOf(rootElement.attributeValue("answerNum")).intValue();
/*  26 */     this.indexId = Integer.valueOf(rootElement.attributeValue("indexId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  31 */     _os_.marshal(this.id);
/*  32 */     _os_.marshal(this.questionLv);
/*  33 */     _os_.marshal(this.answerNum);
/*  34 */     _os_.marshal(this.indexId);
/*  35 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  40 */     this.id = _os_.unmarshal_int();
/*  41 */     this.questionLv = _os_.unmarshal_int();
/*  42 */     this.answerNum = _os_.unmarshal_int();
/*  43 */     this.indexId = _os_.unmarshal_int();
/*  44 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     String path = dir + "mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  53 */       all = new java.util.HashMap();
/*  54 */       SAXReader reader = new SAXReader();
/*  55 */       org.dom4j.Document doc = reader.read(new File(path));
/*  56 */       Element root = doc.getRootElement();
/*  57 */       List<?> nodeList = root.elements();
/*  58 */       int len = nodeList.size();
/*  59 */       for (int i = 0; i < len; i++)
/*     */       {
/*  61 */         Element elem = (Element)nodeList.get(i);
/*  62 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCfg"))
/*     */         {
/*     */ 
/*  65 */           SQYXTForceAnswerQuestionCfg obj = new SQYXTForceAnswerQuestionCfg();
/*  66 */           obj.loadFromXml(elem);
/*  67 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  68 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  73 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SQYXTForceAnswerQuestionCfg> all)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       SAXReader reader = new SAXReader();
/*  84 */       org.dom4j.Document doc = reader.read(new File(path));
/*  85 */       Element root = doc.getRootElement();
/*  86 */       List<?> nodeList = root.elements();
/*  87 */       int len = nodeList.size();
/*  88 */       for (int i = 0; i < len; i++)
/*     */       {
/*  90 */         Element elem = (Element)nodeList.get(i);
/*  91 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCfg"))
/*     */         {
/*     */ 
/*  94 */           SQYXTForceAnswerQuestionCfg obj = new SQYXTForceAnswerQuestionCfg();
/*  95 */           obj.loadFromXml(elem);
/*  96 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  97 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 102 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 108 */     all = new java.util.HashMap();
/*     */     
/* 110 */     String path = dir + "mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCfg.bny";
/*     */     try
/*     */     {
/* 113 */       File file = new File(path);
/* 114 */       if (file.exists())
/*     */       {
/* 116 */         byte[] bytes = new byte['Ѐ'];
/* 117 */         FileInputStream fis = new FileInputStream(file);
/* 118 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 119 */         int len = 0;
/* 120 */         while ((len = fis.read(bytes)) > 0)
/* 121 */           baos.write(bytes, 0, len);
/* 122 */         fis.close();
/* 123 */         bytes = baos.toByteArray();
/* 124 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 125 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 127 */           _os_.unmarshal_int();
/* 128 */           _os_.unmarshal_int();
/* 129 */           _os_.unmarshal_int();
/*     */         }
/* 131 */         _os_.unmarshal_int();
/* 132 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 135 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 137 */           SQYXTForceAnswerQuestionCfg _v_ = new SQYXTForceAnswerQuestionCfg();
/* 138 */           _v_.unmarshal(_os_);
/* 139 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 145 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 150 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SQYXTForceAnswerQuestionCfg> all)
/*     */   {
/* 157 */     String path = dir + "mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCfg.bny";
/*     */     try
/*     */     {
/* 160 */       File file = new File(path);
/* 161 */       if (file.exists())
/*     */       {
/* 163 */         byte[] bytes = new byte['Ѐ'];
/* 164 */         FileInputStream fis = new FileInputStream(file);
/* 165 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 166 */         int len = 0;
/* 167 */         while ((len = fis.read(bytes)) > 0)
/* 168 */           baos.write(bytes, 0, len);
/* 169 */         fis.close();
/* 170 */         bytes = baos.toByteArray();
/* 171 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 172 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/* 176 */           _os_.unmarshal_int();
/*     */         }
/* 178 */         _os_.unmarshal_int();
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 182 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 184 */           SQYXTForceAnswerQuestionCfg _v_ = new SQYXTForceAnswerQuestionCfg();
/* 185 */           _v_.unmarshal(_os_);
/* 186 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 187 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 192 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 197 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 203 */     for (Map.Entry<Integer, SQYXTForceAnswerQuestionCfg> entry : all.entrySet())
/*     */     {
/* 205 */       if (SQYXTQuestionCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 207 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 211 */       SQYXTQuestionCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SQYXTForceAnswerQuestionCfg> all, Map<Integer, SQYXTQuestionCfg> parent)
/*     */   {
/* 218 */     for (Map.Entry<Integer, SQYXTForceAnswerQuestionCfg> entry : all.entrySet())
/*     */     {
/* 220 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 222 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 226 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SQYXTForceAnswerQuestionCfg getOld(int key)
/*     */   {
/* 233 */     return (SQYXTForceAnswerQuestionCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SQYXTForceAnswerQuestionCfg get(int key)
/*     */   {
/* 238 */     return (SQYXTForceAnswerQuestionCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQYXTForceAnswerQuestionCfg> getOldAllSelf()
/*     */   {
/* 243 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQYXTForceAnswerQuestionCfg> getAllSelf()
/*     */   {
/* 248 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SQYXTForceAnswerQuestionCfg> newAll)
/*     */   {
/* 253 */     oldAll = all;
/* 254 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 259 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\confbean\SQYXTForceAnswerQuestionCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */