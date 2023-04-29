/*     */ package mzm.gsp.achievement.confbean;
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
/*     */ public class SAchievementGoalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAchievementGoalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAchievementGoalCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activityCfgId;
/*     */   public int goalType;
/*     */   public int fixAwardId;
/*  22 */   public java.util.ArrayList<GoalParameter> goalParameters = new java.util.ArrayList();
/*     */   public int rank;
/*     */   public int tapId;
/*     */   public int score;
/*     */   public int bulletinType;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.activityCfgId = Integer.valueOf(rootElement.attributeValue("activityCfgId")).intValue();
/*  32 */     this.goalType = Integer.valueOf(rootElement.attributeValue("goalType")).intValue();
/*  33 */     this.fixAwardId = Integer.valueOf(rootElement.attributeValue("fixAwardId")).intValue();
/*     */     
/*  35 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "goalParameters");
/*  36 */     if (collectionElement == null)
/*     */     {
/*  38 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  41 */     List<?> _nodeList = collectionElement.elements();
/*  42 */     int _len = _nodeList.size();
/*  43 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  45 */       Element elem = (Element)_nodeList.get(i);
/*  46 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.achievement.confbean.GoalParameter"))
/*     */       {
/*     */         GoalParameter _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  53 */           _v_ = new GoalParameter();
/*  54 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  61 */         this.goalParameters.add(_v_);
/*     */       }
/*     */     }
/*  64 */     this.rank = Integer.valueOf(rootElement.attributeValue("rank")).intValue();
/*  65 */     this.tapId = Integer.valueOf(rootElement.attributeValue("tapId")).intValue();
/*  66 */     this.score = Integer.valueOf(rootElement.attributeValue("score")).intValue();
/*  67 */     this.bulletinType = Integer.valueOf(rootElement.attributeValue("bulletinType")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _os_.marshal(this.id);
/*  73 */     _os_.marshal(this.activityCfgId);
/*  74 */     _os_.marshal(this.goalType);
/*  75 */     _os_.marshal(this.fixAwardId);
/*  76 */     _os_.compact_uint32(this.goalParameters.size());
/*  77 */     for (GoalParameter _v_ : this.goalParameters)
/*     */     {
/*  79 */       _os_.marshal(_v_);
/*     */     }
/*  81 */     _os_.marshal(this.rank);
/*  82 */     _os_.marshal(this.tapId);
/*  83 */     _os_.marshal(this.score);
/*  84 */     _os_.marshal(this.bulletinType);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     this.id = _os_.unmarshal_int();
/*  91 */     this.activityCfgId = _os_.unmarshal_int();
/*  92 */     this.goalType = _os_.unmarshal_int();
/*  93 */     this.fixAwardId = _os_.unmarshal_int();
/*  94 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  97 */       GoalParameter _v_ = new GoalParameter();
/*  98 */       _v_.unmarshal(_os_);
/*  99 */       this.goalParameters.add(_v_);
/*     */     }
/* 101 */     this.rank = _os_.unmarshal_int();
/* 102 */     this.tapId = _os_.unmarshal_int();
/* 103 */     this.score = _os_.unmarshal_int();
/* 104 */     this.bulletinType = _os_.unmarshal_int();
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 110 */     String path = dir + "mzm.gsp.achievement.confbean.SAchievementGoalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 114 */       all = new java.util.HashMap();
/* 115 */       SAXReader reader = new SAXReader();
/* 116 */       org.dom4j.Document doc = reader.read(new File(path));
/* 117 */       Element root = doc.getRootElement();
/* 118 */       List<?> nodeList = root.elements();
/* 119 */       int len = nodeList.size();
/* 120 */       for (int i = 0; i < len; i++)
/*     */       {
/* 122 */         Element elem = (Element)nodeList.get(i);
/* 123 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.achievement.confbean.SAchievementGoalCfg"))
/*     */         {
/*     */ 
/* 126 */           SAchievementGoalCfg obj = new SAchievementGoalCfg();
/* 127 */           obj.loadFromXml(elem);
/* 128 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 129 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 134 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAchievementGoalCfg> all)
/*     */   {
/* 140 */     String path = dir + "mzm.gsp.achievement.confbean.SAchievementGoalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 144 */       SAXReader reader = new SAXReader();
/* 145 */       org.dom4j.Document doc = reader.read(new File(path));
/* 146 */       Element root = doc.getRootElement();
/* 147 */       List<?> nodeList = root.elements();
/* 148 */       int len = nodeList.size();
/* 149 */       for (int i = 0; i < len; i++)
/*     */       {
/* 151 */         Element elem = (Element)nodeList.get(i);
/* 152 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.achievement.confbean.SAchievementGoalCfg"))
/*     */         {
/*     */ 
/* 155 */           SAchievementGoalCfg obj = new SAchievementGoalCfg();
/* 156 */           obj.loadFromXml(elem);
/* 157 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 163 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 169 */     all = new java.util.HashMap();
/*     */     
/* 171 */     String path = dir + "mzm.gsp.achievement.confbean.SAchievementGoalCfg.bny";
/*     */     try
/*     */     {
/* 174 */       File file = new File(path);
/* 175 */       if (file.exists())
/*     */       {
/* 177 */         byte[] bytes = new byte['Ѐ'];
/* 178 */         FileInputStream fis = new FileInputStream(file);
/* 179 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 180 */         int len = 0;
/* 181 */         while ((len = fis.read(bytes)) > 0)
/* 182 */           baos.write(bytes, 0, len);
/* 183 */         fis.close();
/* 184 */         bytes = baos.toByteArray();
/* 185 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 188 */           _os_.unmarshal_int();
/* 189 */           _os_.unmarshal_int();
/* 190 */           _os_.unmarshal_int();
/*     */         }
/* 192 */         _os_.unmarshal_int();
/* 193 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 196 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 198 */           SAchievementGoalCfg _v_ = new SAchievementGoalCfg();
/* 199 */           _v_.unmarshal(_os_);
/* 200 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 201 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 206 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAchievementGoalCfg> all)
/*     */   {
/* 218 */     String path = dir + "mzm.gsp.achievement.confbean.SAchievementGoalCfg.bny";
/*     */     try
/*     */     {
/* 221 */       File file = new File(path);
/* 222 */       if (file.exists())
/*     */       {
/* 224 */         byte[] bytes = new byte['Ѐ'];
/* 225 */         FileInputStream fis = new FileInputStream(file);
/* 226 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 227 */         int len = 0;
/* 228 */         while ((len = fis.read(bytes)) > 0)
/* 229 */           baos.write(bytes, 0, len);
/* 230 */         fis.close();
/* 231 */         bytes = baos.toByteArray();
/* 232 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 235 */           _os_.unmarshal_int();
/* 236 */           _os_.unmarshal_int();
/* 237 */           _os_.unmarshal_int();
/*     */         }
/* 239 */         _os_.unmarshal_int();
/* 240 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 243 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 245 */           SAchievementGoalCfg _v_ = new SAchievementGoalCfg();
/* 246 */           _v_.unmarshal(_os_);
/* 247 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 248 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 253 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 258 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAchievementGoalCfg getOld(int key)
/*     */   {
/* 266 */     return (SAchievementGoalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAchievementGoalCfg get(int key)
/*     */   {
/* 271 */     return (SAchievementGoalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAchievementGoalCfg> getOldAll()
/*     */   {
/* 276 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAchievementGoalCfg> getAll()
/*     */   {
/* 281 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAchievementGoalCfg> newAll)
/*     */   {
/* 286 */     oldAll = all;
/* 287 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 292 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\confbean\SAchievementGoalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */