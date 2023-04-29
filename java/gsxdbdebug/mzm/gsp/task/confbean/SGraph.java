/*     */ package mzm.gsp.task.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SGraph implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGraph> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGraph> all = null;
/*     */   
/*     */   public int id;
/*     */   public int taskActiveType;
/*     */   public int activeActivityId;
/*     */   public int activeFuBenId;
/*     */   public int activeLevel;
/*     */   public int activeMenPai;
/*     */   public int activeGraphId;
/*     */   public int taskType;
/*     */   public boolean autoAcceptNextTask;
/*     */   public boolean fristTaskAtuoAccept;
/*     */   public boolean teamTaskGraph;
/*     */   public int setTaskRefresh;
/*     */   public int rootNodeId;
/*  31 */   public java.util.ArrayList<SNode> nodes = new java.util.ArrayList();
/*     */   public int finishTurnLimit;
/*     */   public int socialRelation;
/*     */   public boolean isContinueTask;
/*     */   public boolean canGiveUpTask;
/*     */   public int giveUpOperRing;
/*     */   public boolean isRingTypeGraph;
/*  38 */   public HashMap<Integer, SNode> nodeMap = new HashMap();
/*     */   public int taskNum;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  43 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  44 */     this.taskActiveType = Integer.valueOf(rootElement.attributeValue("taskActiveType")).intValue();
/*  45 */     this.activeActivityId = Integer.valueOf(rootElement.attributeValue("activeActivityId")).intValue();
/*  46 */     this.activeFuBenId = Integer.valueOf(rootElement.attributeValue("activeFuBenId")).intValue();
/*  47 */     this.activeLevel = Integer.valueOf(rootElement.attributeValue("activeLevel")).intValue();
/*  48 */     this.activeMenPai = Integer.valueOf(rootElement.attributeValue("activeMenPai")).intValue();
/*  49 */     this.activeGraphId = Integer.valueOf(rootElement.attributeValue("activeGraphId")).intValue();
/*  50 */     this.taskType = Integer.valueOf(rootElement.attributeValue("taskType")).intValue();
/*  51 */     this.autoAcceptNextTask = Boolean.valueOf(rootElement.attributeValue("autoAcceptNextTask")).booleanValue();
/*  52 */     this.fristTaskAtuoAccept = Boolean.valueOf(rootElement.attributeValue("fristTaskAtuoAccept")).booleanValue();
/*  53 */     this.teamTaskGraph = Boolean.valueOf(rootElement.attributeValue("teamTaskGraph")).booleanValue();
/*  54 */     this.setTaskRefresh = Integer.valueOf(rootElement.attributeValue("setTaskRefresh")).intValue();
/*  55 */     this.rootNodeId = Integer.valueOf(rootElement.attributeValue("rootNodeId")).intValue();
/*     */     
/*  57 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "nodes");
/*  58 */     if (collectionElement == null)
/*     */     {
/*  60 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  63 */     List<?> _nodeList = collectionElement.elements();
/*  64 */     int _len = _nodeList.size();
/*  65 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  67 */       Element elem = (Element)_nodeList.get(i);
/*  68 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SNode"))
/*     */       {
/*     */         SNode _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  75 */           _v_ = new SNode();
/*  76 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.nodes.add(_v_);
/*     */       }
/*     */     }
/*  86 */     this.finishTurnLimit = Integer.valueOf(rootElement.attributeValue("finishTurnLimit")).intValue();
/*  87 */     this.socialRelation = Integer.valueOf(rootElement.attributeValue("socialRelation")).intValue();
/*  88 */     this.isContinueTask = Boolean.valueOf(rootElement.attributeValue("isContinueTask")).booleanValue();
/*  89 */     this.canGiveUpTask = Boolean.valueOf(rootElement.attributeValue("canGiveUpTask")).booleanValue();
/*  90 */     this.giveUpOperRing = Integer.valueOf(rootElement.attributeValue("giveUpOperRing")).intValue();
/*  91 */     this.isRingTypeGraph = Boolean.valueOf(rootElement.attributeValue("isRingTypeGraph")).booleanValue();
/*     */     
/*  93 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "nodeMap");
/*  94 */     if (mapTypeElement == null)
/*     */     {
/*  96 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  99 */     List<?> entryNodeList = mapTypeElement.elements();
/* 100 */     int entryLen = entryNodeList.size();
/* 101 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 103 */       Element entryElement = (Element)entryNodeList.get(i);
/* 104 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 109 */         Element keyElem = null;
/* 110 */         Element valueElem = null;
/*     */         
/* 112 */         List<?> _nodeList = entryElement.elements();
/* 113 */         int _len = _nodeList.size();
/* 114 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 116 */           Element elem = (Element)_nodeList.get(j);
/* 117 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 119 */             keyElem = elem;
/*     */           }
/* 121 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SNode")))
/*     */           {
/* 123 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 127 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 129 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SNode _v_;
/*     */         try
/*     */         {
/* 136 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 137 */           _v_ = new SNode();
/* 138 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 145 */         this.nodeMap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/* 148 */     this.taskNum = Integer.valueOf(rootElement.attributeValue("taskNum")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 153 */     _os_.marshal(this.id);
/* 154 */     _os_.marshal(this.taskActiveType);
/* 155 */     _os_.marshal(this.activeActivityId);
/* 156 */     _os_.marshal(this.activeFuBenId);
/* 157 */     _os_.marshal(this.activeLevel);
/* 158 */     _os_.marshal(this.activeMenPai);
/* 159 */     _os_.marshal(this.activeGraphId);
/* 160 */     _os_.marshal(this.taskType);
/* 161 */     _os_.marshal(this.autoAcceptNextTask);
/* 162 */     _os_.marshal(this.fristTaskAtuoAccept);
/* 163 */     _os_.marshal(this.teamTaskGraph);
/* 164 */     _os_.marshal(this.setTaskRefresh);
/* 165 */     _os_.marshal(this.rootNodeId);
/* 166 */     _os_.compact_uint32(this.nodes.size());
/* 167 */     for (SNode _v_ : this.nodes)
/*     */     {
/* 169 */       _os_.marshal(_v_);
/*     */     }
/* 171 */     _os_.marshal(this.finishTurnLimit);
/* 172 */     _os_.marshal(this.socialRelation);
/* 173 */     _os_.marshal(this.isContinueTask);
/* 174 */     _os_.marshal(this.canGiveUpTask);
/* 175 */     _os_.marshal(this.giveUpOperRing);
/* 176 */     _os_.marshal(this.isRingTypeGraph);
/* 177 */     _os_.compact_uint32(this.nodeMap.size());
/* 178 */     for (java.util.Map.Entry<Integer, SNode> _e_ : this.nodeMap.entrySet())
/*     */     {
/* 180 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 181 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 183 */     _os_.marshal(this.taskNum);
/* 184 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 189 */     this.id = _os_.unmarshal_int();
/* 190 */     this.taskActiveType = _os_.unmarshal_int();
/* 191 */     this.activeActivityId = _os_.unmarshal_int();
/* 192 */     this.activeFuBenId = _os_.unmarshal_int();
/* 193 */     this.activeLevel = _os_.unmarshal_int();
/* 194 */     this.activeMenPai = _os_.unmarshal_int();
/* 195 */     this.activeGraphId = _os_.unmarshal_int();
/* 196 */     this.taskType = _os_.unmarshal_int();
/* 197 */     this.autoAcceptNextTask = _os_.unmarshal_boolean();
/* 198 */     this.fristTaskAtuoAccept = _os_.unmarshal_boolean();
/* 199 */     this.teamTaskGraph = _os_.unmarshal_boolean();
/* 200 */     this.setTaskRefresh = _os_.unmarshal_int();
/* 201 */     this.rootNodeId = _os_.unmarshal_int();
/* 202 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 205 */       SNode _v_ = new SNode();
/* 206 */       _v_.unmarshal(_os_);
/* 207 */       this.nodes.add(_v_);
/*     */     }
/* 209 */     this.finishTurnLimit = _os_.unmarshal_int();
/* 210 */     this.socialRelation = _os_.unmarshal_int();
/* 211 */     this.isContinueTask = _os_.unmarshal_boolean();
/* 212 */     this.canGiveUpTask = _os_.unmarshal_boolean();
/* 213 */     this.giveUpOperRing = _os_.unmarshal_int();
/* 214 */     this.isRingTypeGraph = _os_.unmarshal_boolean();
/* 215 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 218 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 220 */       SNode _v_ = new SNode();
/* 221 */       _v_.unmarshal(_os_);
/* 222 */       this.nodeMap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 224 */     this.taskNum = _os_.unmarshal_int();
/* 225 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 230 */     String path = dir + "mzm.gsp.task.confbean.SGraph.xml";
/*     */     
/*     */     try
/*     */     {
/* 234 */       all = new HashMap();
/* 235 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 236 */       org.dom4j.Document doc = reader.read(new File(path));
/* 237 */       Element root = doc.getRootElement();
/* 238 */       List<?> nodeList = root.elements();
/* 239 */       int len = nodeList.size();
/* 240 */       for (int i = 0; i < len; i++)
/*     */       {
/* 242 */         Element elem = (Element)nodeList.get(i);
/* 243 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SGraph"))
/*     */         {
/*     */ 
/* 246 */           SGraph obj = new SGraph();
/* 247 */           obj.loadFromXml(elem);
/* 248 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 249 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 254 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGraph> all)
/*     */   {
/* 260 */     String path = dir + "mzm.gsp.task.confbean.SGraph.xml";
/*     */     
/*     */     try
/*     */     {
/* 264 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 265 */       org.dom4j.Document doc = reader.read(new File(path));
/* 266 */       Element root = doc.getRootElement();
/* 267 */       List<?> nodeList = root.elements();
/* 268 */       int len = nodeList.size();
/* 269 */       for (int i = 0; i < len; i++)
/*     */       {
/* 271 */         Element elem = (Element)nodeList.get(i);
/* 272 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SGraph"))
/*     */         {
/*     */ 
/* 275 */           SGraph obj = new SGraph();
/* 276 */           obj.loadFromXml(elem);
/* 277 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 278 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 283 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 289 */     all = new HashMap();
/*     */     
/* 291 */     String path = dir + "mzm.gsp.task.confbean.SGraph.bny";
/*     */     try
/*     */     {
/* 294 */       File file = new File(path);
/* 295 */       if (file.exists())
/*     */       {
/* 297 */         byte[] bytes = new byte['Ѐ'];
/* 298 */         FileInputStream fis = new FileInputStream(file);
/* 299 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 300 */         int len = 0;
/* 301 */         while ((len = fis.read(bytes)) > 0)
/* 302 */           baos.write(bytes, 0, len);
/* 303 */         fis.close();
/* 304 */         bytes = baos.toByteArray();
/* 305 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 306 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 308 */           _os_.unmarshal_int();
/* 309 */           _os_.unmarshal_int();
/* 310 */           _os_.unmarshal_int();
/*     */         }
/* 312 */         _os_.unmarshal_int();
/* 313 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 316 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 318 */           SGraph _v_ = new SGraph();
/* 319 */           _v_.unmarshal(_os_);
/* 320 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 321 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 326 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 331 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SGraph> all)
/*     */   {
/* 338 */     String path = dir + "mzm.gsp.task.confbean.SGraph.bny";
/*     */     try
/*     */     {
/* 341 */       File file = new File(path);
/* 342 */       if (file.exists())
/*     */       {
/* 344 */         byte[] bytes = new byte['Ѐ'];
/* 345 */         FileInputStream fis = new FileInputStream(file);
/* 346 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 347 */         int len = 0;
/* 348 */         while ((len = fis.read(bytes)) > 0)
/* 349 */           baos.write(bytes, 0, len);
/* 350 */         fis.close();
/* 351 */         bytes = baos.toByteArray();
/* 352 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 353 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 355 */           _os_.unmarshal_int();
/* 356 */           _os_.unmarshal_int();
/* 357 */           _os_.unmarshal_int();
/*     */         }
/* 359 */         _os_.unmarshal_int();
/* 360 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 363 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 365 */           SGraph _v_ = new SGraph();
/* 366 */           _v_.unmarshal(_os_);
/* 367 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 368 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 373 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 378 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SGraph getOld(int key)
/*     */   {
/* 386 */     return (SGraph)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGraph get(int key)
/*     */   {
/* 391 */     return (SGraph)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGraph> getOldAll()
/*     */   {
/* 396 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGraph> getAll()
/*     */   {
/* 401 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGraph> newAll)
/*     */   {
/* 406 */     oldAll = all;
/* 407 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 412 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\SGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */