/*    */ package mzm.gsp.children.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class OccupationSkillBean implements Marshal
/*    */ {
/*    */   public int occupation_skill;
/*    */   public int occupation_skill_level;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.occupation_skill = Integer.valueOf(rootElement.attributeValue("occupation_skill")).intValue();
/* 15 */     this.occupation_skill_level = Integer.valueOf(rootElement.attributeValue("occupation_skill_level")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.occupation_skill);
/* 21 */     _os_.marshal(this.occupation_skill_level);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.occupation_skill = _os_.unmarshal_int();
/* 28 */     this.occupation_skill_level = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\OccupationSkillBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */