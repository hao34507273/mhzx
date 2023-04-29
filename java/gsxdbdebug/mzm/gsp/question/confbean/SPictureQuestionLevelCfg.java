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
/*     */ public class SPictureQuestionLevelCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPictureQuestionLevelCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPictureQuestionLevelCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int moveIntervalSec;
/*     */   public int moveCountLowLimit;
/*     */   public int moveCountHighLimit;
/*     */   public int moveMonsterCountPerTime;
/*     */   public int everyQuestionPersistTime;
/*     */   public int rightScore;
/*     */   public int wrongScore;
/*     */   public int passScore;
/*     */   public int helpCount;
/*     */   public int totalMonsterNum;
/*  29 */   public java.util.ArrayList<Integer> petTypeWeightTypeList = new java.util.ArrayList();
/*     */   public int questionNum;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.moveIntervalSec = Integer.valueOf(rootElement.attributeValue("moveIntervalSec")).intValue();
/*  36 */     this.moveCountLowLimit = Integer.valueOf(rootElement.attributeValue("moveCountLowLimit")).intValue();
/*  37 */     this.moveCountHighLimit = Integer.valueOf(rootElement.attributeValue("moveCountHighLimit")).intValue();
/*  38 */     this.moveMonsterCountPerTime = Integer.valueOf(rootElement.attributeValue("moveMonsterCountPerTime")).intValue();
/*  39 */     this.everyQuestionPersistTime = Integer.valueOf(rootElement.attributeValue("everyQuestionPersistTime")).intValue();
/*  40 */     this.rightScore = Integer.valueOf(rootElement.attributeValue("rightScore")).intValue();
/*  41 */     this.wrongScore = Integer.valueOf(rootElement.attributeValue("wrongScore")).intValue();
/*  42 */     this.passScore = Integer.valueOf(rootElement.attributeValue("passScore")).intValue();
/*  43 */     this.helpCount = Integer.valueOf(rootElement.attributeValue("helpCount")).intValue();
/*  44 */     this.totalMonsterNum = Integer.valueOf(rootElement.attributeValue("totalMonsterNum")).intValue();
/*     */     
/*  46 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "petTypeWeightTypeList");
/*  47 */     if (collectionElement == null)
/*     */     {
/*  49 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  52 */     List<?> _nodeList = collectionElement.elements();
/*  53 */     int _len = _nodeList.size();
/*  54 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  56 */       Element elem = (Element)_nodeList.get(i);
/*  57 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  64 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  71 */         this.petTypeWeightTypeList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  74 */     this.questionNum = Integer.valueOf(rootElement.attributeValue("questionNum")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _os_.marshal(this.id);
/*  80 */     _os_.marshal(this.moveIntervalSec);
/*  81 */     _os_.marshal(this.moveCountLowLimit);
/*  82 */     _os_.marshal(this.moveCountHighLimit);
/*  83 */     _os_.marshal(this.moveMonsterCountPerTime);
/*  84 */     _os_.marshal(this.everyQuestionPersistTime);
/*  85 */     _os_.marshal(this.rightScore);
/*  86 */     _os_.marshal(this.wrongScore);
/*  87 */     _os_.marshal(this.passScore);
/*  88 */     _os_.marshal(this.helpCount);
/*  89 */     _os_.marshal(this.totalMonsterNum);
/*  90 */     _os_.compact_uint32(this.petTypeWeightTypeList.size());
/*  91 */     for (Integer _v_ : this.petTypeWeightTypeList)
/*     */     {
/*  93 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  95 */     _os_.marshal(this.questionNum);
/*  96 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 101 */     this.id = _os_.unmarshal_int();
/* 102 */     this.moveIntervalSec = _os_.unmarshal_int();
/* 103 */     this.moveCountLowLimit = _os_.unmarshal_int();
/* 104 */     this.moveCountHighLimit = _os_.unmarshal_int();
/* 105 */     this.moveMonsterCountPerTime = _os_.unmarshal_int();
/* 106 */     this.everyQuestionPersistTime = _os_.unmarshal_int();
/* 107 */     this.rightScore = _os_.unmarshal_int();
/* 108 */     this.wrongScore = _os_.unmarshal_int();
/* 109 */     this.passScore = _os_.unmarshal_int();
/* 110 */     this.helpCount = _os_.unmarshal_int();
/* 111 */     this.totalMonsterNum = _os_.unmarshal_int();
/* 112 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 115 */       int _v_ = _os_.unmarshal_int();
/* 116 */       this.petTypeWeightTypeList.add(Integer.valueOf(_v_));
/*     */     }
/* 118 */     this.questionNum = _os_.unmarshal_int();
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 124 */     String path = dir + "mzm.gsp.question.confbean.SPictureQuestionLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 128 */       all = new java.util.HashMap();
/* 129 */       SAXReader reader = new SAXReader();
/* 130 */       org.dom4j.Document doc = reader.read(new File(path));
/* 131 */       Element root = doc.getRootElement();
/* 132 */       List<?> nodeList = root.elements();
/* 133 */       int len = nodeList.size();
/* 134 */       for (int i = 0; i < len; i++)
/*     */       {
/* 136 */         Element elem = (Element)nodeList.get(i);
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.SPictureQuestionLevelCfg"))
/*     */         {
/*     */ 
/* 140 */           SPictureQuestionLevelCfg obj = new SPictureQuestionLevelCfg();
/* 141 */           obj.loadFromXml(elem);
/* 142 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 143 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPictureQuestionLevelCfg> all)
/*     */   {
/* 154 */     String path = dir + "mzm.gsp.question.confbean.SPictureQuestionLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 158 */       SAXReader reader = new SAXReader();
/* 159 */       org.dom4j.Document doc = reader.read(new File(path));
/* 160 */       Element root = doc.getRootElement();
/* 161 */       List<?> nodeList = root.elements();
/* 162 */       int len = nodeList.size();
/* 163 */       for (int i = 0; i < len; i++)
/*     */       {
/* 165 */         Element elem = (Element)nodeList.get(i);
/* 166 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.question.confbean.SPictureQuestionLevelCfg"))
/*     */         {
/*     */ 
/* 169 */           SPictureQuestionLevelCfg obj = new SPictureQuestionLevelCfg();
/* 170 */           obj.loadFromXml(elem);
/* 171 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 172 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 177 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 183 */     all = new java.util.HashMap();
/*     */     
/* 185 */     String path = dir + "mzm.gsp.question.confbean.SPictureQuestionLevelCfg.bny";
/*     */     try
/*     */     {
/* 188 */       File file = new File(path);
/* 189 */       if (file.exists())
/*     */       {
/* 191 */         byte[] bytes = new byte['Ѐ'];
/* 192 */         FileInputStream fis = new FileInputStream(file);
/* 193 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 194 */         int len = 0;
/* 195 */         while ((len = fis.read(bytes)) > 0)
/* 196 */           baos.write(bytes, 0, len);
/* 197 */         fis.close();
/* 198 */         bytes = baos.toByteArray();
/* 199 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 200 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 202 */           _os_.unmarshal_int();
/* 203 */           _os_.unmarshal_int();
/* 204 */           _os_.unmarshal_int();
/*     */         }
/* 206 */         _os_.unmarshal_int();
/* 207 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 210 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 212 */           SPictureQuestionLevelCfg _v_ = new SPictureQuestionLevelCfg();
/* 213 */           _v_.unmarshal(_os_);
/* 214 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 215 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 220 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 225 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPictureQuestionLevelCfg> all)
/*     */   {
/* 232 */     String path = dir + "mzm.gsp.question.confbean.SPictureQuestionLevelCfg.bny";
/*     */     try
/*     */     {
/* 235 */       File file = new File(path);
/* 236 */       if (file.exists())
/*     */       {
/* 238 */         byte[] bytes = new byte['Ѐ'];
/* 239 */         FileInputStream fis = new FileInputStream(file);
/* 240 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 241 */         int len = 0;
/* 242 */         while ((len = fis.read(bytes)) > 0)
/* 243 */           baos.write(bytes, 0, len);
/* 244 */         fis.close();
/* 245 */         bytes = baos.toByteArray();
/* 246 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 247 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 249 */           _os_.unmarshal_int();
/* 250 */           _os_.unmarshal_int();
/* 251 */           _os_.unmarshal_int();
/*     */         }
/* 253 */         _os_.unmarshal_int();
/* 254 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 257 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 259 */           SPictureQuestionLevelCfg _v_ = new SPictureQuestionLevelCfg();
/* 260 */           _v_.unmarshal(_os_);
/* 261 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 262 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 267 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 272 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPictureQuestionLevelCfg getOld(int key)
/*     */   {
/* 280 */     return (SPictureQuestionLevelCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPictureQuestionLevelCfg get(int key)
/*     */   {
/* 285 */     return (SPictureQuestionLevelCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPictureQuestionLevelCfg> getOldAll()
/*     */   {
/* 290 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPictureQuestionLevelCfg> getAll()
/*     */   {
/* 295 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPictureQuestionLevelCfg> newAll)
/*     */   {
/* 300 */     oldAll = all;
/* 301 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 306 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\confbean\SPictureQuestionLevelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */