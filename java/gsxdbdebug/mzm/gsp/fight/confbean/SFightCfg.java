/*     */ package mzm.gsp.fight.confbean;
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
/*     */ public class SFightCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFightCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFightCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int levelType;
/*     */   public int levelMin;
/*     */   public int levelMax;
/*     */   public int difficult;
/*     */   public int roleNum2MonsterNumCfg;
/*  24 */   public ArrayList<Integer> monsterCfgs = new ArrayList();
/*  25 */   public ArrayList<Integer> zhenfaList = new ArrayList();
/*     */   public int zhenfaLV;
/*     */   public int rewardId;
/*     */   public String groupAiName;
/*     */   public String npcGroupAiName;
/*  30 */   public ArrayList<Integer> roleRowNpcCfgs = new ArrayList();
/*  31 */   public ArrayList<Integer> petRowNpcCfgs = new ArrayList();
/*     */   public int npcFightCfg12;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.levelType = Integer.valueOf(rootElement.attributeValue("levelType")).intValue();
/*  38 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  39 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*  40 */     this.difficult = Integer.valueOf(rootElement.attributeValue("difficult")).intValue();
/*  41 */     this.roleNum2MonsterNumCfg = Integer.valueOf(rootElement.attributeValue("roleNum2MonsterNumCfg")).intValue();
/*     */     
/*  43 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "monsterCfgs");
/*  44 */     if (collectionElement == null)
/*     */     {
/*  46 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  49 */     List<?> _nodeList = collectionElement.elements();
/*  50 */     int _len = _nodeList.size();
/*  51 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  53 */       Element elem = (Element)_nodeList.get(i);
/*  54 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  61 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  68 */         this.monsterCfgs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  72 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "zhenfaList");
/*  73 */     if (collectionElement == null)
/*     */     {
/*  75 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  78 */     List<?> _nodeList = collectionElement.elements();
/*  79 */     int _len = _nodeList.size();
/*  80 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  82 */       Element elem = (Element)_nodeList.get(i);
/*  83 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  90 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  97 */         this.zhenfaList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 100 */     this.zhenfaLV = Integer.valueOf(rootElement.attributeValue("zhenfaLV")).intValue();
/* 101 */     this.rewardId = Integer.valueOf(rootElement.attributeValue("rewardId")).intValue();
/* 102 */     this.groupAiName = rootElement.attributeValue("groupAiName");
/* 103 */     this.npcGroupAiName = rootElement.attributeValue("npcGroupAiName");
/*     */     
/* 105 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "roleRowNpcCfgs");
/* 106 */     if (collectionElement == null)
/*     */     {
/* 108 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 111 */     List<?> _nodeList = collectionElement.elements();
/* 112 */     int _len = _nodeList.size();
/* 113 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 115 */       Element elem = (Element)_nodeList.get(i);
/* 116 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 123 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 130 */         this.roleRowNpcCfgs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 134 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "petRowNpcCfgs");
/* 135 */     if (collectionElement == null)
/*     */     {
/* 137 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 140 */     List<?> _nodeList = collectionElement.elements();
/* 141 */     int _len = _nodeList.size();
/* 142 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 144 */       Element elem = (Element)_nodeList.get(i);
/* 145 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 152 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 159 */         this.petRowNpcCfgs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 162 */     this.npcFightCfg12 = Integer.valueOf(rootElement.attributeValue("npcFightCfg12")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 167 */     _os_.marshal(this.id);
/* 168 */     _os_.marshal(this.levelType);
/* 169 */     _os_.marshal(this.levelMin);
/* 170 */     _os_.marshal(this.levelMax);
/* 171 */     _os_.marshal(this.difficult);
/* 172 */     _os_.marshal(this.roleNum2MonsterNumCfg);
/* 173 */     _os_.compact_uint32(this.monsterCfgs.size());
/* 174 */     for (Integer _v_ : this.monsterCfgs)
/*     */     {
/* 176 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 178 */     _os_.compact_uint32(this.zhenfaList.size());
/* 179 */     for (Integer _v_ : this.zhenfaList)
/*     */     {
/* 181 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 183 */     _os_.marshal(this.zhenfaLV);
/* 184 */     _os_.marshal(this.rewardId);
/* 185 */     _os_.marshal(this.groupAiName, "UTF-8");
/* 186 */     _os_.marshal(this.npcGroupAiName, "UTF-8");
/* 187 */     _os_.compact_uint32(this.roleRowNpcCfgs.size());
/* 188 */     for (Integer _v_ : this.roleRowNpcCfgs)
/*     */     {
/* 190 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 192 */     _os_.compact_uint32(this.petRowNpcCfgs.size());
/* 193 */     for (Integer _v_ : this.petRowNpcCfgs)
/*     */     {
/* 195 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 197 */     _os_.marshal(this.npcFightCfg12);
/* 198 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 203 */     this.id = _os_.unmarshal_int();
/* 204 */     this.levelType = _os_.unmarshal_int();
/* 205 */     this.levelMin = _os_.unmarshal_int();
/* 206 */     this.levelMax = _os_.unmarshal_int();
/* 207 */     this.difficult = _os_.unmarshal_int();
/* 208 */     this.roleNum2MonsterNumCfg = _os_.unmarshal_int();
/* 209 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 212 */       int _v_ = _os_.unmarshal_int();
/* 213 */       this.monsterCfgs.add(Integer.valueOf(_v_));
/*     */     }
/* 215 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 218 */       int _v_ = _os_.unmarshal_int();
/* 219 */       this.zhenfaList.add(Integer.valueOf(_v_));
/*     */     }
/* 221 */     this.zhenfaLV = _os_.unmarshal_int();
/* 222 */     this.rewardId = _os_.unmarshal_int();
/* 223 */     this.groupAiName = _os_.unmarshal_String("UTF-8");
/* 224 */     this.npcGroupAiName = _os_.unmarshal_String("UTF-8");
/* 225 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 228 */       int _v_ = _os_.unmarshal_int();
/* 229 */       this.roleRowNpcCfgs.add(Integer.valueOf(_v_));
/*     */     }
/* 231 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 234 */       int _v_ = _os_.unmarshal_int();
/* 235 */       this.petRowNpcCfgs.add(Integer.valueOf(_v_));
/*     */     }
/* 237 */     this.npcFightCfg12 = _os_.unmarshal_int();
/* 238 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 243 */     String path = dir + "mzm.gsp.fight.confbean.SFightCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 247 */       all = new java.util.HashMap();
/* 248 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 249 */       org.dom4j.Document doc = reader.read(new File(path));
/* 250 */       Element root = doc.getRootElement();
/* 251 */       List<?> nodeList = root.elements();
/* 252 */       int len = nodeList.size();
/* 253 */       for (int i = 0; i < len; i++)
/*     */       {
/* 255 */         Element elem = (Element)nodeList.get(i);
/* 256 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fight.confbean.SFightCfg"))
/*     */         {
/*     */ 
/* 259 */           SFightCfg obj = new SFightCfg();
/* 260 */           obj.loadFromXml(elem);
/* 261 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 262 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFightCfg> all)
/*     */   {
/* 273 */     String path = dir + "mzm.gsp.fight.confbean.SFightCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 277 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 278 */       org.dom4j.Document doc = reader.read(new File(path));
/* 279 */       Element root = doc.getRootElement();
/* 280 */       List<?> nodeList = root.elements();
/* 281 */       int len = nodeList.size();
/* 282 */       for (int i = 0; i < len; i++)
/*     */       {
/* 284 */         Element elem = (Element)nodeList.get(i);
/* 285 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fight.confbean.SFightCfg"))
/*     */         {
/*     */ 
/* 288 */           SFightCfg obj = new SFightCfg();
/* 289 */           obj.loadFromXml(elem);
/* 290 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 291 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 296 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 302 */     all = new java.util.HashMap();
/*     */     
/* 304 */     String path = dir + "mzm.gsp.fight.confbean.SFightCfg.bny";
/*     */     try
/*     */     {
/* 307 */       File file = new File(path);
/* 308 */       if (file.exists())
/*     */       {
/* 310 */         byte[] bytes = new byte['Ѐ'];
/* 311 */         FileInputStream fis = new FileInputStream(file);
/* 312 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 313 */         int len = 0;
/* 314 */         while ((len = fis.read(bytes)) > 0)
/* 315 */           baos.write(bytes, 0, len);
/* 316 */         fis.close();
/* 317 */         bytes = baos.toByteArray();
/* 318 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 319 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 321 */           _os_.unmarshal_int();
/* 322 */           _os_.unmarshal_int();
/* 323 */           _os_.unmarshal_int();
/*     */         }
/* 325 */         _os_.unmarshal_int();
/* 326 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 329 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 331 */           SFightCfg _v_ = new SFightCfg();
/* 332 */           _v_.unmarshal(_os_);
/* 333 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 334 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 339 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 344 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFightCfg> all)
/*     */   {
/* 351 */     String path = dir + "mzm.gsp.fight.confbean.SFightCfg.bny";
/*     */     try
/*     */     {
/* 354 */       File file = new File(path);
/* 355 */       if (file.exists())
/*     */       {
/* 357 */         byte[] bytes = new byte['Ѐ'];
/* 358 */         FileInputStream fis = new FileInputStream(file);
/* 359 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 360 */         int len = 0;
/* 361 */         while ((len = fis.read(bytes)) > 0)
/* 362 */           baos.write(bytes, 0, len);
/* 363 */         fis.close();
/* 364 */         bytes = baos.toByteArray();
/* 365 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 366 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 368 */           _os_.unmarshal_int();
/* 369 */           _os_.unmarshal_int();
/* 370 */           _os_.unmarshal_int();
/*     */         }
/* 372 */         _os_.unmarshal_int();
/* 373 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 376 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 378 */           SFightCfg _v_ = new SFightCfg();
/* 379 */           _v_.unmarshal(_os_);
/* 380 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 381 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 386 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 391 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFightCfg getOld(int key)
/*     */   {
/* 399 */     return (SFightCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFightCfg get(int key)
/*     */   {
/* 404 */     return (SFightCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFightCfg> getOldAll()
/*     */   {
/* 409 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFightCfg> getAll()
/*     */   {
/* 414 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFightCfg> newAll)
/*     */   {
/* 419 */     oldAll = all;
/* 420 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 425 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\confbean\SFightCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */