/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STXiuLianSkillBagLevelUpCfgInfo implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int skillbaglevel;
/*    */   public int needRoleLevel;
/*    */   public int needExp;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 17 */     this.skillbaglevel = Integer.valueOf(rootElement.attributeValue("skillbaglevel")).intValue();
/* 18 */     this.needRoleLevel = Integer.valueOf(rootElement.attributeValue("needRoleLevel")).intValue();
/* 19 */     this.needExp = Integer.valueOf(rootElement.attributeValue("needExp")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.id);
/* 25 */     _os_.marshal(this.skillbaglevel);
/* 26 */     _os_.marshal(this.needRoleLevel);
/* 27 */     _os_.marshal(this.needExp);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.id = _os_.unmarshal_int();
/* 34 */     this.skillbaglevel = _os_.unmarshal_int();
/* 35 */     this.needRoleLevel = _os_.unmarshal_int();
/* 36 */     this.needExp = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\STXiuLianSkillBagLevelUpCfgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */