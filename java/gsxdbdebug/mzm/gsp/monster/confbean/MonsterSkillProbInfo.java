/*    */ package mzm.gsp.monster.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MonsterSkillProbInfo implements Marshal
/*    */ {
/*    */   public int monsterSkillId;
/*    */   public int monsterSkillProb;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.monsterSkillId = Integer.valueOf(rootElement.attributeValue("monsterSkillId")).intValue();
/* 15 */     this.monsterSkillProb = Integer.valueOf(rootElement.attributeValue("monsterSkillProb")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.monsterSkillId);
/* 21 */     _os_.marshal(this.monsterSkillProb);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.monsterSkillId = _os_.unmarshal_int();
/* 28 */     this.monsterSkillProb = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\confbean\MonsterSkillProbInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */