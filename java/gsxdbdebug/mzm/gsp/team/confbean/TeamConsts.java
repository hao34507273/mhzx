/*     */ package mzm.gsp.team.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class TeamConsts
/*     */ {
/*  13 */   private static volatile TeamConsts oldInstance = null;
/*     */   
/*  15 */   private static TeamConsts instance = new TeamConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TeamConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static TeamConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int TEAM_CAPACITY = 5;
/*  32 */   public int INVITE_SECONDS = 30;
/*  33 */   public int APPLY_SECONDS = 30;
/*  34 */   public int APPLY_CAPACITY = 30;
/*  35 */   public int TEAM_STABLE_MIN_FIGHTCOUNT = 15;
/*  36 */   public int CHANGE_LEADER_TIME_INTERVAL = 5;
/*  37 */   public int STABLE_TEAM_BUF = 701202000;
/*  38 */   public int ACTIVITY_TEAM_REFRESH_INTERVAL = 2;
/*  39 */   public int ROLE_MATCH_TEAM_BUF = 701202000;
/*  40 */   public int LEADERMATCH_ROLE_BUF = 701202000;
/*  41 */   public int CUT_MEMBER_VIGOUR_VALUE = 5;
/*  42 */   public int CUT_MEMBER_SILVER_VALUE = 50;
/*  43 */   public int CUT_LEADER_VIGOUR_VALUE = 10;
/*  44 */   public int CUT_LEADER_SILVER_VALUE = 100;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  48 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.team.confbean.TeamConsts.xml";
/*     */     try
/*     */     {
/*  56 */       SAXReader reader = new SAXReader();
/*  57 */       org.dom4j.Document doc = reader.read(new File(path));
/*  58 */       Element root = doc.getRootElement();
/*  59 */       Map<String, Element> data = new java.util.HashMap();
/*  60 */       java.util.List<?> nodeList = root.elements();
/*  61 */       int len = nodeList.size();
/*  62 */       for (int i = 0; i < len; i++)
/*     */       {
/*  64 */         Element element = (Element)nodeList.get(i);
/*  65 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  68 */           String name = element.attributeValue("name");
/*  69 */           if (data.put(name, element) != null)
/*  70 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  73 */       this.TEAM_CAPACITY = Integer.valueOf(((Element)data.get("TEAM_CAPACITY")).attributeValue("value")).intValue();
/*  74 */       this.INVITE_SECONDS = Integer.valueOf(((Element)data.get("INVITE_SECONDS")).attributeValue("value")).intValue();
/*  75 */       this.APPLY_SECONDS = Integer.valueOf(((Element)data.get("APPLY_SECONDS")).attributeValue("value")).intValue();
/*  76 */       this.APPLY_CAPACITY = Integer.valueOf(((Element)data.get("APPLY_CAPACITY")).attributeValue("value")).intValue();
/*  77 */       this.TEAM_STABLE_MIN_FIGHTCOUNT = Integer.valueOf(((Element)data.get("TEAM_STABLE_MIN_FIGHTCOUNT")).attributeValue("value")).intValue();
/*  78 */       this.CHANGE_LEADER_TIME_INTERVAL = Integer.valueOf(((Element)data.get("CHANGE_LEADER_TIME_INTERVAL")).attributeValue("value")).intValue();
/*  79 */       this.STABLE_TEAM_BUF = Integer.valueOf(((Element)data.get("STABLE_TEAM_BUF")).attributeValue("value")).intValue();
/*  80 */       this.ACTIVITY_TEAM_REFRESH_INTERVAL = Integer.valueOf(((Element)data.get("ACTIVITY_TEAM_REFRESH_INTERVAL")).attributeValue("value")).intValue();
/*  81 */       this.ROLE_MATCH_TEAM_BUF = Integer.valueOf(((Element)data.get("ROLE_MATCH_TEAM_BUF")).attributeValue("value")).intValue();
/*  82 */       this.LEADERMATCH_ROLE_BUF = Integer.valueOf(((Element)data.get("LEADERMATCH_ROLE_BUF")).attributeValue("value")).intValue();
/*  83 */       this.CUT_MEMBER_VIGOUR_VALUE = Integer.valueOf(((Element)data.get("CUT_MEMBER_VIGOUR_VALUE")).attributeValue("value")).intValue();
/*  84 */       this.CUT_MEMBER_SILVER_VALUE = Integer.valueOf(((Element)data.get("CUT_MEMBER_SILVER_VALUE")).attributeValue("value")).intValue();
/*  85 */       this.CUT_LEADER_VIGOUR_VALUE = Integer.valueOf(((Element)data.get("CUT_LEADER_VIGOUR_VALUE")).attributeValue("value")).intValue();
/*  86 */       this.CUT_LEADER_SILVER_VALUE = Integer.valueOf(((Element)data.get("CUT_LEADER_SILVER_VALUE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  90 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  95 */     String path = dir + "mzm.gsp.team.confbean.TeamConsts.xml";
/*     */     try
/*     */     {
/*  98 */       SAXReader reader = new SAXReader();
/*  99 */       org.dom4j.Document doc = reader.read(new File(path));
/* 100 */       Element root = doc.getRootElement();
/* 101 */       Map<String, Element> data = new java.util.HashMap();
/* 102 */       java.util.List<?> nodeList = root.elements();
/* 103 */       int len = nodeList.size();
/* 104 */       for (int i = 0; i < len; i++)
/*     */       {
/* 106 */         Element element = (Element)nodeList.get(i);
/* 107 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 110 */           String name = element.attributeValue("name");
/* 111 */           if (data.put(name, element) != null)
/* 112 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 115 */       this.TEAM_CAPACITY = Integer.valueOf(((Element)data.get("TEAM_CAPACITY")).attributeValue("value")).intValue();
/* 116 */       this.INVITE_SECONDS = Integer.valueOf(((Element)data.get("INVITE_SECONDS")).attributeValue("value")).intValue();
/* 117 */       this.APPLY_SECONDS = Integer.valueOf(((Element)data.get("APPLY_SECONDS")).attributeValue("value")).intValue();
/* 118 */       this.APPLY_CAPACITY = Integer.valueOf(((Element)data.get("APPLY_CAPACITY")).attributeValue("value")).intValue();
/* 119 */       this.TEAM_STABLE_MIN_FIGHTCOUNT = Integer.valueOf(((Element)data.get("TEAM_STABLE_MIN_FIGHTCOUNT")).attributeValue("value")).intValue();
/* 120 */       this.CHANGE_LEADER_TIME_INTERVAL = Integer.valueOf(((Element)data.get("CHANGE_LEADER_TIME_INTERVAL")).attributeValue("value")).intValue();
/* 121 */       this.STABLE_TEAM_BUF = Integer.valueOf(((Element)data.get("STABLE_TEAM_BUF")).attributeValue("value")).intValue();
/* 122 */       this.ACTIVITY_TEAM_REFRESH_INTERVAL = Integer.valueOf(((Element)data.get("ACTIVITY_TEAM_REFRESH_INTERVAL")).attributeValue("value")).intValue();
/* 123 */       this.ROLE_MATCH_TEAM_BUF = Integer.valueOf(((Element)data.get("ROLE_MATCH_TEAM_BUF")).attributeValue("value")).intValue();
/* 124 */       this.LEADERMATCH_ROLE_BUF = Integer.valueOf(((Element)data.get("LEADERMATCH_ROLE_BUF")).attributeValue("value")).intValue();
/* 125 */       this.CUT_MEMBER_VIGOUR_VALUE = Integer.valueOf(((Element)data.get("CUT_MEMBER_VIGOUR_VALUE")).attributeValue("value")).intValue();
/* 126 */       this.CUT_MEMBER_SILVER_VALUE = Integer.valueOf(((Element)data.get("CUT_MEMBER_SILVER_VALUE")).attributeValue("value")).intValue();
/* 127 */       this.CUT_LEADER_VIGOUR_VALUE = Integer.valueOf(((Element)data.get("CUT_LEADER_VIGOUR_VALUE")).attributeValue("value")).intValue();
/* 128 */       this.CUT_LEADER_SILVER_VALUE = Integer.valueOf(((Element)data.get("CUT_LEADER_SILVER_VALUE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 136 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 139 */     String path = dir + "mzm.gsp.team.confbean.TeamConsts.bny";
/*     */     try
/*     */     {
/* 142 */       File file = new File(path);
/* 143 */       if (file.exists())
/*     */       {
/* 145 */         byte[] bytes = new byte['Ѐ'];
/* 146 */         FileInputStream fis = new FileInputStream(file);
/* 147 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 148 */         int len = 0;
/* 149 */         while ((len = fis.read(bytes)) > 0)
/* 150 */           baos.write(bytes, 0, len);
/* 151 */         fis.close();
/* 152 */         bytes = baos.toByteArray();
/* 153 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 154 */         this.TEAM_CAPACITY = _os_.unmarshal_int();
/* 155 */         this.INVITE_SECONDS = _os_.unmarshal_int();
/* 156 */         this.APPLY_SECONDS = _os_.unmarshal_int();
/* 157 */         this.APPLY_CAPACITY = _os_.unmarshal_int();
/* 158 */         this.TEAM_STABLE_MIN_FIGHTCOUNT = _os_.unmarshal_int();
/* 159 */         this.CHANGE_LEADER_TIME_INTERVAL = _os_.unmarshal_int();
/* 160 */         this.STABLE_TEAM_BUF = _os_.unmarshal_int();
/* 161 */         this.ACTIVITY_TEAM_REFRESH_INTERVAL = _os_.unmarshal_int();
/* 162 */         this.ROLE_MATCH_TEAM_BUF = _os_.unmarshal_int();
/* 163 */         this.LEADERMATCH_ROLE_BUF = _os_.unmarshal_int();
/* 164 */         this.CUT_MEMBER_VIGOUR_VALUE = _os_.unmarshal_int();
/* 165 */         this.CUT_MEMBER_SILVER_VALUE = _os_.unmarshal_int();
/* 166 */         this.CUT_LEADER_VIGOUR_VALUE = _os_.unmarshal_int();
/* 167 */         this.CUT_LEADER_SILVER_VALUE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.team.confbean.TeamConsts.bny";
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
/* 193 */         this.TEAM_CAPACITY = _os_.unmarshal_int();
/* 194 */         this.INVITE_SECONDS = _os_.unmarshal_int();
/* 195 */         this.APPLY_SECONDS = _os_.unmarshal_int();
/* 196 */         this.APPLY_CAPACITY = _os_.unmarshal_int();
/* 197 */         this.TEAM_STABLE_MIN_FIGHTCOUNT = _os_.unmarshal_int();
/* 198 */         this.CHANGE_LEADER_TIME_INTERVAL = _os_.unmarshal_int();
/* 199 */         this.STABLE_TEAM_BUF = _os_.unmarshal_int();
/* 200 */         this.ACTIVITY_TEAM_REFRESH_INTERVAL = _os_.unmarshal_int();
/* 201 */         this.ROLE_MATCH_TEAM_BUF = _os_.unmarshal_int();
/* 202 */         this.LEADERMATCH_ROLE_BUF = _os_.unmarshal_int();
/* 203 */         this.CUT_MEMBER_VIGOUR_VALUE = _os_.unmarshal_int();
/* 204 */         this.CUT_MEMBER_SILVER_VALUE = _os_.unmarshal_int();
/* 205 */         this.CUT_LEADER_VIGOUR_VALUE = _os_.unmarshal_int();
/* 206 */         this.CUT_LEADER_SILVER_VALUE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(TeamConsts newInstance)
/*     */   {
/* 217 */     oldInstance = instance;
/* 218 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 223 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\confbean\TeamConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */