/*     */ package mzm.gsp.activity3.confbean;
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
/*     */ public class SFloorRuleCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFloorRuleCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFloorRuleCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activityId;
/*     */   public int floor;
/*     */   public String floorName;
/*     */   public int joinLevel;
/*     */   public int awardId;
/*     */   public int fristBloodAwardId;
/*     */   public int hardFightId;
/*     */   public int normalFightId;
/*     */   public int floorOpenId;
/*     */   public int fastFinishTimeLimit;
/*     */   public int headIconId;
/*     */   public String describe;
/*  31 */   public java.util.ArrayList<Integer> disAwardItems = new java.util.ArrayList();
/*     */   public int helpLibId;
/*     */   public boolean canSweep;
/*     */   public int sweepFightValue;
/*     */   public int sweepCostNum;
/*     */   public int confirmType;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  40 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  41 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  42 */     this.floor = Integer.valueOf(rootElement.attributeValue("floor")).intValue();
/*  43 */     this.floorName = rootElement.attributeValue("floorName");
/*  44 */     this.joinLevel = Integer.valueOf(rootElement.attributeValue("joinLevel")).intValue();
/*  45 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  46 */     this.fristBloodAwardId = Integer.valueOf(rootElement.attributeValue("fristBloodAwardId")).intValue();
/*  47 */     this.hardFightId = Integer.valueOf(rootElement.attributeValue("hardFightId")).intValue();
/*  48 */     this.normalFightId = Integer.valueOf(rootElement.attributeValue("normalFightId")).intValue();
/*  49 */     this.floorOpenId = Integer.valueOf(rootElement.attributeValue("floorOpenId")).intValue();
/*  50 */     this.fastFinishTimeLimit = Integer.valueOf(rootElement.attributeValue("fastFinishTimeLimit")).intValue();
/*  51 */     this.headIconId = Integer.valueOf(rootElement.attributeValue("headIconId")).intValue();
/*  52 */     this.describe = rootElement.attributeValue("describe");
/*     */     
/*  54 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "disAwardItems");
/*  55 */     if (collectionElement == null)
/*     */     {
/*  57 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  60 */     List<?> _nodeList = collectionElement.elements();
/*  61 */     int _len = _nodeList.size();
/*  62 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  64 */       Element elem = (Element)_nodeList.get(i);
/*  65 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  72 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  79 */         this.disAwardItems.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  82 */     this.helpLibId = Integer.valueOf(rootElement.attributeValue("helpLibId")).intValue();
/*  83 */     this.canSweep = Boolean.valueOf(rootElement.attributeValue("canSweep")).booleanValue();
/*  84 */     this.sweepFightValue = Integer.valueOf(rootElement.attributeValue("sweepFightValue")).intValue();
/*  85 */     this.sweepCostNum = Integer.valueOf(rootElement.attributeValue("sweepCostNum")).intValue();
/*  86 */     this.confirmType = Integer.valueOf(rootElement.attributeValue("confirmType")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  91 */     _os_.marshal(this.id);
/*  92 */     _os_.marshal(this.activityId);
/*  93 */     _os_.marshal(this.floor);
/*  94 */     _os_.marshal(this.floorName, "UTF-8");
/*  95 */     _os_.marshal(this.joinLevel);
/*  96 */     _os_.marshal(this.awardId);
/*  97 */     _os_.marshal(this.fristBloodAwardId);
/*  98 */     _os_.marshal(this.hardFightId);
/*  99 */     _os_.marshal(this.normalFightId);
/* 100 */     _os_.marshal(this.floorOpenId);
/* 101 */     _os_.marshal(this.fastFinishTimeLimit);
/* 102 */     _os_.marshal(this.headIconId);
/* 103 */     _os_.marshal(this.describe, "UTF-8");
/* 104 */     _os_.compact_uint32(this.disAwardItems.size());
/* 105 */     for (Integer _v_ : this.disAwardItems)
/*     */     {
/* 107 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 109 */     _os_.marshal(this.helpLibId);
/* 110 */     _os_.marshal(this.canSweep);
/* 111 */     _os_.marshal(this.sweepFightValue);
/* 112 */     _os_.marshal(this.sweepCostNum);
/* 113 */     _os_.marshal(this.confirmType);
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 119 */     this.id = _os_.unmarshal_int();
/* 120 */     this.activityId = _os_.unmarshal_int();
/* 121 */     this.floor = _os_.unmarshal_int();
/* 122 */     this.floorName = _os_.unmarshal_String("UTF-8");
/* 123 */     this.joinLevel = _os_.unmarshal_int();
/* 124 */     this.awardId = _os_.unmarshal_int();
/* 125 */     this.fristBloodAwardId = _os_.unmarshal_int();
/* 126 */     this.hardFightId = _os_.unmarshal_int();
/* 127 */     this.normalFightId = _os_.unmarshal_int();
/* 128 */     this.floorOpenId = _os_.unmarshal_int();
/* 129 */     this.fastFinishTimeLimit = _os_.unmarshal_int();
/* 130 */     this.headIconId = _os_.unmarshal_int();
/* 131 */     this.describe = _os_.unmarshal_String("UTF-8");
/* 132 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 135 */       int _v_ = _os_.unmarshal_int();
/* 136 */       this.disAwardItems.add(Integer.valueOf(_v_));
/*     */     }
/* 138 */     this.helpLibId = _os_.unmarshal_int();
/* 139 */     this.canSweep = _os_.unmarshal_boolean();
/* 140 */     this.sweepFightValue = _os_.unmarshal_int();
/* 141 */     this.sweepCostNum = _os_.unmarshal_int();
/* 142 */     this.confirmType = _os_.unmarshal_int();
/* 143 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 148 */     String path = dir + "mzm.gsp.activity3.confbean.SFloorRuleCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 152 */       all = new java.util.HashMap();
/* 153 */       SAXReader reader = new SAXReader();
/* 154 */       org.dom4j.Document doc = reader.read(new File(path));
/* 155 */       Element root = doc.getRootElement();
/* 156 */       List<?> nodeList = root.elements();
/* 157 */       int len = nodeList.size();
/* 158 */       for (int i = 0; i < len; i++)
/*     */       {
/* 160 */         Element elem = (Element)nodeList.get(i);
/* 161 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SFloorRuleCfg"))
/*     */         {
/*     */ 
/* 164 */           SFloorRuleCfg obj = new SFloorRuleCfg();
/* 165 */           obj.loadFromXml(elem);
/* 166 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 167 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFloorRuleCfg> all)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.activity3.confbean.SFloorRuleCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 182 */       SAXReader reader = new SAXReader();
/* 183 */       org.dom4j.Document doc = reader.read(new File(path));
/* 184 */       Element root = doc.getRootElement();
/* 185 */       List<?> nodeList = root.elements();
/* 186 */       int len = nodeList.size();
/* 187 */       for (int i = 0; i < len; i++)
/*     */       {
/* 189 */         Element elem = (Element)nodeList.get(i);
/* 190 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SFloorRuleCfg"))
/*     */         {
/*     */ 
/* 193 */           SFloorRuleCfg obj = new SFloorRuleCfg();
/* 194 */           obj.loadFromXml(elem);
/* 195 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 196 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 207 */     all = new java.util.HashMap();
/*     */     
/* 209 */     String path = dir + "mzm.gsp.activity3.confbean.SFloorRuleCfg.bny";
/*     */     try
/*     */     {
/* 212 */       File file = new File(path);
/* 213 */       if (file.exists())
/*     */       {
/* 215 */         byte[] bytes = new byte['Ѐ'];
/* 216 */         FileInputStream fis = new FileInputStream(file);
/* 217 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 218 */         int len = 0;
/* 219 */         while ((len = fis.read(bytes)) > 0)
/* 220 */           baos.write(bytes, 0, len);
/* 221 */         fis.close();
/* 222 */         bytes = baos.toByteArray();
/* 223 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 224 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 226 */           _os_.unmarshal_int();
/* 227 */           _os_.unmarshal_int();
/* 228 */           _os_.unmarshal_int();
/*     */         }
/* 230 */         _os_.unmarshal_int();
/* 231 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 234 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 236 */           SFloorRuleCfg _v_ = new SFloorRuleCfg();
/* 237 */           _v_.unmarshal(_os_);
/* 238 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 239 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 244 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 249 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFloorRuleCfg> all)
/*     */   {
/* 256 */     String path = dir + "mzm.gsp.activity3.confbean.SFloorRuleCfg.bny";
/*     */     try
/*     */     {
/* 259 */       File file = new File(path);
/* 260 */       if (file.exists())
/*     */       {
/* 262 */         byte[] bytes = new byte['Ѐ'];
/* 263 */         FileInputStream fis = new FileInputStream(file);
/* 264 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 265 */         int len = 0;
/* 266 */         while ((len = fis.read(bytes)) > 0)
/* 267 */           baos.write(bytes, 0, len);
/* 268 */         fis.close();
/* 269 */         bytes = baos.toByteArray();
/* 270 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 271 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 273 */           _os_.unmarshal_int();
/* 274 */           _os_.unmarshal_int();
/* 275 */           _os_.unmarshal_int();
/*     */         }
/* 277 */         _os_.unmarshal_int();
/* 278 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 281 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 283 */           SFloorRuleCfg _v_ = new SFloorRuleCfg();
/* 284 */           _v_.unmarshal(_os_);
/* 285 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 286 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 291 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 296 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFloorRuleCfg getOld(int key)
/*     */   {
/* 304 */     return (SFloorRuleCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFloorRuleCfg get(int key)
/*     */   {
/* 309 */     return (SFloorRuleCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFloorRuleCfg> getOldAll()
/*     */   {
/* 314 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFloorRuleCfg> getAll()
/*     */   {
/* 319 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFloorRuleCfg> newAll)
/*     */   {
/* 324 */     oldAll = all;
/* 325 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 330 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SFloorRuleCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */