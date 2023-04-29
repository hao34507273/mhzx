/*     */ package mzm.gsp.fight.confbean;
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
/*     */ public class SFightTypeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFightTypeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFightTypeCfg> all = null;
/*     */   
/*     */   public int battleType;
/*     */   public boolean isSealLimit;
/*     */   public boolean hasNewer;
/*     */   public int n;
/*     */   public boolean isFellowSkillCost;
/*     */   public boolean synHpMpAnger;
/*     */   public int enterFightAngerMax;
/*     */   public boolean isUsePoint;
/*     */   public int petDeadLostHealth;
/*     */   public int petAliveLostHealth;
/*     */   public boolean canEscape;
/*     */   public boolean canCarryFellow;
/*     */   public int maxRound;
/*     */   public int maxDuration;
/*     */   public int passivePSid;
/*     */   public int pveFellowOutFightEffectGroupid;
/*     */   public int childDeadLostCharacter;
/*     */   public int childAliveLostCharater;
/*     */   public boolean displayHp;
/*     */   public boolean isShowCmdTip;
/*     */   public int secondSort;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  42 */     this.battleType = Integer.valueOf(rootElement.attributeValue("battleType")).intValue();
/*  43 */     this.isSealLimit = Boolean.valueOf(rootElement.attributeValue("isSealLimit")).booleanValue();
/*  44 */     this.hasNewer = Boolean.valueOf(rootElement.attributeValue("hasNewer")).booleanValue();
/*  45 */     this.n = Integer.valueOf(rootElement.attributeValue("n")).intValue();
/*  46 */     this.isFellowSkillCost = Boolean.valueOf(rootElement.attributeValue("isFellowSkillCost")).booleanValue();
/*  47 */     this.synHpMpAnger = Boolean.valueOf(rootElement.attributeValue("synHpMpAnger")).booleanValue();
/*  48 */     this.enterFightAngerMax = Integer.valueOf(rootElement.attributeValue("enterFightAngerMax")).intValue();
/*  49 */     this.isUsePoint = Boolean.valueOf(rootElement.attributeValue("isUsePoint")).booleanValue();
/*  50 */     this.petDeadLostHealth = Integer.valueOf(rootElement.attributeValue("petDeadLostHealth")).intValue();
/*  51 */     this.petAliveLostHealth = Integer.valueOf(rootElement.attributeValue("petAliveLostHealth")).intValue();
/*  52 */     this.canEscape = Boolean.valueOf(rootElement.attributeValue("canEscape")).booleanValue();
/*  53 */     this.canCarryFellow = Boolean.valueOf(rootElement.attributeValue("canCarryFellow")).booleanValue();
/*  54 */     this.maxRound = Integer.valueOf(rootElement.attributeValue("maxRound")).intValue();
/*  55 */     this.maxDuration = Integer.valueOf(rootElement.attributeValue("maxDuration")).intValue();
/*  56 */     this.passivePSid = Integer.valueOf(rootElement.attributeValue("passivePSid")).intValue();
/*  57 */     this.pveFellowOutFightEffectGroupid = Integer.valueOf(rootElement.attributeValue("pveFellowOutFightEffectGroupid")).intValue();
/*  58 */     this.childDeadLostCharacter = Integer.valueOf(rootElement.attributeValue("childDeadLostCharacter")).intValue();
/*  59 */     this.childAliveLostCharater = Integer.valueOf(rootElement.attributeValue("childAliveLostCharater")).intValue();
/*  60 */     this.displayHp = Boolean.valueOf(rootElement.attributeValue("displayHp")).booleanValue();
/*  61 */     this.isShowCmdTip = Boolean.valueOf(rootElement.attributeValue("isShowCmdTip")).booleanValue();
/*  62 */     this.secondSort = Integer.valueOf(rootElement.attributeValue("secondSort")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _os_.marshal(this.battleType);
/*  68 */     _os_.marshal(this.isSealLimit);
/*  69 */     _os_.marshal(this.hasNewer);
/*  70 */     _os_.marshal(this.n);
/*  71 */     _os_.marshal(this.isFellowSkillCost);
/*  72 */     _os_.marshal(this.synHpMpAnger);
/*  73 */     _os_.marshal(this.enterFightAngerMax);
/*  74 */     _os_.marshal(this.isUsePoint);
/*  75 */     _os_.marshal(this.petDeadLostHealth);
/*  76 */     _os_.marshal(this.petAliveLostHealth);
/*  77 */     _os_.marshal(this.canEscape);
/*  78 */     _os_.marshal(this.canCarryFellow);
/*  79 */     _os_.marshal(this.maxRound);
/*  80 */     _os_.marshal(this.maxDuration);
/*  81 */     _os_.marshal(this.passivePSid);
/*  82 */     _os_.marshal(this.pveFellowOutFightEffectGroupid);
/*  83 */     _os_.marshal(this.childDeadLostCharacter);
/*  84 */     _os_.marshal(this.childAliveLostCharater);
/*  85 */     _os_.marshal(this.displayHp);
/*  86 */     _os_.marshal(this.isShowCmdTip);
/*  87 */     _os_.marshal(this.secondSort);
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     this.battleType = _os_.unmarshal_int();
/*  94 */     this.isSealLimit = _os_.unmarshal_boolean();
/*  95 */     this.hasNewer = _os_.unmarshal_boolean();
/*  96 */     this.n = _os_.unmarshal_int();
/*  97 */     this.isFellowSkillCost = _os_.unmarshal_boolean();
/*  98 */     this.synHpMpAnger = _os_.unmarshal_boolean();
/*  99 */     this.enterFightAngerMax = _os_.unmarshal_int();
/* 100 */     this.isUsePoint = _os_.unmarshal_boolean();
/* 101 */     this.petDeadLostHealth = _os_.unmarshal_int();
/* 102 */     this.petAliveLostHealth = _os_.unmarshal_int();
/* 103 */     this.canEscape = _os_.unmarshal_boolean();
/* 104 */     this.canCarryFellow = _os_.unmarshal_boolean();
/* 105 */     this.maxRound = _os_.unmarshal_int();
/* 106 */     this.maxDuration = _os_.unmarshal_int();
/* 107 */     this.passivePSid = _os_.unmarshal_int();
/* 108 */     this.pveFellowOutFightEffectGroupid = _os_.unmarshal_int();
/* 109 */     this.childDeadLostCharacter = _os_.unmarshal_int();
/* 110 */     this.childAliveLostCharater = _os_.unmarshal_int();
/* 111 */     this.displayHp = _os_.unmarshal_boolean();
/* 112 */     this.isShowCmdTip = _os_.unmarshal_boolean();
/* 113 */     this.secondSort = _os_.unmarshal_int();
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 119 */     String path = dir + "mzm.gsp.fight.confbean.SFightTypeCfg.xml";
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
/* 132 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fight.confbean.SFightTypeCfg"))
/*     */         {
/*     */ 
/* 135 */           SFightTypeCfg obj = new SFightTypeCfg();
/* 136 */           obj.loadFromXml(elem);
/* 137 */           if (all.put(Integer.valueOf(obj.battleType), obj) != null) {
/* 138 */             throw new RuntimeException("duplicate key : " + obj.battleType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 143 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFightTypeCfg> all)
/*     */   {
/* 149 */     String path = dir + "mzm.gsp.fight.confbean.SFightTypeCfg.xml";
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
/* 161 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fight.confbean.SFightTypeCfg"))
/*     */         {
/*     */ 
/* 164 */           SFightTypeCfg obj = new SFightTypeCfg();
/* 165 */           obj.loadFromXml(elem);
/* 166 */           if (all.put(Integer.valueOf(obj.battleType), obj) != null) {
/* 167 */             throw new RuntimeException("duplicate key : " + obj.battleType);
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
/* 180 */     String path = dir + "mzm.gsp.fight.confbean.SFightTypeCfg.bny";
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
/* 207 */           SFightTypeCfg _v_ = new SFightTypeCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SFightTypeCfg> all)
/*     */   {
/* 227 */     String path = dir + "mzm.gsp.fight.confbean.SFightTypeCfg.bny";
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
/* 254 */           SFightTypeCfg _v_ = new SFightTypeCfg();
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
/*     */   public static SFightTypeCfg getOld(int key)
/*     */   {
/* 275 */     return (SFightTypeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFightTypeCfg get(int key)
/*     */   {
/* 280 */     return (SFightTypeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFightTypeCfg> getOldAll()
/*     */   {
/* 285 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFightTypeCfg> getAll()
/*     */   {
/* 290 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFightTypeCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\confbean\SFightTypeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */