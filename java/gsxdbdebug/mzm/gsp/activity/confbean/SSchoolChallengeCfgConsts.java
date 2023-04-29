/*     */ package mzm.gsp.activity.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SSchoolChallengeCfgConsts
/*     */ {
/*  13 */   private static volatile SSchoolChallengeCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SSchoolChallengeCfgConsts instance = new SSchoolChallengeCfgConsts();
/*     */   public int ACTIVITYID;
/*     */   public int GRAPH_ID;
/*     */   public int NPC_ID;
/*     */   public int RING_REWARDID;
/*     */   
/*     */   public static SSchoolChallengeCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SSchoolChallengeCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int RING_TO_COIRCLE;
/*     */   
/*     */   public int MAX_AWARD_COUNT;
/*     */   
/*     */   public int CONTROLLER_ID;
/*     */   
/*     */   public int NPC_SERVICE;
/*  39 */   public java.util.ArrayList<Integer> circleRewardids = new java.util.ArrayList();
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  43 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  48 */     String path = dir + "mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts.xml";
/*     */     try
/*     */     {
/*  51 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  52 */       org.dom4j.Document doc = reader.read(new File(path));
/*  53 */       Element root = doc.getRootElement();
/*  54 */       Map<String, Element> data = new java.util.HashMap();
/*  55 */       List<?> nodeList = root.elements();
/*  56 */       int len = nodeList.size();
/*  57 */       for (int i = 0; i < len; i++)
/*     */       {
/*  59 */         Element element = (Element)nodeList.get(i);
/*  60 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  63 */           String name = element.attributeValue("name");
/*  64 */           if (data.put(name, element) != null)
/*  65 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  68 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  69 */       this.GRAPH_ID = Integer.valueOf(((Element)data.get("GRAPH_ID")).attributeValue("value")).intValue();
/*  70 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  71 */       this.RING_REWARDID = Integer.valueOf(((Element)data.get("RING_REWARDID")).attributeValue("value")).intValue();
/*  72 */       this.RING_TO_COIRCLE = Integer.valueOf(((Element)data.get("RING_TO_COIRCLE")).attributeValue("value")).intValue();
/*  73 */       this.MAX_AWARD_COUNT = Integer.valueOf(((Element)data.get("MAX_AWARD_COUNT")).attributeValue("value")).intValue();
/*  74 */       this.CONTROLLER_ID = Integer.valueOf(((Element)data.get("CONTROLLER_ID")).attributeValue("value")).intValue();
/*  75 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/*     */       
/*  77 */       Element collectionElement = (Element)data.get("circleRewardids");
/*  78 */       if (collectionElement == null)
/*     */       {
/*  80 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/*  83 */       List<?> _nodeList = collectionElement.elements();
/*  84 */       int _len = _nodeList.size();
/*  85 */       for (int i = 0; i < _len; i++)
/*     */       {
/*  87 */         Element elem = (Element)_nodeList.get(i);
/*  88 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/*  95 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 102 */           this.circleRewardids.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 113 */     String path = dir + "mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts.xml";
/*     */     try
/*     */     {
/* 116 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 117 */       org.dom4j.Document doc = reader.read(new File(path));
/* 118 */       Element root = doc.getRootElement();
/* 119 */       Map<String, Element> data = new java.util.HashMap();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element element = (Element)nodeList.get(i);
/* 125 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 128 */           String name = element.attributeValue("name");
/* 129 */           if (data.put(name, element) != null)
/* 130 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 133 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 134 */       this.GRAPH_ID = Integer.valueOf(((Element)data.get("GRAPH_ID")).attributeValue("value")).intValue();
/* 135 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 136 */       this.RING_REWARDID = Integer.valueOf(((Element)data.get("RING_REWARDID")).attributeValue("value")).intValue();
/* 137 */       this.RING_TO_COIRCLE = Integer.valueOf(((Element)data.get("RING_TO_COIRCLE")).attributeValue("value")).intValue();
/* 138 */       this.MAX_AWARD_COUNT = Integer.valueOf(((Element)data.get("MAX_AWARD_COUNT")).attributeValue("value")).intValue();
/* 139 */       this.CONTROLLER_ID = Integer.valueOf(((Element)data.get("CONTROLLER_ID")).attributeValue("value")).intValue();
/* 140 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/*     */       
/* 142 */       Element collectionElement = (Element)data.get("circleRewardids");
/* 143 */       if (collectionElement == null)
/*     */       {
/* 145 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 148 */       List<?> _nodeList = collectionElement.elements();
/* 149 */       int _len = _nodeList.size();
/* 150 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 152 */         Element elem = (Element)_nodeList.get(i);
/* 153 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 160 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 167 */           this.circleRewardids.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 173 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 177 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 180 */     String path = dir + "mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts.bny";
/*     */     try
/*     */     {
/* 183 */       File file = new File(path);
/* 184 */       if (file.exists())
/*     */       {
/* 186 */         byte[] bytes = new byte['Ѐ'];
/* 187 */         FileInputStream fis = new FileInputStream(file);
/* 188 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 189 */         int len = 0;
/* 190 */         while ((len = fis.read(bytes)) > 0)
/* 191 */           baos.write(bytes, 0, len);
/* 192 */         fis.close();
/* 193 */         bytes = baos.toByteArray();
/* 194 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 195 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 196 */         this.GRAPH_ID = _os_.unmarshal_int();
/* 197 */         this.NPC_ID = _os_.unmarshal_int();
/* 198 */         this.RING_REWARDID = _os_.unmarshal_int();
/* 199 */         this.RING_TO_COIRCLE = _os_.unmarshal_int();
/* 200 */         this.MAX_AWARD_COUNT = _os_.unmarshal_int();
/* 201 */         this.CONTROLLER_ID = _os_.unmarshal_int();
/* 202 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 203 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 206 */           int _v_ = _os_.unmarshal_int();
/* 207 */           this.circleRewardids.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 219 */     String path = dir + "mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts.bny";
/*     */     try
/*     */     {
/* 222 */       File file = new File(path);
/* 223 */       if (file.exists())
/*     */       {
/* 225 */         byte[] bytes = new byte['Ѐ'];
/* 226 */         FileInputStream fis = new FileInputStream(file);
/* 227 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 228 */         int len = 0;
/* 229 */         while ((len = fis.read(bytes)) > 0)
/* 230 */           baos.write(bytes, 0, len);
/* 231 */         fis.close();
/* 232 */         bytes = baos.toByteArray();
/* 233 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 234 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 235 */         this.GRAPH_ID = _os_.unmarshal_int();
/* 236 */         this.NPC_ID = _os_.unmarshal_int();
/* 237 */         this.RING_REWARDID = _os_.unmarshal_int();
/* 238 */         this.RING_TO_COIRCLE = _os_.unmarshal_int();
/* 239 */         this.MAX_AWARD_COUNT = _os_.unmarshal_int();
/* 240 */         this.CONTROLLER_ID = _os_.unmarshal_int();
/* 241 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 242 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 245 */           int _v_ = _os_.unmarshal_int();
/* 246 */           this.circleRewardids.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 252 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SSchoolChallengeCfgConsts newInstance)
/*     */   {
/* 258 */     oldInstance = instance;
/* 259 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 264 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SSchoolChallengeCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */