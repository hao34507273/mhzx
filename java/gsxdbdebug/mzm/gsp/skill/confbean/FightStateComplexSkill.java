/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FightStateComplexSkill implements Marshal
/*    */ {
/*    */   public int fightStateGroupId;
/*    */   public int fightState;
/*    */   public int skillid;
/*    */   public int modId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.fightStateGroupId = Integer.valueOf(rootElement.attributeValue("fightStateGroupId")).intValue();
/* 17 */     this.fightState = Integer.valueOf(rootElement.attributeValue("fightState")).intValue();
/* 18 */     this.skillid = Integer.valueOf(rootElement.attributeValue("skillid")).intValue();
/* 19 */     this.modId = Integer.valueOf(rootElement.attributeValue("modId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.fightStateGroupId);
/* 25 */     _os_.marshal(this.fightState);
/* 26 */     _os_.marshal(this.skillid);
/* 27 */     _os_.marshal(this.modId);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.fightStateGroupId = _os_.unmarshal_int();
/* 34 */     this.fightState = _os_.unmarshal_int();
/* 35 */     this.skillid = _os_.unmarshal_int();
/* 36 */     this.modId = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\FightStateComplexSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */