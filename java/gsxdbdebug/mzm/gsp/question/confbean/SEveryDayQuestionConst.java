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
/*     */ public class SEveryDayQuestionConst implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SEveryDayQuestionConst> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SEveryDayQuestionConst> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activityId;
/*     */   public int answerNumLimit;
/*     */   public int singleReward;
/*     */   public int doubleReward;
/*     */   public int tribleReward;
/*     */   public int wrongReward;
/*     */   public int callHelpLimit;
/*     */   public int joinMinLevel;
/*     */   public int extraRewardNeedAnswerNum;
/*     */   public int extraRewardPoolId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  34 */     this.answerNumLimit = Integer.valueOf(rootElement.attributeValue("answerNumLimit")).intValue();
/*  35 */     this.singleReward = Integer.valueOf(rootElement.attributeValue("singleReward")).intValue();
/*  36 */     this.doubleReward = Integer.valueOf(rootElement.attributeValue("doubleReward")).intValue();
/*  37 */     this.tribleReward = Integer.valueOf(rootElement.attributeValue("tribleReward")).intValue();
/*  38 */     this.wrongReward = Integer.valueOf(rootElement.attributeValue("wrongReward")).intValue();
/*  39 */     this.callHelpLimit = Integer.valueOf(rootElement.attributeValue("callHelpLimit")).intValue();
/*  40 */     this.joinMinLevel = Integer.valueOf(rootElement.attributeValue("joinMinLevel")).intValue();
/*  41 */     this.extraRewardNeedAnswerNum = Integer.valueOf(rootElement.attributeValue("extraRewardNeedAnswerNum")).intValue();
/*  42 */     this.extraRewardPoolId = Integer.valueOf(rootElement.attributeValue("extraRewardPoolId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.activityId);
/*  49 */     _os_.marshal(this.answerNumLimit);
/*  50 */     _os_.marshal(this.singleReward);
/*  51 */     _os_.marshal(this.doubleReward);
/*  52 */     _os_.marshal(this.tribleReward);
/*  53 */     _os_.marshal(this.wrongReward);
/*  54 */     _os_.marshal(this.callHelpLimit);
/*  55 */     _os_.marshal(this.joinMinLevel);
/*  56 */     _os_.marshal(this.extraRewardNeedAnswerNum);
/*  57 */     _os_.marshal(this.extraRewardPoolId);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.activityId = _os_.unmarshal_int();
/*  65 */     this.answerNumLimit = _os_.unmarshal_int();
/*  66 */     this.singleReward = _os_.unmarshal_int();
/*  67 */     this.doubleReward = _os_.unmarshal_int();
/*  68 */     this.tribleReward = _os_.unmarshal_int();
/*  69 */     this.wrongReward = _os_.unmarshal_int();
/*  70 */     this.callHelpLimit = _os_.unmarshal_int();
/*  71 */     this.joinMinLevel = _os_.unmarshal_int();
/*  72 */     this.extraRewardNeedAnswerNum = _os_.unmarshal_int();
/*  73 */     this.extraRewardPoolId = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.question.confbean.SEveryDayQuestionConst.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       all = new java.util.HashMap();
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element elem = (Element)nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.SEveryDayQuestionConst"))
/*     */         {
/*     */ 
/*  95 */           SEveryDayQuestionConst obj = new SEveryDayQuestionConst();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SEveryDayQuestionConst> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.question.confbean.SEveryDayQuestionConst.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.SEveryDayQuestionConst"))
/*     */         {
/*     */ 
/* 124 */           SEveryDayQuestionConst obj = new SEveryDayQuestionConst();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 138 */     all = new java.util.HashMap();
/*     */     
/* 140 */     String path = dir + "mzm.gsp.question.confbean.SEveryDayQuestionConst.bny";
/*     */     try
/*     */     {
/* 143 */       File file = new File(path);
/* 144 */       if (file.exists())
/*     */       {
/* 146 */         byte[] bytes = new byte['Ѐ'];
/* 147 */         FileInputStream fis = new FileInputStream(file);
/* 148 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 149 */         int len = 0;
/* 150 */         while ((len = fis.read(bytes)) > 0)
/* 151 */           baos.write(bytes, 0, len);
/* 152 */         fis.close();
/* 153 */         bytes = baos.toByteArray();
/* 154 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 155 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 157 */           _os_.unmarshal_int();
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/*     */         }
/* 161 */         _os_.unmarshal_int();
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 165 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 167 */           SEveryDayQuestionConst _v_ = new SEveryDayQuestionConst();
/* 168 */           _v_.unmarshal(_os_);
/* 169 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 175 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SEveryDayQuestionConst> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.question.confbean.SEveryDayQuestionConst.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SEveryDayQuestionConst _v_ = new SEveryDayQuestionConst();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SEveryDayQuestionConst getOld(int key)
/*     */   {
/* 235 */     return (SEveryDayQuestionConst)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SEveryDayQuestionConst get(int key)
/*     */   {
/* 240 */     return (SEveryDayQuestionConst)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEveryDayQuestionConst> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEveryDayQuestionConst> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SEveryDayQuestionConst> newAll)
/*     */   {
/* 255 */     oldAll = all;
/* 256 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 261 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\confbean\SEveryDayQuestionConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */