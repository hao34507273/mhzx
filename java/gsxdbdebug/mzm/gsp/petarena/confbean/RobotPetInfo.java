/*    */ package mzm.gsp.petarena.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RobotPetInfo implements Marshal
/*    */ {
/*    */   public int monsterCfgid;
/*    */   public int petFightModelRatio;
/*    */   public int petScore;
/*    */   public int petYaoLiLevel;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.monsterCfgid = Integer.valueOf(rootElement.attributeValue("monsterCfgid")).intValue();
/* 17 */     this.petFightModelRatio = Integer.valueOf(rootElement.attributeValue("petFightModelRatio")).intValue();
/* 18 */     this.petScore = Integer.valueOf(rootElement.attributeValue("petScore")).intValue();
/* 19 */     this.petYaoLiLevel = Integer.valueOf(rootElement.attributeValue("petYaoLiLevel")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.monsterCfgid);
/* 25 */     _os_.marshal(this.petFightModelRatio);
/* 26 */     _os_.marshal(this.petScore);
/* 27 */     _os_.marshal(this.petYaoLiLevel);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.monsterCfgid = _os_.unmarshal_int();
/* 34 */     this.petFightModelRatio = _os_.unmarshal_int();
/* 35 */     this.petScore = _os_.unmarshal_int();
/* 36 */     this.petYaoLiLevel = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\confbean\RobotPetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */