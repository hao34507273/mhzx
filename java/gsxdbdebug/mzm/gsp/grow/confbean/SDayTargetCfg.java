/*     */ package mzm.gsp.grow.confbean;
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
/*     */ public class SDayTargetCfg extends SLevelTargetCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SDayTargetCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SDayTargetCfg> all = null;
/*     */   
/*     */   public int levelLow;
/*     */   public int levelUp;
/*     */   public int num;
/*     */   public int awardId;
/*     */   public int weight;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.templateName = rootElement.attributeValue("templateName");
/*  29 */     this.moduleType = Integer.valueOf(rootElement.attributeValue("moduleType")).intValue();
/*  30 */     this.openLevel = Integer.valueOf(rootElement.attributeValue("openLevel")).intValue();
/*  31 */     this.goalType = Integer.valueOf(rootElement.attributeValue("goalType")).intValue();
/*  32 */     this.title = rootElement.attributeValue("title");
/*  33 */     this.goalDes = rootElement.attributeValue("goalDes");
/*  34 */     this.iconId = Integer.valueOf(rootElement.attributeValue("iconId")).intValue();
/*  35 */     this.fixAwardId = Integer.valueOf(rootElement.attributeValue("fixAwardId")).intValue();
/*     */     
/*  37 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "goalParameters");
/*  38 */     if (collectionElement == null)
/*     */     {
/*  40 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  43 */     List<?> _nodeList = collectionElement.elements();
/*  44 */     int _len = _nodeList.size();
/*  45 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  47 */       Element elem = (Element)_nodeList.get(i);
/*  48 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.GoalParameter"))
/*     */       {
/*     */         GoalParameter _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  55 */           _v_ = new GoalParameter();
/*  56 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  63 */         this.goalParameters.add(_v_);
/*     */       }
/*     */     }
/*  66 */     this.levelLow = Integer.valueOf(rootElement.attributeValue("levelLow")).intValue();
/*  67 */     this.levelUp = Integer.valueOf(rootElement.attributeValue("levelUp")).intValue();
/*  68 */     this.num = Integer.valueOf(rootElement.attributeValue("num")).intValue();
/*  69 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  70 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _os_.marshal(this.id);
/*  76 */     _os_.marshal(this.templateName, "UTF-8");
/*  77 */     _os_.marshal(this.moduleType);
/*  78 */     _os_.marshal(this.openLevel);
/*  79 */     _os_.marshal(this.goalType);
/*  80 */     _os_.marshal(this.title, "UTF-8");
/*  81 */     _os_.marshal(this.goalDes, "UTF-8");
/*  82 */     _os_.marshal(this.iconId);
/*  83 */     _os_.marshal(this.fixAwardId);
/*  84 */     _os_.compact_uint32(this.goalParameters.size());
/*  85 */     for (GoalParameter _v_ : this.goalParameters)
/*     */     {
/*  87 */       _os_.marshal(_v_);
/*     */     }
/*  89 */     _os_.marshal(this.levelLow);
/*  90 */     _os_.marshal(this.levelUp);
/*  91 */     _os_.marshal(this.num);
/*  92 */     _os_.marshal(this.awardId);
/*  93 */     _os_.marshal(this.weight);
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     this.id = _os_.unmarshal_int();
/* 100 */     this.templateName = _os_.unmarshal_String("UTF-8");
/* 101 */     this.moduleType = _os_.unmarshal_int();
/* 102 */     this.openLevel = _os_.unmarshal_int();
/* 103 */     this.goalType = _os_.unmarshal_int();
/* 104 */     this.title = _os_.unmarshal_String("UTF-8");
/* 105 */     this.goalDes = _os_.unmarshal_String("UTF-8");
/* 106 */     this.iconId = _os_.unmarshal_int();
/* 107 */     this.fixAwardId = _os_.unmarshal_int();
/* 108 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 111 */       GoalParameter _v_ = new GoalParameter();
/* 112 */       _v_.unmarshal(_os_);
/* 113 */       this.goalParameters.add(_v_);
/*     */     }
/* 115 */     this.levelLow = _os_.unmarshal_int();
/* 116 */     this.levelUp = _os_.unmarshal_int();
/* 117 */     this.num = _os_.unmarshal_int();
/* 118 */     this.awardId = _os_.unmarshal_int();
/* 119 */     this.weight = _os_.unmarshal_int();
/* 120 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.grow.confbean.SDayTargetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       all = new java.util.HashMap();
/* 130 */       SAXReader reader = new SAXReader();
/* 131 */       org.dom4j.Document doc = reader.read(new File(path));
/* 132 */       Element root = doc.getRootElement();
/* 133 */       List<?> nodeList = root.elements();
/* 134 */       int len = nodeList.size();
/* 135 */       for (int i = 0; i < len; i++)
/*     */       {
/* 137 */         Element elem = (Element)nodeList.get(i);
/* 138 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.SDayTargetCfg"))
/*     */         {
/*     */ 
/* 141 */           SDayTargetCfg obj = new SDayTargetCfg();
/* 142 */           obj.loadFromXml(elem);
/* 143 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 144 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 149 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SDayTargetCfg> all)
/*     */   {
/* 155 */     String path = dir + "mzm.gsp.grow.confbean.SDayTargetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 159 */       SAXReader reader = new SAXReader();
/* 160 */       org.dom4j.Document doc = reader.read(new File(path));
/* 161 */       Element root = doc.getRootElement();
/* 162 */       List<?> nodeList = root.elements();
/* 163 */       int len = nodeList.size();
/* 164 */       for (int i = 0; i < len; i++)
/*     */       {
/* 166 */         Element elem = (Element)nodeList.get(i);
/* 167 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.SDayTargetCfg"))
/*     */         {
/*     */ 
/* 170 */           SDayTargetCfg obj = new SDayTargetCfg();
/* 171 */           obj.loadFromXml(elem);
/* 172 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 173 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 178 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 184 */     all = new java.util.HashMap();
/*     */     
/* 186 */     String path = dir + "mzm.gsp.grow.confbean.SDayTargetCfg.bny";
/*     */     try
/*     */     {
/* 189 */       File file = new File(path);
/* 190 */       if (file.exists())
/*     */       {
/* 192 */         byte[] bytes = new byte['Ѐ'];
/* 193 */         FileInputStream fis = new FileInputStream(file);
/* 194 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 195 */         int len = 0;
/* 196 */         while ((len = fis.read(bytes)) > 0)
/* 197 */           baos.write(bytes, 0, len);
/* 198 */         fis.close();
/* 199 */         bytes = baos.toByteArray();
/* 200 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 203 */           _os_.unmarshal_int();
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/*     */         }
/* 207 */         _os_.unmarshal_int();
/* 208 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 211 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 213 */           SDayTargetCfg _v_ = new SDayTargetCfg();
/* 214 */           _v_.unmarshal(_os_);
/* 215 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 216 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 221 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 226 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SDayTargetCfg> all)
/*     */   {
/* 233 */     String path = dir + "mzm.gsp.grow.confbean.SDayTargetCfg.bny";
/*     */     try
/*     */     {
/* 236 */       File file = new File(path);
/* 237 */       if (file.exists())
/*     */       {
/* 239 */         byte[] bytes = new byte['Ѐ'];
/* 240 */         FileInputStream fis = new FileInputStream(file);
/* 241 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 242 */         int len = 0;
/* 243 */         while ((len = fis.read(bytes)) > 0)
/* 244 */           baos.write(bytes, 0, len);
/* 245 */         fis.close();
/* 246 */         bytes = baos.toByteArray();
/* 247 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 248 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 250 */           _os_.unmarshal_int();
/* 251 */           _os_.unmarshal_int();
/* 252 */           _os_.unmarshal_int();
/*     */         }
/* 254 */         _os_.unmarshal_int();
/* 255 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 258 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 260 */           SDayTargetCfg _v_ = new SDayTargetCfg();
/* 261 */           _v_.unmarshal(_os_);
/* 262 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 263 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 268 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 273 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 279 */     for (Map.Entry<Integer, SDayTargetCfg> entry : all.entrySet())
/*     */     {
/* 281 */       if (SLevelTargetCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 283 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 287 */       SLevelTargetCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SDayTargetCfg> all, Map<Integer, SLevelTargetCfg> parent)
/*     */   {
/* 294 */     for (Map.Entry<Integer, SDayTargetCfg> entry : all.entrySet())
/*     */     {
/* 296 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 298 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 302 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SDayTargetCfg getOld(int key)
/*     */   {
/* 309 */     return (SDayTargetCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SDayTargetCfg get(int key)
/*     */   {
/* 314 */     return (SDayTargetCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDayTargetCfg> getOldAllSelf()
/*     */   {
/* 319 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDayTargetCfg> getAllSelf()
/*     */   {
/* 324 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SDayTargetCfg> newAll)
/*     */   {
/* 329 */     oldAll = all;
/* 330 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 335 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\confbean\SDayTargetCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */