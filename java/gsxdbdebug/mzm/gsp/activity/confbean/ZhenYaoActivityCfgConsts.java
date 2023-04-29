/*     */ package mzm.gsp.activity.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class ZhenYaoActivityCfgConsts
/*     */ {
/*  13 */   private static volatile ZhenYaoActivityCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static ZhenYaoActivityCfgConsts instance = new ZhenYaoActivityCfgConsts();
/*     */   public int ACTIVITYID;
/*     */   public int GRAPH_ID;
/*     */   public int NPC_ID;
/*     */   public int NPC_SERVICE;
/*     */   public int REWARDID;
/*     */   public int REWARDID2;
/*     */   
/*  23 */   public static ZhenYaoActivityCfgConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static ZhenYaoActivityCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int MAX_AWARD_COUNT;
/*     */   
/*     */   public int MAX_AWARD_COUNT2;
/*     */   
/*     */   public int FIGHT_DEC_DOUBLE_POINT;
/*     */   
/*     */   public int FIGHT_DEC_DOUBLE_POINT2;
/*     */   
/*     */   public int MAX_LEVEL_DELTA;
/*     */   
/*     */   public int MUSIC_TIP_FOR_LEADER;
/*     */   
/*     */   public int XIAYI_ADD_NUM;
/*     */   public int XIAYI_ADD_NUM2;
/*     */   public int MAX_XIAYI_NUM;
/*     */   public int MIN_LEVEL_DELTA;
/*     */   public int MIN_DOUBLE_POINT_TIP;
/*     */   public int EXP_CHANGE_RATE;
/*     */   public int GUIDE_GRAPH_ID;
/*     */   public int STORAGE_EXP_NUM;
/*     */   public int STORAGE_EXP_NUM2;
/*     */   public int CIRCLE_MOD;
/*     */   public int DEC_SERVICE1;
/*     */   public int DEC_SERVICE2;
/*     */   public int QUERY_SERVICE1;
/*     */   public int QUERY_SERVICE2;
/*     */   public int RETURN_BACK_EXP_CHANGE_RATE;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  61 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  66 */     String path = dir + "mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts.xml";
/*     */     try
/*     */     {
/*  69 */       SAXReader reader = new SAXReader();
/*  70 */       org.dom4j.Document doc = reader.read(new File(path));
/*  71 */       Element root = doc.getRootElement();
/*  72 */       Map<String, Element> data = new java.util.HashMap();
/*  73 */       java.util.List<?> nodeList = root.elements();
/*  74 */       int len = nodeList.size();
/*  75 */       for (int i = 0; i < len; i++)
/*     */       {
/*  77 */         Element element = (Element)nodeList.get(i);
/*  78 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  81 */           String name = element.attributeValue("name");
/*  82 */           if (data.put(name, element) != null)
/*  83 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  86 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  87 */       this.GRAPH_ID = Integer.valueOf(((Element)data.get("GRAPH_ID")).attributeValue("value")).intValue();
/*  88 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  89 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/*  90 */       this.REWARDID = Integer.valueOf(((Element)data.get("REWARDID")).attributeValue("value")).intValue();
/*  91 */       this.REWARDID2 = Integer.valueOf(((Element)data.get("REWARDID2")).attributeValue("value")).intValue();
/*  92 */       this.MAX_AWARD_COUNT = Integer.valueOf(((Element)data.get("MAX_AWARD_COUNT")).attributeValue("value")).intValue();
/*  93 */       this.MAX_AWARD_COUNT2 = Integer.valueOf(((Element)data.get("MAX_AWARD_COUNT2")).attributeValue("value")).intValue();
/*  94 */       this.FIGHT_DEC_DOUBLE_POINT = Integer.valueOf(((Element)data.get("FIGHT_DEC_DOUBLE_POINT")).attributeValue("value")).intValue();
/*  95 */       this.FIGHT_DEC_DOUBLE_POINT2 = Integer.valueOf(((Element)data.get("FIGHT_DEC_DOUBLE_POINT2")).attributeValue("value")).intValue();
/*  96 */       this.MAX_LEVEL_DELTA = Integer.valueOf(((Element)data.get("MAX_LEVEL_DELTA")).attributeValue("value")).intValue();
/*  97 */       this.MUSIC_TIP_FOR_LEADER = Integer.valueOf(((Element)data.get("MUSIC_TIP_FOR_LEADER")).attributeValue("value")).intValue();
/*  98 */       this.XIAYI_ADD_NUM = Integer.valueOf(((Element)data.get("XIAYI_ADD_NUM")).attributeValue("value")).intValue();
/*  99 */       this.XIAYI_ADD_NUM2 = Integer.valueOf(((Element)data.get("XIAYI_ADD_NUM2")).attributeValue("value")).intValue();
/* 100 */       this.MAX_XIAYI_NUM = Integer.valueOf(((Element)data.get("MAX_XIAYI_NUM")).attributeValue("value")).intValue();
/* 101 */       this.MIN_LEVEL_DELTA = Integer.valueOf(((Element)data.get("MIN_LEVEL_DELTA")).attributeValue("value")).intValue();
/* 102 */       this.MIN_DOUBLE_POINT_TIP = Integer.valueOf(((Element)data.get("MIN_DOUBLE_POINT_TIP")).attributeValue("value")).intValue();
/* 103 */       this.EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/* 104 */       this.GUIDE_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIDE_GRAPH_ID")).attributeValue("value")).intValue();
/* 105 */       this.STORAGE_EXP_NUM = Integer.valueOf(((Element)data.get("STORAGE_EXP_NUM")).attributeValue("value")).intValue();
/* 106 */       this.STORAGE_EXP_NUM2 = Integer.valueOf(((Element)data.get("STORAGE_EXP_NUM2")).attributeValue("value")).intValue();
/* 107 */       this.CIRCLE_MOD = Integer.valueOf(((Element)data.get("CIRCLE_MOD")).attributeValue("value")).intValue();
/* 108 */       this.DEC_SERVICE1 = Integer.valueOf(((Element)data.get("DEC_SERVICE1")).attributeValue("value")).intValue();
/* 109 */       this.DEC_SERVICE2 = Integer.valueOf(((Element)data.get("DEC_SERVICE2")).attributeValue("value")).intValue();
/* 110 */       this.QUERY_SERVICE1 = Integer.valueOf(((Element)data.get("QUERY_SERVICE1")).attributeValue("value")).intValue();
/* 111 */       this.QUERY_SERVICE2 = Integer.valueOf(((Element)data.get("QUERY_SERVICE2")).attributeValue("value")).intValue();
/* 112 */       this.RETURN_BACK_EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("RETURN_BACK_EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 116 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 121 */     String path = dir + "mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts.xml";
/*     */     try
/*     */     {
/* 124 */       SAXReader reader = new SAXReader();
/* 125 */       org.dom4j.Document doc = reader.read(new File(path));
/* 126 */       Element root = doc.getRootElement();
/* 127 */       Map<String, Element> data = new java.util.HashMap();
/* 128 */       java.util.List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element element = (Element)nodeList.get(i);
/* 133 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 136 */           String name = element.attributeValue("name");
/* 137 */           if (data.put(name, element) != null)
/* 138 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 141 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 142 */       this.GRAPH_ID = Integer.valueOf(((Element)data.get("GRAPH_ID")).attributeValue("value")).intValue();
/* 143 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 144 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/* 145 */       this.REWARDID = Integer.valueOf(((Element)data.get("REWARDID")).attributeValue("value")).intValue();
/* 146 */       this.REWARDID2 = Integer.valueOf(((Element)data.get("REWARDID2")).attributeValue("value")).intValue();
/* 147 */       this.MAX_AWARD_COUNT = Integer.valueOf(((Element)data.get("MAX_AWARD_COUNT")).attributeValue("value")).intValue();
/* 148 */       this.MAX_AWARD_COUNT2 = Integer.valueOf(((Element)data.get("MAX_AWARD_COUNT2")).attributeValue("value")).intValue();
/* 149 */       this.FIGHT_DEC_DOUBLE_POINT = Integer.valueOf(((Element)data.get("FIGHT_DEC_DOUBLE_POINT")).attributeValue("value")).intValue();
/* 150 */       this.FIGHT_DEC_DOUBLE_POINT2 = Integer.valueOf(((Element)data.get("FIGHT_DEC_DOUBLE_POINT2")).attributeValue("value")).intValue();
/* 151 */       this.MAX_LEVEL_DELTA = Integer.valueOf(((Element)data.get("MAX_LEVEL_DELTA")).attributeValue("value")).intValue();
/* 152 */       this.MUSIC_TIP_FOR_LEADER = Integer.valueOf(((Element)data.get("MUSIC_TIP_FOR_LEADER")).attributeValue("value")).intValue();
/* 153 */       this.XIAYI_ADD_NUM = Integer.valueOf(((Element)data.get("XIAYI_ADD_NUM")).attributeValue("value")).intValue();
/* 154 */       this.XIAYI_ADD_NUM2 = Integer.valueOf(((Element)data.get("XIAYI_ADD_NUM2")).attributeValue("value")).intValue();
/* 155 */       this.MAX_XIAYI_NUM = Integer.valueOf(((Element)data.get("MAX_XIAYI_NUM")).attributeValue("value")).intValue();
/* 156 */       this.MIN_LEVEL_DELTA = Integer.valueOf(((Element)data.get("MIN_LEVEL_DELTA")).attributeValue("value")).intValue();
/* 157 */       this.MIN_DOUBLE_POINT_TIP = Integer.valueOf(((Element)data.get("MIN_DOUBLE_POINT_TIP")).attributeValue("value")).intValue();
/* 158 */       this.EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/* 159 */       this.GUIDE_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIDE_GRAPH_ID")).attributeValue("value")).intValue();
/* 160 */       this.STORAGE_EXP_NUM = Integer.valueOf(((Element)data.get("STORAGE_EXP_NUM")).attributeValue("value")).intValue();
/* 161 */       this.STORAGE_EXP_NUM2 = Integer.valueOf(((Element)data.get("STORAGE_EXP_NUM2")).attributeValue("value")).intValue();
/* 162 */       this.CIRCLE_MOD = Integer.valueOf(((Element)data.get("CIRCLE_MOD")).attributeValue("value")).intValue();
/* 163 */       this.DEC_SERVICE1 = Integer.valueOf(((Element)data.get("DEC_SERVICE1")).attributeValue("value")).intValue();
/* 164 */       this.DEC_SERVICE2 = Integer.valueOf(((Element)data.get("DEC_SERVICE2")).attributeValue("value")).intValue();
/* 165 */       this.QUERY_SERVICE1 = Integer.valueOf(((Element)data.get("QUERY_SERVICE1")).attributeValue("value")).intValue();
/* 166 */       this.QUERY_SERVICE2 = Integer.valueOf(((Element)data.get("QUERY_SERVICE2")).attributeValue("value")).intValue();
/* 167 */       this.RETURN_BACK_EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("RETURN_BACK_EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 175 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 178 */     String path = dir + "mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts.bny";
/*     */     try
/*     */     {
/* 181 */       File file = new File(path);
/* 182 */       if (file.exists())
/*     */       {
/* 184 */         byte[] bytes = new byte['Ѐ'];
/* 185 */         FileInputStream fis = new FileInputStream(file);
/* 186 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 187 */         int len = 0;
/* 188 */         while ((len = fis.read(bytes)) > 0)
/* 189 */           baos.write(bytes, 0, len);
/* 190 */         fis.close();
/* 191 */         bytes = baos.toByteArray();
/* 192 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 193 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 194 */         this.GRAPH_ID = _os_.unmarshal_int();
/* 195 */         this.NPC_ID = _os_.unmarshal_int();
/* 196 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 197 */         this.REWARDID = _os_.unmarshal_int();
/* 198 */         this.REWARDID2 = _os_.unmarshal_int();
/* 199 */         this.MAX_AWARD_COUNT = _os_.unmarshal_int();
/* 200 */         this.MAX_AWARD_COUNT2 = _os_.unmarshal_int();
/* 201 */         this.FIGHT_DEC_DOUBLE_POINT = _os_.unmarshal_int();
/* 202 */         this.FIGHT_DEC_DOUBLE_POINT2 = _os_.unmarshal_int();
/* 203 */         this.MAX_LEVEL_DELTA = _os_.unmarshal_int();
/* 204 */         this.MUSIC_TIP_FOR_LEADER = _os_.unmarshal_int();
/* 205 */         this.XIAYI_ADD_NUM = _os_.unmarshal_int();
/* 206 */         this.XIAYI_ADD_NUM2 = _os_.unmarshal_int();
/* 207 */         this.MAX_XIAYI_NUM = _os_.unmarshal_int();
/* 208 */         this.MIN_LEVEL_DELTA = _os_.unmarshal_int();
/* 209 */         this.MIN_DOUBLE_POINT_TIP = _os_.unmarshal_int();
/* 210 */         this.EXP_CHANGE_RATE = _os_.unmarshal_int();
/* 211 */         this.GUIDE_GRAPH_ID = _os_.unmarshal_int();
/* 212 */         this.STORAGE_EXP_NUM = _os_.unmarshal_int();
/* 213 */         this.STORAGE_EXP_NUM2 = _os_.unmarshal_int();
/* 214 */         this.CIRCLE_MOD = _os_.unmarshal_int();
/* 215 */         this.DEC_SERVICE1 = _os_.unmarshal_int();
/* 216 */         this.DEC_SERVICE2 = _os_.unmarshal_int();
/* 217 */         this.QUERY_SERVICE1 = _os_.unmarshal_int();
/* 218 */         this.QUERY_SERVICE2 = _os_.unmarshal_int();
/* 219 */         this.RETURN_BACK_EXP_CHANGE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 224 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 230 */     String path = dir + "mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts.bny";
/*     */     try
/*     */     {
/* 233 */       File file = new File(path);
/* 234 */       if (file.exists())
/*     */       {
/* 236 */         byte[] bytes = new byte['Ѐ'];
/* 237 */         FileInputStream fis = new FileInputStream(file);
/* 238 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 239 */         int len = 0;
/* 240 */         while ((len = fis.read(bytes)) > 0)
/* 241 */           baos.write(bytes, 0, len);
/* 242 */         fis.close();
/* 243 */         bytes = baos.toByteArray();
/* 244 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 245 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 246 */         this.GRAPH_ID = _os_.unmarshal_int();
/* 247 */         this.NPC_ID = _os_.unmarshal_int();
/* 248 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 249 */         this.REWARDID = _os_.unmarshal_int();
/* 250 */         this.REWARDID2 = _os_.unmarshal_int();
/* 251 */         this.MAX_AWARD_COUNT = _os_.unmarshal_int();
/* 252 */         this.MAX_AWARD_COUNT2 = _os_.unmarshal_int();
/* 253 */         this.FIGHT_DEC_DOUBLE_POINT = _os_.unmarshal_int();
/* 254 */         this.FIGHT_DEC_DOUBLE_POINT2 = _os_.unmarshal_int();
/* 255 */         this.MAX_LEVEL_DELTA = _os_.unmarshal_int();
/* 256 */         this.MUSIC_TIP_FOR_LEADER = _os_.unmarshal_int();
/* 257 */         this.XIAYI_ADD_NUM = _os_.unmarshal_int();
/* 258 */         this.XIAYI_ADD_NUM2 = _os_.unmarshal_int();
/* 259 */         this.MAX_XIAYI_NUM = _os_.unmarshal_int();
/* 260 */         this.MIN_LEVEL_DELTA = _os_.unmarshal_int();
/* 261 */         this.MIN_DOUBLE_POINT_TIP = _os_.unmarshal_int();
/* 262 */         this.EXP_CHANGE_RATE = _os_.unmarshal_int();
/* 263 */         this.GUIDE_GRAPH_ID = _os_.unmarshal_int();
/* 264 */         this.STORAGE_EXP_NUM = _os_.unmarshal_int();
/* 265 */         this.STORAGE_EXP_NUM2 = _os_.unmarshal_int();
/* 266 */         this.CIRCLE_MOD = _os_.unmarshal_int();
/* 267 */         this.DEC_SERVICE1 = _os_.unmarshal_int();
/* 268 */         this.DEC_SERVICE2 = _os_.unmarshal_int();
/* 269 */         this.QUERY_SERVICE1 = _os_.unmarshal_int();
/* 270 */         this.QUERY_SERVICE2 = _os_.unmarshal_int();
/* 271 */         this.RETURN_BACK_EXP_CHANGE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 276 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(ZhenYaoActivityCfgConsts newInstance)
/*     */   {
/* 282 */     oldInstance = instance;
/* 283 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 288 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\ZhenYaoActivityCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */