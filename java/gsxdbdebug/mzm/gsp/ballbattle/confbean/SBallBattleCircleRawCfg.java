/*     */ package mzm.gsp.ballbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SBallBattleCircleRawCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBallBattleCircleRawCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBallBattleCircleRawCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int circleModelId;
/*     */   public int circleModelRawRadius;
/*     */   public int circleModelR;
/*     */   public int circleModelG;
/*     */   public int circleModelB;
/*     */   public int circleModelA;
/*     */   public int circleCenterX;
/*     */   public int circleCenterY;
/*     */   public int initRadius;
/*     */   public int initGeneItemNumber;
/*     */   public int totalReduceTimes;
/*  30 */   public ArrayList<Integer> circleRadii = new ArrayList();
/*  31 */   public ArrayList<Integer> circleReduceSeconds = new ArrayList();
/*  32 */   public ArrayList<Integer> geneItemNumbers = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.circleModelId = Integer.valueOf(rootElement.attributeValue("circleModelId")).intValue();
/*  38 */     this.circleModelRawRadius = Integer.valueOf(rootElement.attributeValue("circleModelRawRadius")).intValue();
/*  39 */     this.circleModelR = Integer.valueOf(rootElement.attributeValue("circleModelR")).intValue();
/*  40 */     this.circleModelG = Integer.valueOf(rootElement.attributeValue("circleModelG")).intValue();
/*  41 */     this.circleModelB = Integer.valueOf(rootElement.attributeValue("circleModelB")).intValue();
/*  42 */     this.circleModelA = Integer.valueOf(rootElement.attributeValue("circleModelA")).intValue();
/*  43 */     this.circleCenterX = Integer.valueOf(rootElement.attributeValue("circleCenterX")).intValue();
/*  44 */     this.circleCenterY = Integer.valueOf(rootElement.attributeValue("circleCenterY")).intValue();
/*  45 */     this.initRadius = Integer.valueOf(rootElement.attributeValue("initRadius")).intValue();
/*  46 */     this.initGeneItemNumber = Integer.valueOf(rootElement.attributeValue("initGeneItemNumber")).intValue();
/*  47 */     this.totalReduceTimes = Integer.valueOf(rootElement.attributeValue("totalReduceTimes")).intValue();
/*     */     
/*  49 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "circleRadii");
/*  50 */     if (collectionElement == null)
/*     */     {
/*  52 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  55 */     List<?> _nodeList = collectionElement.elements();
/*  56 */     int _len = _nodeList.size();
/*  57 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  59 */       Element elem = (Element)_nodeList.get(i);
/*  60 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  67 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  74 */         this.circleRadii.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  78 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "circleReduceSeconds");
/*  79 */     if (collectionElement == null)
/*     */     {
/*  81 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  84 */     List<?> _nodeList = collectionElement.elements();
/*  85 */     int _len = _nodeList.size();
/*  86 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  88 */       Element elem = (Element)_nodeList.get(i);
/*  89 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  96 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 103 */         this.circleReduceSeconds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 107 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "geneItemNumbers");
/* 108 */     if (collectionElement == null)
/*     */     {
/* 110 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 113 */     List<?> _nodeList = collectionElement.elements();
/* 114 */     int _len = _nodeList.size();
/* 115 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 117 */       Element elem = (Element)_nodeList.get(i);
/* 118 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 125 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 132 */         this.geneItemNumbers.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 139 */     _os_.marshal(this.id);
/* 140 */     _os_.marshal(this.circleModelId);
/* 141 */     _os_.marshal(this.circleModelRawRadius);
/* 142 */     _os_.marshal(this.circleModelR);
/* 143 */     _os_.marshal(this.circleModelG);
/* 144 */     _os_.marshal(this.circleModelB);
/* 145 */     _os_.marshal(this.circleModelA);
/* 146 */     _os_.marshal(this.circleCenterX);
/* 147 */     _os_.marshal(this.circleCenterY);
/* 148 */     _os_.marshal(this.initRadius);
/* 149 */     _os_.marshal(this.initGeneItemNumber);
/* 150 */     _os_.marshal(this.totalReduceTimes);
/* 151 */     _os_.compact_uint32(this.circleRadii.size());
/* 152 */     for (Integer _v_ : this.circleRadii)
/*     */     {
/* 154 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 156 */     _os_.compact_uint32(this.circleReduceSeconds.size());
/* 157 */     for (Integer _v_ : this.circleReduceSeconds)
/*     */     {
/* 159 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 161 */     _os_.compact_uint32(this.geneItemNumbers.size());
/* 162 */     for (Integer _v_ : this.geneItemNumbers)
/*     */     {
/* 164 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 166 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 171 */     this.id = _os_.unmarshal_int();
/* 172 */     this.circleModelId = _os_.unmarshal_int();
/* 173 */     this.circleModelRawRadius = _os_.unmarshal_int();
/* 174 */     this.circleModelR = _os_.unmarshal_int();
/* 175 */     this.circleModelG = _os_.unmarshal_int();
/* 176 */     this.circleModelB = _os_.unmarshal_int();
/* 177 */     this.circleModelA = _os_.unmarshal_int();
/* 178 */     this.circleCenterX = _os_.unmarshal_int();
/* 179 */     this.circleCenterY = _os_.unmarshal_int();
/* 180 */     this.initRadius = _os_.unmarshal_int();
/* 181 */     this.initGeneItemNumber = _os_.unmarshal_int();
/* 182 */     this.totalReduceTimes = _os_.unmarshal_int();
/* 183 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 186 */       int _v_ = _os_.unmarshal_int();
/* 187 */       this.circleRadii.add(Integer.valueOf(_v_));
/*     */     }
/* 189 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 192 */       int _v_ = _os_.unmarshal_int();
/* 193 */       this.circleReduceSeconds.add(Integer.valueOf(_v_));
/*     */     }
/* 195 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 198 */       int _v_ = _os_.unmarshal_int();
/* 199 */       this.geneItemNumbers.add(Integer.valueOf(_v_));
/*     */     }
/* 201 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 206 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleCircleRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 210 */       all = new java.util.HashMap();
/* 211 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 212 */       org.dom4j.Document doc = reader.read(new File(path));
/* 213 */       Element root = doc.getRootElement();
/* 214 */       List<?> nodeList = root.elements();
/* 215 */       int len = nodeList.size();
/* 216 */       for (int i = 0; i < len; i++)
/*     */       {
/* 218 */         Element elem = (Element)nodeList.get(i);
/* 219 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ballbattle.confbean.SBallBattleCircleRawCfg"))
/*     */         {
/*     */ 
/* 222 */           SBallBattleCircleRawCfg obj = new SBallBattleCircleRawCfg();
/* 223 */           obj.loadFromXml(elem);
/* 224 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 230 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBallBattleCircleRawCfg> all)
/*     */   {
/* 236 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleCircleRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 240 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 241 */       org.dom4j.Document doc = reader.read(new File(path));
/* 242 */       Element root = doc.getRootElement();
/* 243 */       List<?> nodeList = root.elements();
/* 244 */       int len = nodeList.size();
/* 245 */       for (int i = 0; i < len; i++)
/*     */       {
/* 247 */         Element elem = (Element)nodeList.get(i);
/* 248 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ballbattle.confbean.SBallBattleCircleRawCfg"))
/*     */         {
/*     */ 
/* 251 */           SBallBattleCircleRawCfg obj = new SBallBattleCircleRawCfg();
/* 252 */           obj.loadFromXml(elem);
/* 253 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 254 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 259 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 265 */     all = new java.util.HashMap();
/*     */     
/* 267 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleCircleRawCfg.bny";
/*     */     try
/*     */     {
/* 270 */       File file = new File(path);
/* 271 */       if (file.exists())
/*     */       {
/* 273 */         byte[] bytes = new byte['Ѐ'];
/* 274 */         FileInputStream fis = new FileInputStream(file);
/* 275 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 276 */         int len = 0;
/* 277 */         while ((len = fis.read(bytes)) > 0)
/* 278 */           baos.write(bytes, 0, len);
/* 279 */         fis.close();
/* 280 */         bytes = baos.toByteArray();
/* 281 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 282 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 284 */           _os_.unmarshal_int();
/* 285 */           _os_.unmarshal_int();
/* 286 */           _os_.unmarshal_int();
/*     */         }
/* 288 */         _os_.unmarshal_int();
/* 289 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 292 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 294 */           SBallBattleCircleRawCfg _v_ = new SBallBattleCircleRawCfg();
/* 295 */           _v_.unmarshal(_os_);
/* 296 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 297 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 302 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 307 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBallBattleCircleRawCfg> all)
/*     */   {
/* 314 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleCircleRawCfg.bny";
/*     */     try
/*     */     {
/* 317 */       File file = new File(path);
/* 318 */       if (file.exists())
/*     */       {
/* 320 */         byte[] bytes = new byte['Ѐ'];
/* 321 */         FileInputStream fis = new FileInputStream(file);
/* 322 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 323 */         int len = 0;
/* 324 */         while ((len = fis.read(bytes)) > 0)
/* 325 */           baos.write(bytes, 0, len);
/* 326 */         fis.close();
/* 327 */         bytes = baos.toByteArray();
/* 328 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 329 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 331 */           _os_.unmarshal_int();
/* 332 */           _os_.unmarshal_int();
/* 333 */           _os_.unmarshal_int();
/*     */         }
/* 335 */         _os_.unmarshal_int();
/* 336 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 339 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 341 */           SBallBattleCircleRawCfg _v_ = new SBallBattleCircleRawCfg();
/* 342 */           _v_.unmarshal(_os_);
/* 343 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 344 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 349 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 354 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBallBattleCircleRawCfg getOld(int key)
/*     */   {
/* 362 */     return (SBallBattleCircleRawCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBallBattleCircleRawCfg get(int key)
/*     */   {
/* 367 */     return (SBallBattleCircleRawCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBallBattleCircleRawCfg> getOldAll()
/*     */   {
/* 372 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBallBattleCircleRawCfg> getAll()
/*     */   {
/* 377 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBallBattleCircleRawCfg> newAll)
/*     */   {
/* 382 */     oldAll = all;
/* 383 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 388 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\confbean\SBallBattleCircleRawCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */