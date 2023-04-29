/*     */ package mzm.gsp.drawandguess.confbean;
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
/*     */ public class SDrawAndGuessActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SDrawAndGuessActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SDrawAndGuessActivityCfg> all = null;
/*     */   
/*     */   public int activityCfgid;
/*     */   public int openCfgid;
/*     */   public int npcCfgid;
/*     */   public int npcServiceCfgid;
/*     */   public int minTeamMember;
/*     */   public int maxTeamMember;
/*     */   public int maxRewardTimes;
/*  25 */   public java.util.ArrayList<Integer> awardCfgidList = new java.util.ArrayList();
/*     */   public int jifenLibId;
/*     */   public int ruleId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.activityCfgid = Integer.valueOf(rootElement.attributeValue("activityCfgid")).intValue();
/*  32 */     this.openCfgid = Integer.valueOf(rootElement.attributeValue("openCfgid")).intValue();
/*  33 */     this.npcCfgid = Integer.valueOf(rootElement.attributeValue("npcCfgid")).intValue();
/*  34 */     this.npcServiceCfgid = Integer.valueOf(rootElement.attributeValue("npcServiceCfgid")).intValue();
/*  35 */     this.minTeamMember = Integer.valueOf(rootElement.attributeValue("minTeamMember")).intValue();
/*  36 */     this.maxTeamMember = Integer.valueOf(rootElement.attributeValue("maxTeamMember")).intValue();
/*  37 */     this.maxRewardTimes = Integer.valueOf(rootElement.attributeValue("maxRewardTimes")).intValue();
/*     */     
/*  39 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "awardCfgidList");
/*  40 */     if (collectionElement == null)
/*     */     {
/*  42 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  45 */     List<?> _nodeList = collectionElement.elements();
/*  46 */     int _len = _nodeList.size();
/*  47 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  49 */       Element elem = (Element)_nodeList.get(i);
/*  50 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  57 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  64 */         this.awardCfgidList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  67 */     this.jifenLibId = Integer.valueOf(rootElement.attributeValue("jifenLibId")).intValue();
/*  68 */     this.ruleId = Integer.valueOf(rootElement.attributeValue("ruleId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  73 */     _os_.marshal(this.activityCfgid);
/*  74 */     _os_.marshal(this.openCfgid);
/*  75 */     _os_.marshal(this.npcCfgid);
/*  76 */     _os_.marshal(this.npcServiceCfgid);
/*  77 */     _os_.marshal(this.minTeamMember);
/*  78 */     _os_.marshal(this.maxTeamMember);
/*  79 */     _os_.marshal(this.maxRewardTimes);
/*  80 */     _os_.compact_uint32(this.awardCfgidList.size());
/*  81 */     for (Integer _v_ : this.awardCfgidList)
/*     */     {
/*  83 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  85 */     _os_.marshal(this.jifenLibId);
/*  86 */     _os_.marshal(this.ruleId);
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     this.activityCfgid = _os_.unmarshal_int();
/*  93 */     this.openCfgid = _os_.unmarshal_int();
/*  94 */     this.npcCfgid = _os_.unmarshal_int();
/*  95 */     this.npcServiceCfgid = _os_.unmarshal_int();
/*  96 */     this.minTeamMember = _os_.unmarshal_int();
/*  97 */     this.maxTeamMember = _os_.unmarshal_int();
/*  98 */     this.maxRewardTimes = _os_.unmarshal_int();
/*  99 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 102 */       int _v_ = _os_.unmarshal_int();
/* 103 */       this.awardCfgidList.add(Integer.valueOf(_v_));
/*     */     }
/* 105 */     this.jifenLibId = _os_.unmarshal_int();
/* 106 */     this.ruleId = _os_.unmarshal_int();
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 112 */     String path = dir + "mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 116 */       all = new java.util.HashMap();
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg"))
/*     */         {
/*     */ 
/* 128 */           SDrawAndGuessActivityCfg obj = new SDrawAndGuessActivityCfg();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.activityCfgid), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.activityCfgid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SDrawAndGuessActivityCfg> all)
/*     */   {
/* 142 */     String path = dir + "mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 146 */       SAXReader reader = new SAXReader();
/* 147 */       org.dom4j.Document doc = reader.read(new File(path));
/* 148 */       Element root = doc.getRootElement();
/* 149 */       List<?> nodeList = root.elements();
/* 150 */       int len = nodeList.size();
/* 151 */       for (int i = 0; i < len; i++)
/*     */       {
/* 153 */         Element elem = (Element)nodeList.get(i);
/* 154 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg"))
/*     */         {
/*     */ 
/* 157 */           SDrawAndGuessActivityCfg obj = new SDrawAndGuessActivityCfg();
/* 158 */           obj.loadFromXml(elem);
/* 159 */           if (all.put(Integer.valueOf(obj.activityCfgid), obj) != null) {
/* 160 */             throw new RuntimeException("duplicate key : " + obj.activityCfgid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 165 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 171 */     all = new java.util.HashMap();
/*     */     
/* 173 */     String path = dir + "mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg.bny";
/*     */     try
/*     */     {
/* 176 */       File file = new File(path);
/* 177 */       if (file.exists())
/*     */       {
/* 179 */         byte[] bytes = new byte['Ѐ'];
/* 180 */         FileInputStream fis = new FileInputStream(file);
/* 181 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 182 */         int len = 0;
/* 183 */         while ((len = fis.read(bytes)) > 0)
/* 184 */           baos.write(bytes, 0, len);
/* 185 */         fis.close();
/* 186 */         bytes = baos.toByteArray();
/* 187 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 188 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 190 */           _os_.unmarshal_int();
/* 191 */           _os_.unmarshal_int();
/* 192 */           _os_.unmarshal_int();
/*     */         }
/* 194 */         _os_.unmarshal_int();
/* 195 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 198 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 200 */           SDrawAndGuessActivityCfg _v_ = new SDrawAndGuessActivityCfg();
/* 201 */           _v_.unmarshal(_os_);
/* 202 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 203 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 208 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SDrawAndGuessActivityCfg> all)
/*     */   {
/* 220 */     String path = dir + "mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg.bny";
/*     */     try
/*     */     {
/* 223 */       File file = new File(path);
/* 224 */       if (file.exists())
/*     */       {
/* 226 */         byte[] bytes = new byte['Ѐ'];
/* 227 */         FileInputStream fis = new FileInputStream(file);
/* 228 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 229 */         int len = 0;
/* 230 */         while ((len = fis.read(bytes)) > 0)
/* 231 */           baos.write(bytes, 0, len);
/* 232 */         fis.close();
/* 233 */         bytes = baos.toByteArray();
/* 234 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 235 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 237 */           _os_.unmarshal_int();
/* 238 */           _os_.unmarshal_int();
/* 239 */           _os_.unmarshal_int();
/*     */         }
/* 241 */         _os_.unmarshal_int();
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 245 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 247 */           SDrawAndGuessActivityCfg _v_ = new SDrawAndGuessActivityCfg();
/* 248 */           _v_.unmarshal(_os_);
/* 249 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 250 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 255 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 260 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SDrawAndGuessActivityCfg getOld(int key)
/*     */   {
/* 268 */     return (SDrawAndGuessActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SDrawAndGuessActivityCfg get(int key)
/*     */   {
/* 273 */     return (SDrawAndGuessActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDrawAndGuessActivityCfg> getOldAll()
/*     */   {
/* 278 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDrawAndGuessActivityCfg> getAll()
/*     */   {
/* 283 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SDrawAndGuessActivityCfg> newAll)
/*     */   {
/* 288 */     oldAll = all;
/* 289 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 294 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\confbean\SDrawAndGuessActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */