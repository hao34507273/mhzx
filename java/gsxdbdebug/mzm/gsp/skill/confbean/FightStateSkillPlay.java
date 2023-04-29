/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FightStateSkillPlay implements Marshal
/*    */ {
/*    */   public int finalSkillPlayid;
/*    */   public int fightStateGroupId;
/*    */   public int fightState;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.finalSkillPlayid = Integer.valueOf(rootElement.attributeValue("finalSkillPlayid")).intValue();
/* 16 */     this.fightStateGroupId = Integer.valueOf(rootElement.attributeValue("fightStateGroupId")).intValue();
/* 17 */     this.fightState = Integer.valueOf(rootElement.attributeValue("fightState")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.finalSkillPlayid);
/* 23 */     _os_.marshal(this.fightStateGroupId);
/* 24 */     _os_.marshal(this.fightState);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.finalSkillPlayid = _os_.unmarshal_int();
/* 31 */     this.fightStateGroupId = _os_.unmarshal_int();
/* 32 */     this.fightState = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\FightStateSkillPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */