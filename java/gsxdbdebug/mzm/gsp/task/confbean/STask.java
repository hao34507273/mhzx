/*     */ package mzm.gsp.task.confbean;
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
/*     */ public class STask implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STask> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STask> all = null;
/*     */   
/*     */   public int id;
/*     */   public String taskName;
/*     */   public int giveTaskNPC;
/*     */   public int finishTaskNPC;
/*     */   public int teamType;
/*     */   public int leaveTaskSet;
/*     */   public boolean taskFightDeadPunish;
/*     */   public boolean autoFinish;
/*     */   public boolean failToRev;
/*     */   public boolean useFlySword;
/*     */   public boolean winAllFinish;
/*     */   public boolean isShowFinish;
/*     */   public boolean acceptAutoFindPath;
/*     */   public boolean finishAutoFindPath;
/*  32 */   public ArrayList<SMapAndPosition> mapAndPosition = new ArrayList();
/*     */   public int pathNpcId;
/*     */   public int serverId;
/*     */   public int battlePeopleNumUpper;
/*     */   public int battlePeopleNumLower;
/*     */   public int battleLevelLow;
/*     */   public int battleLevelHigh;
/*     */   public boolean autoDialog;
/*     */   public String taskDes;
/*     */   public String taskTarget;
/*     */   public String taskFinishTarget;
/*     */   public int mapId;
/*     */   public int battleId;
/*  45 */   public ArrayList<Integer> conIds = new ArrayList();
/*  46 */   public ArrayList<Integer> operIds = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  50 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  51 */     this.taskName = rootElement.attributeValue("taskName");
/*  52 */     this.giveTaskNPC = Integer.valueOf(rootElement.attributeValue("giveTaskNPC")).intValue();
/*  53 */     this.finishTaskNPC = Integer.valueOf(rootElement.attributeValue("finishTaskNPC")).intValue();
/*  54 */     this.teamType = Integer.valueOf(rootElement.attributeValue("teamType")).intValue();
/*  55 */     this.leaveTaskSet = Integer.valueOf(rootElement.attributeValue("leaveTaskSet")).intValue();
/*  56 */     this.taskFightDeadPunish = Boolean.valueOf(rootElement.attributeValue("taskFightDeadPunish")).booleanValue();
/*  57 */     this.autoFinish = Boolean.valueOf(rootElement.attributeValue("autoFinish")).booleanValue();
/*  58 */     this.failToRev = Boolean.valueOf(rootElement.attributeValue("failToRev")).booleanValue();
/*  59 */     this.useFlySword = Boolean.valueOf(rootElement.attributeValue("useFlySword")).booleanValue();
/*  60 */     this.winAllFinish = Boolean.valueOf(rootElement.attributeValue("winAllFinish")).booleanValue();
/*  61 */     this.isShowFinish = Boolean.valueOf(rootElement.attributeValue("isShowFinish")).booleanValue();
/*  62 */     this.acceptAutoFindPath = Boolean.valueOf(rootElement.attributeValue("acceptAutoFindPath")).booleanValue();
/*  63 */     this.finishAutoFindPath = Boolean.valueOf(rootElement.attributeValue("finishAutoFindPath")).booleanValue();
/*     */     
/*  65 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "mapAndPosition");
/*  66 */     if (collectionElement == null)
/*     */     {
/*  68 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  71 */     List<?> _nodeList = collectionElement.elements();
/*  72 */     int _len = _nodeList.size();
/*  73 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  75 */       Element elem = (Element)_nodeList.get(i);
/*  76 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SMapAndPosition"))
/*     */       {
/*     */         SMapAndPosition _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  83 */           _v_ = new SMapAndPosition();
/*  84 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  91 */         this.mapAndPosition.add(_v_);
/*     */       }
/*     */     }
/*  94 */     this.pathNpcId = Integer.valueOf(rootElement.attributeValue("pathNpcId")).intValue();
/*  95 */     this.serverId = Integer.valueOf(rootElement.attributeValue("serverId")).intValue();
/*  96 */     this.battlePeopleNumUpper = Integer.valueOf(rootElement.attributeValue("battlePeopleNumUpper")).intValue();
/*  97 */     this.battlePeopleNumLower = Integer.valueOf(rootElement.attributeValue("battlePeopleNumLower")).intValue();
/*  98 */     this.battleLevelLow = Integer.valueOf(rootElement.attributeValue("battleLevelLow")).intValue();
/*  99 */     this.battleLevelHigh = Integer.valueOf(rootElement.attributeValue("battleLevelHigh")).intValue();
/* 100 */     this.autoDialog = Boolean.valueOf(rootElement.attributeValue("autoDialog")).booleanValue();
/* 101 */     this.taskDes = rootElement.attributeValue("taskDes");
/* 102 */     this.taskTarget = rootElement.attributeValue("taskTarget");
/* 103 */     this.taskFinishTarget = rootElement.attributeValue("taskFinishTarget");
/* 104 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/* 105 */     this.battleId = Integer.valueOf(rootElement.attributeValue("battleId")).intValue();
/*     */     
/* 107 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "conIds");
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
/* 132 */         this.conIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 136 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "operIds");
/* 137 */     if (collectionElement == null)
/*     */     {
/* 139 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 142 */     List<?> _nodeList = collectionElement.elements();
/* 143 */     int _len = _nodeList.size();
/* 144 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 146 */       Element elem = (Element)_nodeList.get(i);
/* 147 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 154 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 161 */         this.operIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 168 */     _os_.marshal(this.id);
/* 169 */     _os_.marshal(this.taskName, "UTF-8");
/* 170 */     _os_.marshal(this.giveTaskNPC);
/* 171 */     _os_.marshal(this.finishTaskNPC);
/* 172 */     _os_.marshal(this.teamType);
/* 173 */     _os_.marshal(this.leaveTaskSet);
/* 174 */     _os_.marshal(this.taskFightDeadPunish);
/* 175 */     _os_.marshal(this.autoFinish);
/* 176 */     _os_.marshal(this.failToRev);
/* 177 */     _os_.marshal(this.useFlySword);
/* 178 */     _os_.marshal(this.winAllFinish);
/* 179 */     _os_.marshal(this.isShowFinish);
/* 180 */     _os_.marshal(this.acceptAutoFindPath);
/* 181 */     _os_.marshal(this.finishAutoFindPath);
/* 182 */     _os_.compact_uint32(this.mapAndPosition.size());
/* 183 */     for (SMapAndPosition _v_ : this.mapAndPosition)
/*     */     {
/* 185 */       _os_.marshal(_v_);
/*     */     }
/* 187 */     _os_.marshal(this.pathNpcId);
/* 188 */     _os_.marshal(this.serverId);
/* 189 */     _os_.marshal(this.battlePeopleNumUpper);
/* 190 */     _os_.marshal(this.battlePeopleNumLower);
/* 191 */     _os_.marshal(this.battleLevelLow);
/* 192 */     _os_.marshal(this.battleLevelHigh);
/* 193 */     _os_.marshal(this.autoDialog);
/* 194 */     _os_.marshal(this.taskDes, "UTF-8");
/* 195 */     _os_.marshal(this.taskTarget, "UTF-8");
/* 196 */     _os_.marshal(this.taskFinishTarget, "UTF-8");
/* 197 */     _os_.marshal(this.mapId);
/* 198 */     _os_.marshal(this.battleId);
/* 199 */     _os_.compact_uint32(this.conIds.size());
/* 200 */     for (Integer _v_ : this.conIds)
/*     */     {
/* 202 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 204 */     _os_.compact_uint32(this.operIds.size());
/* 205 */     for (Integer _v_ : this.operIds)
/*     */     {
/* 207 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 209 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 214 */     this.id = _os_.unmarshal_int();
/* 215 */     this.taskName = _os_.unmarshal_String("UTF-8");
/* 216 */     this.giveTaskNPC = _os_.unmarshal_int();
/* 217 */     this.finishTaskNPC = _os_.unmarshal_int();
/* 218 */     this.teamType = _os_.unmarshal_int();
/* 219 */     this.leaveTaskSet = _os_.unmarshal_int();
/* 220 */     this.taskFightDeadPunish = _os_.unmarshal_boolean();
/* 221 */     this.autoFinish = _os_.unmarshal_boolean();
/* 222 */     this.failToRev = _os_.unmarshal_boolean();
/* 223 */     this.useFlySword = _os_.unmarshal_boolean();
/* 224 */     this.winAllFinish = _os_.unmarshal_boolean();
/* 225 */     this.isShowFinish = _os_.unmarshal_boolean();
/* 226 */     this.acceptAutoFindPath = _os_.unmarshal_boolean();
/* 227 */     this.finishAutoFindPath = _os_.unmarshal_boolean();
/* 228 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 231 */       SMapAndPosition _v_ = new SMapAndPosition();
/* 232 */       _v_.unmarshal(_os_);
/* 233 */       this.mapAndPosition.add(_v_);
/*     */     }
/* 235 */     this.pathNpcId = _os_.unmarshal_int();
/* 236 */     this.serverId = _os_.unmarshal_int();
/* 237 */     this.battlePeopleNumUpper = _os_.unmarshal_int();
/* 238 */     this.battlePeopleNumLower = _os_.unmarshal_int();
/* 239 */     this.battleLevelLow = _os_.unmarshal_int();
/* 240 */     this.battleLevelHigh = _os_.unmarshal_int();
/* 241 */     this.autoDialog = _os_.unmarshal_boolean();
/* 242 */     this.taskDes = _os_.unmarshal_String("UTF-8");
/* 243 */     this.taskTarget = _os_.unmarshal_String("UTF-8");
/* 244 */     this.taskFinishTarget = _os_.unmarshal_String("UTF-8");
/* 245 */     this.mapId = _os_.unmarshal_int();
/* 246 */     this.battleId = _os_.unmarshal_int();
/* 247 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 250 */       int _v_ = _os_.unmarshal_int();
/* 251 */       this.conIds.add(Integer.valueOf(_v_));
/*     */     }
/* 253 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 256 */       int _v_ = _os_.unmarshal_int();
/* 257 */       this.operIds.add(Integer.valueOf(_v_));
/*     */     }
/* 259 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 264 */     String path = dir + "mzm.gsp.task.confbean.STask.xml";
/*     */     
/*     */     try
/*     */     {
/* 268 */       all = new java.util.HashMap();
/* 269 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 270 */       org.dom4j.Document doc = reader.read(new File(path));
/* 271 */       Element root = doc.getRootElement();
/* 272 */       List<?> nodeList = root.elements();
/* 273 */       int len = nodeList.size();
/* 274 */       for (int i = 0; i < len; i++)
/*     */       {
/* 276 */         Element elem = (Element)nodeList.get(i);
/* 277 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.STask"))
/*     */         {
/*     */ 
/* 280 */           STask obj = new STask();
/* 281 */           obj.loadFromXml(elem);
/* 282 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 283 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 288 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STask> all)
/*     */   {
/* 294 */     String path = dir + "mzm.gsp.task.confbean.STask.xml";
/*     */     
/*     */     try
/*     */     {
/* 298 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 299 */       org.dom4j.Document doc = reader.read(new File(path));
/* 300 */       Element root = doc.getRootElement();
/* 301 */       List<?> nodeList = root.elements();
/* 302 */       int len = nodeList.size();
/* 303 */       for (int i = 0; i < len; i++)
/*     */       {
/* 305 */         Element elem = (Element)nodeList.get(i);
/* 306 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.STask"))
/*     */         {
/*     */ 
/* 309 */           STask obj = new STask();
/* 310 */           obj.loadFromXml(elem);
/* 311 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 312 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 317 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 323 */     all = new java.util.HashMap();
/*     */     
/* 325 */     String path = dir + "mzm.gsp.task.confbean.STask.bny";
/*     */     try
/*     */     {
/* 328 */       File file = new File(path);
/* 329 */       if (file.exists())
/*     */       {
/* 331 */         byte[] bytes = new byte['Ѐ'];
/* 332 */         FileInputStream fis = new FileInputStream(file);
/* 333 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 334 */         int len = 0;
/* 335 */         while ((len = fis.read(bytes)) > 0)
/* 336 */           baos.write(bytes, 0, len);
/* 337 */         fis.close();
/* 338 */         bytes = baos.toByteArray();
/* 339 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 340 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 342 */           _os_.unmarshal_int();
/* 343 */           _os_.unmarshal_int();
/* 344 */           _os_.unmarshal_int();
/*     */         }
/* 346 */         _os_.unmarshal_int();
/* 347 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 350 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 352 */           STask _v_ = new STask();
/* 353 */           _v_.unmarshal(_os_);
/* 354 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 355 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 360 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 365 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STask> all)
/*     */   {
/* 372 */     String path = dir + "mzm.gsp.task.confbean.STask.bny";
/*     */     try
/*     */     {
/* 375 */       File file = new File(path);
/* 376 */       if (file.exists())
/*     */       {
/* 378 */         byte[] bytes = new byte['Ѐ'];
/* 379 */         FileInputStream fis = new FileInputStream(file);
/* 380 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 381 */         int len = 0;
/* 382 */         while ((len = fis.read(bytes)) > 0)
/* 383 */           baos.write(bytes, 0, len);
/* 384 */         fis.close();
/* 385 */         bytes = baos.toByteArray();
/* 386 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 387 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 389 */           _os_.unmarshal_int();
/* 390 */           _os_.unmarshal_int();
/* 391 */           _os_.unmarshal_int();
/*     */         }
/* 393 */         _os_.unmarshal_int();
/* 394 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 397 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 399 */           STask _v_ = new STask();
/* 400 */           _v_.unmarshal(_os_);
/* 401 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 402 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 407 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 412 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STask getOld(int key)
/*     */   {
/* 420 */     return (STask)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STask get(int key)
/*     */   {
/* 425 */     return (STask)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STask> getOldAll()
/*     */   {
/* 430 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STask> getAll()
/*     */   {
/* 435 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STask> newAll)
/*     */   {
/* 440 */     oldAll = all;
/* 441 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 446 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\STask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */