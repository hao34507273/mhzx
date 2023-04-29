/*    */ package mzm.gsp.gang.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SGangMiFangToolsCfgInfo implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int yaoDianLevel;
/*    */   public int mustItemSiftId;
/*    */   public int otherItemSiftId;
/*    */   public int generLifeSkillId;
/*    */   public int successRate;
/*    */   public int weight;
/*    */   public int lowTime;
/*    */   public int maxTime;
/*    */   public int lowPersistTimeM;
/*    */   public int hightPersistTimeM;
/*    */   public int needBangGong;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 25 */     this.yaoDianLevel = Integer.valueOf(rootElement.attributeValue("yaoDianLevel")).intValue();
/* 26 */     this.mustItemSiftId = Integer.valueOf(rootElement.attributeValue("mustItemSiftId")).intValue();
/* 27 */     this.otherItemSiftId = Integer.valueOf(rootElement.attributeValue("otherItemSiftId")).intValue();
/* 28 */     this.generLifeSkillId = Integer.valueOf(rootElement.attributeValue("generLifeSkillId")).intValue();
/* 29 */     this.successRate = Integer.valueOf(rootElement.attributeValue("successRate")).intValue();
/* 30 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/* 31 */     this.lowTime = Integer.valueOf(rootElement.attributeValue("lowTime")).intValue();
/* 32 */     this.maxTime = Integer.valueOf(rootElement.attributeValue("maxTime")).intValue();
/* 33 */     this.lowPersistTimeM = Integer.valueOf(rootElement.attributeValue("lowPersistTimeM")).intValue();
/* 34 */     this.hightPersistTimeM = Integer.valueOf(rootElement.attributeValue("hightPersistTimeM")).intValue();
/* 35 */     this.needBangGong = Integer.valueOf(rootElement.attributeValue("needBangGong")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 40 */     _os_.marshal(this.id);
/* 41 */     _os_.marshal(this.yaoDianLevel);
/* 42 */     _os_.marshal(this.mustItemSiftId);
/* 43 */     _os_.marshal(this.otherItemSiftId);
/* 44 */     _os_.marshal(this.generLifeSkillId);
/* 45 */     _os_.marshal(this.successRate);
/* 46 */     _os_.marshal(this.weight);
/* 47 */     _os_.marshal(this.lowTime);
/* 48 */     _os_.marshal(this.maxTime);
/* 49 */     _os_.marshal(this.lowPersistTimeM);
/* 50 */     _os_.marshal(this.hightPersistTimeM);
/* 51 */     _os_.marshal(this.needBangGong);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 57 */     this.id = _os_.unmarshal_int();
/* 58 */     this.yaoDianLevel = _os_.unmarshal_int();
/* 59 */     this.mustItemSiftId = _os_.unmarshal_int();
/* 60 */     this.otherItemSiftId = _os_.unmarshal_int();
/* 61 */     this.generLifeSkillId = _os_.unmarshal_int();
/* 62 */     this.successRate = _os_.unmarshal_int();
/* 63 */     this.weight = _os_.unmarshal_int();
/* 64 */     this.lowTime = _os_.unmarshal_int();
/* 65 */     this.maxTime = _os_.unmarshal_int();
/* 66 */     this.lowPersistTimeM = _os_.unmarshal_int();
/* 67 */     this.hightPersistTimeM = _os_.unmarshal_int();
/* 68 */     this.needBangGong = _os_.unmarshal_int();
/* 69 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\SGangMiFangToolsCfgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */