/*     */ package mzm.gsp.gang.confbean;
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
/*     */ public class SGangDutyCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGangDutyCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGangDutyCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int dutyLevel;
/*     */   public boolean isCanModifyName;
/*     */   public boolean isCanTanHe;
/*     */   public boolean isCanDesignDutyName;
/*     */   public boolean isCanModifyPurpose;
/*     */   public boolean isCanLevelUpGang;
/*     */   public boolean isCanSetGangTask;
/*     */   public boolean isCanAssignDuty;
/*     */   public boolean isCanKick;
/*     */   public boolean isCanSetCallState;
/*     */   public boolean isCanForbidden;
/*     */   public boolean isCanPublishAnnouncement;
/*     */   public boolean isCanMgeApplyList;
/*     */   public boolean isCanInvite;
/*     */   public boolean canActivatePVE;
/*     */   public boolean canSignUpCrossCompete;
/*     */   public int kickNeedVigor;
/*     */   public int weekAwardId;
/*     */   public int payRate;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  42 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  43 */     this.templatename = rootElement.attributeValue("templatename");
/*  44 */     this.dutyLevel = Integer.valueOf(rootElement.attributeValue("dutyLevel")).intValue();
/*  45 */     this.isCanModifyName = Boolean.valueOf(rootElement.attributeValue("isCanModifyName")).booleanValue();
/*  46 */     this.isCanTanHe = Boolean.valueOf(rootElement.attributeValue("isCanTanHe")).booleanValue();
/*  47 */     this.isCanDesignDutyName = Boolean.valueOf(rootElement.attributeValue("isCanDesignDutyName")).booleanValue();
/*  48 */     this.isCanModifyPurpose = Boolean.valueOf(rootElement.attributeValue("isCanModifyPurpose")).booleanValue();
/*  49 */     this.isCanLevelUpGang = Boolean.valueOf(rootElement.attributeValue("isCanLevelUpGang")).booleanValue();
/*  50 */     this.isCanSetGangTask = Boolean.valueOf(rootElement.attributeValue("isCanSetGangTask")).booleanValue();
/*  51 */     this.isCanAssignDuty = Boolean.valueOf(rootElement.attributeValue("isCanAssignDuty")).booleanValue();
/*  52 */     this.isCanKick = Boolean.valueOf(rootElement.attributeValue("isCanKick")).booleanValue();
/*  53 */     this.isCanSetCallState = Boolean.valueOf(rootElement.attributeValue("isCanSetCallState")).booleanValue();
/*  54 */     this.isCanForbidden = Boolean.valueOf(rootElement.attributeValue("isCanForbidden")).booleanValue();
/*  55 */     this.isCanPublishAnnouncement = Boolean.valueOf(rootElement.attributeValue("isCanPublishAnnouncement")).booleanValue();
/*  56 */     this.isCanMgeApplyList = Boolean.valueOf(rootElement.attributeValue("isCanMgeApplyList")).booleanValue();
/*  57 */     this.isCanInvite = Boolean.valueOf(rootElement.attributeValue("isCanInvite")).booleanValue();
/*  58 */     this.canActivatePVE = Boolean.valueOf(rootElement.attributeValue("canActivatePVE")).booleanValue();
/*  59 */     this.canSignUpCrossCompete = Boolean.valueOf(rootElement.attributeValue("canSignUpCrossCompete")).booleanValue();
/*  60 */     this.kickNeedVigor = Integer.valueOf(rootElement.attributeValue("kickNeedVigor")).intValue();
/*  61 */     this.weekAwardId = Integer.valueOf(rootElement.attributeValue("weekAwardId")).intValue();
/*  62 */     this.payRate = Integer.valueOf(rootElement.attributeValue("payRate")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _os_.marshal(this.id);
/*  68 */     _os_.marshal(this.templatename, "UTF-8");
/*  69 */     _os_.marshal(this.dutyLevel);
/*  70 */     _os_.marshal(this.isCanModifyName);
/*  71 */     _os_.marshal(this.isCanTanHe);
/*  72 */     _os_.marshal(this.isCanDesignDutyName);
/*  73 */     _os_.marshal(this.isCanModifyPurpose);
/*  74 */     _os_.marshal(this.isCanLevelUpGang);
/*  75 */     _os_.marshal(this.isCanSetGangTask);
/*  76 */     _os_.marshal(this.isCanAssignDuty);
/*  77 */     _os_.marshal(this.isCanKick);
/*  78 */     _os_.marshal(this.isCanSetCallState);
/*  79 */     _os_.marshal(this.isCanForbidden);
/*  80 */     _os_.marshal(this.isCanPublishAnnouncement);
/*  81 */     _os_.marshal(this.isCanMgeApplyList);
/*  82 */     _os_.marshal(this.isCanInvite);
/*  83 */     _os_.marshal(this.canActivatePVE);
/*  84 */     _os_.marshal(this.canSignUpCrossCompete);
/*  85 */     _os_.marshal(this.kickNeedVigor);
/*  86 */     _os_.marshal(this.weekAwardId);
/*  87 */     _os_.marshal(this.payRate);
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     this.id = _os_.unmarshal_int();
/*  94 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  95 */     this.dutyLevel = _os_.unmarshal_int();
/*  96 */     this.isCanModifyName = _os_.unmarshal_boolean();
/*  97 */     this.isCanTanHe = _os_.unmarshal_boolean();
/*  98 */     this.isCanDesignDutyName = _os_.unmarshal_boolean();
/*  99 */     this.isCanModifyPurpose = _os_.unmarshal_boolean();
/* 100 */     this.isCanLevelUpGang = _os_.unmarshal_boolean();
/* 101 */     this.isCanSetGangTask = _os_.unmarshal_boolean();
/* 102 */     this.isCanAssignDuty = _os_.unmarshal_boolean();
/* 103 */     this.isCanKick = _os_.unmarshal_boolean();
/* 104 */     this.isCanSetCallState = _os_.unmarshal_boolean();
/* 105 */     this.isCanForbidden = _os_.unmarshal_boolean();
/* 106 */     this.isCanPublishAnnouncement = _os_.unmarshal_boolean();
/* 107 */     this.isCanMgeApplyList = _os_.unmarshal_boolean();
/* 108 */     this.isCanInvite = _os_.unmarshal_boolean();
/* 109 */     this.canActivatePVE = _os_.unmarshal_boolean();
/* 110 */     this.canSignUpCrossCompete = _os_.unmarshal_boolean();
/* 111 */     this.kickNeedVigor = _os_.unmarshal_int();
/* 112 */     this.weekAwardId = _os_.unmarshal_int();
/* 113 */     this.payRate = _os_.unmarshal_int();
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 119 */     String path = dir + "mzm.gsp.gang.confbean.SGangDutyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 123 */       all = new java.util.HashMap();
/* 124 */       SAXReader reader = new SAXReader();
/* 125 */       org.dom4j.Document doc = reader.read(new File(path));
/* 126 */       Element root = doc.getRootElement();
/* 127 */       List<?> nodeList = root.elements();
/* 128 */       int len = nodeList.size();
/* 129 */       for (int i = 0; i < len; i++)
/*     */       {
/* 131 */         Element elem = (Element)nodeList.get(i);
/* 132 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.SGangDutyCfg"))
/*     */         {
/*     */ 
/* 135 */           SGangDutyCfg obj = new SGangDutyCfg();
/* 136 */           obj.loadFromXml(elem);
/* 137 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 138 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 143 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGangDutyCfg> all)
/*     */   {
/* 149 */     String path = dir + "mzm.gsp.gang.confbean.SGangDutyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 153 */       SAXReader reader = new SAXReader();
/* 154 */       org.dom4j.Document doc = reader.read(new File(path));
/* 155 */       Element root = doc.getRootElement();
/* 156 */       List<?> nodeList = root.elements();
/* 157 */       int len = nodeList.size();
/* 158 */       for (int i = 0; i < len; i++)
/*     */       {
/* 160 */         Element elem = (Element)nodeList.get(i);
/* 161 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.SGangDutyCfg"))
/*     */         {
/*     */ 
/* 164 */           SGangDutyCfg obj = new SGangDutyCfg();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 178 */     all = new java.util.HashMap();
/*     */     
/* 180 */     String path = dir + "mzm.gsp.gang.confbean.SGangDutyCfg.bny";
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
/* 195 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/* 199 */           _os_.unmarshal_int();
/*     */         }
/* 201 */         _os_.unmarshal_int();
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 205 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 207 */           SGangDutyCfg _v_ = new SGangDutyCfg();
/* 208 */           _v_.unmarshal(_os_);
/* 209 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 215 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 220 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SGangDutyCfg> all)
/*     */   {
/* 227 */     String path = dir + "mzm.gsp.gang.confbean.SGangDutyCfg.bny";
/*     */     try
/*     */     {
/* 230 */       File file = new File(path);
/* 231 */       if (file.exists())
/*     */       {
/* 233 */         byte[] bytes = new byte['Ѐ'];
/* 234 */         FileInputStream fis = new FileInputStream(file);
/* 235 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 236 */         int len = 0;
/* 237 */         while ((len = fis.read(bytes)) > 0)
/* 238 */           baos.write(bytes, 0, len);
/* 239 */         fis.close();
/* 240 */         bytes = baos.toByteArray();
/* 241 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/* 246 */           _os_.unmarshal_int();
/*     */         }
/* 248 */         _os_.unmarshal_int();
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 252 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 254 */           SGangDutyCfg _v_ = new SGangDutyCfg();
/* 255 */           _v_.unmarshal(_os_);
/* 256 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 257 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 262 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SGangDutyCfg getOld(int key)
/*     */   {
/* 275 */     return (SGangDutyCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGangDutyCfg get(int key)
/*     */   {
/* 280 */     return (SGangDutyCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangDutyCfg> getOldAll()
/*     */   {
/* 285 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangDutyCfg> getAll()
/*     */   {
/* 290 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGangDutyCfg> newAll)
/*     */   {
/* 295 */     oldAll = all;
/* 296 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 301 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\SGangDutyCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */