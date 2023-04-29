/*     */ package mzm.gsp.gang.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SGangTeamConst
/*     */ {
/*  13 */   private static volatile SGangTeamConst oldInstance = null;
/*     */   
/*  15 */   private static SGangTeamConst instance = new SGangTeamConst();
/*     */   public int GangTeamInviteSeconds;
/*     */   public int GangTeamBuffid;
/*     */   public int GangTeamBuffNeedNumber;
/*     */   public int GangTeamNameLength;
/*     */   public int JoinTeamMailToOthers;
/*     */   public int JoinTeamMailToSelf;
/*     */   
/*  23 */   public static SGangTeamConst getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static SGangTeamConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int ChangeTeamLeaderMail;
/*     */   
/*     */   public int ChangeTeamLeaderByLeaveTeamMail;
/*     */   
/*     */   public int LeaveTeamMail;
/*     */   
/*     */   public int KickedByTeamLeaderMail;
/*     */   
/*     */   public int LeaveTeamByLeaveGangMail;
/*     */   
/*     */   public int CreateCoolDownMinutes;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  46 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  51 */     String path = dir + "mzm.gsp.gang.confbean.SGangTeamConst.xml";
/*     */     try
/*     */     {
/*  54 */       SAXReader reader = new SAXReader();
/*  55 */       org.dom4j.Document doc = reader.read(new File(path));
/*  56 */       Element root = doc.getRootElement();
/*  57 */       Map<String, Element> data = new java.util.HashMap();
/*  58 */       java.util.List<?> nodeList = root.elements();
/*  59 */       int len = nodeList.size();
/*  60 */       for (int i = 0; i < len; i++)
/*     */       {
/*  62 */         Element element = (Element)nodeList.get(i);
/*  63 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  66 */           String name = element.attributeValue("name");
/*  67 */           if (data.put(name, element) != null)
/*  68 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  71 */       this.GangTeamInviteSeconds = Integer.valueOf(((Element)data.get("GangTeamInviteSeconds")).attributeValue("value")).intValue();
/*  72 */       this.GangTeamBuffid = Integer.valueOf(((Element)data.get("GangTeamBuffid")).attributeValue("value")).intValue();
/*  73 */       this.GangTeamBuffNeedNumber = Integer.valueOf(((Element)data.get("GangTeamBuffNeedNumber")).attributeValue("value")).intValue();
/*  74 */       this.GangTeamNameLength = Integer.valueOf(((Element)data.get("GangTeamNameLength")).attributeValue("value")).intValue();
/*  75 */       this.JoinTeamMailToOthers = Integer.valueOf(((Element)data.get("JoinTeamMailToOthers")).attributeValue("value")).intValue();
/*  76 */       this.JoinTeamMailToSelf = Integer.valueOf(((Element)data.get("JoinTeamMailToSelf")).attributeValue("value")).intValue();
/*  77 */       this.ChangeTeamLeaderMail = Integer.valueOf(((Element)data.get("ChangeTeamLeaderMail")).attributeValue("value")).intValue();
/*  78 */       this.ChangeTeamLeaderByLeaveTeamMail = Integer.valueOf(((Element)data.get("ChangeTeamLeaderByLeaveTeamMail")).attributeValue("value")).intValue();
/*  79 */       this.LeaveTeamMail = Integer.valueOf(((Element)data.get("LeaveTeamMail")).attributeValue("value")).intValue();
/*  80 */       this.KickedByTeamLeaderMail = Integer.valueOf(((Element)data.get("KickedByTeamLeaderMail")).attributeValue("value")).intValue();
/*  81 */       this.LeaveTeamByLeaveGangMail = Integer.valueOf(((Element)data.get("LeaveTeamByLeaveGangMail")).attributeValue("value")).intValue();
/*  82 */       this.CreateCoolDownMinutes = Integer.valueOf(((Element)data.get("CreateCoolDownMinutes")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  86 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  91 */     String path = dir + "mzm.gsp.gang.confbean.SGangTeamConst.xml";
/*     */     try
/*     */     {
/*  94 */       SAXReader reader = new SAXReader();
/*  95 */       org.dom4j.Document doc = reader.read(new File(path));
/*  96 */       Element root = doc.getRootElement();
/*  97 */       Map<String, Element> data = new java.util.HashMap();
/*  98 */       java.util.List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element element = (Element)nodeList.get(i);
/* 103 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 106 */           String name = element.attributeValue("name");
/* 107 */           if (data.put(name, element) != null)
/* 108 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 111 */       this.GangTeamInviteSeconds = Integer.valueOf(((Element)data.get("GangTeamInviteSeconds")).attributeValue("value")).intValue();
/* 112 */       this.GangTeamBuffid = Integer.valueOf(((Element)data.get("GangTeamBuffid")).attributeValue("value")).intValue();
/* 113 */       this.GangTeamBuffNeedNumber = Integer.valueOf(((Element)data.get("GangTeamBuffNeedNumber")).attributeValue("value")).intValue();
/* 114 */       this.GangTeamNameLength = Integer.valueOf(((Element)data.get("GangTeamNameLength")).attributeValue("value")).intValue();
/* 115 */       this.JoinTeamMailToOthers = Integer.valueOf(((Element)data.get("JoinTeamMailToOthers")).attributeValue("value")).intValue();
/* 116 */       this.JoinTeamMailToSelf = Integer.valueOf(((Element)data.get("JoinTeamMailToSelf")).attributeValue("value")).intValue();
/* 117 */       this.ChangeTeamLeaderMail = Integer.valueOf(((Element)data.get("ChangeTeamLeaderMail")).attributeValue("value")).intValue();
/* 118 */       this.ChangeTeamLeaderByLeaveTeamMail = Integer.valueOf(((Element)data.get("ChangeTeamLeaderByLeaveTeamMail")).attributeValue("value")).intValue();
/* 119 */       this.LeaveTeamMail = Integer.valueOf(((Element)data.get("LeaveTeamMail")).attributeValue("value")).intValue();
/* 120 */       this.KickedByTeamLeaderMail = Integer.valueOf(((Element)data.get("KickedByTeamLeaderMail")).attributeValue("value")).intValue();
/* 121 */       this.LeaveTeamByLeaveGangMail = Integer.valueOf(((Element)data.get("LeaveTeamByLeaveGangMail")).attributeValue("value")).intValue();
/* 122 */       this.CreateCoolDownMinutes = Integer.valueOf(((Element)data.get("CreateCoolDownMinutes")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 126 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 130 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 133 */     String path = dir + "mzm.gsp.gang.confbean.SGangTeamConst.bny";
/*     */     try
/*     */     {
/* 136 */       File file = new File(path);
/* 137 */       if (file.exists())
/*     */       {
/* 139 */         byte[] bytes = new byte['Ѐ'];
/* 140 */         FileInputStream fis = new FileInputStream(file);
/* 141 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 142 */         int len = 0;
/* 143 */         while ((len = fis.read(bytes)) > 0)
/* 144 */           baos.write(bytes, 0, len);
/* 145 */         fis.close();
/* 146 */         bytes = baos.toByteArray();
/* 147 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 148 */         this.GangTeamInviteSeconds = _os_.unmarshal_int();
/* 149 */         this.GangTeamBuffid = _os_.unmarshal_int();
/* 150 */         this.GangTeamBuffNeedNumber = _os_.unmarshal_int();
/* 151 */         this.GangTeamNameLength = _os_.unmarshal_int();
/* 152 */         this.JoinTeamMailToOthers = _os_.unmarshal_int();
/* 153 */         this.JoinTeamMailToSelf = _os_.unmarshal_int();
/* 154 */         this.ChangeTeamLeaderMail = _os_.unmarshal_int();
/* 155 */         this.ChangeTeamLeaderByLeaveTeamMail = _os_.unmarshal_int();
/* 156 */         this.LeaveTeamMail = _os_.unmarshal_int();
/* 157 */         this.KickedByTeamLeaderMail = _os_.unmarshal_int();
/* 158 */         this.LeaveTeamByLeaveGangMail = _os_.unmarshal_int();
/* 159 */         this.CreateCoolDownMinutes = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 170 */     String path = dir + "mzm.gsp.gang.confbean.SGangTeamConst.bny";
/*     */     try
/*     */     {
/* 173 */       File file = new File(path);
/* 174 */       if (file.exists())
/*     */       {
/* 176 */         byte[] bytes = new byte['Ѐ'];
/* 177 */         FileInputStream fis = new FileInputStream(file);
/* 178 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 179 */         int len = 0;
/* 180 */         while ((len = fis.read(bytes)) > 0)
/* 181 */           baos.write(bytes, 0, len);
/* 182 */         fis.close();
/* 183 */         bytes = baos.toByteArray();
/* 184 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 185 */         this.GangTeamInviteSeconds = _os_.unmarshal_int();
/* 186 */         this.GangTeamBuffid = _os_.unmarshal_int();
/* 187 */         this.GangTeamBuffNeedNumber = _os_.unmarshal_int();
/* 188 */         this.GangTeamNameLength = _os_.unmarshal_int();
/* 189 */         this.JoinTeamMailToOthers = _os_.unmarshal_int();
/* 190 */         this.JoinTeamMailToSelf = _os_.unmarshal_int();
/* 191 */         this.ChangeTeamLeaderMail = _os_.unmarshal_int();
/* 192 */         this.ChangeTeamLeaderByLeaveTeamMail = _os_.unmarshal_int();
/* 193 */         this.LeaveTeamMail = _os_.unmarshal_int();
/* 194 */         this.KickedByTeamLeaderMail = _os_.unmarshal_int();
/* 195 */         this.LeaveTeamByLeaveGangMail = _os_.unmarshal_int();
/* 196 */         this.CreateCoolDownMinutes = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SGangTeamConst newInstance)
/*     */   {
/* 207 */     oldInstance = instance;
/* 208 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 213 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\SGangTeamConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */