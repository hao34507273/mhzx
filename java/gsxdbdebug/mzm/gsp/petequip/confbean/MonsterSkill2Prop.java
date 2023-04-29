/*    */ package mzm.gsp.petequip.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MonsterSkill2Prop implements Marshal
/*    */ {
/*    */   public int monsterSkillId;
/*    */   public int monsterSkillProb;
/*    */   public int monster2SkillId;
/*    */   public int monster2SkillProb;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.monsterSkillId = Integer.valueOf(rootElement.attributeValue("monsterSkillId")).intValue();
/* 17 */     this.monsterSkillProb = Integer.valueOf(rootElement.attributeValue("monsterSkillProb")).intValue();
/* 18 */     this.monster2SkillId = Integer.valueOf(rootElement.attributeValue("monster2SkillId")).intValue();
/* 19 */     this.monster2SkillProb = Integer.valueOf(rootElement.attributeValue("monster2SkillProb")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.monsterSkillId);
/* 25 */     _os_.marshal(this.monsterSkillProb);
/* 26 */     _os_.marshal(this.monster2SkillId);
/* 27 */     _os_.marshal(this.monster2SkillProb);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.monsterSkillId = _os_.unmarshal_int();
/* 34 */     this.monsterSkillProb = _os_.unmarshal_int();
/* 35 */     this.monster2SkillId = _os_.unmarshal_int();
/* 36 */     this.monster2SkillProb = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petequip\confbean\MonsterSkill2Prop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */