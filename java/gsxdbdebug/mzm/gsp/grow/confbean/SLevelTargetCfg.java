/*     */ package mzm.gsp.grow.confbean;
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
/*     */ public class SLevelTargetCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLevelTargetCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLevelTargetCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templateName;
/*     */   public int moduleType;
/*     */   public int openLevel;
/*     */   public int goalType;
/*     */   public String title;
/*     */   public String goalDes;
/*     */   public int iconId;
/*     */   public int fixAwardId;
/*  27 */   public java.util.ArrayList<GoalParameter> goalParameters = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.templateName = rootElement.attributeValue("templateName");
/*  33 */     this.moduleType = Integer.valueOf(rootElement.attributeValue("moduleType")).intValue();
/*  34 */     this.openLevel = Integer.valueOf(rootElement.attributeValue("openLevel")).intValue();
/*  35 */     this.goalType = Integer.valueOf(rootElement.attributeValue("goalType")).intValue();
/*  36 */     this.title = rootElement.attributeValue("title");
/*  37 */     this.goalDes = rootElement.attributeValue("goalDes");
/*  38 */     this.iconId = Integer.valueOf(rootElement.attributeValue("iconId")).intValue();
/*  39 */     this.fixAwardId = Integer.valueOf(rootElement.attributeValue("fixAwardId")).intValue();
/*     */     
/*  41 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "goalParameters");
/*  42 */     if (collectionElement == null)
/*     */     {
/*  44 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  47 */     List<?> _nodeList = collectionElement.elements();
/*  48 */     int _len = _nodeList.size();
/*  49 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  51 */       Element elem = (Element)_nodeList.get(i);
/*  52 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.GoalParameter"))
/*     */       {
/*     */         GoalParameter _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  59 */           _v_ = new GoalParameter();
/*  60 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  67 */         this.goalParameters.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _os_.marshal(this.id);
/*  75 */     _os_.marshal(this.templateName, "UTF-8");
/*  76 */     _os_.marshal(this.moduleType);
/*  77 */     _os_.marshal(this.openLevel);
/*  78 */     _os_.marshal(this.goalType);
/*  79 */     _os_.marshal(this.title, "UTF-8");
/*  80 */     _os_.marshal(this.goalDes, "UTF-8");
/*  81 */     _os_.marshal(this.iconId);
/*  82 */     _os_.marshal(this.fixAwardId);
/*  83 */     _os_.compact_uint32(this.goalParameters.size());
/*  84 */     for (GoalParameter _v_ : this.goalParameters)
/*     */     {
/*  86 */       _os_.marshal(_v_);
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     this.id = _os_.unmarshal_int();
/*  94 */     this.templateName = _os_.unmarshal_String("UTF-8");
/*  95 */     this.moduleType = _os_.unmarshal_int();
/*  96 */     this.openLevel = _os_.unmarshal_int();
/*  97 */     this.goalType = _os_.unmarshal_int();
/*  98 */     this.title = _os_.unmarshal_String("UTF-8");
/*  99 */     this.goalDes = _os_.unmarshal_String("UTF-8");
/* 100 */     this.iconId = _os_.unmarshal_int();
/* 101 */     this.fixAwardId = _os_.unmarshal_int();
/* 102 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 105 */       GoalParameter _v_ = new GoalParameter();
/* 106 */       _v_.unmarshal(_os_);
/* 107 */       this.goalParameters.add(_v_);
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 114 */     String path = dir + "mzm.gsp.grow.confbean.SLevelTargetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 118 */       all = new java.util.HashMap();
/* 119 */       SAXReader reader = new SAXReader();
/* 120 */       org.dom4j.Document doc = reader.read(new File(path));
/* 121 */       Element root = doc.getRootElement();
/* 122 */       List<?> nodeList = root.elements();
/* 123 */       int len = nodeList.size();
/* 124 */       for (int i = 0; i < len; i++)
/*     */       {
/* 126 */         Element elem = (Element)nodeList.get(i);
/* 127 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.SLevelTargetCfg"))
/*     */         {
/*     */ 
/* 130 */           SLevelTargetCfg obj = new SLevelTargetCfg();
/* 131 */           obj.loadFromXml(elem);
/* 132 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 133 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 138 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLevelTargetCfg> all)
/*     */   {
/* 144 */     String path = dir + "mzm.gsp.grow.confbean.SLevelTargetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 148 */       SAXReader reader = new SAXReader();
/* 149 */       org.dom4j.Document doc = reader.read(new File(path));
/* 150 */       Element root = doc.getRootElement();
/* 151 */       List<?> nodeList = root.elements();
/* 152 */       int len = nodeList.size();
/* 153 */       for (int i = 0; i < len; i++)
/*     */       {
/* 155 */         Element elem = (Element)nodeList.get(i);
/* 156 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.SLevelTargetCfg"))
/*     */         {
/*     */ 
/* 159 */           SLevelTargetCfg obj = new SLevelTargetCfg();
/* 160 */           obj.loadFromXml(elem);
/* 161 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 162 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 167 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 173 */     all = new java.util.HashMap();
/*     */     
/* 175 */     String path = dir + "mzm.gsp.grow.confbean.SLevelTargetCfg.bny";
/*     */     try
/*     */     {
/* 178 */       File file = new File(path);
/* 179 */       if (file.exists())
/*     */       {
/* 181 */         byte[] bytes = new byte['Ѐ'];
/* 182 */         FileInputStream fis = new FileInputStream(file);
/* 183 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 184 */         int len = 0;
/* 185 */         while ((len = fis.read(bytes)) > 0)
/* 186 */           baos.write(bytes, 0, len);
/* 187 */         fis.close();
/* 188 */         bytes = baos.toByteArray();
/* 189 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 192 */           _os_.unmarshal_int();
/* 193 */           _os_.unmarshal_int();
/* 194 */           _os_.unmarshal_int();
/*     */         }
/* 196 */         _os_.unmarshal_int();
/* 197 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 200 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 202 */           SLevelTargetCfg _v_ = new SLevelTargetCfg();
/* 203 */           _v_.unmarshal(_os_);
/* 204 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 205 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 210 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLevelTargetCfg> all)
/*     */   {
/* 222 */     String path = dir + "mzm.gsp.grow.confbean.SLevelTargetCfg.bny";
/*     */     try
/*     */     {
/* 225 */       File file = new File(path);
/* 226 */       if (file.exists())
/*     */       {
/* 228 */         byte[] bytes = new byte['Ѐ'];
/* 229 */         FileInputStream fis = new FileInputStream(file);
/* 230 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 231 */         int len = 0;
/* 232 */         while ((len = fis.read(bytes)) > 0)
/* 233 */           baos.write(bytes, 0, len);
/* 234 */         fis.close();
/* 235 */         bytes = baos.toByteArray();
/* 236 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 239 */           _os_.unmarshal_int();
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/*     */         }
/* 243 */         _os_.unmarshal_int();
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 247 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 249 */           SLevelTargetCfg _v_ = new SLevelTargetCfg();
/* 250 */           _v_.unmarshal(_os_);
/* 251 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 252 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 257 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 262 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SLevelTargetCfg getOld(int key)
/*     */   {
/* 270 */     return (SLevelTargetCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLevelTargetCfg get(int key)
/*     */   {
/* 275 */     return (SLevelTargetCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLevelTargetCfg> getOldAll()
/*     */   {
/* 280 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLevelTargetCfg> getAll()
/*     */   {
/* 285 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLevelTargetCfg> newAll)
/*     */   {
/* 290 */     oldAll = all;
/* 291 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 296 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\confbean\SLevelTargetCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */